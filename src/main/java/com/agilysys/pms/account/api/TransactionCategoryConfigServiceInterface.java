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

import com.agilysys.platform.common.exception.ServiceException;
import com.agilysys.platform.schema.Validated;
import com.agilysys.pms.account.model.TransactionCategory;
import com.agilysys.pms.common.api.annotation.CreatedOnSuccess;

/**
 * CRUD methods for TransactionCategory
 */
@Path("/tenants/{tenantId}/properties/{propertyId}/config/transactionCategories")
@Produces(MediaType.APPLICATION_JSON)
public interface TransactionCategoryConfigServiceInterface {
    public static final String TENANT_ID = "tenantId";
    public static final String PROPERTY_ID = "propertyId";
    public static final String CATEGORY_ID = "id";
    public static final String CATEGORY_ID_PATH = "{id}";
    public static final String INCLUDE_INTERNAL = "includeInternal";

    /**
     * Retrieve all TransactionCategories
     *
     * @param tenantId the tenantId to retrieve TransactionCategories for
     * @return List of TransactionCategory
     */
    @GET
    @PreAuthorize("hasPermission('Required', 'ReadPropertyConfig')")
    public List<TransactionCategory> getTransactionCategories(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId,
          @DefaultValue("false") @QueryParam(INCLUDE_INTERNAL) boolean includeInternal) throws ServiceException;

    /**
     * Retrieve a specific TransactionCategory
     *
     * @param tenantId   the tenantId to retrieve the TransactionCategory for
     * @param categoryId the ID of the TransactionCategories to retrieve
     * @return the TransactionCategory identified by categoryId
     */
    @GET
    @Path(CATEGORY_ID_PATH)
    @PreAuthorize("hasPermission('Required', 'ReadPropertyConfig')")
    public TransactionCategory getTransactionCategory(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @PathParam(CATEGORY_ID) String categoryId) throws ServiceException;

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
    @PreAuthorize("hasPermission('Required', 'WritePropertyConfig')")
    public TransactionCategory createTransactionCategory(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, TransactionCategory category) throws ServiceException;

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
    @PreAuthorize("hasPermission('Required', 'WritePropertyConfig')")
    public TransactionCategory updateTransactionCategory(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @PathParam(CATEGORY_ID) String categoryId,
          TransactionCategory category) throws ServiceException;

    /**
     * Delete an existing TransactionCategory
     *
     * @param tenantId   the tenantId to delete the TransactionCategory for
     * @param categoryId the ID of the TransactionCategories to delete
     */
    @DELETE
    @Path(CATEGORY_ID_PATH)
    @PreAuthorize("hasPermission('Required', 'WritePropertyConfig')")
    public void deleteTransactionCategory(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @PathParam(CATEGORY_ID) String categoryId) throws ServiceException;
}
