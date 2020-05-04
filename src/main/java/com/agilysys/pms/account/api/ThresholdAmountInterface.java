/*
 * (C) 2020 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
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

import org.springframework.security.access.prepost.PreAuthorize;

import com.agilysys.platform.common.rguest.exception.RGuestException;
import com.agilysys.pms.account.model.PaymentMethod;
import com.agilysys.pms.account.model.ThresholdAmount;
import com.agilysys.pms.common.api.annotation.CreatedOnSuccess;

@Path("/tenants/{tenantId}/properties/{propertyId}/config/thresholdAmount")
public interface ThresholdAmountInterface {
    String TENANT_ID = "tenantId";
    String PROPERTY_ID = "propertyId";
    String THRESHOLD_AMOUNT_ID = "id";
    String THRESHOLD_METHOD_ID_PATH = "{id}";


    /**
     * Create a new ThresholdAmount
     *
     * @param tenantId      the tenantId to create a ThresholdAmount for
     * @param propertyId    the propertyId to create a ThresholdAmount for
     * @param thresholdAmount the new ThresholdAmount to persist
     * @return the newly create ThresholdAmount with auto-generated ID
     */
    @POST
    @CreatedOnSuccess
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    ThresholdAmount createThresholdAmount(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, ThresholdAmount thresholdAmount) throws RGuestException;

    /**
     * Retrieve a specific ThresholdAmount
     *
     * @param tenantId          the tenantId to retrieve the ThresholdAmount for
     * @param propertyId        the propertyId to retrieve ThresholdAmount for
     * @param thresholdAmountId the ID of the ThresholdAmount to retrieve
     * @return the ThresholdAmount identified by itemId
     */
    @GET
    @Path(THRESHOLD_METHOD_ID_PATH)
    @Produces(MediaType.APPLICATION_JSON)
    ThresholdAmount getThresholdAmount(@PathParam(TENANT_ID) String tenantId, @PathParam(PROPERTY_ID) String propertyId,
          @PathParam(THRESHOLD_AMOUNT_ID) String thresholdAmountId) throws RGuestException;

    /**
     * Retrieve all PaymentMethods
     *
     * @param tenantId   the tenantId to retrieve ThresholdAmount for
     * @param propertyId the propertyId to retrieve ThresholdAmount for
     * @return List of ThresholdAmount
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    List<ThresholdAmount> getAllThresholdAmount(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId) throws RGuestException;

    /**
     * Modify an existing ThresholdAmount
     *
     * @param tenantId          the tenantId to modify the ThresholdAmount for
     * @param propertyId        the propertyId to modify ThresholdAmount for
     * @param thresholdAmountId the ID of the ThresholdAmount to modify
     * @param thresholdAmount   the modified ThresholdAmount to persist
     * @return the modified ThresholdAmount
     */
    @PUT
    @Path(THRESHOLD_METHOD_ID_PATH)
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    ThresholdAmount updateThresholdAmount(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @PathParam(THRESHOLD_AMOUNT_ID) String thresholdAmountId,
          ThresholdAmount thresholdAmount) throws RGuestException;








}
