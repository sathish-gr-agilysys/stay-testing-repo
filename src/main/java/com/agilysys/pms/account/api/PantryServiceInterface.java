/*
 * (C) 2019 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.api;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.agilysys.platform.common.rguest.exception.RGuestException;
import com.agilysys.platform.schema.Validated;
import com.agilysys.pms.account.model.PantryItem;
import com.agilysys.pms.common.security.Permission;
import com.agilysys.pms.common.security.Requires;

@Path("/tenants/{tenantId}/properties/{propertyId}/pantryItems")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface PantryServiceInterface {
    String TENANT_ID = "tenantId";
    String PROPERTY_ID = "propertyId";
    String ITEM_ID = "id";
    String ITEM_ID_PATH = "{id}";
    String PANTRY_ITEM_BULK_UPDATE = "/bulkUpdate";
    String SORT_PANTRY_ITEMS_BY_FIELD = "sortByField";
    String SORT_PANTRY_ITEMS_BY_FIELD_PATH = "/" + SORT_PANTRY_ITEMS_BY_FIELD + "/{" + SORT_PANTRY_ITEMS_BY_FIELD + "}";

    @GET
    @Requires(any = { Permission.READ_PANTRY_MGMT, Permission.ADD_PANTRY })
    List<PantryItem> getPantryItems(@PathParam(TENANT_ID) String tenantId, @PathParam(PROPERTY_ID) String propertyId)
          throws RGuestException;

    @GET
    @Path(ITEM_ID_PATH)
    @Requires(Permission.READ_PANTRY_MGMT)
    PantryItem getPantryItemById(@PathParam(TENANT_ID) String tenantId, @PathParam(PROPERTY_ID) String propertyId,
          @PathParam(ITEM_ID) String itemId) throws RGuestException;

    @POST
    @Validated(PantryItem.class)
    @Requires(Permission.WRITE_PANTRY_MGMT)
    PantryItem createPantryItem(@PathParam(TENANT_ID) String tenantId, @PathParam(PROPERTY_ID) String propertyId,
          PantryItem item) throws RGuestException;

    @PUT
    @Path(ITEM_ID_PATH)
    @Validated(PantryItem.class)
    @Requires(Permission.WRITE_PANTRY_MGMT)
    PantryItem updatePantryItem(@PathParam(TENANT_ID) String tenantId, @PathParam(PROPERTY_ID) String propertyId,
          @PathParam(ITEM_ID) String itemId, PantryItem item) throws RGuestException;

    @PUT
    @Path(PANTRY_ITEM_BULK_UPDATE)
    @Requires(Permission.WRITE_PANTRY_MGMT)
    List<PantryItem> bulkUpdatePantryItem(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, List<PantryItem> pantryItemList) throws RGuestException;

    @GET
    @Path(SORT_PANTRY_ITEMS_BY_FIELD_PATH)
    @Requires(any = { Permission.READ_PANTRY_MGMT, Permission.ADD_PANTRY })
    List<PantryItem> getPantryItemsSortByName(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId,
          @PathParam(SORT_PANTRY_ITEMS_BY_FIELD) String sortPantryItemsByField) throws RGuestException;
}