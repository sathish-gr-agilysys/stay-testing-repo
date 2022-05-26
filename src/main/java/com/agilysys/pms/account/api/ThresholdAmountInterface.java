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

import com.agilysys.platform.common.rguest.exception.RGuestException;
import com.agilysys.pms.account.model.ThresholdAmount;
import com.agilysys.pms.common.api.annotation.CreatedOnSuccess;

@Path("/tenants/{tenantId}/properties/{propertyId}/config/thresholdAmount")
public interface ThresholdAmountInterface {
    String TENANT_ID = "tenantId";
    String PROPERTY_ID = "propertyId";
    String THRESHOLD_AMOUNT_ID = "id";
    String THRESHOLD_METHOD_ID_PATH = "{id}";

    @POST
    @CreatedOnSuccess
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    ThresholdAmount createThresholdAmount(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, ThresholdAmount thresholdAmount) throws RGuestException;

    @GET
    @Path(THRESHOLD_METHOD_ID_PATH)
    @Produces(MediaType.APPLICATION_JSON)
    ThresholdAmount getThresholdAmount(@PathParam(TENANT_ID) String tenantId, @PathParam(PROPERTY_ID) String propertyId,
          @PathParam(THRESHOLD_AMOUNT_ID) String thresholdAmountId) throws RGuestException;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    List<ThresholdAmount> getAllThresholdAmount(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId) throws RGuestException;

    @PUT
    @Path(THRESHOLD_METHOD_ID_PATH)
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    ThresholdAmount updateThresholdAmount(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @PathParam(THRESHOLD_AMOUNT_ID) String thresholdAmountId,
          ThresholdAmount thresholdAmount) throws RGuestException;
}