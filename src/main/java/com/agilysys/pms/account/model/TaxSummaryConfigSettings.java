/*
 * (C) 2022 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.util.List;

import com.agilysys.pms.common.model.ObjectBase;

public class TaxSummaryConfigSettings extends ObjectBase {
    private List<TaxSummaryConfigurationMappings> fields;
    private String totalFieldName;

    public TaxSummaryConfigSettings() {
    }

    public TaxSummaryConfigSettings(String id) {
        super(id);
    }

    public TaxSummaryConfigSettings(List<TaxSummaryConfigurationMappings> fields, String totalFieldName) {
        this.fields = fields;
        this.totalFieldName = totalFieldName;
    }

    public String getTotalFieldName() {
        return totalFieldName;
    }

    public void setTotalFieldName(String totalFieldName) {
        this.totalFieldName = totalFieldName;
    }

    public List<TaxSummaryConfigurationMappings> getFields() {return fields;}

    public void setFields(List<TaxSummaryConfigurationMappings> fields) {
        this.fields = fields;
    }
}
