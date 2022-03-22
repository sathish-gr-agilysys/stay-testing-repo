/*
 * (C) 2022 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.util.Map;

import com.agilysys.pms.common.model.ObjectBase;

public class TaxSummaryConfigSettings extends ObjectBase {
    private Map<String, String> fields;
    private String totalFieldName;

    public TaxSummaryConfigSettings() {
    }

    public TaxSummaryConfigSettings(Map<String, String> fields, String totalFieldName) {
        this.fields = fields;
        this.totalFieldName = totalFieldName;
    }

    public Map<String, String> getFields() {
        return fields;
    }

    public void setFields(Map<String, String> fields) {
        this.fields = fields;
    }

    public String getTotalFieldName() {
        return totalFieldName;
    }

    public void setTotalFieldName(String totalFieldName) {
        this.totalFieldName = totalFieldName;
    }
}
