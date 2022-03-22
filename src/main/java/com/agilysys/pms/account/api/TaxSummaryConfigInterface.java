/*
 * (C) 2022 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.api;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.agilysys.platform.common.rguest.exception.RGuestException;
import com.agilysys.pms.account.model.TaxSummaryConfigSettings;
import com.agilysys.pms.account.model.TaxSummaryConfiguration;

@Path(TaxSummaryConfigInterface.BASE)
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface TaxSummaryConfigInterface {
    String ID = "id";
    String TENANT_ID = "tenantId";
    String PROPERTY_ID = "propertyId";
    String TENANT_TEMPLATE = "{" + TENANT_ID + "}";
    String PROPERTY_TEMPLATE = "{" + PROPERTY_ID + "}";
    String BASE = "/tenants/" + TENANT_TEMPLATE + "/properties/" + PROPERTY_TEMPLATE;
    String TAX_SUMMARY_CONFIG_PATH = "setup/accounts/taxSummaryConfigSettings";
    String TAX_SUMMARY_CONFIG_SETTINGS = "/taxSummaryConfigSettings";
    String TAX_SUMMARY_CONFIG = "/taxSummaryConfig";

    @GET
    @Path(TAX_SUMMARY_CONFIG)
    List<TaxSummaryConfiguration> getTaxSummaryConfig(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId) throws RGuestException;

    @POST
    @Path(TAX_SUMMARY_CONFIG)
    void postTaxSummaryConfig(@PathParam(TENANT_ID) String tenantId, @PathParam(PROPERTY_ID) String propertyId,
          TaxSummaryConfiguration taxSummaryConfig) throws RGuestException;

    @PUT
    @Path(TAX_SUMMARY_CONFIG + "/{id}")
    TaxSummaryConfiguration updateTaxSummaryConfig(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @PathParam(ID) String id, TaxSummaryConfiguration taxSummaryConfig)
          throws RGuestException;

    @GET
    @Path(TAX_SUMMARY_CONFIG_SETTINGS)
    List<TaxSummaryConfigSettings> getTaxSummaryConfigSettings(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId) throws RGuestException;

    @PUT
    @Path(TAX_SUMMARY_CONFIG_SETTINGS + "/{id}")
    TaxSummaryConfigSettings updateTaxSummaryConfigSettings(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @PathParam(ID) String id,
          TaxSummaryConfigSettings taxSummaryConfigSettings) throws RGuestException;

}
