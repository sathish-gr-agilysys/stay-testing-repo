/*
 * (C) 2018 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.api;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.ws.rs.Consumes;
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

import com.agilysys.platform.common.rguest.exception.RGuestException;
import com.agilysys.pms.account.model.ARBalanceInfo;
import com.agilysys.pms.account.model.AccountSummary;
import com.agilysys.pms.account.model.CentralARRequest;
import com.agilysys.pms.account.model.CentralARView;
import com.agilysys.pms.account.model.InvoiceBalanceResponse;
import com.agilysys.pms.account.model.TenantStatementRequest;
import com.agilysys.pms.account.model.TenantStatementResponse;
import com.agilysys.pms.common.api.annotation.CreatedOnSuccess;
import com.agilysys.pms.common.tenantData.TenantData;

@Path(AccountServiceTenantInterface.BASE_PATH)
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface AccountServiceTenantInterface {
    String TENANT_ID = "tenantId";

    String PROPERTY_DATE = "propertyDate";
    String BASE_PATH = "/tenants/{" + TENANT_ID + "}/accounts";

    String AR_BALANCES_PATH = "/ar/balances";
    String AR_STATEMENTS_PATH = "/ar/statements";
    String CALCULATE_INVOICE_BALANCE = "/calculateBalance";
    String INVOICES_PATH = "/invoices";
    String ID = "id";
    String PREFERRED_COMMUNICATION = "/preferredCommunication";
    String REMIT_TO = "/remitTo";
    String OPEN_AR_ACCOUNT = "/openARAccounts";
    String OPEN_GROUP_ACCOUNT = "/openGroupAccounts";

    @GET
    @Path(AR_BALANCES_PATH)
    ARBalanceInfo getARAccountBalance(@PathParam(TENANT_ID) String tenantId,
          @DefaultValue("AGE_BY_PROPERTY_DATE") @QueryParam("type") String type) throws RGuestException;

    @PUT
    @Path(INVOICES_PATH + CALCULATE_INVOICE_BALANCE)
    List<InvoiceBalanceResponse> updateInvoiceBalanceByInvoiceNumber(@PathParam(TENANT_ID) String tenantId,
          Set<String> invoiceNumbers) throws RGuestException;

    @POST
    @CreatedOnSuccess
    @Path(INVOICES_PATH)
    List<CentralARView> createInvoices(@PathParam(TENANT_ID) String tenantId, CentralARRequest centralARRequest)
          throws RGuestException;

    @POST
    @CreatedOnSuccess
    @Path(AR_STATEMENTS_PATH)
    TenantStatementResponse createStatements(@PathParam(TENANT_ID) String tenantId,
          TenantStatementRequest tenantStatementRequest) throws RGuestException;

    @POST
    @CreatedOnSuccess
    @Path(PREFERRED_COMMUNICATION)
    List<CentralARView> getPreferredCommunication(@PathParam(TENANT_ID) String tenantId,
          CentralARRequest centralARRequest) throws RGuestException;

    @POST
    @Path(OPEN_AR_ACCOUNT)
    Map<String, List<AccountSummary>> getOpenARAccountsByReferenceIds(@PathParam(TENANT_ID) String tenantId,
          Set<String> referenceIds) throws RGuestException;

    @POST
    @Path(OPEN_GROUP_ACCOUNT)
    @PreAuthorize("hasPermission('Required', 'ReadAccounts')")
    Map<String, String> getOpenPendingGroupAccountIds(@PathParam(TENANT_ID) String tenantId,
          Set<String> groupIds) throws RGuestException;
}
