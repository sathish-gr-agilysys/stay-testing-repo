package com.agilysys.pms.account.model;

import com.agilysys.pms.common.model.annotation.DataPortAuto;
import com.agilysys.pms.common.model.annotation.DataPortId;
import com.agilysys.pms.common.model.annotation.DataPortKey;
import com.fasterxml.jackson.annotation.JsonProperty;

public class LedgerSettingView {
    @DataPortId
    private String id;

    @DataPortAuto
    private String tenantId;

    @DataPortAuto
    private String propertyId;

    @JsonProperty(required = true)
    @DataPortKey
    private String ledgerType;

    private String code;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public String getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(String propertyId) {
        this.propertyId = propertyId;
    }

    public String getLedgerType() {
        return ledgerType;
    }

    public void setLedgerType(String ledgerType) {
        this.ledgerType = ledgerType;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

}
