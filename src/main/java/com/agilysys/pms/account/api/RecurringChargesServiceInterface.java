/*
 * (C) 2014 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.api;

import java.math.BigDecimal;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.joda.time.LocalDate;
import org.springframework.security.access.prepost.PreAuthorize;

import com.agilysys.platform.common.exception.ServiceException;
import com.agilysys.platform.schema.Validated;
import com.agilysys.pms.account.model.AuthDetailResponse;
import com.agilysys.pms.account.model.CreateRecurringCharge;
import com.agilysys.pms.account.model.CreateRecurringChargeOverride;
import com.agilysys.pms.account.model.EstimatedChargesByFolioResult;
import com.agilysys.pms.account.model.EstimatedChargesView;
import com.agilysys.pms.account.model.ProgressStatusView;
import com.agilysys.pms.account.model.RecurringChargeView;
import com.agilysys.pms.account.model.RecurringChargesPostingResult;
import com.agilysys.pms.account.model.RecurringChargesPropertyView;
import com.agilysys.pms.common.api.annotation.CreatedOnSuccess;

/**
 * Recurring charges service interface Describes each of the endpoints
 */
@Path("/tenants/{tenantId}/properties/{propertyId}")
public interface RecurringChargesServiceInterface {
    public static final String TENANT_ID = "tenantId";
    public static final String PROPERTY_ID = "propertyId";
    public static final String ACCOUNT_PATH = "/accounts";
    public static final String ACCOUNT_ID = "accountId";
    public static final String ACCOUNT_ID_PATH = "/{accountId}";
    public static final String TERMINAL_ID = "terminalId";

    public static final String RECURRING_CHARGES_PATH = "/recurringCharges";
    public static final String RECURRING_CHARGE_ID = "recurringChargeId";
    public static final String RECURRING_CHARGE_ID_PATH = "/{recurringChargeId}";
    public static final String RECURRING_CHARGE_OVERRIDE_ID = "overrideDate";
    public static final String RECURRING_CHARGE_OVERRIDE_ID_PATH = "/{overrideDate}";
    public static final String RECURRING_CHARGES_PROCESS_STATUS_PATH = "/recurringChargeProgress";

    public static final String ESTIMATED_CHARGES_PATH = "/estimatedCharges";
    public static final String ESTIMATED_CHARGES_BY_PAYMENTSETTING_PATH = "/estimatedChargesByPaymentSetting";
    public static final String ESTIMATED_CHARGES_BY_FOLIO_PATH = "/estimatedChargesByFolio";
    public static final String START_DATE = "startDate";
    public static final String END_DATE = "endDate";
    public static final String NUM_ADULTS = "numAdults";

    public static final String PROPERTY_DATE = "propertyDate";
    public static final String PROPERTY_DATE_PATH = "/{propertyDate}";
    public static final String CHECKIN_AUTH_AMOUNT = "/checkinAuthAmount";
    public static final String AUTH_DETAILS = "/authDetails";

    /**
     * Retrieve all recurring charges for a property for the current propertyDate
     *
     * @param tenantId   id of tenant where the property exists
     * @param propertyId id of the property
     * @return
     */
    @GET
    @Path(RECURRING_CHARGES_PATH)
    @Produces(MediaType.APPLICATION_JSON)
    @PreAuthorize("hasPermission('Required', 'ReadAccounts')")
    public RecurringChargesPropertyView getPropertyRecurringChargesSummary(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId) throws ServiceException;

    /**
     * Retrieve recurring charges for an account
     *
     * @param tenantId   id of tenant where account exists
     * @param propertyId id of the property where the account exists
     * @param accountId  id of account
     * @return Existing recurringCharges
     */
    @GET
    @Path(ACCOUNT_PATH + ACCOUNT_ID_PATH + RECURRING_CHARGES_PATH)
    @Produces(MediaType.APPLICATION_JSON)
    @PreAuthorize("hasPermission('Required', 'ReadAccounts')")
    public List<RecurringChargeView> getRecurringCharges(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @PathParam(ACCOUNT_ID) String accountId,
          @QueryParam(START_DATE) LocalDate startDate, @QueryParam(END_DATE) LocalDate endDate) throws ServiceException;

    /**
     * Create a recurring charge for an account
     *
     * @param tenantId              id of tenant where account exists
     * @param propertyId            id of the property where the account exists
     * @param accountId             id of account to save settings to
     * @param createRecurringCharge recurring charge to save
     * @param startDate
     * @param endDate               Start date and end date creates the range for what RecurringChargeView dates should
     *                              be returned
     * @return Created recurring charge
     */
    @POST
    @CreatedOnSuccess
    @Path(ACCOUNT_PATH + ACCOUNT_ID_PATH + RECURRING_CHARGES_PATH)
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Validated(CreateRecurringCharge.class)
    @PreAuthorize("hasPermission('Required', 'WriteAccounts')")
    public List<RecurringChargeView> createRecurringCharge(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @PathParam(ACCOUNT_ID) String accountId,
          CreateRecurringCharge createRecurringCharge, @QueryParam(START_DATE) LocalDate startDate,
          @QueryParam(END_DATE) LocalDate endDate) throws ServiceException;

    /**
     * Retrieve recurring charge for an account
     *
     * @param tenantId          id of tenant where account exists
     * @param propertyId        id of the property where the account exists
     * @param accountId         id of account where recurring charge exists
     * @param recurringChargeId recurring charge to retrieve
     * @return Retrieved Settings
     */
    @GET
    @Path(ACCOUNT_PATH + ACCOUNT_ID_PATH + RECURRING_CHARGES_PATH + RECURRING_CHARGE_ID_PATH)
    @Produces(MediaType.APPLICATION_JSON)
    @PreAuthorize("hasPermission('Required', 'ReadAccounts')")
    public List<RecurringChargeView> getRecurringCharge(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @PathParam(ACCOUNT_ID) String accountId,
          @PathParam(RECURRING_CHARGE_ID) String recurringChargeId, @QueryParam(START_DATE) LocalDate startDate,
          @QueryParam(END_DATE) LocalDate endDate) throws ServiceException;

    /**
     * Retrieve recurring charge for an account
     *
     * @param tenantId   id of tenant where account exists
     * @param propertyId id of the property where the account exists
     */
    @GET
    @Path(RECURRING_CHARGES_PROCESS_STATUS_PATH)
    @Produces(MediaType.APPLICATION_JSON)
    @PreAuthorize("hasPermission('Required', 'ReadAccounts')")
    public ProgressStatusView getRecurringChargeProgress(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId) throws ServiceException;

    /**
     * Runs recurring charges for a given date, the date must be equal to or before the current property date
     *
     * @param tenantId
     * @param propertyId
     * @param propertyDate
     * @param terminalId
     * @return Results from posting the charges
     */
    @POST
    @Path(RECURRING_CHARGES_PATH + PROPERTY_DATE_PATH)
    @Produces(MediaType.APPLICATION_JSON)
    @PreAuthorize("hasPermission('Required', 'WriteAccounts')")
    public RecurringChargesPostingResult postRecurringCharges(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @PathParam(PROPERTY_DATE) LocalDate propertyDate,
          @QueryParam(TERMINAL_ID) String terminalId, @QueryParam("tag") String tag) throws ServiceException;

    /* Overrides */

    /**
     * Update an existing recurring charge override for an account
     *
     * @param tenantId
     * @param propertyId
     * @param accountId
     * @param recurringChargeId
     * @param overrideDate
     * @return Updated recurring charge override
     */
    @PUT
    @Path(ACCOUNT_PATH + ACCOUNT_ID_PATH + RECURRING_CHARGES_PATH + RECURRING_CHARGE_ID_PATH +
          RECURRING_CHARGE_OVERRIDE_ID_PATH)
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Validated(CreateRecurringChargeOverride.class)
    @PreAuthorize("hasPermission('Required', 'WriteAccounts')")
    public RecurringChargeView updateRecurringChargeOverride(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @PathParam(ACCOUNT_ID) String accountId,
          @PathParam(RECURRING_CHARGE_ID) String recurringChargeId,
          @PathParam(RECURRING_CHARGE_OVERRIDE_ID) LocalDate overrideDate,
          CreateRecurringChargeOverride recurringChargeOverride) throws ServiceException;

    /* Estimated Charges */

    /**
     * @param tenantId
     * @param propertyId
     * @param accountId
     * @param startDate
     * @param endDate
     * @return The estimated charges for the given date range, or the current date if date range not given.
     */
    @GET
    @Path(ACCOUNT_PATH + ACCOUNT_ID_PATH + ESTIMATED_CHARGES_PATH)
    @Produces(MediaType.APPLICATION_JSON)
    @PreAuthorize("hasPermission('Required', 'ReadAccounts')")
    public EstimatedChargesView getEstimatedCharges(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @PathParam(ACCOUNT_ID) String accountId,
          @QueryParam(START_DATE) LocalDate startDate, @QueryParam(END_DATE) LocalDate endDate) throws ServiceException;

    /**
     * @param tenantId
     * @param propertyId
     * @param accountId
     * @param startDate
     * @param endDate
     * @return The estimated charges for the given date range, or the current
     * date if date range not given. Returns an estimated charges views
     * for each payment setting on the account.
     */
    @GET
    @Path(ACCOUNT_PATH + ACCOUNT_ID_PATH + ESTIMATED_CHARGES_BY_PAYMENTSETTING_PATH)
    @Produces(MediaType.APPLICATION_JSON)
    @PreAuthorize("hasPermission('Required', 'ReadAccounts')")
    public List<EstimatedChargesView> getEstimatedChargesByPaymentSetting(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @PathParam(ACCOUNT_ID) String accountId,
          @QueryParam(START_DATE) LocalDate startDate, @QueryParam(END_DATE) LocalDate endDate) throws ServiceException;

    /**
     * @param tenantId
     * @param propertyId
     * @param accountId
     * @return The estimated charges for the given date range, or the current
     * date if date range not given. Returns an estimated charges views
     * for each payment setting on the account.
     */
    @GET
    @Path(ACCOUNT_PATH + ACCOUNT_ID_PATH + ESTIMATED_CHARGES_BY_FOLIO_PATH)
    @Produces(MediaType.APPLICATION_JSON)
    @PreAuthorize("hasPermission('Required', 'ReadAccounts')")
    public EstimatedChargesByFolioResult getEstimatedChargesByFolio(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @PathParam(ACCOUNT_ID) String accountId) throws ServiceException;

    /**
     * Retrieves the amount to be authed on a card for checkin
     */
    @GET
    @Path(ACCOUNT_PATH + ACCOUNT_ID_PATH + CHECKIN_AUTH_AMOUNT)
    @Produces(MediaType.APPLICATION_JSON)
    @PreAuthorize("hasPermission('Required', 'ReadAccounts')")
    @Deprecated
    public BigDecimal getCheckinAuthAmount(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @PathParam(ACCOUNT_ID) String accountId,
          @QueryParam(START_DATE) LocalDate startDate, @QueryParam(END_DATE) LocalDate endDate,
          @QueryParam(NUM_ADULTS) int numAdults);

    /**
     * Retrieves the amount to be authed on a card for checkin
     */
    @GET
    @Path(ACCOUNT_PATH + ACCOUNT_ID_PATH + AUTH_DETAILS)
    @Produces(MediaType.APPLICATION_JSON)
    @PreAuthorize("hasPermission('Required', 'ReadAccounts')")
    public AuthDetailResponse getAuthDetails(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @PathParam(ACCOUNT_ID) String accountId);
}
