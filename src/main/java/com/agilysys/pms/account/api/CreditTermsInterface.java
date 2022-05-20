/*
 * (C) 2019 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.api;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.agilysys.platform.common.rguest.exception.RGuestException;
import com.agilysys.pms.common.security.Permission;
import com.agilysys.pms.common.security.Requires;

/**
 * CRUD methods for credit terms
 */
@Path("/tenants/{tenantId}/properties/{propertyId}/config/creditTerms")
@Produces(MediaType.APPLICATION_JSON)
public interface CreditTermsInterface {
    /**
     * Retrieve all credit terms
     *
     * @param tenantId   the tenantId to retrieve credit terms for
     * @param propertyId the propertyId to retrieve credit terms for
     * @return List of Integer
     */
    @GET
    @Requires(Permission.READ_PROPERTY_CONFIG)
    List<Integer> getCreditTerms(@PathParam("tenantId") String tenantId, @PathParam("propertyId") String propertyId)
          throws RGuestException;
}