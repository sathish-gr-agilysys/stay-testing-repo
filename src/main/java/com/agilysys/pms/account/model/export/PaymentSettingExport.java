/**
 * (C) 2016 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model.export;

import com.agilysys.pms.common.model.annotation.export.ReportingExportRef;
import com.agilysys.pms.common.model.export.ExportDB;
import com.agilysys.pms.common.model.export.ExportRef;

public class PaymentSettingExport extends com.agilysys.common.model.export.PaymentSettingExport {
    @Override
    @ReportingExportRef(ref = ExportRef.PAYMENT_INSTRUMENTS, db = ExportDB.RGUEST_STAY)
    public String getPaymentInstrumentId() {
        return super.getPaymentInstrumentId();
    }
}