package vaulsys.routing.base.exception;

import vaulsys.exception.impl.DecisionMakerExceptionImp;
import vaulsys.protocols.ifx.imp.Ifx;
import vaulsys.protocols.PaymentSchemes.base.ISOResponseCodes;

public class NoDestinationFoundException extends DecisionMakerExceptionImp {

    public NoDestinationFoundException() {
        super();
        // TODO Auto-generated constructor stub
    }

    public NoDestinationFoundException(String message, Throwable cause) {
        super(message, cause);
        // TODO Auto-generated constructor stub
    }

    public NoDestinationFoundException(String message) {
        super(message);
        // TODO Auto-generated constructor stub
    }

    public NoDestinationFoundException(Throwable cause) {
        super(cause);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void alterIfxByErrorType(Ifx ifx) {
        ifx.setRsCode( ISOResponseCodes.INVALID_CARD_STATUS);
//        ifx.Status.Severity = SeverityEnum.Error;
//        ifx.Status.StatusDesc = this.getClass().getSimpleName() + ": " + getMessage();

    }

    @Override
    public boolean returnError() {
        // TODO Auto-generated method stub
        return true;
    }

}