package vaulsys.scheduler.job;

import vaulsys.calendar.DateTime;
import vaulsys.clearing.ClearingService;
import vaulsys.clearing.base.ClearingProfile;
import vaulsys.clearing.settlement.SettlementService;
import vaulsys.job.AbstractSwitchJob;
import vaulsys.job.SwitchJobStatus;
import vaulsys.persistence.GeneralDao;
import vaulsys.scheduler.JobLog;
import vaulsys.wfe.GlobalContext;
import vaulsys.wfe.ProcessContext;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.apache.log4j.Logger;
import org.hibernate.annotations.ForeignKey;
import org.quartz.JobExecutionContext;

@Entity
@DiscriminatorValue(value = "Cycle_Settlement")
public abstract class CycleSettlementJob extends AbstractSwitchJob {
    protected static final Logger logger = Logger.getLogger(CycleSettlementJob.class);

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "clr_prof")
    @ForeignKey(name="cycle_stl_job_clrprof_fk")
    private ClearingProfile clearingProfile;
    
    public ClearingProfile getClearingProfile()
	{
		return clearingProfile;
	}
    
	public void setClearingProfile(ClearingProfile clearingProfile)
	{
		this.clearingProfile = clearingProfile;
	}
	
    public void execute(JobExecutionContext switchJobContext, JobLog log) {
    	try {
			logger.debug("SCHEDULER Generating settle file on cycling-time.");
			ClearingProfile clearingProfile =null;
			DateTime now = null;
			DateTime settleUntilTime = null;

			GeneralDao.Instance.beginTransaction();
			GlobalContext.getInstance().setAllInstitutions();
			GlobalContext.getInstance().getAllFeeProfiles();
			ProcessContext.get().init();
			
			try{
				now = DateTime.now();
				Long id = (Long) switchJobContext.getJobDetail().getJobDataMap().get("ClrProfile");
				clearingProfile = ClearingService.findClearingProfile(id);
				settleUntilTime = clearingProfile.getSettleUntilTime(now);
				GeneralDao.Instance.endTransaction();
			}catch(Exception e){
				logger.error(e);
				log.setStatus(SwitchJobStatus.FAILED);
				log.setExceptionMessage(e.getMessage());
				GeneralDao.Instance.rollback();
				GeneralDao.Instance.close();
				return;
			}
			
			getSettlementService().settle(clearingProfile, settleUntilTime, false, true, true);
			logger.debug("Settle file generated by SCHEDULER on cycling-time.");
			log.setStatus(SwitchJobStatus.FINISHED);
		} catch (Exception e) {
			log.setStatus(SwitchJobStatus.FAILED);
			log.setExceptionMessage(e.getMessage());
			logger.error("Exception in CycleSettlementJob!!! " + e);
		}finally{
			GeneralDao.Instance.close();
		}
    }

    public void interrupt() {
    }

    public void updateExecutionInfo() {
    }

    abstract public SettlementService getSettlementService();
}