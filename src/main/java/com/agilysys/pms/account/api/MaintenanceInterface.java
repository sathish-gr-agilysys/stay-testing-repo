/**
 * (C) 2016 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.api;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.joda.time.LocalDate;
import org.springframework.security.access.prepost.PreAuthorize;

import com.agilysys.platform.common.exception.ServiceException;
import com.agilysys.platform.common.rguest.exception.RGuestException;
import com.agilysys.pms.account.model.AccountBalanceRepairResult;
import com.agilysys.pms.maintenance.domain.BulkReindexJobDetail;
import com.agilysys.pms.maintenance.domain.BulkReindexJobResult;
import com.agilysys.pms.maintenance.domain.BulkReindexRequest;
import com.agilysys.pms.maintenance.model.Job;

@Path("/maintenance")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface MaintenanceInterface {
    String TENANT_ID = "tenantId";
    String PROPERTY_ID = "propertyId";
    String REQUEST_ID = "requestId";

    String ES_INDEX_ACCOUNTS = "/elasticsearch/indices";

    @GET
    @Path("/requests/{" + REQUEST_ID + "}")
    List<Job> retrieveJobs(@PathParam(REQUEST_ID) String requestId) throws RGuestException, ServiceException;

    @POST
    @PreAuthorize("hasPermission('Required', 'WriteTenants')")
    @Path(ES_INDEX_ACCOUNTS + "/bulk")
    BulkReindexJobResult bulkReIndex(BulkReindexRequest request) throws RGuestException, ServiceException;

    @GET
    @Path(ES_INDEX_ACCOUNTS + "/bulk/requests/{requestId}")
    List<BulkReindexJobDetail> retrieveBulkJobs(@PathParam("requestId") String requestId)
          throws RGuestException, ServiceException;
}
