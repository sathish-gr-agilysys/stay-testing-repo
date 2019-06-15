/**
 * (C) 2013 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.util.List;
import java.util.Set;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.joda.time.LocalDate;

import com.agilysys.platform.common.json.schema.MaxLengthRestriction;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Contains information on what should happen to a charge when it is posted to an account This is the view model for
 * PostingRule
 * <p/>
 * Object dictionary page: http://confluence.bellevue.ad.local/display/VICTRIAL/PostingRule+Object
 */
public class PostingRuleDetail {
    private String id;

    @JsonProperty(required = true)
    @NotNull
    private String ruleName;

    private String chargeSourceId;
    private Set<String> categoryIds;
    private String subcategoryId;
    private Set<String> itemIds;

    @Deprecated
    private String destinationFolioId;
    private String splitBy;

    @Deprecated
    private String destinationAccountId;
    private List<DestinationDetail> destinations;

    @JsonProperty(required = true)
    @NotNull
    private LocalDate startDate;

    @JsonProperty(required = true)
    @NotNull
    private LocalDate endDate;

    private Boolean applyToAllPostedCharges;
    private Boolean ignoreDestinationRules;

    @MaxLengthRestriction(250)
    @Size(max = 250)
    private String reason;

    private String description;
    private Integer priority;

    //Used for group accounts to signify who the rule applies to (null means the account itself, empty means everyone)
    private Set<String> includedAccountIds;

    public PostingRuleDetail() { }

    @Deprecated
    public String getDestinationAccountId() {
        return destinationAccountId;
    }

    @Deprecated
    public void setDestinationAccountId(String destinationAccountId) {
        this.destinationAccountId = destinationAccountId;
    }

    @Deprecated
    public String getDestinationFolioId() {
        return destinationFolioId;
    }

    @Deprecated
    public void setDestinationFolioId(String destinationFolioId) {
        this.destinationFolioId = destinationFolioId;
    }

    public String getRuleName() {
        return ruleName;
    }

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }

    public String getChargeSourceId() {
        return chargeSourceId;
    }

    public void setChargeSourceId(String chargeSourceId) {
        this.chargeSourceId = chargeSourceId;
    }

    public Set<String> getCategoryIds() {
        return categoryIds;
    }

    public void setCategoryIds(Set<String> categoryIds) {
        this.categoryIds = categoryIds;
    }

    public String getSubcategoryId() {
        return subcategoryId;
    }

    public void setSubcategoryId(String subcategoryId) {
        this.subcategoryId = subcategoryId;
    }

    public Set<String> getItemIds() {
        return itemIds;
    }

    public void setItemIds(Set<String> itemIds) {
        this.itemIds = itemIds;
    }

    public String getSplitBy() { return splitBy; }

    public void setSplitBy(String splitBy) { this.splitBy = splitBy; }

    public List<DestinationDetail> getDestinations() { return destinations; }

    public void setDestinations(List<DestinationDetail> destinations) { this.destinations = destinations; }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Boolean getApplyToAllPostedCharges() {
        return applyToAllPostedCharges;
    }

    public void setApplyToAllPostedCharges(Boolean applyToAllPostedCharges) {
        this.applyToAllPostedCharges = applyToAllPostedCharges;
    }

    public Boolean getIgnoreDestinationRules() {
        return ignoreDestinationRules;
    }

    public void setIgnoreDestinationRules(Boolean ignoreDestinationRules) {
        this.ignoreDestinationRules = ignoreDestinationRules;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Set<String> getIncludedAccountIds() {
        return includedAccountIds;
    }

    public void setIncludedAccountIds(Set<String> includedAccountIds) {
        this.includedAccountIds = includedAccountIds;
    }
}