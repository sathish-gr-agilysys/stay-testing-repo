/*
 * (C) 2014 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model.payagent;

public enum PayActionType {
    CHECK_IN_DEFAULT_FOLIO,
    CHECK_IN_NON_DEFAULT_FOLIO,
    ADD_PAYMENT_METHOD,
    BOOK,
    MAKE_PAYMENT,
    CHECK_OUT_NEW_CARD,
    CREDIT_NEW_CARD  //?? should this be allowed
}
