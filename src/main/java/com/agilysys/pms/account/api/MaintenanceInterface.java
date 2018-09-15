/**
 * (C) 2016 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.api;

import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.joda.time.DateTime;
import org.springframework.security.access.prepost.PreAuthorize;

import com.agilysys.platform.common.exception.ServiceException;
import com.agilysys.platform.common.rguest.exception.RGuestException;
import com.agilysys.pms.maintenance.model.ReindexRequest;

@Path("/maintenance/elasticsearch")
@Consumes(MediaType.APPLICATION_JSON)
public interface MaintenanceInterface {
    String CHUNK_SIZE = "chunkSize";

    String TENANT_ID = "tenantId";
    String TENANT_ID_TEMPLATE = "{" + TENANT_ID + "}";

    String UPDATED_SINCE = "updatedSince";
    String UPDATED_UNTIL = "updatedUntil";

    String PERMISSION_PREFIX = "hasPermission('Required', '";
    String PERMISSION_POSTFIX = "')";

    String WRITE_TENANTS_PERMISSION = PERMISSION_PREFIX + "WriteTenants" + PERMISSION_POSTFIX;

    @GET
    @Path("/unindexed/accounts/" + TENANT_ID_TEMPLATE)
    long countUnindexedAccounts(@PathParam(TENANT_ID) String tenantId) throws RGuestException, ServiceException;

    @GET
    @Path("/unindexed/accounts")
    Map<String, Long> countUnindexedAccounts() throws RGuestException, ServiceException;

    @POST
    @PreAuthorize(WRITE_TENANTS_PERMISSION)
    @Path("/reindex/accounts/" + TENANT_ID_TEMPLATE)
    long reindexReservations(@PathParam(TENANT_ID) String tenantId, @QueryParam(CHUNK_SIZE) Integer chunkSize,
          @QueryParam(UPDATED_SINCE) DateTime updatedSince, @QueryParam(UPDATED_UNTIL) DateTime updatedUntil)
          throws RGuestException, ServiceException;

    @POST
    @PreAuthorize(WRITE_TENANTS_PERMISSION)
    @Path("/reindex/accounts")
    Map<String, Long> reindexAccounts(ReindexRequest request) throws RGuestException, ServiceException;
}
