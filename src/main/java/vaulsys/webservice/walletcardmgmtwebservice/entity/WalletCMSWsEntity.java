package vaulsys.webservice.walletcardmgmtwebservice.entity;


import com.owlike.genson.annotation.JsonIgnore;
import vaulsys.persistence.IEntity;
import vaulsys.webservice.walletcardmgmtwebservice.model.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.ForeignKey;
import org.hibernate.annotations.Index;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * Created by RAZA MURTAZA BAIG on 1/27/2018.
 */
@XmlRootElement
@Entity
//TODO: please revert the following
//@Table(name = "WS_LOG")
@Table(name = "WSLOG")
public class WalletCMSWsEntity implements IEntity<Long>, Cloneable {

    @Id
    @GeneratedValue(generator="TXN_WSLOG_SEQ-gen")
    @org.hibernate.annotations.GenericGenerator(name = "TXN_WSLOG_SEQ-gen", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "optimizer", value = "pooled"),
                    @org.hibernate.annotations.Parameter(name = "increment_size", value = "1"),
                    @org.hibernate.annotations.Parameter(name = "sequence_name", value = "TXNWSLOG_SEQ")
            })
    private Long id;

    @Column(name = "SERVICENAME")
    private String servicename;

//    @Column(name = "NAYAPAYID") //Raza removing from V1.8
//    private String nayapayid;

    @Column(name = "MOBILENUMBER")
    private String mobilenumber;

    @Column(name = "CNIC")
    private String cnic;

    @Column(name = "CUSTOMERNAME")
    private String customername;

    @Column(name = "CNICEXPIRY")
    private String cnicexpiry;

    @Column(name = "BANKCODE")
    private String bankcode;

    //m.rehman: 08-12-2021, Nayapay Optimization
    //@Column(name = "DESTBANKCODE")
    @Transient
    private String destbankcode;

    @Column(name = "BANKNAME")
    private String bankname;

    @Column(name = "ACCOUNTNUMBER")
    private String accountnumber;

    @Column(name = "ACCOUNTCURRENCY")
    private String accountcurrency;

    @Column(name = "TXNREFNUM")
    private String tranrefnumber;

    @Column(name = "MOTHERNAME")
    private String mothername;

    @Column(name = "DATEOFBIRTH")
    private String dateofbirth;

    @Column(name = "TRANSDATETIME")
    private String transdatetime;

    //@Column(name = "PINDATA")
    @Transient
    private String pindata;

    //@Column(name = "OLDPINDATA")
    @Transient
    private String oldpindata;

    //@Column(name = "NEWPINDATA")
    @Transient
    private String newpindata;

    //m.rehman: 08-12-2021, Nayapay Optimization
    //@Column(name = "ENCRYPTEDKEY")
    @Transient
    private String encryptkey;

    @Column(name = "AMOUNTTRAN")
    private String amounttransaction;

    @Column(name = "SRCAMOUNTCHARGE")
    private String srcchargeamount;

    @Column(name = "DESTAMOUNTCHARGE")
    private String destchargeamount;

    @Column(name = "DESTACCOUNT")
    private String destaccount;

    //m.rehman: 08-12-2021, Nayapay Optimization
    //@Column(name = "DESTACCOUNTCURRENCY")
    @Transient
    private String destaccountcurrency;

    //m.rehman: 08-12-2021, Nayapay Optimization
    //@Column(name = "OTP")
    @Transient
    private String otp;

    @Transient
    private String biometricdata;

    @Transient
    private List<Transaction> tranlist;

    @Column(name = "RESPCODE")
    private String respcode;

    @Column(name = "PLACEOFBIRTH")
    private String placeofbirth;

    @Column(name = "FATHERNAME")
    private String fathername;

    @Column(name = "PROVINCE")
    private String province;

    //m.rehman: 08-12-2021, Nayapay Optimization
    //@Column(name = "TELECOMSP")
    @Transient
    private String tsp; //telecommunication service provider (required for OTP by banks)

    @Column(name = "DESTNAYAPAYID")
    private String destnayapayid;

    @Column(name = "ORIG_DATA_ELEMENT")
    private String origdataelement;

    //m.rehman: 08-12-2021, Nayapay Optimization
    //@Column(name = "ATMID")
    @Transient
    private String atmid;

    //m.rehman: 08-12-2021, Nayapay Optimization
    //@Column(name = "COREBANKCODE")
    @Transient
    private String corebankcode;

    //m.rehman: 08-12-2021, Nayapay Optimization
    //@Column(name = "COREACCOUNT")
    @Transient
    private String coreaccount;

    //m.rehman: 08-12-2021, Nayapay Optimization
    //@Column(name = "COREACCOUNTCURRENCY")
    @Transient
    private String coreaccountcurrency;

    @Column(name = "CARDNUMBER")
    private String cardnumber;

    //@Column(name = "CARDPINDATA")
    @Transient
    private String cardpindata;

    //m.rehman: 08-12-2021, Nayapay Optimization
    //@Column(name = "ENABLEFLAG")
    @Transient
    private String enableflag;

    @Column(name = "MERCHANTID")
    private String merchantid;

    @Column(name = "DAILYLIMIT")
    private String dailylimit;

    @Column(name = "MONTHLYLIMIT")
    private String monthlylimit;

    @Column(name = "YEARLYLIMIT")
    private String yearlylimit;

    //m.rehman: 08-12-2021, Nayapay Optimization
    //@Column(name = "STATUS")
    @Transient
    private String status;

    @Column(name = "STAN")
    private String stan;

    @Column(name = "RRN")
    private String rrn;

    @Column(name = "USERID")
    private String userid;

    @Column(name = "CHANNELID")
    private String channelid;

    //m.rehman: 08-12-2021, Nayapay Optimization
    //@Column(name = "ALLOWED")
    @Transient
    private String allowed;

    //m.rehman: 08-12-2021, Nayapay Optimization
    //@Column(name = "DELETETYPE")
    @Transient
    private String deletetype;

    //m.rehman: 08-12-2021, Nayapay Optimization
    //@Column(name = "COMMENTS")
    @Transient
    private String comments;

    @Column(name = "ACCTID")
    private String acctid;

    @Column(name = "ACCT_ALIAS")
    private String acctalias;

    //m.rehman: 08-12-2021, Nayapay Optimization
    //@Column(name = "ISPRIMARY")
    @Transient
    private String isprimary;

    @Column(name = "ACCTBALANCE")
    private String acctbalance;

    //m.rehman: 08-12-2021, Nayapay Optimization
    //@Column(name = "ACCTLIMIT")
    @Transient
    private String acctlimit;

    //m.rehman: 08-12-2021, Nayapay Optimization
    //@Column(name = "AVAILLIMIT")
    @Transient
    private String availlimit;

    //m.rehman: 08-12-2021, Nayapay Optimization
    //@Column(name = "AVAILLIMITFREQ")
    @Transient
    private String availlimitfreq;

    //m.rehman: 08-12-2021, Nayapay Optimization
    //@Column(name = "STATE")
    @Transient
    private String state;

    //m.rehman: 08-12-2021, Nayapay Optimization
    //@Column(name = "REQUESTTIME")
    @Transient
    private String requesttime;

    //m.rehman: 08-12-2021, Nayapay Optimization
    //@Column(name = "ACTIVATIONTIME")
    @Transient
    private String activationtime;

    @Column(name = "NAYAPAYCHARGES")
    private String nayapaycharges;

    @Column(name = "DESTUSERID")
    private String destuserid;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "CITY")
    private String city;

    @Column(name = "COUNTRY")
    private String country;

    //m.rehman: 08-12-2021, Nayapay Optimization
    //@Column(name = "ADVANCEFLAG")
    @Transient
    private String advanceflag;

    //m.rehman: 08-12-2021, Nayapay Optimization
    //@Column(name = "SECONDARYNUMBER")
    @Transient
    private String secondarynumber;

    @Column(name = "USERTOKEN")
    private String accesstoken;

    //m.rehman: 08-12-2021, Nayapay Optimization
    //@Column(name = "INOUTFILTER")
    @Transient
    private String inoutfilter;

    // Asim Shahzad, Date : 17th March 2021, Tracking ID : VP-NAP-202103115 / VC-NAP-202103115
    //@Column(name = "TYPEFILTER")
    //private String typefilter;
    @Transient
    private List<String> typefilter;
    // =======================================================================================

    //m.rehman: 08-12-2021, Nayapay Optimization
    //@Column(name = "SEARCHTEXT")
    @Transient
    private String searchtext;

    @Column(name = "USERNAME")
    private String username;

    @Column(name = "NAYAPAYID")
    private String nayapayid;

    //m.rehman: Parent merchant ID
    @Column(name = "PARENTID")
    private String parentid;

    //m.rehman: Merchant name
    @Column(name = "MERCHANTNAME")
    private String merchantname;

    //m.rehman: Merchant category ID
    @Column(name = "MERCHANTCATEGORYID")
    private String categoryid;

    //m.rehman: Trusted flag for linked account transactions (true/false)
    //m.rehman: 08-12-2021, Nayapay Optimization
    //@Column(name = "TRUSTEDFLAG")
    @Transient
    private String trustedflag;

    //m.rehman: Merchant phone number
    @Column(name = "PHONENUMBER")
    private String phonenumber;

    //m.rehman: Merchant transaction limit
    //m.rehman: 08-12-2021, Nayapay Optimization
    //@Column(name = "TRANSACTIONLIMIT")
    @Transient
    private String transactionlimit;

    //m.rehman: Merchant category name
    //m.rehman: 08-12-2021, Nayapay Optimization
    //@Column(name = "CATEGORYNAME")
    @Transient
    private String categoryname;

    //m.rehman: 08-12-2021, Nayapay Optimization
    //@Column(name = "MERCHANTSTATE")
    @Transient
    private String merchantstate;

    //m.rehman: 08-12-2021, Nayapay Optimization
    //@Column(name = "MERCHANTENABLED")
    @Transient
    private String merchantenabled;

    //m.rehman: 08-12-2021, Nayapay Optimization
    //@Column(name = "MERCHANTBLOCKED")
    @Transient
    private String merchantblocked;

    //m.rehman: 08-12-2021, Nayapay Optimization
    //@Column(name = "MINIMUMAMOUNT")
    @Transient
    private String minimumamount;

    //m.rehman: 08-12-2021, Nayapay Optimization
    //@Column(name = "MAXIMUMAMOUNT")
    @Transient
    private String maximumamount;

    //m.rehman: 08-12-2021, Nayapay Optimization
    //@Column(name = "SOURCECHARGETYPE")
    @Transient
    private String sourcechargetype;

    //m.rehman: 08-12-2021, Nayapay Optimization
    //@Column(name = "DESTINATIONCHARGPE")
    @Transient
    private String destinationchargetype;

    @Column(name = "CONSUMERNO")
    private String consumerno;

    @Column(name = "UTILCOMPANYID")
    private String utilcompanyid;

    //m.rehman: 08-12-2021, Nayapay Optimization
    //@Column(name = "CONSUMERDETAIL")
    @Transient
    private String consumerdetail;

    //m.rehman: 08-12-2021, Nayapay Optimization
    //@Column(name = "BILLSTATUS")
    @Transient
    private String billstatus;

    //m.rehman: 08-12-2021, Nayapay Optimization
    //@Column(name = "DUEDATE")
    @Transient
    private String duedate;

    //m.rehman: 08-12-2021, Nayapay Optimization
    //@Column(name = "AMTWITHINDUEDATE")
    @Transient
    private String amtwithinduedate;

    //m.rehman: 08-12-2021, Nayapay Optimization
    //@Column(name = "AMTAFTERDUEDATE")
    @Transient
    private String amtafterduedate;

    //m.rehman: 08-12-2021, Nayapay Optimization
    //@Column(name = "BILLINGMONTH")
    @Transient
    private String billingmonth;

    //m.rehman: 08-12-2021, Nayapay Optimization
    //@Column(name = "DATEPAID")
    @Transient
    private String datepaid;

    //m.rehman: 08-12-2021, Nayapay Optimization
    //@Column(name = "AMOUNTPAID")
    @Transient
    private String amtpaid;

    @Column(name = "TRANAUTHID")
    private String tranauthid;

    @Column(name = "RESERVED")
    private String reserved;

    //m.rehman: 08-12-2021, Nayapay Optimization
    //@Column(name = "IDENTIFICATIONNO")
    @Transient
    private String identificationno;

    //m.rehman: 08-12-2021, Nayapay Optimization
    //@Column(name = "PING")
    @Transient
    private String ping;

    @Column(name = "NAYAPAYTRANTYPE")
    private String nayapaytrantype;

    @Column(name = "DESTUSERNAME")
    private String destusername;

    @Column(name = "AGENTID")
    private String agentid;

    @Column(name = "REFERENCENUMBER")
    private String referencenumber;

    @Column(name = "INVOICEID")
    private String invoiceid;

    //m.rehman: 08-12-2021, Nayapay Optimization
    //@Column(name = "VERIFIEDFLAG")
    @Transient
    private String verifiedflag;

    //m.rehman: 08-12-2021, Nayapay Optimization
    //@Column(name = "STARTDATE")
    @Transient
    private String startdate;

    //m.rehman: 08-12-2021, Nayapay Optimization
    //@Column(name = "ENDDATE")
    @Transient
    private String enddate;

    //m.rehman: 08-12-2021, Nayapay Optimization
    //@Column(name = "BANKTXNFLAG")
    @Transient
    private String banktxnflag;

    //m.rehman: 08-12-2021, Nayapay Optimization
    //@Column(name = "BLOCKEDFLAG")
    @Transient
    private String blockedflag;

    //m.rehman: 08-12-2021, Nayapay Optimization
    //@Column(name = "NAYAPAYTXNID")
    @Transient
    private String nayapaytxnid;

    //m.rehman: 08-12-2021, Nayapay Optimization
    //@Column(name = "CREATIONDATE")
    @Transient
    private String creationdate;

    //m.rehman: 08-12-2021, Nayapay Optimization
    //@Column(name = "BANK_MNEMONIC") //Raza Adding for OneLink Biller in-case if it is required, currently for logging only
    @Transient
    private String bankmnemonic;

    //m.rehman: for NayaPay, adding more fields
    @Column(name = "TOTALAMOUNT")
    private String totalamount;

    @Column(name = "BANKCHARGES")
    private String bankcharges;

    @Column(name = "BANKTAXAMOUNT")
    private String banktaxamount;

    @Column(name = "NAYAPAYTAXAMOUNT")
    private String nayapaytaxamount;

    @Column(name = "DEPOSITAMOUNT")
    private String depositamount;

    @Column(name = "SECRET_QUESTION_1")
    private String secretquestion1;

    //m.rehman: 08-12-2021, Nayapay Optimization
    //@Column(name = "SECRET_QUET_ANS_1")
    @Transient
    private String secretquestionanswer1;

    @Column(name = "SECRET_QUESTION_2")
    private String secretquestion2;

    //m.rehman: 08-12-2021, Nayapay Optimization
    //@Column(name = "SECRET_QUET_ANS_2")
    @Transient
    private String secretquestionanswer2;

    @Transient
    private List<NayaPayLimit> nayapaylimits;

    @Transient
    private List<NayaPayLinkedAccount> linkedaccounts;

    @Transient
    private List<ProvisionalWallet> provisionalwallets;

    @Transient
    private List<NayaPayAccount> accountlist;

    @Transient
    private List<Transaction> transactions;

    @Transient
    private List<UserTransaction> usertransactions;

    //m.rehman: for NayaPay
    @Transient
    private TransactionDetail transactionDetail;

    //Raza adding 02072019
    @Transient
    private List<TransactionDetail> reversal;

    @Transient
    private String currency; //Raza using for GetWallet

    @Transient
    @JsonIgnore
    private String bank;

    @Transient
    @JsonIgnore
    private String destbank;

    @Transient
    @JsonIgnore
    private String corebank;

    @Transient
    @JsonIgnore
    private String destcurrency;

    @Transient
    @JsonIgnore
    private String corecurrency;


    //Raza adding for OTC start
    @Column(name = "ACQBIN")
    private String acqbin;

    @Column(name = "BRANCHCODE")
    private String branchcode;

    @Column(name = "BRANCHNAME")
    private String branchname;

    @Column(name = "SLIPNUMBER")
    private String slipnumber;

    @Column(name = "TELLERID")
    private String tellerid;
    //Raza adding for OTC end

	//m.rehman: 08-12-2021, Nayapay Optimization
	//@ManyToOne(fetch = FetchType.LAZY)
    //@JoinColumn(name = "SECURITY_PARAMS")
    //@Cascade(value = org.hibernate.annotations.CascadeType.ALL )
    //@ForeignKey(name="WSLOG_SECURPARAM_FK")
    //@Index(name="idx_WSLOG_SECURPARAM_FK")
	@Transient
    private SecurityParams securityparams;

    //m.rehman: 08-12-2021, Nayapay Optimization
    //@Column(name = "CODFLAG")
    @Transient
    private String codflag;

    //m.rehman: for NayaPay, adding new fields for document 2.0 <start>
    //m.rehman: 08-12-2021, Nayapay Optimization
    //@Column(name = "SETTLEMENT_DELAY")
    @Transient
    private String settlementdelay;

    //m.rehman: 08-12-2021, Nayapay Optimization
    //@Column(name = "PAGE_COUNT")
    @Transient
    private String pagecount;

    //m.rehman: 08-12-2021, Nayapay Optimization
    //@Column(name = "PAGE_SIZE")
    @Transient
    private String pagesize;

    //m.rehman: 08-12-2021, Nayapay Optimization
    //@Column(name = "TOTAL_COUNT")
    @Transient
    private String totalcount;

    @Column(name = "BILLER_ID")
    private String billerid;

    @Column(name = "BILLER_NAME")
    private String billername;

    //m.rehman: 08-12-2021, Nayapay Optimization
    //@Column(name = "PARTIALFLAG")
    @Transient
    private String partialflag;

    //m.rehman: for validating incomcing ip address also save in DB for logging
    @Column(name = "SOURCE_IP")
    private String incomingip;
    //m.rehman: for NayaPay, adding new fields for document 2.0 <end>

    //m.rehman: 08-12-2021, Nayapay Optimization
    //@Column(name = "TEMPBLOCKFLAG")
    @Transient
    private String tempblockflag;

    @Column(name = "CARDEXPIRY")
    private String cardexpiry;

    @Column(name = "CARDNOLASTDIGITS")
    private String cardnolastdigits;

    //m.rehman: 08-12-2021, Nayapay Optimization
    //@Column(name = "ACCTSTATUS")
    @Transient
    private String acctStatus;

    @Column(name = "AMTTRANFEE")
    private String amttranfee;

    @Column(name = "TERMLOC")
    private String termloc;

    @Transient
    private String ismerchantonline;

    @Transient
    private String iswalletaccount;

    @Column(name = "MERCHANT_AMT")
    private String merchantamount;
	
    @Column(name = "ORIGINALAPI")
    private String originalapi;

    //m.rehman: 08-12-2021, Nayapay Optimization
    //@Column(name = "DECRYPTEDOTP")
    @Transient
    private String decryptedotp;

    //m.rehman: 08-12-2021, Nayapay Optimization
    //@Column(name = "CIPHEREDDATA")
    @Transient
    private String ciphereddata;

    //m.rehman: for onelink issuing
    @Transient
    private String track2Data;

    @Transient
    private String track3Data;

    @Transient
    private String track1Data;

    @Transient
    private String icccarddata;

    @Transient
    private String servicecode;

    @Transient
    private String cvv;

    @Transient
    private String cvv2;

    @Transient
    private String icvv;

    // Asim Shahzad, Date : 21st Sep 2020, Tracking ID : VC-NAP-202009101 / VP-NAP-202009104
    @Column(name = "POS_ENT_MODE")
    private String posentrymode;

    @Transient
    private String selfdefinedata;

    @Transient
    private String acctlevel;

    @Column(name = "TRACKING_ID")
    private String trackingid;

    @Transient
    private List<CardObject> cardobjectlist;

    @Column(name = "MAP_ID")
    private String mapid;

    @Column(name = "POS_INVOICE_REF")
    private String posinvoiceref;

    @Column(name = "TERMINALID")
    private String terminalid;

    //m.rehman: 08-12-2021, Nayapay Optimization
    //@Column(name = "DISPUTE_FLAG")
    @Transient
    private String disputeflag;

    //m.rehman: 08-12-2021, Nayapay Optimization
    //@Column(name = "BLOCK_TYPE")
    @Transient
    private String blocktype;

    //m.rehman: 08-12-2021, Nayapay Optimization
    //@Column(name = "LOCK_STATE")
    @Transient
    private String lockstate;

    //m.rehman: 08-12-2021, Nayapay Optimization
    //@Column(name = "FINANCIAL_FLAG")
    @Transient
    private String financialflag;

    @Column(name = "TRANCURRENCY")
    private String trancurrency; //Raza also add column in DB

//    @Transient
//    @JsonIgnore
//    private ProcessContext processContext; //Raza commenting

	    //m.rehman: VP-NAP-202008211 / VC-NAP-202008211 - 17-09-2020 - Creation of Dispute transactions settlement feature (Phase I)
    @Column(name = "ORIG_STAN")
    private String origstan;

	    //m.rehman: VP-NAP-202008211 / VC-NAP-202008211 - 17-09-2020 - Creation of Dispute transactions settlement feature (Phase I)
    @Column(name = "ORIG_TRANS_DATE_TIME")
    private String origtransdatetime;

    //m.rehman: 08-12-2021, Nayapay Optimization
    @Transient
    private String occupation;

    // Author: Asim Shahzad, Date : 24th Feb 2020, Desc : For getting Nayapay mobile application download counts from middleware

    //m.rehman: 08-12-2021, Nayapay Optimization
    //@Column(name = "NP_APP_DOWNLOAD_COUNT")
    @Transient
    private String npappdownloadcount;

    //*******************************************************************************************************
    // Asim Shahzad, Date : 30th March 2020, Desc : Added available and actual balances for Ledger management
    @Transient
    private String availablebaldebitacc; // availableBalDebitAcc

    @Transient
    private String actualbaldebitacc; // actualBalDebitAcc

    @Transient
    private String availablebalcreditacc; // availableBalCreditAcc

    @Transient
    private String actualbalcreditacc; // actualBalCreditAcc

    @Transient
    private String fundsvoucherid; // actualBalCreditAcc
    //*******************************************************************************************************

    //m.rehman: Euronet Integration, for 3D Secure implementation
    @Transient
    private String cavvdata;
	
	// Asim Shahzad, Date : 24th May 2021, Tracking ID : VP-NAP-202103115 / VC-NAP-202103115
    @Column(name = "CBILL_AMT")
    private String cbillamount;
	// =======================================================================================
    @Column(name = "CBILL_CURR")
    private String cbillcurrency;

    @Column(name = "CBILL_RATE")
    private String cbillrate;

    //m.rehman: for IBFT Out
    @Column(name = "BENE_BANK_CODE")
    private String benebankcode;

    @Column(name = "BENE_BANK_ACCT_NO")
    private String benebankaccountno;

    @Column(name = "BENE_ACCT_TITLE")
    private String beneaccounttitle;

    //m.rehman: 08-12-2021, Nayapay Optimization
    //@Column(name = "BENE_FLAG")
    @Transient
    private String beneflag;

    //m.rehman: 08-12-2021, Nayapay Optimization
    //@Column(name = "BENE_ACCT_ALIAS")
    @Transient
    private String beneaccountalias;

    //m.rehman: 08-12-2021, Nayapay Optimization
    //@Column(name = "BENEFICIARY_ID")
    @Transient
    private String beneid;

    @Column(name = "BENE_EMAIL_ID")
    private String beneemailid;

    @Column(name = "BENE_MOBILE_NO")
    private String benemobileno;

    @Column(name = "PURPOSE_OF_TXN")
    private String purposeoftransaction;

    // Asim Shahzad, Date : 22nd Sep 2020, Tracking ID : VC-NAP-202009101 / VP-NAP-202009104
    @Column(name = "CARD_SCHEME")
    private String cardscheme;
    // =====================================================================================
    //m.rehman: VP-NAP-202008211 / VC-NAP-202008211 - 17-09-2020 - Creation of Dispute transactions settlement feature (Phase I)
    @Column(name = "ORIG_RET_REF_NO")
    private String origretrefno;

    @Column(name = "NP_TICKET_ID")
    private String npticket;

    @Column(name = "VROL_TICKET_ID")
    private String vrolticket;
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    

    // Asim Shahzad, Date : 13th Jan 2021, Tracking ID : VC-NAP-202101071 / VP-NAP-202101071 / VG-NAP-202101071 (Release # 1)

//    @Transient
//    private Boolean atlStatus;
//
//    public Boolean getAtlStatus() {
//        return atlStatus;
//    }
//
//    public void setAtlStatus(Boolean atlStatus) {
//        this.atlStatus = atlStatus;
//    }
    // Asim Shahzad, Date : 13th Jan 2021, Tracking ID : VC-NAP-202101071 / VP-NAP-202101071 / VG-NAP-202101071 (Release # 1)

    //m.rehman: 08-12-2021, Nayapay Optimization
    //@Column(name="IS_CHIP_PIN_ENABLED")
    @Transient
    private String isChipPinEnabled;

    //m.rehman: 08-12-2021, Nayapay Optimization
    //@Column(name="IS_MAG_STRIPE_ENABLED")
    @Transient
    private String isMagStripeEnabled;

    //m.rehman: 08-12-2021, Nayapay Optimization
    //@Column(name="IS_CASH_WITHDRAWAL_ENABLED")
    @Transient
    private String isCashWithdrawalEnabled;

    //m.rehman: 08-12-2021, Nayapay Optimization
    //@Column(name="IS_NFC_ENABLED")
    @Transient
    private String isNFCEnabled;

    //m.rehman: 08-12-2021, Nayapay Optimization
    //@Column(name="IS_ONLINE_ENABLED")
    @Transient
    private String isOnlineEnabled;

    //m.rehman: 08-12-2021, Nayapay Optimization
    //@Column(name="IS_INT_TXNS_ENABLED")
    @Transient
    private String isInternationalTxnsEnabled;

    public String getIsChipPinEnabled() {
        return isChipPinEnabled;
    }

    public void setIsChipPinEnabled(String isChipPinEnabled) {
        this.isChipPinEnabled = isChipPinEnabled;
    }

    public String getIsMagStripeEnabled() {
        return isMagStripeEnabled;
    }

    public void setIsMagStripeEnabled(String isMagStripeEnabled) {
        this.isMagStripeEnabled = isMagStripeEnabled;
    }

    public String getIsCashWithdrawalEnabled() {
        return isCashWithdrawalEnabled;
    }

    public void setIsCashWithdrawalEnabled(String isCashWithdrawalEnabled) {
        this.isCashWithdrawalEnabled = isCashWithdrawalEnabled;
    }

    public String getIsNFCEnabled() {
        return isNFCEnabled;
    }

    public void setIsNFCEnabled(String isNFCEnabled) {
        this.isNFCEnabled = isNFCEnabled;
    }

    public String getIsOnlineEnabled() {
        return isOnlineEnabled;
    }

    public void setIsOnlineEnabled(String isOnlineEnabled) {
        this.isOnlineEnabled = isOnlineEnabled;
    }

    public String getIsInternationalTxnsEnabled() {
        return isInternationalTxnsEnabled;
    }

    public void setIsInternationalTxnsEnabled(String isInternationalTxnsEnabled) {
        this.isInternationalTxnsEnabled = isInternationalTxnsEnabled;
    }

    // ========================================================================================================

    // Asim Shahzad, Date : 20th Jan 2021, Tracking ID : VC-NAP-202101071 / VP-NAP-202101071 / VG-NAP-202101071 (Release # 2)

    //m.rehman: 08-12-2021, Nayapay Optimization
    //@Column(name="CARD_TYPE")
    @Transient
    private String cardtype;

    public String getCardtype() {
        return cardtype;
    }

    public void setCardtype(String cardtype) {
        this.cardtype = cardtype;
    }

    // ========================================================================================================
    
	//m.rehman: 21-01-2020, VC-NAP-202101071 / VP-NAP-202101071 / VG-NAP-202101071 - VISA (Switch-Middleware Integration document v 4.7.6) - Release 4
	@Transient
    private String globalcardlimit;

    @Transient
    private String cashwithdrawallimit;

    @Transient
    private String purchaselimit;

    @Transient
    private String onlinetxnlimit;
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
	//m.rehman: Euronet integration
	@Transient
    private String addresponsedata;

    //m.rehman: 15-02-2021, VP-NAP-202102101 / VC-NAP-202102101 - Visa - Switch Middleware Integration Document V_4.7.7-A - Release 2
    @Transient
    private String customlimitflag;
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //m.rehman: 05-03-2021, VP-NAP-202103041/ VC-NAP-202103041 - Merchant Transaction Listing Issue
    @Transient
    //m.rehman: 10-11-2021 - Nayapay Optimization
    //private List<MVFinancialLog> wsloglist; // Asim Shahzad, Date : 12th Oct 2021, Tracking ID : PS-VP-NAP-202109301 / PS-VC-NAP-202109301 / PS-VG-NAP-202109301
    private List<WalletCMSWsListingEntity> wsloglist;

    @Transient
    //private MVFinancialLog wslog; // Asim Shahzad, Date : 12th Oct 2021, Tracking ID : PS-VP-NAP-202109301 / PS-VC-NAP-202109301 / PS-VG-NAP-202109301
    private WalletCMSWsListingEntity wslog;
    ///////////////////////////////////////////////////////////////////////////////////////////////

    // Asim Shahzad, Date : 11th March 2021, Tracking ID : VP-NAP-202103111 / VC-NAP-202103111

    @Transient
    private String reasonofclosure;

    @Transient
    private String approvinguser;

    @Transient
    private String closurerequestdatetime;

    // =======================================================================================

    // Asim Shahzad, Date : 16th March 2021, Tracking ID : VP-NAP-202103115 / VC-NAP-202103115

    @Transient
    private String totalamountspent;

    @Transient
    private String totalamountreceived;

    @Transient
    private String fromdatetime;

    @Transient
    private String todatetime;

    // =======================================================================================

    //m.rehman: 07-04-2021, VP-NAP-202103292 / VC-NAP-202103293 - Refund Module Part 2
    @Transient
    private String settledflag;

    @Transient
    private String merchantfavorflag;

    @Transient
    private String debitwalletflag;

    @Transient
    private String creditwalletflag;

    @Column(name = "JUSTIFICATION")
    private String justification;
    //////////////////////////////////////////////////////////////////////////////////

    //m.rehman: 29-04-2021, VG-NAP-202104271 / VP-NAP-202104261 / VC-NAP-202104261 - VISA transaction charging update
    @Transient
    private List<CardCharge> cardchargeslist;
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    // Asim Shahzad, Date : 30th July 2021, Tracking ID : VP-NAP-202104011 / VC-NAP-202104012
    @Column(name="SETTLEMENT_AMOUNT")
    private String settlementamount;

    public String getSettlementamount() {
        return settlementamount;
    }

    public void setSettlementamount(String settlementamount) {
        this.settlementamount = settlementamount;
    }
    // ======================================================================================

    //Arsalan Akhter, Date: 07-Oct-2021, Ticket: VP-NAP-202110051 / VC-NAP-202110053(Document 4.9.1 - Notifications Update)
    @Transient
    private String declinedbycardctrl;
    //=====================================================================================================================

    //m.rehman: 15-10-2021, PS-VP-NAP-202109301 / PS-VC-NAP-202109301 / PS-VG-NAP-202109301 - Time-out on switch (when calling wallet-API) for wallet statement
    @Column(name = "INCLUDE_IN_STATEMENT", columnDefinition = "integer default 0")
    private int includeinstatement = 0;

    @Column(name = "SOURCE_OPENING_BALANCE")
    private String openingbalance;

    @Column(name = "SOURCE_CLOSING_BALANCE")
    private String closingbalance;

    @Column(name = "DEST_OPENING_BALANCE")
    private String destOpeningbalance;

    @Column(name = "DEST_CLOSING_BALANCE")
    private String destClosingbalance;
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public WalletCMSWsEntity()
    {
        //this.bankform = new HashMap<String, String>();
    }

//    public NayaPayWsModel(String nayapayid,String mobilenumber,
//                          String cnic,String bankcode,
//                          String bankname,String accountnumber,
//                          String tranrefnumber,String cnicpicture,
//                          String customerpicture,String mothername,
//                          String dateofbirth,String transdatetime,
//                          String pindata,String oldpindata,
//                          String newpindata,String encryptkey,
//                          String amounttransaction,String amounttranfee,
//                          String chargeflag,String srcaccount,
//                          String srcaccountcode,String srcaccountcurrency,
//                          String destaccount,String destaccountcode,
//                          String destaccountcurrency,String otp,
//                          String mpin,String srcSettaccountnumber,
//                          String destSettaccountnumber,String merchantflag,
//                          String walletaccountcurrency,String biometricdata,
//                          String respcode,String txnfeetype)
//    {
//
//    }

    public WalletCMSWsEntity(String NayaPayId, String MobileNum, String Cnic, String BankCode,
                             String BankName, String AccountNum, String TranRefNum, String CnicPictureFront, String CnicPictureBack,
                             String CustomerPicture, String MotherName, String DataOBirth, String TransDateTime,
                             String PinData, String OldPinData, String NewPinData, String EncryptKey,
                             String AmountTran, String SrcAmountCharges, String DestAmountCharges , String ChargeFlag, String SrcAccount,
                             String SrcAccountCode, String SrcAccountCurrency, String DestAccount, String DestAccountCode,
                             String DestAccountCurrency, String Otp, /*String MPin,*/ /*String SrcSettAccount,*/
                           /*String DestSettAccount,*/ List<Transaction> TranList, String BioMetric,
                             HashMap<String,String> BankForm, String TxnFeeType)
    {
        //this.nayapayid = NayaPayId; //Raza removing from V1.8
        this.mobilenumber = MobileNum;
        this.cnic = Cnic;
        this.bankcode = BankCode;
        this.bankname = BankName;
        this.accountnumber = AccountNum;
        this.tranrefnumber = TranRefNum;
        this.mothername = MotherName;
        this.dateofbirth = DataOBirth;
        this.transdatetime = TransDateTime;
        this.pindata = PinData;
        this.oldpindata = OldPinData;
        this.newpindata = NewPinData;
        this.encryptkey = EncryptKey;
        this.amounttransaction = AmountTran;
        this.srcchargeamount = SrcAmountCharges;
        //this.chargeflag = ChargeFlag;
        //this.srcaccount = SrcAccount;
        //this.accountcode = SrcAccountCode;
        //this.srcaccountcurrency = SrcAccountCurrency;
        this.destaccount = DestAccount;
        //this.destaccountcode = DestAccountCode;
        this.destaccountcurrency = DestAccountCurrency;
        this.otp = Otp;
        //this.mpin = MPin;
        //this.srcSettaccountnumber = SrcSettAccount;
        //this.destSettaccountnumber = DestSettAccount;
        this.tranlist = TranList;
        this.biometricdata = BioMetric;

        //this.walletaccountcurrency = WalletAccountcurrency;
        //this.txnfeetype = TxnFeeType;
    }

//    public String getNayapayid() { //Raza removing from V1.8
//        return nayapayid;
//    }

//    public void setNayapayid(String nayapayid) { //Raza removing from V1.8
//        this.nayapayid = nayapayid;
//    }

    public String getMobilenumber() {
        return mobilenumber;
    }

    public void setMobilenumber(String mobilenumber) {
        this.mobilenumber = mobilenumber;
    }

    public String getCnic() {
        return cnic;
    }

    public void setCnic(String cnic) {
        this.cnic = cnic;
    }

    public String getBankcode() {
        return bankcode;
    }

    public void setBankcode(String bankcode) {
        this.bankcode = bankcode;
    }

    public String getBankname() {
        return bankname;
    }

    public void setBankname(String bankname) {
        this.bankname = bankname;
    }

    public String getAccountnumber() {
        return accountnumber;
    }

    public void setAccountnumber(String accountnumber) {
        this.accountnumber = accountnumber;
    }

    public String getTranrefnumber() {
        return tranrefnumber;
    }

    public void setTranrefnumber(String tranrefnumber) {
        this.tranrefnumber = tranrefnumber;
    }

    public String getMothername() {
        return mothername;
    }

    public void setMothername(String mothername) {
        this.mothername = mothername;
    }

    public String getDateofbirth() {
        return dateofbirth;
    }

    public void setDateofbirth(String dateofbirth) {
        this.dateofbirth = dateofbirth;
    }

    public String getTransdatetime() {
        return transdatetime;
    }

    public void setTransdatetime(String transdatetime) {
        this.transdatetime = transdatetime;
    }

    public String getPindata() {
        return pindata;
    }

    public void setPindata(String pindata) {
        this.pindata = pindata;
    }

    public String getOldpindata() {
        return oldpindata;
    }

    public void setOldpindata(String oldpindata) {
        this.oldpindata = oldpindata;
    }

    public String getNewpindata() {
        return newpindata;
    }

    public void setNewpindata(String newpindata) {
        this.newpindata = newpindata;
    }

    public String getEncryptkey() {
        return encryptkey;
    }

    public void setEncryptkey(String encryptkey) {
        this.encryptkey = encryptkey;
    }

    public String getAmounttransaction() {
        return amounttransaction;
    }

    public void setAmounttransaction(String amounttransaction) {
        this.amounttransaction = amounttransaction;
    }

//    public String getaccountcode() {
//        return accountcode;
//    }

//    public void setaccountcode(String srcaccountcode) {
//        this.accountcode = srcaccountcode;
//    }

    public String getDestaccount() {
        return destaccount;
    }

    public void setDestaccount(String destaccount) {
        this.destaccount = destaccount;
    }

//    public String getDestaccountcode() {
//        return destaccountcode;
//    }

//    public void setDestaccountcode(String destaccountcode) {
//        this.destaccountcode = destaccountcode;
//    }

    public String getDestaccountcurrency() {
        return destaccountcurrency;
    }

    public void setDestaccountcurrency(String destaccountcurrency) {
        this.destaccountcurrency = destaccountcurrency;
    }

    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }

//    public String getMpin() {
//        return mpin;
//    }
//
//    public void setMpin(String mpin) {
//        this.mpin = mpin;
//    }

//    public String getSrcSettaccountnumber() {
//        return srcSettaccountnumber;
//    }
//
//    public void setSrcSettaccountnumber(String srcSettaccountnumber) {
//        this.srcSettaccountnumber = srcSettaccountnumber;
//    }

//    public String getDestSettaccountnumber() {
//        return destSettaccountnumber;
//    }
//
//    public void setDestSettaccountnumber(String destSettaccountnumber) {
//        this.destSettaccountnumber = destSettaccountnumber;
//    }

    public List<Transaction> getTranlist() {
        return tranlist;
    }

    public void setTranlist(List<Transaction> tranlist) {
        this.tranlist = tranlist;
    }

    public String getRespcode() {
        return respcode;
    }

    public void setRespcode(String respcode) {
        this.respcode = respcode;
    }

    public String getBiometricdata() {
        return biometricdata;
    }

    public void setBiometricdata(String biometricdata) {
        this.biometricdata = biometricdata;
    }

    @JsonIgnore
    public String getServicename() {
        return servicename;
    }

    public void setServicename(String servicename) {
        this.servicename = servicename;
    }

    @JsonIgnore
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



    public String getAccountcurrency() {
        return accountcurrency;
    }

    public void setAccountcurrency(String accountcurrency) {
        this.accountcurrency = accountcurrency;
    }

    public String getPlaceofbirth() {
        return placeofbirth;
    }

    public void setPlaceofbirth(String placeofbirth) {
        this.placeofbirth = placeofbirth;
    }

    public String getCnicexpiry() {
        return cnicexpiry;
    }

    public void setCnicexpiry(String cnicexpiry) {
        this.cnicexpiry = cnicexpiry;
    }

    public String getFathername() {
        return fathername;
    }

    public void setFathername(String fathername) {
        this.fathername = fathername;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getTsp() {
        return tsp;
    }

    public void setTsp(String tsp) {
        this.tsp = tsp;
    }

    public String getDestbankcode() {
        return destbankcode;
    }

    public void setDestbankcode(String destbankcode) {
        this.destbankcode = destbankcode;
    }

    public String getDestnayapayid() {
        return destnayapayid;
    }

    public void setDestnayapayid(String destCnic) {
        this.destnayapayid = destCnic;
    }

    public String getSrcchargeamount() {
        return srcchargeamount;
    }

    public void setSrcchargeamount(String srcchargeamount) {
        this.srcchargeamount = srcchargeamount;
    }

    public String getDestchargeamount() {
        return destchargeamount;
    }

    public void setDestchargeamount(String destchargeamount) {
        this.destchargeamount = destchargeamount;
    }

    public String getOrigdataelement() {
        return origdataelement;
    }

    public void setOrigdataelement(String origdataelement) {
        this.origdataelement = origdataelement;
    }

    public String getAtmid() {
        return atmid;
    }

    public void setAtmid(String atmid) {
        this.atmid = atmid;
    }

    public String getCustomername() {
        return customername;
    }

    public void setCustomername(String customername) {
        this.customername = customername;
    }

    public String getCorebankcode() {
        return corebankcode;
    }

    public void setCorebankcode(String corebankcode) {
        this.corebankcode = corebankcode;
    }

    public String getCoreaccount() {
        return coreaccount;
    }

    public void setCoreaccount(String coreaccount) {
        this.coreaccount = coreaccount;
    }

    public String getCoreaccountcurrency() {
        return coreaccountcurrency;
    }

    public void setCoreaccountcurrency(String coreaccountcurrency) {
        this.coreaccountcurrency = coreaccountcurrency;
    }

    public String getCardnumber() {
        return cardnumber;
    }

    public void setCardnumber(String cardnumber) {
        this.cardnumber = cardnumber;
    }

    public String getCardpindata() {
        return cardpindata;
    }

    public void setCardpindata(String cardpindata) {
        this.cardpindata = cardpindata;
    }

    public String getEnableflag() {
        return enableflag;
    }

    public void setEnableflag(String cardenableflag) {
        this.enableflag = cardenableflag;
    }

    public String getMerchantid() {
        return merchantid;
    }

    public void setMerchantid(String merchantid) {
        this.merchantid = merchantid;
    }

    public String getDailylimit() {
        return dailylimit;
    }

    public void setDailylimit(String dailylimit) {
        this.dailylimit = dailylimit;
    }

    public String getMonthlylimit() {
        return monthlylimit;
    }

    public void setMonthlylimit(String monthlylimit) {
        this.monthlylimit = monthlylimit;
    }

    public String getYearlylimit() {
        return yearlylimit;
    }

    public void setYearlylimit(String yearlylimit) {
        this.yearlylimit = yearlylimit;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @JsonIgnore
    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    @JsonIgnore
    public String getDestcurrency() {
        return destcurrency;
    }

    public void setDestcurrency(String destcurrency) {
        this.destcurrency = destcurrency;
    }

    @JsonIgnore
    public String getCorecurrency() {
        return corecurrency;
    }

    public void setCorecurrency(String corecurrency) {
        this.corecurrency = corecurrency;
    }

    @JsonIgnore
    public String getDestbank() {
        return destbank;
    }

    public void setDestbank(String destbank) {
        this.destbank = destbank;
    }

    @JsonIgnore
    public String getCorebank() {
        return corebank;
    }

    public void setCorebank(String corebank) {
        this.corebank = corebank;
    }

    public String getStan() {
        return stan;
    }

    public void setStan(String stan) {
        this.stan = stan;
    }

    public String getRrn() {
        return rrn;
    }

    public void setRrn(String rrn) {
        this.rrn = rrn;
    }

    public String getChannelid() {
        return channelid;
    }

    public void setChannelid(String channelid) {
        this.channelid = channelid;
    }

    public String getAllowed() {
        return allowed;
    }

    public void setAllowed(String allowed) {
        this.allowed = allowed;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getDeletetype() {
        return deletetype;
    }

    public void setDeletetype(String deletetype) {
        this.deletetype = deletetype;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getAcctid() {
        return acctid;
    }

    public void setAcctid(String acctid) {
        this.acctid = acctid;
    }

    public String getAcctalias() {
        return acctalias;
    }

    public void setAcctalias(String acctalias) {
        this.acctalias = acctalias;
    }

    public String getIsprimary() {
        return isprimary;
    }

    public void setIsprimary(String isprimary) {
        this.isprimary = isprimary;
    }

    public String getAcctbalance() {
        return acctbalance;
    }

    public void setAcctbalance(String acctbalance) {
        this.acctbalance = acctbalance;
    }

    public String getAcctlimit() {
        return acctlimit;
    }

    public void setAcctlimit(String acctLimit) {
        this.acctlimit = acctLimit;
    }

    public String getAvaillimit() {
        return availlimit;
    }

    public void setAvaillimit(String availLimit) {
        this.availlimit = availLimit;
    }

    public String getAvaillimitfreq() {
        return availlimitfreq;
    }

    public void setAvaillimitfreq(String availLimitfreq) {
        this.availlimitfreq = availLimitfreq;
    }

    public List<NayaPayLimit> getNayapaylimits() {
        return nayapaylimits;
    }

    public void setNayapaylimits(List<NayaPayLimit> nayapaylimits) {
        this.nayapaylimits = nayapaylimits;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getRequesttime() {
        return requesttime;
    }

    public void setRequesttime(String requesttime) {
        this.requesttime = requesttime;
    }

    public String getActivationtime() {
        return activationtime;
    }

    public void setActivationtime(String activationtime) {
        this.activationtime = activationtime;
    }

    public List<NayaPayLinkedAccount> getLinkedaccounts() {
        return linkedaccounts;
    }

    public void setLinkedaccounts(List<NayaPayLinkedAccount> linkedaccounts) {
        this.linkedaccounts = linkedaccounts;
    }

    public String getNayapaycharges() {
        return nayapaycharges;
    }

    public void setNayapaycharges(String nayapaycharges) {
        this.nayapaycharges = nayapaycharges;
    }

    public String getDestuserid() {
        return destuserid;
    }

    public void setDestuserid(String destuserid) {
        this.destuserid = destuserid;
    }

    public List<ProvisionalWallet> getProvisionalwallets() {
        return provisionalwallets;
    }

    public void setProvisionalwallets(List<ProvisionalWallet> provisionalwallets) {
        this.provisionalwallets = provisionalwallets;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAdvanceflag() {
        return advanceflag;
    }

    public void setAdvanceflag(String advanceflag) {
        this.advanceflag = advanceflag;
    }

    public List<NayaPayAccount> getAccountlist() {
        return accountlist;
    }

    public void setAccountlist(List<NayaPayAccount> accountlist) {
        this.accountlist = accountlist;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public String getSecondarynumber() {
        return secondarynumber;
    }

    public void setSecondarynumber(String secondarynumber) {
        this.secondarynumber = secondarynumber;
    }

    public String getAccesstoken() {
        return accesstoken;
    }

    public void setAccesstoken(String accesstoken) {
        this.accesstoken = accesstoken;
    }

    public String getInoutfilter() {
        return inoutfilter;
    }

    public void setInoutfilter(String inoutfilter) {
        this.inoutfilter = inoutfilter;
    }

    // Asim Shahzad, Date : 17th March 2021, Tracking ID : VP-NAP-202103115 / VC-NAP-202103115
//    public String getTypefilter() {
//        return typefilter;
//    }
//
//    public void setTypefilter(String typefilter) {
//        this.typefilter = typefilter;
//    }

    public List<String> getTypefilter() {
        return typefilter;
    }

    public void setTypefilter(List<String> typefilter) {
        this.typefilter = typefilter;
    }
    // =======================================================================================

    public String getSearchtext() {
        return searchtext;
    }

    public void setSearchtext(String searchtext) {
        this.searchtext = searchtext;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNayapayid() {
        return nayapayid;
    }

    public void setNayapayid(String nayapayid) {
        this.nayapayid = nayapayid;
    }

    public String getParentid() {
        return parentid;
    }

    public void setParentid(String parentid) {
        this.parentid = parentid;
    }

    public String getMerchantname() {
        return merchantname;
    }

    public void setMerchantname(String merchantname) {
        this.merchantname = merchantname;
    }

    public String getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(String categoryid) {
        this.categoryid = categoryid;
    }

    public String getTrustedflag() {
        return trustedflag;
    }

    public void setTrustedflag(String trustedflag) {
        this.trustedflag = trustedflag;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getTransactionlimit() {
        return transactionlimit;
    }

    public void setTransactionlimit(String transactionlimit) {
        this.transactionlimit = transactionlimit;
    }

    public String getCategoryname() {
        return categoryname;
    }

    public void setCategoryname(String categoryname) {
        this.categoryname = categoryname;
    }

    public String getMerchantstate() {
        return merchantstate;
    }

    public void setMerchantstate(String merchantstate) {
        this.merchantstate = merchantstate;
    }

    public String getMerchantenabled() {
        return merchantenabled;
    }

    public void setMerchantenabled(String merchantenabled) {
        this.merchantenabled = merchantenabled;
    }

    public String getMerchantblocked() {
        return merchantblocked;
    }

    public void setMerchantblocked(String merchantblocked) {
        this.merchantblocked = merchantblocked;
    }

    public String getMinimumamount() {
        return minimumamount;
    }

    public void setMinimumamount(String minimumamount) {
        this.minimumamount = minimumamount;
    }

    public String getMaximumamount() {
        return maximumamount;
    }

    public void setMaximumamount(String maximumamount) {
        this.maximumamount = maximumamount;
    }

    public String getSourcechargetype() {
        return sourcechargetype;
    }

    public void setSourcechargetype(String sourcechargetype) {
        this.sourcechargetype = sourcechargetype;
    }

    public String getDestinationchargetype() {
        return destinationchargetype;
    }

    public void setDestinationchargetype(String destinationchargetype) {
        this.destinationchargetype = destinationchargetype;
    }

    public String getConsumerno() {
        return consumerno;
    }

    public void setConsumerno(String consumerno) {
        this.consumerno = consumerno;
    }

    public String getUtilcompanyid() {
        return utilcompanyid;
    }

    public void setUtilcompanyid(String utilcompanyid) {
        this.utilcompanyid = utilcompanyid;
    }

    public String getConsumerdetail() {
        return consumerdetail;
    }

    public void setConsumerdetail(String consumerdetail) {
        this.consumerdetail = consumerdetail;
    }

    public String getBillstatus() {
        return billstatus;
    }

    public void setBillstatus(String billStatus) {
        this.billstatus = billStatus;
    }

    public String getDuedate() {
        return duedate;
    }

    public void setDuedate(String dueDate) {
        this.duedate = dueDate;
    }

    public String getAmtwithinduedate() {
        return amtwithinduedate;
    }

    public void setAmtwithinduedate(String amtWithinDueDate) {
        this.amtwithinduedate = amtWithinDueDate;
    }

    public String getAmtafterduedate() {
        return amtafterduedate;
    }

    public void setAmtafterduedate(String amtAfterDueDate) {
        this.amtafterduedate = amtAfterDueDate;
    }

    public String getBillingmonth() {
        return billingmonth;
    }

    public void setBillingmonth(String billingMonth) {
        this.billingmonth = billingMonth;
    }

    public String getDatepaid() {
        return datepaid;
    }

    public void setDatepaid(String datePaid) {
        this.datepaid = datePaid;
    }

    public String getAmtpaid() {
        return amtpaid;
    }

    public void setAmtpaid(String amtPaid) {
        this.amtpaid = amtPaid;
    }

    public String getTranauthid() {
        return tranauthid;
    }

    public void setTranauthid(String tranAuthId) {
        this.tranauthid = tranAuthId;
    }

    public String getReserved() {
        return reserved;
    }

    public void setReserved(String reserved) {
        this.reserved = reserved;
    }

    public String getIdentificationno() {
        return identificationno;
    }

    public void setIdentificationno(String identificationNo) {
        this.identificationno = identificationNo;
    }

    public String getPing() {
        return ping;
    }

    public void setPing(String ping) {
        this.ping = ping;
    }

    public String getNayapaytrantype() {
        return nayapaytrantype;
    }

    public void setNayapaytrantype(String nayapaytrantype) {
        this.nayapaytrantype = nayapaytrantype;
    }

    public String getDestusername() {
        return destusername;
    }

    public void setDestusername(String destusername) {
        this.destusername = destusername;
    }

    public String getAgentid() {
        return agentid;
    }

    public void setAgentid(String agentid) {
        this.agentid = agentid;
    }

    public String getReferencenumber() {
        return referencenumber;
    }

    public void setReferencenumber(String referencenumber) {
        this.referencenumber = referencenumber;
    }

    public String getInvoiceid() {
        return invoiceid;
    }

    public void setInvoiceid(String invoiceid) {
        this.invoiceid = invoiceid;
    }

    public String getVerifiedflag() {
        return verifiedflag;
    }

    public void setVerifiedflag(String verifiedflag) {
        this.verifiedflag = verifiedflag;
    }

    public String getStartdate() {
        return startdate;
    }

    public void setStartdate(String startdate) {
        this.startdate = startdate;
    }

    public String getEnddate() {
        return enddate;
    }

    public void setEnddate(String enddate) {
        this.enddate = enddate;
    }

    public String getBanktxnflag() {
        return banktxnflag;
    }

    public void setBanktxnflag(String banktxnflag) {
        this.banktxnflag = banktxnflag;
    }

    public String getBlockedflag() {
        return blockedflag;
    }

    public void setBlockedflag(String blockedflag) {
        this.blockedflag = blockedflag;
    }

    public String getNayapaytxnid() {
        return nayapaytxnid;
    }

    public void setNayapaytxnid(String nayapaytxnid) {
        this.nayapaytxnid = nayapaytxnid;
    }

    public List<UserTransaction> getUsertransactions() {
        return usertransactions;
    }

    public void setUsertransactions(List<UserTransaction> usertransactions) {
        this.usertransactions = usertransactions;
    }

    public String getCreationdate() {
        return creationdate;
    }

    public void setCreationdate(String creationdate) {
        this.creationdate = creationdate;
    }

    public TransactionDetail getTransactionDetail() {
        return transactionDetail;
    }

    public void setTransactionDetail(TransactionDetail transactionDetail) {
        this.transactionDetail = transactionDetail;
    }



    public String getBankcharges() {
        return bankcharges;
    }

    public void setBankcharges(String bankCharges) {
        this.bankcharges = bankCharges;
    }

    public String getBanktaxamount() {
        return banktaxamount;
    }

    public void setBanktaxamount(String bankTaxAmount) {
        this.banktaxamount = bankTaxAmount;
    }

    public String getNayapaytaxamount() {
        return nayapaytaxamount;
    }

    public void setNayapaytaxamount(String nayapayTaxAmount) {
        this.nayapaytaxamount = nayapayTaxAmount;
    }

    public String getDepositamount() {
        return depositamount;
    }

    public void setDepositamount(String depositAmount) {
        this.depositamount = depositAmount;
    }

    public String getTotalamount() {
        return totalamount;
    }

    public void setTotalamount(String totalamount) {
        this.totalamount = totalamount;
    }

    public String getBankmnemonic() {
        return bankmnemonic;
    }

    public void setBankmnemonic(String bankMnemonic) {
        this.bankmnemonic = bankMnemonic;
    }

    public String getAcqbin() {
        return acqbin;
    }

    public void setAcqbin(String acqbin) {
        this.acqbin = acqbin;
    }

    public String getBranchcode() {
        return branchcode;
    }

    public void setBranchcode(String branchcode) {
        this.branchcode = branchcode;
    }

    public String getBranchname() {
        return branchname;
    }

    public void setBranchname(String branchname) {
        this.branchname = branchname;
    }

    public String getSlipnumber() {
        return slipnumber;
    }

    public void setSlipnumber(String slipnumber) {
        this.slipnumber = slipnumber;
    }

    public String getTellerid() {
        return tellerid;
    }

    public void setTellerid(String tellerid) {
        this.tellerid = tellerid;
    }

    public String getSecretquestion1() {
        return secretquestion1;
    }

    public void setSecretquestion1(String secretquestion1) {
        this.secretquestion1 = secretquestion1;
    }

    public String getSecretquestionanswer1() {
        return secretquestionanswer1;
    }

    public void setSecretquestionanswer1(String secretquestionanswer1) {
        this.secretquestionanswer1 = secretquestionanswer1;
    }

    public String getSecretquestion2() {
        return secretquestion2;
    }

    public void setSecretquestion2(String secretquestion2) {
        this.secretquestion2 = secretquestion2;
    }

    public String getSecretquestionanswer2() {
        return secretquestionanswer2;
    }

    public void setSecretquestionanswer2(String secretquestionanswer2) {
        this.secretquestionanswer2 = secretquestionanswer2;
    }

    public SecurityParams getSecurityparams() {
        return securityparams;
    }

    public void setSecurityparams(SecurityParams securityparams) {
        this.securityparams = securityparams;
    }
	
    public String getPartialflag() {
        return partialflag;
    }

    public void setPartialflag(String partialflag) {
        this.partialflag = partialflag;
    }

    public String getSettlementdelay() {
        return settlementdelay;
    }

    public void setSettlementdelay(String settlementdelay) {
        this.settlementdelay = settlementdelay;
    }

    public String getPagecount() {
        return pagecount;
    }

    public void setPagecount(String pagecount) {
        this.pagecount = pagecount;
    }

    public String getPagesize() {
        return pagesize;
    }

    public void setPagesize(String pagesize) {
        this.pagesize = pagesize;
    }

    public String getTotalcount() {
        return totalcount;
    }

    public void setTotalcount(String totalcount) {
        this.totalcount = totalcount;
    }

    public String getBillerid() {
        return billerid;
    }

    public void setBillerid(String billerid) {
        this.billerid = billerid;
    }

    public String getBillername() {
        return billername;
    }

    public void setBillername(String billername) {
        this.billername = billername;
    }

    public String getIncomingip() {
        return incomingip;
    }

    public void setIncomingip(String incomingip) {
        this.incomingip = incomingip;
    }

    public String getCodflag() {
        return codflag;
    }

    public void setCodflag(String codflag) {
        this.codflag = codflag;
    }

    public String getTempblockflag() {
        return tempblockflag;
    }

    public void setTempblockflag(String tempblockflag) {
        this.tempblockflag = tempblockflag;
    }

    public String getCardexpiry() {
        return cardexpiry;
    }

    public void setCardexpiry(String cardexpiry) {
        this.cardexpiry = cardexpiry;
    }

    public String getCardnolastdigits() {
        return cardnolastdigits;
    }

    public void setCardnolastdigits(String cardNoLastDigits) {
        this.cardnolastdigits = cardNoLastDigits;
    }

    public String getAcctStatus() {
        return acctStatus;
    }

    public void setAcctStatus(String acctStatus) {
        this.acctStatus = acctStatus;
    }



    public String getTermloc() {
        return termloc;
    }

    public void setTermloc(String termloc) {
        this.termloc = termloc;
    }

    public String getIsmerchantonline() {
        return ismerchantonline;
    }

    public void setIsmerchantonline(String ismerchantonline) {
        this.ismerchantonline = ismerchantonline;
    }

    public String getIswalletaccount() {
        return iswalletaccount;
    }

    public void setIswalletaccount(String iswalletaccount) {
        this.iswalletaccount = iswalletaccount;
    }

    public String getMerchantamount() {
        return merchantamount;
    }

    public void setMerchantamount(String merchantamount) {
        this.merchantamount = merchantamount;
    }
	
    public String getOriginalapi() {
        return originalapi;
    }

    public void setOriginalapi(String origialapi) {
        this.originalapi = origialapi;
    }

    public List<TransactionDetail> getReversal() {
        return reversal;
    }

    public void setReversal(List<TransactionDetail> reversal) {
        this.reversal = reversal;
    }

    public String getTrack2Data() {
        return track2Data;
    }

    public void setTrack2Data(String track2Data) {
        this.track2Data = track2Data;
    }

    public String getTrack3Data() {
        return track3Data;
    }

    public void setTrack3Data(String track3Data) {
        this.track3Data = track3Data;
    }

    public String getTrack1Data() {
        return track1Data;
    }

    public void setTrack1Data(String track1Data) {
        this.track1Data = track1Data;
    }

    public String getIcccarddata() {
        return icccarddata;
    }

    public void setIcccarddata(String icccarddata) {
        this.icccarddata = icccarddata;
    }

    public String getServicecode() {
        return servicecode;
    }

    public void setServicecode(String servicecode) {
        this.servicecode = servicecode;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public String getCvv2() {
        return cvv2;
    }

    public void setCvv2(String cvv2) {
        this.cvv2 = cvv2;
    }

    public String getIcvv() {
        return icvv;
    }

    public void setIcvv(String icvv) {
        this.icvv = icvv;
    }

    public String getPosentrymode() {
        return posentrymode;
    }

    public void setPosentrymode(String posentrymode) {
        this.posentrymode = posentrymode;
    }
	
    public String getAmttranfee() {
        return amttranfee;
    }

    public void setAmttranfee(String amttranfee) {
        this.amttranfee = amttranfee;
    }

    public String getSelfdefinedata() {
        return selfdefinedata;
    }

    public void setSelfdefinedata(String selfdefinedata) {
        this.selfdefinedata = selfdefinedata;
    }

    public String getDecryptedotp() {
        return decryptedotp;
    }

    public void setDecryptedotp(String decryptedotp) {
        this.decryptedotp = decryptedotp;
    }

    public String getCiphereddata() {
        return ciphereddata;
    }

    public void setCiphereddata(String ciphereddata) {
        this.ciphereddata = ciphereddata;
    }

    public String getAcctlevel() {
        return acctlevel;
    }

    public void setAcctlevel(String acctlevel) {
        this.acctlevel = acctlevel;
    }

    public String getTrackingid() {
        return trackingid;
    }

    public void setTrackingid(String trackingid) {
        this.trackingid = trackingid;
    }

    public List<CardObject> getCardobjectlist() {
        return cardobjectlist;
    }

    public void setCardobjectlist(List<CardObject> cardobjectlist) {
        this.cardobjectlist = cardobjectlist;
    }

    public String getPosinvoiceref() {
        return posinvoiceref;
    }

    public void setPosinvoiceref(String posinvoiceref) {
        this.posinvoiceref = posinvoiceref;
    }

    public String getMapid() {
        return mapid;
    }

    public void setMapid(String mapid) {
        this.mapid = mapid;
    }

    public String getTerminalid() {
        return terminalid;
    }

    public void setTerminalid(String terminalid) {
        this.terminalid = terminalid;
    }

    public String getDisputeflag() {
        return disputeflag;
    }

    public void setDisputeflag(String disputeflag) {
        this.disputeflag = disputeflag;
    }

    public String getBlocktype() {
        return blocktype;
    }

    public void setBlocktype(String blocktype) {
        this.blocktype = blocktype;
    }

    public String getLockstate() {
        return lockstate;
    }

    public void setLockstate(String lockstate) {
        this.lockstate = lockstate;
    }

    public String getFinancialflag() {
        return financialflag;
    }

    public void setFinancialflag(String financialflag) {
        this.financialflag = financialflag;
    }

    public String getTrancurrency() {
        return trancurrency;
    }

    public void setTrancurrency(String trancurrency) {
        this.trancurrency = trancurrency;
    }

    public String getOrigstan() {
        return origstan;
    }

    public void setOrigstan(String origstan) {
        this.origstan = origstan;
    }

    public String getOrigtransdatetime() {
        return origtransdatetime;
    }

    public void setOrigtransdatetime(String origtransdatetime) {
        this.origtransdatetime = origtransdatetime;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    // Author: Asim Shahzad, Date : 24th Feb 2020, Desc : For getting Nayapay mobile application download counts from middleware

    public String getNpappdownloadcount() {
        return npappdownloadcount;
    }

    public void setNpappdownloadcount(String npAppDownloadCount) {
        this.npappdownloadcount = npAppDownloadCount;
    }

    public String getAvailablebaldebitacc() {
        return availablebaldebitacc;
    }

    public void setAvailablebaldebitacc(String availablebaldebitacc) {
        this.availablebaldebitacc = availablebaldebitacc;
    }

    public String getActualbaldebitacc() {
        return actualbaldebitacc;
    }

    public void setActualbaldebitacc(String actualbaldebitacc) {
        this.actualbaldebitacc = actualbaldebitacc;
    }

    public String getAvailablebalcreditacc() {
        return availablebalcreditacc;
    }

    public void setAvailablebalcreditacc(String availablebalcreditacc) {
        this.availablebalcreditacc = availablebalcreditacc;
    }

    public String getActualbalcreditacc() {
        return actualbalcreditacc;
    }

    public void setActualbalcreditacc(String actualbalcreditacc) {
        this.actualbalcreditacc = actualbalcreditacc;
    }

    public String getFundsvoucherid() {
        return fundsvoucherid;
    }

    public void setFundsvoucherid(String fundsvoucherid) {
        this.fundsvoucherid = fundsvoucherid;
    }

	//m.rehman: Euronet Integration
    public String getCavvdata() {
        return cavvdata;
    }

    public void setCavvdata(String cavvdata) {
        this.cavvdata = cavvdata;
    }
    // Asim Shahzad, Date : 24th May 2021, Tracking ID : VP-NAP-202103115 / VC-NAP-202103115
    public String getCbillamount() {
        return cbillamount;
    }

    public void setCbillamount(String cbillamount) {
        this.cbillamount = cbillamount;
    }
	// =======================================================================================
    public String getCbillcurrency() {
        return cbillcurrency;
    }

    public void setCbillcurrency(String cbillcurrency) {
        this.cbillcurrency = cbillcurrency;
    }

    public String getCbillrate() {
        return cbillrate;
    }

    public void setCbillrate(String cbillrate) {
        this.cbillrate = cbillrate;
    }

    public String getBenebankcode() {
        return benebankcode;
    }

    public void setBenebankcode(String benebankcode) {
        this.benebankcode = benebankcode;
    }

    public String getBenebankaccountno() {
        return benebankaccountno;
    }

    public void setBenebankaccountno(String benebankaccountno) {
        this.benebankaccountno = benebankaccountno;
    }

    public String getBeneaccounttitle() {
        return beneaccounttitle;
    }

    public void setBeneaccounttitle(String beneaccounttitle) {
        this.beneaccounttitle = beneaccounttitle;
    }

    public String getBeneflag() {
        return beneflag;
    }

    public void setBeneflag(String beneflag) {
        this.beneflag = beneflag;
    }

    public String getBeneaccountalias() {
        return beneaccountalias;
    }

    public void setBeneaccountalias(String beneaccountalias) {
        this.beneaccountalias = beneaccountalias;
    }

    public String getBeneid() {
        return beneid;
    }

    public void setBeneid(String beneid) {
        this.beneid = beneid;
    }

    public String getBeneemailid() {
        return beneemailid;
    }

    public void setBeneemailid(String beneemailid) {
        this.beneemailid = beneemailid;
    }

    public String getBenemobileno() {
        return benemobileno;
    }

    public void setBenemobileno(String benemobileno) {
        this.benemobileno = benemobileno;
    }

    public String getPurposeoftransaction() {
        return purposeoftransaction;
    }

    public void setPurposeoftransaction(String purposeoftransaction) {
        this.purposeoftransaction = purposeoftransaction;
    }

    // Asim Shahzad, Date : 22nd Sep 2020, Tracking ID : VC-NAP-202009101 / VP-NAP-202009104

    public String getCardscheme() {
        return cardscheme;
    }

    public void setCardscheme(String cardscheme) {
        this.cardscheme = cardscheme;
    }

    // =====================================================================================
	
    //m.rehman: VP-NAP-202008211 / VC-NAP-202008211 - 17-09-2020 - Creation of Dispute transactions settlement feature (Phase I)
    public String getOrigretrefno() {
        return origretrefno;
    }

    public void setOrigretrefno(String origretrefno) {
        this.origretrefno = origretrefno;
    }

    public String getNpticket() {
        return npticket;
    }

    public void setNpticket(String npticket) {
        this.npticket = npticket;
    }

    public String getVrolticket() {
        return vrolticket;
    }

    public void setVrolticket(String vrolticket) {
        this.vrolticket = vrolticket;
    }

	//m.rehman: 21-01-2020, VC-NAP-202101071 / VP-NAP-202101071 / VG-NAP-202101071 - VISA (Switch-Middleware Integration document v 4.7.6) - Release 4
 	public String getGlobalcardlimit() {
        return globalcardlimit;
    }

    public void setGlobalcardlimit(String globalcardlimit) {
        this.globalcardlimit = globalcardlimit;
    }

    public String getCashwithdrawallimit() {
        return cashwithdrawallimit;
    }

    public void setCashwithdrawallimit(String cashwithdrawallimit) {
        this.cashwithdrawallimit = cashwithdrawallimit;
    }

    public String getPurchaselimit() {
        return purchaselimit;
    }

    public void setPurchaselimit(String purchaselimit) {
        this.purchaselimit = purchaselimit;
    }

    public String getOnlinetxnlimit() {
        return onlinetxnlimit;
    }

    public void setOnlinetxnlimit(String onlinetxnlimit) {
        this.onlinetxnlimit = onlinetxnlimit;
    }
	///////////////////////////////////////////////////////////////////////////////////////////
    
	//m.rehman: Euronet Integration
	public String getAddresponsedata() {
        return addresponsedata;
    }

    public void setAddresponsedata(String addresponsedata) {
        this.addresponsedata = addresponsedata;
    }

    //m.rehman: 15-02-2021, VP-NAP-202102101 / VC-NAP-202102101 - Visa - Switch Middleware Integration Document V_4.7.7-A - Release 2
    public String getCustomlimitflag() {
        return customlimitflag;
    }

    public void setCustomlimitflag(String customlimitflag) {
        this.customlimitflag = customlimitflag;
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //m.rehman: 05-03-2021, VP-NAP-202103041/ VC-NAP-202103041 - Merchant Transaction Listing Issue
    //m.rehman: 10-11-2021 - Nayapay Optimization
    //public List<MVFinancialLog> getWsloglist() {
    public List<WalletCMSWsListingEntity> getWsloglist() {
        return wsloglist;
    } // Asim Shahzad, Date : 12th Oct 2021, Tracking ID : PS-VP-NAP-202109301 / PS-VC-NAP-202109301 / PS-VG-NAP-202109301

    //public void setWsloglist(List<MVFinancialLog> wsloglist) { // Asim Shahzad, Date : 12th Oct 2021, Tracking ID : PS-VP-NAP-202109301 / PS-VC-NAP-202109301 / PS-VG-NAP-202109301
    public void setWsloglist(List<WalletCMSWsListingEntity> wsloglist) {
        this.wsloglist = wsloglist;
    }

    //public MVFinancialLog getWslog() { // Asim Shahzad, Date : 12th Oct 2021, Tracking ID : PS-VP-NAP-202109301 / PS-VC-NAP-202109301 / PS-VG-NAP-202109301
    public WalletCMSWsListingEntity getWslog() {
        return wslog;
    }

    //public void setWslog(MVFinancialLog wslog) { // Asim Shahzad, Date : 12th Oct 2021, Tracking ID : PS-VP-NAP-202109301 / PS-VC-NAP-202109301 / PS-VG-NAP-202109301
    public void setWslog(WalletCMSWsListingEntity wslog) {
        this.wslog = wslog;
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //    @JsonIgnore
//    public ProcessContext getProcessContext() {
//        if(processContext == null) {
//            processContext = new ProcessContext(true);
//            return processContext;
//        }
//        else
//        {
//            return processContext;
//        }
//    }

//    public void setProcessContext(ProcessContext processContext) {
//        this.processContext = processContext;
//    }

    // Asim Shahzad, Date : 12th March 2021, Tracking ID : VP-NAP-202103113 / VC-NAP-202103113

    @Transient
    private String nameoncard;

    public String getNameoncard() {
        return nameoncard;
    }

    public void setNameoncard(String nameoncard) {
        this.nameoncard = nameoncard;
    }

    // ========================================================================================

    // Asim Shahzad, Date : 11th March 2021, Tracking ID : VP-NAP-202103111 / VC-NAP-202103111

    public String getReasonofclosure() {
        return reasonofclosure;
    }

    public void setReasonofclosure(String reasonofclosure) {
        this.reasonofclosure = reasonofclosure;
    }

    public String getApprovinguser() {
        return approvinguser;
    }

    public void setApprovinguser(String approvinguser) {
        this.approvinguser = approvinguser;
    }

    public String getClosurerequestdatetime() {
        return closurerequestdatetime;
    }

    public void setClosurerequestdatetime(String closurerequestdatetime) {
        this.closurerequestdatetime = closurerequestdatetime;
    }


    // ========================================================================================

    // Asim Shahzad, Date : 16th March 2021, Tracking ID : VP-NAP-202103115 / VC-NAP-202103115

    public String getTotalamountspent() {
        return totalamountspent;
    }

    public void setTotalamountspent(String totalamountspent) {
        this.totalamountspent = totalamountspent;
    }

    public String getTotalamountreceived() {
        return totalamountreceived;
    }

    public void setTotalamountreceived(String totalamountreceived) {
        this.totalamountreceived = totalamountreceived;
    }

    public String getFromdatetime() {
        return fromdatetime;
    }

    public void setFromdatetime(String fromdatetime) {
        this.fromdatetime = fromdatetime;
    }

    public String getTodatetime() {
        return todatetime;
    }

    public void setTodatetime(String todatetime) {
        this.todatetime = todatetime;
    }

    // ========================================================================================

    // Asim Shahzad, Date : 18th March 2021, Tracking ID : VP-NAP-202103117 / VC-NAP-202103116

    @Column(name="SETT_RATE")
    private String settlementrate;

    public String getSettlementrate() {
        return settlementrate;
    }

    public void setSettlementrate(String settlementrate) {
        this.settlementrate = settlementrate;
    }

    @Column(name = "WITHHOLDING_TAX_AMT")
    private String withholdingtaxamount;

    public String getWithholdingtaxamount() {
        return withholdingtaxamount;
    }

    public void setWithholdingtaxamount(String withholdingtaxamount) {
        this.withholdingtaxamount = withholdingtaxamount;
    }

    // =======================================================================================
    //m.rehman: 07-04-2021, VP-NAP-202103292 / VC-NAP-202103293 - Refund Module Part 2
    public String getSettledflag() {
        return settledflag;
    }

    public void setSettledflag(String settledflag) {
        this.settledflag = settledflag;
    }

    public String getMerchantfavorflag() {
        return merchantfavorflag;
    }

    public void setMerchantfavorflag(String merchantfavorflag) {
        this.merchantfavorflag = merchantfavorflag;
    }

    public String getDebitwalletflag() {
        return debitwalletflag;
    }

    public void setDebitwalletflag(String debitwalletflag) {
        this.debitwalletflag = debitwalletflag;
    }

    public String getCreditwalletflag() {
        return creditwalletflag;
    }

    public void setCreditwalletflag(String creditwalletflag) {
        this.creditwalletflag = creditwalletflag;
    }

    public String getJustification() {
        return justification;
    }

    public void setJustification(String justification) {
        this.justification = justification;
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //m.rehman: 29-04-2021, VG-NAP-202104271 / VP-NAP-202104261 / VC-NAP-202104261 - VISA transaction charging update
    public WalletCMSWsEntity copy() {
        WalletCMSWsEntity wsEntity = new WalletCMSWsEntity();
        wsEntity.setServicename(this.getServicename());
        wsEntity.setMobilenumber(this.getMobilenumber());
        wsEntity.setCnic(this.getCnic());
        wsEntity.setCustomername(this.getCustomername());
        wsEntity.setCnicexpiry(this.getCnicexpiry());
        wsEntity.setBankcode(this.getBankcode());
        wsEntity.setDestbankcode(this.getDestbankcode());
        wsEntity.setBankname(this.getBankname());
        wsEntity.setAccountnumber(this.getAccountnumber());
        wsEntity.setAccountcurrency(this.getAccountcurrency());
        wsEntity.setTranrefnumber(this.getTranrefnumber());
        wsEntity.setMothername(this.getMothername());
        wsEntity.setDateofbirth(this.getDateofbirth());
        wsEntity.setTransdatetime(this.getTransdatetime());
        wsEntity.setPindata(this.getPindata());
        wsEntity.setOldpindata(this.getOldpindata());
        wsEntity.setNewpindata(this.getNewpindata());
        wsEntity.setEncryptkey(this.getEncryptkey());
        wsEntity.setAmounttransaction(this.getAmounttransaction());
        wsEntity.setSrcchargeamount(this.getSrcchargeamount());
        wsEntity.setDestchargeamount(this.getDestchargeamount());
        wsEntity.setDestaccount(this.getDestaccount());
        wsEntity.setDestaccountcurrency(this.getDestaccountcurrency());
        wsEntity.setOtp(this.getOtp());
        wsEntity.setBiometricdata(this.getBiometricdata());
        wsEntity.setRespcode(this.getRespcode());
        wsEntity.setPlaceofbirth(this.getPlaceofbirth());
        wsEntity.setFathername(this.getFathername());
        wsEntity.setProvince(this.getProvince());
        wsEntity.setTsp(this.getTsp());
        wsEntity.setDestnayapayid(this.getDestnayapayid());
        wsEntity.setOrigdataelement(this.getOrigdataelement());
        wsEntity.setAtmid(this.getAtmid());
        wsEntity.setCorebankcode(this.getCorebankcode());
        wsEntity.setCoreaccount(this.getCoreaccount());
        wsEntity.setCoreaccountcurrency(this.getCoreaccountcurrency());
        wsEntity.setCardnumber(this.getCardnumber());
        wsEntity.setCardpindata(this.getCardpindata());
        wsEntity.setEnableflag(this.getEnableflag());
        wsEntity.setMerchantid(this.getMerchantid());
        wsEntity.setDailylimit(this.getDailylimit());
        wsEntity.setMonthlylimit(this.getMonthlylimit());
        wsEntity.setYearlylimit(this.getYearlylimit());
        wsEntity.setStatus(this.getStatus());
        wsEntity.setStan(this.getStan());
        wsEntity.setRrn(this.getRrn());
        wsEntity.setUserid(this.getUserid());
        wsEntity.setChannelid(this.getChannelid());
        wsEntity.setAllowed(this.getAllowed());
        wsEntity.setDeletetype(this.getDeletetype());
        wsEntity.setComments(this.getComments());
        wsEntity.setAcctid(this.getAcctid());
        wsEntity.setAcctalias(this.getAcctalias());
        wsEntity.setIsprimary(this.getIsprimary());
        wsEntity.setAcctbalance(this.getAcctbalance());
        wsEntity.setAcctlimit(this.getAcctlimit());
        wsEntity.setAvaillimit(this.getAvaillimit());
        wsEntity.setAvaillimitfreq(this.getAvaillimitfreq());
        wsEntity.setState(this.getState());
        wsEntity.setRequesttime(this.getRequesttime());
        wsEntity.setActivationtime(this.getActivationtime());
        wsEntity.setNayapaycharges(this.getNayapaycharges());
        wsEntity.setDestuserid(this.getDestuserid());
        wsEntity.setAddress(this.getAddress());
        wsEntity.setCity(this.getCity());
        wsEntity.setCountry(this.getCountry());
        wsEntity.setAdvanceflag(this.getAdvanceflag());
        wsEntity.setSecondarynumber(this.getSecondarynumber());
        wsEntity.setAccesstoken(this.getAccesstoken());
        wsEntity.setInoutfilter(this.getInoutfilter());
        wsEntity.setTypefilter(this.getTypefilter());
        wsEntity.setSearchtext(this.getSearchtext());
        wsEntity.setUsername(this.getUsername());
        wsEntity.setNayapayid(this.getNayapayid());
        wsEntity.setParentid(this.getParentid());
        wsEntity.setMerchantname(this.getMerchantname());
        wsEntity.setCategoryid(this.getCategoryid());
        wsEntity.setTrustedflag(this.getTrustedflag());
        wsEntity.setPhonenumber(this.getPhonenumber());
        wsEntity.setTransactionlimit(this.getTransactionlimit());
        wsEntity.setCategoryname(this.getCategoryname());
        wsEntity.setMerchantstate(this.getMerchantstate());
        wsEntity.setMerchantenabled(this.getMerchantenabled());
        wsEntity.setMerchantblocked(this.getMerchantblocked());
        wsEntity.setMinimumamount(this.getMinimumamount());
        wsEntity.setMaximumamount(this.getMaximumamount());
        wsEntity.setSourcechargetype(this.getSourcechargetype());
        wsEntity.setDestinationchargetype(this.getDestinationchargetype());
        wsEntity.setConsumerno(this.getConsumerno());
        wsEntity.setUtilcompanyid(this.getUtilcompanyid());
        wsEntity.setConsumerdetail(this.getConsumerdetail());
        wsEntity.setBillstatus(this.getBillstatus());
        wsEntity.setDuedate(this.getDuedate());
        wsEntity.setAmtwithinduedate(this.getAmtwithinduedate());
        wsEntity.setAmtafterduedate(this.getAmtafterduedate());
        wsEntity.setBillingmonth(this.getBillingmonth());
        wsEntity.setDatepaid(this.getDatepaid());
        wsEntity.setAmtpaid(this.getAmtpaid());
        wsEntity.setTranauthid(this.getTranauthid());
        wsEntity.setReserved(this.getReserved());
        wsEntity.setIdentificationno(this.getIdentificationno());
        wsEntity.setPing(this.getPing());
        wsEntity.setNayapaytrantype(this.getNayapaytrantype());
        wsEntity.setDestusername(this.getDestusername());
        wsEntity.setAgentid(this.getAgentid());
        wsEntity.setReferencenumber(this.getReferencenumber());
        wsEntity.setInvoiceid(this.getInvoiceid());
        wsEntity.setVerifiedflag(this.getVerifiedflag());
        wsEntity.setStartdate(this.getStartdate());
        wsEntity.setEnddate(this.getEnddate());
        wsEntity.setBanktxnflag(this.getBanktxnflag());
        wsEntity.setBlockedflag(this.getBlockedflag());
        wsEntity.setMerchantenabled(this.getMerchantenabled());
        wsEntity.setNayapaytxnid(this.getNayapaytxnid());
        wsEntity.setCreationdate(this.getCreationdate());
        wsEntity.setNayapaylimits(this.getNayapaylimits());
        wsEntity.setLinkedaccounts(this.getLinkedaccounts());
        wsEntity.setProvisionalwallets(this.getProvisionalwallets());
        wsEntity.setAccountlist(this.getAccountlist());
        wsEntity.setTransactions(this.getTransactions());
        wsEntity.setUsertransactions(this.getUsertransactions());
        wsEntity.setMerchantenabled(this.getMerchantenabled());
        wsEntity.setTransactionDetail(this.getTransactionDetail());
        wsEntity.setCurrency(this.getCurrency());
        wsEntity.setBank(this.getBank());
        wsEntity.setDestbank(this.getDestbank());
        wsEntity.setCorebank(this.getCorebank());
        wsEntity.setDestcurrency(this.getDestcurrency());
        wsEntity.setCorecurrency(this.getCorecurrency());
        wsEntity.setBillerid(this.getBillerid());
        wsEntity.setBillername(this.getBillername());
        wsEntity.setConsumerno(this.getConsumerno());
        wsEntity.setAcctStatus(this.getAcctStatus());
        wsEntity.setTerminalid(this.getTerminalid());
        wsEntity.setBankcode(this.getBankcode());
        wsEntity.setDecryptedotp(this.getDecryptedotp());
        wsEntity.setCiphereddata(this.getCiphereddata());
        wsEntity.setAmttranfee(this.getAmttranfee());
        wsEntity.setAcctlevel(this.getAcctlevel());
        wsEntity.setMapid(this.getMapid());
        wsEntity.setPosinvoiceref(this.getPosinvoiceref());
        wsEntity.setDisputeflag(this.getDisputeflag());
        wsEntity.setBlocktype(this.getBlocktype());
        wsEntity.setLockstate(this.getLockstate());
        wsEntity.setFinancialflag(this.getFinancialflag());
        wsEntity.setNameoncard(this.getNameoncard());
        wsEntity.setReasonofclosure(this.getReasonofclosure());
        wsEntity.setApprovinguser(this.getApprovinguser());
        wsEntity.setClosurerequestdatetime(this.getClosurerequestdatetime());
        wsEntity.setTotalamountspent(this.getTotalamountspent());
        wsEntity.setTotalamountreceived(this.getTotalamountreceived());
        wsEntity.setFromdatetime(this.getFromdatetime());
        wsEntity.setTodatetime(this.getTodatetime());
        wsEntity.setBranchcode(this.getBranchcode());
        wsEntity.setTrancurrency(this.getTrancurrency());
        wsEntity.setSettlementrate(this.getSettlementrate());
        wsEntity.setCbillamount(this.getCbillamount());
        wsEntity.setCbillcurrency(this.getCbillcurrency());
        wsEntity.setCardexpiry(this.getCardexpiry());
        wsEntity.setPosentrymode(this.getPosentrymode());
        wsEntity.setTrack1Data(this.getTrack1Data());
        wsEntity.setTrack2Data(this.getTrack2Data());
        wsEntity.setTrack3Data(this.getTrack3Data());
        wsEntity.setIcccarddata(this.getIcccarddata());
        wsEntity.setSelfdefinedata(this.getSelfdefinedata());
        wsEntity.setBranchname(this.getBranchname());
        wsEntity.setTermloc(this.getTermloc());
        wsEntity.setAcqbin(this.getAcqbin());
        wsEntity.setCavvdata(this.getCavvdata());
        wsEntity.setCvv2(this.getCvv2());
        wsEntity.setCardscheme(this.getCardscheme());
        wsEntity.setCardnolastdigits(this.getCardnolastdigits());
        wsEntity.setId(null);
        //Arsalan Akhter, Date: 07-Oct-2021, Ticket: VP-NAP-202110051 / VC-NAP-202110053(Document 4.9.1 - Notifications Update)
        wsEntity.setDeclinedbycardctrl(this.getDeclinedbycardctrl());
        //=====================================================================================================================

        return wsEntity;
    }

    public List<CardCharge> getCardchargeslist() {
        return cardchargeslist;
    }

    public void setCardchargeslist(List<CardCharge> cardchargeslist) {
        this.cardchargeslist = cardchargeslist;
    }
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    // Asim Shahzad, Date : 29th June 2021, Tracking ID : VP-NAP-202106241 / VC-NAP-202106241

    @Column(name = "IBAN")
    private String iban;

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    // ======================================================================================

    // Asim Shahzad, Date : 10 Aug 2021, Tracking ID : VP-NAP-202108091 / VC-NAP-202108093/ VG-NAP-202108091

    @Transient
    private String monthstartingbalance;

    @Transient
    private String monthendingbalance;

    public String getMonthstartingbalance() {
        return monthstartingbalance;
    }

    public void setMonthstartingbalance(String monthstartingbalance) {
        this.monthstartingbalance = monthstartingbalance;
    }

    public String getMonthendingbalance() {
        return monthendingbalance;
    }

    public void setMonthendingbalance(String monthendingbalance) {
        this.monthendingbalance = monthendingbalance;
    }

    // =====================================================================================================

    // Asim Shahzad, Date : 24th Aug 2021, Tracking ID : VP-NAP-202108161 / VC-NAP-202108161
    @Column(name = "ACQ_COUNTRY")
    private String acqcountrycode;

    public String getAcqcountrycode() {
        return acqcountrycode;
    }

    public void setAcqcountrycode(String acqcountrycode) {
        this.acqcountrycode = acqcountrycode;
    }
    // =====================================================================================
    //Arsalan Akhter, Date: 07-Oct-2021, Ticket: VP-NAP-202110051 / VC-NAP-202110053(Document 4.9.1 - Notifications Update)
    public String getDeclinedbycardctrl() { return declinedbycardctrl; }

    public void setDeclinedbycardctrl(String declinedbycardctrl) { this.declinedbycardctrl = declinedbycardctrl; }
    //=====================================================================================================================

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //m.rehman: 15-10-2021, PS-VP-NAP-202109301 / PS-VC-NAP-202109301 / PS-VG-NAP-202109301 - Time-out on switch (when calling wallet-API) for wallet statement
    public int getIncludeinstatement() {
        return includeinstatement;
    }

    public void setIncludeinstatement(int includeInStatement) {
        this.includeinstatement = includeInStatement;
    }

    public String getOpeningbalance() {
        return openingbalance;
    }

    public void setOpeningbalance(String openingbalance) {
        this.openingbalance = openingbalance;
    }

    public String getClosingbalance() {
        return closingbalance;
    }

    public void setClosingbalance(String closingbalance) {
        this.closingbalance = closingbalance;
    }

    public String getDestOpeningbalance() {
        return destOpeningbalance;
    }

    public void setDestOpeningbalance(String destOpeningbalance) {
        this.destOpeningbalance = destOpeningbalance;
    }

    public String getDestClosingbalance() {
        return destClosingbalance;
    }

    public void setDestClosingbalance(String destClosingbalance) {
        this.destClosingbalance = destClosingbalance;
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
    // Asim Shahzad, Date : 6th Oct 2021, Tracking ID : PS-VP-NAP-202109301 / PS-VC-NAP-202109301 / PS-VG-NAP-202109301
    @Column(name = "LOG_DATE")
    private Date logDate = new Date();

    public Date getLogDate() {
        return logDate;
    }

    public void setLogDate(Date logDate) {
        this.logDate = logDate;
    }
    // ==============================================================================================================

    //m.rehman: 22-11-2021, HSM response logging
    @Transient
    private String threadId;

    @Transient
    private String threadName;

    public String getThreadId() {
        return threadId;
    }

    public void setThreadId(String threadId) {
        this.threadId = threadId;
    }

    public String getThreadName() {
        return threadName;
    }

    public void setThreadName(String threadName) {
        this.threadName = threadName;
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////



    //Added by m.waleed 06/09/20233 VC-NAP-202303062 - Merchant Portal
    //@Transient
    @Column(name="CARD_ID")
    private  String cardid;

    @Column(name="IS_MERCHANT_TXN")
    private int ismerchanttransaction;

    public String getCardid() {
        return cardid;
    }

    public void setCardid(String cardid) {
        this.cardid = cardid;
    }

    public int getIsmerchanttransaction() {
        return ismerchanttransaction;
    }

    public void setIsmerchanttransaction(int ismerchanttransaction) {
        this.ismerchanttransaction = ismerchanttransaction;
    }


    //==================================================================
}
