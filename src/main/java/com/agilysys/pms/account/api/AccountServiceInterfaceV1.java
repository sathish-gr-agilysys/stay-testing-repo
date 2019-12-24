/*
 * (C) 2015 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
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

import org.joda.time.LocalDate;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;

import com.agilysys.common.model.PaymentSetting;
import com.agilysys.platform.common.rguest.exception.RGuestException;
import com.agilysys.platform.schema.Validated;
import com.agilysys.pms.account.AccountUpdateResponse;
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
import com.agilysys.pms.account.model.BatchFolioInvoiceRequest;
import com.agilysys.pms.account.model.BatchFolioInvoiceResponse;
import com.agilysys.pms.account.model.Charge;
import com.agilysys.pms.account.model.ChargeTaxAmountInfo;
import com.agilysys.pms.account.model.ChargeTaxAmountRequest;
import com.agilysys.pms.account.model.CompTransaction;
import com.agilysys.pms.account.model.CreateAccountSummary;
import com.agilysys.pms.account.model.Credit;
import com.agilysys.pms.account.model.EligibleFolioLineItems;
import com.agilysys.pms.account.model.FolioBalance;
import com.agilysys.pms.account.model.FolioDetail;
import com.agilysys.pms.account.model.FolioInvoiceDetail;
import com.agilysys.pms.account.model.FolioInvoiceRequest;
import com.agilysys.pms.account.model.FolioInvoiceResponse;
import com.agilysys.pms.account.model.FolioSummary;
import com.agilysys.pms.account.model.FolioViewLineItem;
import com.agilysys.pms.account.model.GetFoliosOptionalParameters;
import com.agilysys.pms.account.model.GiftCardRequest;
import com.agilysys.pms.account.model.GiftCardResponse;
import com.agilysys.pms.account.model.GroupCompanyTaxExemptSettings;
import com.agilysys.pms.account.model.InventoryAllocationDetails;
import com.agilysys.pms.account.model.InvoicePaymentRefund;
import com.agilysys.pms.account.model.InvoiceReportProgressView;
import com.agilysys.pms.account.model.InvoiceRequest;
import com.agilysys.pms.account.model.InvoiceView;
import com.agilysys.pms.account.model.LedgerBalancesInfo;
import com.agilysys.pms.account.model.LedgerTransactionTransferDetail;
import com.agilysys.pms.account.model.LineItemAdjustment;
import com.agilysys.pms.account.model.LineItemTransfer;
import com.agilysys.pms.account.model.LineItemView;
import com.agilysys.pms.account.model.NextAccountNumberInfo;
import com.agilysys.pms.account.model.NonInvoiceReport;
import com.agilysys.pms.account.model.NonInvoicedARDetail;
import com.agilysys.pms.account.model.PantryCharge;
import com.agilysys.pms.account.model.PantryTransactionResponse;
import com.agilysys.pms.account.model.Payment;
import com.agilysys.pms.account.model.PaymentInstrumentAuthStatus;
import com.agilysys.pms.account.model.PaymentRefund;
import com.agilysys.pms.account.model.PayoffBalanceRequest;
import com.agilysys.pms.account.model.PosCharge;
import com.agilysys.pms.account.model.PosCredit;
import com.agilysys.pms.account.model.PostChargesRequest;
import com.agilysys.pms.account.model.PostChargesResponse;
import com.agilysys.pms.account.model.PostingRuleDetail;
import com.agilysys.pms.account.model.PostingRuleDetailView;
import com.agilysys.pms.account.model.ReverseRedemptionRequest;
import com.agilysys.pms.account.model.ReservationCancellationResponse;
import com.agilysys.pms.account.model.TaxExemptSettingsByDate;
import com.agilysys.pms.account.model.TenantARPropertySettingStatus;
import com.agilysys.pms.account.model.TenantDefaultSettingsSummary;
import com.agilysys.pms.account.model.TransactionReportItem;
import com.agilysys.pms.account.model.UpdateFolioInvoicesRequest;
import com.agilysys.pms.account.model.UpdateInvoiceLineItemsRequest;
import com.agilysys.pms.account.model.UpdateInvoiceTermsRequest;
import com.agilysys.pms.account.model.ViewFolioRequest;
import com.agilysys.pms.account.model.invoice.InvoiceViewType;
import com.agilysys.pms.account.model.invoice.base.InvoiceBaseView;
import com.agilysys.pms.common.api.annotation.CreatedOnSuccess;
import com.agilysys.pms.common.api.annotation.OkOnEmpty;
import com.agilysys.pms.common.model.CollectionResponse;
import com.agilysys.pms.common.model.SearchPage;
import com.agilysys.pms.payment.model.LodgingInformation;
import com.agilysys.pms.payment.model.PaymentInstrumentSetting;

@Path(AccountServiceInterfaceV1.BASE_PATH)
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface AccountServiceInterfaceV1 {
    String TENANT_ID = "tenantId";
    String PROPERTY_ID = "propertyId";

    String BASE_PATH = "/v1/tenants/{" + TENANT_ID + "}/properties/{" + PROPERTY_ID + "}/accounts";

    String ACCOUNT_BALANCES_PATH = "/balances";
    String ACCOUNT_ID = "accountId";
    String ACCOUNT_ID_PATH = "/{" + ACCOUNT_ID + "}";
    String ACCOUNT_NUMBER = "accountNumber";
    String ACCOUNT_STATUS = "accountStatus";
    String ACCOUNT_TYPE = "accountType";
    String ACCOUNT_STATUS_PATH = "/status/{" + ACCOUNT_STATUS + "}";
    String ACCOUNTS_RECEIVABLE_SETTINGS_PATH = "/accountsReceivableSettings";
    String ADJUSTMENT_PATH = "/adjustment";
    String APPLY_PAYMENTS = "/applyPayments";
    String AUTH_CARDS_ON_ACCOUNT_PATH = "/authCardsOnAccount";
    String BATCH_CHARGES_PATH = "/batchCharges";
    String BATCH_FOLIO_EMAIL = "/batchFolioEmail";
    String BATCH_FOLIO_PATH = "/batchFolios";
    String BATCH_FOLIO_PRINT = "/batchPrintFolio";
    String CALL_TYPE = "callType";
    String CHARGE_TAX_AMOUNT_PATH = "/calculateChargeTaxAmount";
    String CHARGES_PATH = "/charges";
    String CHECK_ACCOUNT_NUMBER_AVAILABILITY_PATH = "/checkAccountNumberAvailability/{" + ACCOUNT_NUMBER + "}";
    String CLOSABLE_INFO = "/closableInfo";
    String CORRECTION_PATH = "/correction";
    String CREDIT_PATH = "/credit";
    String END_DATE = "endDate";
    String END_DATE_TIME = "endDateTime";
    String FILTERED = "/filtered";
    String FOLIO_PATH = "/folios";
    String TOTAL_SPENT_PATH = "/totalSpent";
    String FOLIO_BALANCES_PATH = "/folioBalances";
    String FOLIO_EMAIL = "/folioEmail";
    String FOLIO_ID = "folioId";
    String FOLIO_ID_PATH = "/{" + FOLIO_ID + "}";
    String FOLIO_INVOICE_ID = "folioInvoiceId";
    String FOLIO_INVOICE_ID_PATH = "/" + FOLIO_INVOICE_ID + "/{" + FOLIO_INVOICE_ID + "}";
    String FREE_ALLOWANCE_PATH = "/freeAllowanceCharges";
    String GROUP_COMPANY_TAX_EXEMPT_SETTINGS_PATH = "/groupCompanyTaxExemptSettings";
    String GROUPED = "grouped";
    String INCLUDE_CLOSED_ACCOUNTS = "includeClosedAccounts";
    String INVOICE_ADD_ITEMS_PATH = "/addItems";
    String INVOICE_ID = "invoiceId";
    String INVOICE_ID_PATH = "/{" + INVOICE_ID + "}";
    String INVOICES_PATH = "/invoices";
    String INVOICE_REPORT_START = "/invoice-report-start";
    String INVOICE_VIEW_TYPE = "invoiceViewType";
    String INVOICE_REPORT = "/invoice-report";
    String INVOICE_REPORT_TYPE = INVOICE_REPORT + "/{" + INVOICE_VIEW_TYPE + "}";
    String INVOICE_REMOVE_ITEMS_PATH = "/removeItems";
    String INVOICE_REPORT_POLL = "/invoice-report-poll";
    String INVOICE_SET_INVOICE_SENT = "/setInvoiceSent";
    String INVOICE_UPDATE_TERMS_PATH = "/updateTerms";
    String LEDGER_BALANCES_PATH = "/ledgerBalances";
    String LODGING_PATH = ACCOUNT_ID_PATH + "/lodging";
    String NEXT_ACCOUNT_NUMBER_PATH = "/nextAccountNumber";
    String NON_INVOICED_PATH = "/nonInvoicedDetails";
    String PAGE_PATH = "/page";
    String PATH = "path";
    String PAYMENT_SETTINGS_PATH = "/paymentSettings";
    String PAYMENTS_PATH = "/payments";
    String PAYMENTS_ASYNC_PATH = "/paymentsAsync";
    String PAYOFF_BALANCE_PATH = "/payOffBalance";
    String POS_CHARGE_PATH = "/posCharge";
    String POS_CREDIT_PATH = "/posCredit";
    String POSTING_RULE_ID = "postingRulesId";
    String POSTING_RULE_ID_PATH = "/{" + POSTING_RULE_ID + "}";
    String POSTING_RULES_PATH = "/postingRules";
    String PRINT_FOLIO = "/printFolio";
    String FOLIO_INVOICE_SUMMARY = "/folioInvoiceSummary";
    String PROFILE_ID = "profileId";
    String PROFILES_PATH = "/profiles";
    String PROFILE_ID_PATH = PROFILES_PATH + "/{" + PROFILE_ID + "}";
    String PRESET = "preset";
    String PRESET_PATH = "/presetValue/{" + PRESET + "}";
    String REFERENCE_ID = "referenceId";
    String REFERENCE_ID_PATH = "/reference/{" + REFERENCE_ID + "}";
    String MULTIPLE_REFERENCES_ID_PATH = "/references/{" + REFERENCE_ID + "}";
    String REFUND_PATH = "/refund";
    String REFUNDS_PATH = "/refunds";
    String REMAINING_PATH = "/{" + PATH + ":.*}";
    String PAYMENT_METHOD_ID = "paymentMethodId";
    String REQUEST_TYPE = "requestType";
    String SEARCH_PATH = "/search";
    String SEARCH_TERM = "searchTerm";
    String SEARCH_TERM_PATH = "/{" + SEARCH_TERM + "}";
    String START_DATE = "startDate";
    String START_DATE_TIME = "startDateTime";
    String STATUSES_PATH = "statuses";
    String TASK_ID = "taskId";
    String TASK_ID_PATH = "/tasks/{" + TASK_ID + "}";
    String TAX_EXEMPT_SETTINGS_BY_DATE_PATH = "/taxExemptSettingsByDate";
    String TRANSFER_AMOUNT_PATH = "/transferAmount";
    String TRANSFER_FOLIO_LINES = "/transferFolioLines";
    String TRANSFER_HISTORY = "/transferHistory";
    String TRANSFER_HISTORY_ID = "transferHistoryId";
    String LEDGER_TRANSACTION_ID = "/ledgerTransactionIds";
    String TRANSFER_HISTORY_ID_PATH = "/{" + TRANSFER_HISTORY_ID + "}";
    String TYPES_PATH = "types";
    String VERIFY_CHECKOUT_PATH = "/verifyCheckout";
    String COMPANY_PROFILE_ID = "companyProfileId";
    String COMPANY_PROFILE_PATH = "/companyProfile/{" + COMPANY_PROFILE_ID + "}";
    String TENANT_DEFAULT_SETTINGS_PATH = "/tenantDefaultSettings";
    String INVENTORY_ALLOCATION = "/inventory/allocation";
    String TENANT_DEFAULT_SETTINGS_APPLY_PATH = TENANT_DEFAULT_SETTINGS_PATH + "/apply";
    String TENANT_DEFAULT_SETTINGS_JOB_STATUS_PATH = TENANT_DEFAULT_SETTINGS_PATH + "/jobStatus";
    String TENANT_DEFAULT_SETTINGS_PROPERTY_LISTINGS_PATH = TENANT_DEFAULT_SETTINGS_PATH + "/propertyStatus";
    String NEW_PROPERTY_AR_ACCOUNT = "/newPropertyARAccount";
    String CANCEL_PAYMENTS = "/cancelPayments";
    String RESERVATION_IDS_TO_AUTHORIZE = "/getReservationIdsToAuthorize";
    String FOLIO_INVOICE_BY_PROFILE_ID = FOLIO_PATH + PROFILES_PATH + INVOICES_PATH;
    String FOLIO_INVOICE_BY_FOLIO_ID = ACCOUNT_ID_PATH + FOLIO_PATH + FOLIO_ID_PATH + INVOICES_PATH;
    String PANTRY_ITEMS_CHARGE = "/pantryItemsCharge";
    String AUTHORIZER_CODE = "authorizerCode";
    String CODE = "/{" + AUTHORIZER_CODE + "}";
    String AUTHORIZERD_FOLIO_ITEMS = "/authorizedFolioItems" + CODE;
    String REDEEM_FOLIO_CHARGE = "/redeemFolio";
    String REVERSE_REDEEM_CHARGE = "/reverseRedeemFolio";

    String PAGE = "page";
    String SIZE = "size";

    @GET
    @PreAuthorize("hasPermission('Required', 'ReadAccounts')")
    List<AccountSummary> getAccounts(@PathParam(TENANT_ID) String tenantId, @PathParam(PROPERTY_ID) String propertyId,
          @QueryParam("accountType") String accountTypes, @QueryParam("accountStatus") String accountStatuses)
          throws RGuestException;

    @Deprecated
    @GET
    @Path(REFERENCE_ID_PATH)
    @PreAuthorize("hasPermission('Required', 'ReadAccounts')")
    AccountSummary getAccountByReferenceId(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @PathParam(REFERENCE_ID) String referenceId)
          throws RGuestException;

    @GET
    @Path(MULTIPLE_REFERENCES_ID_PATH)
    @PreAuthorize("hasPermission('Required', 'ReadAccounts')")
    List<AccountSummary> getAccountsByReferenceId(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @QueryParam(ACCOUNT_TYPE) String accountType,
          @PathParam(REFERENCE_ID) String referenceId) throws RGuestException;

    @GET
    @Path(ACCOUNT_ID_PATH)
    @PreAuthorize("hasPermission('Required', 'ReadAccounts')")
    AccountSummary getAccount(@PathParam(TENANT_ID) String tenantId, @PathParam(PROPERTY_ID) String propertyId,
          @PathParam(ACCOUNT_ID) String accountId) throws RGuestException;

    @GET
    @Path(LODGING_PATH)
    @PreAuthorize("hasPermission('Required', 'ReadAccounts')")
    LodgingInformation getLodgingInformationForAccountById(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @PathParam(ACCOUNT_ID) String accountId) throws RGuestException;

    @GET
    @Path(TYPES_PATH)
    @PreAuthorize("hasPermission('Required', 'ReadAccounts')")
    List<String> getAccountTypes(@PathParam(TENANT_ID) String tenantId, @PathParam(PROPERTY_ID) String propertyId)
          throws RGuestException;

    @GET
    @Path(STATUSES_PATH)
    @PreAuthorize("hasPermission('Required', 'ReadAccounts')")
    List<String> getAccountStatuses(@PathParam(TENANT_ID) String tenantId, @PathParam(PROPERTY_ID) String propertyId)
          throws RGuestException;

    @GET
    @Path(ACCOUNT_ID_PATH + "/details")
    @PreAuthorize("hasPermission('Required', 'ReadAccounts')")
    AccountDetail getAccountDetails(@PathParam(TENANT_ID) String tenantId, @PathParam(PROPERTY_ID) String propertyId,
          @PathParam(ACCOUNT_ID) String accountId) throws RGuestException;

    @POST
    @CreatedOnSuccess
    @Validated(CreateAccountSummary.class)
    @PreAuthorize("hasPermission('Required', 'WriteAccounts')")
    AccountDetail createAccount(@PathParam(TENANT_ID) String tenantId, @PathParam(PROPERTY_ID) String propertyId,
          CreateAccountSummary account) throws RGuestException;

    @GET
    @Path(ACCOUNT_ID_PATH + AUTHORIZERD_FOLIO_ITEMS)
    EligibleFolioLineItems getEligibleFolioItemsByAuthorizerDetails(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @PathParam(ACCOUNT_ID) String accountId,
          @PathParam(AUTHORIZER_CODE) String authorizerCode) throws RGuestException;

    @PUT
    @Path(ACCOUNT_ID_PATH + ACCOUNT_STATUS_PATH)
    @OkOnEmpty
    @PreAuthorize("hasPermission('Required', 'WriteAccounts')")
    void updateAccountStatus(@PathParam(TENANT_ID) String tenantId, @PathParam(PROPERTY_ID) String propertyId,
          @PathParam(ACCOUNT_ID) String accountId, @PathParam(ACCOUNT_STATUS) String accountStatus,
          @QueryParam("dissociatePantryHouseAccount") boolean dissociatePantryHouseAccount) throws RGuestException;


    @PUT
    @Path(ACCOUNT_ID_PATH + ACCOUNTS_RECEIVABLE_SETTINGS_PATH)
    @PreAuthorize("hasPermission('Required', 'WriteAccounts')")
    AccountSummary updateAccountsReceivableSettings(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @PathParam(ACCOUNT_ID) String accountId,
          AccountsReceivableSettings accountsReceivableSettings) throws RGuestException;

    @POST
    @Path(ACCOUNT_BALANCES_PATH)
    @PreAuthorize("hasPermission('Required', 'ReadAccounts')")
    AccountStatementResponse getAccountBalances(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, AccountStatementsRequest accountStatementsRequest)
          throws RGuestException;

    @GET
    @Path(ACCOUNT_ID_PATH + FOLIO_PATH)
    @PreAuthorize("hasPermission('Required', 'ReadAccounts')")
    List<FolioDetail> getFolios(@PathParam(TENANT_ID) String tenantId, @PathParam(PROPERTY_ID) String propertyId,
          @PathParam(ACCOUNT_ID) String accountId, @QueryParam("") GetFoliosOptionalParameters optionalParameters)
          throws RGuestException;

    @POST
    @Path(FOLIO_PATH)
    @PreAuthorize("hasPermission('Required', 'ReadAccounts')")
    Map<String, List<FolioDetail>> getFoliosForAccounts(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, Set<String> accountIds) throws RGuestException;

    @POST
    @Path(TOTAL_SPENT_PATH)
    @PreAuthorize("hasPermission('Required', 'ReadAccounts')")
    Map<String, BigDecimal> getTotalSpentForAccounts(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, Set<String> accountIds) throws RGuestException;

    @POST
    @Path(ACCOUNT_ID_PATH + FOLIO_PATH + FOLIO_ID_PATH)
    @PreAuthorize("hasPermission('Required', 'ReadAccounts')")
    @Validated(ViewFolioRequest.class)
    Page<FolioViewLineItem> viewFolio(@PathParam(TENANT_ID) String tenantId, @PathParam(PROPERTY_ID) String propertyId,
          @PathParam(ACCOUNT_ID) String accountId, @PathParam(FOLIO_ID) String folioId,
          ViewFolioRequest viewfoliosRequest) throws RGuestException;

    @GET
    @Path(ACCOUNT_ID_PATH + FOLIO_BALANCES_PATH)
    @PreAuthorize("hasPermission('Required', 'ReadAccounts')")
    List<FolioBalance> getFolioBalances(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @PathParam(ACCOUNT_ID) String accountId) throws RGuestException;

    @POST
    @CreatedOnSuccess
    @Path(ACCOUNT_ID_PATH + FOLIO_PATH)
    @Validated(FolioSummary.class)
    @PreAuthorize("hasPermission('Required', 'WriteAccounts')")
    FolioSummary createFolio(@PathParam(TENANT_ID) String tenantId, @PathParam(PROPERTY_ID) String propertyId,
          @PathParam(ACCOUNT_ID) String accountId, FolioSummary folio) throws RGuestException;

    @POST
    @CreatedOnSuccess
    @Path(ACCOUNT_ID_PATH + BATCH_FOLIO_PATH)
    @PreAuthorize("hasPermission('Required', 'WriteAccounts')")
    List<FolioSummary> createFolios(@PathParam(TENANT_ID) String tenantId, @PathParam(PROPERTY_ID) String propertyId,
          @PathParam(ACCOUNT_ID) String accountId, List<FolioSummary> folios) throws RGuestException;

    @GET
    @Path(ACCOUNT_ID_PATH + FOLIO_PATH + FOLIO_ID_PATH)
    @Produces(MediaType.APPLICATION_JSON)
    @PreAuthorize("hasPermission('Required', 'ReadAccounts')")
    FolioDetail getFolio(@PathParam(TENANT_ID) String tenantId, @PathParam(PROPERTY_ID) String propertyId,
          @PathParam(ACCOUNT_ID) String accountId, @PathParam(FOLIO_ID) String folioId) throws RGuestException;

    @PUT
    @Path(ACCOUNT_ID_PATH + FOLIO_PATH + FOLIO_ID_PATH)
    @Validated(FolioSummary.class)
    @PreAuthorize("hasPermission('Required', 'WriteAccounts')")
    FolioSummary updateFolio(@PathParam(TENANT_ID) String tenantId, @PathParam(PROPERTY_ID) String propertyId,
          @PathParam(ACCOUNT_ID) String accountId, @PathParam(FOLIO_ID) String folioId, FolioSummary folio)
          throws RGuestException;

    @PUT
    @Path(ACCOUNT_ID_PATH + FOLIO_PATH)
    @PreAuthorize("hasPermission('Required', 'WriteAccounts')")
    List<FolioSummary> updateFolios(@PathParam(TENANT_ID) String tenantId, @PathParam(PROPERTY_ID) String propertyId,
          @PathParam(ACCOUNT_ID) String accountId, List<FolioSummary> folios) throws RGuestException;

    @DELETE
    @Path(ACCOUNT_ID_PATH + FOLIO_PATH + FOLIO_ID_PATH)
    @PreAuthorize("hasPermission('Required', 'WriteAccounts')")
    void deleteFolio(@PathParam(TENANT_ID) String tenantId, @PathParam(PROPERTY_ID) String propertyId,
          @PathParam(ACCOUNT_ID) String accountId, @PathParam(FOLIO_ID) String folioId) throws RGuestException;

    @POST
    @Path(TRANSFER_HISTORY)
    @PreAuthorize("hasPermission('Required', 'ReadAccounts')")
    Map<String, LedgerTransactionTransferDetail> getTransactionHistory(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, List<String> ledgerTransactionHistoryId)
          throws RGuestException;

    @GET
    @Path(ACCOUNT_ID_PATH + POSTING_RULES_PATH)
    @PreAuthorize("hasPermission('Required', 'ReadAccounts')")
    PostingRuleDetailView getPostingRules(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @PathParam(ACCOUNT_ID) String accountId) throws RGuestException;

    @POST
    @CreatedOnSuccess
    @Path(ACCOUNT_ID_PATH + POSTING_RULES_PATH)
    @Validated(PostingRuleDetail.class)
    @PreAuthorize("hasPermission('Required', 'WriteAccounts')")
    PostingRuleDetail createPostingRule(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @PathParam(ACCOUNT_ID) String accountId,
          PostingRuleDetail postingRuleDetail) throws RGuestException;

    @GET
    @Path(ACCOUNT_ID_PATH + POSTING_RULES_PATH + POSTING_RULE_ID_PATH)
    @PreAuthorize("hasPermission('Required', 'ReadAccounts')")
    PostingRuleDetail getPostingRule(@PathParam(TENANT_ID) String tenantId, @PathParam(PROPERTY_ID) String propertyId,
          @PathParam(ACCOUNT_ID) String accountId, @PathParam(POSTING_RULE_ID) String postingRuleId)
          throws RGuestException;

    @PUT
    @Path(ACCOUNT_ID_PATH + POSTING_RULES_PATH + POSTING_RULE_ID_PATH)
    @Validated(PostingRuleDetail.class)
    @PreAuthorize("hasPermission('Required', 'WriteAccounts')")
    PostingRuleDetail updatePostingRule(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @PathParam(ACCOUNT_ID) String accountId,
          @PathParam(POSTING_RULE_ID) String postingRuleId, PostingRuleDetail postingRuleDetail) throws RGuestException;

    @PUT
    @Path(ACCOUNT_ID_PATH + POSTING_RULES_PATH)
    @PreAuthorize("hasPermission('Required', 'WriteAccounts')")
    List<PostingRuleDetail> updatePostingRules(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @PathParam(ACCOUNT_ID) String accountId,
          List<PostingRuleDetail> postingRuleDetails) throws RGuestException;

    @DELETE
    @Path(ACCOUNT_ID_PATH + POSTING_RULES_PATH + POSTING_RULE_ID_PATH)
    @PreAuthorize("hasPermission('Required', 'WriteAccounts')")
    void deletePostingRule(@PathParam(TENANT_ID) String tenantId, @PathParam(PROPERTY_ID) String propertyId,
          @PathParam(ACCOUNT_ID) String accountId, @PathParam(POSTING_RULE_ID) String postingRuleId)
          throws RGuestException;

    @POST
    @Path(ACCOUNT_ID_PATH + CHARGES_PATH)
    @Validated(Charge.class)
    @PreAuthorize("hasPermission('Required', 'WriteAccounts')")
    List<LineItemView> postCharge(@PathParam(TENANT_ID) String tenantId, @PathParam(PROPERTY_ID) String propertyId,
          @PathParam(ACCOUNT_ID) String accountId, @QueryParam("ignoreAuth") boolean ignoreAuth, Charge charge)
          throws RGuestException;

    @POST
    @Path(ACCOUNT_ID_PATH + POS_CHARGE_PATH)
    @Validated(Charge.class)
    @PreAuthorize("hasPermission('Required', 'WriteAccounts')")
    List<LineItemView> postPosCharge(@PathParam(TENANT_ID) String tenantId, @PathParam(PROPERTY_ID) String propertyId,
          @PathParam(ACCOUNT_ID) String accountId, @QueryParam("ignoreAuth") boolean ignoreAuth, PosCharge posCharge)
          throws RGuestException;

    @POST
    @Path(ACCOUNT_ID_PATH + BATCH_CHARGES_PATH)
    @PreAuthorize("hasPermission('Required', 'WriteAccounts')")
    PostChargesResponse postCharges(@PathParam(TENANT_ID) String tenantId, @PathParam(PROPERTY_ID) String propertyId,
          @PathParam(ACCOUNT_ID) String accountId, @QueryParam("ignoreAuth") boolean ignoreAuth,
          @QueryParam(GROUPED) boolean grouped, PostChargesRequest charges) throws RGuestException;

    // This doesn't get exposed as an endpoint yet.
    // It exists on the interface because we are
    // auto-wiring this Interface instead of the implementation,
    // and RecurringCharges needs to call this.

    // Not sure why it's written this way where you will have a public method without any CXF annotations.
    // Someday, we should fix this: VCTRS-42410
    List<LineItemView> postCharges(String tenantId, String propertyId, String accountId, boolean ignoreAuth,
          List<Charge> charges, Boolean isRecurring) throws RGuestException;

    @POST
    @CreatedOnSuccess
    @Path(ACCOUNT_ID_PATH + CREDIT_PATH)
    @Validated(Credit.class)
    @PreAuthorize("hasPermission('Required', 'AllowCredits')")
    LineItemView postCredit(@PathParam(TENANT_ID) String tenantId, @PathParam(PROPERTY_ID) String propertyId,
          @PathParam(ACCOUNT_ID) String accountId, Credit credit) throws RGuestException;

    @POST
    @CreatedOnSuccess
    @Path(ACCOUNT_ID_PATH + POS_CREDIT_PATH)
    @Validated(Credit.class)
    @PreAuthorize("hasPermission('Required', 'AllowCredits')")
    LineItemView postPosCredit(@PathParam(TENANT_ID) String tenantId, @PathParam(PROPERTY_ID) String propertyId,
          @PathParam(ACCOUNT_ID) String accountId, PosCredit posCredit) throws RGuestException;

    @POST
    @CreatedOnSuccess
    @Path(ACCOUNT_ID_PATH + PAYMENTS_PATH)
    @Validated(Payment.class)
    @PreAuthorize("hasPermission('Required', 'WriteAccounts')")
    List<LineItemView> postPayment(@PathParam(TENANT_ID) String tenantId, @PathParam(PROPERTY_ID) String propertyId,
          @PathParam(ACCOUNT_ID) String accountId, Payment payment,
          @DefaultValue("true") @QueryParam("reAuth") Boolean reAuth) throws RGuestException;

    @POST
    @CreatedOnSuccess
    @Path(ACCOUNT_ID_PATH + PAYMENTS_ASYNC_PATH)
    @Validated(Payment.class)
    @PreAuthorize("hasPermission('Required', 'WriteAccounts')")
    @Produces(MediaType.TEXT_PLAIN)
    String postPaymentAsync(@PathParam(TENANT_ID) String tenantId, @PathParam(PROPERTY_ID) String propertyId,
          @PathParam(ACCOUNT_ID) String accountId, Payment payment,
          @DefaultValue("true") @QueryParam("reAuth") Boolean reAuth) throws RGuestException;

    @GET
    @Path(ACCOUNT_ID_PATH + TASK_ID_PATH)
    @PreAuthorize("hasPermission('Required', 'WriteAccounts')")
    List<LineItemView> getPaymentResult(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @PathParam(TASK_ID) String taskId) throws Throwable;

    @POST
    @Path(PAYMENTS_PATH)
    @PreAuthorize("hasPermission('Required', 'ReadAccounts')")
    Map<String, List<TransactionReportItem>> findPaymentsForAccounts(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, List<String> accountIds) throws RGuestException;

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
          @PathParam(ACCOUNT_ID) String accountId, Payment payment) throws RGuestException;

    @POST
    @Path(ACCOUNT_ID_PATH + TRANSFER_FOLIO_LINES)
    @Validated(LineItemTransfer.class)
    @PreAuthorize("hasPermission('Required', 'WriteAccounts')")
    List<LineItemView> transferFolioLines(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @PathParam(ACCOUNT_ID) String accountId,
          LineItemTransfer transferInfo) throws RGuestException;

    @POST
    @Path(ACCOUNT_ID_PATH + TRANSFER_AMOUNT_PATH)
    @Validated(AmountTransfer.class)
    @PreAuthorize("hasPermission('Required', 'WriteAccounts')")
    List<LineItemView> transferAmountToAccount(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @PathParam(ACCOUNT_ID) String accountId,
          AmountTransfer transferInfo) throws RGuestException;

    @POST
    @Path(ACCOUNT_ID_PATH + ADJUSTMENT_PATH)
    @Validated(LineItemAdjustment.class)
    @PreAuthorize("hasPermission('Required', 'WriteAccounts')")
    LineItemView adjustment(@PathParam(TENANT_ID) String tenantId, @PathParam(PROPERTY_ID) String propertyId,
          @PathParam(ACCOUNT_ID) String accountId, LineItemAdjustment adjustmentInfo) throws RGuestException;

    @POST
    @Path(ACCOUNT_ID_PATH + CORRECTION_PATH)
    @Validated(LineItemAdjustment.class)
    @PreAuthorize("hasPermission('Required', 'WriteAccounts')")
    List<LineItemView> correction(@PathParam(TENANT_ID) String tenantId, @PathParam(PROPERTY_ID) String propertyId,
          @PathParam(ACCOUNT_ID) String accountId, LineItemAdjustment correctionInfo) throws RGuestException;

    @POST
    @CreatedOnSuccess
    @Path(ACCOUNT_ID_PATH + REFUND_PATH)
    @Validated(PaymentRefund.class)
    @PreAuthorize("hasPermission('Required', 'AllowRefunds')")
    LineItemView refundPayment(@PathParam(TENANT_ID) String tenantId, @PathParam(PROPERTY_ID) String propertyId,
          @PathParam(ACCOUNT_ID) String accountId, PaymentRefund paymentRefund) throws RGuestException;

    @POST
    @Path(ACCOUNT_ID_PATH + CHARGE_TAX_AMOUNT_PATH)
    @Validated(ChargeTaxAmountRequest.class)
    @PreAuthorize("hasPermission('Required', 'ReadAccounts')")
    ChargeTaxAmountInfo calculateChargeTaxAmount(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @PathParam(ACCOUNT_ID) String accountId,
          ChargeTaxAmountRequest request) throws RGuestException;

    @GET
    @Path(ACCOUNT_ID_PATH + PAYMENT_SETTINGS_PATH)
    @PreAuthorize("hasPermission('Required', 'ReadAccounts')")
    List<PaymentSetting> getPaymentSettings(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @PathParam(ACCOUNT_ID) String accountId) throws RGuestException;

    @POST
    @Path(PAYMENT_SETTINGS_PATH)
    @PreAuthorize("hasPermission('Required', 'ReadAccounts')")
    Map<String, List<PaymentInstrumentSetting>> getPaymentSettingsByAccounts(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, Set<String> accountIds) throws RGuestException;

    @POST
    @CreatedOnSuccess
    @Path(ACCOUNT_ID_PATH + PAYMENT_SETTINGS_PATH)
    @PreAuthorize("hasPermission('Required', 'WriteAccounts')")
    List<PaymentSetting> savePaymentSettings(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @PathParam(ACCOUNT_ID) String accountId,
          List<PaymentSetting> paymentSettings) throws RGuestException;

    @GET
    @Path(ACCOUNT_ID_PATH + TAX_EXEMPT_SETTINGS_BY_DATE_PATH)
    @PreAuthorize("hasPermission('Required', 'ReadAccounts')")
    TaxExemptSettingsByDate getTaxExemptSettingsByDate(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @PathParam(ACCOUNT_ID) String accountId) throws RGuestException;

    /**
     * Retrieve tax exempt settings for list of accounts by individual dates.
     *
     * @param tenantId   id of tenant where account exists
     * @param propertyId id of the property where the account exists
     * @param accountIds id of account where settings exist
     * @return Existing taxExemptSettings by account id
     */
    @POST
    @Path(TAX_EXEMPT_SETTINGS_BY_DATE_PATH)
    @PreAuthorize("hasPermission('Required', 'ReadAccounts')")
    Map<String, TaxExemptSettingsByDate> getTaxExemptSettingsByDateForAccounts(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, Set<String> accountIds) throws RGuestException;

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
    @Path(ACCOUNT_ID_PATH + TAX_EXEMPT_SETTINGS_BY_DATE_PATH)
    @Validated(TaxExemptSettingsByDate.class)
    @PreAuthorize("hasPermission('Required', 'WriteAccounts')")
    TaxExemptSettingsByDate saveTaxExemptSettingsByDate(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @PathParam(ACCOUNT_ID) String accountId,
          TaxExemptSettingsByDate taxExemptSettingsByDate) throws RGuestException;

    @GET
    @Path(ACCOUNT_ID_PATH + GROUP_COMPANY_TAX_EXEMPT_SETTINGS_PATH)
    @PreAuthorize("hasPermission('Required', 'ReadAccounts')")
    GroupCompanyTaxExemptSettings getGroupCompanyTaxExemptSettings(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @PathParam(ACCOUNT_ID) String accountId) throws RGuestException;

    @GET
    @Path(ACCOUNT_ID_PATH + GROUP_COMPANY_TAX_EXEMPT_SETTINGS_PATH + PRESET_PATH)
    @PreAuthorize("hasPermission('Required', 'ReadAccounts')")
    GroupCompanyTaxExemptSettings getV1GroupCompanyTaxExemptSettings(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @PathParam(ACCOUNT_ID) String accountId,
          @PathParam(PRESET) boolean preset) throws RGuestException;

    @POST
    @Path(ACCOUNT_ID_PATH + GROUP_COMPANY_TAX_EXEMPT_SETTINGS_PATH)
    @Validated(GroupCompanyTaxExemptSettings.class)
    @PreAuthorize("hasPermission('Required', 'WriteAccounts')")
    GroupCompanyTaxExemptSettings saveGroupCompanyTaxExemptSettings(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @PathParam(ACCOUNT_ID) String accountId,
          GroupCompanyTaxExemptSettings groupCompanyTaxExemptSettings) throws RGuestException;

    @POST
    @Path(ACCOUNT_ID_PATH + GROUP_COMPANY_TAX_EXEMPT_SETTINGS_PATH + PRESET_PATH)
    @Validated(GroupCompanyTaxExemptSettings.class)
    @PreAuthorize("hasPermission('Required', 'WriteAccounts')")
    GroupCompanyTaxExemptSettings saveV1GroupCompanyTaxExemptSettings(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @PathParam(ACCOUNT_ID) String accountId,
          GroupCompanyTaxExemptSettings groupCompanyTaxExemptSettings, @PathParam(PRESET) boolean isPreset)
          throws RGuestException;

    @Deprecated
    @GET
    @Path(SEARCH_PATH + SEARCH_TERM_PATH + REMAINING_PATH)
    @PreAuthorize("hasPermission('Required', 'ReadAccounts')")
    List<AccountSearchResult> search(@PathParam(TENANT_ID) String tenantId, @PathParam(PROPERTY_ID) String propertyId,
          @PathParam(SEARCH_TERM) String searchTerm, @PathParam(PATH) String optionalSearchParamsPath)
          throws RGuestException;

    @Deprecated
    @GET
    @Path(SEARCH_PATH + SEARCH_TERM_PATH)
    @PreAuthorize("hasPermission('Required', 'ReadAccounts')")
    List<AccountSearchResult> search(@PathParam(TENANT_ID) String tenantId, @PathParam(PROPERTY_ID) String propertyId,
          @PathParam(SEARCH_TERM) String searchTerm, @QueryParam(INCLUDE_CLOSED_ACCOUNTS) Boolean includeClosedAccounts)
          throws RGuestException;

    @GET
    @Path(SEARCH_PATH + SEARCH_TERM_PATH + PAGE_PATH)
    @PreAuthorize("hasPermission('Required', 'ReadAccounts')")
    SearchPage<AccountSearchResult> searchPage(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @PathParam(SEARCH_TERM) String searchTerm,
          @QueryParam(INCLUDE_CLOSED_ACCOUNTS) Boolean includeClosedAccounts, @QueryParam(PAGE) Integer page,
          @QueryParam(SIZE) Integer size) throws RGuestException;

    @GET
    @Path(ACCOUNT_ID_PATH + NON_INVOICED_PATH)
    @PreAuthorize("hasPermission('Required', 'ReadAccountsReceivable')")
    NonInvoicedARDetail getNonInvoicedARDetail(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @PathParam(ACCOUNT_ID) String accountId) throws RGuestException;

    /**
     * Retrieves the non-invoiced details of a COMPANY account based on the Transaction Ids
     *
     * @param tenantId         id of tenant where the COMPANY account exists
     * @param propertyId       id of the property
     * @param accountId        id of COMPANY account to retrieve non-invoiced details from
     * @param nonInvoiceReport class contains the transaction ids to retrieve non-invoiced details
     * @return Non-invoiced details for a COMPANY account
     */
    @POST
    @Path(ACCOUNT_ID_PATH + NON_INVOICED_PATH + LEDGER_TRANSACTION_ID)
    @Validated(NonInvoiceReport.class)
    @PreAuthorize("hasPermission('Required', 'ReadAccountsReceivable')")
    NonInvoicedARDetail getNonInvoicedARDetailByTransactionIds(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @PathParam(ACCOUNT_ID) String accountId,
          NonInvoiceReport nonInvoiceReport) throws RGuestException;

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
    @PreAuthorize(
          "hasPermission('Required', 'WriteAccountsReceivable') or hasPermission('Required', 'UseAccountsReceivable')")
    InvoiceView createInvoice(@PathParam(TENANT_ID) String tenantId, @PathParam(PROPERTY_ID) String propertyId,
          @PathParam(ACCOUNT_ID) String accountId, InvoiceRequest invoice) throws RGuestException;

    @GET
    @Path(ACCOUNT_ID_PATH + INVOICES_PATH + INVOICE_ID_PATH)
    @PreAuthorize("hasPermission('Required', 'ReadAccountsReceivable')")
    InvoiceView getInvoiceById(@PathParam(TENANT_ID) String tenantId, @PathParam(PROPERTY_ID) String propertyId,
          @PathParam(ACCOUNT_ID) String accountId, @PathParam(INVOICE_ID) String invoiceId,
          @QueryParam("") InvoiceOptionalParams optionalParams) throws RGuestException;

    @GET
    @Path(ACCOUNT_ID_PATH + INVOICES_PATH)
    @OkOnEmpty
    @PreAuthorize("hasPermission('Required', 'ReadAccountsReceivable')")
    List<InvoiceView> findInvoices(@PathParam(TENANT_ID) String tenantId, @PathParam(PROPERTY_ID) String propertyId,
          @PathParam(ACCOUNT_ID) String accountId, @QueryParam("") InvoiceFilteringOptionalParams params)
          throws RGuestException;

    @GET
    @Path(ACCOUNT_ID_PATH + INVOICE_REPORT_TYPE)
    @PreAuthorize("hasPermission('Required', 'ReadAccountsReceivable')")
    List<InvoiceBaseView> getInvoiceViews(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @PathParam(ACCOUNT_ID) String accountId,
          @PathParam(INVOICE_VIEW_TYPE) InvoiceViewType viewType, @QueryParam("includeClosed") boolean includeClosed)
          throws RGuestException;

    @POST
    @Path(ACCOUNT_ID_PATH + INVOICE_REPORT)
    @PreAuthorize("hasPermission('Required', 'ReadAccountsReceivable')")
    List<InvoiceBaseView> getInvoiceViews(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @PathParam(ACCOUNT_ID) String accountId, Set<String> invoiceIds)
          throws RGuestException;

    @GET
    @Path(ACCOUNT_ID_PATH + INVOICE_REPORT_START)
    @OkOnEmpty
    @PreAuthorize("hasPermission('Required', 'ReadAccountsReceivable')")
    InvoiceReportProgressView createInvoiceReport(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @PathParam(ACCOUNT_ID) String accountId,
          @QueryParam("tag") String tag, @QueryParam("includeClosed") String includeClosed) throws RGuestException;

    @Deprecated
    @GET
    @Path(ACCOUNT_ID_PATH + INVOICE_REPORT_POLL)
    @OkOnEmpty
    @PreAuthorize("hasPermission('Required', 'ReadAccountsReceivable')")
    InvoiceReportProgressView getInvoiceReportProgress(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @PathParam(ACCOUNT_ID) String accountId,
          @QueryParam("includeClosed") String includeClosed) throws RGuestException;

    @PUT
    @Path(ACCOUNT_ID_PATH + INVOICES_PATH + INVOICE_ID_PATH + INVOICE_ADD_ITEMS_PATH)
    @Validated(UpdateInvoiceLineItemsRequest.class)
    @PreAuthorize(
          "hasPermission('Required', 'WriteAccountsReceivable') or hasPermission('Required', 'UseAccountsReceivable')")
    InvoiceView addInvoiceLineItems(@PathParam(TENANT_ID) String tenantId, @PathParam(PROPERTY_ID) String propertyId,
          @PathParam(ACCOUNT_ID) String accountId, @PathParam(INVOICE_ID) String invoiceId,
          UpdateInvoiceLineItemsRequest lineItems) throws RGuestException;

    @PUT
    @Path(ACCOUNT_ID_PATH + INVOICES_PATH + INVOICE_ID_PATH + INVOICE_REMOVE_ITEMS_PATH)
    @Validated(UpdateInvoiceLineItemsRequest.class)
    @PreAuthorize(
          "hasPermission('Required', 'WriteAccountsReceivable') or hasPermission('Required', 'UseAccountsReceivable')")
    InvoiceView removeInvoiceLineItems(@PathParam(TENANT_ID) String tenantId, @PathParam(PROPERTY_ID) String propertyId,
          @PathParam(ACCOUNT_ID) String accountId, @PathParam(INVOICE_ID) String invoiceId,
          UpdateInvoiceLineItemsRequest lineItems) throws RGuestException;

    @PUT
    @Path(ACCOUNT_ID_PATH + INVOICES_PATH + INVOICE_ID_PATH + INVOICE_UPDATE_TERMS_PATH)
    @Validated(UpdateInvoiceTermsRequest.class)
    @PreAuthorize(
          "hasPermission('Required', 'WriteAccountsReceivable') or hasPermission('Required', 'UseAccountsReceivable')")
    InvoiceView updateInvoiceTerms(@PathParam(TENANT_ID) String tenantId, @PathParam(PROPERTY_ID) String propertyId,
          @PathParam(ACCOUNT_ID) String accountId, @PathParam(INVOICE_ID) String invoiceId,
          UpdateInvoiceTermsRequest terms) throws RGuestException;

    @PUT
    @Path(ACCOUNT_ID_PATH + INVOICES_PATH + INVOICE_ID_PATH + INVOICE_SET_INVOICE_SENT)
    @PreAuthorize(
          "hasPermission('Required', 'WriteAccountsReceivable') or hasPermission('Required', 'UseAccountsReceivable')")
    InvoiceView setInvoiceSent(@PathParam(TENANT_ID) String tenantId, @PathParam(PROPERTY_ID) String propertyId,
          @PathParam(ACCOUNT_ID) String accountId, @PathParam(INVOICE_ID) String invoiceId,
          @QueryParam("isEmail") boolean isEmail) throws RGuestException;

    @POST
    @CreatedOnSuccess
    @Path(ACCOUNT_ID_PATH + INVOICES_PATH + APPLY_PAYMENTS)
    @Validated(ApplyInvoicePaymentRequest.class)
    @PreAuthorize(
          "hasPermission('Required', 'WriteAccountsReceivable') or hasPermission('Required', 'UseAccountsReceivable')")
    List<InvoiceView> applyInvoicePayments(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @PathParam(ACCOUNT_ID) String accountId,
          ApplyInvoicePaymentRequest applyInvoicePaymentRequest) throws RGuestException;

    @POST
    @CreatedOnSuccess
    @Path(ACCOUNT_ID_PATH + INVOICES_PATH + INVOICE_ID_PATH + REFUND_PATH)
    @Validated(InvoicePaymentRefund.class)
    @PreAuthorize("hasPermission('Required', 'AllowRefunds')")
    InvoiceView refundInvoicePayment(@PathParam(TENANT_ID) String tenantId, @PathParam(PROPERTY_ID) String propertyId,
          @PathParam(ACCOUNT_ID) String accountId, @PathParam(INVOICE_ID) String invoiceId,
          InvoicePaymentRefund invoicePaymentRefund) throws RGuestException;

    @GET
    @Path(LEDGER_BALANCES_PATH)
    @PreAuthorize("hasPermission('Required', 'ReadAccounts')")
    Map<String, BigDecimal> getLedgerBalances(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, LedgerBalancesInfo ledgerBalancesInfo) throws RGuestException;

    @GET
    @Path(ACCOUNT_ID_PATH + VERIFY_CHECKOUT_PATH)
    @PreAuthorize("hasPermission('Required', 'ReadAccounts')")
    void verifyCheckout(@PathParam(TENANT_ID) String tenantId, @PathParam(PROPERTY_ID) String propertyId,
          @PathParam(ACCOUNT_ID) String accountId, @QueryParam("allowBalance") boolean allowBalance,
          @QueryParam(PAYMENT_METHOD_ID) String paymentMethodId) throws RGuestException;

    @GET
    @Path(NEXT_ACCOUNT_NUMBER_PATH)
    @PreAuthorize("hasPermission('Required', 'ReadAccounts')")
    NextAccountNumberInfo getNextArAccountNumber(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId) throws RGuestException;

    @GET
    @Path(CHECK_ACCOUNT_NUMBER_AVAILABILITY_PATH)
    @PreAuthorize("hasPermission('Required', 'ReadAccounts')")
    Boolean checkAccountNumberAvailability(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @PathParam(ACCOUNT_NUMBER) String accountNumber)
          throws RGuestException;

    @POST
    @Path(ACCOUNT_ID_PATH + AUTH_CARDS_ON_ACCOUNT_PATH)
    @PreAuthorize("hasPermission('Required', 'WriteAccounts')")
    List<PaymentInstrumentAuthStatus> authAllCardsOnAccount(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @PathParam(ACCOUNT_ID) String accountId,
          @QueryParam(START_DATE) @Deprecated LocalDate startDate, @QueryParam(END_DATE) @Deprecated LocalDate endDate)
          throws RGuestException;

    @POST
    @Path(FILTERED)
    CollectionResponse<AccountSummary> findAccounts(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, AccountsCollectionRequest collectionRequest)
          throws RGuestException;

    @GET
    @Path(ACCOUNT_ID_PATH + CLOSABLE_INFO)
    @PreAuthorize("hasPermission('Required', 'ReadAccounts')")
    AccountClosableInfo getAccountClosableInfo(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @PathParam(ACCOUNT_ID) String accountId)
          throws RGuestException;

    @POST
    @CreatedOnSuccess
    @Path(ACCOUNT_ID_PATH + PAYOFF_BALANCE_PATH)
    @PreAuthorize("hasPermission('Required', 'WriteAccounts')")
    void payOffBalance(@PathParam(TENANT_ID) String tenantId, @PathParam(PROPERTY_ID) String propertyId,
          @PathParam(ACCOUNT_ID) String accountId, PayoffBalanceRequest request) throws RGuestException;

    @POST
    @Path(INVENTORY_ALLOCATION)
    @PreAuthorize("hasPermission('Required', 'ReadAccounts')")
    Map<LocalDate, Map<String, InventoryAllocationDetails>> findInventoryItemAllocatedDetails(
          @PathParam(TENANT_ID) String tenantId, @PathParam(PROPERTY_ID) String propertyId,
          @QueryParam(START_DATE) LocalDate startDate, @QueryParam(END_DATE) LocalDate endDate, Set<String> itemIds)
          throws RGuestException;

    @GET
    @Path(ACCOUNT_ID_PATH + FREE_ALLOWANCE_PATH)
    @PreAuthorize("hasPermission('Required', 'ReadAccounts')")
    BigDecimal getFreeAllowanceCharges(@PathParam(TENANT_ID) String tenantId, @PathParam(PROPERTY_ID) String propertyId,
          @PathParam(ACCOUNT_ID) String accountId, @QueryParam(CALL_TYPE) String callType,
          @QueryParam(START_DATE_TIME) String startDateTime, @QueryParam(END_DATE_TIME) String endDateTime)
          throws RGuestException;

    @GET
    @Path(COMPANY_PROFILE_PATH + TENANT_DEFAULT_SETTINGS_PATH)
    @PreAuthorize("hasPermission('Required', 'WriteCompanyProfileDefaults')")
    TenantDefaultSettingsSummary getTenantDefaultSettings(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @PathParam(COMPANY_PROFILE_ID) String companyProfileId)
          throws RGuestException;

    @POST
    @Path(COMPANY_PROFILE_PATH + TENANT_DEFAULT_SETTINGS_PATH)
    @PreAuthorize("hasPermission('Required', 'WriteCompanyProfileDefaults')")
    TenantDefaultSettingsSummary createTenantDefaultSettings(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @PathParam(COMPANY_PROFILE_ID) String companyProfileId,
          TenantDefaultSettingsSummary tenantDefaultSettingsSummary) throws RGuestException;

    @PUT
    @Path(COMPANY_PROFILE_PATH + TENANT_DEFAULT_SETTINGS_PATH)
    @PreAuthorize("hasPermission('Required', 'WriteCompanyProfileDefaults')")
    TenantDefaultSettingsSummary updateTenantDefaultSettings(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @PathParam(COMPANY_PROFILE_ID) String companyProfileId,
          TenantDefaultSettingsSummary tenantDefaultSettingsSummary) throws RGuestException;

    @GET
    @Path(COMPANY_PROFILE_PATH + TENANT_DEFAULT_SETTINGS_JOB_STATUS_PATH)
    @PreAuthorize("hasPermission('Required', 'ReadAccounts')")
    AccountUpdateResponse findAccountReceivableJobStatus(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @PathParam(COMPANY_PROFILE_ID) String companyProfileId)
          throws RGuestException;

    @GET
    @Path(COMPANY_PROFILE_PATH + TENANT_DEFAULT_SETTINGS_PROPERTY_LISTINGS_PATH)
    @PreAuthorize("hasPermission('Required', 'WriteCompanyProfileDefaults')")
    List<TenantARPropertySettingStatus> getAccountReceivablePropertySettingStatus(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @PathParam(COMPANY_PROFILE_ID) String companyProfileId)
          throws RGuestException;

    @POST
    @Path(COMPANY_PROFILE_PATH + TENANT_DEFAULT_SETTINGS_APPLY_PATH)
    @PreAuthorize("hasPermission('Required', 'WriteCompanyProfileDefaults')")
    AccountUpdateResponse applyTenantDefaultSettings(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @PathParam(COMPANY_PROFILE_ID) String companyProfileId)
          throws RGuestException;

    @POST
    @CreatedOnSuccess
    @Path(NEW_PROPERTY_AR_ACCOUNT)
    void createNewPropertyARAccount(@PathParam(TENANT_ID) String tenantId, @PathParam(PROPERTY_ID) String propertyId)
          throws RGuestException;

    @PUT
    @Path(FOLIO_INVOICE_BY_PROFILE_ID)
    @PreAuthorize("hasPermission('Required', 'ReadProperties')")
    void updateProfileIdsInMultiFolioInvoice(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, UpdateFolioInvoicesRequest updateFolioInvoicesRequest)
          throws RGuestException;

    @POST
    @Path(INVOICES_PATH + PRINT_FOLIO)
    @Produces(MediaType.TEXT_HTML)
    @PreAuthorize("hasPermission('Required', 'ReadProperties')")
    String printFolioInvoice(@PathParam(TENANT_ID) String tenantId, @PathParam(PROPERTY_ID) String propertyId,
          FolioInvoiceRequest folioInvoiceRequest) throws RGuestException;

    @GET
    @Path(ACCOUNT_ID_PATH + FOLIO_INVOICE_SUMMARY)
    @PreAuthorize("hasPermission('Required', 'ReadProperties')")
    List<FolioInvoiceDetail> getFolioInvoiceSummary(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @PathParam(ACCOUNT_ID) String accountId) throws RGuestException;

    @GET
    @Path(FOLIO_INVOICE_ID_PATH)
    @PreAuthorize("hasPermission('Required', 'ReadProperties')")
    FolioInvoiceResponse getFolioInvoiceDetailFromFolioInvoiceNumber(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @PathParam("folioInvoiceId") String folioInvoiceId)
          throws RGuestException;

    @POST
    @Path(INVOICES_PATH + BATCH_FOLIO_PRINT)
    @PreAuthorize("hasPermission('Required', 'ReadProperties')")
    List<String> printBatchFolioInvoice(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, BatchFolioInvoiceRequest batchFolioInvoiceRequest)
          throws RGuestException;

    @POST
    @Path(INVOICES_PATH + FOLIO_EMAIL)
    @PreAuthorize("hasPermission('Required', 'ReadProperties')")
    void sendFolioInvoiceEmail(@PathParam(TENANT_ID) String tenantId, @PathParam(PROPERTY_ID) String propertyId,
          FolioInvoiceRequest folioInvoiceRequest) throws RGuestException;

    @POST
    @Path(INVOICES_PATH + BATCH_FOLIO_EMAIL)
    @PreAuthorize("hasPermission('Required', 'ReadProperties')")
    BatchFolioInvoiceResponse sendBatchFolioInvoiceEmail(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, BatchFolioInvoiceRequest batchFolioInvoiceRequest)
          throws RGuestException;

    @POST
    @Path(CANCEL_PAYMENTS)
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @PreAuthorize("hasPermission('Required', 'ReadAccounts')")
    ReservationCancellationResponse processCancellation(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, AccountStatementsRequest accountStatementsRequest)
          throws RGuestException;

    @POST
    @CreatedOnSuccess
    @Path(RESERVATION_IDS_TO_AUTHORIZE)
    Set<String> getReservationIdsToAuthorize(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, Set<String> accountIds) throws RGuestException;

    @POST
    @Path(ACCOUNT_ID_PATH + "/giftCard/load")
    @PreAuthorize("hasPermission('Required', 'WriteAccounts')")
    GiftCardResponse loadGiftCard(@PathParam(TENANT_ID) String tenantId, @PathParam(PROPERTY_ID) String propertyId,
          @PathParam(ACCOUNT_ID) String accountId, GiftCardRequest request) throws RGuestException;

    @POST
    @Path(ACCOUNT_ID_PATH + "/giftCard/issue")
    @PreAuthorize("hasPermission('Required', 'WriteAccounts')")
    GiftCardResponse issueGiftCard(@PathParam(TENANT_ID) String tenantId, @PathParam(PROPERTY_ID) String propertyId,
          @PathParam(ACCOUNT_ID) String accountId, GiftCardRequest request) throws RGuestException;

    @POST
    @Path(ACCOUNT_ID_PATH + PANTRY_ITEMS_CHARGE)
    @PreAuthorize("hasPermission('Required', 'WriteAccounts') and hasPermission('Required', 'AddPantry')")
    PantryTransactionResponse postPantryCharges(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @PathParam(ACCOUNT_ID) String accountId,
          @QueryParam("ignoreAuth") boolean ignoreAuth, @QueryParam("reAuth") boolean reAuth,
          @QueryParam(GROUPED) boolean grouped, PantryCharge pantryCharge) throws RGuestException;

    @POST
    @Path(ACCOUNT_ID_PATH + REDEEM_FOLIO_CHARGE)
    @PreAuthorize("hasPermission('Required', 'WriteAccounts')")
    List<String> redeemPlayerFolioItemsCharge(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @PathParam(ACCOUNT_ID) String accountId,
          CompTransaction compTransaction) throws RGuestException;

    @POST
    @Path(ACCOUNT_ID_PATH + REVERSE_REDEEM_CHARGE)
    List<String> completeReverseRedemption(@PathParam(TENANT_ID) String tenantId, @PathParam(PROPERTY_ID) String propertyId,
          @PathParam(ACCOUNT_ID) String accountId, ReverseRedemptionRequest reverseRedemptionRequest)
          throws RGuestException;

}
