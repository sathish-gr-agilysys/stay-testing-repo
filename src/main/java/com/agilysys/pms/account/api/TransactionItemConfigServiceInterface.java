/*
 * (C) 2019 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.api;

import static com.agilysys.pms.common.client.caching.RiskTolerance.MODERATE;

import java.util.List;
import java.util.Set;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.agilysys.intapp.model.FolioPostingCodes;
import com.agilysys.platform.common.rguest.exception.RGuestException;
import com.agilysys.platform.schema.Validated;
import com.agilysys.platform.tax.model.TaxRuleData;
import com.agilysys.pms.account.model.TransactionItem;
import com.agilysys.pms.account.model.TransactionItemOptionalParameters;
import com.agilysys.pms.common.api.annotation.CreatedOnSuccess;
import com.agilysys.pms.common.client.caching.CacheOnClient;
import com.agilysys.pms.common.eons.EonsType;
import com.agilysys.pms.common.security.Permission;
import com.agilysys.pms.common.security.Requires;

/**
 * CRUD methods for TransactionItem
 */
@Path("/tenants/{tenantId}/properties/{propertyId}/config/transactionItems")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface TransactionItemConfigServiceInterface {
    String TENANT_ID = "tenantId";
    String PROPERTY_ID = "propertyId";
    String ITEM_ID = "id";
    String ITEM_ID_PATH = "{id}";
    String INCLUDE_INTERNAL = "includeInternal";
    String INCLUDE_SUB_TRANSACTION_ITEMS = "includeSubTransactionItems";
    String INCLUDE_INACTIVE = "includeInactive";
    String INCLUDE_ALLOW_COMP = "includeAllowComp";
    String COMTROL_VALUE = "comtrolValue";
    String COMTROL_VALUE_PATH = COMTROL_VALUE + "/{comtrolValue}";
    String FOLIO_POSTING_CODE_PATH = "/folioPostingCode";
    String ACTIVE = "/active";
    String UPDATE_ORDER = "/updateOrder";

    /**
     * Retrieve all TransactionItems
     *
     * @param tenantId the tenantId to retrieve TransactionItems for
     * @return List of TransactionItem
     */
    @GET
    @Requires(Permission.READ_PROPERTY_CONFIG)
    List<TransactionItem> getTransactionItems(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId,
          @DefaultValue("false") @QueryParam(INCLUDE_INTERNAL) boolean includeInternal) throws RGuestException;

    @GET
    @Path("/all")
    @CacheOnClient(type = EonsType.TRANSACTION_ITEM, tenantId = TENANT_ID, propertyId = PROPERTY_ID,
          riskTolerance = MODERATE)
    @Requires(Permission.READ_PROPERTY_CONFIG)
    List<TransactionItem> getAllTransactionItems(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId) throws RGuestException;

    @GET
    @Path("/nonInternal")
    @CacheOnClient(type = EonsType.TRANSACTION_ITEM, tenantId = TENANT_ID, propertyId = PROPERTY_ID,
          riskTolerance = MODERATE)
    @Requires(Permission.READ_PROPERTY_CONFIG)
    List<TransactionItem> getNonInternalTransactionItems(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId) throws RGuestException;

    /**
     * Retrieve a transaction item comtrol mapping
     *
     * @param tenantId         the tenantId to retrieve TransactionItems for
     * @param folioPostingCode the mapping that is used by the relay service to map a comtrol charge to a {@link
     *                         TransactionItem}
     * @return List of TransactionItem
     */
    @GET
    @Path(COMTROL_VALUE_PATH)
    @Requires(Permission.READ_PROPERTY_CONFIG)
    TransactionItem getTransactionItemByComtrolValue(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @PathParam(COMTROL_VALUE) FolioPostingCodes folioPostingCode)
          throws RGuestException;

    @POST
    @Path(FOLIO_POSTING_CODE_PATH)
    @Requires(Permission.READ_PROPERTY_CONFIG)
    List<TransactionItem> getTransactionItemsByFolioPostingCodes(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, Set<FolioPostingCodes> folioPostingCodes) throws RGuestException;

    /**
     * Retrieve a specific TransactionItem
     *
     * @param tenantId the tenantId to retrieve the TransactionItem for
     * @param itemId   the ID of the TransactionItems to retrieve
     * @return the TransactionItem identified by itemId
     */
    @GET
    @Path(ITEM_ID_PATH)
    @Requires(Permission.READ_PROPERTY_CONFIG)
    TransactionItem getTransactionItem(@PathParam(TENANT_ID) String tenantId, @PathParam(PROPERTY_ID) String propertyId,
          @PathParam(ITEM_ID) String itemId) throws RGuestException;

    /**
     * Create a new TransactionItem
     *
     * @param tenantId the tenantId to create a TransactionItem for
     * @param item     the new TransactionItem to persist
     * @return the newly create TransactionItem with auto-generated ID
     */
    @POST
    @CreatedOnSuccess
    @Validated(TransactionItem.class)
    @Requires(Permission.WRITE_PROPERTY_CONFIG)
    TransactionItem createTransactionItem(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, TransactionItem item) throws RGuestException;

    /**
     * Modify an existing TransactionItem
     *
     * @param tenantId                          the tenantId to modify the TransactionItem for
     * @param itemId                            the ID of the TransactionItems to modify
     * @param transactionItemOptionalParameters decides whether to update the values of Auto recurring and pantry items
     *                                          created from the transaction item
     * @param item                              the modified TransactionItem to persist
     * @return the modified TransactionItem
     */
    @PUT
    @Path(ITEM_ID_PATH)
    @Validated(TransactionItem.class)
    @Requires(Permission.WRITE_PROPERTY_CONFIG)
    TransactionItem updateTransactionItem(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @PathParam(ITEM_ID) String itemId,
          @QueryParam("") TransactionItemOptionalParameters transactionItemOptionalParameters, TransactionItem item)
          throws RGuestException;

    /**
     * Delete an existing TransactionItem
     *
     * @param tenantId the tenantId to delete the TransactionItem for
     * @param itemId   the ID of the TransactionItems to delete
     */
    @DELETE
    @Path(ITEM_ID_PATH)
    @Requires(Permission.WRITE_PROPERTY_CONFIG)
    void deleteTransactionItem(@PathParam(TENANT_ID) String tenantId, @PathParam(PROPERTY_ID) String propertyId,
          @PathParam(ITEM_ID) String itemId) throws RGuestException;

    @GET
    @Path(ITEM_ID_PATH + "/associatedTaxRules")
    @Requires(Permission.READ_PROPERTY_CONFIG)
    List<TaxRuleData> getAssociatedTaxRules(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @PathParam(ITEM_ID) String itemId) throws RGuestException;

    /**
     * Retrieve all Active Transaction item
     *
     * @param tenantId the tenantId to retrieve InventoryItems for
     * @return List of InventoryItems
     */
    @GET
    @Path(ACTIVE)
    @Requires(Permission.READ_PROPERTY_CONFIG)
    List<TransactionItem> getActiveTransactionItem(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @QueryParam(INCLUDE_INTERNAL) boolean includeInternal,
          @QueryParam(INCLUDE_SUB_TRANSACTION_ITEMS) boolean includeSubItems,
          @QueryParam(INCLUDE_INACTIVE) boolean includeInactive,
          @QueryParam(INCLUDE_ALLOW_COMP) boolean includeAllowComp) throws RGuestException;

    @PUT
    @Path(UPDATE_ORDER)
    void updateOrder(@PathParam(TENANT_ID) String tenantId, @PathParam(PROPERTY_ID) String propertyId,
          List<TransactionItem> transactionItems) throws RGuestException;
}