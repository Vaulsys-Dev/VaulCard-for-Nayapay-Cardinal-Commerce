package vaulsys.protocols.PaymentSchemes.MasterCard;

import vaulsys.protocols.ifx.IFXReturnCode;

import java.util.HashMap;

public class MasterCardReturnCode {

    // ISO : Action Codes

    static public String approved = "approved";
    static public String do_not_honour = "do_not_honour";
    static public String expired_card = "expired card";
    static public String suspected_fraud = "suspected fraud";
    static public String restricted_card = "restricted card";
    static public String no_destination = "transaction destination cannot be found for routing";

    static private HashMap<String, String> returnCodes = new HashMap<String, String>();
    static private HashMap<Long, String> ifxToiso = new HashMap<Long, String>();

    public static String getCode(String isodscr) {
        return returnCodes.get(isodscr);
    }

    public static String getCode(Long ifxCode) {
        return ifxToiso.get(ifxCode);
    }

    public static void addCode(String dscr, String code) {
        returnCodes.put(dscr, code);
    }

    public static void map(Long ifxCode, String isoCode) {
        ifxToiso.put(ifxCode, isoCode);
    }


    static {
        addCode(MasterCardReturnCode.approved, "000");
        map(IFXReturnCode.getErrorCode(IFXReturnCode.NoError), "000");

        addCode(MasterCardReturnCode.do_not_honour, "100");


        addCode(MasterCardReturnCode.expired_card, "101");
        addCode(MasterCardReturnCode.suspected_fraud, "102");
        addCode(MasterCardReturnCode.restricted_card, "104");

        addCode(MasterCardReturnCode.no_destination, "908");
        map(IFXReturnCode.getErrorCode(IFXReturnCode.No_Destination), "908");

    }


}