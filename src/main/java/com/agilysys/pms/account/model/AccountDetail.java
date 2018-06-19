/**
 * (C) 2013 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.util.List;

/**
 * Detailed model of an Account
 *
 * @see <a
 * href="">http://confluence.bellevue.ad.local:8090/display/VICTRIAL/Account+Document</a>
 */
public class AccountDetail extends AccountSummary {
    private List<FolioSummary> folios;

    /**
     * Get folios
     *
     * @return List of folios
     */
    public List<FolioSummary> getFolios() {
        return folios;
    }

    /**
     * Set folios
     *
     * @param folioModels folios to set
     */
    public void setFolios(List<FolioSummary> folioModels) {
        this.folios = folioModels;
    }
}
