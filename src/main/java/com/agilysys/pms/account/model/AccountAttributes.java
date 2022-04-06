/**
 * (C) 2018 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import static org.apache.commons.lang3.StringUtils.equalsIgnoreCase;
import static org.apache.commons.lang3.StringUtils.trimToEmpty;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import com.agilysys.pms.common.model.ThirdPartyConfirmation;

import org.apache.commons.lang3.StringUtils;

public class AccountAttributes implements Comparable<AccountAttributes> {

    public static final String PREFERRED_COMMUNICATION_FIELD = "preferredCommunication";

    private String accountContactId;
    private PreferredCommunication preferredCommunication;
    private AccountStatus status;
    private String comment;
    private BigDecimal creditLimit;
    private int terms;
    private DefaultRoutingRule routingRule;
    private TenantARTaxExemptSettings taxExemptSettings;
    private boolean showSelectedThirdPartyConfirmation;
    private Set<ThirdPartyConfirmation> selectedThirdPartyConfirmations;

    public AccountAttributes() {
    }

    public AccountAttributes(String accountContactId, PreferredCommunication preferredCommunication,
          AccountStatus status, BigDecimal creditLimit, int terms, DefaultRoutingRule routingRule,
          TenantARTaxExemptSettings taxExemptSettings, boolean showSelectedThirdPartyConfirmation,
          Set<ThirdPartyConfirmation> selectedThirdPartyConfirmations) {
        this(accountContactId, preferredCommunication, status, null, creditLimit, terms, routingRule, taxExemptSettings,
              showSelectedThirdPartyConfirmation, selectedThirdPartyConfirmations);
    }

    public AccountAttributes(String accountContactId, PreferredCommunication preferredCommunication,
          AccountStatus status, String comment, BigDecimal creditLimit, int terms, DefaultRoutingRule routingRule,
          TenantARTaxExemptSettings taxExemptSettings, boolean showSelectedThirdPartyConfirmation,
          Set<ThirdPartyConfirmation> selectedThirdPartyConfirmations) {
        this.accountContactId = accountContactId;
        this.preferredCommunication = preferredCommunication;
        this.status = status;
        this.comment = comment;
        this.creditLimit = creditLimit;
        this.terms = terms;
        this.routingRule = routingRule;
        this.taxExemptSettings = taxExemptSettings;
        this.showSelectedThirdPartyConfirmation = showSelectedThirdPartyConfirmation;
        this.selectedThirdPartyConfirmations = selectedThirdPartyConfirmations;
    }

    public enum AccountStatus {
        PENDING,
        OPEN,
        HOLD,
        CLOSED
    }

    public enum PreferredCommunication {
        Email,
        Print
    }

    public enum DefaultRoutingRule {
        ALL_CHARGES,
        NO_CHARGES,
        ROOM_AND_TAX,
        THIRD_PARTY_PAYMENTS
    }

    public String getAccountContactId() {
        return accountContactId;
    }

    public void setAccountContactId(String accountContactId) {
        this.accountContactId = accountContactId;
    }

    public PreferredCommunication getPreferredCommunication() {
        return preferredCommunication;
    }

    public void setPreferredCommunication(PreferredCommunication preferredCommunication) {
        this.preferredCommunication = preferredCommunication;
    }

    public void setStatus(AccountStatus status) {
        this.status = status;
    }

    public AccountStatus getStatus() {
        return status;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public BigDecimal getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(BigDecimal creditLimit) {
        this.creditLimit = creditLimit;
    }

    public int getTerms() {
        return terms;
    }

    public void setTerms(int terms) {
        this.terms = terms;
    }

    public DefaultRoutingRule getRoutingRule() {
        return routingRule;
    }

    public void setRoutingRule(DefaultRoutingRule routingRule) {
        this.routingRule = routingRule;
    }

    public TenantARTaxExemptSettings getTaxExemptSettings() {
        return taxExemptSettings;
    }

    public void setTaxExemptSettings(TenantARTaxExemptSettings taxExemptSettings) {
        this.taxExemptSettings = taxExemptSettings;
    }

    public boolean isShowSelectedThirdPartyConfirmation() {
        return showSelectedThirdPartyConfirmation;
    }

    public void setShowSelectedThirdPartyConfirmation(boolean showSelectedThirdPartyConfirmation) {
        this.showSelectedThirdPartyConfirmation = showSelectedThirdPartyConfirmation;
    }

    public Set<ThirdPartyConfirmation> getSelectedThirdPartyConfirmations() {
        return selectedThirdPartyConfirmations;
    }

    public void setSelectedThirdPartyConfirmations(Set<ThirdPartyConfirmation> selectedThirdPartyConfirmations) {
        this.selectedThirdPartyConfirmations = selectedThirdPartyConfirmations;
    }

    @Override
    public int compareTo(AccountAttributes that) {
        boolean isEqual =
              StringUtils.equals(this.getAccountContactId(), that.getAccountContactId()) && this.getStatus() != null &&
                    that.getStatus() != null && StringUtils.equals(this.getStatus().name(), that.getStatus().name()) &&
                    this.getPreferredCommunication() != null && that.getPreferredCommunication() != null && StringUtils
                    .equals(this.getPreferredCommunication().name(), that.getPreferredCommunication().name()) &&
                    this.getCreditLimit().compareTo(that.getCreditLimit()) == 0 && this.getTerms() == that.getTerms() &&
                    compareRoutingRule(this.getRoutingRule(), that.getRoutingRule()) &&
                    compareTaxExemptSettings(this.getTaxExemptSettings(), that.getTaxExemptSettings()) &&
                    this.isShowSelectedThirdPartyConfirmation() == that.isShowSelectedThirdPartyConfirmation() &&
                    compareSelectedThirdPartyConfirmations(this.getSelectedThirdPartyConfirmations(),
                          that.getSelectedThirdPartyConfirmations());
        if (isEqual) {
            return 0;
        }
        else {
            return 1;
        }
    }

    private boolean compareRoutingRule(DefaultRoutingRule defaultSettings, DefaultRoutingRule existingSettings) {
        if (defaultSettings == null && existingSettings == null) {
            return true;
        }
        return equalsIgnoreCase(defaultSettings.name(), existingSettings.name());
    }

    private boolean compareTaxExemptSettings(TenantARTaxExemptSettings defaultSettings,
          TenantARTaxExemptSettings existingSettings) {
        if (defaultSettings == null && existingSettings == null) {
            return true;
        }
        return equalsIgnoreCase(defaultSettings.getTaxId(), trimToEmpty(existingSettings.getTaxId()));
    }

    public boolean compareSelectedThirdPartyConfirmations(Set<ThirdPartyConfirmation> defaultSettings,
          Set<ThirdPartyConfirmation> existingSettings) {
        if (defaultSettings == null && existingSettings == null) {
            return true;
        }

        if (defaultSettings.size() != existingSettings.size()) {
            return false;
        }

        Set<String> existingSettingsConfirmationNames = new HashSet<String>();

        for (ThirdPartyConfirmation existingSetting : existingSettings) {
            existingSettingsConfirmationNames.add(existingSetting.getConfirmationName());
        }

        for (ThirdPartyConfirmation defaultSetting : defaultSettings) {
            if (!existingSettingsConfirmationNames.contains(defaultSetting.getConfirmationName())){
                return false;
            } 
        }
        return true;
    }
}
