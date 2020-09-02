/*
 * (C) 2014 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
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
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.joda.time.LocalDate;
import org.springframework.security.access.prepost.PreAuthorize;

import com.agilysys.common.model.EnhancementRequest;
import com.agilysys.common.model.EnhancementResponse;
import com.agilysys.common.model.CreateRecurringCharge;
import com.agilysys.common.model.rate.CreateRecurringChargeOverride;
import com.agilysys.platform.common.rguest.exception.RGuestException;
import com.agilysys.platform.schema.Validated;
import com.agilysys.pms.account.model.AuthDetailResponse;
import com.agilysys.pms.account.model.EstimatedChargeDetailsForOffers;
import com.agilysys.pms.account.model.EstimatedChargesByFolioResult;
import com.agilysys.pms.account.model.EstimatedChargesView;
import com.agilysys.pms.account.model.EstimatedRoomChargeView;
import com.agilysys.pms.account.model.OfferDetails;
import com.agilysys.pms.account.model.ProgressStatusView;
import com.agilysys.pms.account.model.RecurringChargeView;
import com.agilysys.pms.account.model.RecurringChargesPostingResult;
import com.agilysys.pms.account.model.RecurringChargesPropertyView;
import com.agilysys.pms.account.model.RecurringChargesValidityRequest;
import com.agilysys.pms.account.model.RecurringChargesValidityResponse;
import com.agilysys.pms.common.api.annotation.CreatedOnSuccess;

/**
 * Recurring charges service interface Describes each of the endpoints
 */
@Path("/tenants/{tenantId}/properties/{propertyId}")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface RecurringChargesServiceInterface {
    String TENANT_ID = "tenantId";
    String PROPERTY_ID = "propertyId";
    String ACCOUNT_PATH = "/accounts";
    String ACCOUNT_ID = "accountId";
    String ACCOUNT_ID_PATH = "/{accountId}";
    String TERMINAL_ID = "terminalId";

    String RECURRING_CHARGES_PATH = "/recurringCharges";
    String ENHANCEMENT_VALIDITY_PATH = "/enhancements";
    String RECURRING_CHARGE_ID = "recurringChargeId";
    String RECURRING_CHARGE_ID_PATH = "/{recurringChargeId}";
    String RECURRING_CHARGE_OVERRIDE = "/override";
    String RECURRING_CHARGE_OVERRIDE_ID = "overrideDate";
    String RECURRING_CHARGE_OVERRIDE_ID_PATH = "/{overrideDate}";
    String RECURRING_CHARGES_PROCESS_STATUS_PATH = "/recurringChargeProgress";

    String ESTIMATED_ROOM_CHARGES_PATH = "/estimatedRoomCharges";
    String ESTIMATED_CHARGES_PATH = "/estimatedCharges";
    String ESTIMATED_CHARGES_BY_PAYMENTSETTING_PATH = "/estimatedChargesByPaymentSetting";
    String ESTIMATED_CHARGES_BY_RESERVATION_PATH = "/estimatedChargesByReservationIds";
    String ESTIMATED_CHARGES_BY_FOLIO_PATH = "/estimatedChargesByFolio";
    String ESTIMATED_CHARGES_WITH_OFFERS = "/estimatedChargesWithOffers";
    String START_DATE = "startDate";
    String END_DATE = "endDate";
    String ARRIVAL_DATE = "arrivalDate";
    String DEPARTURE_DATE = "departureDate";
    String NUM_ADULTS = "numAdults";

    String PROPERTY_DATE = "propertyDate";
    String PROPERTY_DATE_PATH = "/{propertyDate}";
    String CHECKIN_AUTH_AMOUNT = "/checkinAuthAmount";
    String AUTH_DETAILS = "/authDetails";
    String BATCH = "/batch";
    String VALIDITY = "/validity";
    String INVENTORY = "/inventory";
    String BULK = "/bulk";
    String CHECK_IF_ROOM_TYPE_ALLOWED = "/CheckIfRoomTypeAllowed";
    String ROOM_TYPE_ID = "roomTypeId";
    String ROOM_TYPE_ID_PATH = "/{roomTypeId}";


    /**
     * Retrieve all recurring charges for a property for the current propertyDate
     *
     * @param tenantId   id of tenant where the property exists
     * @param propertyId id of the property
     * @return
     */
    @GET
    @Path(RECURRING_CHARGES_PATH)
    @PreAuthorize("hasPermission('Required', 'ReadAccounts')")
    RecurringChargesPropertyView getPropertyRecurringChargesSummary(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId) throws RGuestException;

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
    @PreAuthorize("hasPermission('Required', 'ReadAccounts')")
    List<RecurringChargeView> getRecurringCharges(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @PathParam(ACCOUNT_ID) String accountId,
          @QueryParam(START_DATE) LocalDate startDate, @QueryParam(END_DATE) LocalDate endDate) throws RGuestException;

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
    @Validated(CreateRecurringCharge.class)
    @PreAuthorize("hasPermission('Required', 'WriteAccounts')")
    List<RecurringChargeView> createRecurringCharge(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @PathParam(ACCOUNT_ID) String accountId,
          CreateRecurringCharge createRecurringCharge, @QueryParam(START_DATE) LocalDate startDate,
          @QueryParam(END_DATE) LocalDate endDate) throws RGuestException;

    /**
     * Create List of recurring charge for an account
     *
     * @param tenantId               id of tenant where account exists
     * @param propertyId             id of the property where the account exists
     * @param accountId              id of account to save settings to
     * @param createRecurringCharges </List<CreateRecurringCharge> recurring charges to save
     * @param startDate
     * @param endDate                Start date and end date creates the range for what RecurringChargeView dates should
     *                               be returned
     * @return Created recurring charge
     */
    @POST
    @Path(ACCOUNT_PATH + ACCOUNT_ID_PATH + RECURRING_CHARGES_PATH + BATCH)
    @PreAuthorize("hasPermission('Required', 'WriteAccounts')")
    List<RecurringChargeView> createRecurringCharges(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @PathParam(ACCOUNT_ID) String accountId,
          List<CreateRecurringCharge> createRecurringCharges, @QueryParam(START_DATE) LocalDate startDate,
          @QueryParam(END_DATE) LocalDate endDate) throws RGuestException;

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
    @PreAuthorize("hasPermission('Required', 'ReadAccounts')")
    List<RecurringChargeView> getRecurringCharge(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @PathParam(ACCOUNT_ID) String accountId,
          @PathParam(RECURRING_CHARGE_ID) String recurringChargeId, @QueryParam(START_DATE) LocalDate startDate,
          @QueryParam(END_DATE) LocalDate endDate) throws RGuestException;

    /**
     * Retrieve recurring charge for an account
     *
     * @param tenantId   id of tenant where account exists
     * @param propertyId id of the property where the account exists
     */
    @GET
    @Path(RECURRING_CHARGES_PROCESS_STATUS_PATH)
    @PreAuthorize("hasPermission('Required', 'ReadAccounts')")
    ProgressStatusView getRecurringChargeProgress(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId) throws RGuestException;

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
    @PreAuthorize("hasPermission('Required', 'WriteAccounts')")
    RecurringChargesPostingResult postRecurringCharges(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @PathParam(PROPERTY_DATE) LocalDate propertyDate,
          @QueryParam(TERMINAL_ID) String terminalId, @QueryParam("tag") String tag) throws RGuestException;

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
    @Validated(CreateRecurringChargeOverride.class)
    @PreAuthorize("hasPermission('Required', 'WriteAccounts')")
    RecurringChargeView updateRecurringChargeOverride(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @PathParam(ACCOUNT_ID) String accountId,
          @PathParam(RECURRING_CHARGE_ID) String recurringChargeId,
          @PathParam(RECURRING_CHARGE_OVERRIDE_ID) LocalDate overrideDate,
          CreateRecurringChargeOverride recurringChargeOverride) throws RGuestException;

    /* Estimated Charges */

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
    @PreAuthorize("hasPermission('Required', 'ReadAccounts')")
    List<EstimatedChargesView> getEstimatedChargesByPaymentSetting(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @PathParam(ACCOUNT_ID) String accountId,
          @QueryParam(START_DATE) LocalDate startDate, @QueryParam(END_DATE) LocalDate endDate) throws RGuestException;

    /* Estimated Charges By Reservation Ids */

    @POST
    @Path(ACCOUNT_PATH + ESTIMATED_CHARGES_BY_RESERVATION_PATH)
    @PreAuthorize("hasPermission('Required', 'ReadAccounts')")
    Map<String, List<EstimatedChargesView>> getEstimatedChargesByReservationIds(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @QueryParam(START_DATE) LocalDate startDate,
          @QueryParam(END_DATE) LocalDate endDate, Set<String> reservationIds) throws RGuestException;

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
    @PreAuthorize("hasPermission('Required', 'ReadAccounts')")
    EstimatedChargesByFolioResult getEstimatedChargesByFolio(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @PathParam(ACCOUNT_ID) String accountId) throws RGuestException;

    @POST
    @Path(ACCOUNT_PATH + ESTIMATED_CHARGES_WITH_OFFERS)
    @PreAuthorize("hasPermission('Required', 'ReadAccounts')")
    EstimatedChargeDetailsForOffers getEstimatedChargesWithOfferDetails(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, OfferDetails offerDetails) throws RGuestException;

    /**
     * Retrieves the amount to be authed on a card for checkin
     */
    @GET
    @Path(ACCOUNT_PATH + ACCOUNT_ID_PATH + AUTH_DETAILS)
    @PreAuthorize("hasPermission('Required', 'ReadAccounts')")
    AuthDetailResponse getAuthDetails(@PathParam(TENANT_ID) String tenantId, @PathParam(PROPERTY_ID) String propertyId,
          @PathParam(ACCOUNT_ID) String accountId) throws RGuestException;

    /**
     * Batch update API to override(charge, quantity, cancel) the recurring charges for specific
     * dates
     */
    @PUT
    @Path(ACCOUNT_PATH + ACCOUNT_ID_PATH + RECURRING_CHARGES_PATH + RECURRING_CHARGE_OVERRIDE + BATCH)
    @PreAuthorize("hasPermission('Required', 'WriteAccounts')")
    List<RecurringChargeView> updateRecurringChargesOverride(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @PathParam(ACCOUNT_ID) String accountId,
          Map<String, Map<LocalDate, CreateRecurringChargeOverride>> recurringChargeOverrideMap) throws RGuestException;

    /**
     * Retrieves the count of invalid recurring charges which does not dependent on reservation
     * dates and inventory recurring charges which does not have required inventory item quantity for the given
     * reservation start and end date
     *
     * @param arrivalDate   reservation new arrival date
     * @param departureDate reservation new departure date
     */
    @Deprecated
    @GET
    @Path(ACCOUNT_PATH + ACCOUNT_ID_PATH + RECURRING_CHARGES_PATH + VALIDITY)
    @PreAuthorize("hasPermission('Required', 'ReadAccounts')")
    RecurringChargesValidityResponse getRecurringChargesValidity(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @PathParam(ACCOUNT_ID) String accountId,
          @QueryParam(ARRIVAL_DATE) LocalDate arrivalDate, @QueryParam(DEPARTURE_DATE) LocalDate departureDate)
          throws RGuestException;

    /**
     * Retrieves the details of recurring charges which
     * 1. Does not dependent on reservation dates
     * 2. Violates inventory max per reservation restriction
     * 3. Violates inventory room type restriction
     * 4. Required quantity not available
     */
    @POST
    @Path(ACCOUNT_PATH + ACCOUNT_ID_PATH + RECURRING_CHARGES_PATH + VALIDITY)
    @PreAuthorize("hasPermission('Required', 'ReadAccounts')")
    RecurringChargesValidityResponse getRecurringChargesValidity(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @PathParam(ACCOUNT_ID) String accountId,
          RecurringChargesValidityRequest recurringChargesValidityRequest) throws RGuestException;

    /**
     * Retrieves the details of recurring charges which
     * 1. Do not dependent on reservation dates
     * 2. Violates inventory max per reservation restriction
     * 3. Violates inventory room type restriction
     * 4. Required quantity not available
     */
    @POST
    @Path(RECURRING_CHARGES_PATH + VALIDITY)
    @PreAuthorize("hasPermission('Required', 'ReadAccounts')")
    RecurringChargesValidityResponse getRecurringChargesValidityForCreate(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, RecurringChargesValidityRequest recurringChargesValidityRequest)
          throws RGuestException;

    /**
     * Retrieves the details of Items for Rbook
     * 1. Do not dependent on reservation dates
     * 2. Violates inventory max per reservation restriction
     * 3. Violates inventory room type restriction
     * 4. Required quantity not available
     */
    @POST
    @Path(ENHANCEMENT_VALIDITY_PATH + VALIDITY)
    @PreAuthorize("hasPermission('Required', 'ReadAccounts')")
    EnhancementResponse getValidEnhancementItems(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, EnhancementRequest enhancementRequest)
          throws RGuestException;


    @POST
    @Path(RECURRING_CHARGES_PATH + VALIDITY + BULK)
    @PreAuthorize("hasPermission('Required', 'ReadAccounts')")
    List<RecurringChargesValidityResponse> getBulkRecurringChargesValidityForCreate(
          @PathParam(TENANT_ID) String tenantId, @PathParam(PROPERTY_ID) String propertyId,
          RecurringChargesValidityRequest recurringChargesValidityRequest) throws RGuestException;

    /**
     * @return The estimated room charges for the given date range, or the current
     * date if date range not given. Returns a list of estimated room charge view.
     *
     * Future plan: May add additional query parameters for loyalty to work beyong Drury, see VCTRS-63195.
     */
    @GET
    @Path(ACCOUNT_PATH + ACCOUNT_ID_PATH + ESTIMATED_ROOM_CHARGES_PATH)
    @PreAuthorize("hasPermission('Required', 'ReadAccounts')")
    List<EstimatedRoomChargeView> getEstimatedRoomCharges(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @PathParam(ACCOUNT_ID) String accountId,
          @QueryParam(START_DATE) LocalDate startDate, @QueryParam(END_DATE) LocalDate endDate) throws RGuestException;

    @GET
    @Path(ACCOUNT_PATH + ACCOUNT_ID_PATH + CHECK_IF_ROOM_TYPE_ALLOWED + ROOM_TYPE_ID_PATH)
    Boolean checkIfRoomTypeChangeAllowedForRecurringCharges(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @PathParam(ACCOUNT_ID) Set<String> accountId, @PathParam(ROOM_TYPE_ID) String roomTypeId);
}
