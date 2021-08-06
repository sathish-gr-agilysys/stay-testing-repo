/**
 * (C) 2013 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import org.joda.time.DateTime;

import com.agilysys.platform.common.json.schema.MaxLengthRestriction;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Summary model of folios
 *
 * @see <a href="http://confluence.bellevue.ad.local:8090/display/VICTRIAL/Folio+Model">Confluence: Folio Model</a>
 */
@JsonIgnoreProperties({
      "totalCharges",
      "totalTaxes",
      "totalBalance",
      "formattedTotalCharges",
      "formattedTotalTaxes",
      "formattedTotalBalance" })
public class FolioSummary {
    private String id;
    private boolean defaultFolio;
    private FolioType folioType;

    @MaxLengthRestriction(50)
    @JsonProperty(required = true)
    private String name;

    private String paymentSettingId;

    private Boolean depositFolio;

    private DateTime emailLastSent;
    private boolean balanceSettled;

    public FolioSummary() {}

    public FolioSummary(boolean defaultFolio, FolioType folioType, String name, String paymentSettingId) {
        this.defaultFolio = defaultFolio;
        this.folioType = folioType;
        this.name = name;
        this.paymentSettingId = paymentSettingId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    /**
     * Check for folio default status
     *
     * @return True if folio is the default, false otherwise
     */
    public boolean isDefaultFolio() {
        return defaultFolio;
    }

    /**
     * Set folio as default or non-default
     *
     * @param defaultFolio
     */
    public void setDefaultFolio(boolean defaultFolio) {
        this.defaultFolio = defaultFolio;
    }

    public FolioType getFolioType() {
        return folioType;
    }

    public void setFolioType(FolioType folioType) {
        this.folioType = folioType;
    }

    /**
     * Get folio name
     *
     * @return folio name
     */
    public String getName() {
        return name;
    }

    /**
     * Set folio name
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the payment setting id
     *
     * @return the payment setting id
     */
    public String getPaymentSettingId() {
        return paymentSettingId;
    }

    /**
     * Set the payment setting id
     *
     * @param paymentSettingId the payment setting id
     */
    public void setPaymentSettingId(String paymentSettingId) {
        this.paymentSettingId = paymentSettingId;
    }

    public Boolean getDepositFolio() {
        return depositFolio;
    }

    public void setDepositFolio(Boolean depositFolio) {
        this.depositFolio = depositFolio;
    }

    public DateTime getEmailLastSent() {
        return emailLastSent;
    }

    public void setEmailLastSent(DateTime emailLastSent) {
        this.emailLastSent = emailLastSent;
    }

    public boolean isBalanceSettled() {
        return balanceSettled;
    }

    public void setBalanceSettled(boolean balanceSettled) {
        this.balanceSettled = balanceSettled;
    }
}
