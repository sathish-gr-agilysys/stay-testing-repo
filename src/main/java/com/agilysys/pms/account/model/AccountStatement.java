/*
 * (C) 2017 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class AccountStatement {
    private Balance balance;
    private Map<String, Balance> folioBalances;

    public AccountStatement() {
        balance = new Balance();
        folioBalances = new HashMap<>();
    }

    public AccountStatement(Balance balance, Map<String, Balance> folioBalances) {
        this.balance = balance;
        this.folioBalances = folioBalances;
    }

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

    public BigDecimal getFolioTotal(String folioId) {
        return Optional.ofNullable(folioBalances.get(folioId)).map(Balance::getTotal).orElse(BigDecimal.ZERO);
    }
}
