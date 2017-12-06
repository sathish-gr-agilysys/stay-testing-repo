/*
 *
 *  *  (C) 2015 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 *
 */
package com.agilysys.pms.account.api;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;

import com.agilysys.common.model.PaymentSetting;
import com.agilysys.platform.common.exception.ServiceException;
import com.agilysys.platform.common.rguest.exception.RGuestException;
import com.agilysys.platform.schema.Validated;
import com.agilysys.pms.account.api.params.InvoiceFilteringOptionalParams;
import com.agilysys.pms.account.api.params.InvoiceOptionalParams;
import com.agilysys.pms.account.model.AccountClosableInfo;
import com.agilysys.pms.account.model.AccountDetail;
import com.agilysys.pms.account.model.AccountSearchResult;
import com.agilysys.pms.account.model.AccountStatementResponse;
import com.agilysys.pms.account.model.AccountStatementsRequest;
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
import com.agilysys.pms.account.model.FolioViewLineItem;
import com.agilysys.pms.account.model.GetFoliosOptionalParameters;
import com.agilysys.pms.account.model.GroupCompanyTaxExemptSettings;
import com.agilysys.pms.account.model.InvoicePaymentRefund;
import com.agilysys.pms.account.model.InvoiceReportProgressView;
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
import com.agilysys.pms.account.model.PayoffBalanceRequest;
import com.agilysys.pms.account.model.PostChargesRequest;
import com.agilysys.pms.account.model.PostChargesResponse;
import com.agilysys.pms.account.model.PostingRuleDetail;
import com.agilysys.pms.account.model.PostingRuleDetailView;
import com.agilysys.pms.account.model.TaxExemptSettingsByDate;
import com.agilysys.pms.account.model.UpdateInvoiceLineItemsRequest;
import com.agilysys.pms.account.model.UpdateInvoiceTermsRequest;
import com.agilysys.pms.account.model.ViewFolioRequest;
import com.agilysys.pms.account.model.tmp.fixup.LedgerBalanceFixup;
import com.agilysys.pms.common.api.annotation.CreatedOnSuccess;
import com.agilysys.pms.common.api.annotation.OkOnEmpty;
import com.agilysys.pms.common.model.CollectionResponse;
import com.wordnik.swagger.annotations.ApiParam;

@Path(AccountServiceInterfaceV1.BASE_PATH)
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface AccountServiceInterfaceV1 {
    String TENANT_ID = "tenantId";
    String PROPERTY_ID = "propertyId";
    String BASE_PATH = "/v1/tenants/{" + TENANT_ID + "}/properties/{" + PROPERTY_ID + "}/accounts";
    String TYPES_PATH = "types";
    String STATUSES_PATH = "statuses";
    String ACCOUNT_ID = "accountId";
    String GROUPED = "grouped";
    String ACCOUNT_ID_PATH = "/{" + ACCOUNT_ID + "}";
    String REFERENCE_ID = "referenceId";
    String REFERENCE_ID_PATH = "/reference/{" + REFERENCE_ID + "}";
    String ACCOUNT_STATUS = "accountStatus";
    String ACCOUNT_STATUS_PATH = "/status/{" + ACCOUNT_STATUS + "}";
    String ACCOUNTS_RECEIVABLE_SETTINGS_PATH = "/accountsReceivableSettings";
    String ACCOUNT_BALANCES_PATH = "/balances";
    String CLOSABLE_INFO = "/closableInfo";
    String PAYOFF_BALANCE_PATH = "/payOffBalance";
    String FOLIO_PATH = "/folios";
    String BATCH_FOLIO_PATH = "/batchFolios";
    String FOLIO_ID = "folioId";
    String FOLIO_BALANCES_PATH = "/folioBalances";
    String FOLIO_ID_PATH = "/{" + FOLIO_ID + "}";
    String POSTING_RULES_PATH = "/postingRules";
    String POSTING_RULE_ID = "postingRulesId";
    String POSTING_RULE_ID_PATH = "/{" + POSTING_RULE_ID + "}";
    String CHARGES_PATH = "/charges";
    String BATCH_CHARGES_PATH = "/batchCharges";
    String CREDIT_PATH = "/credit";
    String PAYMENTS_PATH = "/payments";
    String REFUNDS_PATH = "/refunds"; //Used for generic refunds
    String REFUND_PATH = "/refund"; //Used for a refund of a specific line item
    String TRANSFER_FOLIO_LINES = "/transferFolioLines";
    String TRANSFER_AMOUNT_PATH = "/transferAmount";
    String ADJUSTMENT_PATH = "/adjustment";
    String CORRECTION_PATH = "/correction";
    String CHARGE_TAX_AMOUNT_PATH = "/calculateChargeTaxAmount";
    String PAYMENT_SETTINGS_PATH = "/paymentSettings";
    String TAXEXEMPT_SETTINGS_BYDATE_PATH = "/taxExemptSettingsByDate";
    String GROUP_COMPANY_TAXEXEMPT_SETTINGS_PATH = "/groupCompanyTaxExemptSettings";
    String PRESET =  "preset";
    String PRESET_PATH = "/presetValue/{" + PRESET + "}";
    String SEARCH_PATH = "/search";
    String SEARCH_TERM = "searchTerm";
    String SEARCH_TERM_PATH = "/{" + SEARCH_TERM + "}";
    String PATH = "path";
    String REMAINING_PATH = "/{" + PATH + ":.*}";
    String LEDGER_BALANCES_PATH = "/ledgerBalances";
    String VERIFY_CHECKOUT_PATH = "/verifyCheckout";
    String INVOICE_ID = "invoiceId";
    String INVOICE_ID_PATH = "/{" + INVOICE_ID + "}";
    String INVOICES_PATH = "/invoices";
    String INVOICE_REPORT_START = "/invoice-report-start";
    String INVOICE_REPORT_POLL = "/invoice-report-poll";
    String INVOICE_ADD_ITEMS_PATH = "/addItems";
    String INVOICE_UPDATE_TERMS_PATH = "/updateTerms";
    String INVOICE_REMOVE_ITEMS_PATH = "/removeItems";
    String INVOICE_SET_INVOICE_SENT = "/setInvoiceSent";
    String APPLY_PAYMENTS = "/applyPayments";
    String NON_INVOICED_PATH = "/nonInvoicedDetails";
    String NEXT_ACCOUNT_NUMBER_PATH = "/nextAccountNumber";
    String ACCOUNT_NUMBER = "accountNumber";
    String CHECK_ACCOUNT_NUMBER_AVAILABILITY_PATH = "/checkAccountNumberAvailability/{" + ACCOUNT_NUMBER + "}";
    String AUTH_CARDS_ON_ACCOUNT_PATH = "/authCardsOnAccount";
    String FILTERED = "/filtered";
    String START_DATE = "startDate";
    String END_DATE = "endDate";
    String FIX_LEDGER_BALANCES_PATH = "/fixLedgerBalances";

    /**
     * Retrieve all accounts from a tenant
     *
     * @param tenantId        id of tenant where accounts exist
     * @param propertyId      id of the property where accounts exist
     * @param accountTypes    types (comma separated) of account to filter by (optional)
     * @param accountStatuses statuses (comma separated) of account to filter by (optional)
     * @return Existing accounts for the tenant and property
     * @deprecated use {@link AccountServiceInterfaceV1#getAccounts(String, String, String, String)}
     */
    @GET
    @PreAuthorize("hasPermission('Required', 'ReadAccounts')")
    List<AccountSummary> getAccounts(@PathParam(TENANT_ID) String tenantId, @PathParam(PROPERTY_ID) String propertyId,
          @QueryParam("accountType") String accountTypes, @QueryParam("accountStatus") String accountStatuses)
          throws RGuestException, ServiceException;

    /**
     * Retrieve an account by reference id
     *
     * @param tenantId    id of tenant where the account exists
     * @param propertyId  id of the property where the account exists
     * @param referenceId reference id of the account to retrieve
     * @return an account for the tenant and referenceId
     */
    @GET
    @Path(REFERENCE_ID_PATH)
    @PreAuthorize("hasPermission('Required', 'ReadAccounts')")
    AccountSummary getAccountByReferenceId(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @PathParam(REFERENCE_ID) String referenceId)
          throws RGuestException, ServiceException;

    /**
     * Retrieve an account
     *
     * @param tenantId   id of tenant where the account exists
     * @param propertyId id of the property where the account exists
     * @param accountId  account to retrieve
     * @return Existing account for the tenant
     */
    @GET
    @Path(ACCOUNT_ID_PATH)
    @PreAuthorize("hasPermission('Required', 'ReadAccounts')")
    AccountSummary getAccount(@PathParam(TENANT_ID) String tenantId, @PathParam(PROPERTY_ID) String propertyId,
          @PathParam(ACCOUNT_ID) String accountId) throws RGuestException, ServiceException;

    /**
     * Retrieve all account types
     *
     * @param tenantId   tenantId
     * @param propertyId propertyId
     * @return Available account types in the system
     */
    @GET
    @Path(TYPES_PATH)
    @PreAuthorize("hasPermission('Required', 'ReadAccounts')")
    List<String> getAccountTypes(@PathParam(TENANT_ID) String tenantId, @PathParam(PROPERTY_ID) String propertyId)
          throws RGuestException, ServiceException;

    /**
     * Retrieve all account statuses
     *
     * @param tenantId   tenantId
     * @param propertyId propertyId
     * @return Available account statuses in the system
     */
    @GET
    @Path(STATUSES_PATH)
    @PreAuthorize("hasPermission('Required', 'ReadAccounts')")
    List<String> getAccountStatuses(@PathParam(TENANT_ID) String tenantId, @PathParam(PROPERTY_ID) String propertyId)
          throws RGuestException, ServiceException;

    /**
     * Retrieve account details
     *
     * @param tenantId   id of tenant where the account exists
     * @param propertyId id of the property where the account exists
     * @param accountId  account to retrieve
     * @return Existing account details for the tenant
     */
    @GET
    @Path(ACCOUNT_ID_PATH + "/details")
    @PreAuthorize("hasPermission('Required', 'ReadAccounts')")
    AccountDetail getAccountDetails(@PathParam(TENANT_ID) String tenantId, @PathParam(PROPERTY_ID) String propertyId,
          @PathParam(ACCOUNT_ID) String accountId) throws RGuestException, ServiceException;

    /**
     * Create an account for a tenant & property
     *
     * @param tenantId   created account's tenant
     * @param propertyId created account's property
     * @param account    AccountCreate model to save
     * @return Created account, represented as an AccountDetail model
     */
    @POST
    @CreatedOnSuccess
    @Validated(CreateAccountSummary.class)
    @PreAuthorize("hasPermission('Required', 'WriteAccounts')")
    AccountDetail createAccount(@PathParam(TENANT_ID) String tenantId, @PathParam(PROPERTY_ID) String propertyId,
          CreateAccountSummary account) throws RGuestException, ServiceException;

    /**
     * Update the status of an existing account for a tenant
     *
     * @param tenantId      updated account's tenant
     * @param propertyId    id of the property where the account exists
     * @param accountId     account to update
     * @param accountStatus account status string. One of PENDING, OPEN, CLOSED (see domain AccountStatus)
     */
    @PUT
    @Path(ACCOUNT_ID_PATH + ACCOUNT_STATUS_PATH)
    @OkOnEmpty
    @PreAuthorize("hasPermission('Required', 'WriteAccounts')")
    void updateAccountStatus(@PathParam(TENANT_ID) String tenantId, @PathParam(PROPERTY_ID) String propertyId,
          @PathParam(ACCOUNT_ID) String accountId, @PathParam(ACCOUNT_STATUS) String accountStatus)
          throws RGuestException, ServiceException;

    /**
     * Update the AR settings on an existing company account
     *
     * @param tenantId
     * @param propertyId
     * @param accountId
     * @param accountsReceivableSettings update AR settings for the company
     * @return summary view of the updated company account
     * @throws ServiceException
     */
    @PUT
    @Path(ACCOUNT_ID_PATH + ACCOUNTS_RECEIVABLE_SETTINGS_PATH)
    @PreAuthorize("hasPermission('Required', 'WriteAccounts')")
    AccountSummary updateAccountsReceivableSettings(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @PathParam(ACCOUNT_ID) String accountId,
          AccountsReceivableSettings accountsReceivableSettings) throws RGuestException, ServiceException;

    @POST
    @Path(ACCOUNT_BALANCES_PATH)
    @PreAuthorize("hasPermission('Required', 'ReadAccounts')")
    AccountStatementResponse getAccountBalances(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, AccountStatementsRequest accountStatementsRequest)
          throws RGuestException, ServiceException;

    /**
     * Retrieve folios from an account
     *
     * @param tenantId   id of tenant where the account exists
     * @param propertyId id of the property where the account exists
     * @param accountId  id of account to retrieve folios from
     * @return List of folios
     */
    @GET
    @Path(ACCOUNT_ID_PATH + FOLIO_PATH)
    @PreAuthorize("hasPermission('Required', 'ReadAccounts')")
    List<FolioDetail> getFolios(@PathParam(TENANT_ID) String tenantId, @PathParam(PROPERTY_ID) String propertyId,
          @PathParam(ACCOUNT_ID) String accountId, @QueryParam("") GetFoliosOptionalParameters optionalParameters)
          throws RGuestException, ServiceException;

    /**
     * Retrieve folios for all Accounts
     *
     * @param tenantId   id of tenant where the account exists
     * @param propertyId id of the property where the account exists
     * @param accountIds  ids of accounts to retrieve folios from
     * @return Map of accountid - List of folios
     */
    @POST
    @Path(FOLIO_PATH)
    @PreAuthorize("hasPermission('Required', 'ReadAccounts')")
    Map<String, List<FolioDetail>> getFoliosForAccounts(@PathParam(TENANT_ID) String tenantId, @PathParam(PROPERTY_ID) String propertyId,
          Set<String> accountIds)
          throws RGuestException, ServiceException;

    @POST
    @Path(ACCOUNT_ID_PATH + FOLIO_PATH + FOLIO_ID_PATH)
    @PreAuthorize("hasPermission('Required', 'ReadAccounts')")
    @Validated(ViewFolioRequest.class)
    Page<FolioViewLineItem> viewFolio(@PathParam(TENANT_ID) String tenantId, @PathParam(PROPERTY_ID) String propertyId,
          @PathParam(ACCOUNT_ID) String accountId, @PathParam(FOLIO_ID) String folioId,
          ViewFolioRequest viewfoliosRequest) throws RGuestException, ServiceException;

    /**
     * Retrieves all of the Folios along with their balances for a given accountId
     *
     * @param tenantId   id of tenant for the account
     * @param propertyId id of the property where the account exists
     * @param accountId  Id of Account to retrieve folios for
     * @return List of FolioBalance for the given Account
     */
    @GET
    @Path(ACCOUNT_ID_PATH + FOLIO_BALANCES_PATH)
    @PreAuthorize("hasPermission('Required', 'ReadAccounts')")
    List<FolioBalance> getFolioBalances(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @PathParam(ACCOUNT_ID) String accountId)
          throws RGuestException, ServiceException;

    /**
     * Create a folio for an account
     *
     * @param tenantId   id of tenant for the account
     * @param propertyId id of the property where the account exists
     * @param accountId  id of account to save a folio to
     * @param folio      folioId
     * @return Created folio
     */
    @POST
    @CreatedOnSuccess
    @Path(ACCOUNT_ID_PATH + FOLIO_PATH)
    @Validated(FolioSummary.class)
    @PreAuthorize("hasPermission('Required', 'WriteAccounts')")
    FolioSummary createFolio(@PathParam(TENANT_ID) String tenantId, @PathParam(PROPERTY_ID) String propertyId,
          @PathParam(ACCOUNT_ID) String accountId, FolioSummary folio) throws RGuestException, ServiceException;

    /**
     * Create folios for an account
     *
     * @param tenantId   id of tenant for the account
     * @param propertyId id of the property where the account exists
     * @param accountId  id of account to save a folio to
     * @param folios     folios
     * @return Created folios
     */
    @POST
    @CreatedOnSuccess
    @Path(ACCOUNT_ID_PATH + BATCH_FOLIO_PATH)
    @PreAuthorize("hasPermission('Required', 'WriteAccounts')")
    List<FolioSummary> createFolios(@PathParam(TENANT_ID) String tenantId, @PathParam(PROPERTY_ID) String propertyId,
          @PathParam(ACCOUNT_ID) String accountId, List<FolioSummary> folios) throws RGuestException, ServiceException;

    /**
     * Retrieve folio
     *
     * @param tenantId   id of tenant for the account
     * @param propertyId id of the property where the account exists
     * @param accountId  accountId
     * @param folioId    folioId
     * @return Existing folio for an account
     */
    @GET
    @Path(ACCOUNT_ID_PATH + FOLIO_PATH + FOLIO_ID_PATH)
    @Produces(MediaType.APPLICATION_JSON)
    @PreAuthorize("hasPermission('Required', 'ReadAccounts')")
    FolioDetail getFolio(@PathParam(TENANT_ID) String tenantId, @PathParam(PROPERTY_ID) String propertyId,
          @PathParam(ACCOUNT_ID) String accountId, @PathParam(FOLIO_ID) String folioId)
          throws RGuestException, ServiceException;

    /**
     * Update folio for an account
     *
     * @param tenantId   id of tenant where account exists
     * @param propertyId id of the property where the account exists
     * @param accountId  id of account where folio exists
     * @param folioId    folio to update
     * @param folio      folio with updated fields
     * @return Updated folio
     */
    @PUT
    @Path(ACCOUNT_ID_PATH + FOLIO_PATH + FOLIO_ID_PATH)
    @Validated(FolioSummary.class)
    @PreAuthorize("hasPermission('Required', 'WriteAccounts')")
    FolioSummary updateFolio(@PathParam(TENANT_ID) String tenantId, @PathParam(PROPERTY_ID) String propertyId,
          @PathParam(ACCOUNT_ID) String accountId, @PathParam(FOLIO_ID) String folioId, FolioSummary folio)
          throws RGuestException, ServiceException;

    /**
     * Update folio for an account
     *
     * @param tenantId   id of tenant where account exists
     * @param propertyId id of the property where the account exists
     * @param accountId  id of account where folio exists
     * @param folios     folio with updated fields
     * @return Updated folio
     */
    @PUT
    @Path(ACCOUNT_ID_PATH + FOLIO_PATH)
    // @Validated(FolioSummary.class) - Due to platform bug: PLAT-6718
    @PreAuthorize("hasPermission('Required', 'WriteAccounts')")
    List<FolioSummary> updateFolios(@PathParam(TENANT_ID) String tenantId, @PathParam(PROPERTY_ID) String propertyId,
          @PathParam(ACCOUNT_ID) String accountId, List<FolioSummary> folios) throws RGuestException, ServiceException;

    /**
     * Delete a folio from an account
     *
     * @param tenantId   id of tenant where account exists
     * @param propertyId id of the property where the account exists
     * @param accountId  id of folio where folio exists
     * @param folioId    folio to delete
     */
    @DELETE
    @Path(ACCOUNT_ID_PATH + FOLIO_PATH + FOLIO_ID_PATH)
    @PreAuthorize("hasPermission('Required', 'WriteAccounts')")
    void deleteFolio(@PathParam(TENANT_ID) String tenantId, @PathParam(PROPERTY_ID) String propertyId,
          @PathParam(ACCOUNT_ID) String accountId, @PathParam(FOLIO_ID) String folioId)
          throws RGuestException, ServiceException;

    /* Posting Rules */

    /**
     * Retrieve rules for an account
     *
     * @param tenantId   id of tenant where account exists
     * @param propertyId id of the property where the account exists
     * @param accountId  id of account where rules exist
     * @return Existing posting rules
     */
    @GET
    @Path(ACCOUNT_ID_PATH + POSTING_RULES_PATH)
    @PreAuthorize("hasPermission('Required', 'ReadAccounts')")
    PostingRuleDetailView getPostingRules(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @PathParam(ACCOUNT_ID) String accountId)
          throws RGuestException, ServiceException;

    /**
     * Create a rule for an account
     *
     * @param tenantId          id of tenant where account exists
     * @param propertyId        id of the property where the account exists
     * @param accountId         id of account to save a rule to
     * @param postingRuleDetail rule to save
     * @return Created rule
     */
    @POST
    @CreatedOnSuccess
    @Path(ACCOUNT_ID_PATH + POSTING_RULES_PATH)
    @Validated(PostingRuleDetail.class)
    @PreAuthorize("hasPermission('Required', 'WriteAccounts')")
    PostingRuleDetail createPostingRule(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @PathParam(ACCOUNT_ID) String accountId,
          PostingRuleDetail postingRuleDetail) throws RGuestException, ServiceException;

    /**
     * Retrieve a rule for an account
     *
     * @param tenantId      id of tenant where account exists
     * @param propertyId    id of the property where the account exists
     * @param accountId     id of account where rule exists
     * @param postingRuleId rule to retrieve
     * @return Retrieved rule
     */
    @GET
    @Path(ACCOUNT_ID_PATH + POSTING_RULES_PATH + POSTING_RULE_ID_PATH)
    @PreAuthorize("hasPermission('Required', 'ReadAccounts')")
    PostingRuleDetail getPostingRule(@PathParam(TENANT_ID) String tenantId, @PathParam(PROPERTY_ID) String propertyId,
          @PathParam(ACCOUNT_ID) String accountId, @PathParam(POSTING_RULE_ID) String postingRuleId)
          throws RGuestException, ServiceException;

    /**
     * Update an existing rule for an account
     *
     * @param tenantId          id of tenant where account exists
     * @param propertyId        id of the property where the account exists
     * @param accountId         id of account where rule exists
     * @param postingRuleId     rule to update
     * @param postingRuleDetail rule with updated fields
     * @return Updated rule
     */
    @PUT
    @Path(ACCOUNT_ID_PATH + POSTING_RULES_PATH + POSTING_RULE_ID_PATH)
    @Validated(PostingRuleDetail.class)
    @PreAuthorize("hasPermission('Required', 'WriteAccounts')")
    PostingRuleDetail updatePostingRule(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @PathParam(ACCOUNT_ID) String accountId,
          @PathParam(POSTING_RULE_ID) String postingRuleId, PostingRuleDetail postingRuleDetail)
          throws RGuestException, ServiceException;

    /**
     * Update all PostingRules at once
     *
     * @param tenantId           id of tenant where account exists
     * @param propertyId         id of the property where the account exists
     * @param accountId          id of account where rule exists
     * @param postingRuleDetails list of rules to update
     * @return list of updated rules
     */
    @PUT
    @Path(ACCOUNT_ID_PATH + POSTING_RULES_PATH)
    @PreAuthorize("hasPermission('Required', 'WriteAccounts')")
    List<PostingRuleDetail> updatePostingRules(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @PathParam(ACCOUNT_ID) String accountId,
          List<PostingRuleDetail> postingRuleDetails) throws RGuestException, ServiceException;

    /**
     * Delete a rule from an account
     *
     * @param tenantId      id of tenant where account exists
     * @param propertyId    id of the property where the account exists
     * @param accountId     id of account to where rule exists
     * @param postingRuleId rule to delete
     */
    @DELETE
    @Path(ACCOUNT_ID_PATH + POSTING_RULES_PATH + POSTING_RULE_ID_PATH)
    @PreAuthorize("hasPermission('Required', 'WriteAccounts')")
    void deletePostingRule(@PathParam(TENANT_ID) String tenantId, @PathParam(PROPERTY_ID) String propertyId,
          @PathParam(ACCOUNT_ID) String accountId, @PathParam(POSTING_RULE_ID) String postingRuleId)
          throws RGuestException, ServiceException;

    /* Charges, Credits, Refunds */

    /**
     * Posts a charge to an account
     *
     * @param accountId  the Account to post to
     * @param propertyId id of the property where the account exists
     * @param charge     the Charge to post
     * @param ignoreAuth When false, the credit card auth will be adjusted higher when the additional charges
     *                   exceeds the existing auth, which may result in an exception (400 error) if the auth
     *                   adjustment fails. When a cash payment method is used, an exception will be thrown
     *                   for charges that exceed the credit limit.
     *                   The auth will not be adjusted or the credit limit ignored when this flag is true.
     *                   Setting this value to true requires the ForceChargeAcceptance permission.
     * @return a LineItemView for Display purposes
     */
    @POST
    @Path(ACCOUNT_ID_PATH + CHARGES_PATH)
    @Validated(Charge.class)
    @PreAuthorize("hasPermission('Required', 'WriteAccounts')")
    List<LineItemView> postCharge(@PathParam(TENANT_ID) String tenantId, @PathParam(PROPERTY_ID) String propertyId,
          @PathParam(ACCOUNT_ID) String accountId, @QueryParam("ignoreAuth") boolean ignoreAuth, Charge charge)
          throws RGuestException, ServiceException;

    /**
     * Posts charges to an account
     *
     * @param accountId  the Account to post to
     * @param propertyId id of the property where the account exists
     * @param charges    the Charges to post
     * @param ignoreAuth When false, the credit card auth will be adjusted higher when the additional charges
     *                   exceeds the existing auth, which may result in an exception (400 error) if the auth
     *                   adjustment fails. When a cash payment method is used, an exception will be thrown
     *                   for charges that exceed the credit limit.
     *                   The auth will not be adjusted or the credit limit ignored when this flag is true.
     *                   Setting this value to true requires the ForceChargeAcceptance permission.
     * @return LineItemViews
     */
    @POST
    @Path(ACCOUNT_ID_PATH + BATCH_CHARGES_PATH)
    @PreAuthorize("hasPermission('Required', 'WriteAccounts')")
    PostChargesResponse postCharges(@PathParam(TENANT_ID) String tenantId, @PathParam(PROPERTY_ID) String propertyId,
          @PathParam(ACCOUNT_ID) String accountId, @QueryParam("ignoreAuth") boolean ignoreAuth,
          @QueryParam(GROUPED) boolean grouped, PostChargesRequest charges) throws RGuestException, ServiceException;

    // This doesn't get exposed as an endpoint yet.
    // It exists on the interface because we are
    // auto-wiring this Interface instead of the implementation,
    // and RecurringCharges needs to call this.

    // Not sure why it's written this way where you will have a public method without any CXF annotations.
    // Someday, we should fix this: VCTRS-42410
    List<LineItemView> postCharges(String tenantId, String propertyId, String accountId, boolean ignoreAuth,
          List<Charge> charges, Boolean isRecurring) throws RGuestException, ServiceException;

    ;

    /**
     * Posts a credit to an account
     *
     * @param accountId  the Account to post to
     * @param propertyId id of the property where the account exists
     * @param credit     the Credit to post
     * @return a LineItemView for Display purposes
     */
    @POST
    @CreatedOnSuccess
    @Path(ACCOUNT_ID_PATH + CREDIT_PATH)
    @Validated(Credit.class)
    @PreAuthorize("hasPermission('Required', 'AllowCredits')")
    LineItemView postCredit(@PathParam(TENANT_ID) String tenantId, @PathParam(PROPERTY_ID) String propertyId,
          @PathParam(ACCOUNT_ID) String accountId, Credit credit) throws RGuestException, ServiceException;

    /**
     * Posts a payment to an account
     *
     * @param accountId  the Account to post to
     * @param propertyId id of the property where the account exists
     * @param payment    Payment object containing payment information
     * @return a LineItemView for Display purposes
     */
    @POST
    @CreatedOnSuccess
    @Path(ACCOUNT_ID_PATH + PAYMENTS_PATH)
    @Validated(Payment.class)
    @PreAuthorize("hasPermission('Required', 'WriteAccounts')")
    List<LineItemView> postPayment(@PathParam(TENANT_ID) String tenantId, @PathParam(PROPERTY_ID) String propertyId,
          @PathParam(ACCOUNT_ID) String accountId, Payment payment,
          @DefaultValue("true") @QueryParam("reAuth") Boolean reAuth) throws RGuestException, ServiceException;

    /**
     * Refunds a payment to an account
     *
     * @param accountId  the Account to post to
     * @param propertyId id of the property where the account exists
     * @param payment    Payment object containing the refund information (refunds are just negative payments)
     * @return a LineItemView for Display purposes
     */
    @POST
    @CreatedOnSuccess
    @Path(ACCOUNT_ID_PATH + REFUNDS_PATH)
    @Validated(Payment.class)
    @PreAuthorize("hasPermission('Required', 'AllowRefunds')")
    List<LineItemView> postRefunds(@PathParam(TENANT_ID) String tenantId, @PathParam(PROPERTY_ID) String propertyId,
          @PathParam(ACCOUNT_ID) String accountId, Payment payment) throws RGuestException, ServiceException;

    /**
     * Transfers folio line items from a source folio to a destination folio either on the same account or on a
     * different account
     *
     * @param accountId    the Account to transfer the line items to
     * @param transferInfo includes the destination folioId and the list of source folio line items to transfer
     * @return a List<LineItemView> containing all of the folio lines from the TRANSFER LedgerTransaction
     */
    @POST
    @Path(ACCOUNT_ID_PATH + TRANSFER_FOLIO_LINES)
    @Validated(LineItemTransfer.class)
    @PreAuthorize("hasPermission('Required', 'WriteAccounts')")
    List<LineItemView> transferFolioLines(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @PathParam(ACCOUNT_ID) String accountId,
          LineItemTransfer transferInfo) throws RGuestException, ServiceException;

    @POST
    @Path(ACCOUNT_ID_PATH + TRANSFER_AMOUNT_PATH)
    @Validated(AmountTransfer.class)
    @PreAuthorize("hasPermission('Required', 'WriteAccounts')")
    List<LineItemView> transferAmountToAccount(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @PathParam(ACCOUNT_ID) String accountId,
          AmountTransfer transferInfo) throws RGuestException, ServiceException;

    /**
     * Performs an adjustment on a give folio line item
     *
     * @param tenantId       id of tenant where account exists
     * @param propertyId     id of the property where the account exists
     * @param accountId      id of the account the folio line item belongs to
     * @param adjustmentInfo adjustment data including the folio line item and the amount of the adjustment
     * @return {@link LineItemView} of the folio line item including the new adjustment
     */
    @POST
    @Path(ACCOUNT_ID_PATH + ADJUSTMENT_PATH)
    @Validated(LineItemAdjustment.class)
    @PreAuthorize("hasPermission('Required', 'WriteAccounts')")
    LineItemView adjustment(@PathParam(TENANT_ID) String tenantId, @PathParam(PROPERTY_ID) String propertyId,
          @PathParam(ACCOUNT_ID) String accountId, LineItemAdjustment adjustmentInfo)
          throws RGuestException, ServiceException;

    /**
     * Performs a correction on a given folio line item
     *
     * @param tenantId       id of tenant where account exists
     * @param propertyId     id of the property where the account exists
     * @param accountId      id of the account the folio line item belongs to
     * @param correctionInfo correction data including the folio line item and the amount of the correction
     * @return {@link List<LineItemView>} of the folio line items including the new correction line items
     */
    @POST
    @Path(ACCOUNT_ID_PATH + CORRECTION_PATH)
    @Validated(LineItemAdjustment.class)
    @PreAuthorize("hasPermission('Required', 'WriteAccounts')")
    List<LineItemView> correction(@PathParam(TENANT_ID) String tenantId, @PathParam(PROPERTY_ID) String propertyId,
          @PathParam(ACCOUNT_ID) String accountId, LineItemAdjustment correctionInfo)
          throws RGuestException, ServiceException;

    /**
     * Performs a refund on a given line item on a folio
     *
     * @param tenantId      id of tenant where account exists
     * @param propertyId    id of the property where the account exists
     * @param accountId     id of the account the folio line item belongs to
     * @param paymentRefund refund data including the folio line item and the amount of the refund
     * @return {@link LineItemView} of the folio line item including the new refund
     */
    @POST
    @CreatedOnSuccess
    @Path(ACCOUNT_ID_PATH + REFUND_PATH)
    @Validated(PaymentRefund.class)
    @PreAuthorize("hasPermission('Required', 'AllowRefunds')")
    LineItemView refundPayment(@PathParam(TENANT_ID) String tenantId, @PathParam(PROPERTY_ID) String propertyId,
          @PathParam(ACCOUNT_ID) String accountId, PaymentRefund paymentRefund)
          throws RGuestException, ServiceException;

    /* Taxes */

    @POST
    @Path(ACCOUNT_ID_PATH + CHARGE_TAX_AMOUNT_PATH)
    @Validated(ChargeTaxAmountRequest.class)
    @PreAuthorize("hasPermission('Required', 'ReadAccounts')")
    ChargeTaxAmountInfo calculateChargeTaxAmount(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @PathParam(ACCOUNT_ID) String accountId,
          ChargeTaxAmountRequest request) throws RGuestException, ServiceException;

    /* Payment settings */

    /**
     * Retrieve payment settings for an account
     *
     * @param tenantId   id of tenant where account exists
     * @param propertyId id of the property where the account exists
     * @param accountId  id of account where settings exist
     * @return Existing paymentSettings
     */
    @GET
    @Path(ACCOUNT_ID_PATH + PAYMENT_SETTINGS_PATH)
    @PreAuthorize("hasPermission('Required', 'ReadAccounts')")
    List<PaymentSetting> getPaymentSettings(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @PathParam(ACCOUNT_ID) String accountId)
          throws RGuestException, ServiceException;

    /**
     * Save paymentSettings for an account
     *
     * @param tenantId        id of tenant where account exists
     * @param propertyId      id of the property where the account exists
     * @param accountId       id of account to save settings to
     * @param paymentSettings list of payment settings to save
     * @return Created settings
     */
    @POST
    @CreatedOnSuccess
    @Path(ACCOUNT_ID_PATH + PAYMENT_SETTINGS_PATH)
    @PreAuthorize("hasPermission('Required', 'WriteAccounts')")
    List<PaymentSetting> savePaymentSettings(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @PathParam(ACCOUNT_ID) String accountId,
          List<PaymentSetting> paymentSettings) throws RGuestException, ServiceException;

    /**
     * Retrieve tax exempt settings for an account by individual dates.
     *
     * @param tenantId   id of tenant where account exists
     * @param propertyId id of the property where the account exists
     * @param accountId  id of account where settings exist
     * @return Existing taxExemptSettings
     */
    @GET
    @Path(ACCOUNT_ID_PATH + TAXEXEMPT_SETTINGS_BYDATE_PATH)
    @PreAuthorize("hasPermission('Required', 'ReadAccounts')")
    TaxExemptSettingsByDate getTaxExemptSettingsByDate(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @PathParam(ACCOUNT_ID) String accountId)
          throws RGuestException, ServiceException;

    /**
     * Save tax exempt settings for an account by individual dates.
     *
     * @param tenantId                id of tenant where account exists
     * @param propertyId              id of the property where the account exists
     * @param accountId               id of account to save settings to
     * @param taxExemptSettingsByDate list of tax exempt settings to save
     * @return Created settings
     */
    @POST
    @CreatedOnSuccess
    @Path(ACCOUNT_ID_PATH + TAXEXEMPT_SETTINGS_BYDATE_PATH)
    @Validated(TaxExemptSettingsByDate.class)
    @PreAuthorize("hasPermission('Required', 'WriteAccounts')")
    TaxExemptSettingsByDate saveTaxExemptSettingsByDate(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @PathParam(ACCOUNT_ID) String accountId,
          TaxExemptSettingsByDate taxExemptSettingsByDate) throws RGuestException, ServiceException;

    /**
     * Retrieve tax exempt settings for an account by a range of dates.
     *
     * @param tenantId   id of tenant where account exists
     * @param propertyId id of the property where the account exists
     * @param accountId  id of account where settings exist
     * @return Existing taxExemptSettings
     */
    @GET
    @Path(ACCOUNT_ID_PATH + GROUP_COMPANY_TAXEXEMPT_SETTINGS_PATH)
    @PreAuthorize("hasPermission('Required', 'ReadAccounts')")
    GroupCompanyTaxExemptSettings getGroupCompanyTaxExemptSettings(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @PathParam(ACCOUNT_ID) String accountId
    ) throws RGuestException, ServiceException;

    /**
     * Retrieve tax exempt settings for an account by a range of dates.
     *
     * @param tenantId   id of tenant where account exists
     * @param propertyId id of the property where the account exists
     * @param accountId  id of account where settings exist
     * @return Existing taxExemptSettings
     */
    @GET
    @Path(ACCOUNT_ID_PATH + GROUP_COMPANY_TAXEXEMPT_SETTINGS_PATH + PRESET_PATH)
    @PreAuthorize("hasPermission('Required', 'ReadAccounts')")
    GroupCompanyTaxExemptSettings getV1GroupCompanyTaxExemptSettings(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @PathParam(ACCOUNT_ID) String accountId,
          @PathParam(PRESET) boolean preset) throws RGuestException, ServiceException;


    /**
     * Save tax exempt settings for an account by a range of dates.
     *
     * @param tenantId                      id of tenant where account exists
     * @param propertyId                    id of the property where the account exists
     * @param accountId                     id of account to save settings to
     * @param groupCompanyTaxExemptSettings list of tax exempt settings to save
     * @return Created settings
     */
    @POST
    @Path(ACCOUNT_ID_PATH + GROUP_COMPANY_TAXEXEMPT_SETTINGS_PATH)
    @Validated(GroupCompanyTaxExemptSettings.class)
    @PreAuthorize("hasPermission('Required', 'WriteAccounts')")
    GroupCompanyTaxExemptSettings saveGroupCompanyTaxExemptSettings(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @PathParam(ACCOUNT_ID) String accountId,
          GroupCompanyTaxExemptSettings groupCompanyTaxExemptSettings)
          throws RGuestException, ServiceException;

    @POST
    @Path(ACCOUNT_ID_PATH + GROUP_COMPANY_TAXEXEMPT_SETTINGS_PATH + PRESET_PATH)
    @Validated(GroupCompanyTaxExemptSettings.class)
    @PreAuthorize("hasPermission('Required', 'WriteAccounts')")
    GroupCompanyTaxExemptSettings saveV1GroupCompanyTaxExemptSettings(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @PathParam(ACCOUNT_ID) String accountId,
          GroupCompanyTaxExemptSettings groupCompanyTaxExemptSettings, @PathParam(PRESET) boolean isPreset)
          throws RGuestException, ServiceException;



    /* Search */

    /**
     * Search for accounts within a given tenant and property
     *
     * @param tenantId                 id of tenant to search on
     * @param propertyId               id of the property to search on
     * @param searchTerm               string to match on
     * @param optionalSearchParamsPath optional parameters sent to search accounts. They are passed in in the path as
     *                                 key/value pairs; for
     *                                 available parameters:
     *                                 propertyIdFilter - property id to filter results on
     *                                 includeClosedAccounts - by default closed accounts will be filtered from the
     *                                 search results
     * @return A list of {@link AccountSearchResult}
     */
    @GET
    @Path(SEARCH_PATH + SEARCH_TERM_PATH + REMAINING_PATH)
    @PreAuthorize("hasPermission('Required', 'ReadAccounts')")
    List<AccountSearchResult> search(@PathParam(TENANT_ID) String tenantId, @PathParam(PROPERTY_ID) String propertyId,
          @PathParam(SEARCH_TERM) String searchTerm, @PathParam(PATH) String optionalSearchParamsPath)
          throws RGuestException, ServiceException;

    /* Invoices */

    /**
     * Retrieves the non-invoiced details of a COMPANY account
     *
     * @param tenantId   id of tenant where the COMPANY account exists
     * @param propertyId id of the property
     * @param accountId  id of COMPANY account to retrieve non-invoiced details from
     * @return Non-invoiced details for a COMPANY account
     */
    @GET
    @Path(ACCOUNT_ID_PATH + NON_INVOICED_PATH)
    @PreAuthorize("hasPermission('Required', 'ReadAccountsReceivable')")
    NonInvoicedARDetail getNonInvoicedARDetail(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @PathParam(ACCOUNT_ID) String accountId)
          throws RGuestException, ServiceException;

    /**
     * Create an invoice for an account
     *
     * @param tenantId   id of tenant for the account
     * @param propertyId id of the property
     * @param accountId  id of account to save an invoice to
     * @param invoice
     * @return Created invoice
     */
    @POST
    @CreatedOnSuccess
    @Path(ACCOUNT_ID_PATH + INVOICES_PATH)
    @Validated(InvoiceRequest.class)
    @PreAuthorize("hasPermission('Required', 'WriteAccountsReceivable')")
    InvoiceView createInvoice(@PathParam(TENANT_ID) String tenantId, @PathParam(PROPERTY_ID) String propertyId,
          @PathParam(ACCOUNT_ID) String accountId, InvoiceRequest invoice) throws RGuestException, ServiceException;

    /**
     * Retrieve an invoice by Id
     *
     * @param tenantId       id of the tenant for the account
     * @param propertyId     id of the property
     * @param accountId      id of account the invoice belongs to
     * @param invoiceId      id of the invoice to retrieve
     * @param optionalParams optional params for retrieving a previous version of the invoice
     * @return {@link InvoiceView}
     * @throws ServiceException
     */
    @GET
    @Path(ACCOUNT_ID_PATH + INVOICES_PATH + INVOICE_ID_PATH)
    @PreAuthorize("hasPermission('Required', 'ReadAccountsReceivable')")
    InvoiceView getInvoiceById(@PathParam(TENANT_ID) String tenantId, @PathParam(PROPERTY_ID) String propertyId,
          @PathParam(ACCOUNT_ID) String accountId, @PathParam(INVOICE_ID) String invoiceId,
          @QueryParam("") @LogParam("optionalParams") InvoiceOptionalParams optionalParams)
          throws RGuestException, ServiceException;

    @GET
    @Path(ACCOUNT_ID_PATH + INVOICES_PATH)
    @OkOnEmpty
    @PreAuthorize("hasPermission('Required', 'ReadAccountsReceivable')")
    List<InvoiceView> findInvoices(@PathParam(TENANT_ID) String tenantId, @PathParam(PROPERTY_ID) String propertyId,
          @PathParam("accountId") String accountId,
          @QueryParam("") @LogParam("params") InvoiceFilteringOptionalParams params)
          throws RGuestException, ServiceException;

    @GET
    @Path(ACCOUNT_ID_PATH + INVOICE_REPORT_START)
    @OkOnEmpty
    @PreAuthorize("hasPermission('Required', 'ReadAccountsReceivable')")
    InvoiceReportProgressView createInvoiceReport(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @PathParam(ACCOUNT_ID) String accountId,
          @QueryParam("tag") String tag, @QueryParam("includeClosed") String includeClosed)
          throws RGuestException, ServiceException;

    @GET
    @Path(ACCOUNT_ID_PATH + INVOICE_REPORT_POLL)
    @OkOnEmpty
    @PreAuthorize("hasPermission('Required', 'ReadAccountsReceivable')")
    InvoiceReportProgressView getInvoiceReportProgress(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @PathParam(ACCOUNT_ID) String accountId,
          @QueryParam("includeClosed") String includeClosed) throws RGuestException, ServiceException;

    /**
     * Add line items to an invoice for an account
     *
     * @param tenantId   id of the tenant for the account
     * @param propertyId id of the property
     * @param accountId  id of account the invoice belongs to
     * @param invoiceId  id of the invoice to add items to
     * @param lineItems  lineItem ids to add to the invoice
     * @return Updated invoice
     * @throws ServiceException
     */
    @PUT
    @Path(ACCOUNT_ID_PATH + INVOICES_PATH + INVOICE_ID_PATH + INVOICE_ADD_ITEMS_PATH)
    @Validated(UpdateInvoiceLineItemsRequest.class)
    @PreAuthorize("hasPermission('Required', 'WriteAccountsReceivable')")
    InvoiceView addInvoiceLineItems(@PathParam(TENANT_ID) String tenantId, @PathParam(PROPERTY_ID) String propertyId,
          @PathParam(ACCOUNT_ID) String accountId, @PathParam(INVOICE_ID) String invoiceId,
          UpdateInvoiceLineItemsRequest lineItems) throws RGuestException, ServiceException;

    /**
     * Remove line items from an invoice for an account
     *
     * @param tenantId   id of the tenant for the account
     * @param propertyId id of the property
     * @param accountId  id of account the invoice belongs to
     * @param invoiceId  id of the invoice to remove items from
     * @param lineItems  lineItem ids to remove from the invoice
     * @return Updated invoice
     * @throws ServiceException
     */
    @PUT
    @Path(ACCOUNT_ID_PATH + INVOICES_PATH + INVOICE_ID_PATH + INVOICE_REMOVE_ITEMS_PATH)
    @Validated(UpdateInvoiceLineItemsRequest.class)
    @PreAuthorize("hasPermission('Required', 'WriteAccountsReceivable')")
    InvoiceView removeInvoiceLineItems(@PathParam(TENANT_ID) String tenantId, @PathParam(PROPERTY_ID) String propertyId,
          @PathParam(ACCOUNT_ID) String accountId, @PathParam(INVOICE_ID) String invoiceId,
          UpdateInvoiceLineItemsRequest lineItems) throws RGuestException, ServiceException;

    /**
     * Update terms on an invoice
     *
     * @param tenantId   tenantId
     * @param propertyId id of the property
     * @param accountId  accountId
     * @param invoiceId  invoice to update
     * @param terms      new value for terms
     * @return Updated invoice
     * @throws ServiceException
     */
    @PUT
    @Path(ACCOUNT_ID_PATH + INVOICES_PATH + INVOICE_ID_PATH + INVOICE_UPDATE_TERMS_PATH)
    @Validated(UpdateInvoiceTermsRequest.class)
    @PreAuthorize("hasPermission('Required', 'WriteAccountsReceivable')")
    InvoiceView updateInvoiceTerms(@PathParam(TENANT_ID) String tenantId, @PathParam(PROPERTY_ID) String propertyId,
          @PathParam(ACCOUNT_ID) String accountId, @PathParam(INVOICE_ID) String invoiceId,
          UpdateInvoiceTermsRequest terms) throws RGuestException, ServiceException;

    /**
     * Mark invoice as sent by email or printed and sent by mail
     *
     * @param tenantId   id of the tenant for the account
     * @param propertyId id of the property
     * @param accountId  id of account the invoice belongs to
     * @param invoiceId  id of the invoice to retrieve
     * @param isEmail    boolean if true then sent by Email if false then printed and sent by mail
     * @return Created invoice
     * @throws ServiceException
     */
    @PUT
    @Path(ACCOUNT_ID_PATH + INVOICES_PATH + INVOICE_ID_PATH + INVOICE_SET_INVOICE_SENT)
    @PreAuthorize("hasPermission('Required', 'WriteAccountsReceivable')")
    InvoiceView setInvoiceSent(@PathParam(TENANT_ID) String tenantId, @PathParam(PROPERTY_ID) String propertyId,
          @PathParam(ACCOUNT_ID) String accountId, @PathParam(INVOICE_ID) String invoiceId,
          @QueryParam("isEmail") boolean isEmail) throws RGuestException, ServiceException;

    /**
     * Applies payments to one or more invoices
     *
     * @param accountId                  id of the A/R account to apply payments to
     * @param applyInvoicePaymentRequest details for how to apply the payments; including payment method, amounts, and
     *                                   which invoices
     * @return a list of {@link InvoiceView} including the payments applied
     */
    @POST
    @CreatedOnSuccess
    @Path(ACCOUNT_ID_PATH + INVOICES_PATH + APPLY_PAYMENTS)
    @Validated(ApplyInvoicePaymentRequest.class)
    @PreAuthorize("hasPermission('Required', 'WriteAccountsReceivable')")
    List<InvoiceView> applyInvoicePayments(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @PathParam(ACCOUNT_ID) String accountId,
          ApplyInvoicePaymentRequest applyInvoicePaymentRequest) throws RGuestException, ServiceException;

    /**
     * Performs a refund against a given invoice payment item
     *
     * @param tenantId             id of tenant where account exists
     * @param propertyId           id of the property
     * @param accountId            id of the account the folio line item belongs to
     * @param invoiceId            id of the invoice
     * @param invoicePaymentRefund refund data including the invoicePaymentId and the amount of the refund
     * @return {@link InvoiceView} of the updated invoice
     */
    @POST
    @CreatedOnSuccess
    @Path(ACCOUNT_ID_PATH + INVOICES_PATH + INVOICE_ID_PATH + REFUND_PATH)
    @Validated(InvoicePaymentRefund.class)
    @PreAuthorize("hasPermission('Required', 'AllowRefunds')")
    InvoiceView refundInvoicePayment(@PathParam(TENANT_ID) String tenantId, @PathParam(PROPERTY_ID) String propertyId,
          @PathParam(ACCOUNT_ID) String accountId, @PathParam(INVOICE_ID) String invoiceId,
          InvoicePaymentRefund invoicePaymentRefund) throws RGuestException, ServiceException;

    /*  */

    /**
     * Retrieve balances for a date
     *
     * @param tenantId           id of tenant
     * @param propertyId         id of the property
     * @param ledgerBalancesInfo property id and date
     * @return map of ledger name to ledger balance
     */
    @GET
    @Path(LEDGER_BALANCES_PATH)
    @PreAuthorize("hasPermission('Required', 'ReadAccounts')")
    Map<String, BigDecimal> getLedgerBalances(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, LedgerBalancesInfo ledgerBalancesInfo)
          throws RGuestException, ServiceException;

    /**
     * Determines if this account can checkout
     *
     * @param tenantId     tenantId
     * @param propertyId   id of the property
     * @param accountId    accountId
     * @param allowBalance allowBalance
     */
    @GET
    @Path(ACCOUNT_ID_PATH + VERIFY_CHECKOUT_PATH)
    @PreAuthorize("hasPermission('Required', 'ReadAccounts')")
    void verifyCheckout(@PathParam(TENANT_ID) String tenantId, @PathParam(PROPERTY_ID) String propertyId,
          @PathParam(ACCOUNT_ID) String accountId, @QueryParam("allowBalance") boolean allowBalance)
          throws RGuestException, ServiceException;

    /**
     * Fetches the next unused AR account number from the database
     *
     * @param tenantId
     * @param propertyId
     * @return the next AR account number
     * @throws ServiceException
     */
    @GET
    @Path(NEXT_ACCOUNT_NUMBER_PATH)
    @PreAuthorize("hasPermission('Required', 'ReadAccounts')")
    NextAccountNumberInfo getNextArAccountNumber(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId) throws RGuestException, ServiceException;

    /**
     * Checks account number code availability
     *
     * @param tenantId
     * @param propertyId
     * @return true if available
     * @throws ServiceException
     */
    @GET
    @Path(CHECK_ACCOUNT_NUMBER_AVAILABILITY_PATH)
    @PreAuthorize("hasPermission('Required', 'ReadAccounts')")
    Boolean checkAccountNumberAvailability(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @PathParam(ACCOUNT_NUMBER) String accountNumber)
          throws RGuestException, ServiceException;

    /**
     * authorizes any additional credit cards associated with an
     * account based on estimated charges and existing auth amounts
     *
     * @throws ServiceException
     */
    @POST
    @Path(ACCOUNT_ID_PATH + AUTH_CARDS_ON_ACCOUNT_PATH)
    @PreAuthorize("hasPermission('Required', 'WriteAccounts')")
    List<PaymentInstrumentAuthStatus> authAllCardsOnAccount(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @PathParam(ACCOUNT_ID) String accountId,
          @QueryParam(START_DATE) LocalDate startDate, @QueryParam(END_DATE) LocalDate endDate)
          throws RGuestException, ServiceException;

    @POST
    @Path(FILTERED)
    CollectionResponse<AccountSummary> findAccounts(
          @ApiParam(value = "tenant id", required = true) @PathParam(TENANT_ID) @LogParam("tenantId") String tenantId,
          @PathParam(PROPERTY_ID) String propertyId,
          @ApiParam(value = "collection request", required = false) @LogParam("params")
          AccountsCollectionRequest collectionRequest) throws RGuestException, ServiceException;

    /* ----------------------------------------------------------- */

    @GET
    @Path(ACCOUNT_ID_PATH + CLOSABLE_INFO)
    @PreAuthorize("hasPermission('Required', 'ReadAccounts')")
    AccountClosableInfo getAccountClosableInfo(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @PathParam("accountId") String accountId)
          throws RGuestException, ServiceException;

    /**
     * Attempts to pay off the balances of an account associated with the
     * set of payment setting ids, or the default payment setting id if
     * no set is specified
     *
     * @param tenantId  tenantId
     * @param accountId if of account to pay off
     * @param request   request parameters
     */
    @POST
    @CreatedOnSuccess
    @Path(ACCOUNT_ID_PATH + PAYOFF_BALANCE_PATH)
    @PreAuthorize("hasPermission('Required', 'WriteAccounts')")
    void payOffBalance(@PathParam(TENANT_ID) String tenantId, @PathParam(PROPERTY_ID) String propertyId,
          @PathParam(ACCOUNT_ID) String accountId, PayoffBalanceRequest request)
          throws RGuestException, ServiceException;

    @POST
    @Path(ACCOUNT_ID_PATH + FIX_LEDGER_BALANCES_PATH)
    @PreAuthorize("hasPermission('Required', 'WriteAccounts')")
    List<LedgerBalanceFixup> fixLedgerBalancesForAccount(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @PathParam(ACCOUNT_ID) String accountId)
          throws RGuestException, ServiceException;
}