<<<<<<< HEAD
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
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.agilysys.platform.common.exception.ServiceException;
import com.agilysys.platform.common.rguest.exception.RGuestException;
import com.agilysys.pms.maintenance.model.IndexRequest;

@Path(MaintenanceInterface.BASE_PATH)
@Consumes(MediaType.APPLICATION_JSON)
public interface MaintenanceInterface {
    String BASE_PATH = "/maintenance";

    String ACCOUNTS_PATH = "/accounts";

    String COUNT_PATH = "/count";
    String INDEX_PATH = "/index";
    String RANGE_PATH = "/range";
    String UNINDEXED_PATH = "/unindexed";

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
}
=======
/*
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
import com.agilysys.pms.maintenance.model.IndexRequest;

@Path(MaintenanceInterface.BASE_PATH)
@Consumes(MediaType.APPLICATION_JSON)
public interface MaintenanceInterface {
    String BASE_PATH = "/maintenance";

    String ACCOUNTS_PATH = "/accounts";

    String COUNT_PATH = "/count";
    String INDEX_PATH = "/index";
    String RANGE_PATH = "/range";
    String UNINDEXED_PATH = "/unindexed";

    String TENANT_ID = "tenantId";
    String TENANT_ID_TEMPLATE = "{" + TENANT_ID + "}";

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
    long countUnindexedAccounts(@PathParam(TENANT_ID) String tenantId) throws RGuestException, ServiceException;

    @GET
    @Path(COUNT_PATH + UNINDEXED_PATH + ACCOUNTS_PATH)
    Map<String, Long> countUnindexedAccounts() throws RGuestException, ServiceException;

    @POST
    @PreAuthorize(WRITE_TENANTS_PERMISSION)
    @Path(INDEX_PATH + ACCOUNTS_PATH + "/" + TENANT_ID_TEMPLATE)
    long indexAccounts(@PathParam(TENANT_ID) String tenantId, @QueryParam(UPDATED_SINCE) String updatedSince,
          @QueryParam(UPDATED_UNTIL) String updatedUntil) throws RGuestException, ServiceException;

    @POST
    @PreAuthorize(WRITE_TENANTS_PERMISSION)
    @Path(INDEX_PATH + ACCOUNTS_PATH)
    Map<String, Long> indexAccounts(IndexRequest request) throws RGuestException, ServiceException;
}
>>>>>>> 54b6432e3e3187b895886d46553c7a7126bc701d
