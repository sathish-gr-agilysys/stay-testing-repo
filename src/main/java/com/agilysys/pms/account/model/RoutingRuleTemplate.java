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

    @JsonProperty(required = true)
    @NotNull
    private String description;

    @JsonProperty(required = true)
    @NotNull
    private LocalDate startDate;

    private LocalDate endDate;

    private Boolean includeArrivalDate;

    private Boolean includeDepartureDate;

    private List<Integer> occurrenceDays;

    private Boolean comp;

    private String departmentId;

    private List<String> authorizerIds;

    private OffSetRule offSetRule;

    private Boolean pinRequired;

    private Boolean compingTax;

    @JsonProperty(required = true)
    @NotNull
    private String sourceId;

    private Set<String> categoryIds;

    private Set<String> itemIds;

    private PostingRuleSplitBy splitBy;

    @JsonProperty(required = true)
    @NotNull
    private PostingRuleChargeType postingRuleChargeType;

    private List<DestinationDetail> destinations;

    @MaxLengthRestriction(250)
    @Size(max = 250)
    private String reason;

    private Boolean ignoreDestinationRules;

    private Boolean carryUnusedBalance;

    private DepositDestinationDetail depositDestinationDetail;

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

    public List<Integer> getOccurrenceDays() {
        return occurrenceDays;
    }

    public void setOccurrenceDays(List<Integer> occurrenceDays) {
        this.occurrenceDays = occurrenceDays;
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

    public List<String> getAuthorizerIds() {
        return authorizerIds;
    }

    public void setAuthorizerIds(List<String> authorizerIds) {
        this.authorizerIds = authorizerIds;
    }

    public OffSetRule getOffSetRule() {
        return offSetRule;
    }

    public void setOffSetRule(OffSetRule offSetRule) {
        this.offSetRule = offSetRule;
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

    public PostingRuleSplitBy getSplitBy() {
        return splitBy;
    }

    public void setSplitBy(PostingRuleSplitBy splitBy) {
        this.splitBy = splitBy;
    }

    public PostingRuleChargeType getPostingRuleChargeType() {
        return postingRuleChargeType;
    }

    public void setPostingRuleChargeType(PostingRuleChargeType postingRuleChargeType) {
        this.postingRuleChargeType = postingRuleChargeType;
    }

    public List<DestinationDetail> getDestinations() {
        return destinations;
    }

    public void setDestinations(List<DestinationDetail> destinations) {
        this.destinations = destinations;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Boolean getIgnoreDestinationRules() {
        return ignoreDestinationRules;
    }

    public void setIgnoreDestinationRules(Boolean ignoreDestinationRules) {
        this.ignoreDestinationRules = ignoreDestinationRules;
    }

    public Boolean getCarryUnusedBalance() {
        return carryUnusedBalance;
    }

    public void setCarryUnusedBalance(Boolean carryUnusedBalance) {
        this.carryUnusedBalance = carryUnusedBalance;
    }

    public DepositDestinationDetail getDepositDestinationDetail() {
        return depositDestinationDetail;
    }

    public void setDepositDestinationDetail(DepositDestinationDetail depositDestinationDetail) {
        this.depositDestinationDetail = depositDestinationDetail;
    }
}
