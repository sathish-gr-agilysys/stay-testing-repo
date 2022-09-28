/*
 * (C) 2018 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.api;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.agilysys.common.model.MergeMarketingDetailRequest;
import com.agilysys.platform.common.rguest.exception.RGuestException;
import com.agilysys.pms.account.model.AutoRecurringChargeRule;
import com.agilysys.pms.account.model.AutoRecurringChargeRuleParameters;
import com.agilysys.pms.account.model.AutoRecurringChargeRuleRequest;
import com.agilysys.pms.account.model.AutoRecurringChargeRuleResponse;
import com.agilysys.pms.account.model.AutoRecurringChargesPrintOrEmail;
import com.agilysys.pms.account.model.AutoRecurringChargesPriority;
import com.agilysys.pms.account.model.AutoRecurringItem;
import com.agilysys.pms.account.model.BulkAutoRecurringRuleRequest;
import com.agilysys.pms.account.model.TransactionItemOptionalParameters;
import com.agilysys.pms.common.api.annotation.CreatedOnSuccess;
import com.agilysys.pms.common.security.Permission;
import com.agilysys.pms.common.security.Requires;

@Path(AutoRecurringItemConfigServiceInterface.BASE_PATH)
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface AutoRecurringItemConfigServiceInterface {
    String TENANT_ID = "tenantId";
    String PROPERTY_ID = "propertyId";
    String BASE_PATH = "/tenants/{" + TENANT_ID + "}/properties/{" + PROPERTY_ID + "}/config/autoRecurringItems";
    String ITEM_ID = "id";
    String ITEM_ID_PATH = "{" + ITEM_ID + "}";
    String START_DATE = "startDate";
    String END_DATE = "endDate";
    String APPLICABLE_ARC_RULE = "/applicableArcRule";
    String APPLICABLE_ARC_RULE_BULK = "/applicableArcRuleBulk";
    String RULE = "/rule";
    String RULE_BY_ACCOUNTS = "/ruleByAccounts";
    String PRIORITIZE_ORDER = "/priorityOrder";
    String PRINT_OR_EMAIL = "/printOrEmailConfig";
    String SHARE_ID = "shareId";
    String ACCOUNT_ID = "accountId";
    String SHARE_PATH = "/share/{" + SHARE_ID + "}";
    String VALIDATE_RULE_CHANGES = "/validateRuleChanges/{" + ACCOUNT_ID + "}";
    String MERGE_MARKETING_DETAILS = "/mergeMarketingDetails";
    String UPDATE_ARC_FOR_MODIFIED_SNAPSHOT = "/updateArcForModifiedSnapshot";
    String UPDATE_ARC_DEPOSIT_POLICY = "/updateArcDepositPolicy";

    @GET
    @Path(ITEM_ID_PATH)
    @Requires(Permission.READ_PROPERTY_CONFIG)
    AutoRecurringItem getAutoRecurringItem(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @PathParam(ITEM_ID) String itemId) throws RGuestException;

    @GET
    @Requires(Permission.READ_PROPERTY_CONFIG)
    List<AutoRecurringItem> getAutoRecurringItems(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId) throws RGuestException;

    @POST
    @CreatedOnSuccess
    @Requires(Permission.WRITE_COMPANY_PROFILE_DEFAULTS)
    List<AutoRecurringItem> createAutoRecurringItems(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId,
          @QueryParam("") TransactionItemOptionalParameters transactionItemOptionalParameters,
          List<AutoRecurringItem> items) throws RGuestException;

    @PUT
    @Path(ITEM_ID_PATH)
    @Requires(Permission.WRITE_COMPANY_PROFILE_DEFAULTS)
    AutoRecurringItem updateAutoRecurringItem(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @PathParam(ITEM_ID) String itemId,
          @QueryParam("") TransactionItemOptionalParameters transactionItemOptionalParameters, AutoRecurringItem item)
          throws RGuestException;

    @POST
    @Path(APPLICABLE_ARC_RULE)
    @Requires(Permission.READ_PROPERTY_CONFIG)
    AutoRecurringChargeRuleResponse getApplicableArcRule(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, AutoRecurringChargeRuleRequest autoRecurringChargeRuleRequest)
          throws RGuestException;

    @POST
    @Path(VALIDATE_RULE_CHANGES)
    @Requires(Permission.READ_PROPERTY_CONFIG)
    AutoRecurringChargeRuleResponse validateRuleChanges(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @PathParam(ACCOUNT_ID) String accountId,
          AutoRecurringChargeRuleRequest autoRecurringChargeRuleRequest) throws RGuestException;

    @POST
    @Path(APPLICABLE_ARC_RULE_BULK)
    @Requires(Permission.READ_PROPERTY_CONFIG)
    Map<String, AutoRecurringChargeRuleResponse> getApplicableArcRuleForRatesAndRooms(
          @PathParam(TENANT_ID) String tenantId, @PathParam(PROPERTY_ID) String propertyId,
          BulkAutoRecurringRuleRequest bulkAutoRecurringRuleRequest) throws RGuestException;

    @DELETE
    @Path(ITEM_ID_PATH)
    @Requires(Permission.WRITE_PROPERTY_CONFIG)
    void deleteAutoRecurringItem(@PathParam(TENANT_ID) String tenantId, @PathParam(PROPERTY_ID) String propertyId,
          @PathParam(ITEM_ID) String itemId) throws RGuestException;

    @GET
    @Path(RULE)
    @CreatedOnSuccess
    @Requires(Permission.READ_PROPERTY_CONFIG)
    List<AutoRecurringChargeRule> getAutoRecurringChargeRules(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @QueryParam("active") Boolean active) throws RGuestException;

    @POST
    @Path(RULE)
    @CreatedOnSuccess
    @Requires(Permission.AUTO_RECURRING_CHARGE_RULES)
    AutoRecurringChargeRule createAutoRecurringChargeRule(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId,
          @QueryParam("") TransactionItemOptionalParameters transactionItemOptionalParameters,
          AutoRecurringChargeRule rule) throws RGuestException;

    @PUT
    @Path(RULE)
    @CreatedOnSuccess
    @Requires(Permission.AUTO_RECURRING_CHARGE_RULES)
    AutoRecurringChargeRule updateAutoRecurringChargeRule(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId,
          @QueryParam("") TransactionItemOptionalParameters transactionItemOptionalParameters,
          AutoRecurringChargeRule rule) throws RGuestException;

    @PUT
    @Path(RULE_BY_ACCOUNTS)
    @CreatedOnSuccess
    @Requires(Permission.WRITE_PROPERTY_CONFIG)
    void updateArcRuleByAccountIds(@PathParam(TENANT_ID) String tenantId, @PathParam(PROPERTY_ID) String propertyId,
          AutoRecurringChargeRuleParameters autoRecurringChargeRuleParameters) throws RGuestException;

    @GET
    @Path(RULE + "/associatedToGroup")
    @CreatedOnSuccess
    @Requires(Permission.READ_PROPERTY_CONFIG)
    AutoRecurringChargeRule getArcRuleAssociatedToGroup(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId) throws RGuestException;

    @GET
    @Path(RULE + PRIORITIZE_ORDER)
    @CreatedOnSuccess
    @Requires(Permission.READ_PROPERTY_CONFIG)
    AutoRecurringChargesPriority getArcRulePriority(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId) throws RGuestException;

    @PUT
    @Path(RULE + PRIORITIZE_ORDER)
    @CreatedOnSuccess
    @Requires(Permission.WRITE_PROPERTY_CONFIG)
    AutoRecurringChargesPriority updateArcRulePriority(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId,
          @QueryParam("") TransactionItemOptionalParameters optionalParameters, AutoRecurringChargesPriority priority)
          throws RGuestException;

    @GET
    @Path(RULE + PRINT_OR_EMAIL)
    @CreatedOnSuccess
    @Requires(Permission.READ_PROPERTY_CONFIG)
    AutoRecurringChargesPrintOrEmail getPrintEmailConfig(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId);

    @PUT
    @Path(RULE + PRINT_OR_EMAIL)
    @CreatedOnSuccess
    @Requires(Permission.WRITE_PROPERTY_CONFIG)
    AutoRecurringChargesPrintOrEmail updatePrintEmailConfig(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, AutoRecurringChargesPrintOrEmail printOrEmail);

    @PUT
    @Path(SHARE_PATH)
    @Requires(Permission.WRITE_PROPERTY_CONFIG)
    void updateArcPerRoomItemsByShareId(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @PathParam(SHARE_ID) String shareId);

    @PUT
    @Path(UPDATE_ARC_FOR_MODIFIED_SNAPSHOT)
    @Requires(Permission.WRITE_PROPERTY_CONFIG)
    void updateAutoRecurringChargesForModifiedRateSnapshot(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId,
          AutoRecurringChargeRuleParameters autoRecurringChargeRuleParameters);

    @PUT
    @Path(MERGE_MARKETING_DETAILS)
    String mergeMarketingDetails(@PathParam(TENANT_ID) String tenantId, @PathParam(PROPERTY_ID) String propertyId,
          MergeMarketingDetailRequest request) throws RGuestException;

    @POST
    @Path(UPDATE_ARC_DEPOSIT_POLICY)
    void updateArcDepositPolicy(@PathParam(TENANT_ID) String tenantId, @PathParam(PROPERTY_ID) String propertyId,
          Set<String> accountIds);
}