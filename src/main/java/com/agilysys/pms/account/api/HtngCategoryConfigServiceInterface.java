/*
 * (C) 2019 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.api;

import java.util.List;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.security.access.prepost.PreAuthorize;

import com.agilysys.platform.common.rguest.exception.RGuestException;
import com.agilysys.pms.account.model.HtngCategory;

/**
 * GET method for HtngCategory
 */
@Path("/tenants/{tenantId}/properties/{propertyId}/config/htngCategories")
@Produces(MediaType.APPLICATION_JSON)
public interface HtngCategoryConfigServiceInterface {
    String TENANT_ID = "tenantId";
    String PROPERTY_ID = "propertyId";
    String INCLUDE_INTERNAL = "includeInternal";

    /**
     * Retrieve all HtngRevenueCodes
     *
     * @param tenantId the tenantId to retrieve TransactionCategories for
     * @return List of TransactionCategory
     */
    @GET
    @PreAuthorize("hasPermission('Required', 'ReadPropertyConfig')")
    List<HtngCategory> getHtngRevenueCodes(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId,
          @DefaultValue("false") @QueryParam(INCLUDE_INTERNAL) boolean includeInternal) throws RGuestException;
}
