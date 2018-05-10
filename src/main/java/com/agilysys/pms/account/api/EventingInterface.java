/**
 * (C) 2015 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */

package com.agilysys.pms.account.api;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.a3badran.platform.logging.LogParam;
import org.a3badran.platform.logging.LogRequest;
import org.springframework.security.access.prepost.PreAuthorize;

import com.agilysys.platform.common.exception.ServiceException;
import com.agilysys.platform.common.rguest.exception.RGuestException;
import com.agilysys.pms.account.model.RawEventsResult;
import com.agilysys.pms.account.model.events.AccountPostEvent;
import com.agilysys.pms.account.payagent.model.events.PayAgentTransactionEvent;
import com.agilysys.pms.common.model.HistoryEventsResult;
import com.agilysys.pms.common.model.InvoiceEventsResults;

@Path(EventingInterface.BASE)
@Produces(MediaType.APPLICATION_JSON)
public interface EventingInterface {
    String BASE = "/tenants/{tenantId}/properties/{propertyId}";
    String INVOICE_BASE = "/invoices";
    String ACCOUNTS = "/accounts";
    String PAYAGENTTRANSACTION = "/payagent_transaction";
    String ID = "/{id}";
    String HISTORY = "/history";
    String RAW_EVENTS = "/events";
    String TENANT_ID = "tenantId";
    String PROPERTY_ID = "propertyId";
    String AR_NUMBER_BASE = "/arNumber/{arNumber}";
    String AR_NUMBER = "arNumber";

    @GET
    @Path(INVOICE_BASE + ID + HISTORY)
    @PreAuthorize("hasPermission('Required', 'ReadAccountsReceivable')")
    @LogRequest("getInvoiceHistoryEvents")
    HistoryEventsResult getInvoiceHistoryEvents(@PathParam(TENANT_ID) @LogParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) @LogParam(PROPERTY_ID) String propertyId,
          @PathParam("id") @LogParam("id") String invoiceId) throws RGuestException, ServiceException;

    @POST
    @Path(INVOICE_BASE + HISTORY)
    @PreAuthorize("hasPermission('Required', 'ReadAccountsReceivable')")
    @LogRequest("getInvoiceHistoryEvents")
    Map<String, HistoryEventsResult> getHistoryEventsForInvoices(
          @PathParam(TENANT_ID) @LogParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) @LogParam(PROPERTY_ID) String propertyId, Set<String> invoiceId)
          throws RGuestException, ServiceException;

    @GET
    @Path(INVOICE_BASE + HISTORY + AR_NUMBER_BASE)
    @PreAuthorize("hasPermission('Required', 'ReadAccountsReceivable')")
    @LogRequest("getInvoiceHistoryEvents")
    List<InvoiceEventsResults> getHistoryEventsForARNumber(
          @PathParam(TENANT_ID) @LogParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) @LogParam(PROPERTY_ID) String propertyId,
          @PathParam(AR_NUMBER) @LogParam(AR_NUMBER) String arNumber)
          throws RGuestException, ServiceException;

    @GET
    @Path(INVOICE_BASE + ID + RAW_EVENTS)
    @PreAuthorize("hasPermission('Required', 'ReadAccountsReceivable')")
    @LogRequest("getInvoiceRawEvents")
    RawEventsResult getInvoiceRawEvents(@PathParam(TENANT_ID) @LogParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) @LogParam(PROPERTY_ID) String propertyId,
          @PathParam("id") @LogParam("id") String invoiceId) throws RGuestException, ServiceException;

    @GET
    @Path(ACCOUNTS + ID + HISTORY)
    @PreAuthorize("hasPermission('Required', 'ReadAccounts')")
    @LogRequest("getAccountHistoryEvents")
    HistoryEventsResult getAccountHistoryEvents(@PathParam(TENANT_ID) @LogParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) @LogParam(PROPERTY_ID) String propertyId,
          @PathParam("id") @LogParam("id") String accountId) throws RGuestException, ServiceException;

    @GET
    @Path(PAYAGENTTRANSACTION + ID + RAW_EVENTS)
    @PreAuthorize("hasPermission('Required', 'ReadAccountsReceivable')")
    @LogRequest("getInvoiceHistoryEvents")
    List<PayAgentTransactionEvent> getPayAgentTransactionHistoryEvents(
          @PathParam(TENANT_ID) @LogParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) @LogParam(PROPERTY_ID) String propertyId,
          @PathParam("id") @LogParam("id") String invoiceId) throws RGuestException, ServiceException;

    @POST
    @Path(ACCOUNTS + ID + HISTORY)
    @PreAuthorize("hasPermission('Required', 'WriteAccounts')")
    @LogRequest("createAccountHistoryEvent")
    HistoryEventsResult createAccountHistoryEvent(@PathParam(TENANT_ID) @LogParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) @LogParam(PROPERTY_ID) String propertyId,
          @PathParam("id") @LogParam("id") String accountId, AccountPostEvent event)
          throws RGuestException, ServiceException;
}
