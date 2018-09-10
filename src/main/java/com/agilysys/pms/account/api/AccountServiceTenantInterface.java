/**
 * (C) 2018 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.api;

import java.util.List;
import java.util.Set;

import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.security.access.prepost.PreAuthorize;

import com.agilysys.platform.common.exception.ServiceException;
import com.agilysys.platform.common.rguest.exception.RGuestException;
import com.agilysys.pms.account.model.ARBalanceInfo;
import com.agilysys.pms.account.model.InvoiceBalanceResponse;

@Path(AccountServiceTenantInterface.BASE_PATH)
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface AccountServiceTenantInterface {
    String TENANT_ID = "tenantId";

    String PROPERTY_DATE = "propertyDate";
    String BASE_PATH = "/tenants/{" + TENANT_ID + "}/accounts";

    String AR_BALANCES_PATH = "/ar/balances";
    String CALCULATE_INVOICE_BALANCE = "/calculateBalance";
    String INVOICES_PATH = "/invoices";

    @GET
    @Path(AR_BALANCES_PATH)
    @PreAuthorize("hasPermission('Required', 'WriteAccountsReceivable')" +
          " or hasPermission('Required', 'UseAccountsReceivable') " +
          "or hasPermission('Required', 'ReadAccountsReceivable')")
    ARBalanceInfo getARAccountBalance(@PathParam(TENANT_ID) String tenantId,
          @DefaultValue("AGE_BY_PROPERTY_DATE") @QueryParam("type") String type) throws RGuestException, ServiceException;

    @PUT
    @Path(INVOICES_PATH + CALCULATE_INVOICE_BALANCE)
    @PreAuthorize("hasPermission('Required', 'WriteAccountsReceivable')" +
          " or hasPermission('Required', 'UseAccountsReceivable')")
    List<InvoiceBalanceResponse> updateInvoiceBalanceByInvoiceNumber(@PathParam(TENANT_ID) String tenantId,
          Set<String> invoiceNumbers)
          throws RGuestException, ServiceException;
}
