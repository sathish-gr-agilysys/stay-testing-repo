/**
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

import org.a3badran.platform.logging.LogParam;
import org.a3badran.platform.logging.LogRequest;
import org.springframework.security.access.prepost.PreAuthorize;

import com.agilysys.platform.common.exception.ServiceException;
import com.agilysys.pms.account.model.RawEventsResult;
import com.agilysys.pms.account.model.events.AccountPostEvent;
import com.agilysys.pms.account.payagent.model.events.PayAgentTransactionEvent;
import com.agilysys.pms.common.model.HistoryEventsResult;

@Path(EventingInterface.BASE)
@Produces(MediaType.APPLICATION_JSON)
public interface EventingInterface {
    static final String BASE = "/tenants/{tenantId}/properties/{propertyId}";
    static final String INVOICE_BASE = "/invoices";
    static final String ACCOUNTS = "/accounts";
    static final String PAYAGENTTRANSACTION = "/payagent_transaction";
    static final String ID = "/{id}";
    static final String HISTORY = "/history";
    static final String RAW_EVENTS = "/events";
    static final String TENANT_ID = "tenantId";
    static final String PROPERTY_ID = "propertyId";

    @GET
    @Path(INVOICE_BASE + ID + HISTORY)
    @PreAuthorize("hasPermission('Required', 'ReadAccountsReceivable')")
    @LogRequest("getInvoiceHistoryEvents")
    public HistoryEventsResult getInvoiceHistoryEvents(@PathParam(TENANT_ID) @LogParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) @LogParam(PROPERTY_ID) String propertyId,
          @PathParam("id") @LogParam("id") String invoiceId) throws ServiceException;

    @GET
    @Path(INVOICE_BASE + ID + RAW_EVENTS)
    @PreAuthorize("hasPermission('Required', 'ReadAccountsReceivable')")
    @LogRequest("getInvoiceRawEvents")
    public RawEventsResult getInvoiceRawEvents(@PathParam(TENANT_ID) @LogParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) @LogParam(PROPERTY_ID) String propertyId,
          @PathParam("id") @LogParam("id") String invoiceId) throws ServiceException;

    @GET
    @Path(ACCOUNTS + ID + HISTORY)
    @PreAuthorize("hasPermission('Required', 'ReadAccounts')")
    @LogRequest("getAccountHistoryEvents")
    public HistoryEventsResult getAccountHistoryEvents(@PathParam(TENANT_ID) @LogParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) @LogParam(PROPERTY_ID) String propertyId,
          @PathParam("id") @LogParam("id") String accountId) throws ServiceException;

    @GET
    @Path(PAYAGENTTRANSACTION + ID + RAW_EVENTS)
    @PreAuthorize("hasPermission('Required', 'ReadAccountsReceivable')")
    @LogRequest("getInvoiceHistoryEvents")
    public List<PayAgentTransactionEvent> getPayAgentTransactionHistoryEvents(
          @PathParam(TENANT_ID) @LogParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) @LogParam(PROPERTY_ID) String propertyId,
          @PathParam("id") @LogParam("id") String invoiceId) throws ServiceException;

    @POST
    @Path(ACCOUNTS + ID + HISTORY)
    @PreAuthorize("hasPermission('Required', 'WriteAccounts')")
    @LogRequest("createAccountHistoryEvent")
    public HistoryEventsResult createAccountHistoryEvent(@PathParam(TENANT_ID) @LogParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) @LogParam(PROPERTY_ID) String propertyId,
          @PathParam("id") @LogParam("id") String accountId, AccountPostEvent event) throws ServiceException;

}
