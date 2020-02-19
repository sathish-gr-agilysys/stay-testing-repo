/*
 * (C) 2018 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.api;

import java.util.List;
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

import org.joda.time.LocalDate;
import org.springframework.security.access.prepost.PreAuthorize;

import com.agilysys.platform.common.rguest.exception.RGuestException;
import com.agilysys.pms.account.model.AutoRecurringChargeRule;
import com.agilysys.pms.account.model.AutoRecurringChargeRuleRequest;
import com.agilysys.pms.account.model.AutoRecurringChargeRuleResponse;
import com.agilysys.pms.account.model.AutoRecurringChargesPrintOrEmail;
import com.agilysys.pms.account.model.AutoRecurringChargesPriority;
import com.agilysys.pms.account.model.AutoRecurringItem;
import com.agilysys.pms.account.model.TransactionItemOptionalParameters;
import com.agilysys.pms.common.api.annotation.CreatedOnSuccess;

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
    String RULE = "/rule";
    String RULE_BY_ACCOUNTS = "/ruleBYAccounts";
    String PRIORITIZE_ORDER = "/priorityOrder";
    String PRINT_OR_EMAIL = "/printOrEmailConfig";

    @GET
    @Path(ITEM_ID_PATH)
    @PreAuthorize("hasPermission('Required', 'ReadPropertyConfig')")
    AutoRecurringItem getAutoRecurringItem(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @PathParam(ITEM_ID) String itemId) throws RGuestException;

    @GET
    @PreAuthorize("hasPermission('Required', 'ReadPropertyConfig')")
    List<AutoRecurringItem> getAutoRecurringItems(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId) throws RGuestException;

    @POST
    @CreatedOnSuccess
    @PreAuthorize("hasPermission('Required', 'WritePropertyConfig')")
    List<AutoRecurringItem> createAutoRecurringItems(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId,
          @QueryParam("") TransactionItemOptionalParameters transactionItemOptionalParameters,
          List<AutoRecurringItem> items) throws RGuestException;

    @PUT
    @Path(ITEM_ID_PATH)
    @PreAuthorize("hasPermission('Required', 'WritePropertyConfig')")
    AutoRecurringItem updateAutoRecurringItem(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @PathParam(ITEM_ID) String itemId,
          @QueryParam("") TransactionItemOptionalParameters transactionItemOptionalParameters, AutoRecurringItem item)
          throws RGuestException;

    @POST
    @Path(APPLICABLE_ARC_RULE)
    @PreAuthorize("hasPermission('Required', 'ReadPropertyConfig')")
    AutoRecurringChargeRuleResponse getApplicableArcRule(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, AutoRecurringChargeRuleRequest autoRecurringChargeRuleRequest)
          throws RGuestException;

    @DELETE
    @Path(ITEM_ID_PATH)
    @PreAuthorize("hasPermission('Required', 'WritePropertyConfig')")
    void deleteAutoRecurringItem(@PathParam(TENANT_ID) String tenantId, @PathParam(PROPERTY_ID) String propertyId,
          @PathParam(ITEM_ID) String itemId) throws RGuestException;

    @GET
    @Path(RULE)
    @CreatedOnSuccess
    @PreAuthorize("hasPermission('Required', 'ReadPropertyConfig')")
    List<AutoRecurringChargeRule> getAutoRecurringChargeRules(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId) throws RGuestException;

    @POST
    @Path(RULE)
    @CreatedOnSuccess
    @PreAuthorize("hasPermission('Required', 'WritePropertyConfig')")
    AutoRecurringChargeRule createAutoRecurringChargeRule(@PathParam(TENANT_ID) String tenantId, @PathParam(PROPERTY_ID) String propertyId,
          @QueryParam("") TransactionItemOptionalParameters transactionItemOptionalParameters,
          AutoRecurringChargeRule rule) throws RGuestException;

    @PUT
    @Path(RULE)
    @CreatedOnSuccess
    @PreAuthorize("hasPermission('Required', 'WritePropertyConfig')")
    AutoRecurringChargeRule updateAutoRecurringChargeRule(@PathParam(TENANT_ID) String tenantId, @PathParam(PROPERTY_ID) String propertyId,
          @QueryParam("") TransactionItemOptionalParameters transactionItemOptionalParameters,
          AutoRecurringChargeRule rule) throws RGuestException;

    @PUT
    @Path(RULE_BY_ACCOUNTS)
    @CreatedOnSuccess
    @PreAuthorize("hasPermission('Required', 'WritePropertyConfig')")
    void updateArcRuleForGroupAccounts(@PathParam(TENANT_ID) String tenantId, @PathParam(PROPERTY_ID) String propertyId,
          Set<String> accountIds)
          throws RGuestException;

    @GET
    @Path(RULE + "/associatedToGroup")
    @CreatedOnSuccess
    @PreAuthorize("hasPermission('Required', 'WritePropertyConfig')")
    AutoRecurringChargeRule getArcRuleAssociatedToGroup(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId) throws RGuestException;

    @GET
    @Path(RULE + PRIORITIZE_ORDER)
    @CreatedOnSuccess
    @PreAuthorize("hasPermission('Required', 'ReadPropertyConfig')")
    AutoRecurringChargesPriority getArcRulePriority(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId) throws RGuestException;

    @PUT
    @Path(RULE + PRIORITIZE_ORDER)
    @CreatedOnSuccess
    @PreAuthorize("hasPermission('Required', 'WritePropertyConfig')")
    AutoRecurringChargesPriority updateArcRulePriority(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId,
          @QueryParam("") TransactionItemOptionalParameters optionalParameters, AutoRecurringChargesPriority priority)
          throws RGuestException;

    @GET
    @Path(RULE + PRINT_OR_EMAIL)
    @CreatedOnSuccess
    @PreAuthorize("hasPermission('Required', 'ReadPropertyConfig')")
    AutoRecurringChargesPrintOrEmail getPrintEmailConfig(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId);

    @PUT
    @Path(RULE + PRINT_OR_EMAIL)
    @CreatedOnSuccess
    @PreAuthorize("hasPermission('Required', 'WritePropertyConfig')")
    AutoRecurringChargesPrintOrEmail updatePrintEmailConfig(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, AutoRecurringChargesPrintOrEmail printOrEmail);
}
