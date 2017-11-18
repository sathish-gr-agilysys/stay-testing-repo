/**
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
import javax.ws.rs.core.MediaType;

import org.springframework.security.access.prepost.PreAuthorize;

import com.agilysys.intapp.model.FolioPostingCodes;
import com.agilysys.platform.common.exception.ServiceException;
import com.agilysys.platform.common.rguest.exception.RGuestException;
import com.agilysys.platform.schema.Validated;
import com.agilysys.platform.tax.model.TaxRuleData;
import com.agilysys.pms.account.model.NonRoomInventoryItem;
import com.agilysys.pms.account.model.TransactionItem;
import com.agilysys.pms.common.api.annotation.CreatedOnSuccess;

@Path("/tenants/{tenantId}/properties/{propertyId}/config/nonRoomInventoryItems")
public interface NonRoomInventoryItemConfigServiceInterface {
    String TENANT_ID = "tenantId";
    String PROPERTY_ID = "propertyId";
    String ITEM_ID = "id";
    String ITEM_ID_PATH = "{id}";

    /**
     * Retrieve all NonRoomInventoryItems
     *
     * @param tenantId the tenantId to retrieve NonRoomInventoryItems for
     * @return List of NonRoomInventoryItems
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @PreAuthorize("hasPermission('Required', 'ReadPropertyConfig')")
    List<NonRoomInventoryItem> getNonRoomInventoryItems(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId) throws RGuestException, ServiceException;

    /**
     * Retrieve a specific NonRoomInventoryItems
     *
     * @param tenantId the tenantId to retrieve the NonRoomInventoryItem for
     * @param itemId   the ID of the NonRoomInventoryItem to retrieve
     * @return the NonRoomInventoryItem identified by itemId
     */
    @GET
    @Path(ITEM_ID_PATH)
    @Produces(MediaType.APPLICATION_JSON)
    @PreAuthorize("hasPermission('Required', 'ReadPropertyConfig')")
    NonRoomInventoryItem getNonRoomInventoryItem(@PathParam(TENANT_ID) String tenantId, @PathParam(PROPERTY_ID) String propertyId,
          @PathParam(ITEM_ID) String itemId) throws RGuestException, ServiceException;

    /**
     * Create a new NonRoomInventoryItems
     *
     * @param tenantId the tenantId to create a NonRoomInventoryItem for
     * @param item     the new NonRoomInventoryItem to persist
     * @return the newly create NonRoomInventoryItem with auto-generated ID
     */
    @POST
    @CreatedOnSuccess
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Validated(NonRoomInventoryItem.class)
    @PreAuthorize("hasPermission('Required', 'WritePropertyConfig')")
    NonRoomInventoryItem createNonRoomInventoryItem(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, NonRoomInventoryItem item) throws RGuestException, ServiceException;

    /**
     * Modify an existing NonRoomInventoryItem
     *
     * @param tenantId the tenantId to modify the NonRoomInventoryItem for
     * @param itemId   the ID of the NonRoomInventoryItem to modify
     * @param item     the modified NonRoomInventoryItem to persist
     * @return the modified NonRoomInventoryItem
     */
    @PUT
    @Path(ITEM_ID_PATH)
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Validated(NonRoomInventoryItem.class)
    @PreAuthorize("hasPermission('Required', 'WritePropertyConfig')")
    NonRoomInventoryItem updateNonRoomInventoryItem(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @PathParam(ITEM_ID) String itemId, NonRoomInventoryItem item)
          throws RGuestException, ServiceException;

    /**
     * Delete an existing NonRoomInventoryItem
     *
     * @param tenantId the tenantId to delete the NonRoomInventoryItem for
     * @param itemId   the ID of the NonRoomInventoryItem to delete
     */
    @DELETE
    @Path(ITEM_ID_PATH)
    @Produces(MediaType.APPLICATION_JSON)
    @PreAuthorize("hasPermission('Required', 'WritePropertyConfig')")
    void deleteNonRoomInventoryItem(@PathParam(TENANT_ID) String tenantId, @PathParam(PROPERTY_ID) String propertyId,
          @PathParam(ITEM_ID) String itemId) throws RGuestException, ServiceException;

}

