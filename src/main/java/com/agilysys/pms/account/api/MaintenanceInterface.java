/*
 * (C) 2016 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.api;

import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.agilysys.platform.common.rguest.exception.RGuestException;
import com.agilysys.pms.common.api.search.SearchMaintenanceInterface;
import com.agilysys.pms.common.security.Permission;
import com.agilysys.pms.common.security.Requires;
import com.agilysys.pms.maintenance.model.MaintenanceRequest;

@Consumes(MediaType.APPLICATION_JSON)
@Path(MaintenanceInterface.BASE_PATH)
public interface MaintenanceInterface extends SearchMaintenanceInterface {
    String BASE_PATH = "/maintenance";

    String ACCOUNTS_PATH = "/accounts";

    @GET
    @Path(COUNT_PATH + RANGE_PATH + ACCOUNTS_PATH + "/" + TENANT_ID_TEMPLATE)
    long countRangeAccounts(@PathParam(TENANT_ID) String tenantId, @QueryParam(UPDATED_SINCE) String updatedSince,
          @QueryParam(UPDATED_UNTIL) String updatedUntil) throws RGuestException;

    @GET
    @Path(COUNT_PATH + UNINDEXED_PATH + ACCOUNTS_PATH + "/" + TENANT_ID_TEMPLATE)
    long countUnindexedAccounts(@PathParam(TENANT_ID) String tenantId) throws RGuestException;

    @GET
    @Path(COUNT_PATH + UNINDEXED_PATH + ACCOUNTS_PATH)
    Map<String, Long> countUnindexedAccounts() throws RGuestException;

    @DELETE
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @Path(INDEX_PATH + ACCOUNTS_PATH)
    void deleteAccountsIndex() throws RGuestException;

    @DELETE
    @Path(INDEX_PATH + ACCOUNTS_PATH + "/" + TENANT_ID_TEMPLATE)
    long deleteAccountDocuments(@PathParam(TENANT_ID) String tenantId) throws RGuestException;

    @POST
    @Requires(Permission.WRITE_TENANTS)
    @Path(INDEX_PATH + ACCOUNTS_PATH + "/" + TENANT_ID_TEMPLATE)
    long indexAccounts(@PathParam(TENANT_ID) String tenantId, @QueryParam(UPDATED_SINCE) String updatedSince,
          @QueryParam(UPDATED_UNTIL) String updatedUntil) throws RGuestException;

    @POST
    @Requires(Permission.WRITE_TENANTS)
    @Path(INDEX_PATH + ACCOUNTS_PATH)
    Map<String, Long> indexAccounts(MaintenanceRequest request) throws RGuestException;

    @POST
    @Path("/migrateDailyCashiers")
    @Requires(Permission.WRITE_TENANTS)
    void migrateDailyCashiers() throws RGuestException;
}

