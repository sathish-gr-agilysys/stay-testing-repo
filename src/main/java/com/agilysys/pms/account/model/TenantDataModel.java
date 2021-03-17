/*
 * (C) 2021 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import com.agilysys.pms.property.model.Address;

public class TenantDataModel {

    private String id;
    private String tenantId;
    private Boolean deleted;
    private Address address;

    public TenantDataModel() {}

    public TenantDataModel(String tenantId, Boolean deleted, Address address) {
        this.tenantId = tenantId;
        this.deleted = deleted;
        this.address = address;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
