/*
 * (C) 2021 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import static com.agilysys.pms.payment.model.StoredCredTransactionType.NoShow;
import static com.agilysys.pms.payment.model.StoredCredTransactionType.None;
import static com.agilysys.pms.payment.model.StoredCredTransactionType.UnscheduledCOFInitial;
import static com.agilysys.pms.payment.model.StoredCredTransactionType.UnscheduledCOFSubsequent;

import com.agilysys.pms.payment.model.StoredCredTransactionType;

public enum PaymentFlowType {
    Create_Token(None, None),
    Deposit_Payment(UnscheduledCOFInitial, None),
    Check_In_Auth(UnscheduledCOFSubsequent, UnscheduledCOFInitial),
    In_house_Auth(UnscheduledCOFSubsequent, UnscheduledCOFInitial),
    In_house_Payment(UnscheduledCOFSubsequent, UnscheduledCOFInitial),
    No_Show_Payment(NoShow, None),
    Cancellation_Payment(UnscheduledCOFSubsequent, None),
    Delayed_Payment(UnscheduledCOFSubsequent, None),
    Refund(None, None);

    private StoredCredTransactionType scmType;
    private StoredCredTransactionType fallbackScmType;

    PaymentFlowType(StoredCredTransactionType scmType, StoredCredTransactionType fallbackScmType) {
        this.scmType = scmType;
        this.fallbackScmType = fallbackScmType;
    }

    public StoredCredTransactionType getScmType(String scmValue) {
        if (!this.scmType.isValid(scmValue)) {
            return this.fallbackScmType;
        }
        return this.scmType;
    }
}
