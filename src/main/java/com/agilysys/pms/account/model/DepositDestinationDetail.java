/*
 * (C) 2022 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

public class DepositDestinationDetail {

    private String accountId;

    private String folioId;

    private boolean routeDeposit;

    public DepositDestinationDetail() {}

    public DepositDestinationDetail(String accountId, String folioId) {
        this.accountId = accountId;
        this.folioId = folioId;
    }

    public DepositDestinationDetail(String accountId, String folioId, boolean routeDeposit) {
        this(accountId, folioId);
        this.routeDeposit = routeDeposit;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getFolioId() {
        return folioId;
    }

    public void setFolioId(String folioId) {
        this.folioId = folioId;
    }

    public boolean isRouteDeposit() {
        return routeDeposit;
    }

    public void setRouteDeposit(boolean routeDeposit) {
        this.routeDeposit = routeDeposit;
    }
}
