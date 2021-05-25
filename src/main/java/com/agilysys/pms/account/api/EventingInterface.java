/*
 * (C) 2015 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.api;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.agilysys.platform.common.rguest.exception.RGuestException;
import com.agilysys.pms.account.model.ARReportRequest;
import com.agilysys.pms.account.model.InvoicePaymentHistory;
import com.agilysys.pms.account.model.InvoiceUpdatedHistory;
import com.agilysys.pms.account.model.RawEventsResult;
import com.agilysys.pms.account.model.events.AccountPostEvent;
import com.agilysys.pms.account.payagent.model.events.PayAgentTransactionEvent;
import com.agilysys.pms.common.model.ARInvoiceEvents;
import com.agilysys.pms.common.model.HistoryEventsResult;
import com.agilysys.pms.common.security.Permission;
import com.agilysys.pms.common.security.Requires;

@Path(EventingInterface.BASE)
@Produces(MediaType.APPLICATION_JSON)
public interface EventingInterface {
    String BASE = "/tenants/{tenantId}/properties/{propertyId}";
    String INVOICE_BASE = "/invoices";
    String PAYMENT_BASE = "/payment";
    String ACCOUNTS = "/accounts";
    String PAYAGENTTRANSACTION = "/payagent_transaction";
    String ID = "/{id}";
    String HISTORY = "/history";
    String RAW_EVENTS = "/events";
    String TENANT_ID = "tenantId";
    String PROPERTY_ID = "propertyId";
    String AR_ACCOUNT_ID = "arAccountId";
    String AR_ACCOUNT_ID_PATH = "/{arAccountId}";
    String AR_NUMBER_BASE = "/arNumber";

    @GET
    @Path(INVOICE_BASE + ID + HISTORY)
    @Requires(Permission.READ_ACCOUNTS_RECEIVABLE)
    HistoryEventsResult getInvoiceHistoryEvents(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @PathParam("id") String invoiceId) throws RGuestException;

    @POST
    @Path(INVOICE_BASE + HISTORY + AR_NUMBER_BASE)
    @Requires(Permission.READ_ACCOUNTS_RECEIVABLE)
    List<ARInvoiceEvents> getInvoiceHistoryEventsForARNumber(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, ARReportRequest arReportRequest) throws RGuestException;

    @GET
    @Path(INVOICE_BASE + HISTORY + AR_ACCOUNT_ID_PATH)
    @Requires(Permission.READ_ACCOUNTS_RECEIVABLE)
    List<InvoiceUpdatedHistory> getInvoiceHistoryEventsForARAccount(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @PathParam(AR_ACCOUNT_ID) String arAccountId)
          throws RGuestException;

    @GET
    @Path(PAYMENT_BASE + HISTORY + AR_ACCOUNT_ID_PATH)
    @Requires(Permission.READ_ACCOUNTS_RECEIVABLE)
    List<InvoicePaymentHistory> getPaymentHistoryEventsForARAccount(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @PathParam(AR_ACCOUNT_ID) String arAccountId)
          throws RGuestException;

    @GET
    @Path(INVOICE_BASE + ID + RAW_EVENTS)
    @Requires(Permission.READ_ACCOUNTS_RECEIVABLE)
    RawEventsResult getInvoiceRawEvents(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @PathParam("id") String invoiceId) throws RGuestException;

    @GET
    @Path(ACCOUNTS + ID + HISTORY)
    @Requires(Permission.READ_ACCOUNTS)
    HistoryEventsResult getAccountHistoryEvents(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @PathParam("id") String accountId) throws RGuestException;

    @GET
    @Path(PAYAGENTTRANSACTION + ID + RAW_EVENTS)
    @Requires(Permission.READ_ACCOUNTS_RECEIVABLE)
    List<PayAgentTransactionEvent> getPayAgentTransactionHistoryEvents(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @PathParam("id") String invoiceId) throws RGuestException;

    @POST
    @Path(ACCOUNTS + ID + HISTORY)
    @Requires(Permission.WRITE_ACCOUNTS)
    HistoryEventsResult createAccountHistoryEvent(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @PathParam("id") String accountId, AccountPostEvent event)
          throws RGuestException;
}