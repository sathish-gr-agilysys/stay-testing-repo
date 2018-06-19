package com.agilysys.pms.account.model;

import java.util.Map;
import java.util.Set;

import com.google.common.collect.Sets;

public class PayoffBalanceRequest {
    private String terminalId;
    private Set<String> paymentSettingIds = Sets.newHashSet();
    private boolean allowBalance = false;
    private String reservationConfirmationCode;
    private String guestName;
    private Map<String, String> companyNameMap;
    private boolean useDefaultFolioPaymentSettings;

    public PayoffBalanceRequest() {}

    public PayoffBalanceRequest(String terminalId, Set<String> paymentSettingIds, boolean allowBalance) {
        this.terminalId = terminalId;
        this.paymentSettingIds = paymentSettingIds;
        this.allowBalance = allowBalance;
    }

    public String getTerminalId() {
        return terminalId;
    }

    public void setTerminalId(String terminalId) {
        this.terminalId = terminalId;
    }

    public Set<String> getPaymentSettingIds() {
        return paymentSettingIds;
    }

    public void setPaymentSettingIds(Set<String> paymentSettingIds) {
        this.paymentSettingIds = paymentSettingIds;
    }

    public boolean isAllowBalance() {
        return allowBalance;
    }

    public void setAllowBalance(boolean allowBalance) {
        this.allowBalance = allowBalance;
    }

    public String getReservationConfirmationCode() {
        return reservationConfirmationCode;
    }

    public void setReservationConfirmationCode(String reservationConfirmationCode) {
        this.reservationConfirmationCode = reservationConfirmationCode;
    }

    public String getGuestName() {
        return guestName;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    public Map<String, String> getCompanyNameMap() {
        return companyNameMap;
    }

    public void setCompanyNameMap(Map<String, String> companyNameMap) {
        this.companyNameMap = companyNameMap;
    }

    public boolean isUseDefaultFolioPaymentSettings() {
        return useDefaultFolioPaymentSettings;
    }

    public void setUseDefaultFolioPaymentSettings(boolean useDefaultFolioPaymentSettings) {
        this.useDefaultFolioPaymentSettings = useDefaultFolioPaymentSettings;
    }
}
