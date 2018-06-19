package com.agilysys.pms.account.model;

import java.util.List;

public class AuthDetails {
    private EstimatedChargesSummaryView estimatedCharges;

    private AuthSummary authSummary;

    private String paymentSettingId;

    private boolean defaultPaymentSetting;

    private boolean thirdParty;

    List<FolioDetail> associatedFolios;

    private String paymentInstrumentId;

    public EstimatedChargesSummaryView getEstimatedCharges() {
        return estimatedCharges;
    }

    public void setEstimatedCharges(EstimatedChargesSummaryView estimatedCharges) {
        this.estimatedCharges = estimatedCharges;
    }

    public boolean isDefaultPaymentSetting() {
        return defaultPaymentSetting;
    }

    public void setDefaultPaymentSetting(boolean defaultPaymentSetting) {
        this.defaultPaymentSetting = defaultPaymentSetting;
    }

    public boolean isThirdParty() {
        return thirdParty;
    }

    public void setThirdParty(boolean thirdParty) {
        this.thirdParty = thirdParty;
    }

    public List<FolioDetail> getAssociatedFolios() {
        return associatedFolios;
    }

    public void setAssociatedFolios(List<FolioDetail> associatedFolios) {
        this.associatedFolios = associatedFolios;
    }

    public AuthSummary getAuthSummary() {
        return authSummary;
    }

    public void setAuthSummary(AuthSummary authSummary) {
        this.authSummary = authSummary;
    }

    public String getPaymentSettingId() {
        return paymentSettingId;
    }

    public void setPaymentSettingId(String paymentSettingId) {
        this.paymentSettingId = paymentSettingId;
    }

    public String getPaymentInstrumentId() {
        return paymentInstrumentId;
    }

    public void setPaymentInstrumentId(String paymentInstrumentId) {
        this.paymentInstrumentId = paymentInstrumentId;
    }
}
