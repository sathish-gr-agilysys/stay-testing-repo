/**
 * (C) 2017 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.util.HashMap;
import java.util.Map;

public class AccountStatement {

    private Balance balance;

    private Map<String, Balance> folioBalances = new HashMap<>();

    public Balance getBalance() {
        return balance;
    }

    public void setBalance(Balance balance) {
        this.balance = balance;
    }

    public Map<String, Balance> getFolioBalances() {
        return folioBalances;
    }

    public void setFolioBalances(Map<String, Balance> folioBalances) {
        this.folioBalances = folioBalances;
    }
}
