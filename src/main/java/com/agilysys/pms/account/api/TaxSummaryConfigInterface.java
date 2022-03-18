package com.agilysys.pms.account.api;

import com.agilysys.platform.common.rguest.exception.RGuestException;
import com.agilysys.pms.account.model.TaxSummaryConfig;
import com.agilysys.pms.account.model.TaxSummaryConfigSettings;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import java.util.List;
import java.util.Map;

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
    String TAX_SUMMARY_CONFIG = "/taxSummaryConfigSettings";

    @GET
    @Path("/taxSummaryConfig")
    List<TaxSummaryConfig> getTaxSummaryConfig(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId) throws RGuestException;

    @POST
    @Path("/taxSummaryConfig")
    void postTaxSummaryConfig(@PathParam(TENANT_ID) String tenantId, @PathParam(PROPERTY_ID) String propertyId,
          TaxSummaryConfig taxSummaryConfig) throws RGuestException;

    @PUT
    @Path("/taxSummaryConfig/{id}")
    TaxSummaryConfig updateTaxSummaryConfig(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @PathParam(ID) String id, TaxSummaryConfig taxSummaryConfig)
          throws RGuestException;

    @GET
    @Path(TAX_SUMMARY_CONFIG)
    TaxSummaryConfigSettings getTaxSummaryConfigSettings(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId) throws RGuestException;
    
    @PUT
    @Path(TAX_SUMMARY_CONFIG + "/{id}")
    TaxSummaryConfigSettings updateTaxSummaryConfigSettings(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @PathParam(ID) String id,
          TaxSummaryConfigSettings taxSummaryConfigSettings) throws RGuestException;

}
