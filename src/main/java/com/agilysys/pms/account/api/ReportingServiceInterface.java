/**
 * (C) 2014 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.api;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.joda.time.LocalDate;
import org.springframework.security.access.prepost.PreAuthorize;

import com.agilysys.platform.common.exception.ServiceException;
import com.agilysys.platform.schema.Validated;
import com.agilysys.pms.account.model.AccountBalancesInfo;
import com.agilysys.pms.account.model.AccountBalancesRequest;
import com.agilysys.pms.account.model.Cashier;
import com.agilysys.pms.account.model.NightAuditReport;
import com.agilysys.pms.account.model.RecurringChargesReportResult;
import com.agilysys.pms.account.model.RevenueReportResult;
import com.agilysys.pms.account.model.TaxExemptReportResult;
import com.agilysys.pms.account.model.TransactionReportItem;
import com.agilysys.pms.account.model.TransactionReportRequest;
import com.agilysys.pms.account.model.TransactionToDateTotalsResult;

@Path("/tenants/{tenantId}/properties/{propertyId}/reports")
public interface ReportingServiceInterface {
    public static final String LEDGER_PATH = "/ledger";
    public static final String CASHIER_PATH = "/cashier";
    public static final String CASHIERS_LIST_PATH = "/cashiersList";
    public static final String TRANS_PATH = "/transaction";
    public static final String TO_DATE_TOTALS_PATH = "/toDateTotals";
    public static final String ACCOUNT_BALANCES_PATH = "/accountBalances";
    public static final String REVENUE_PATH = "/revenueDetails";
    public static final String RECURRING_CHARGES_PATH = "/recurringCharges";
    public static final String TENANT_ID = "tenantId";
    public static final String PROPERTY_ID = "propertyId";
    public static final String PROPERTY_DATE = "propertyDate";
    public static final String START_DATE = "startDate";
    public static final String END_DATE = "endDate";
    public static final String ROOM_REVENUE = "roomRevenue";
    public static final String BY_CASHIER = "byCashier";
    public static final String TAX_EXEMPT_ACCOUNTS = "/taxExemptAccounts";

    /**
     * get the ledger report
     *
     * @param tenantId     the tenant ID
     * @param propertyId   the property ID
     * @param propertyDate the propertyDate to get the report for
     */
    @GET
    @Path(LEDGER_PATH)
    @Produces(MediaType.APPLICATION_JSON)
    @PreAuthorize("hasPermission('Required', 'DateRoll')")
    public List<NightAuditReport> ledgerReport(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @QueryParam(PROPERTY_DATE) LocalDate propertyDate)
          throws ServiceException;

    /**
     * get the cashier report
     *
     * @param tenantId     the tenant ID
     * @param propertyId   the property ID
     * @param propertyDate the propertyDate to get the report for
     */
    @GET
    @Path(CASHIER_PATH)
    @Produces(MediaType.APPLICATION_JSON)
    @PreAuthorize("hasPermission('Required', 'DateRoll')")
    public List<NightAuditReport> cashierReport(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @QueryParam(PROPERTY_DATE) LocalDate propertyDate)
          throws ServiceException;

    /**
     * get the transaction report
     *
     * @param tenantId     the tenant ID
     * @param propertyId   the property ID
     * @param propertyDate the propertyDate to get the report for
     */
    @GET
    @Path(TRANS_PATH)
    @Produces(MediaType.APPLICATION_JSON)
    @PreAuthorize("hasPermission('Required', 'ReadReports')")
    public List<TransactionReportItem> getTransactionReport(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @QueryParam(PROPERTY_DATE) LocalDate propertyDate)
          throws ServiceException;

    /**
     * get the transaction report
     *
     * @param tenantId   the tenant ID
     * @param propertyId the property ID
     * @param request    the body request with filter to get the report for
     */
    @POST
    @Path(TRANS_PATH)
    @Produces(MediaType.APPLICATION_JSON)
    @PreAuthorize("hasPermission('Required', 'ReadReports')")
    List<TransactionReportItem> getTransactionReportByAccountIds(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, TransactionReportRequest request)
          throws ServiceException;
    /**
     * Retrieves MTD/YTD transaction totals broken down by item ID. Optionally, includes a further breakdown by
     * cashier.
     *
     * @param tenantId
     * @param propertyId
     * @param propertyDate
     * @param breakdownByCashier
     * @return
     */
    @GET
    @Path(TRANS_PATH + TO_DATE_TOTALS_PATH)
    @Produces(MediaType.APPLICATION_JSON)
    @PreAuthorize("hasPermission('Required', 'ReadReports')")
    public TransactionToDateTotalsResult getTransactionToDateTotals(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @QueryParam(PROPERTY_DATE) LocalDate propertyDate,
          @QueryParam(BY_CASHIER) Boolean breakdownByCashier) throws ServiceException;

    /**
     * retrieve revenue detail information for given dates
     *
     * @param tenantId
     * @param propertyId
     * @param startDate
     * @param endDate
     * @param isRoomRevenue
     * @return
     */
    @GET
    @Path(REVENUE_PATH)
    @Produces(MediaType.APPLICATION_JSON)
    @PreAuthorize("hasPermission('Required', 'ReadReports')")
    public RevenueReportResult getRevenueDetailReport(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @QueryParam(START_DATE) LocalDate startDate,
          @QueryParam(END_DATE) LocalDate endDate, @QueryParam(ROOM_REVENUE) Boolean isRoomRevenue);

    /**
     * retrieve recurring charge detail information for a given date
     *
     * @param tenantId
     * @param propertyId
     * @param date
     * @return
     */
    @GET
    @Path(RECURRING_CHARGES_PATH)
    @Produces(MediaType.APPLICATION_JSON)
    @PreAuthorize("hasPermission('Required', 'ReadReports')")
    public RecurringChargesReportResult getRecurringChargesReport(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @QueryParam("date") LocalDate date);

    /**
     * retrieve account tax exemption for given dates
     *
     * @param tenantId
     * @param propertyId
     * @param startDate
     * @param endDate
     * @return
     */
    @GET
    @Path(TAX_EXEMPT_ACCOUNTS)
    @Produces(MediaType.APPLICATION_JSON)
    @PreAuthorize("hasPermission('Required', 'ReadReports')")
    public TaxExemptReportResult getTaxExemptReport(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @QueryParam(START_DATE) LocalDate startDate,
          @QueryParam(END_DATE) LocalDate endDate);

    /**
     * @deprecated use {@link  #getAccountBalances(String, String,
     * com.agilysys.pms.account.model.AccountBalancesRequest)}
     * instead.
     */
    @GET
    @Path(ACCOUNT_BALANCES_PATH)
    @Produces(MediaType.APPLICATION_JSON)
    @PreAuthorize("hasPermission('Required', 'ReadReports')")
    @Deprecated
    public AccountBalancesInfo getAccountBalances(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId) throws ServiceException;

    /**
     * retrieves account folio balance information for accounts filtered by the contents of the request
     *
     * @param request
     * @return
     * @throws ServiceException
     */
    @POST
    @Path(ACCOUNT_BALANCES_PATH)
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Validated(AccountBalancesRequest.class)
    @PreAuthorize("hasPermission('Required', 'ReadAccounts') or hasPermission('Required', 'ReadReports')")
    public AccountBalancesInfo getAccountBalances(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, AccountBalancesRequest request) throws ServiceException;

    /**
     * Lists all cashiers associated with ledger transactions for the given tenant and property
     * that are associated with transactions between the specified start and end dates.
     */
    @GET
    @Path(CASHIERS_LIST_PATH)
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @PreAuthorize("hasPermission('Required', 'ReadAccounts') or hasPermission('Required', 'ReadReports')")
    public List<Cashier> getCashiersList(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @QueryParam(START_DATE) LocalDate startDate,
          @QueryParam(END_DATE) LocalDate endDate) throws ServiceException;
}
