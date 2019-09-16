/*
 * (C) 2016 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.api;

import java.util.List;
import java.util.Map;

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
import com.agilysys.pms.account.model.AggregationType;
import com.agilysys.pms.account.model.WarehouseType;
import com.agilysys.pms.common.model.AggregationJob;
import com.agilysys.pms.maintenance.model.ExportRequest;
import com.agilysys.pms.maintenance.model.IndexRequest;

@Path(MaintenanceInterface.BASE_PATH)
@Consumes(MediaType.APPLICATION_JSON)
public interface MaintenanceInterface {
    String BASE_PATH = "/maintenance";

    String ACCOUNTS_PATH = "/accounts";
    String AGGREGATE_PATH = "/aggregate";
    String COUNT_PATH = "/count";
    String EXPORT_PATH = "/export";
    String INDEX_PATH = "/index";
    String RANGE_PATH = "/range";
    String UNINDEXED_PATH = "/unindexed";
    String UNEXPORTED_PATH = "/unexported";

    String TENANT_ID = "tenantId";
    String TENANT_ID_TEMPLATE = "{" + TENANT_ID + "}";
    String TYPE = "type";
    String TYPE_TEMPLATE = "{" + TYPE + "}";

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

    @POST
    @PreAuthorize(WRITE_TENANTS_PERMISSION)
    @Path(AGGREGATE_PATH + "/" + TYPE_TEMPLATE)
    void aggregate(@PathParam(TYPE) AggregationType type) throws RGuestException, ServiceException;

    @GET
    @PreAuthorize(WRITE_TENANTS_PERMISSION)
    @Path(AGGREGATE_PATH + "/" + TYPE_TEMPLATE)
    AggregationJob getAggregate(@PathParam(TYPE) AggregationType type) throws RGuestException, ServiceException;

    @GET
    @PreAuthorize(WRITE_TENANTS_PERMISSION)
    @Path(AGGREGATE_PATH)
    List<AggregationJob> getAggregates() throws RGuestException, ServiceException;

    @GET
    @Path(COUNT_PATH + RANGE_PATH + "/" + TYPE_TEMPLATE + "/" + TENANT_ID_TEMPLATE)
    long countRange(@PathParam(TYPE) WarehouseType type, @PathParam(TENANT_ID) String tenantId,
          @QueryParam(UPDATED_SINCE) String updatedSince, @QueryParam(UPDATED_UNTIL) String updatedUntil)
          throws RGuestException, ServiceException;

    @GET
    @Path(COUNT_PATH + UNEXPORTED_PATH + "/" + TYPE_TEMPLATE + "/" + TENANT_ID_TEMPLATE)
    long countUnexported(@PathParam(TYPE) WarehouseType type, @PathParam(TENANT_ID) String tenantId)
          throws RGuestException, ServiceException;

    @GET
    @Path(COUNT_PATH + UNEXPORTED_PATH + "/" + TYPE_TEMPLATE)
    Map<String, Long> countUnexported(@PathParam(TYPE) WarehouseType type) throws RGuestException, ServiceException;

    @POST
    @PreAuthorize(WRITE_TENANTS_PERMISSION)
    @Path(EXPORT_PATH + "/" + TYPE_TEMPLATE + "/" + TENANT_ID_TEMPLATE)
    long export(@PathParam(TYPE) WarehouseType type, @PathParam(TENANT_ID) String tenantId,
          @QueryParam(UPDATED_SINCE) String updatedSince, @QueryParam(UPDATED_UNTIL) String updatedUntil)
          throws RGuestException, ServiceException;

    @POST
    @PreAuthorize(WRITE_TENANTS_PERMISSION)
    @Path(EXPORT_PATH + "/" + TYPE_TEMPLATE)
    Map<String, Long> export(ExportRequest<WarehouseType> request) throws RGuestException, ServiceException;
}
