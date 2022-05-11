/*
 * (C) 2021 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.api;

import static com.agilysys.pms.account.api.AccountIntegrationInterface.BASE_PATH;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.agilysys.platform.common.rguest.exception.RGuestException;
import com.agilysys.pms.account.model.Payment;
import com.agilysys.pms.account.model.integration.InboundPostPaymentResult;

@Path(BASE_PATH)
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface AccountIntegrationInterface {

    String TENANT_ID = "tenantId";
    String PROPERTY_ID = "propertyId";
    String BASE_PATH = "/tenants/{" + TENANT_ID + "}/properties/{" + PROPERTY_ID + "}/integrations";

    @POST
    @Path("/postPayments")
    InboundPostPaymentResult postPayments(@PathParam(TENANT_ID) String tenantId, @PathParam(PROPERTY_ID) String propertyId, Payment payment)
          throws RGuestException;

}
