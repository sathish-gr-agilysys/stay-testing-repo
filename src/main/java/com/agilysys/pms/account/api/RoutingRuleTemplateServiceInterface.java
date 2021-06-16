/*
 * (C) 2020 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.api;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.agilysys.platform.common.rguest.exception.RGuestException;
import com.agilysys.pms.account.model.RoutingRuleTemplate;
import com.agilysys.pms.common.api.annotation.CreatedOnSuccess;
import com.agilysys.pms.common.security.Permission;
import com.agilysys.pms.common.security.Requires;

@Path(RoutingRuleTemplateServiceInterface.BASE_PATH)
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface RoutingRuleTemplateServiceInterface {
    String TENANT_ID = "tenantId";
    String PROPERTY_ID = "propertyId";
    String BASE_PATH = "/tenants/{" + TENANT_ID + "}/properties/{" + PROPERTY_ID + "}/routingRuleTemplates";
    String TEMPLATE_ID = "id";
    String TEMPLATE_ID_PATH = "{" + TEMPLATE_ID + "}";
    String TEMPLATES_BY_IDS_PATH = "/templatesByIds";

    @GET
    @Path(TEMPLATE_ID_PATH)
    @Requires(Permission.READ_PROPERTY_CONFIG)
    RoutingRuleTemplate getRoutingRuleTemplateById(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @PathParam(TEMPLATE_ID) String id) throws RGuestException;

    @POST
    @Path(TEMPLATES_BY_IDS_PATH)
    @Requires(Permission.READ_PROPERTY_CONFIG)
    Map<String, RoutingRuleTemplate> getRoutingRuleTemplateByIds(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, Set<String> templateIds) throws RGuestException;

    @GET
    @Requires(Permission.READ_PROPERTY_CONFIG)
    List<RoutingRuleTemplate> getRoutingRuleTemplates(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId) throws RGuestException;

    @POST
    @CreatedOnSuccess
    @Requires(Permission.CREATE_RR_TEMPLATE)
    RoutingRuleTemplate createRoutingRuleTemplate(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, RoutingRuleTemplate routingRuleTemplates) throws RGuestException;

    @PUT
    @Path(TEMPLATE_ID_PATH)
    @Requires(Permission.CREATE_RR_TEMPLATE)
    RoutingRuleTemplate updateRoutingRuleTemplate(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @PathParam(TEMPLATE_ID) String id,
          RoutingRuleTemplate routingRuleTemplate) throws RGuestException;
}