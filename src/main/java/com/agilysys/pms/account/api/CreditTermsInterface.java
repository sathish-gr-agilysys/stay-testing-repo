package com.agilysys.pms.account.api;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.security.access.prepost.PreAuthorize;

import com.agilysys.platform.common.exception.ServiceException;

/**
 * CRUD methods for credit terms
 */
@Path("/tenants/{tenantId}/properties/{propertyId}/config/creditTerms")
@Produces(MediaType.APPLICATION_JSON)
public interface CreditTermsInterface {
    public static final String CREDIT_TERMS_PATH = "setup/accounts/creditTerms";

    /**
     * Retrieve all credit terms
     *
     * @param tenantId   the tenantId to retrieve credit terms for
     * @param propertyId the propertyId to retrieve credit terms for
     * @return List of Integer
     */
    @GET
    @PreAuthorize("hasPermission('Required', 'ReadPropertyConfig')")
    public List<Integer> getCreditTerms(@PathParam("tenantId") String tenantId,
          @PathParam("propertyId") String propertyId) throws ServiceException;
}