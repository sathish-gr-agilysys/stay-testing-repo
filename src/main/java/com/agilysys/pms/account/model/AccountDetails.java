package com.agilysys.pms.account.model;

import java.util.List;

public class AccountDetails {
    List<String> accountNames;
    List<String> confCodes;

    public AccountDetails(List<String> accountNames, List<String> confCodes) {
        this.accountNames = accountNames;
        this.confCodes = confCodes;
    }

    public AccountDetails() {}

    public List<String> getAccountNames() {
        return accountNames;
    }

    public void setAccountNames(List<String> accountNames) {
        this.accountNames = accountNames;
    }

    public List<String> getConfCodes() {
        return confCodes;
    }

    public void setConfCodes(List<String> confCodes) {
        this.confCodes = confCodes;
    }
}
