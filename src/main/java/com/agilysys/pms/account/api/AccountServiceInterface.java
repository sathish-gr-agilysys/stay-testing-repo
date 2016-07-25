/**
 * (C) 2013 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */

package com.agilysys.pms.account.api;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.a3badran.platform.logging.LogParam;
import org.joda.time.LocalDate;
import org.springframework.security.access.prepost.PreAuthorize;

import com.agilysys.common.model.PaymentSetting;
import com.agilysys.platform.common.exception.ServiceException;
import com.agilysys.platform.schema.Validated;
import com.agilysys.pms.account.api.params.InvoiceFilteringOptionalParams;
import com.agilysys.pms.account.api.params.InvoiceOptionalParams;
import com.agilysys.pms.account.model.AccountDetail;
import com.agilysys.pms.account.model.AccountSearchResult;
import com.agilysys.pms.account.model.AccountSummary;
import com.agilysys.pms.account.model.AccountsCollectionRequest;
import com.agilysys.pms.account.model.AccountsReceivableSettings;
import com.agilysys.pms.account.model.AmountTransfer;
import com.agilysys.pms.account.model.ApplyInvoicePaymentRequest;
import com.agilysys.pms.account.model.Charge;
import com.agilysys.pms.account.model.ChargeTaxAmountInfo;
import com.agilysys.pms.account.model.ChargeTaxAmountRequest;
import com.agilysys.pms.account.model.CreateAccountSummary;
import com.agilysys.pms.account.model.Credit;
import com.agilysys.pms.account.model.FolioBalance;
import com.agilysys.pms.account.model.FolioDetail;
import com.agilysys.pms.account.model.FolioSummary;
import com.agilysys.pms.account.model.GetFoliosOptionalParameters;
import com.agilysys.pms.account.model.GroupCompanyTaxExemptSettings;
import com.agilysys.pms.account.model.InvoicePaymentRefund;
import com.agilysys.pms.account.model.InvoiceRequest;
import com.agilysys.pms.account.model.InvoiceView;
import com.agilysys.pms.account.model.LedgerBalancesInfo;
import com.agilysys.pms.account.model.LineItemAdjustment;
import com.agilysys.pms.account.model.LineItemTransfer;
import com.agilysys.pms.account.model.LineItemView;
import com.agilysys.pms.account.model.NextAccountNumberInfo;
import com.agilysys.pms.account.model.NonInvoicedARDetail;
import com.agilysys.pms.account.model.Payment;
import com.agilysys.pms.account.model.PaymentInstrumentAuthStatus;
import com.agilysys.pms.account.model.PaymentRefund;
import com.agilysys.pms.account.model.PostingRuleDetail;
import com.agilysys.pms.account.model.PostingRuleDetailView;
import com.agilysys.pms.account.model.TaxExemptSettingsByDate;
import com.agilysys.pms.account.model.UpdateInvoiceLineItemsRequest;
import com.agilysys.pms.account.model.UpdateInvoiceTermsRequest;
import com.agilysys.pms.common.api.annotation.CreatedOnSuccess;
import com.agilysys.pms.common.api.annotation.OkOnEmpty;
import com.agilysys.pms.common.model.CollectionResponse;
import com.wordnik.swagger.annotations.ApiParam;

/**
 * Account Service endpoint interface
 *
 * @see <a href="http://confluence.bellevue.ad.local:8090/display/VICTRIAL/Account+Service">Confluence: Account
 * Service</a>
 */
@Path("/tenants/{tenantId}/accounts")
public interface AccountServiceInterface {
    public static final String TENANT_ID = "tenantId";
    public static final String ACCOUNT_ID = "accountId";
    public static final String ACCOUNT_ID_PATH = "{accountId}";
    public static final String REFERENCE_ID_PATH = "/reference/{referenceId}";
    public static final String REFERENCE_ID = "referenceId";
    public static final String ACCOUNT_STATUS_PATH = "/status/{accountStatus}";
    public static final String ACCOUNT_STATUS = "accountStatus";
    public static final String FOLIO_PATH = "/folios";
    public static final String NON_INVOICED_PATH = "/nonInvoicedDetails";
    public static final String FOLIO_ID = "folioId";
    public static final String FOLIO_ID_PATH = "/{folioId}";
    public static final String FOLIO_BALANCES_PATH = "/folioBalances";

    public static final String INVOICE_ID = "invoiceId";
    public static final String INVOICE_ID_PATH = "/{invoiceId}";
    public static final String INVOICES_PATH = "/invoices";
    public static final String INVOICE_ADD_ITEMS_PATH = "/addItems";
    public static final String INVOICE_UPDATE_TERMS_PATH = "/updateTerms";
    public static final String INVOICE_REMOVE_ITEMS_PATH = "/removeItems";
    public static final String INVOICE_SET_INVOICE_SENT = "/setInvoiceSent";
    public static final String POSTING_RULES_PATH = "/postingRules";
    public static final String POSTING_RULE_ID = "postingRulesId";
    public static final String POSTING_RULE_ID_PATH = "/{postingRulesId}";
    public static final String CHARGES_PATH = "/charges";
    public static final String PAYMENTS_PATH = "/payments";
    public static final String PAYOFF_BALANCE_PATH = "/payOffBalance";
    public static final String CREDIT_PATH = "/credit";
    public static final String REFUNDS_PATH = "/refunds"; //Used for generic refunds
    public static final String REFUND_PATH = "/refund"; //Used for a refund of a specific line item
    public static final String TRANSFER_CHARGES_PATH = "/transferCharges";
    public static final String VERIFY_CHECKOUT_PATH = "/verifyCheckout";
    public static final String VERIFY_CHECKOUT_ALLOWED_PATH = "/verifyCheckoutAllowed";
    public static final String LEDGER_BALANCES_PATH = "/ledgerBalances";
    public static final String PAYMENT_SETTINGS_PATH = "/paymentSettings";
    public static final String TAXEXEMPT_SETTINGS_BYDATE_PATH = "/taxExemptSettingsByDate";
    public static final String GROUP_COMPANY_TAXEXEMPT_SETTINGS_PATH = "/groupCompanyTaxExemptSettings";
    public static final String TRANSFER_AMOUNT_PATH = "/transferAmount";
    public static final String CHARGE_TAX_AMOUNT_PATH = "/calculateChargeTaxAmount";
    public static final String ADJUSTMENT_PATH = "/adjustment";
    public static final String CORRECTION_PATH = "/correction";
    public static final String SEARCH_PATH = "/search";
    public static final String SEARCH_TERM = "searchTerm";
    public static final String SEARCH_TERM_PATH = "/{searchTerm}";
    public static final String REMAINING_PATH = "/{path:.*}";
    public static final String PATH = "path";
    public static final String TYPES_PATH = "types";
    public static final String STATUSES_PATH = "statuses";
    public static final String ACCOUNTS_RECEIVABLE_SETTINGS_PATH = "/accountsReceivableSettings";
    public static final String APPLY_PAYMENTS = "/applyPayments";
    public static final String NEXT_ACCOUNT_NUMBER_PATH = "/nextAccountNumber";
    public static final String MIGRATE_ACCOUNTS_RECEIVABLE = "/migrateAccountsReceivable";
    public static final String AUTH_CARDS_ON_ACCOUNT_PATH = "/authCardsOnAccount";
    public static final String FILTERED = "/filtered";
    public static final String START_DATE = "startDate";
    public static final String END_DATE = "endDate";

    /**
     * Retrieve all accounts from a tenant
     *
     * @param tenantId id of tenant where accounts exist
     * @return Existing accounts for the tenant
     * @deprecated use {@link AccountServiceInterfaceV1#getAccounts(String, String, String, String)}
     */
    @Deprecated
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @PreAuthorize("hasPermission('Required', 'ReadAccounts')")
    public List<AccountSummary> getAccounts(@PathParam(TENANT_ID) String tenantId) throws ServiceException;

    /**
     * Retrieve an account by reference id
     *
     * @param tenantId    id of tenant where the account exists
     * @param referenceId reference id of the account to retrieve
     * @return an account for the tenant and referenceId
     */
    @Deprecated
    @GET
    @Path(REFERENCE_ID_PATH)
    @Produces(MediaType.APPLICATION_JSON)
    @PreAuthorize("hasPermission('Required', 'ReadAccounts')")
    public AccountSummary getAccountByReferenceId(@PathParam(TENANT_ID) String tenantId,
          @PathParam(REFERENCE_ID) String referenceId) throws ServiceException;

    /**
     * Retrieve an account
     *
     * @param tenantId  id of tenant where the account exists
     * @param accountId account to retrieve
     * @return Existing account for the tenant
     * @deprecated use {@link AccountServiceInterfaceV1#getAccount(String, String, String)}
     */
    @Deprecated
    @GET
    @Path(ACCOUNT_ID_PATH)
    @Produces(MediaType.APPLICATION_JSON)
    @PreAuthorize("hasPermission('Required', 'ReadAccounts')")
    public AccountSummary getAccount(@PathParam(TENANT_ID) String tenantId, @PathParam(ACCOUNT_ID) String accountId)
          throws ServiceException;

    /**
     * Retrieve all account types
     *
     * @param tenantId tenantId
     * @return Available account types in the system
     */
    @Deprecated
    @GET
    @Path(TYPES_PATH)
    @Produces(MediaType.APPLICATION_JSON)
    @PreAuthorize("hasPermission('Required', 'ReadAccounts')")
    public List<String> getAccountTypes(@PathParam(TENANT_ID) String tenantId) throws ServiceException;

    /**
     * Retrieve all account statuses
     *
     * @param tenantId tenantId
     * @return Available account statuses in the system
     */
    @Deprecated
    @GET
    @Path(STATUSES_PATH)
    @Produces(MediaType.APPLICATION_JSON)
    @PreAuthorize("hasPermission('Required', 'ReadAccounts')")
    public List<String> getAccountStatuses(@PathParam(TENANT_ID) String tenantId) throws ServiceException;

    /**
     * Create an account for a tenant
     *
     * @param tenantId created account's tenant
     * @param account  AccountCreate model to save
     * @return Created account, represented as an AccountDetail model
     * @deprecated use {@link AccountServiceInterfaceV1#createAccount(String, String, CreateAccountSummary)}
     */
    @Deprecated
    @POST
    @CreatedOnSuccess
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Validated(CreateAccountSummary.class)
    @PreAuthorize("hasPermission('Required', 'WriteAccounts')")
    public AccountDetail createAccount(@PathParam(TENANT_ID) String tenantId, CreateAccountSummary account)
          throws ServiceException;

    /**
     * Update the status of an existing account for a tenant
     *
     * @param tenantId      updated account's tenant
     * @param accountId     account to update
     * @param accountStatus account status string. One of PENDING, OPEN, CLOSED (see domain AccountStatus)
     * @deprecated use {@link AccountServiceInterfaceV1#updateAccountStatus(String, String, String, String)}
     */
    @Deprecated
    @PUT
    @Path(ACCOUNT_ID_PATH + ACCOUNT_STATUS_PATH)
    @OkOnEmpty
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @PreAuthorize("hasPermission('Required', 'WriteAccounts')")
    public void updateAccountStatus(@PathParam(TENANT_ID) String tenantId, @PathParam(ACCOUNT_ID) String accountId,
          @PathParam(ACCOUNT_STATUS) String accountStatus) throws ServiceException;

    /**
     * Update the AR settings on an existing company account
     *
     * @param tenantId
     * @param accountId
     * @param accountsReceivableSettings update AR settings for the company
     * @return summary view of the updated company account
     * @throws ServiceException
     * @deprecated use {@link AccountServiceInterfaceV1#updateAccountsReceivableSettings(String, String, String,
     * AccountsReceivableSettings)}
     */
    @Deprecated
    @PUT
    @Path(ACCOUNT_ID_PATH + ACCOUNTS_RECEIVABLE_SETTINGS_PATH)
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @PreAuthorize("hasPermission('Required', 'WriteAccounts')")
    public AccountSummary updateAccountsReceivableSettings(@PathParam(TENANT_ID) String tenantId,
          @PathParam(ACCOUNT_ID) String accountId, AccountsReceivableSettings accountsReceivableSettings)
          throws ServiceException;

    /**
     * Retrieve folios from an account
     *
     * @param tenantId  id of tenant where the account exists
     * @param accountId id of account to retrieve folios from
     * @return List of folios
     */
    @Deprecated
    @GET
    @Path(ACCOUNT_ID_PATH + FOLIO_PATH)
    @Produces(MediaType.APPLICATION_JSON)
    @PreAuthorize("hasPermission('Required', 'ReadAccounts')")
    public List<FolioDetail> getFolios(@PathParam(TENANT_ID) String tenantId, @PathParam(ACCOUNT_ID) String accountId,
          @QueryParam("") GetFoliosOptionalParameters optionalParameters) throws ServiceException;

    /**
     * Retrieves all of the Folios along with their balances for a given accountId
     *
     * @param tenantId  id of tenant for the account
     * @param accountId Id of Account to retrieve folios for
     * @return List of FolioBalance for the given Account
     */
    @Deprecated
    @GET
    @Path(ACCOUNT_ID_PATH + FOLIO_BALANCES_PATH)
    @Produces(MediaType.APPLICATION_JSON)
    @PreAuthorize("hasPermission('Required', 'ReadAccounts')")
    public List<FolioBalance> getFolioBalances(@PathParam(TENANT_ID) String tenantId,
          @PathParam(ACCOUNT_ID) String accountId) throws ServiceException;

    /**
     * Create a folio for an account
     *
     * @param tenantId  id of tenant for the account
     * @param accountId id of account to save a folio to
     * @param folio     folioId
     * @return Created folio
     */
    @Deprecated
    @POST
    @CreatedOnSuccess
    @Path(ACCOUNT_ID_PATH + FOLIO_PATH)
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Validated(FolioSummary.class)
    @PreAuthorize("hasPermission('Required', 'WriteAccounts')")
    public FolioSummary createFolio(@PathParam(TENANT_ID) String tenantId, @PathParam(ACCOUNT_ID) String accountId,
          FolioSummary folio) throws ServiceException;

    /**
     * Retrieve folio
     *
     * @param tenantId  id of tenant for the account
     * @param accountId accountId
     * @param folioId   folioId
     * @return Existing folio for an account
     */
    @Deprecated
    @GET
    @Path(ACCOUNT_ID_PATH + FOLIO_PATH + FOLIO_ID_PATH)
    @Produces(MediaType.APPLICATION_JSON)
    @PreAuthorize("hasPermission('Required', 'ReadAccounts')")
    public FolioDetail getFolio(@PathParam(TENANT_ID) String tenantId, @PathParam(ACCOUNT_ID) String accountId,
          @PathParam(FOLIO_ID) String folioId) throws ServiceException;

    /**
     * Update folio for an account
     *
     * @param tenantId  id of tenant where account exists
     * @param accountId id of account where folio exists
     * @param folioId   folio to update
     * @param folio     folio with updated fields
     * @return Updated folio
     */
    @Deprecated
    @PUT
    @Path(ACCOUNT_ID_PATH + FOLIO_PATH + FOLIO_ID_PATH)
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Validated(FolioSummary.class)
    @PreAuthorize("hasPermission('Required', 'WriteAccounts')")
    public FolioSummary updateFolio(@PathParam(TENANT_ID) String tenantId, @PathParam(ACCOUNT_ID) String accountId,
          @PathParam(FOLIO_ID) String folioId, FolioSummary folio) throws ServiceException;

    /**
     * Update folio for an account
     *
     * @param tenantId  id of tenant where account exists
     * @param accountId id of account where folio exists
     * @param folios    folio with updated fields
     * @return Updated folio
     */
    @Deprecated
    @PUT
    @Path(ACCOUNT_ID_PATH + FOLIO_PATH)
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Validated(FolioSummary.class)
    @PreAuthorize("hasPermission('Required', 'WriteAccounts')")
    public List<FolioSummary> updateFolios(@PathParam(TENANT_ID) String tenantId,
          @PathParam(ACCOUNT_ID) String accountId, List<FolioSummary> folios) throws ServiceException;

    /**
     * Delete a folio from an account
     *
     * @param tenantId  id of tenant where account exists
     * @param accountId id of folio where folio exists
     * @param folioId   folio to delete
     */
    @Deprecated
    @DELETE
    @Path(ACCOUNT_ID_PATH + FOLIO_PATH + FOLIO_ID_PATH)
    @Produces(MediaType.APPLICATION_JSON)
    @PreAuthorize("hasPermission('Required', 'WriteAccounts')")
    public void deleteFolio(@PathParam(TENANT_ID) String tenantId, @PathParam(ACCOUNT_ID) String accountId,
          @PathParam(FOLIO_ID) String folioId) throws ServiceException;

    /* Posting Rules */

    /**
     * Retrieve rules for an account
     *
     * @param tenantId  id of tenant where account exists
     * @param accountId id of account where rules exist
     * @return Existing posting rules
     */
    @Deprecated
    @GET
    @Path(ACCOUNT_ID_PATH + POSTING_RULES_PATH)
    @Produces(MediaType.APPLICATION_JSON)
    @PreAuthorize("hasPermission('Required', 'ReadAccounts')")
    public PostingRuleDetailView getPostingRules(@PathParam(TENANT_ID) String tenantId,
          @PathParam(ACCOUNT_ID) String accountId) throws ServiceException;

    /**
     * Create a rule for an account
     *
     * @param tenantId          id of tenant where account exists
     * @param accountId         id of account to save a rule to
     * @param postingRuleDetail rule to save
     * @return Created rule
     */
    @Deprecated
    @POST
    @CreatedOnSuccess
    @Path(ACCOUNT_ID_PATH + POSTING_RULES_PATH)
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Validated(PostingRuleDetail.class)
    @PreAuthorize("hasPermission('Required', 'WriteAccounts')")
    public PostingRuleDetail createPostingRule(@PathParam(TENANT_ID) String tenantId,
          @PathParam(ACCOUNT_ID) String accountId, PostingRuleDetail postingRuleDetail) throws ServiceException;

    /**
     * Retrieve a rule for an account
     *
     * @param tenantId      id of tenant where account exists
     * @param accountId     id of account where rule exists
     * @param postingRuleId rule to retrieve
     * @return Retrieved rule
     */
    @Deprecated
    @GET
    @Path(ACCOUNT_ID_PATH + POSTING_RULES_PATH + POSTING_RULE_ID_PATH)
    @Produces(MediaType.APPLICATION_JSON)
    @PreAuthorize("hasPermission('Required', 'ReadAccounts')")
    public PostingRuleDetail getPostingRule(@PathParam(TENANT_ID) String tenantId,
          @PathParam(ACCOUNT_ID) String accountId, @PathParam(POSTING_RULE_ID) String postingRuleId)
          throws ServiceException;

    /**
     * Update an existing rule for an account
     *
     * @param tenantId          id of tenant where account exists
     * @param accountId         id of account where rule exists
     * @param postingRuleId     rule to update
     * @param postingRuleDetail rule with updated fields
     * @return Updated rule
     */
    @Deprecated
    @PUT
    @Path(ACCOUNT_ID_PATH + POSTING_RULES_PATH + POSTING_RULE_ID_PATH)
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Validated(PostingRuleDetail.class)
    @PreAuthorize("hasPermission('Required', 'WriteAccounts')")
    public PostingRuleDetail updatePostingRule(@PathParam(TENANT_ID) String tenantId,
          @PathParam(ACCOUNT_ID) String accountId, @PathParam(POSTING_RULE_ID) String postingRuleId,
          PostingRuleDetail postingRuleDetail) throws ServiceException;

    /**
     * Update all PostingRules at once
     *
     * @param tenantId           id of tenant where account exists
     * @param accountId          id of account where rule exists
     * @param postingRuleDetails list of rules to update
     * @return list of updated rules
     */
    @Deprecated
    @PUT
    @Path(ACCOUNT_ID_PATH + POSTING_RULES_PATH)
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @PreAuthorize("hasPermission('Required', 'WriteAccounts')")
    public List<PostingRuleDetail> updatePostingRules(@PathParam(TENANT_ID) String tenantId,
          @PathParam(ACCOUNT_ID) String accountId, List<PostingRuleDetail> postingRuleDetails) throws ServiceException;

    /**
     * Delete a rule from an account
     *
     * @param tenantId      id of tenant where account exists
     * @param accountId     id of account to where rule exists
     * @param postingRuleId rule to delete
     */
    @Deprecated
    @DELETE
    @Path(ACCOUNT_ID_PATH + POSTING_RULES_PATH + POSTING_RULE_ID_PATH)
    @Produces(MediaType.APPLICATION_JSON)
    @PreAuthorize("hasPermission('Required', 'WriteAccounts')")
    public void deletePostingRule(@PathParam(TENANT_ID) String tenantId, @PathParam(ACCOUNT_ID) String accountId,
          @PathParam(POSTING_RULE_ID) String postingRuleId) throws ServiceException;

    /**
     * Posts a charge to an account
     *
     * @param accountId  the Account to post to
     * @param charge     the Charge to post
     * @param ignoreAuth When false, the credit card auth will be adjusted higher when the additional charges
     *                   exceeds the existing auth, which may result in an exception (400 error) if the auth
     *                   adjustment fails. When a cash payment method is used, an exception will be thrown
     *                   for charges that exceed the credit limit.
     *                   The auth will not be adjusted or the credit limit ignored when this flag is true.
     *                   Setting this value to true requires the ForceChargeAcceptance permission.
     * @return a LineItemView for Display purposes
     */
    @Deprecated
    @POST
    @Path(ACCOUNT_ID_PATH + CHARGES_PATH)
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Validated(Charge.class)
    @PreAuthorize("hasPermission('Required', 'WriteAccounts')")
    public List<LineItemView> postCharge(@PathParam(TENANT_ID) String tenantId, @PathParam(ACCOUNT_ID) String accountId,
          @QueryParam("ignoreAuth") boolean ignoreAuth, Charge charge) throws ServiceException;

    // This doesn't get exposed as an endpoint yet.
    // It exists on the interface because we are
    // auto-wiring this Interface instead of the implementation,
    // and RecurringCharges needs to call this.

    // Not sure why it's written this way where you will have a public method without any CXF annotations.
    // Someday, we should fix this: VCTRS-42410
    public List<LineItemView> postCharges(String tenantId, String accountId, boolean ignoreAuth, List<Charge> charges,
          Boolean isRecurring);

    /**
     * Posts a credit to an account
     *
     * @param accountId the Account to post to
     * @param credit    the Credit to post
     * @return a LineItemView for Display purposes
     */
    @Deprecated
    @POST
    @CreatedOnSuccess
    @Path(ACCOUNT_ID_PATH + CREDIT_PATH)
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Validated(Credit.class)
    @PreAuthorize("hasPermission('Required', 'AllowCredits')")
    public LineItemView postCredit(@PathParam(TENANT_ID) String tenantId, @PathParam(ACCOUNT_ID) String accountId,
          Credit credit) throws ServiceException;

    /**
     * Posts a payment to an account
     *
     * @param accountId the Account to post to
     * @param payment   Payment object containing payment information
     * @return a LineItemView for Display purposes
     */
    @Deprecated
    @POST
    @CreatedOnSuccess
    @Path(ACCOUNT_ID_PATH + PAYMENTS_PATH)
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Validated(Payment.class)
    @PreAuthorize("hasPermission('Required', 'WriteAccounts')")
    public List<LineItemView> postPayment(@PathParam(TENANT_ID) String tenantId,
          @PathParam(ACCOUNT_ID) String accountId, Payment payment,
          @DefaultValue("true") @QueryParam("reAuth") Boolean reAuth) throws ServiceException;

    /**
     * Refunds a payment to an account
     *
     * @param accountId the Account to post to
     * @param payment   Payment object containing the refund information (refunds are just negative payments)
     * @return a LineItemView for Display purposes
     */
    @Deprecated
    @POST
    @CreatedOnSuccess
    @Path(ACCOUNT_ID_PATH + REFUNDS_PATH)
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Validated(Payment.class)
    @PreAuthorize("hasPermission('Required', 'AllowRefunds')")
    public List<LineItemView> postRefunds(@PathParam(TENANT_ID) String tenantId,
          @PathParam(ACCOUNT_ID) String accountId, Payment payment) throws ServiceException;

    /**
     * Transfers folio line items from a source folio to a destination folio either on the same account or on a
     * different account
     *
     * @param accountId    the Account to transfer the line items to
     * @param transferInfo includes the destination folioId and the list of source folio line items to transfer
     * @return a List<LineItemView> containing all of the folio lines from the TRANSFER LedgerTransaction
     */
    @Deprecated
    @POST
    @Path(ACCOUNT_ID_PATH + TRANSFER_CHARGES_PATH)
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Validated(LineItemTransfer.class)
    @PreAuthorize("hasPermission('Required', 'WriteAccounts')")
    public List<LineItemView> transferFolioLines(@PathParam(TENANT_ID) String tenantId,
          @PathParam(ACCOUNT_ID) String accountId, LineItemTransfer transferInfo) throws ServiceException;

    @Deprecated
    @POST
    @Path(ACCOUNT_ID_PATH + TRANSFER_AMOUNT_PATH)
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Validated(AmountTransfer.class)
    @PreAuthorize("hasPermission('Required', 'WriteAccounts')")
    public List<LineItemView> transferAmountToAccount(@PathParam(TENANT_ID) String tenantId,
          @PathParam(ACCOUNT_ID) String accountId, AmountTransfer transferInfo) throws ServiceException;

    /**
     * Performs an adjustment on a give folio line item
     *
     * @param tenantId       id of tenant where account exists
     * @param accountId      id of the account the folio line item belongs to
     * @param adjustmentInfo adjustment data including the folio line item and the amount of the adjustment
     * @return {@link LineItemView} of the folio line item including the new adjustment
     */
    @Deprecated
    @POST
    @Path(ACCOUNT_ID_PATH + ADJUSTMENT_PATH)
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Validated(LineItemAdjustment.class)
    @PreAuthorize("hasPermission('Required', 'WriteAccounts')")
    public LineItemView adjustment(@PathParam(TENANT_ID) String tenantId, @PathParam(ACCOUNT_ID) String accountId,
          LineItemAdjustment adjustmentInfo) throws ServiceException;

    /**
     * Performs a correction on a given folio line item
     *
     * @param tenantId       id of tenant where account exists
     * @param accountId      id of the account the folio line item belongs to
     * @param correctionInfo correction data including the folio line item and the amount of the correction
     * @return {@link List<LineItemView>} of the folio line items including the new correction line items
     */
    @Deprecated
    @POST
    @Path(ACCOUNT_ID_PATH + CORRECTION_PATH)
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Validated(LineItemAdjustment.class)
    @PreAuthorize("hasPermission('Required', 'WriteAccounts')")
    public List<LineItemView> correction(@PathParam(TENANT_ID) String tenantId, @PathParam(ACCOUNT_ID) String accountId,
          LineItemAdjustment correctionInfo) throws ServiceException;

    /**
     * Performs a refund on a given line item on a folio
     *
     * @param tenantId      id of tenant where account exists
     * @param accountId     id of the account the folio line item belongs to
     * @param paymentRefund refund data including the folio line item and the amount of the refund
     * @return {@link LineItemView} of the folio line item including the new refund
     */
    @Deprecated
    @POST
    @CreatedOnSuccess
    @Path(ACCOUNT_ID_PATH + REFUND_PATH)
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Validated(PaymentRefund.class)
    @PreAuthorize("hasPermission('Required', 'AllowRefunds')")
    public LineItemView refundPayment(@PathParam(TENANT_ID) String tenantId, @PathParam(ACCOUNT_ID) String accountId,
          PaymentRefund paymentRefund) throws ServiceException;

    @Deprecated
    @POST
    @Path(ACCOUNT_ID_PATH + CHARGE_TAX_AMOUNT_PATH)
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Validated(ChargeTaxAmountRequest.class)
    @PreAuthorize("hasPermission('Required', 'ReadAccounts')")
    public ChargeTaxAmountInfo calculateChargeTaxAmount(@PathParam(TENANT_ID) String tenantId,
          @PathParam(ACCOUNT_ID) String accountId, ChargeTaxAmountRequest request) throws ServiceException;

    /* Payment Settings */

    /**
     * Retrieve payment settings for an account
     *
     * @param tenantId  id of tenant where account exists
     * @param accountId id of account where settings exist
     * @return Existing paymentSettings
     */
    @Deprecated
    @GET
    @Path(ACCOUNT_ID_PATH + PAYMENT_SETTINGS_PATH)
    @Produces(MediaType.APPLICATION_JSON)
    @PreAuthorize("hasPermission('Required', 'ReadAccounts')")
    public List<PaymentSetting> getPaymentSettings(@PathParam(TENANT_ID) String tenantId,
          @PathParam(ACCOUNT_ID) String accountId) throws ServiceException;

    /**
     * Save paymentSettings for an account
     *
     * @param tenantId        id of tenant where account exists
     * @param accountId       id of account to save settings to
     * @param paymentSettings list of payment settings to save
     * @return Created settings
     */
    @Deprecated
    @POST
    @CreatedOnSuccess
    @Path(ACCOUNT_ID_PATH + PAYMENT_SETTINGS_PATH)
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @PreAuthorize("hasPermission('Required', 'WriteAccounts')")
    public List<PaymentSetting> savePaymentSettings(@PathParam(TENANT_ID) String tenantId,
          @PathParam(ACCOUNT_ID) String accountId, List<PaymentSetting> paymentSettings);

    /**
     * Retrieve tax exempt settings for an account by individual dates.
     *
     * @param tenantId  id of tenant where account exists
     * @param accountId id of account where settings exist
     * @return Existing taxExemptSettings
     */
    @Deprecated
    @GET
    @Path(ACCOUNT_ID_PATH + TAXEXEMPT_SETTINGS_BYDATE_PATH)
    @Produces(MediaType.APPLICATION_JSON)
    @PreAuthorize("hasPermission('Required', 'ReadAccounts')")
    public TaxExemptSettingsByDate getTaxExemptSettingsByDate(@PathParam(TENANT_ID) String tenantId,
          @PathParam(ACCOUNT_ID) String accountId) throws ServiceException;

    /**
     * Save tax exempt settings for an account by individual dates.
     *
     * @param tenantId                id of tenant where account exists
     * @param accountId               id of account to save settings to
     * @param taxExemptSettingsByDate list of tax exempt settings to save
     * @return Created settings
     */
    @Deprecated
    @POST
    @CreatedOnSuccess
    @Path(ACCOUNT_ID_PATH + TAXEXEMPT_SETTINGS_BYDATE_PATH)
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Validated(TaxExemptSettingsByDate.class)
    @PreAuthorize("hasPermission('Required', 'WriteAccounts')")
    public TaxExemptSettingsByDate saveTaxExemptSettingsByDate(@PathParam(TENANT_ID) String tenantId,
          @PathParam(ACCOUNT_ID) String accountId, TaxExemptSettingsByDate taxExemptSettingsByDate);

    /**
     * Retrieve tax exempt settings for an account by a range of dates.
     *
     * @param tenantId  id of tenant where account exists
     * @param accountId id of account where settings exist
     * @return Existing taxExemptSettings
     */
    @Deprecated
    @GET
    @Path(ACCOUNT_ID_PATH + GROUP_COMPANY_TAXEXEMPT_SETTINGS_PATH)
    @Produces(MediaType.APPLICATION_JSON)
    @PreAuthorize("hasPermission('Required', 'ReadAccounts')")
    public GroupCompanyTaxExemptSettings getGroupCompanyTaxExemptSettings(@PathParam(TENANT_ID) String tenantId,
          @PathParam(ACCOUNT_ID) String accountId) throws ServiceException;

    /**
     * Save tax exempt settings for an account by a range of dates.
     *
     * @param tenantId                      id of tenant where account exists
     * @param accountId                     id of account to save settings to
     * @param groupCompanyTaxExemptSettings list of tax exempt settings to save
     * @return Created settings
     */
    @Deprecated
    @POST
    @Path(ACCOUNT_ID_PATH + GROUP_COMPANY_TAXEXEMPT_SETTINGS_PATH)
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Validated(GroupCompanyTaxExemptSettings.class)
    @PreAuthorize("hasPermission('Required', 'WriteAccounts')")
    public GroupCompanyTaxExemptSettings saveGroupCompanyTaxExemptSettings(@PathParam(TENANT_ID) String tenantId,
          @PathParam(ACCOUNT_ID) String accountId, GroupCompanyTaxExemptSettings groupCompanyTaxExemptSettings);

    /**
     * Search for accounts within a given tenant and property
     *
     * @param tenantId                 id of tenant to search on
     * @param searchTerm               string to match on
     * @param optionalSearchParamsPath optional parameters sent to search accounts. They are passed in in the path as
     *                                 key/value pairs; for
     *                                 available parameters:
     *                                 propertyIdFilter - property id to filter results on
     *                                 includeClosedAccounts - by default closed accounts will be filtered from the
     *                                 search results
     * @return A list of {@link AccountSearchResult}
     */
    @Deprecated
    @GET
    @Path(SEARCH_PATH + SEARCH_TERM_PATH + REMAINING_PATH)
    @Produces(MediaType.APPLICATION_JSON)
    @PreAuthorize("hasPermission('Required', 'ReadAccounts')")
    public List<AccountSearchResult> search(@PathParam(TENANT_ID) String tenantId,
          @PathParam(SEARCH_TERM) String searchTerm, @PathParam(PATH) String optionalSearchParamsPath)
          throws ServiceException;

    /**
     * Retrieve balances for a date
     *
     * @param tenantId           id of tenant
     * @param ledgerBalancesInfo property id and date
     * @return map of ledger name to ledger balance
     */
    @Deprecated
    @GET
    @Path(LEDGER_BALANCES_PATH)
    @Produces(MediaType.APPLICATION_JSON)
    @PreAuthorize("hasPermission('Required', 'ReadAccounts')")
    public Map<String, BigDecimal> getLedgerBalances(@PathParam(TENANT_ID) String tenantId,
          LedgerBalancesInfo ledgerBalancesInfo) throws ServiceException;

    /**
     * Determines if this account can checkout
     *
     * @param tenantId     tenantId
     * @param accountId    accountId
     * @param allowBalance allowBalance
     */
    @Deprecated
    @GET
    @Path(ACCOUNT_ID_PATH + VERIFY_CHECKOUT_PATH)
    @PreAuthorize("hasPermission('Required', 'ReadAccounts')")
    public void verifyCheckout(@PathParam(TENANT_ID) String tenantId, @PathParam(ACCOUNT_ID) String accountId,
          @QueryParam("allowBalance") boolean allowBalance);

    /**
     * Determines if this account can checkout
     *
     * @param tenantId  tenantId
     * @param accountId accountId
     */
    @GET
    @Path(ACCOUNT_ID_PATH + VERIFY_CHECKOUT_ALLOWED_PATH)
    @PreAuthorize("hasPermission('Required', 'ReadAccounts')")
    @Deprecated
    public void verifyCheckoutAllowed(@PathParam(TENANT_ID) String tenantId, @PathParam(ACCOUNT_ID) String accountId);

    /**
     * Attempts to pay off the balances of an account associated using the default payment setting id
     * for the account
     *
     * @param tenantId   tenantId
     * @param accountId  if of account to pay off
     * @param terminalId terminalId of origin, required if a credit card is to be used
     * @deprecated Use AccountServiceV1#payOffBalance instead
     */
    @Deprecated
    @POST
    @CreatedOnSuccess
    @Path(ACCOUNT_ID_PATH + PAYOFF_BALANCE_PATH)
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @PreAuthorize("hasPermission('Required', 'WriteAccounts')")
    public void payOffBalance(@PathParam(TENANT_ID) String tenantId, @PathParam(ACCOUNT_ID) String accountId,
          @QueryParam("terminalId") String terminalId) throws ServiceException;

    /**
     * Retrieves the non-invoiced details of a COMPANY account
     *
     * @param tenantId  id of tenant where the COMPANY account exists
     * @param accountId id of COMPANY account to retrieve non-invoiced details from
     * @return Non-invoiced details for a COMPANY account
     */
    @Deprecated
    @GET
    @Path(ACCOUNT_ID_PATH + NON_INVOICED_PATH)
    @Produces(MediaType.APPLICATION_JSON)
    @PreAuthorize("hasPermission('Required', 'ReadAccountsReceivable')")
    public NonInvoicedARDetail getNonInvoicedARDetail(@PathParam(TENANT_ID) String tenantId,
          @PathParam(ACCOUNT_ID) String accountId) throws ServiceException;

    /**
     * Create an invoice for an account
     *
     * @param tenantId  id of tenant for the account
     * @param accountId id of account to save an invoice to
     * @param invoice
     * @return Created invoice
     */
    @Deprecated
    @POST
    @CreatedOnSuccess
    @Path(ACCOUNT_ID_PATH + INVOICES_PATH)
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Validated(InvoiceRequest.class)
    @PreAuthorize("hasPermission('Required', 'WriteAccountsReceivable')")
    public InvoiceView createInvoice(@PathParam(TENANT_ID) String tenantId, @PathParam(ACCOUNT_ID) String accountId,
          InvoiceRequest invoice) throws ServiceException;

    /**
     * Retrieve an invoice by Id
     *
     * @param tenantId       id of the tenant for the account
     * @param accountId      id of account the invoice belongs to
     * @param invoiceId      id of the invoice to retrieve
     * @param optionalParams optional params for retrieving a previous version of the invoice
     * @return {@link InvoiceView}
     * @throws ServiceException
     */
    @Deprecated
    @GET
    @Path(ACCOUNT_ID_PATH + INVOICES_PATH + INVOICE_ID_PATH)
    @PreAuthorize("hasPermission('Required', 'ReadAccountsReceivable')")
    public InvoiceView getInvoiceById(@PathParam(TENANT_ID) String tenantId, @PathParam(ACCOUNT_ID) String accountId,
          @PathParam(INVOICE_ID) String invoiceId,
          @QueryParam("") @LogParam("optionalParams") InvoiceOptionalParams optionalParams) throws ServiceException;

    /**
     * Retrieves the invoices associated with an A/R account
     *
     * @param tenantId  id of the tenant for the account
     * @param accountId id of account the invoice belongs to
     * @param params    optional filtering params
     * @return List of {@link InvoiceView}
     * @throws ServiceException
     */
    @Deprecated
    @GET
    @Path(ACCOUNT_ID_PATH + INVOICES_PATH)
    @OkOnEmpty
    @PreAuthorize("hasPermission('Required', 'ReadAccountsReceivable')")
    public List<InvoiceView> findInvoices(@PathParam(TENANT_ID) String tenantId,
          @PathParam(ACCOUNT_ID) String accountId,
          @QueryParam("") @LogParam("params") InvoiceFilteringOptionalParams params) throws ServiceException;

    /**
     * Add line items to an invoice for an account
     *
     * @param tenantId  id of the tenant for the account
     * @param accountId id of account the invoice belongs to
     * @param invoiceId id of the invoice to add items to
     * @param lineItems lineItem ids to add to the invoice
     * @return Updated invoice
     * @throws ServiceException
     */
    @Deprecated
    @PUT
    @Path(ACCOUNT_ID_PATH + INVOICES_PATH + INVOICE_ID_PATH + INVOICE_ADD_ITEMS_PATH)
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Validated(UpdateInvoiceLineItemsRequest.class)
    @PreAuthorize("hasPermission('Required', 'WriteAccountsReceivable')")
    public InvoiceView addInvoiceLineItems(@PathParam(TENANT_ID) String tenantId,
          @PathParam(ACCOUNT_ID) String accountId, @PathParam(INVOICE_ID) String invoiceId,
          UpdateInvoiceLineItemsRequest lineItems) throws ServiceException;

    /**
     * Remove line items from an invoice for an account
     *
     * @param tenantId  id of the tenant for the account
     * @param accountId id of account the invoice belongs to
     * @param invoiceId id of the invoice to remove items from
     * @param lineItems lineItem ids to remove from the invoice
     * @return Updated invoice
     * @throws ServiceException
     */
    @Deprecated
    @PUT
    @Path(ACCOUNT_ID_PATH + INVOICES_PATH + INVOICE_ID_PATH + INVOICE_REMOVE_ITEMS_PATH)
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Validated(UpdateInvoiceLineItemsRequest.class)
    @PreAuthorize("hasPermission('Required', 'WriteAccountsReceivable')")
    public InvoiceView removeInvoiceLineItems(@PathParam(TENANT_ID) String tenantId,
          @PathParam(ACCOUNT_ID) String accountId, @PathParam(INVOICE_ID) String invoiceId,
          UpdateInvoiceLineItemsRequest lineItems) throws ServiceException;

    /**
     * Update terms on an invoice
     *
     * @param tenantId  tenantId
     * @param accountId accountId
     * @param invoiceId invoice to update
     * @param terms     new value for terms
     * @return Updated invoice
     * @throws ServiceException
     */
    @Deprecated
    @PUT
    @Path(ACCOUNT_ID_PATH + INVOICES_PATH + INVOICE_ID_PATH + INVOICE_UPDATE_TERMS_PATH)
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Validated(UpdateInvoiceTermsRequest.class)
    @PreAuthorize("hasPermission('Required', 'WriteAccountsReceivable')")
    public InvoiceView updateInvoiceTerms(@PathParam(TENANT_ID) String tenantId,
          @PathParam(ACCOUNT_ID) String accountId, @PathParam(INVOICE_ID) String invoiceId,
          UpdateInvoiceTermsRequest terms) throws ServiceException;

    /**
     * Mark invoice as sent by email or printed and sent by mail
     *
     * @param tenantId  id of the tenant for the account
     * @param accountId id of account the invoice belongs to
     * @param invoiceId id of the invoice to retrieve
     * @param isEmail   boolean if true then sent by Email if false then printed and sent by mail
     * @return Created invoice
     * @throws ServiceException
     */
    @Deprecated
    @PUT
    @Path(ACCOUNT_ID_PATH + INVOICES_PATH + INVOICE_ID_PATH + INVOICE_SET_INVOICE_SENT)
    @PreAuthorize("hasPermission('Required', 'WriteAccountsReceivable')")
    public InvoiceView setInvoiceSent(@PathParam(TENANT_ID) String tenantId, @PathParam(ACCOUNT_ID) String accountId,
          @PathParam(INVOICE_ID) String invoiceId, @QueryParam("isEmail") boolean isEmail) throws ServiceException;

    /**
     * Applies payments to one or more invoices
     *
     * @param accountId                  id of the A/R account to apply payments to
     * @param applyInvoicePaymentRequest details for how to apply the payments; including payment method, amounts, and
     *                                   which invoices
     * @return a list of {@link InvoiceView} including the payments applied
     */
    @Deprecated
    @POST
    @CreatedOnSuccess
    @Path(ACCOUNT_ID_PATH + INVOICES_PATH + APPLY_PAYMENTS)
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Validated(ApplyInvoicePaymentRequest.class)
    @PreAuthorize("hasPermission('Required', 'WriteAccountsReceivable')")
    public List<InvoiceView> applyInvoicePayments(@PathParam(TENANT_ID) String tenantId,
          @PathParam(ACCOUNT_ID) String accountId, ApplyInvoicePaymentRequest applyInvoicePaymentRequest)
          throws ServiceException;

    /**
     * Performs a refund against a given invoice payment item
     *
     * @param tenantId             id of tenant where account exists
     * @param accountId            id of the account the folio line item belongs to
     * @param invoiceId            id of the invoice
     * @param invoicePaymentRefund refund data including the invoicePaymentId and the amount of the refund
     * @return {@link InvoiceView} of the updated invoice
     */
    @Deprecated
    @POST
    @CreatedOnSuccess
    @Path(ACCOUNT_ID_PATH + INVOICES_PATH + INVOICE_ID_PATH + REFUND_PATH)
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Validated(InvoicePaymentRefund.class)
    @PreAuthorize("hasPermission('Required', 'AllowRefunds')")
    public InvoiceView refundInvoicePayment(@PathParam(TENANT_ID) String tenantId,
          @PathParam(ACCOUNT_ID) String accountId, @PathParam(INVOICE_ID) String invoiceId,
          InvoicePaymentRefund invoicePaymentRefund) throws ServiceException;

    /**
     * Fetches the next unused AR account number from the database
     *
     * @param tenantId
     * @return the next AR account number
     * @throws ServiceException
     */
    @Deprecated
    @GET
    @Path(NEXT_ACCOUNT_NUMBER_PATH)
    @Produces(MediaType.APPLICATION_JSON)
    @PreAuthorize("hasPermission('Required', 'ReadAccounts')")
    NextAccountNumberInfo getNextArAccountNumber(@PathParam(TENANT_ID) String tenantId) throws ServiceException;

    /**
     * modifies existing data and/or creates new data to migrate existing
     * company accounts information to AR
     *
     * @throws ServiceException
     */
    @POST
    @Path(MIGRATE_ACCOUNTS_RECEIVABLE)
    @PreAuthorize("hasPermission('Required', 'WriteAccountsReceivable')")
    public void migrateAccountsReceivable() throws ServiceException;

    /**
     * authorizes any additional credit cards associated with an
     * account based on estimated charges and existing auth amounts
     *
     * @throws ServiceException
     */
    @Deprecated
    @POST
    @Path(ACCOUNT_ID_PATH + AUTH_CARDS_ON_ACCOUNT_PATH)
    @Produces(MediaType.APPLICATION_JSON)
    @PreAuthorize("hasPermission('Required', 'WriteAccounts')")
    public List<PaymentInstrumentAuthStatus> authAllCardsOnAccount(@PathParam(TENANT_ID) String tenantId,
          @PathParam(ACCOUNT_ID) String accountId, @QueryParam(START_DATE) LocalDate startDate,
          @QueryParam(END_DATE) LocalDate endDate) throws ServiceException;

    @Deprecated
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path(FILTERED)
    public CollectionResponse<AccountSummary> findAccounts(
          @ApiParam(value = "tenant id", required = true) @PathParam(TENANT_ID) @LogParam("tenantId") String tenantId,
          @ApiParam(value = "collection request", required = false) @LogParam("params")
          AccountsCollectionRequest collectionRequest) throws ServiceException;
}
