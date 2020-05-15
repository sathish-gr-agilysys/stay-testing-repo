/*
 * (C) 2013 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
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

import com.agilysys.platform.common.rguest.exception.RGuestException;
import com.agilysys.platform.schema.Validated;
import com.agilysys.pms.account.model.PaymentMethod;
import com.agilysys.pms.account.model.RestrictivePermission;
import com.agilysys.pms.common.api.annotation.CreatedOnSuccess;

/**
 * CRUD Methods for PaymentMethod
 */
@Path("/tenants/{tenantId}/properties/{propertyId}/config/paymentMethods")
public interface PaymentMethodInterface {
    String TENANT_ID = "tenantId";
    String PROPERTY_ID = "propertyId";
    String PAYMENT_METHOD_ID = "id";
    String PAYMENT_METHOD_ID_PATH = "{id}";
    String PERMISSIONS_PATH = "/restrictivePermissions";

    /**
     * Retrieve all PaymentMethods
     *
     * @param tenantId   the tenantId to retrieve PaymentMethods for
     * @param propertyId the propertyId to retrieve PaymentMethods for
     * @return List of PaymentMethods
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @PreAuthorize("hasPermission('Required', 'ReadPropertyConfig')")
    List<PaymentMethod> getPaymentMethods(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId) throws RGuestException;

    /**
     * Retrieve a specific PaymentMethod
     *
     * @param tenantId        the tenantId to retrieve the PaymentMethods for
     * @param propertyId      the propertyId to retrieve PaymentMethods for
     * @param paymentMethodId the ID of the PaymentMethod to retrieve
     * @return the PaymentMethod identified by itemId
     */
    @GET
    @Path(PAYMENT_METHOD_ID_PATH)
    @Produces(MediaType.APPLICATION_JSON)
    @PreAuthorize("hasPermission('Required', 'ReadPropertyConfig')")
    PaymentMethod getPaymentMethod(@PathParam(TENANT_ID) String tenantId, @PathParam(PROPERTY_ID) String propertyId,
          @PathParam(PAYMENT_METHOD_ID) String paymentMethodId) throws RGuestException;

    /**
     * Create a new PaymentMethod
     *
     * @param tenantId      the tenantId to create a PaymentMethod for
     * @param propertyId    the propertyId to create a PaymentMethods for
     * @param paymentMethod the new PaymentMethod to persist
     * @return the newly create PaymentMethod with auto-generated ID
     */
    @POST
    @CreatedOnSuccess
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Validated(PaymentMethod.class)
    @PreAuthorize("hasPermission('Required', 'WritePropertyConfig')")
    PaymentMethod createPaymentMethod(@PathParam(TENANT_ID) String tenantId, @PathParam(PROPERTY_ID) String propertyId,
          PaymentMethod paymentMethod) throws RGuestException;

    /**
     * Modify an existing PaymentMethod
     *
     * @param tenantId        the tenantId to modify the PaymentMethods for
     * @param propertyId      the propertyId to modify PaymentMethods for
     * @param paymentMethodId the ID of the PaymentMethod to modify
     * @param paymentMethod   the modified PaymentMethod to persist
     * @return the modified PaymentMethod
     */
    @PUT
    @Path(PAYMENT_METHOD_ID_PATH)
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Validated(PaymentMethod.class)
    @PreAuthorize("hasPermission('Required', 'WritePropertyConfig')")
    PaymentMethod updatePaymentMethod(@PathParam(TENANT_ID) String tenantId, @PathParam(PROPERTY_ID) String propertyId,
          @PathParam(PAYMENT_METHOD_ID) String paymentMethodId, PaymentMethod paymentMethod) throws RGuestException;

    /**
     * Delete an existing PaymentMethod
     *
     * @param tenantId        the tenantId to delete the PaymentMethod for
     * @param propertyId      the propertyId to delete PaymentMethods for
     * @param paymentMethodId the ID of the PaymentMethod to delete
     */
    @DELETE
    @Path(PAYMENT_METHOD_ID_PATH)
    @Produces(MediaType.APPLICATION_JSON)
    @PreAuthorize("hasPermission('Required', 'WritePropertyConfig')")
    void deletePaymentMethod(@PathParam(TENANT_ID) String tenantId, @PathParam(PROPERTY_ID) String propertyId,
          @PathParam(PAYMENT_METHOD_ID) String paymentMethodId) throws RGuestException;

    @GET
    @Path(PERMISSIONS_PATH)
    @Produces(MediaType.APPLICATION_JSON)
    @PreAuthorize("hasPermission('Required', 'ReadPropertyConfig')")
    List<RestrictivePermission> getRestrictivePermissions(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId) throws RGuestException;
}
