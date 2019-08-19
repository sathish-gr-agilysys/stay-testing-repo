/*
 * (C) 2016 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.api;

import java.util.Map;
import java.util.Set;

import javax.ws.rs.Consumes;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.agilysys.platform.common.exception.ServiceException;
import com.agilysys.platform.common.rguest.exception.RGuestException;
import com.agilysys.pms.maintenance.model.IndexRequest;

@Path(MaintenanceInterface.BASE_PATH)
@Consumes(MediaType.APPLICATION_JSON)
public interface MaintenanceInterface {
    String BASE_PATH = "/maintenance";

    String ACCOUNTS_PATH = "/accounts";
    String LEDGER_TRANSACTIONS_PATH = "/ledgerTransactions";
    String REVENUE_AGGREGATES_PATH = "/revenueAggregates";

    String COUNT_PATH = "/count";
    String EXPORT_PATH = "/export";
    String INDEX_PATH = "/index";
    String RANGE_PATH = "/range";
    String SEED_EXPORT_PATH = "/seedExport";
    String UNINDEXED_PATH = "/unindexed";
    String UNEXPORTED_PATH = "/unexported";

    String TENANT_ID = "tenantId";
    String TENANT_ID_TEMPLATE = "{" + TENANT_ID + "}";

    String NEXT_GEN = "nextGen";
    String UPDATED_SINCE = "updatedSince";
    String UPDATED_UNTIL = "updatedUntil";

    String PERMISSION_PREFIX = "hasPermission('Required', '";
    String PERMISSION_POSTFIX = "')";

    String WRITE_TENANTS_PERMISSION = PERMISSION_PREFIX + "WriteTenants" + PERMISSION_POSTFIX;

    @GET
    @Path(COUNT_PATH + RANGE_PATH + ACCOUNTS_PATH + "/" + TENANT_ID_TEMPLATE)
    long countRangeAccounts(@PathParam(TENANT_ID) String tenantId, @QueryParam(UPDATED_SINCE) String updatedSince,
          @QueryParam(UPDATED_UNTIL) String updatedUntil) throws RGuestException, ServiceException;

    @GET
    @Path(COUNT_PATH + UNINDEXED_PATH + ACCOUNTS_PATH + "/" + TENANT_ID_TEMPLATE)
    long countUnindexedAccounts(@PathParam(TENANT_ID) String tenantId, @QueryParam(NEXT_GEN) boolean nextGen)
          throws RGuestException, ServiceException;

    @GET
    @Path(COUNT_PATH + UNINDEXED_PATH + ACCOUNTS_PATH)
    Map<String, Long> countUnindexedAccounts(@QueryParam(NEXT_GEN) boolean nextGen)
          throws RGuestException, ServiceException;

    @DELETE
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @Path(INDEX_PATH + ACCOUNTS_PATH)
    void deleteAccountsIndex() throws RGuestException, ServiceException;

    @POST
    @PreAuthorize(WRITE_TENANTS_PERMISSION)
    @Path(INDEX_PATH + ACCOUNTS_PATH + "/" + TENANT_ID_TEMPLATE)
    long indexAccounts(@PathParam(TENANT_ID) String tenantId, @QueryParam(UPDATED_SINCE) String updatedSince,
          @QueryParam(UPDATED_UNTIL) String updatedUntil, @QueryParam(NEXT_GEN) boolean nextGen)
          throws RGuestException, ServiceException;

    @POST
    @PreAuthorize(WRITE_TENANTS_PERMISSION)
    @Path(INDEX_PATH + ACCOUNTS_PATH)
    Map<String, Long> indexAccounts(IndexRequest request) throws RGuestException, ServiceException;

    @GET
    @Path(COUNT_PATH + UNEXPORTED_PATH + ACCOUNTS_PATH + "/" + TENANT_ID_TEMPLATE)
    long countUnexportedAccounts(@PathParam(TENANT_ID) String tenantId) throws RGuestException, ServiceException;

    @GET
    @Path(COUNT_PATH + UNEXPORTED_PATH + ACCOUNTS_PATH)
    Map<String, Long> countUnexportedAccounts() throws RGuestException, ServiceException;

    @POST
    @PreAuthorize(WRITE_TENANTS_PERMISSION)
    @Path(EXPORT_PATH + ACCOUNTS_PATH + "/" + TENANT_ID_TEMPLATE)
    long exportAccounts(@PathParam(TENANT_ID) String tenantId, @QueryParam(UPDATED_SINCE) String updatedSince,
          @QueryParam(UPDATED_UNTIL) String updatedUntil) throws RGuestException, ServiceException;

    @POST
    @PreAuthorize(WRITE_TENANTS_PERMISSION)
    @Path(EXPORT_PATH + ACCOUNTS_PATH)
    Map<String, Long> exportAccounts(IndexRequest request) throws RGuestException, ServiceException;

    @GET
    @Path(COUNT_PATH + RANGE_PATH + LEDGER_TRANSACTIONS_PATH + "/" + TENANT_ID_TEMPLATE)
    long countRangeLedgerTransactions(@PathParam(TENANT_ID) String tenantId,
          @QueryParam(UPDATED_SINCE) String updatedSince, @QueryParam(UPDATED_UNTIL) String updatedUntil)
          throws RGuestException, ServiceException;

    @GET
    @Path(COUNT_PATH + UNEXPORTED_PATH + LEDGER_TRANSACTIONS_PATH + "/" + TENANT_ID_TEMPLATE)
    long countUnexportedLedgerTransactions(@PathParam(TENANT_ID) String tenantId)
          throws RGuestException, ServiceException;

    @GET
    @Path(COUNT_PATH + UNEXPORTED_PATH + LEDGER_TRANSACTIONS_PATH)
    Map<String, Long> countUnexportedLedgerTransactions() throws RGuestException, ServiceException;

    @POST
    @PreAuthorize(WRITE_TENANTS_PERMISSION)
    @Path(EXPORT_PATH + LEDGER_TRANSACTIONS_PATH + "/" + TENANT_ID_TEMPLATE)
    long exportLedgerTransactions(@PathParam(TENANT_ID) String tenantId, @QueryParam(UPDATED_SINCE) String updatedSince,
          @QueryParam(UPDATED_UNTIL) String updatedUntil) throws RGuestException, ServiceException;

    @POST
    @PreAuthorize(WRITE_TENANTS_PERMISSION)
    @Path(EXPORT_PATH + LEDGER_TRANSACTIONS_PATH)
    Map<String, Long> exportLedgerTransactions(IndexRequest request) throws RGuestException, ServiceException;

    @GET
    @Path(COUNT_PATH + RANGE_PATH + REVENUE_AGGREGATES_PATH + "/" + TENANT_ID_TEMPLATE)
    long countRangeRevenueAggregates(@PathParam(TENANT_ID) String tenantId,
          @QueryParam(UPDATED_SINCE) String updatedSince, @QueryParam(UPDATED_UNTIL) String updatedUntil)
          throws RGuestException, ServiceException;

    @GET
    @Path(COUNT_PATH + UNEXPORTED_PATH + REVENUE_AGGREGATES_PATH + "/" + TENANT_ID_TEMPLATE)
    long countUnexportedRevenueAggregates(@PathParam(TENANT_ID) String tenantId)
          throws RGuestException, ServiceException;

    @GET
    @Path(COUNT_PATH + UNEXPORTED_PATH + REVENUE_AGGREGATES_PATH)
    Map<String, Long> countUnexportedRevenueAggregates() throws RGuestException, ServiceException;

    @POST
    @PreAuthorize(WRITE_TENANTS_PERMISSION)
    @Path(EXPORT_PATH + REVENUE_AGGREGATES_PATH + "/" + TENANT_ID_TEMPLATE)
    long exportRevenueAggregates(@PathParam(TENANT_ID) String tenantId, @QueryParam(UPDATED_SINCE) String updatedSince,
          @QueryParam(UPDATED_UNTIL) String updatedUntil) throws RGuestException, ServiceException;

    @POST
    @PreAuthorize(WRITE_TENANTS_PERMISSION)
    @Path(EXPORT_PATH + REVENUE_AGGREGATES_PATH)
    Map<String, Long> exportRevenueAggregates(IndexRequest request) throws RGuestException, ServiceException;

    @POST
    @PreAuthorize(WRITE_TENANTS_PERMISSION)
    @Path(SEED_EXPORT_PATH + REVENUE_AGGREGATES_PATH + "/" + TENANT_ID_TEMPLATE)
    long seedRevenueAggregates(@PathParam(TENANT_ID) String tenantId) throws RGuestException, ServiceException;

    @POST
    @PreAuthorize(WRITE_TENANTS_PERMISSION)
    @Path(SEED_EXPORT_PATH + REVENUE_AGGREGATES_PATH)
    Map<String, Long> seedRevenueAggregates(Set<String> tenantIds) throws RGuestException, ServiceException;
}
