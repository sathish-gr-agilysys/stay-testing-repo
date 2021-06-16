/*
 * (C) 2021 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.api;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.agilysys.platform.common.rguest.exception.RGuestException;
import com.agilysys.pms.common.tenantData.TenantData;

@Path(ARInterface.BASE_PATH)
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface ARInterface {
    String TENANT_ID = "tenantId";
    String PROPERTY_ID = "propertyId";
    String REMIT_TO = "/remitTo";
    String ID = "id";

    String BASE_PATH = "/tenants/{" + TENANT_ID + "}/properties/{" + PROPERTY_ID + "}";

    @GET
    @Path(REMIT_TO + "/addresses")
    List<TenantData> getRemitToAddresses(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId) throws RGuestException;

    @PUT
    @Path(REMIT_TO + "/addresses")
    List<TenantData> updateRemitToAddress(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, List<TenantData> tenantData) throws RGuestException;

    @GET
    @Path(REMIT_TO + "/address/{id}")
    List<TenantData> getRemitToAddress(@PathParam(TENANT_ID) String tenantId, @PathParam(ID) String id)
          throws RGuestException;
}