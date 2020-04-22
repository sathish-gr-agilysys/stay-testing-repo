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

import org.springframework.security.access.prepost.PreAuthorize;

import com.agilysys.platform.common.rguest.exception.RGuestException;
import com.agilysys.pms.account.model.AutoRecurringItem;
import com.agilysys.pms.account.model.RoutingRuleTemplate;
import com.agilysys.pms.common.api.annotation.CreatedOnSuccess;

@Path(RoutingRuleTemplateServiceInterface.BASE_PATH)
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface RoutingRuleTemplateServiceInterface {
    String TENANT_ID = "tenantId";
    String PROPERTY_ID = "propertyId";
    String BASE_PATH = "/tenants/{" + TENANT_ID + "}/properties/{" + PROPERTY_ID + "}/routingRuleTemplates";
    String TEMPLATE_ID = "id";
    String TEMPLATE_ID_PATH = "{" + TEMPLATE_ID + "}";

    @GET
    @Path(TEMPLATE_ID_PATH)
    @PreAuthorize("hasPermission('Required', 'ReadPropertyConfig')")
    RoutingRuleTemplate getRoutingRuleTemplateById(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @PathParam(TEMPLATE_ID) String id) throws RGuestException;

    @GET
    @PreAuthorize("hasPermission('Required', 'ReadPropertyConfig')")
    List<RoutingRuleTemplate> getRoutingRuleTemplates(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId) throws RGuestException;

    @POST
    @CreatedOnSuccess
    @PreAuthorize("hasPermission('Required', 'WriteCompanyProfileDefaults')")
    RoutingRuleTemplate createRoutingRuleTemplate(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, RoutingRuleTemplate routingRuleTemplates)
          throws RGuestException;

    @PUT
    @Path(TEMPLATE_ID_PATH)
    @PreAuthorize("hasPermission('Required', 'WriteCompanyProfileDefaults')")
    AutoRecurringItem updateAutoRecurringItem(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @PathParam(TEMPLATE_ID) String id,
          RoutingRuleTemplate routingRuleTemplate) throws RGuestException;
}
