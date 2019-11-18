/*
 * (C) 2018 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.api;

import java.util.List;
import java.util.SortedMap;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.joda.time.LocalDate;
import org.springframework.security.access.prepost.PreAuthorize;

import com.agilysys.platform.common.rguest.exception.RGuestException;
import com.agilysys.pms.account.model.AutoRecurringItem;
import com.agilysys.pms.account.model.TransactionItemOptionalParameters;
import com.agilysys.pms.common.api.annotation.CreatedOnSuccess;

@Path(AutoRecurringItemConfigServiceInterface.BASE_PATH)
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface AutoRecurringItemConfigServiceInterface {
    String TENANT_ID = "tenantId";
    String PROPERTY_ID = "propertyId";
    String BASE_PATH = "/tenants/{" + TENANT_ID + "}/properties/{" + PROPERTY_ID + "}/config/autoRecurringItems";
    String ITEM_ID = "id";
    String ITEM_ID_PATH = "{" + ITEM_ID + "}";
    String START_DATE = "startDate";
    String END_DATE = "endDate";
    String ACTIVE_ITEM = "/active";

    @GET
    @Path(ITEM_ID_PATH)
    @PreAuthorize("hasPermission('Required', 'ReadPropertyConfig')")
    AutoRecurringItem getAutoRecurringItem(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @PathParam(ITEM_ID) String itemId) throws RGuestException;

    @GET
    @PreAuthorize("hasPermission('Required', 'ReadPropertyConfig')")
    List<AutoRecurringItem> getAutoRecurringItems(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId) throws RGuestException;

    @POST
    @CreatedOnSuccess
    @PreAuthorize("hasPermission('Required', 'WritePropertyConfig')")
    List<AutoRecurringItem> createAutoRecurringItems(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId,
          @QueryParam("") TransactionItemOptionalParameters transactionItemOptionalParameters,
          List<AutoRecurringItem> items) throws RGuestException;

    @PUT
    @Path(ITEM_ID_PATH)
    @PreAuthorize("hasPermission('Required', 'WritePropertyConfig')")
    AutoRecurringItem updateAutoRecurringItem(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @PathParam(ITEM_ID) String itemId,
          @QueryParam("") TransactionItemOptionalParameters transactionItemOptionalParameters, AutoRecurringItem item)
          throws RGuestException;

    @GET
    @Path(ACTIVE_ITEM)
    @PreAuthorize("hasPermission('Required', 'ReadPropertyConfig')")
    SortedMap<LocalDate, List<AutoRecurringItem>> getValidAutoRecurringItems(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @QueryParam(START_DATE) LocalDate startDate,
          @QueryParam(END_DATE) LocalDate endDate) throws RGuestException;

    @DELETE
    @Path(ITEM_ID_PATH)
    @PreAuthorize("hasPermission('Required', 'WritePropertyConfig')")
    void deleteAutoRecurringItem(@PathParam(TENANT_ID) String tenantId, @PathParam(PROPERTY_ID) String propertyId,
          @PathParam(ITEM_ID) String itemId) throws RGuestException;
}
