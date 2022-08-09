/*
 * (C) 2014 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.api;

import static com.agilysys.pms.account.api.PointRedemptionConfigServiceInterface.BASE;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.agilysys.platform.common.rguest.exception.RGuestException;
import com.agilysys.pms.account.model.PointRedemption;

@Path(BASE)
@Produces(MediaType.APPLICATION_JSON)
public interface PointRedemptionConfigServiceInterface {
    String ID = "id";
    String TENANT_ID = "tenantId";
    String PROPERTY_ID = "propertyId";
    String TENANT_TEMPLATE = "{" + TENANT_ID + "}";
    String PROPERTY_TEMPLATE = "{" + PROPERTY_ID + "}";
    String BASE = "/tenants/" + TENANT_TEMPLATE + "/properties/" + PROPERTY_TEMPLATE + "/config";
    String POINT_REDEMPTION_FLOW_CONFIG = "/pointRedemptionConfig";

    @GET
    @Path(POINT_REDEMPTION_FLOW_CONFIG)
    List<PointRedemption> getPointRedemptionConfig(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId) throws RGuestException;

    @POST
    @Path(POINT_REDEMPTION_FLOW_CONFIG)
    PointRedemption addPointRedemptionConfig(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, PointRedemption pointRedemption) throws RGuestException;

    @PUT
    @Path(POINT_REDEMPTION_FLOW_CONFIG + "/{id}")
    PointRedemption updatePointRedemptionConfig(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @PathParam(ID) String id, PointRedemption pointRedemption)
          throws RGuestException;

}
