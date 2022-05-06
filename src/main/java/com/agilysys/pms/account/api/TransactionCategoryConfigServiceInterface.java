/*
 * (C) 2019 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
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
import com.agilysys.pms.account.model.TransactionCategory;
import com.agilysys.pms.common.api.annotation.CreatedOnSuccess;
import com.agilysys.pms.common.security.Permission;
import com.agilysys.pms.common.security.Requires;

/**
 * CRUD methods for TransactionCategory
 */
@Path("/tenants/{tenantId}/properties/{propertyId}/config/transactionCategories")
@Produces(MediaType.APPLICATION_JSON)
public interface TransactionCategoryConfigServiceInterface {
    String TENANT_ID = "tenantId";
    String PROPERTY_ID = "propertyId";
    String CATEGORY_ID = "id";
    String CATEGORY_ID_PATH = "{id}";
    String INCLUDE_INTERNAL = "includeInternal";

    /**
     * Retrieve all TransactionCategories
     *
     * @param tenantId the tenantId to retrieve TransactionCategories for
     * @return List of TransactionCategory
     */
    @GET
    @Requires(Permission.READ_PROPERTY_CONFIG)
    List<TransactionCategory> getTransactionCategories(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId,
          @DefaultValue("false") @QueryParam(INCLUDE_INTERNAL) boolean includeInternal) throws RGuestException;

    /**
     * Retrieve a specific TransactionCategory
     *
     * @param tenantId   the tenantId to retrieve the TransactionCategory for
     * @param categoryId the ID of the TransactionCategories to retrieve
     * @return the TransactionCategory identified by categoryId
     */
    @GET
    @Path(CATEGORY_ID_PATH)
    @Requires(Permission.READ_PROPERTY_CONFIG)
    TransactionCategory getTransactionCategory(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @PathParam(CATEGORY_ID) String categoryId) throws RGuestException;

    /**
     * Create a new TransactionCategory
     *
     * @param tenantId the tenantId to create a TransactionCategory for
     * @param category the new TransactionCategory to persist
     * @return the newly create TransactionCategory with auto-generated ID
     */
    @POST
    @CreatedOnSuccess
    @Consumes(MediaType.APPLICATION_JSON)
    @Validated(TransactionCategory.class)
    @Requires(Permission.WRITE_PROPERTY_CONFIG)
    TransactionCategory createTransactionCategory(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, TransactionCategory category) throws RGuestException;

    /**
     * Modify an existing TransactionCategory
     *
     * @param tenantId   the tenantId to modify the TransactionCategory for
     * @param categoryId the ID of the TransactionCategories to modify
     * @param category   the modified TransactionCategory to persist
     * @return the modified TransactionCategory
     */
    @PUT
    @Path(CATEGORY_ID_PATH)
    @Consumes(MediaType.APPLICATION_JSON)
    @Validated(TransactionCategory.class)
    @Requires(Permission.WRITE_PROPERTY_CONFIG)
    TransactionCategory updateTransactionCategory(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @PathParam(CATEGORY_ID) String categoryId,
          TransactionCategory category) throws RGuestException;

    /**
     * Delete an existing TransactionCategory
     *
     * @param tenantId   the tenantId to delete the TransactionCategory for
     * @param categoryId the ID of the TransactionCategories to delete
     */
    @DELETE
    @Path(CATEGORY_ID_PATH)
    @Requires(Permission.WRITE_PROPERTY_CONFIG)
    void deleteTransactionCategory(@PathParam(TENANT_ID) String tenantId, @PathParam(PROPERTY_ID) String propertyId,
          @PathParam(CATEGORY_ID) String categoryId) throws RGuestException;
}