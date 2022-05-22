/*
 * (C) 2015 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.api;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.agilysys.platform.common.rguest.exception.RGuestException;
import com.agilysys.pms.account.model.payagent.PayAgentTransactionView;
import com.agilysys.pms.account.model.payagent.PayTransactionRequest;
import com.agilysys.pms.account.model.payagent.PayTransactionUpdateRequest;
import com.agilysys.pms.common.security.Permission;
import com.agilysys.pms.common.security.Requires;

@Path("/tenants/{tenantId}/properties/{propertyId}/payTransactions")
public interface PayAgentTransactionInterface {
    String TENANT_ID = "tenantId";
    String PROPERTY_ID = "propertyId";
    String PAY_TRANSACTION_ID = "payTransactionId";

    /**
     * Retrieve a transaction by captureId
     *
     * @param tenantId         id of tenant where the account exists
     * @param propertyId       id of property where the account exists
     * @param payTransactionId reference id of the account to retrieve
     * @return an account for the tenant and referenceId
     */
    @GET
    @Path("/{payTransactionId}")
    @Produces(MediaType.APPLICATION_JSON)
    @Requires(Permission.READ_ACCOUNTS)
    PayAgentTransactionView getPayTransaction(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @PathParam(PAY_TRANSACTION_ID) String payTransactionId)
          throws RGuestException;

    /**
     * Post a request for a captureId and accompanying payload to be sent to an rGuest Pay Agent
     *
     * @param tenantId   id of tenant where the account exists
     * @param propertyId id of property where the account exists
     * @param request    request object with account id and type of payload requested (auth, sale, token, etc) based on
     *                   the rGuest Pay endpoint that will be called
     * @return a PayTransactionResponse object with the required payload, account id, and reference id
     */
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Requires(Permission.READ_ACCOUNTS)
    PayAgentTransactionView createPayTransaction(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, PayTransactionRequest request) throws RGuestException;

    /**
     * Completes an existing pay transaction with the supplied response from the Pay Agent
     *
     * @return the updated PayTransactionResponse
     */
    @PUT
    @Path("/{payTransactionId}")
    @Produces(MediaType.APPLICATION_JSON)
    @Requires(Permission.READ_ACCOUNTS)
    PayAgentTransactionView completePayTransaction(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @PathParam(PAY_TRANSACTION_ID) String payTransactionId,
          PayTransactionUpdateRequest request) throws RGuestException;

    /**
     * Indicates that the identified pay agent transaction is complete and should be queried from the Pay Event Service
     * for processing
     *
     * @return the updated PayTransactionResponse
     */
    @POST
    @Path("/{payTransactionId}")
    @Produces(MediaType.APPLICATION_JSON)
    @Requires(Permission.READ_ACCOUNTS)
    PayAgentTransactionView reportRemotePayTransaction(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @PathParam(PAY_TRANSACTION_ID) String payTransactionId, String id)
          throws RGuestException;

    /**
     * Cancels an existing pay transaction
     *
     * @return the updated PayTransactionResponse
     */
    @DELETE
    @Path("/{payTransactionId}")
    @Produces(MediaType.APPLICATION_JSON)
    @Requires(Permission.READ_ACCOUNTS)
    PayAgentTransactionView cancelPayTransaction(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @PathParam(PAY_TRANSACTION_ID) String payTransactionId)
          throws RGuestException;
}