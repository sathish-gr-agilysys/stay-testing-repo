/**
 * (C) 2013 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import static org.apache.commons.collections.CollectionUtils.isNotEmpty;

import java.util.List;
import java.util.Set;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.joda.time.LocalDate;

import com.agilysys.platform.common.json.schema.MaxLengthRestriction;
import com.agilysys.pms.property.model.compaccounting.CompOffer;
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

    private String ratePlanName;

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

    private LocalDate startDate;
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

    private List<LocalDate> validOn;

    private Boolean includeArrivalDate;

    private Boolean includeDepartureDate;

    private List<Integer> occurrenceDays;

    private Boolean comp;

    private String departmentId;

    private String authorizerCode;

    private Boolean compingTax;

    private OffSetRule offSetRule;

    private Boolean pinRequired;

    private String postingRuleChargeType;

    private Boolean carryUnusedBalance;

    private String authorizerId;

    private String compOfferId;

    private Boolean routeChargesAlreadyPosted;

    private String ratePlanId;

    private DepositDestinationDetail depositDestinationDetail;

    private Boolean compRule;

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

    public String getRatePlanName() {
        return ratePlanName;
    }

    public void setRatePlanName(String ratePlanName) {
        this.ratePlanName = ratePlanName;
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

    public List<LocalDate> getValidOn() {
        return validOn;
    }

    public void setValidOn(List<LocalDate> validOn) {
        this.validOn = validOn;
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

    public String getAuthorizerCode() {
        return authorizerCode;
    }

    public void setAuthorizerCode(String authorizerCode) {
        this.authorizerCode = authorizerCode;
    }

    public Boolean getCompingTax() {
        return compingTax;
    }

    public void setCompingTax(Boolean compingTax) {
        this.compingTax = compingTax;
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

    public String getPostingRuleChargeType() {
        return postingRuleChargeType;
    }

    public void setPostingRuleChargeType(String postingRuleChargeType) {
        this.postingRuleChargeType = postingRuleChargeType;
    }

    public Boolean getCarryUnusedBalance() {
        return carryUnusedBalance;
    }

    public void setCarryUnusedBalance(Boolean carryUnusedBalance) {
        this.carryUnusedBalance = carryUnusedBalance;
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

    public String getAuthorizerId() {
        return authorizerId;
    }

    public void setAuthorizerId(String authorizerId) {
        this.authorizerId = authorizerId;
    }

    public String getCompOfferId() {
        return compOfferId;
    }

    public void setCompOfferId(String compOfferId) {
        this.compOfferId = compOfferId;
    }

    public String getRatePlanId() {
        return ratePlanId;
    }

    public void setRatePlanId(String ratePlanId) {
        this.ratePlanId = ratePlanId;
    }

    public DepositDestinationDetail getDepositDestinationDetail() {
        return depositDestinationDetail;
    }

    public void setDepositDestinationDetail(DepositDestinationDetail depositDestinationDetail) {
        this.depositDestinationDetail = depositDestinationDetail;
    }

    public Boolean getCompRule() {
        return compRule;
    }

    public void setCompRule(Boolean compRule) {
        this.compRule = compRule;
    }

    public PostingRuleDetail(RoutingRuleTemplate template, String ruleName, String ratePlanName,
          List<LocalDate> offerAppliedDates, LocalDate propertyDate, String authorizerCode, String authorizerId,
          String compOfferId) {
        this(template, ruleName, offerAppliedDates, propertyDate, authorizerCode, authorizerId, compOfferId);
        this.ratePlanName = ratePlanName;
    }

    public PostingRuleDetail(RoutingRuleTemplate template, String ruleName, List<LocalDate> offerAppliedDates,
          LocalDate propertyDate, String authorizerCode, String authorizerId, String compOfferId) {
        this.ruleName = ruleName;
        if (template.getSourceId() != null) {
            this.chargeSourceId = template.getSourceId();
        }
        if (template.getCategoryIds() != null) {
            this.categoryIds = template.getCategoryIds();
        }
        if (template.getItemIds() != null) {
            this.itemIds = template.getItemIds();
        }
        this.comp = template.getComp();
        this.compingTax = template.getCompingTax();
        this.includeArrivalDate = template.getIncludeArrivalDate();
        this.includeDepartureDate = template.getIncludeDepartureDate();
        this.carryUnusedBalance = template.getCarryUnusedBalance();
        this.ignoreDestinationRules = template.getIgnoreDestinationRules();
        this.reason = template.getReason();
        this.description = template.getDescription();
        this.postingRuleChargeType = template.getPostingRuleChargeType().name();
        this.occurrenceDays = template.getOccurrenceDays();
        if (template.getSplitBy() != null) {
            this.splitBy = template.getSplitBy().name();
        }
        this.startDate = template.getStartDate().isBefore(propertyDate) ? propertyDate : template.getStartDate();
        if (template.getEndDate() != null) {
            this.endDate = template.getEndDate();
        }
        if (template.getComp()) {
            this.offSetRule = template.getOffSetRule();
            this.departmentId = template.getDepartmentId();
            this.authorizerId = authorizerId;
            this.compOfferId = compOfferId;
            this.authorizerCode = authorizerCode;
        }
        if (isNotEmpty(offerAppliedDates)) {
            this.validOn = offerAppliedDates;
        }
        if (isNotEmpty(template.getDestinations())) {
            this.destinations = template.getDestinations();
        }
        if(template.getDepositDestinationDetail() != null){
            this.depositDestinationDetail = template.getDepositDestinationDetail();
        }
    }

    public Boolean getRouteChargesAlreadyPosted() {
        return routeChargesAlreadyPosted;
    }

    public void setRouteChargesAlreadyPosted(Boolean routeChargesAlreadyPosted) {
        this.routeChargesAlreadyPosted = routeChargesAlreadyPosted;
    }
}
