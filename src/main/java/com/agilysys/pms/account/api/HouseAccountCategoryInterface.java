/*
 * (C) 2016 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
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

import com.agilysys.platform.common.rguest.exception.RGuestException;
import com.agilysys.platform.schema.Validated;
import com.agilysys.pms.account.model.HouseAccountCategory;
import com.agilysys.pms.common.api.annotation.CreatedOnSuccess;
import com.agilysys.pms.common.security.Permission;
import com.agilysys.pms.common.security.Requires;

@Path("/tenants/{tenantId}/properties/{propertyId}/config/houseAccountCategories")
@Produces(MediaType.APPLICATION_JSON)
public interface HouseAccountCategoryInterface {
    String TENANT_ID = "tenantId";
    String PROPERTY_ID = "propertyId";
    String RESOURCE_ID = "id";
    String ID_PATH = "{id}";
    String INCLUDE_INTERNAL = "includeInternal";

    /**
     * Retrieves all House account categories given a tenant and a property
     *
     * @param tenantId   id of tenant where House account categories exist
     * @param propertyId id of the property where House account categories exist
     * @return Existing House account categories for the tenant & property
     **/
    @GET
    @Requires(Permission.READ_PROPERTY_CONFIG)
    List<HouseAccountCategory> findHouseAccountCategories(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId,
          @DefaultValue("false") @QueryParam(INCLUDE_INTERNAL) boolean includeInternal) throws RGuestException;

    /**
     * Create a House account category for a tenant & property
     *
     * @param tenantId             created house account category's tenant
     * @param propertyId           created house account category's property
     * @param houseAccountCategory HouseAccountCategory model to save
     * @return Created HouseAccountCategory
     */
    @POST
    @CreatedOnSuccess
    @Validated(HouseAccountCategory.class)
    @Consumes(MediaType.APPLICATION_JSON)
    @Requires(Permission.WRITE_PROPERTY_CONFIG)
    HouseAccountCategory createHouseAccountCategory(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, HouseAccountCategory houseAccountCategory) throws RGuestException;

    /**
     * Retrieve a House account category
     *
     * @param tenantId   id of tenant where the house account category exists
     * @param propertyId id of the property where the house account category exists
     * @param id         House account category id to retrieve
     * @return Existing HouseAccountCategory for the tenant & property
     */
    @GET
    @Requires(Permission.READ_PROPERTY_CONFIG)
    @Path(ID_PATH)
    HouseAccountCategory getHouseAccountCategoryById(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @PathParam(RESOURCE_ID) String id) throws RGuestException;

    /**
     * Update a House account category
     *
     * @param tenantId             id of tenant where the house account category exists
     * @param propertyId           id of the property where the house account category exists
     * @param id                   House account category id to update
     * @param houseAccountCategory House account category payload to update
     * @return Updated House account category
     */
    @PUT
    @Path(ID_PATH)
    @Consumes(MediaType.APPLICATION_JSON)
    @Validated(HouseAccountCategory.class)
    @Requires(Permission.WRITE_PROPERTY_CONFIG)
    HouseAccountCategory updateHouseAccountCategory(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @PathParam(RESOURCE_ID) String id,
          HouseAccountCategory houseAccountCategory) throws RGuestException;

    /**
     * Deletes a House account category
     *
     * @param tenantId   id of tenant where the house account category exists
     * @param propertyId id of the property where the house account category exists
     * @param id         House account category id to delete
     */
    @DELETE
    @Path(ID_PATH)
    @Requires(Permission.WRITE_PROPERTY_CONFIG)
    void deleteHouseAccountCategory(@PathParam(TENANT_ID) String tenantId, @PathParam(PROPERTY_ID) String propertyId,
          @PathParam(RESOURCE_ID) String id) throws RGuestException;
}