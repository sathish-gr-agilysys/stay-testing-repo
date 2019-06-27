/**
 * (C) 2019 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.constants;

public class AccountConstants {
    public static final String ADJUSTMENT_ERROR = "calculated amount is negative";
    public static final String FLAT_TAX_FEE = "fee";
    public static final String TAX_CLASS = "class";
    public static final String TRANSFER_TO_RESERVED_GUEST_ACCOUNT_MESSAGE = " to %s with Reservation #%s.";
    public static final String TRANSFER_TO_GROUP_ACCOUNT_MESSAGE = " to Group %s.";
    public static final String TRANSFER_TO_COMPANY_ACCOUNT_MESSAGE = " to A/R Account %s.";
    public static final String TRANSFER_FROM_RESERVED_GUEST_ACCOUNT_MESSAGE = " on %s from %s with Reservation #%s.";
    public static final String TRANSFER_FROM_GROUP_ACCOUNT_MESSAGE = " on %s from Group %s.";
    public static final String TRANSFER_FROM_COMPANY_ACCOUNT_MESSAGE = " on %s from A/R Account %s.";
    public static final String TRANSFER_TO_FOLIO_FROM_FOLIO_SAME_ACCOUNT =
          "Transferred to another folio on this " + "account.";
    public static final String TRANSFER_FROM_FOLIO_TO_FOLIO_SAME_ACCOUNT =
          "Transferred from another folio on this " + "account.";
    public static final String CORRECTION_MESSAGE = "Charge corrected by %s.";
    public static final String ADJUSTMENT_MESSAGE = "Charge adjusted by %s from %s to %s";
}
