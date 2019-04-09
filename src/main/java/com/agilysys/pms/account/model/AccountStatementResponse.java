/**
 * (C) 2017 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.util.HashMap;
import java.util.Map;

public class AccountStatementResponse {

    private Map<String, AccountStatement> accountStatementMap = new HashMap<>();

    public Map<String, AccountStatement> getAccountStatementMap() {
        return accountStatementMap;
    }

    public void setAccountStatementMap(Map<String, AccountStatement> accountStatementMap) {
        this.accountStatementMap = accountStatementMap;
    }
}
