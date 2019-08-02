package com.agilysys.pms.account.api;

import java.util.List;

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

import org.springframework.security.access.prepost.PreAuthorize;

import com.agilysys.intapp.model.FolioPostingCodes;
import com.agilysys.platform.common.exception.ServiceException;
import com.agilysys.platform.common.rguest.exception.RGuestException;
import com.agilysys.platform.schema.Validated;
import com.agilysys.platform.tax.model.TaxRuleData;
import com.agilysys.pms.account.model.AutoRecurringChargeOptionalParameters;
import com.agilysys.pms.account.model.TransactionItem;
import com.agilysys.pms.common.api.annotation.CreatedOnSuccess;

/*
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
    String INCLUDE_PERMIT_COMP = "includePermitComp";
    String COMTROL_VALUE = "comtrolValue";
    String COMTROL_VALUE_PATH = COMTROL_VALUE + "/{comtrolValue}";
    String ACTIVE = "/active";
    String PERMIT_COMP = "/permitComp";
    String MIGRATE_TO_V1_PATH = "/migrateToV1";

    /**
     * Retrieve all TransactionItems
     *
     * @param tenantId the tenantId to retrieve TransactionItems for
     * @return List of TransactionItem
     */
    @GET
    @PreAuthorize("hasPermission('Required', 'ReadPropertyConfig')")
    List<TransactionItem> getTransactionItems(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId,
          @DefaultValue("false") @QueryParam(INCLUDE_INTERNAL) boolean includeInternal)
          throws RGuestException, ServiceException;

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
    @PreAuthorize("hasPermission('Required', 'ReadPropertyConfig')")
    TransactionItem getTransactionItemByComtrolValue(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @PathParam(COMTROL_VALUE) FolioPostingCodes folioPostingCode)
          throws RGuestException, ServiceException;

    /**
     * Retrieve a specific TransactionItem
     *
     * @param tenantId the tenantId to retrieve the TransactionItem for
     * @param itemId   the ID of the TransactionItems to retrieve
     * @return the TransactionItem identified by itemId
     */
    @GET
    @Path(ITEM_ID_PATH)
    @PreAuthorize("hasPermission('Required', 'ReadPropertyConfig')")
    TransactionItem getTransactionItem(@PathParam(TENANT_ID) String tenantId, @PathParam(PROPERTY_ID) String propertyId,
          @PathParam(ITEM_ID) String itemId) throws RGuestException, ServiceException;

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
    @PreAuthorize("hasPermission('Required', 'WritePropertyConfig')")
    TransactionItem createTransactionItem(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, TransactionItem item) throws RGuestException, ServiceException;

    /**
     * Modify an existing TransactionItem
     *
     * @param tenantId                              the tenantId to modify the TransactionItem for
     * @param itemId                                the ID of the TransactionItems to modify
     * @param autoRecurringChargeOptionalParameters decides whether to update the values of Auto recurring items
     *                                              created from the transaction item
     * @param item                                  the modified TransactionItem to persist
     * @return the modified TransactionItem
     */
    @PUT
    @Path(ITEM_ID_PATH)
    @Validated(TransactionItem.class)
    @PreAuthorize("hasPermission('Required', 'WritePropertyConfig')")
    TransactionItem updateTransactionItem(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @PathParam(ITEM_ID) String itemId,
          @QueryParam("") AutoRecurringChargeOptionalParameters autoRecurringChargeOptionalParameters,
          TransactionItem item) throws RGuestException, ServiceException;

    /**
     * Delete an existing TransactionItem
     *
     * @param tenantId the tenantId to delete the TransactionItem for
     * @param itemId   the ID of the TransactionItems to delete
     */
    @DELETE
    @Path(ITEM_ID_PATH)
    @PreAuthorize("hasPermission('Required', 'WritePropertyConfig')")
    void deleteTransactionItem(@PathParam(TENANT_ID) String tenantId, @PathParam(PROPERTY_ID) String propertyId,
          @PathParam(ITEM_ID) String itemId) throws RGuestException, ServiceException;

    @GET
    @Path(ITEM_ID_PATH + "/associatedTaxRules")
    @PreAuthorize("hasPermission('Required', 'ReadPropertyConfig')")
    List<TaxRuleData> getAssociatedTaxRules(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @PathParam(ITEM_ID) String itemId)
          throws RGuestException, ServiceException;

    /**
     * Retrieve all Active Transaction item
     *
     * @param tenantId the tenantId to retrieve InventoryItems for
     * @return List of InventoryItems
     */
    @GET
    @Path(ACTIVE)
    @PreAuthorize("hasPermission('Required', 'ReadPropertyConfig')")
    List<TransactionItem> getActiveTransactionItem(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @QueryParam(INCLUDE_INTERNAL) boolean includeInternal,
          @QueryParam(INCLUDE_SUB_TRANSACTION_ITEMS) boolean includeSubItems,
          @QueryParam(INCLUDE_INACTIVE) boolean includeInactive) throws RGuestException, ServiceException;

    /**
     * Retrieve all Active permitComp items
     *
     * @param tenantId the tenantId to retrieve InventoryItems for
     * @return List of InventoryItems
     */
    @GET
    @Path(PERMIT_COMP)
    @PreAuthorize("hasPermission('Required', 'ReadPropertyConfig')")
    List<TransactionItem> getActiveTransactionItem(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @QueryParam(INCLUDE_INTERNAL) boolean includeInternal,
          @QueryParam(INCLUDE_SUB_TRANSACTION_ITEMS) boolean includeSubItems,
          @QueryParam(INCLUDE_INACTIVE) boolean includeInactive,
          @QueryParam(INCLUDE_PERMIT_COMP) boolean includePermitComp) throws RGuestException, ServiceException;
}
