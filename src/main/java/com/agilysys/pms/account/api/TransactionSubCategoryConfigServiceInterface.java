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
import com.agilysys.pms.account.model.TransactionSubCategory;
import com.agilysys.pms.common.api.annotation.CreatedOnSuccess;

/**
 * CRUD methods for TransactionSubCategory
 */
@Path("/tenants/{tenantId}/properties/{propertyId}/config/transactionSubCategories")
public interface TransactionSubCategoryConfigServiceInterface {
    public static final String TENANT_ID = "tenantId";
    public static final String PROPERTY_ID = "propertyId";
    public static final String SUB_CATEGORY_ID = "id";
    public static final String SUB_CATEGORY_ID_PATH = "{id}";
    public static final String INCLUDE_INTERNAL = "includeInternal";

    /**
     * Retrieve all TransactionSubCategories
     *
     * @param tenantId the tenantId to retrieve TransactionSubCategories for
     * @return List of TransactionSubCategory
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @PreAuthorize("hasPermission('Required', 'ReadPropertyConfig')")
    public List<TransactionSubCategory> getTransactionSubCategories(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId,
          @DefaultValue("false") @QueryParam(INCLUDE_INTERNAL) boolean includeInternal) throws ServiceException;

    /**
     * Retrieve a specific TransactionSubCategory
     *
     * @param tenantId      the tenantId to retrieve the TransactionSubCategory for
     * @param subcategoryId the ID of the TransactionSubCategories to retrieve
     * @return the TransactionSubCategory identified by categoryId
     */
    @GET
    @Path(SUB_CATEGORY_ID_PATH)
    @Produces(MediaType.APPLICATION_JSON)
    @PreAuthorize("hasPermission('Required', 'ReadPropertyConfig')")
    public TransactionSubCategory getTransactionSubCategory(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @PathParam(SUB_CATEGORY_ID) String subcategoryId)
          throws ServiceException;

    /**
     * Create a new TransactionSubCategory
     *
     * @param tenantId    the tenantId to create a TransactionSubCategory for
     * @param subcategory the new TransactionSubCategory to persist
     * @return the newly create TransactionSubCategory with auto-generated ID
     */
    @POST
    @CreatedOnSuccess
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Validated(TransactionSubCategory.class)
    @PreAuthorize("hasPermission('Required', 'WritePropertyConfig')")
    public TransactionSubCategory createTransactionSubCategory(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, TransactionSubCategory subcategory) throws ServiceException;

    /**
     * Modify an existing TransactionSubCategory
     *
     * @param tenantId      the tenantId to modify the TransactionSubCategory for
     * @param subcategoryId the ID of the TransactionSubCategories to modify
     * @param subcategory   the modified TransactionSubCategory to persist
     * @return the modified TransactionSubCategory
     */
    @PUT
    @Path(SUB_CATEGORY_ID_PATH)
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Validated(TransactionSubCategory.class)
    @PreAuthorize("hasPermission('Required', 'WritePropertyConfig')")
    public TransactionSubCategory updateTransactionSubCategory(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @PathParam(SUB_CATEGORY_ID) String subcategoryId,
          TransactionSubCategory subcategory) throws ServiceException;

    /**
     * Delete an existing TransactionSubCategory
     *
     * @param tenantId      the tenantId to delete the TransactionSubCategory for
     * @param subcategoryId the ID of the TransactionSubCategories to delete
     */
    @DELETE
    @Path(SUB_CATEGORY_ID_PATH)
    @Produces(MediaType.APPLICATION_JSON)
    @PreAuthorize("hasPermission('Required', 'WritePropertyConfig')")
    public void deleteTransactionSubCategory(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @PathParam(SUB_CATEGORY_ID) String subcategoryId)
          throws ServiceException;
}
