/**
 * (C) 2013 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Detailed model of folios
 *
 * @see <a
 * href="http://confluence.bellevue.ad.local:8090/display/VICTRIAL/Folio+Model">Confluence:
 * Folio Mode</a>
 */
@JsonIgnoreProperties({
      "totalCharges",
      "totalTaxes",
      "totalBalance",
      "formattedTotalCharges",
      "formattedTotalTaxes",
      "formattedTotalBalance" })
public class FolioDetail extends FolioSummary {
    private List<LineItemView> lineItems;

    /**
     * Get line item views
     *
     * @return List of line item views
     */
    public List<LineItemView> getLineItems() {
        return lineItems;
    }

    /**
     * Set line item views
     *
     * @param lineItems List of line item views to set
     */
    public void setLineItems(List<LineItemView> lineItems) {
        this.lineItems = lineItems;
    }
}
