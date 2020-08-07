/**
 * (C) 2018 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

public class TenantARTaxExemptSettings {
    private boolean applyToExistingReservations;
    private String taxId;
    private boolean protectTaxSettings;

    public TenantARTaxExemptSettings() {
    }

    public TenantARTaxExemptSettings(String taxId) {
        this.taxId = taxId;
    }

    public TenantARTaxExemptSettings(boolean applyToExistingReservations, String taxId, boolean protectTaxSettings) {
        this.applyToExistingReservations = applyToExistingReservations;
        this.taxId = taxId;
        this.protectTaxSettings = protectTaxSettings;
    }

    public boolean isApplyToExistingReservations() {
        return applyToExistingReservations;
    }

    public void setApplyToExistingReservations(boolean applyToExistingReservations) {
        this.applyToExistingReservations = applyToExistingReservations;
    }

    public String getTaxId() {
        return taxId;
    }

    public void setTaxId(String taxId) {
        this.taxId = taxId;
    }

    public boolean isProtectTaxSettings() {
        return protectTaxSettings;
    }

    public void setProtectTaxSettings(boolean protectTaxSettings) {
        this.protectTaxSettings = protectTaxSettings;
    }
}
