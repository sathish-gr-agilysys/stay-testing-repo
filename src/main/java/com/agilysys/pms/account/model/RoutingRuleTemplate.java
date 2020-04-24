/*
 * (C) 2020 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.util.List;
import java.util.Set;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.joda.time.LocalDate;

import com.agilysys.platform.common.json.schema.MaxLengthRestriction;
import com.fasterxml.jackson.annotation.JsonProperty;

public class RoutingRuleTemplate {
    private String id;

    @JsonProperty(required = true)
    @NotNull
    private String ruleName;

    private String description;

    @JsonProperty(required = true)
    @NotNull
    private LocalDate startDate;

    @JsonProperty(required = true)
    @NotNull
    private LocalDate endDate;

    private Boolean includeArrivalDate;

    private Boolean includeDepartureDate;

    private DaysOfWeek daysOfWeek;

    private Boolean comp;

    private String departmentId;

    private List<String> authorizers;

    private OffSetRule offsetRule;

    private Boolean pinRequired;

    private Boolean compingTax;

    private String sourceId;

    private Set<String> categoryIds;

    private Set<String> itemIds;

    private PostingRuleSplitBy postingRuleSplitBy;

    private PostingRuleChargeType postingRuleChargeType;

    private List<DestinationDetail> destinationDetails;

    @MaxLengthRestriction(250)
    @Size(max = 250)
    private String reasons;

    private Boolean ignoreDestinationRule;

    private Boolean carryForwardBalance;

    public RoutingRuleTemplate() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRuleName() {
        return ruleName;
    }

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

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

    public Boolean getIncludeArrivalDate() {
        return includeArrivalDate;
    }

    public void setIncludeArrivalDate(Boolean includeArrivalDate) {
        this.includeArrivalDate = includeArrivalDate;
    }

    public Boolean getIncludeDepartureDate() {
        return includeDepartureDate;
    }

    public void setIncludeDepartureDate(Boolean includeDepartureDate) {
        this.includeDepartureDate = includeDepartureDate;
    }

    public DaysOfWeek getDaysOfWeek() {
        return daysOfWeek;
    }

    public void setDaysOfWeek(DaysOfWeek daysOfWeek) {
        this.daysOfWeek = daysOfWeek;
    }

    public Boolean getComp() {
        return comp;
    }

    public void setComp(Boolean comp) {
        this.comp = comp;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public List<String> getAuthorizers() {
        return authorizers;
    }

    public void setAuthorizers(List<String> authorizers) {
        this.authorizers = authorizers;
    }

    public OffSetRule getOffsetRule() {
        return offsetRule;
    }

    public void setOffsetRule(OffSetRule offsetRule) {
        this.offsetRule = offsetRule;
    }

    public Boolean getPinRequired() {
        return pinRequired;
    }

    public void setPinRequired(Boolean pinRequired) {
        this.pinRequired = pinRequired;
    }

    public Boolean getCompingTax() {
        return compingTax;
    }

    public void setCompingTax(Boolean compingTax) {
        this.compingTax = compingTax;
    }

    public String getSourceId() {
        return sourceId;
    }

    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    public Set<String> getCategoryIds() {
        return categoryIds;
    }

    public void setCategoryIds(Set<String> categoryIds) {
        this.categoryIds = categoryIds;
    }

    public Set<String> getItemIds() {
        return itemIds;
    }

    public void setItemIds(Set<String> itemIds) {
        this.itemIds = itemIds;
    }

    public PostingRuleSplitBy getPostingRuleSplitBy() {
        return postingRuleSplitBy;
    }

    public void setPostingRuleSplitBy(PostingRuleSplitBy postingRuleSplitBy) {
        this.postingRuleSplitBy = postingRuleSplitBy;
    }

    public PostingRuleChargeType getPostingRuleChargeType() {
        return postingRuleChargeType;
    }

    public void setPostingRuleChargeType(PostingRuleChargeType postingRuleChargeType) {
        this.postingRuleChargeType = postingRuleChargeType;
    }

    public List<DestinationDetail> getDestinationDetails() {
        return destinationDetails;
    }

    public void setDestinationDetails(List<DestinationDetail> destinationDetails) {
        this.destinationDetails = destinationDetails;
    }

    public String getReasons() {
        return reasons;
    }

    public void setReasons(String reasons) {
        this.reasons = reasons;
    }

    public Boolean getIgnoreDestinationRule() {
        return ignoreDestinationRule;
    }

    public void setIgnoreDestinationRule(Boolean ignoreDestinationRule) {
        this.ignoreDestinationRule = ignoreDestinationRule;
    }

    public Boolean getCarryForwardBalance() {
        return carryForwardBalance;
    }

    public void setCarryForwardBalance(Boolean carryForwardBalance) {
        this.carryForwardBalance = carryForwardBalance;
    }
}
