/*
 * (C) 2014 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.api;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.agilysys.common.model.rate.CompInfo;
import com.agilysys.common.model.rate.CompThreshold;
import com.agilysys.platform.common.rguest.exception.RGuestException;
import com.agilysys.platform.schema.Validated;
import com.agilysys.pms.common.security.Permission;
import com.agilysys.pms.common.security.Requires;

/**
 * CRUD methods for CompReason
 */
@Path("/tenants/{tenantId}/properties/{propertyId}/config")
@Produces(MediaType.APPLICATION_JSON)
public interface CompReasonInterface {
    String CODE = "code";
    String COMP_REASONS_PATH = "setup/accounts/compReasons";
    String COMP_REASONS_THRESHOLD_PATH = COMP_REASONS_PATH + "/threshold";
    String ID = "id";
    String PROPERTY_ID = "propertyId";

    /**
     * Retrieve all comp reasons
     *
     * @param tenantId   the tenantId to retrieve comp reasons for
     * @param propertyId the propertyId to retrieve comp reasons for
     * @return List of CompReason
     */
    @GET
    @Path("/compReasons")
    @Requires(Permission.READ_COMP_REASONS)
    List<CompInfo> getCompReasons(@PathParam(AccountServiceInterfaceV1.TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId) throws RGuestException;

    /**
     * Retrieve a comp reason by id
     *
     * @param tenantId   the tenantId to retrieve comp reasons for
     * @param propertyId the propertyId to retrieve comp reasons for
     * @param id         the id of the reason to retrieve
     * @return List of CompReason
     */
    @GET
    @Path("/compReasons/{id}")
    @Requires(Permission.READ_COMP_REASONS)
    CompInfo getCompReason(@PathParam(AccountServiceInterfaceV1.TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @PathParam(ID) String id) throws RGuestException;

    /**
     * Retrieve a comp reason by id
     *
     * @param tenantId   the tenantId to retrieve comp reasons for
     * @param propertyId the propertyId to retrieve comp reasons for
     * @param code       the id of the reason to retrieve
     * @return List of CompReason
     */
    @GET
    @Path("/compReasons/code/{code}")
    @Requires(Permission.READ_COMP_REASONS)
    CompInfo getCompReasonByCode(@PathParam(AccountServiceInterfaceV1.TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @PathParam(CODE) String code) throws RGuestException;

    /**
     * Add a CompReason
     *
     * @param tenantId   the tenantId to updateTaxGroup comp reasons for
     * @param propertyId the propertyId to updateTaxGroup comp reason for
     * @param compInfo   the list of comp reasons to change
     * @return the item to updateTaxGroup
     */
    @POST
    @Path("/compReasons")
    @Requires(Permission.WRITE_COMP_REASONS)
    @Validated(CompInfo.class)
    CompInfo addCompReason(@PathParam(AccountServiceInterfaceV1.TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, CompInfo compInfo) throws RGuestException;

    /**
     * Modify a CompReason
     *
     * @param tenantId   the tenantId to updateTaxGroup comp reasons for
     * @param propertyId the propertyId to updateTaxGroup comp reason for
     * @param id         the id of the comp reason to updateTaxGroup
     * @param compInfo   the list of comp reasons to change
     * @return the item to updateTaxGroup
     */
    @PUT
    @Path("/compReasons/{id}")
    @Requires(Permission.WRITE_COMP_REASONS)
    @Validated(CompInfo.class)
    CompInfo updateCompReason(@PathParam(AccountServiceInterfaceV1.TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @PathParam(ID) String id, CompInfo compInfo)
          throws RGuestException;

    /**
     * Set the comp threshold
     *
     * @param tenantId   the tenantId to set the comp threshold for
     * @param propertyId the propertyId to set comp threshold for
     */
    @PUT
    @Path("/compThreshold")
    @Requires(Permission.WRITE_COMP_REASONS)
    @Validated(CompThreshold.class)
    void setCompThreshold(@PathParam(AccountServiceInterfaceV1.TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, CompThreshold threshold) throws RGuestException;

    /**
     * Get the comp threshold
     *
     * @param tenantId   the tenantId to get the comp threshold for
     * @param propertyId the propertyId to get comp threshold for
     */
    @GET
    @Path("/compThreshold")
    @Requires(Permission.READ_COMP_REASONS)
    CompThreshold getCompThreshold(@PathParam(AccountServiceInterfaceV1.TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId) throws RGuestException;
}