/**
 * (C) 2018 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.api;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.security.access.prepost.PreAuthorize;

import com.agilysys.platform.common.exception.ServiceException;
import com.agilysys.platform.common.rguest.exception.RGuestException;
import com.agilysys.pms.account.model.CentralARRequest;
import com.agilysys.pms.account.model.CentralARView;
import com.agilysys.pms.common.api.annotation.CreatedOnSuccess;

@Path(AccountServiceTenantInterface.BASE_PATH)
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface AccountServiceTenantInterface {
    String TENANT_ID = "tenantId";

    String BASE_PATH = "/tenants/{" + TENANT_ID + "}/accounts";

    String INVOICES_PATH = "/invoices";

    String PREFERRED_COMMUNICATION = "/preferredCommunication";

    @POST
    @CreatedOnSuccess
    @Path(INVOICES_PATH)
    List<CentralARView> createInvoices(@PathParam(TENANT_ID) String tenantId,
          CentralARRequest centralARRequest) throws RGuestException, ServiceException;

    @POST
    @CreatedOnSuccess
    @Path(PREFERRED_COMMUNICATION)
    List<CentralARView> getPreferredCommunication(@PathParam(TENANT_ID) String tenantId,
          CentralARRequest centralARRequest) throws RGuestException, ServiceException;
}
