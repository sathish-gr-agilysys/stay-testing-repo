/*
 * (C) 2019 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.api;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.security.access.prepost.PreAuthorize;

import com.agilysys.platform.common.exception.ServiceException;
import com.agilysys.platform.common.rguest.exception.RGuestException;
import com.agilysys.pms.account.model.TaxGroupView;

@Path("/v1/tenants/{tenantId}/properties/{propertyId}/taxGroups")
public interface TaxGroupsInterface {
    String TENANT_ID = "tenantId";
    String PROPERTY_ID = "propertyId";
    String TAX_GROUP_ID = "taxGroupId";
    String TAX_GROUP_ID_PATH = "/{" + TAX_GROUP_ID + "}";

    /**
     * Gets the list of tax groups associated with the given tenant and property.
     *
     * @param tenantId
     * @param propertyId
     * @return the list of tax groups
     * @throws RGuestException
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @PreAuthorize("hasPermission('Required', 'ReadAccounts')")
    // TODO check this
    List<TaxGroupView> getTaxGroups(@PathParam(TENANT_ID) String tenantId, @PathParam(PROPERTY_ID) String propertyId)
          throws RGuestException;

    /**
     * Create a new tax group.
     *
     * @param tenantId
     * @param propertyId
     * @param create
     * @return the list of all tax groups associated with the tenant and property
     * @throws RGuestException
     */
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @PreAuthorize("hasPermission('Required', 'WriteAccounts')")
    // TODO check this
    TaxGroupView createTaxGroup(@PathParam(TENANT_ID) String tenantId, @PathParam(PROPERTY_ID) String propertyId,
          TaxGroupView create) throws RGuestException;

    /**
     * Insert a set of tax groups into the list for the given tenant and property.
     *
     * @param tenantId
     * @param propertyId
     * @param create
     * @return the list of all tax groups associated with the tenant and property
     * @throws RGuestException
     */
    @POST
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @PreAuthorize("hasPermission('Required', 'WriteAccounts')")
    // TODO check this
    List<TaxGroupView> insertTaxGroups(@PathParam(TENANT_ID) String tenantId, @PathParam(PROPERTY_ID) String propertyId,
          List<TaxGroupView> create) throws RGuestException;

    /**
     * Get the tax group specified by the given tax group name.
     *
     * @param tenantId
     * @param propertyId
     * @param taxGroupId
     * @return
     * @throws RGuestException
     */
    @GET
    @Path(TAX_GROUP_ID_PATH)
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @PreAuthorize("hasPermission('Required', 'ReadAccounts')")
    // TODO check this
    TaxGroupView getTaxGroup(@PathParam(TENANT_ID) String tenantId, @PathParam(PROPERTY_ID) String propertyId,
          @PathParam(TAX_GROUP_ID) String taxGroupId) throws RGuestException;

    /**
     * Update TaxGroup the tax group specified by the given tax group name.
     *
     * @param tenantId
     * @param propertyId
     * @param taxGroupId, must be unique for the given tenant/property.
     * @param update
     * @return
     * @throws RGuestException
     */
    @PUT
    @Path(TAX_GROUP_ID_PATH)
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @PreAuthorize("hasPermission('Required', 'WriteAccounts')")
    // TODO check this
    TaxGroupView updateTaxGroup(@PathParam(TENANT_ID) String tenantId, @PathParam(PROPERTY_ID) String propertyId,
          @PathParam(TAX_GROUP_ID) String taxGroupId, TaxGroupView update) throws RGuestException;

    /**
     * Update a set of tax groups.
     *
     * @param tenantId
     * @param propertyId
     * @param updates
     * @return
     * @throws RGuestException
     */
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @PreAuthorize("hasPermission('Required', 'WriteAccounts')")
    // TODO check this
    List<TaxGroupView> updateTaxGroups(@PathParam(TENANT_ID) String tenantId, @PathParam(PROPERTY_ID) String propertyId,
          List<TaxGroupView> updates) throws RGuestException;

    /**
     * Delete the tax group with the specified tax group name.
     *
     * @param tenantId
     * @param propertyId
     * @param taxGroupId
     * @return
     * @throws RGuestException
     */
    @DELETE
    @Path(TAX_GROUP_ID_PATH)
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @PreAuthorize("hasPermission('Required', 'WriteAccounts')")
    // TODO check this
    TaxGroupView deleteTaxGroup(@PathParam(TENANT_ID) String tenantId, @PathParam(PROPERTY_ID) String propertyId,
          @PathParam(TAX_GROUP_ID) String taxGroupId) throws RGuestException;
}
