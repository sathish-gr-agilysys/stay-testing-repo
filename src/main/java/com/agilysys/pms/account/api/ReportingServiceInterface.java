/*
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

import com.agilysys.platform.common.rguest.exception.RGuestException;
import com.agilysys.platform.schema.Validated;
import com.agilysys.pms.account.model.AccountBalancesInfo;
import com.agilysys.pms.account.model.AccountBalancesRequest;
import com.agilysys.pms.account.model.AuthorizerCompReportRequest;
import com.agilysys.pms.account.model.AuthorizerCompReportResponse;
import com.agilysys.pms.account.model.Cashier;
import com.agilysys.pms.account.model.DepositCollectionStatusEmailRequest;
import com.agilysys.pms.account.model.GLCodeTemplate;
import com.agilysys.pms.account.model.GLCodeTemplateRequest;
import com.agilysys.pms.account.model.GeneralAvailabilityStatsResult;
import com.agilysys.pms.account.model.GroupRevenueReportItem;
import com.agilysys.pms.account.model.NightAuditReport;
import com.agilysys.pms.account.model.RecurringChargesReportResult;
import com.agilysys.pms.account.model.ReservationRevenueReportItem;
import com.agilysys.pms.account.model.RevenueDetailReportRequest;
import com.agilysys.pms.account.model.RevenueReportResult;
import com.agilysys.pms.account.model.RoomRevenueItem;
import com.agilysys.pms.account.model.StatsByBuildingRequest;
import com.agilysys.pms.account.model.TaxExemptReportResult;
import com.agilysys.pms.account.model.TransactionReportItem;
import com.agilysys.pms.account.model.TransactionReportRequest;
import com.agilysys.pms.account.model.TransactionReportResponse;
import com.agilysys.pms.account.model.TransactionToDateTotalsResult;
import com.agilysys.pms.common.model.GeneralAvailabilityResult;
import com.agilysys.pms.common.security.Permission;
import com.agilysys.pms.common.security.Requires;

@Path("/tenants/{tenantId}/properties/{propertyId}/reports")
public interface ReportingServiceInterface {
    String LEDGER_PATH = "/ledger";
    String CASHIER_PATH = "/cashier";
    String CASHIERS_LIST_PATH = "/cashiersList";
    String TO_DATE_TOTALS_PATH = "/toDateTotals";
    String TRANS_PATH = "/transaction";
    String ACCOUNT_BALANCES_PATH = "/accountBalances";
    String GENERAL_LEDGER = "/generalLedger";
    String RESERVATION_ROOM_REVENUE_PATH = "/reservationRoomRevenue";
    String GENERAL_AVAILABILITY_PATH = "/generalAvailability";
    String GENERAL_AVAILABILITY_STATS = "/generalAvailabilityStats";
    String REVENUE_PATH = "/revenueDetails";
    String REVENUE_PATH_BY_BUILDING = "/revenueDetailsByBuilding";
    String REVENUE_PATH_BY_ROOM = "/revenueDetailsByRoom";
    String RECURRING_CHARGES_PATH = "/recurringCharges";
    String INVENTORY_RECURRING_CHARGES_PATH = "/inventoryRecurringCharges";
    String TENANT_ID = "tenantId";
    String PROPERTY_ID = "propertyId";
    String PROPERTY_DATE = "propertyDate";
    String START_DATE = "startDate";
    String END_DATE = "endDate";
    String DATE = "date";
    String ROOM_REVENUE = "roomRevenue";
    String REVENUE_OCCUPANCY = "revenueOccupancy";
    String BY_CASHIER = "byCashier";
    String TAX_EXEMPT_ACCOUNTS = "/taxExemptAccounts";
    String SOURCE_ID = "sourceId";
    String PANTRY_TRANSACTION = "/pantryTransaction";
    String DEPARTMENT_REVENUE = "/departmentRevenue";
    String INCLUDE_MTD_TRANSACTIONS = "includeMtdTransactions";
    String GROUPS_REVENUE_PATH = "/groupsRevenue";
    String STAY_DATE_SUMMARY = "stayDateSummary";
    String SEND_DEPOSIT_COLLECTION_STATUS_EMAIL = "sendDepositCollectionStatus";
    String SEND_BATCH_DEPOSIT_DUE_NOTIFICATION = "sendBatchDepositDueNotification";
    String COMP_AUTHORIZER_DETAILS = "authorizerListReport";

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
    @Requires(Permission.DATE_ROLL)
    List<NightAuditReport> ledgerReport(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @QueryParam(PROPERTY_DATE) LocalDate propertyDate)
          throws RGuestException;

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
    @Requires(Permission.DATE_ROLL)
    List<NightAuditReport> cashierReport(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @QueryParam(PROPERTY_DATE) LocalDate propertyDate)
          throws RGuestException;

    /**
     * This endpoint is deprecated in favor of getTransactionReportByAccountIdsAndPropertyDateRange get the transaction
     * report
     *
     * @param tenantId     the tenant ID
     * @param propertyId   the property ID
     * @param propertyDate the propertyDate to get the report for
     */
    @Deprecated
    @GET
    @Path(TRANS_PATH)
    @Produces(MediaType.APPLICATION_JSON)
    @Requires(Permission.READ_REPORTS)
    List<TransactionReportItem> getTransactionReport(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @QueryParam(PROPERTY_DATE) LocalDate propertyDate)
          throws RGuestException;

    /**
     * This endpoint is to fetch all the transaction of given date and include the MTD transactions, if
     * INCLUDE_MTD_TRANSACTIONS is true
     */
    @GET
    @Path(DEPARTMENT_REVENUE + TRANS_PATH)
    @Produces(MediaType.APPLICATION_JSON)
    @Requires(Permission.READ_REPORTS)
    List<TransactionReportItem> getTransactionReport(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @QueryParam(PROPERTY_DATE) LocalDate propertyDate,
          @QueryParam(INCLUDE_MTD_TRANSACTIONS) boolean includeMTDTransactions) throws RGuestException;

    /**
     * get the transaction report
     *
     * @param tenantId   the tenant ID
     * @param propertyId the property ID
     * @param request    TransactionReportRequest object that holds accountIds filter
     * @return TransactionReportResponse object that holds TransactionReportItem mapped by account id
     */
    @POST
    @Path(TRANS_PATH)
    @Produces(MediaType.APPLICATION_JSON)
    @Requires(Permission.READ_REPORTS)
    TransactionReportResponse getTransactions(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, TransactionReportRequest request) throws RGuestException;

    /**
     * Retrieves MTD/YTD transaction totals broken down by item ID. Optionally, includes a further breakdown by
     * cashier.
     */
    @GET
    @Path(TRANS_PATH + TO_DATE_TOTALS_PATH)
    @Produces(MediaType.APPLICATION_JSON)
    @Requires(Permission.READ_REPORTS)
    TransactionToDateTotalsResult getTransactionToDateTotals(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @QueryParam(PROPERTY_DATE) LocalDate propertyDate,
          @QueryParam(BY_CASHIER) Boolean breakdownByCashier) throws RGuestException;

    /**
     * retrieve revenue detail information for given dates
     */
    @GET
    @Path(REVENUE_PATH)
    @Produces(MediaType.APPLICATION_JSON)
    @Requires(Permission.READ_REPORTS)
    RevenueReportResult getRevenueDetailReport(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @QueryParam(START_DATE) LocalDate startDate,
          @QueryParam(END_DATE) LocalDate endDate, @QueryParam(ROOM_REVENUE) Boolean roomRevenue,
          @QueryParam(REVENUE_OCCUPANCY) Boolean revenueOccupancy,
          @QueryParam(STAY_DATE_SUMMARY) boolean stayDateSummary) throws RGuestException;

    @GET
    @Path(REVENUE_PATH_BY_ROOM)
    @Produces(MediaType.APPLICATION_JSON)
    @Requires(Permission.READ_REPORTS)
    List<ReservationRevenueReportItem> getRevenueDetailReportByRoom(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @QueryParam(START_DATE) LocalDate startDate,
          @QueryParam(END_DATE) LocalDate endDate, @QueryParam(ROOM_REVENUE) Boolean roomRevenue,
          @QueryParam(REVENUE_OCCUPANCY) Boolean revenueOccupancy) throws RGuestException;

    @POST
    @Path(REVENUE_PATH_BY_BUILDING)
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Requires(Permission.READ_REPORTS)
    Map<String, RevenueReportResult> getRevenueDetailReportByBuilding(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, RevenueDetailReportRequest revenueDetailReportRequest)
          throws RGuestException;

    /**
     * retrieve recurring charge detail information for a given date
     */
    @GET
    @Path(RECURRING_CHARGES_PATH)
    @Produces(MediaType.APPLICATION_JSON)
    @Requires(Permission.READ_REPORTS)
    RecurringChargesReportResult getRecurringChargesReport(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @QueryParam("date") LocalDate date) throws RGuestException;

    /**
     * retrieve account tax exemption for given dates
     */
    @GET
    @Path(TAX_EXEMPT_ACCOUNTS)
    @Produces(MediaType.APPLICATION_JSON)
    @Requires(Permission.READ_REPORTS)
    TaxExemptReportResult getTaxExemptReport(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @QueryParam(START_DATE) LocalDate startDate,
          @QueryParam(END_DATE) LocalDate endDate, @QueryParam(ROOM_REVENUE) Boolean roomRevenueOnly)
          throws RGuestException;

    /**
     * @deprecated use {@link  #getAccountBalances(String, String, com.agilysys.pms.account.model.AccountBalancesRequest)}
     * instead.
     */
    @GET
    @Path(ACCOUNT_BALANCES_PATH)
    @Produces(MediaType.APPLICATION_JSON)
    @Requires(Permission.READ_REPORTS)
    @Deprecated
    AccountBalancesInfo getAccountBalances(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId) throws RGuestException;

    /**
     * retrieves account folio balance information for accounts filtered by the contents of the request
     */
    @POST
    @Path(ACCOUNT_BALANCES_PATH)
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Validated(AccountBalancesRequest.class)
    @Requires(any = { Permission.READ_ACCOUNTS, Permission.READ_REPORTS })
    AccountBalancesInfo getAccountBalances(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, AccountBalancesRequest request) throws RGuestException;

    @POST
    @Path(GENERAL_LEDGER)
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Requires(any = { Permission.READ_ACCOUNTS, Permission.READ_REPORTS })
    List<GLCodeTemplate> getGeneralLedgerTemplates(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, GLCodeTemplateRequest request) throws RGuestException;

    /**
     * Lists all cashiers associated with ledger transactions for the given tenant and property that are associated with
     * transactions between the specified start and end dates.
     */
    @GET
    @Path(CASHIERS_LIST_PATH)
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Requires(any = { Permission.READ_ACCOUNTS, Permission.READ_REPORTS })
    List<Cashier> getCashiersList(@PathParam(TENANT_ID) String tenantId, @PathParam(PROPERTY_ID) String propertyId,
          @QueryParam(START_DATE) LocalDate startDate, @QueryParam(END_DATE) LocalDate endDate,
          @Deprecated @QueryParam("useMigrated") Boolean useMigrated) throws RGuestException;

    /**
     * retrieve inventory recurring charge detail information for the given date range
     */
    @GET
    @Path(INVENTORY_RECURRING_CHARGES_PATH)
    @Produces(MediaType.APPLICATION_JSON)
    @Requires(Permission.READ_REPORTS)
    RecurringChargesReportResult getInventoryRecurringChargesReport(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @QueryParam(START_DATE) LocalDate startDate,
          @QueryParam(END_DATE) LocalDate endDate, @QueryParam(SOURCE_ID) String sourceId) throws RGuestException;

    /**
     * Retrieve room revenue detail for the given reservation identifiers.
     */
    @POST
    @Path(RESERVATION_ROOM_REVENUE_PATH)
    @Produces(MediaType.APPLICATION_JSON)
    @Requires(Permission.READ_REPORTS)
    Map<String, RoomRevenueItem> getRoomRevenueForReservations(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @QueryParam(START_DATE) LocalDate startDate,
          @QueryParam(END_DATE) LocalDate endDate, Set<String> reservationIds) throws RGuestException;

    @GET
    @Path(GENERAL_AVAILABILITY_PATH)
    @Produces(MediaType.APPLICATION_JSON)
    @Requires(Permission.READ_REPORTS)
    GeneralAvailabilityResult getGeneralAvailabilityReport(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @QueryParam(START_DATE) LocalDate startDate,
          @QueryParam(END_DATE) LocalDate endDate, @QueryParam(ROOM_REVENUE) Boolean roomRevenue)
          throws RGuestException;

    @POST
    @Path(GENERAL_AVAILABILITY_STATS)
    @Produces(MediaType.APPLICATION_JSON)
    @Requires(Permission.READ_REPORTS)
    List<GeneralAvailabilityStatsResult> getGeneralAvailabilityStats(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, StatsByBuildingRequest statsByBuildingRequest)
          throws RGuestException;

    @POST
    @Path(PANTRY_TRANSACTION)
    @Produces(MediaType.APPLICATION_JSON)
    @Requires(Permission.READ_REPORTS)
    TransactionReportResponse getPantryItemTransactions(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, TransactionReportRequest request) throws RGuestException;

    /**
     * Retrieve group revenue detail for the given group identifiers.
     */
    @POST
    @Path(GROUPS_REVENUE_PATH)
    @Produces(MediaType.APPLICATION_JSON)
    @Requires(Permission.READ_REPORTS)
    Map<String, List<GroupRevenueReportItem>> getRevenueDetailsForGroups(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @QueryParam(DATE) LocalDate date, Set<String> groupIds);

    @POST
    @Path(SEND_DEPOSIT_COLLECTION_STATUS_EMAIL)
    void sendDepositCollectionStatusEmail(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, DepositCollectionStatusEmailRequest request)
          throws RGuestException;

    @POST
    @Path(SEND_BATCH_DEPOSIT_DUE_NOTIFICATION)
    void sendBatchDepositDueNotification(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId) throws RGuestException;

    @POST
    @Path(COMP_AUTHORIZER_DETAILS)
    @Produces(MediaType.APPLICATION_JSON)
    List<AuthorizerCompReportResponse> getAuthorizerCompReport(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, AuthorizerCompReportRequest request) throws RGuestException;
}