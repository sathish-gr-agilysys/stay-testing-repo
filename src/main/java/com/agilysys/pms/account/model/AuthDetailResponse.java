package com.agilysys.pms.account.model;

import java.util.Map;

public class AuthDetailResponse {
    private Map<String, AuthDetails> authDetailsByPaymentSetting;

    public Map<String, AuthDetails> getAuthDetailsByPaymentSetting() {
        return authDetailsByPaymentSetting;
    }

    public void setAuthDetailsByPaymentSetting(Map<String, AuthDetails> authDetailsByPaymentSetting) {
        this.authDetailsByPaymentSetting = authDetailsByPaymentSetting;
    }
}
