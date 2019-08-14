/*
 * (C) 2017 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.api;

import java.util.List;

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

import org.springframework.security.access.prepost.PreAuthorize;

import com.agilysys.platform.common.rguest.exception.RGuestException;
import com.agilysys.platform.schema.Validated;
import com.agilysys.pms.account.model.AutoRecurringChargeOptionalParameters;
import com.agilysys.pms.account.model.InventoryItem;
import com.agilysys.pms.common.api.annotation.CreatedOnSuccess;

@Path("/tenants/{tenantId}/properties/{propertyId}/config/inventoryItems")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface InventoryItemConfigServiceInterface {
    String TENANT_ID = "tenantId";
    String PROPERTY_ID = "propertyId";
    String ITEM_ID = "id";
    String ITEM_ID_PATH = "{id}";
    String INCLUDE_INTERNAL = "includeInternal";
    String CONVERT_PATH = "/convertToInventory";
    String MIGRATE_TO_V1_PATH = "/migrateToV1";

    /**
     * Retrieve all InventoryItems
     *
     * @param tenantId the tenantId to retrieve InventoryItems for
     * @return List of InventoryItems
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @PreAuthorize("hasPermission('Required', 'ReadPropertyConfig')")
    List<InventoryItem> getInventoryItems(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @QueryParam(INCLUDE_INTERNAL) boolean includeInternal)
          throws RGuestException;

    /**
     * Retrieve a specific InventoryItems
     *
     * @param tenantId the tenantId to retrieve the InventoryItem for
     * @param itemId   the ID of the InventoryItem to retrieve
     * @return the InventoryItem identified by itemId
     */
    @GET
    @Path(ITEM_ID_PATH)
    @PreAuthorize("hasPermission('Required', 'ReadPropertyConfig')")
    InventoryItem getInventoryItem(@PathParam(TENANT_ID) String tenantId, @PathParam(PROPERTY_ID) String propertyId,
          @PathParam(ITEM_ID) String itemId) throws RGuestException;

    /**
     * Create a new InventoryItems
     *
     * @param tenantId the tenantId to create a InventoryItem for
     * @param item     the new InventoryItem to persist
     * @return the newly create InventoryItem with auto-generated ID
     */
    @POST
    @CreatedOnSuccess
    @Validated(InventoryItem.class)
    @PreAuthorize("hasPermission('Required', 'WritePropertyConfig')")
    InventoryItem createInventoryItem(@PathParam(TENANT_ID) String tenantId, @PathParam(PROPERTY_ID) String propertyId,
          InventoryItem item) throws RGuestException;

    /**
     * Modify an existing InventoryItem
     *
     * @param tenantId                              the tenantId to modify the Inventory Item for
     * @param itemId                                the ID of the Inventory to modify
     * @param autoRecurringChargeOptionalParameters decides whether to update the values of Auto recurring items
     *                                              created from the inventory item
     * @param item                                  the modified InventoryItem to persist
     * @return the modified InventoryItem
     */
    @PUT
    @Path(ITEM_ID_PATH)
    @Validated(InventoryItem.class)
    @PreAuthorize("hasPermission('Required', 'WritePropertyConfig')")
    InventoryItem updateInventoryItem(@PathParam(TENANT_ID) String tenantId, @PathParam(PROPERTY_ID) String propertyId,
          @PathParam(ITEM_ID) String itemId,
          @QueryParam("") AutoRecurringChargeOptionalParameters autoRecurringChargeOptionalParameters,
          InventoryItem item) throws RGuestException;

    /**
     * Delete an existing InventoryItem
     *
     * @param tenantId the tenantId to delete the InventoryItem for
     * @param itemId   the ID of the InventoryItem to delete
     */
    @DELETE
    @Path(ITEM_ID_PATH)
    @PreAuthorize("hasPermission('Required', 'WritePropertyConfig')")
    void deleteInventoryItem(@PathParam(TENANT_ID) String tenantId, @PathParam(PROPERTY_ID) String propertyId,
          @PathParam(ITEM_ID) String itemId) throws RGuestException;

    /**
     * convert transaction item to InventoryItem
     *
     * @param tenantId the tenantId to delete the InventoryItem for
     * @param items    items which are converting to InventoryItem
     */
    @POST
    @Path(CONVERT_PATH)
    @PreAuthorize("hasPermission('Required', 'WritePropertyConfig')")
    List<InventoryItem> convertToInventoryItem(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, List<InventoryItem> items) throws RGuestException;
}
