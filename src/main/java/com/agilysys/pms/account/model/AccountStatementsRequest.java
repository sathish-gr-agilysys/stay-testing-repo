/**
 * (C) 2017 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.util.Map;
import java.util.Set;

import org.joda.time.LocalDate;

public class AccountStatementsRequest {

    private Map<String, String> accountIdsReservationCodes;

    private LocalDate propertyDate;

    private Set<String> accountIds;

    private Map<String, Charge> accountsChargesMap;

    public Map<String, String> getAccountIdsReservationCodes() {
        return accountIdsReservationCodes;
    }

    public void setAccountIdsReservationCodes(Map<String, String> accountIdsReservationCodes) {
        this.accountIdsReservationCodes = accountIdsReservationCodes;
    }

    public LocalDate getPropertyDate() {
        return propertyDate;
    }

    public void setPropertyDate(LocalDate propertyDate) {
        this.propertyDate = propertyDate;
    }

    public Set<String> getAccountIds() {
        return accountIds;
    }

    public void setAccountIds(Set<String> accountIds) {
        this.accountIds = accountIds;
    }

    public Map<String, Charge> getAccountsChargesMap() {
        return accountsChargesMap;
    }

    public void setAccountsChargesMap(Map<String, Charge> accountsChargesMap) {
        this.accountsChargesMap = accountsChargesMap;
    }
}
