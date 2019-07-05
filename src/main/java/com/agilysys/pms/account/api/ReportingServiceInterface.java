/**
 * (C) 2014 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.api;

import java.util.List;
import java.util.Map;
import java.util.Set;

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
import com.agilysys.platform.common.rguest.exception.RGuestException;
import com.agilysys.platform.schema.Validated;
import com.agilysys.pms.account.model.AccountBalancesInfo;
import com.agilysys.pms.account.model.AccountBalancesRequest;
import com.agilysys.pms.account.model.Cashier;
import com.agilysys.pms.account.model.NightAuditReport;
import com.agilysys.pms.account.model.RecurringChargesReportResult;
import com.agilysys.pms.account.model.ReservationRevenueReportItem;
import com.agilysys.pms.account.model.RevenueReportItem;
import com.agilysys.pms.account.model.RevenueReportResult;
import com.agilysys.pms.account.model.RoomRevenueItem;
import com.agilysys.pms.account.model.TaxExemptReportResult;
import com.agilysys.pms.account.model.TransactionReportItem;
import com.agilysys.pms.account.model.TransactionReportRequest;
import com.agilysys.pms.account.model.TransactionReportResponse;
import com.agilysys.pms.account.model.TransactionToDateTotalsResult;

@Path("/tenants/{tenantId}/properties/{propertyId}/reports")
public interface ReportingServiceInterface {
    String LEDGER_PATH = "/ledger";
    String CASHIER_PATH = "/cashier";
    String CASHIERS_LIST_PATH = "/cashiersList";
    String TO_DATE_TOTALS_PATH = "/toDateTotals";
    String TRANS_PATH = "/transaction";
    String ACCOUNT_BALANCES_PATH = "/accountBalances";
    String RESERVATION_ROOM_REVENUE_PATH = "/reservationRoomRevenue";
    String REVENUE_PATH = "/revenueDetails";
    String REVENUE_BY_ACCOUNT="revenueByAccount";
    String REVENUE_PATH_BY_ROOM = "/revenueDetailsByRoom";
    String RECURRING_CHARGES_PATH = "/recurringCharges";
    String INVENTORY_RECURRING_CHARGES_PATH = "/inventoryRecurringCharges";
    String TENANT_ID = "tenantId";
    String PROPERTY_ID = "propertyId";
    String PROPERTY_DATE = "propertyDate";
    String START_DATE = "startDate";
    String END_DATE = "endDate";
    String ROOM_REVENUE = "roomRevenue";
    String REVENUE_OCCUPANCY = "revenueOccupancy";
    String ALL_REVENUE = "allRevenue";
    String BY_CASHIER = "byCashier";
    String TAX_EXEMPT_ACCOUNTS = "/taxExemptAccounts";
    String SOURCE_ID = "sourceId";
    String DEPARTMENT_REVENUE = "/departmentRevenue";
    String INCLUDE_MTD_TRANSACTIONS = "includeMtdTransactions";

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
    List<NightAuditReport> ledgerReport(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @QueryParam(PROPERTY_DATE) LocalDate propertyDate)
          throws RGuestException, ServiceException;

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
    List<NightAuditReport> cashierReport(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @QueryParam(PROPERTY_DATE) LocalDate propertyDate)
          throws RGuestException, ServiceException;

    /**
     * This endpoint is deprecated in favor of getTransactionReportByAccountIdsAndPropertyDateRange
     * get the transaction report
     *
     * @param tenantId     the tenant ID
     * @param propertyId   the property ID
     * @param propertyDate the propertyDate to get the report for
     */
    @Deprecated
    @GET
    @Path(TRANS_PATH)
    @Produces(MediaType.APPLICATION_JSON)
    @PreAuthorize("hasPermission('Required', 'ReadReports')")
    List<TransactionReportItem> getTransactionReport(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @QueryParam(PROPERTY_DATE) LocalDate propertyDate)
          throws RGuestException, ServiceException;

    /**
     * This endpoint is to fetch all the transaction of given date and include the MTD transactions, if
     * INCLUDE_MTD_TRANSACTIONS is true
     */
    @GET
    @Path(DEPARTMENT_REVENUE + TRANS_PATH)
    @Produces(MediaType.APPLICATION_JSON)
    @PreAuthorize("hasPermission('Required', 'ReadReports')")
    List<TransactionReportItem> getTransactionReport(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @QueryParam(PROPERTY_DATE) LocalDate propertyDate,
          @QueryParam(INCLUDE_MTD_TRANSACTIONS) boolean includeMTDTransactions)
          throws RGuestException, ServiceException;

    /**
     * get the transaction report
     *
     * @param tenantId   the tenant ID
     * @param propertyId the property ID
     * @param request    TransactionReportRequest object that holds accountIds filter
     * @return TransactionReportResponse object that holds TransactionReportItem mapped by account id
     * @throws ServiceException
     */
    @POST
    @Path(TRANS_PATH)
    @Produces(MediaType.APPLICATION_JSON)
    @PreAuthorize("hasPermission('Required', 'ReadReports')")
    TransactionReportResponse getTransactions(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, TransactionReportRequest request)
          throws RGuestException, ServiceException;

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
    TransactionToDateTotalsResult getTransactionToDateTotals(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @QueryParam(PROPERTY_DATE) LocalDate propertyDate,
          @QueryParam(BY_CASHIER) Boolean breakdownByCashier) throws RGuestException, ServiceException;

    /**
     * retrieve revenue detail information for given dates
     *
     * @param tenantId
     * @param propertyId
     * @param startDate
     * @param endDate
     * @param roomRevenue
     * @return
     */
    @GET
    @Path(REVENUE_PATH)
    @Produces(MediaType.APPLICATION_JSON)
    @PreAuthorize("hasPermission('Required', 'ReadReports')")
    RevenueReportResult getRevenueDetailReport(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @QueryParam(START_DATE) LocalDate startDate,
          @QueryParam(END_DATE) LocalDate endDate, @QueryParam(ROOM_REVENUE) Boolean roomRevenue,
          @QueryParam(REVENUE_OCCUPANCY) Boolean revenueOccupancy)
          throws RGuestException, ServiceException;

    @GET
    @Path(REVENUE_PATH_BY_ROOM)
    @Produces(MediaType.APPLICATION_JSON)
    @PreAuthorize("hasPermission('Required', 'ReadReports')")
    List<ReservationRevenueReportItem> getRevenueDetailReportByRoom(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @QueryParam(START_DATE) LocalDate startDate,
          @QueryParam(END_DATE) LocalDate endDate, @QueryParam(ROOM_REVENUE) Boolean roomRevenue,
          @QueryParam(REVENUE_OCCUPANCY) Boolean revenueOccupancy)
          throws RGuestException, ServiceException;

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
    RecurringChargesReportResult getRecurringChargesReport(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @QueryParam("date") LocalDate date)
          throws RGuestException, ServiceException;

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
    TaxExemptReportResult getTaxExemptReport(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @QueryParam(START_DATE) LocalDate startDate,
          @QueryParam(END_DATE) LocalDate endDate, @QueryParam(ROOM_REVENUE) Boolean roomRevenueOnly)
          throws RGuestException, ServiceException;

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
    AccountBalancesInfo getAccountBalances(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId) throws RGuestException, ServiceException;

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
    AccountBalancesInfo getAccountBalances(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, AccountBalancesRequest request)
          throws RGuestException, ServiceException;

    /**
     * Lists all cashiers associated with ledger transactions for the given tenant and property
     * that are associated with transactions between the specified start and end dates.
     */
    @GET
    @Path(CASHIERS_LIST_PATH)
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @PreAuthorize("hasPermission('Required', 'ReadAccounts') or hasPermission('Required', 'ReadReports')")
    List<Cashier> getCashiersList(@PathParam(TENANT_ID) String tenantId, @PathParam(PROPERTY_ID) String propertyId,
          @QueryParam(START_DATE) LocalDate startDate, @QueryParam(END_DATE) LocalDate endDate)
          throws RGuestException, ServiceException;

    /**
     * retrieve inventory recurring charge detail information for the given date range
     *
     * @param tenantId
     * @param propertyId
     * @param startDate
     * @param endDate
     * @param sourceId
     * @return
     */
    @GET
    @Path(INVENTORY_RECURRING_CHARGES_PATH)
    @Produces(MediaType.APPLICATION_JSON)
    @PreAuthorize("hasPermission('Required', 'ReadReports')")
    RecurringChargesReportResult getInventoryRecurringChargesReport(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @QueryParam(START_DATE) LocalDate startDate,
          @QueryParam(END_DATE) LocalDate endDate, @QueryParam(SOURCE_ID) String sourceId)
          throws RGuestException, ServiceException;

    /**
     * Retrieve room revenue detail for the given reservation identifiers.
     *
     * @param tenantId
     * @param propertyId
     * @return
     */
    @POST
    @Path(RESERVATION_ROOM_REVENUE_PATH)
    @Produces(MediaType.APPLICATION_JSON)
    @PreAuthorize("hasPermission('Required', 'ReadReports')")
    Map<String, RoomRevenueItem> getRoomRevenueForReservations(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @QueryParam(START_DATE) LocalDate startDate,
          @QueryParam(END_DATE) LocalDate endDate, Set<String> reservationIds) throws RGuestException, ServiceException;
}

