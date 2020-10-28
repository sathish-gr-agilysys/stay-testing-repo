/*
 * (C) 2019 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.api;

import java.util.List;
import java.util.Set;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.security.access.prepost.PreAuthorize;

import com.agilysys.platform.common.rguest.exception.RGuestException;
import com.agilysys.platform.schema.Validated;
import com.agilysys.pms.account.model.PantryItem;
import com.agilysys.pms.account.model.TransactionItem;

@Path("/tenants/{tenantId}/properties/{propertyId}/pantryItems")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface PantryServiceInterface {
    String TENANT_ID = "tenantId";
    String PROPERTY_ID = "propertyId";
    String ITEM_ID = "id";
    String ITEM_ID_PATH = "{id}";
    String PANTRY_ITEM_BULK_UPDATE = "/bulkUpdate";
    String TRANSACTION_ITEMS = "/transactionItems";

    @GET
    @PreAuthorize("hasPermission('Required', 'ReadPantryMgmt') or hasPermission('Required', 'AddPantry')")
    List<PantryItem> getPantryItems(@PathParam(TENANT_ID) String tenantId, @PathParam(PROPERTY_ID) String propertyId)
          throws RGuestException;

    @GET
    @Path(ITEM_ID_PATH)
    @PreAuthorize("hasPermission('Required', 'ReadPantryMgmt')")
    PantryItem getPantryItemById(@PathParam(TENANT_ID) String tenantId, @PathParam(PROPERTY_ID) String propertyId,
          @PathParam(ITEM_ID) String itemId) throws RGuestException;

    @POST
    @Validated(PantryItem.class)
    @PreAuthorize("hasPermission('Required', 'WritePantryMgmt')")
    PantryItem createPantryItem(@PathParam(TENANT_ID) String tenantId, @PathParam(PROPERTY_ID) String propertyId,
          PantryItem item) throws RGuestException;

    @PUT
    @Path(ITEM_ID_PATH)
    @Validated(PantryItem.class)
    @PreAuthorize("hasPermission('Required', 'WritePantryMgmt')")
    PantryItem updatePantryItem(@PathParam(TENANT_ID) String tenantId, @PathParam(PROPERTY_ID) String propertyId,
          @PathParam(ITEM_ID) String itemId, PantryItem item) throws RGuestException;

    @PUT
    @Path(PANTRY_ITEM_BULK_UPDATE)
    @PreAuthorize("hasPermission('Required', 'WritePantryMgmt')")
    List<PantryItem> bulkUpdatePantryItem(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, List<PantryItem> pantryItemList)
          throws RGuestException;

    @GET
    @Path(TRANSACTION_ITEMS)
    @PreAuthorize("hasPermission('Required', 'ReadPantryMgmt')")
    List<TransactionItem> getPantryAssociatedTransactionItems(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId) throws RGuestException;

}
