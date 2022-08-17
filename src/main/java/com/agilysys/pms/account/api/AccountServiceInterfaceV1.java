/*
 * (C) 2015 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.api;

import static com.agilysys.common.constants.Constants.FILE;

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

import org.apache.cxf.jaxrs.ext.multipart.Attachment;
import org.apache.cxf.jaxrs.ext.multipart.Multipart;
import org.joda.time.LocalDate;
import org.springframework.data.domain.Page;

import com.agilysys.common.constants.Constants.HTTPRequestConstants;
import com.agilysys.common.model.BatchStatusResponse;
import com.agilysys.common.model.CancelBatchRequest;
import com.agilysys.common.model.PaymentSetting;
import com.agilysys.common.model.rate.OfferSnapshot;
import com.agilysys.platform.common.rguest.exception.RGuestException;
import com.agilysys.platform.schema.Validated;
import com.agilysys.pms.account.AccountUpdateResponse;
import com.agilysys.pms.account.api.params.InvoiceFilteringOptionalParams;
import com.agilysys.pms.account.api.params.InvoiceOptionalParams;
import com.agilysys.pms.account.api.params.InvoicePaymentRequest;
import com.agilysys.pms.account.model.ARDepositView;
import com.agilysys.pms.account.model.AccountClosableInfo;
import com.agilysys.pms.account.model.AccountDetail;
import com.agilysys.pms.account.model.AccountSearchResult;
import com.agilysys.pms.account.model.AccountStatementResponse;
import com.agilysys.pms.account.model.AccountStatementsRequest;
import com.agilysys.pms.account.model.AccountStatus;
import com.agilysys.pms.account.model.AccountSummary;
import com.agilysys.pms.account.model.AccountsCollectionRequest;
import com.agilysys.pms.account.model.AccountsReceivableSettings;
import com.agilysys.pms.account.model.AmountTransfer;
import com.agilysys.pms.account.model.ApplyInvoiceDepositPaymentRequest;
import com.agilysys.pms.account.model.ApplyInvoicePaymentRequest;
import com.agilysys.pms.account.model.BatchDepositCollectionRequest;
import com.agilysys.pms.account.model.BatchDepositCollectionResponse;
import com.agilysys.pms.account.model.BatchFolioInvoiceRequest;
import com.agilysys.pms.account.model.BatchFolioInvoiceResponse;
import com.agilysys.pms.account.model.BatchPostCC;
import com.agilysys.pms.account.model.BatchPreAuthRequest;
import com.agilysys.pms.account.model.Charge;
import com.agilysys.pms.account.model.ChargeTaxAmountInfo;
import com.agilysys.pms.account.model.ChargeTaxAmountRequest;
import com.agilysys.pms.account.model.CheckAllowanceResponse;
import com.agilysys.pms.account.model.CompTransaction;
import com.agilysys.pms.account.model.CompanyInfo;
import com.agilysys.pms.account.model.CompleteReverseRedemptionRequestAyncJobId;
import com.agilysys.pms.account.model.CreateAccountSummary;
import com.agilysys.pms.account.model.Credit;
import com.agilysys.pms.account.model.DepositPaymentInfo;
import com.agilysys.pms.account.model.DisputedARLedgerTransaction;
import com.agilysys.pms.account.model.EligibleFolioLineItems;
import com.agilysys.pms.account.model.EstimatedChargesWrapper;
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
import com.agilysys.pms.account.model.IGTransactionHistoryFields;
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
import com.agilysys.pms.account.model.MailedInvoice;
import com.agilysys.pms.account.model.MultipleAccountPaymentRequestAsyncJobId;
import com.agilysys.pms.account.model.MultiplePayment;
import com.agilysys.pms.account.model.MultiplePaymentResponse;
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
import com.agilysys.pms.account.model.PostPosChargesRequest;
import com.agilysys.pms.account.model.PostPosCreditRequest;
import com.agilysys.pms.account.model.PostingRuleDetail;
import com.agilysys.pms.account.model.PostingRuleDetailView;
import com.agilysys.pms.account.model.RecurringChargeView;
import com.agilysys.pms.account.model.ReleaseAllAuthRequest;
import com.agilysys.pms.account.model.ReservationCancellationResponse;
import com.agilysys.pms.account.model.ReverseRedemptionRequest;
import com.agilysys.pms.account.model.ReverseRedemptionResponse;
import com.agilysys.pms.account.model.StatementHistory;
import com.agilysys.pms.account.model.TaxExemptSettingsByDate;
import com.agilysys.pms.account.model.TenantARPropertySettingStatus;
import com.agilysys.pms.account.model.TenantDefaultSettingsSummary;
import com.agilysys.pms.account.model.TransactionItem;
import com.agilysys.pms.account.model.TransactionReportItem;
import com.agilysys.pms.account.model.UpdateFolioInvoicesRequest;
import com.agilysys.pms.account.model.UpdateInvoiceLineItemsRequest;
import com.agilysys.pms.account.model.UpdateInvoiceTermsRequest;
import com.agilysys.pms.account.model.ViewFolioRequest;
import com.agilysys.pms.account.model.invoice.InvoicePaymentReport;
import com.agilysys.pms.account.model.invoice.InvoiceViewType;
import com.agilysys.pms.account.model.invoice.base.InvoiceBaseView;
import com.agilysys.pms.common.api.annotation.CreatedOnSuccess;
import com.agilysys.pms.common.api.annotation.OkOnEmpty;
import com.agilysys.pms.common.batchdistributor.domain.BatchDistributorResult;
import com.agilysys.pms.common.document.model.DocumentDetails;
import com.agilysys.pms.common.document.model.DocumentRequest;
import com.agilysys.pms.common.model.CollectionResponse;
import com.agilysys.pms.common.model.DeserializablePage;
import com.agilysys.pms.common.model.ReceiptImageResponse;
import com.agilysys.pms.common.security.Permission;
import com.agilysys.pms.common.security.Requires;
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
    String SPLIT_BY_SOURCE_ACCOUNT = "splitBySourceAccount";
    String GROUP_ID = "groupId";
    String ACCOUNT_ID_PATH = "/{" + ACCOUNT_ID + "}";
    String ACCOUNT_NUMBER = "accountNumber";
    String ACCOUNT_STATUS = "accountStatus";
    String ACCOUNT_TYPE = "accountType";
    String ACCOUNT_STATUS_PATH = "/status/{" + ACCOUNT_STATUS + "}";
    String ACCOUNTS_RECEIVABLE_SETTINGS_PATH = "/accountsReceivableSettings";
    String ADJUSTMENT_PATH = "/adjustment";
    String APPLY_DEPOSIT_PAYMENTS = "/applyDepositPayments";
    String APPLY_PAYMENTS = "/applyPayments";
    String AR_DEPOSIT_BALANCE = "/arDepositBalance";
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
    String DEPOSIT_FOLIO_PATH = "/depositFolio";
    String END_DATE = "endDate";
    String END_DATE_TIME = "endDateTime";
    String FILTERED = "/filtered";
    String FOLIO_PATH = "/folios";
    String FOLIO_DETAIL_VIEW_PATH = "/folios2";
    String FOLIO_DETAIL_PATH = "/foliosDetail";
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
    String GROUPED_FOLIOS_LINE_ITEMS = "/groupedFoliosLineItems";
    String ID = "id";
    String INCLUDE_CLOSED_ACCOUNTS = "includeClosedAccounts";
    String INCLUDE_HOLD_ACCOUNTS = "includeHoldAccounts";
    String INVOICE_ADD_ITEMS_PATH = "/addItems";
    String INVOICE_ID = "invoiceId";
    String INVOICE_ID_PATH = "/{" + INVOICE_ID + "}";
    String INVOICES_PATH = "/invoices";
    String BY_ACCOUNT_PATH = INVOICES_PATH + "/byAccount";
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
    String MULTIPLE_CHARGES = "/multipleCharges";
    String MULTIPLE_PAYMENTS_PATH = "/multiplePaymentsPath";
    String MULTIPLE_PAYMENTS = "/multiplePayments";
    String MULTIPLE_PAYMENTS_ASYNC_PATH = "/multiplePaymentsAsync";
    String NEXT_ACCOUNT_NUMBER_PATH = "/nextAccountNumber";
    String NON_INVOICED_PATH = "/nonInvoicedDetails";
    String PAGE_PATH = "/page";
    String PATH = "path";
    String PAYMENT_SETTINGS_PATH = "/paymentSettings";
    String PAYMENTS_PATH = "/payments";
    String POST_PAYMENT_CANCELLATION = "/postPaymentForCancellation";
    String BATCH_PRE_AUTH = "/batchPreAuth";
    String PAYMENTS_ASYNC_PATH = "/paymentsAsync";
    String DEPOSITS_PATH = "/deposits";
    String PAYOFF_BALANCE_PATH = "/payOffBalance";
    String POS_CHARGE_PATH = "/posCharge";
    String POS_CREDIT_PATH = "/posCredit";
    String POS_CREDITS_PATH = "/posCredits";
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
    String REMIT_TO = "/remitTo";
    String MULTIPLE_REFERENCES_ID_PATH = "/references/{" + REFERENCE_ID + "}";
    String RESERVATION_ACCOUNT_AR_PAYMENT_ACCOUNTS = "/reservationAccountWithARPaymentAccounts";
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
    String STATEMENT_HISTORY = "/statementHistory";
    String TASK_ID = "taskId";
    String TASK_ID_PATH = "/tasks/{" + TASK_ID + "}";
    String TAX_EXEMPT_SETTINGS_BY_DATE_PATH = "/taxExemptSettingsByDate";
    String TRANSFER_PATH = "/transfer";
    String TRANSFER_FOLIO_LINES = "/transferFolioLines";
    String TRANSFER_OFFER_CHARGES = "/transferOfferCharges";
    String TRANSFER_HISTORY = "/transferHistory";
    String TRANSFER_HISTORY_ID = "transferHistoryId";
    String LEDGER_TRANSACTION_ID = "/ledgerTransactionIds";
    String TRANSFER_HISTORY_ID_PATH = "/{" + TRANSFER_HISTORY_ID + "}";
    String TYPES_PATH = "types";
    String FOLIO_EMAIL_LAST_SENT = "folioEmailLastSent";
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
    String FOLIO_LINE_ITEM_ID = "folioLineItemId";
    String FOLIO_LINE_ITEM = "/folioLineItem/{" + FOLIO_LINE_ITEM_ID + "}";
    String UPLOAD_COMPANY_AR_DOCUMENTS = "/document/uploadCompanyARDocuments/{accountId}";
    String DELETE_COMPANY_AR_DOCUMENTS = "/document/deleteCompanyARDocuments";
    String LEDGER_TRANSACTION = "ledgerTransactionId";
    String LEDGER_TRANSACTION_IDS = "/ledgerTransactionId/{" + LEDGER_TRANSACTION + "}";

    String AUTHORIZER_CODE = "authorizerCode";
    String CODE = "/{" + AUTHORIZER_CODE + "}";
    String AUTHORIZERD_FOLIO_ITEMS = "/authorizedFolioItems" + CODE;
    String REDEEM_FOLIO_CHARGE = "/redeemFolio";
    String REVERSE_REDEEM_CHARGE = "/reverseRedeemFolio";
    String BULK = "/bulk";
    String BATCH_DEPOSIT_COLLECTION_JOB_PATH = "/batchDepositCollectionJob";
    String BATCH_DEPOSIT_COLLECTION_JOB_STATUS_PATH = "/batchDepositCollectionJobStatus";
    String BATCH_DEPOSIT_COLLECTION_JOB_CANCEL_PATH = "/batchDepositCollectionJobCancel";
    String JOB_ID = "jobId";
    String DATE = "date";
    String DATE_PATH = "/{" + DATE + "}";
    String AR_DISPUTE_PATH = "/arDisputedLedgerTransaction";
    String PAGE = "page";
    String SIZE = "size";
    String ALLOWANCE = "/allowance";
    String RECEIPT_IMAGE_RESPOME = FOLIO_LINE_ITEM + "/receiptTextImage";
    String RECEIPT_IMAGE_RESPONCE_GROUP = LEDGER_TRANSACTION_IDS + "/receiptTextImage";
    String BATCH_CREDITS_PATH = "/batchCredits";
    String ACCOUNTS_BY_IDS = "/accountsByIds";
    String RELEASE_ALL_AUTH = "/releaseAllAuthorizations";
    String ACCOUNT_TYPE_PATH = "/accountType/{"+ACCOUNT_TYPE +"}";
    String SEARCH_BY_UPDATED_DATE = ACCOUNT_TYPE_PATH + "/searchByUpdatedDate";
    String VALIDATE_FOR_REFERENCE_NUMBER = "/validateForReferenceNumber";
    String CANCELLATION = "/cancellation";
    String ESTIMATE_CHARGE_AMOUNT_FOR_DEPOSIT_POLICY = "/estimateChargeAmountForDepositCalculation";

    @GET
    @Requires(Permission.READ_ACCOUNTS)
    List<AccountSummary> getAccounts(@PathParam(TENANT_ID) String tenantId, @PathParam(PROPERTY_ID) String propertyId,
          @QueryParam("accountType") String accountTypes, @QueryParam("accountStatus") String accountStatuses)
          throws RGuestException;

    @POST
    @Path(SEARCH_BY_UPDATED_DATE)
    @Requires(Permission.READ_ACCOUNTS)
    List<AccountSummary> getAccountsByUpdatedTimeRange(@PathParam(TENANT_ID) String tenantId, @PathParam(PROPERTY_ID) String propertyId,
          @PathParam("accountType") String accountTypes,
          @QueryParam(START_DATE_TIME) String startDateTime,
          @QueryParam(END_DATE_TIME) String endDateTime,
          Set<String> reservationIdsToExclude) throws RGuestException;

    @Deprecated
    @GET
    @Path(REFERENCE_ID_PATH)
    @Requires(Permission.READ_ACCOUNTS)
    AccountSummary getAccountByReferenceId(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @PathParam(REFERENCE_ID) String referenceId)
          throws RGuestException;

    @GET
    @Path(MULTIPLE_REFERENCES_ID_PATH)
    @Requires(Permission.READ_ACCOUNTS)
    List<AccountSummary> getAccountsByReferenceId(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @QueryParam(ACCOUNT_TYPE) String accountType,
          @PathParam(REFERENCE_ID) String referenceId) throws RGuestException;

    @GET
    @Path(ACCOUNT_ID_PATH)
    @Requires(Permission.READ_ACCOUNTS)
    AccountSummary getAccount(@PathParam(TENANT_ID) String tenantId, @PathParam(PROPERTY_ID) String propertyId,
          @PathParam(ACCOUNT_ID) String accountId) throws RGuestException;

    @GET
    @Path(LODGING_PATH)
    @Requires(Permission.READ_ACCOUNTS)
    LodgingInformation getLodgingInformationForAccountById(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @PathParam(ACCOUNT_ID) String accountId) throws RGuestException;

    @GET
    @Path(TYPES_PATH)
    @Requires(Permission.READ_ACCOUNTS)
    List<String> getAccountTypes(@PathParam(TENANT_ID) String tenantId, @PathParam(PROPERTY_ID) String propertyId)
          throws RGuestException;

    @POST
    @Path(ACCOUNTS_BY_IDS)
    @Requires(Permission.READ_ACCOUNTS)
    List<AccountSummary> getAccountsByIds(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, Set<String> accountIds) throws RGuestException;

    @GET
    @Path(STATUSES_PATH)
    @Requires(Permission.READ_ACCOUNTS)
    List<String> getAccountStatuses(@PathParam(TENANT_ID) String tenantId, @PathParam(PROPERTY_ID) String propertyId)
          throws RGuestException;

    @GET
    @Path(ACCOUNT_ID_PATH + "/details")
    @Requires(Permission.READ_ACCOUNTS)
    AccountDetail getAccountDetails(@PathParam(TENANT_ID) String tenantId, @PathParam(PROPERTY_ID) String propertyId,
          @PathParam(ACCOUNT_ID) String accountId) throws RGuestException;

    @GET
    @Path(ACCOUNT_ID_PATH + RESERVATION_ACCOUNT_AR_PAYMENT_ACCOUNTS)
    @Requires(Permission.READ_ACCOUNTS)
    Map<String, AccountDetail> getReservationAccountWithARAccounts(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @PathParam(ACCOUNT_ID) String reservationAccountId)
          throws RGuestException;

    @POST
    @CreatedOnSuccess
    @Validated(CreateAccountSummary.class)
    @Requires(Permission.WRITE_ACCOUNTS)
    AccountDetail createAccount(@PathParam(TENANT_ID) String tenantId, @PathParam(PROPERTY_ID) String propertyId,
          CreateAccountSummary account) throws RGuestException;

    @GET
    @Path(ACCOUNT_ID_PATH + AUTHORIZERD_FOLIO_ITEMS)
    EligibleFolioLineItems getEligibleFolioItemsByAuthorizerDetails(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @PathParam(ACCOUNT_ID) String accountId,
          @PathParam(AUTHORIZER_CODE) String authorizerCode, @QueryParam("maxFolioLineItems") Integer maxFolioLineItems)
          throws RGuestException;

    @PUT
    @Path(ACCOUNT_ID_PATH + ACCOUNT_STATUS_PATH)
    @OkOnEmpty
    @Requires(Permission.WRITE_ACCOUNTS)
    void updateAccountStatus(@PathParam(TENANT_ID) String tenantId, @PathParam(PROPERTY_ID) String propertyId,
          @PathParam(ACCOUNT_ID) String accountId, @PathParam(ACCOUNT_STATUS) String accountStatus,
          @QueryParam("dissociatePantryHouseAccount") boolean dissociatePantryHouseAccount) throws RGuestException;

    @PUT
    @Path(ACCOUNT_ID_PATH + ACCOUNTS_RECEIVABLE_SETTINGS_PATH)
    @Requires(Permission.WRITE_ACCOUNTS)
    AccountSummary updateAccountsReceivableSettings(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @PathParam(ACCOUNT_ID) String accountId,
          AccountsReceivableSettings accountsReceivableSettings) throws RGuestException;

    @POST
    @Path(ACCOUNT_BALANCES_PATH)
    @Requires(Permission.READ_ACCOUNTS)
    AccountStatementResponse getAccountBalances(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, AccountStatementsRequest accountStatementsRequest)
          throws RGuestException;

    @GET
    @Path(ACCOUNT_ID_PATH + FOLIO_PATH)
    @Requires(Permission.READ_ACCOUNTS)
    List<FolioDetail> getFolios(@PathParam(TENANT_ID) String tenantId, @PathParam(PROPERTY_ID) String propertyId,
          @PathParam(ACCOUNT_ID) String accountId, @QueryParam("") GetFoliosOptionalParameters optionalParameters)
          throws RGuestException;

    @GET
    @Path(ACCOUNT_ID_PATH + GROUPED_FOLIOS_LINE_ITEMS)
    @Requires(Permission.READ_ACCOUNTS)
    List<FolioDetail> getAllFolioLineItems(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @PathParam(ACCOUNT_ID) String accountId,
          @QueryParam("") GetFoliosOptionalParameters optionalParameters) throws RGuestException;

    @GET
    @Path(ACCOUNT_ID_PATH + FOLIO_DETAIL_PATH)
    @Requires(Permission.READ_ACCOUNTS)
    List<FolioDetail> getFoliosDetailList(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @PathParam(ACCOUNT_ID) String accountId,
          @QueryParam("") GetFoliosOptionalParameters optionalParameters) throws RGuestException;

    @GET
    @Path(ACCOUNT_ID_PATH + DEPOSIT_FOLIO_PATH)
    @Requires(Permission.READ_ACCOUNTS)
    FolioDetail getDepositFolio(@PathParam(TENANT_ID) String tenantId, @PathParam(PROPERTY_ID) String propertyId,
          @PathParam(ACCOUNT_ID) String accountId, @QueryParam("") GetFoliosOptionalParameters optionalParameters)
          throws RGuestException;

    @POST
    @Path(FOLIO_PATH)
    @Requires(Permission.READ_ACCOUNTS)
    Map<String, List<FolioDetail>> getFoliosForAccounts(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, Set<String> accountIds) throws RGuestException;

    @POST
    @Path(TOTAL_SPENT_PATH)
    @Requires(Permission.READ_ACCOUNTS)
    Map<String, BigDecimal> getTotalSpentForAccounts(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, Set<String> accountIds) throws RGuestException;

    @POST
    @Path(ACCOUNT_ID_PATH + FOLIO_PATH + FOLIO_ID_PATH)
    @Requires(Permission.READ_ACCOUNTS)
    @Validated(ViewFolioRequest.class)
    Page<FolioViewLineItem> viewFolio(@PathParam(TENANT_ID) String tenantId, @PathParam(PROPERTY_ID) String propertyId,
          @PathParam(ACCOUNT_ID) String accountId, @PathParam(FOLIO_ID) String folioId,
          ViewFolioRequest viewfoliosRequest) throws RGuestException;

    /**
     * For integration-service, a wrapper of Page<FolioViewLineItem> viewFolio(...) to workaround
     * org.springframework.data.domain.Page<T> deserialization errors. This is to be consumed by APIs, so returning a
     * Java.util.List instead of com.agilysys.pms.common.model.DeserializablePage (pmscommon impl of Spring data
     * Page<T>)
     */
    @POST
    @Path(ACCOUNT_ID_PATH + FOLIO_DETAIL_VIEW_PATH + FOLIO_ID_PATH)
    @Requires(Permission.READ_ACCOUNTS)
    @Validated(ViewFolioRequest.class)
    List<FolioViewLineItem> getFolioDetailView(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @PathParam(ACCOUNT_ID) String accountId,
          @PathParam(FOLIO_ID) String folioId, ViewFolioRequest viewfoliosRequest) throws RGuestException;

    @GET
    @Path(ACCOUNT_ID_PATH + FOLIO_BALANCES_PATH)
    @Requires(Permission.READ_ACCOUNTS)
    List<FolioBalance> getFolioBalances(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @PathParam(ACCOUNT_ID) String accountId) throws RGuestException;

    @POST
    @CreatedOnSuccess
    @Path(ACCOUNT_ID_PATH + FOLIO_PATH)
    @Validated(FolioSummary.class)
    @Requires(Permission.WRITE_ACCOUNTS)
    FolioSummary createFolio(@PathParam(TENANT_ID) String tenantId, @PathParam(PROPERTY_ID) String propertyId,
          @PathParam(ACCOUNT_ID) String accountId, FolioSummary folio) throws RGuestException;

    @POST
    @CreatedOnSuccess
    @Path(ACCOUNT_ID_PATH + BATCH_FOLIO_PATH)
    @Requires(Permission.WRITE_ACCOUNTS)
    List<FolioSummary> createFolios(@PathParam(TENANT_ID) String tenantId, @PathParam(PROPERTY_ID) String propertyId,
          @PathParam(ACCOUNT_ID) String accountId, List<FolioSummary> folios) throws RGuestException;

    @GET
    @Path(ACCOUNT_ID_PATH + FOLIO_PATH + FOLIO_ID_PATH)
    @Produces(MediaType.APPLICATION_JSON)
    @Requires(Permission.READ_ACCOUNTS)
    FolioDetail getFolio(@PathParam(TENANT_ID) String tenantId, @PathParam(PROPERTY_ID) String propertyId,
          @PathParam(ACCOUNT_ID) String accountId, @PathParam(FOLIO_ID) String folioId) throws RGuestException;

    @PUT
    @Path(ACCOUNT_ID_PATH + FOLIO_PATH + FOLIO_ID_PATH)
    @Validated(FolioSummary.class)
    @Requires(Permission.WRITE_ACCOUNTS)
    FolioSummary updateFolio(@PathParam(TENANT_ID) String tenantId, @PathParam(PROPERTY_ID) String propertyId,
          @PathParam(ACCOUNT_ID) String accountId, @PathParam(FOLIO_ID) String folioId, FolioSummary folio)
          throws RGuestException;

    @PUT
    @Path(ACCOUNT_ID_PATH + FOLIO_PATH)
    @Requires(Permission.WRITE_ACCOUNTS)
    List<FolioSummary> updateFolios(@PathParam(TENANT_ID) String tenantId, @PathParam(PROPERTY_ID) String propertyId,
          @PathParam(ACCOUNT_ID) String accountId, List<FolioSummary> folios) throws RGuestException;

    @DELETE
    @Path(ACCOUNT_ID_PATH + FOLIO_PATH + FOLIO_ID_PATH)
    @Requires(Permission.WRITE_ACCOUNTS)
    void deleteFolio(@PathParam(TENANT_ID) String tenantId, @PathParam(PROPERTY_ID) String propertyId,
          @PathParam(ACCOUNT_ID) String accountId, @PathParam(FOLIO_ID) String folioId) throws RGuestException;

    @PUT
    @Path(FOLIO_EMAIL_LAST_SENT)
    @Requires(Permission.WRITE_ACCOUNTS)
    Map<String, List<FolioSummary>> updateFolioEmailLastSent(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, Map<String, List<String>> accountIdToFolios)
          throws RGuestException;

    @POST
    @Path(TRANSFER_HISTORY)
    @Requires(Permission.READ_ACCOUNTS)
    Map<String, LedgerTransactionTransferDetail> getTransactionHistory(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, List<String> ledgerTransactionHistoryId) throws RGuestException;

    @GET
    @Path(ACCOUNT_ID_PATH + POSTING_RULES_PATH)
    @Requires(Permission.READ_ACCOUNTS)
    PostingRuleDetailView getPostingRules(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @PathParam(ACCOUNT_ID) String accountId) throws RGuestException;

    @POST
    @CreatedOnSuccess
    @Path(ACCOUNT_ID_PATH + POSTING_RULES_PATH)
    @Validated(PostingRuleDetail.class)
    @Requires(Permission.WRITE_ACCOUNTS)
    PostingRuleDetail createPostingRule(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @PathParam(ACCOUNT_ID) String accountId,
          PostingRuleDetail postingRuleDetail) throws RGuestException;

    @GET
    @Path(ACCOUNT_ID_PATH + POSTING_RULES_PATH + POSTING_RULE_ID_PATH)
    @Requires(Permission.READ_ACCOUNTS)
    PostingRuleDetail getPostingRule(@PathParam(TENANT_ID) String tenantId, @PathParam(PROPERTY_ID) String propertyId,
          @PathParam(ACCOUNT_ID) String accountId, @PathParam(POSTING_RULE_ID) String postingRuleId)
          throws RGuestException;

    @PUT
    @Path(ACCOUNT_ID_PATH + POSTING_RULES_PATH + POSTING_RULE_ID_PATH)
    @Validated(PostingRuleDetail.class)
    @Requires(Permission.WRITE_ACCOUNTS)
    PostingRuleDetail updatePostingRule(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @PathParam(ACCOUNT_ID) String accountId,
          @PathParam(POSTING_RULE_ID) String postingRuleId, PostingRuleDetail postingRuleDetail) throws RGuestException;

    @PUT
    @Path(ACCOUNT_ID_PATH + POSTING_RULES_PATH)
    @Requires(Permission.WRITE_ACCOUNTS)
    List<PostingRuleDetail> updatePostingRules(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @PathParam(ACCOUNT_ID) String accountId,
          List<PostingRuleDetail> postingRuleDetails) throws RGuestException;

    @POST
    @CreatedOnSuccess
    @Path(ACCOUNT_ID_PATH + POSTING_RULES_PATH + "/fromTemplate")
    @Requires(Permission.WRITE_ACCOUNTS)
    void updateCompRoutingRulesAndLineItems(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @PathParam(ACCOUNT_ID) String accountId,
          List<OfferSnapshot> offerSnapshots) throws RGuestException;

    @DELETE
    @Path(ACCOUNT_ID_PATH + POSTING_RULES_PATH + POSTING_RULE_ID_PATH)
    @Requires(Permission.WRITE_ACCOUNTS)
    void deletePostingRule(@PathParam(TENANT_ID) String tenantId, @PathParam(PROPERTY_ID) String propertyId,
          @PathParam(ACCOUNT_ID) String accountId, @PathParam(POSTING_RULE_ID) String postingRuleId)
          throws RGuestException;

    @DELETE
    @Path(ACCOUNT_ID_PATH + POSTING_RULES_PATH)
    @Requires(Permission.WRITE_ACCOUNTS)
    void deleteCompOfferPostingRule(@PathParam(TENANT_ID) String tenantId, @PathParam(PROPERTY_ID) String propertyId,
          @PathParam(ACCOUNT_ID) String accountId) throws RGuestException;

    @POST
    @Path(ACCOUNT_ID_PATH + CHARGES_PATH)
    @Validated(Charge.class)
    @Requires(Permission.WRITE_ACCOUNTS)
    List<LineItemView> postCharge(@PathParam(TENANT_ID) String tenantId, @PathParam(PROPERTY_ID) String propertyId,
          @PathParam(ACCOUNT_ID) String accountId, @QueryParam("ignoreAuth") boolean ignoreAuth, Charge charge)
          throws RGuestException;

    // Account tax facts are modified to exclude residency tax during cancellation.
    // DO NOT use this for normal charge posting
    @POST
    @Path(ACCOUNT_ID_PATH + CHARGES_PATH + CANCELLATION)
    @Validated(Charge.class)
    @Requires(Permission.WRITE_ACCOUNTS)
    List<LineItemView> postCancellationCharge(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @PathParam(ACCOUNT_ID) String accountId,
          @QueryParam("ignoreAuth") boolean ignoreAuth, Charge charge) throws RGuestException;

    @POST
    @Path(ACCOUNT_ID_PATH + POS_CHARGE_PATH)
    @Validated(Charge.class)
    @Requires(Permission.WRITE_ACCOUNTS)
    List<LineItemView> postPosCharge(@PathParam(TENANT_ID) String tenantId, @PathParam(PROPERTY_ID) String propertyId,
          @PathParam(ACCOUNT_ID) String accountId, @QueryParam("ignoreAuth") boolean ignoreAuth, PosCharge posCharge)
          throws RGuestException;

    @POST
    @Path(ACCOUNT_ID_PATH + BATCH_CHARGES_PATH)
    @Requires(Permission.WRITE_ACCOUNTS)
    PostChargesResponse postCharges(@PathParam(TENANT_ID) String tenantId, @PathParam(PROPERTY_ID) String propertyId,
          @PathParam(ACCOUNT_ID) String accountId, @QueryParam("ignoreAuth") boolean ignoreAuth,
          @QueryParam(GROUPED) boolean grouped, PostChargesRequest charges) throws RGuestException;

    @POST
    @Path(ACCOUNT_ID_PATH + "/batchPosCharges")
    @Requires(Permission.WRITE_ACCOUNTS)
    PostChargesResponse postPosCharges(@PathParam(TENANT_ID) String tenantId, @PathParam(PROPERTY_ID) String propertyId,
          @PathParam(ACCOUNT_ID) String accountId, @QueryParam("ignoreAuth") boolean ignoreAuth,
          @QueryParam(GROUPED) boolean grouped, PostPosChargesRequest charges) throws RGuestException;


    @GET
    @Path(ACCOUNT_ID_PATH + "/authValidationCashPayment")
    @Requires(Permission.READ_ACCOUNTS)
    boolean authValidationForCashPayment(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @PathParam(ACCOUNT_ID) String accountId) throws RGuestException;

    @POST
    @Path("/authValidationCashPayment")
    @Requires(Permission.READ_ACCOUNTS)
    Map<String, Boolean> authValidationForCashPayments(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, Set<String> accountIds) throws RGuestException;

    // This doesn't get exposed as an endpoint yet.
    // It exists on the interface because we are
    // auto-wiring this Interface instead of the implementation,
    // and RecurringCharges needs to call this.

    // Not sure why it's written this way where you will have a public method without any CXF annotations.
    // Someday, we should fix this: VCTRS-42410
    List<LineItemView> postCharges(String tenantId, String propertyId, String accountId, boolean ignoreAuth,
          List<Charge> charges, Boolean isRecurring) throws RGuestException;

    /**
     * Posts multiple charges
     *
     * @param tenantId          the Tenant Id to post to
     * @param propertyId        id of the property where the account exists
     * @param ignoreAuth        the Tenant Id to post to
     * @param grouped
     * @param accountChargesMap Payment request containing payment information for accounts
     * @return a List of PostChargesResponse for Display purposes
     */
    @POST
    @Path(MULTIPLE_CHARGES)
    @Requires(Permission.WRITE_ACCOUNTS)
    List<PostChargesResponse> postMultipleCharges(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @QueryParam("ignoreAuth") boolean ignoreAuth,
          @QueryParam(GROUPED) boolean grouped, Map<String, PostChargesRequest> accountChargesMap)
          throws RGuestException;

    @POST
    @CreatedOnSuccess
    @Path(ACCOUNT_ID_PATH + CREDIT_PATH)
    @Validated(Credit.class)
    @Requires(Permission.ALLOW_CREDITS)
    LineItemView postCredit(@PathParam(TENANT_ID) String tenantId, @PathParam(PROPERTY_ID) String propertyId,
          @PathParam(ACCOUNT_ID) String accountId, Credit credit) throws RGuestException;

    @POST
    @CreatedOnSuccess
    @Path(BATCH_CREDITS_PATH)
    @Requires(Permission.BATCH_POST_CREDITS)
    BatchDistributorResult batchPostCredit(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, List<BatchPostCC> batchPostCCs) throws RGuestException;

    @POST
    @CreatedOnSuccess
    @Path(BATCH_CHARGES_PATH)
    @Requires({ Permission.BATCH_POST_CHARGES, Permission.FORCE_CHARGE_ACCEPTANCE })
    BatchDistributorResult batchPostCharge(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, List<BatchPostCC> batchPostCCs) throws RGuestException;

    @POST
    @CreatedOnSuccess
    @Path(BATCH_PRE_AUTH)
    @Requires(Permission.PREAUTH_CREDIT_CARD)
    BatchDistributorResult batchPreAuth(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, BatchPreAuthRequest batchPreAuthRequest) throws RGuestException;

    @POST
    @CreatedOnSuccess
    @Path(ACCOUNT_ID_PATH + POS_CREDIT_PATH)
    @Validated(Credit.class)
    @Requires(Permission.ALLOW_CREDITS)
    LineItemView postPosCredit(@PathParam(TENANT_ID) String tenantId, @PathParam(PROPERTY_ID) String propertyId,
          @PathParam(ACCOUNT_ID) String accountId, PosCredit posCredit) throws RGuestException;

    @POST
    @CreatedOnSuccess
    @Path(ACCOUNT_ID_PATH + POS_CREDITS_PATH)
    @Requires(Permission.ALLOW_CREDITS)
    LineItemView postPosCredits(@PathParam(TENANT_ID) String tenantId, @PathParam(PROPERTY_ID) String propertyId,
          @PathParam(ACCOUNT_ID) String accountId, PostPosCreditRequest posCredit) throws RGuestException;

    @POST
    @CreatedOnSuccess
    @Path(ACCOUNT_ID_PATH + PAYMENTS_PATH)
    @Validated(Payment.class)
    @Requires(Permission.WRITE_ACCOUNTS)
    List<LineItemView> postPayment(@PathParam(TENANT_ID) String tenantId, @PathParam(PROPERTY_ID) String propertyId,
          @PathParam(ACCOUNT_ID) String accountId, Payment payment,
          @DefaultValue("true") @QueryParam("reAuth") Boolean reAuth) throws RGuestException;

    @POST
    @CreatedOnSuccess
    @Path(ACCOUNT_ID_PATH + POST_PAYMENT_CANCELLATION)
    @Validated(Payment.class)
    @Requires(Permission.WRITE_ACCOUNTS)
    List<LineItemView> postPaymentForCancellation(@PathParam(TENANT_ID) String tenantId, @PathParam(PROPERTY_ID) String propertyId,
          @PathParam(ACCOUNT_ID) String accountId, Payment payment,
          @DefaultValue("true") @QueryParam("reAuth") Boolean reAuth) throws RGuestException;

    /**
     * Posts multiple payments
     *
     * @param tenantId           the Tenant Id to post to
     * @param propertyId         id of the property where the account exists
     * @param accountPaymentsMap Payment request containing payment information for accounts
     * @return a List of LineItemView for Display purposes
     */
    @POST
    @CreatedOnSuccess
    @Path(MULTIPLE_PAYMENTS_PATH)
    @Requires(Permission.WRITE_ACCOUNTS)
    List<List<LineItemView>> postMultiplePayments(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, Map<String, Payment> accountPaymentsMap,
          @DefaultValue("true") @QueryParam("reAuth") Boolean reAuth) throws RGuestException;

    /**
     * Posts payment to multiple account
     *
     * @param tenantId               the Tenant Id to post to
     * @param propertyId             id of the property where the account exists
     * @param multiplePaymentRequest Payment request containing payment information for multiple accounts
     * @return a LineItemView for Display purposes
     */
    @POST
    @Path(MULTIPLE_PAYMENTS)
    @Requires(Permission.WRITE_ACCOUNTS)
    MultiplePaymentResponse postMultipleAccountPayment(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, MultiplePayment multiplePaymentRequest,
          @DefaultValue("true") @QueryParam("reAuth") Boolean reAuth) throws RGuestException;

    /**
     * Posts a payment to an account async
     *
     * @param tenantId   the Tenant Id to post to
     * @param propertyId id of the property where the account exists
     * @param accountId  the Account Id to post to
     * @param payment    Payment object containing payment information
     * @return a TaskId to track the async process
     */
    @POST
    @CreatedOnSuccess
    @Path(ACCOUNT_ID_PATH + PAYMENTS_ASYNC_PATH)
    @Validated(Payment.class)
    @Requires(Permission.WRITE_ACCOUNTS)
    @Produces(MediaType.TEXT_PLAIN)
    String postPaymentAsync(@PathParam(TENANT_ID) String tenantId, @PathParam(PROPERTY_ID) String propertyId,
          @PathParam(ACCOUNT_ID) String accountId, Payment payment,
          @DefaultValue("true") @QueryParam("reAuth") Boolean reAuth) throws RGuestException;

    @POST
    @CreatedOnSuccess
    @Path(ACCOUNT_ID_PATH + DEPOSITS_PATH)
    @Validated(Payment.class)
    @Requires(Permission.WRITE_ACCOUNTS)
    @Produces(MediaType.APPLICATION_JSON)
    List<LineItemView> postDeposit(@PathParam(TENANT_ID) String tenantId, @PathParam(PROPERTY_ID) String propertyId,
          @PathParam(ACCOUNT_ID) String accountId, DepositPaymentInfo depositPaymentInfo,
          @DefaultValue("true") @QueryParam("reAuth") Boolean reAuth) throws RGuestException;

    @POST
    @CreatedOnSuccess
    @Path(MULTIPLE_PAYMENTS_ASYNC_PATH)
    @Requires(Permission.WRITE_ACCOUNTS)
    MultipleAccountPaymentRequestAsyncJobId postMultipleAccountPaymentAsync(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @DefaultValue("true") @QueryParam("reAuth") Boolean reAuth,
          MultiplePayment multiplePaymentRequest) throws RGuestException;

    @GET
    @Path(MULTIPLE_PAYMENTS_ASYNC_PATH + TASK_ID_PATH)
    @Requires(Permission.READ_ACCOUNTS)
    MultiplePaymentResponse getMultiplePaymentResponse(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @PathParam(TASK_ID) String taskId);

    @GET
    @Path(ACCOUNT_ID_PATH + TASK_ID_PATH)
    @Requires(Permission.WRITE_ACCOUNTS)
    List<LineItemView> getPaymentResult(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @PathParam(TASK_ID) String taskId) throws Throwable;

    @POST
    @Path(PAYMENTS_PATH)
    @Requires(Permission.READ_ACCOUNTS)
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
    @Requires(Permission.ALLOW_REFUNDS)
    List<LineItemView> postRefunds(@PathParam(TENANT_ID) String tenantId, @PathParam(PROPERTY_ID) String propertyId,
          @PathParam(ACCOUNT_ID) String accountId, Payment payment) throws RGuestException;

    @POST
    @Path(ACCOUNT_ID_PATH + TRANSFER_FOLIO_LINES)
    @Validated(LineItemTransfer.class)
    @Requires({ Permission.WRITE_ACCOUNTS, Permission.TRANSFER })
    List<LineItemView> transferFolioLines(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @PathParam(ACCOUNT_ID) String accountId,
          LineItemTransfer transferInfo) throws RGuestException;

    @PUT
    @Path(ACCOUNT_ID_PATH + TRANSFER_OFFER_CHARGES)
    @Requires(Permission.WRITE_ACCOUNTS)
    void transferCompBackToFolio(@PathParam(TENANT_ID) String tenantId, @PathParam(PROPERTY_ID) String propertyId,
          @PathParam(ACCOUNT_ID) String accountId, Set<String> offerIds) throws RGuestException;

    @POST
    @Path(ACCOUNT_ID_PATH + TRANSFER_PATH)
    @Validated(AmountTransfer.class)
    @Requires({ Permission.WRITE_ACCOUNTS, Permission.TRANSFER })
    List<LineItemView> transferAmountToAccount(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @PathParam(ACCOUNT_ID) String accountId,
          AmountTransfer transferInfo) throws RGuestException;

    @POST
    @Path(ACCOUNT_ID_PATH + ADJUSTMENT_PATH)
    @Validated(LineItemAdjustment.class)
    @Requires(Permission.WRITE_ACCOUNTS)
    LineItemView adjustment(@PathParam(TENANT_ID) String tenantId, @PathParam(PROPERTY_ID) String propertyId,
          @PathParam(ACCOUNT_ID) String accountId, LineItemAdjustment adjustmentInfo) throws RGuestException;

    @POST
    @Path(ACCOUNT_ID_PATH + CORRECTION_PATH)
    @Validated(LineItemAdjustment.class)
    @Requires(Permission.WRITE_ACCOUNTS)
    List<LineItemView> correction(@PathParam(TENANT_ID) String tenantId, @PathParam(PROPERTY_ID) String propertyId,
          @PathParam(ACCOUNT_ID) String accountId, LineItemAdjustment correctionInfo) throws RGuestException;

    @POST
    @CreatedOnSuccess
    @Path(ACCOUNT_ID_PATH + REFUND_PATH)
    @Validated(PaymentRefund.class)
    @Requires(Permission.ALLOW_REFUNDS)
    LineItemView refundPayment(@PathParam(TENANT_ID) String tenantId, @PathParam(PROPERTY_ID) String propertyId,
          @PathParam(ACCOUNT_ID) String accountId, PaymentRefund paymentRefund) throws RGuestException;

    @POST
    @Path(ACCOUNT_ID_PATH + CHARGE_TAX_AMOUNT_PATH)
    @Validated(ChargeTaxAmountRequest.class)
    @Requires(Permission.READ_ACCOUNTS)
    ChargeTaxAmountInfo calculateChargeTaxAmount(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @PathParam(ACCOUNT_ID) String accountId,
          ChargeTaxAmountRequest request) throws RGuestException;

    @GET
    @Path(ACCOUNT_ID_PATH + PAYMENT_SETTINGS_PATH)
    @Requires(Permission.READ_ACCOUNTS)
    List<PaymentSetting> getPaymentSettings(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @PathParam(ACCOUNT_ID) String accountId) throws RGuestException;

    @POST
    @Path(PAYMENT_SETTINGS_PATH)
    @Requires(Permission.READ_ACCOUNTS)
    Map<String, List<PaymentInstrumentSetting>> getPaymentSettingsByAccounts(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, Set<String> accountIds) throws RGuestException;

    @POST
    @CreatedOnSuccess
    @Path(ACCOUNT_ID_PATH + PAYMENT_SETTINGS_PATH)
    @Requires(Permission.WRITE_ACCOUNTS)
    List<PaymentSetting> savePaymentSettings(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @PathParam(ACCOUNT_ID) String accountId,
          List<PaymentSetting> paymentSettings) throws RGuestException;

    @GET
    @Path(ACCOUNT_ID_PATH + TAX_EXEMPT_SETTINGS_BY_DATE_PATH)
    @Requires(Permission.READ_ACCOUNTS)
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
    @Requires(Permission.READ_ACCOUNTS)
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
    @Requires(Permission.WRITE_ACCOUNTS)
    TaxExemptSettingsByDate saveTaxExemptSettingsByDate(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @PathParam(ACCOUNT_ID) String accountId,
          TaxExemptSettingsByDate taxExemptSettingsByDate) throws RGuestException;

    @GET
    @Path(ACCOUNT_ID_PATH + GROUP_COMPANY_TAX_EXEMPT_SETTINGS_PATH)
    @Requires(Permission.READ_ACCOUNTS)
    GroupCompanyTaxExemptSettings getGroupCompanyTaxExemptSettings(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @PathParam(ACCOUNT_ID) String accountId) throws RGuestException;

    @GET
    @Path(ACCOUNT_ID_PATH + GROUP_COMPANY_TAX_EXEMPT_SETTINGS_PATH + PRESET_PATH)
    @Requires(Permission.READ_ACCOUNTS)
    GroupCompanyTaxExemptSettings getV1GroupCompanyTaxExemptSettings(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @PathParam(ACCOUNT_ID) String accountId,
          @PathParam(PRESET) boolean preset) throws RGuestException;

    @POST
    @Path(ACCOUNT_ID_PATH + GROUP_COMPANY_TAX_EXEMPT_SETTINGS_PATH)
    @Validated(GroupCompanyTaxExemptSettings.class)
    @Requires(Permission.WRITE_ACCOUNTS)
    GroupCompanyTaxExemptSettings saveGroupCompanyTaxExemptSettings(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @PathParam(ACCOUNT_ID) String accountId,
          GroupCompanyTaxExemptSettings groupCompanyTaxExemptSettings) throws RGuestException;

    @POST
    @Path(ACCOUNT_ID_PATH + GROUP_COMPANY_TAX_EXEMPT_SETTINGS_PATH + PRESET_PATH)
    @Validated(GroupCompanyTaxExemptSettings.class)
    @Requires(Permission.WRITE_ACCOUNTS)
    GroupCompanyTaxExemptSettings saveV1GroupCompanyTaxExemptSettings(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @PathParam(ACCOUNT_ID) String accountId,
          GroupCompanyTaxExemptSettings groupCompanyTaxExemptSettings, @PathParam(PRESET) boolean isPreset)
          throws RGuestException;

    @Deprecated
    @GET
    @Path(SEARCH_PATH + SEARCH_TERM_PATH + REMAINING_PATH)
    @Requires(Permission.READ_ACCOUNTS)
    List<AccountSearchResult> search(@PathParam(TENANT_ID) String tenantId, @PathParam(PROPERTY_ID) String propertyId,
          @PathParam(SEARCH_TERM) String searchTerm, @PathParam(PATH) String optionalSearchParamsPath)
          throws RGuestException;

    @Deprecated
    @GET
    @Path(SEARCH_PATH + SEARCH_TERM_PATH)
    @Requires(Permission.READ_ACCOUNTS)
    List<AccountSearchResult> search(@PathParam(TENANT_ID) String tenantId, @PathParam(PROPERTY_ID) String propertyId,
          @PathParam(SEARCH_TERM) String searchTerm, @QueryParam(INCLUDE_CLOSED_ACCOUNTS) Boolean includeClosedAccounts,
          @QueryParam(INCLUDE_HOLD_ACCOUNTS) Boolean includeHoldAccounts) throws RGuestException;

    @GET
    @Path(SEARCH_PATH + SEARCH_TERM_PATH + PAGE_PATH)
    @Requires(Permission.READ_ACCOUNTS)
    DeserializablePage<AccountSearchResult> searchPage(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @PathParam(SEARCH_TERM) String searchTerm,
          @QueryParam(INCLUDE_CLOSED_ACCOUNTS) Boolean includeClosedAccounts,
          @QueryParam(INCLUDE_HOLD_ACCOUNTS) Boolean includeHoldAccounts, @QueryParam(PAGE) Integer page,
          @QueryParam(SIZE) Integer size) throws RGuestException;

    @GET
    @Path(ACCOUNT_ID_PATH + NON_INVOICED_PATH)
    @Requires(Permission.READ_ACCOUNTS_RECEIVABLE)
    NonInvoicedARDetail getNonInvoicedARDetail(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @PathParam(ACCOUNT_ID) String accountId) throws RGuestException;

    @PUT
    @Path(ACCOUNT_ID_PATH + AR_DISPUTE_PATH)
    @Requires(Permission.MANAGE_INVOICE_DISPUTES)
    void setARDisputeDetails(@PathParam(TENANT_ID) String tenantId, @PathParam(PROPERTY_ID) String propertyId,
          @PathParam(ACCOUNT_ID) String accountId, DisputedARLedgerTransaction disputedARLedgerTransaction)
          throws RGuestException;

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
    @Requires(Permission.READ_ACCOUNTS_RECEIVABLE)
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
    @Requires(any = { Permission.WRITE_ACCOUNTS_RECEIVABLE, Permission.USE_ACCOUNTS_RECEIVABLE })
    InvoiceView createInvoice(@PathParam(TENANT_ID) String tenantId, @PathParam(PROPERTY_ID) String propertyId,
          @PathParam(ACCOUNT_ID) String accountId, InvoiceRequest invoice) throws RGuestException;

    /**
     * Create an invoice for an account
     *
     * @param tenantId             id of tenant for the account
     * @param propertyId           id of the property
     * @param accountId            id of account to save an invoice to
     * @param splitBySourceAccount create multiple invoice split by source account
     * @param invoice
     * @return Created invoice
     */
    @POST
    @CreatedOnSuccess
    @Path(ACCOUNT_ID_PATH + BY_ACCOUNT_PATH)
    @Validated(InvoiceRequest.class)
    @Requires(any = { Permission.WRITE_ACCOUNTS_RECEIVABLE, Permission.USE_ACCOUNTS_RECEIVABLE })
    List<InvoiceView> createInvoice(@PathParam(TENANT_ID) String tenantId, @PathParam(PROPERTY_ID) String propertyId,
          @PathParam(ACCOUNT_ID) String accountId, @QueryParam(SPLIT_BY_SOURCE_ACCOUNT) boolean splitBySourceAccount,
          InvoiceRequest invoice) throws RGuestException;

    @GET
    @Path(ACCOUNT_ID_PATH + INVOICES_PATH + INVOICE_ID_PATH)
    @Requires(Permission.READ_ACCOUNTS_RECEIVABLE)
    InvoiceView getInvoiceById(@PathParam(TENANT_ID) String tenantId, @PathParam(PROPERTY_ID) String propertyId,
          @PathParam(ACCOUNT_ID) String accountId, @PathParam(INVOICE_ID) String invoiceId,
          @QueryParam("") InvoiceOptionalParams optionalParams) throws RGuestException;

    @POST
    @Path("/invoiceBalance")
    @Requires(Permission.READ_ACCOUNTS_RECEIVABLE)
    List<InvoicePaymentReport> getInvoiceBalance(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @QueryParam(START_DATE) LocalDate startDate,
          @QueryParam(END_DATE) LocalDate endDate, InvoicePaymentRequest invoicePaymentRequest) throws RGuestException;

    @GET
    @Path("/findByUnAppliedAmountUsed")
    @Requires(Permission.READ_ACCOUNTS)
    List<CompanyInfo> findAccountsByUnAppliedAmountUsed(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @QueryParam("accountStatus") AccountStatus accountStatus)
          throws RGuestException;

    @GET
    @Path(ACCOUNT_ID_PATH + INVOICES_PATH)
    @OkOnEmpty
    @Requires(Permission.READ_ACCOUNTS_RECEIVABLE)
    List<InvoiceView> findInvoices(@PathParam(TENANT_ID) String tenantId, @PathParam(PROPERTY_ID) String propertyId,
          @PathParam(ACCOUNT_ID) String accountId, @QueryParam("") InvoiceFilteringOptionalParams params)
          throws RGuestException;

    @GET
    @Path(ACCOUNT_ID_PATH + INVOICE_REPORT_TYPE)
    @Requires(Permission.READ_ACCOUNTS_RECEIVABLE)
    List<InvoiceBaseView> getInvoiceViews(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @PathParam(ACCOUNT_ID) String accountId,
          @PathParam(INVOICE_VIEW_TYPE) InvoiceViewType viewType, @QueryParam("includeClosed") boolean includeClosed)
          throws RGuestException;

    @POST
    @Path(ACCOUNT_ID_PATH + INVOICE_REPORT)
    @Requires(Permission.READ_ACCOUNTS_RECEIVABLE)
    List<InvoiceBaseView> getInvoiceViews(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @PathParam(ACCOUNT_ID) String accountId, Set<String> invoiceIds)
          throws RGuestException;

    @GET
    @Path(ACCOUNT_ID_PATH + INVOICE_REPORT_START)
    @OkOnEmpty
    @Requires(Permission.READ_ACCOUNTS_RECEIVABLE)
    InvoiceReportProgressView createInvoiceReport(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @PathParam(ACCOUNT_ID) String accountId,
          @QueryParam("tag") String tag, @QueryParam("includeClosed") String includeClosed) throws RGuestException;

    @Deprecated
    @GET
    @Path(ACCOUNT_ID_PATH + INVOICE_REPORT_POLL)
    @OkOnEmpty
    @Requires(Permission.READ_ACCOUNTS_RECEIVABLE)
    InvoiceReportProgressView getInvoiceReportProgress(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @PathParam(ACCOUNT_ID) String accountId,
          @QueryParam("includeClosed") String includeClosed) throws RGuestException;

    @PUT
    @Path(ACCOUNT_ID_PATH + INVOICES_PATH + INVOICE_ID_PATH + INVOICE_ADD_ITEMS_PATH)
    @Validated(UpdateInvoiceLineItemsRequest.class)
    @Requires(any = { Permission.WRITE_ACCOUNTS_RECEIVABLE, Permission.USE_ACCOUNTS_RECEIVABLE })
    InvoiceView addInvoiceLineItems(@PathParam(TENANT_ID) String tenantId, @PathParam(PROPERTY_ID) String propertyId,
          @PathParam(ACCOUNT_ID) String accountId, @PathParam(INVOICE_ID) String invoiceId,
          UpdateInvoiceLineItemsRequest lineItems) throws RGuestException;

    @PUT
    @Path(ACCOUNT_ID_PATH + INVOICES_PATH + INVOICE_ID_PATH + INVOICE_REMOVE_ITEMS_PATH)
    @Validated(UpdateInvoiceLineItemsRequest.class)
    @Requires(any = { Permission.WRITE_ACCOUNTS_RECEIVABLE, Permission.USE_ACCOUNTS_RECEIVABLE })
    InvoiceView removeInvoiceLineItems(@PathParam(TENANT_ID) String tenantId, @PathParam(PROPERTY_ID) String propertyId,
          @PathParam(ACCOUNT_ID) String accountId, @PathParam(INVOICE_ID) String invoiceId,
          UpdateInvoiceLineItemsRequest lineItems) throws RGuestException;

    @PUT
    @Path(ACCOUNT_ID_PATH + INVOICES_PATH + INVOICE_ID_PATH + INVOICE_UPDATE_TERMS_PATH)
    @Validated(UpdateInvoiceTermsRequest.class)
    @Requires(any = { Permission.WRITE_ACCOUNTS_RECEIVABLE, Permission.USE_ACCOUNTS_RECEIVABLE })
    InvoiceView updateInvoiceTerms(@PathParam(TENANT_ID) String tenantId, @PathParam(PROPERTY_ID) String propertyId,
          @PathParam(ACCOUNT_ID) String accountId, @PathParam(INVOICE_ID) String invoiceId,
          UpdateInvoiceTermsRequest terms) throws RGuestException;

    @PUT
    @Path(ACCOUNT_ID_PATH + INVOICES_PATH + INVOICE_ID_PATH + INVOICE_SET_INVOICE_SENT)
    @Requires(any = { Permission.WRITE_ACCOUNTS_RECEIVABLE, Permission.USE_ACCOUNTS_RECEIVABLE })
    InvoiceView setInvoiceSent(@PathParam(TENANT_ID) String tenantId, @PathParam(PROPERTY_ID) String propertyId,
          @PathParam(ACCOUNT_ID) String accountId, @PathParam(INVOICE_ID) String invoiceId,
          @QueryParam("isEmail") boolean isEmail) throws RGuestException;

    @PUT
    @Path(ACCOUNT_ID_PATH + INVOICES_PATH + INVOICE_SET_INVOICE_SENT + BULK)
    @Requires(any = { Permission.WRITE_ACCOUNTS_RECEIVABLE, Permission.USE_ACCOUNTS_RECEIVABLE })
    void setInvoiceSentByBulk(@PathParam(TENANT_ID) String tenantId, @PathParam(PROPERTY_ID) String propertyId,
          @PathParam(ACCOUNT_ID) String accountId, @QueryParam("isEmail") boolean isEmail, MailedInvoice mailedInvoice)
          throws RGuestException;

    @POST
    @CreatedOnSuccess
    @Path(ACCOUNT_ID_PATH + INVOICES_PATH + APPLY_PAYMENTS)
    @Validated(ApplyInvoicePaymentRequest.class)
    @Requires(any = { Permission.WRITE_ACCOUNTS_RECEIVABLE, Permission.USE_ACCOUNTS_RECEIVABLE })
    List<InvoiceView> applyInvoicePayments(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @PathParam(ACCOUNT_ID) String accountId,
          ApplyInvoicePaymentRequest applyInvoicePaymentRequest) throws RGuestException;

    @POST
    @CreatedOnSuccess
    @Path(ACCOUNT_ID_PATH + INVOICES_PATH + APPLY_DEPOSIT_PAYMENTS)
    @Validated(ApplyInvoiceDepositPaymentRequest.class)
    @Requires(any = { Permission.WRITE_ACCOUNTS_RECEIVABLE, Permission.USE_ACCOUNTS_RECEIVABLE })
    List<InvoiceView> applyInvoiceDepositPayments(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @PathParam(ACCOUNT_ID) String accountId,
          ApplyInvoiceDepositPaymentRequest applyInvoiceDepositPaymentRequest) throws RGuestException;

    @POST
    @CreatedOnSuccess
    @Path(ACCOUNT_ID_PATH + INVOICES_PATH + INVOICE_ID_PATH + REFUND_PATH)
    @Validated(InvoicePaymentRefund.class)
    @Requires(Permission.ALLOW_REFUNDS)
    InvoiceView refundInvoicePayment(@PathParam(TENANT_ID) String tenantId, @PathParam(PROPERTY_ID) String propertyId,
          @PathParam(ACCOUNT_ID) String accountId, @PathParam(INVOICE_ID) String invoiceId,
          InvoicePaymentRefund invoicePaymentRefund) throws RGuestException;

    @GET
    @Path(LEDGER_BALANCES_PATH)
    @Requires(Permission.READ_ACCOUNTS)
    Map<String, BigDecimal> getLedgerBalances(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, LedgerBalancesInfo ledgerBalancesInfo) throws RGuestException;

    @GET
    @Path(ACCOUNT_ID_PATH + AR_DEPOSIT_BALANCE)
    @Requires(Permission.READ_ACCOUNTS)
    ARDepositView getARDepositBalance(@PathParam(TENANT_ID) String tenantId, @PathParam(PROPERTY_ID) String propertyId,
          @PathParam(ACCOUNT_ID) String accountId) throws RGuestException;

    @GET
    @Path(ACCOUNT_ID_PATH + VERIFY_CHECKOUT_PATH)
    @Requires(Permission.READ_ACCOUNTS)
    void verifyCheckout(@PathParam(TENANT_ID) String tenantId, @PathParam(PROPERTY_ID) String propertyId,
          @PathParam(ACCOUNT_ID) String accountId, @QueryParam("allowBalance") boolean allowBalance,
          @QueryParam(PAYMENT_METHOD_ID) String paymentMethodId,
          @QueryParam("isCancellation") boolean isCancellation) throws RGuestException;

    @GET
    @Path(NEXT_ACCOUNT_NUMBER_PATH)
    @Requires(Permission.READ_ACCOUNTS)
    NextAccountNumberInfo getNextArAccountNumber(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId) throws RGuestException;

    @GET
    @Path(CHECK_ACCOUNT_NUMBER_AVAILABILITY_PATH)
    @Requires(Permission.READ_ACCOUNTS)
    Boolean checkAccountNumberAvailability(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @PathParam(ACCOUNT_NUMBER) String accountNumber)
          throws RGuestException;

    @POST
    @Path(ACCOUNT_ID_PATH + AUTH_CARDS_ON_ACCOUNT_PATH)
    @Requires(Permission.WRITE_ACCOUNTS)
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
    @Requires(Permission.READ_ACCOUNTS)
    AccountClosableInfo getAccountClosableInfo(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @PathParam(ACCOUNT_ID) String accountId) throws RGuestException;

    @POST
    @CreatedOnSuccess
    @Path(ACCOUNT_ID_PATH + PAYOFF_BALANCE_PATH)
    @Requires(Permission.WRITE_ACCOUNTS)
    void payOffBalance(@PathParam(TENANT_ID) String tenantId, @PathParam(PROPERTY_ID) String propertyId,
          @PathParam(ACCOUNT_ID) String accountId, PayoffBalanceRequest request) throws RGuestException;

    @POST
    @Path(INVENTORY_ALLOCATION)
    @Requires(Permission.READ_ACCOUNTS)
    Map<LocalDate, Map<String, InventoryAllocationDetails>> findInventoryItemAllocatedDetails(
          @PathParam(TENANT_ID) String tenantId, @PathParam(PROPERTY_ID) String propertyId,
          @QueryParam(START_DATE) LocalDate startDate, @QueryParam(END_DATE) LocalDate endDate, Set<String> itemIds)
          throws RGuestException;

    @GET
    @Path(ACCOUNT_ID_PATH + FREE_ALLOWANCE_PATH)
    @Requires(Permission.READ_ACCOUNTS)
    BigDecimal getFreeAllowanceCharges(@PathParam(TENANT_ID) String tenantId, @PathParam(PROPERTY_ID) String propertyId,
          @PathParam(ACCOUNT_ID) String accountId, @QueryParam(CALL_TYPE) String callType,
          @QueryParam(START_DATE_TIME) String startDateTime, @QueryParam(END_DATE_TIME) String endDateTime)
          throws RGuestException;

    @GET
    @Path(COMPANY_PROFILE_PATH + TENANT_DEFAULT_SETTINGS_PATH)
    @Requires(Permission.WRITE_COMPANY_PROFILE_DEFAULTS)
    TenantDefaultSettingsSummary getTenantDefaultSettings(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @PathParam(COMPANY_PROFILE_ID) String companyProfileId)
          throws RGuestException;

    @POST
    @Path(COMPANY_PROFILE_PATH + TENANT_DEFAULT_SETTINGS_PATH)
    @Requires(Permission.WRITE_COMPANY_PROFILE_DEFAULTS)
    TenantDefaultSettingsSummary createTenantDefaultSettings(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @PathParam(COMPANY_PROFILE_ID) String companyProfileId,
          TenantDefaultSettingsSummary tenantDefaultSettingsSummary) throws RGuestException;

    @PUT
    @Path(COMPANY_PROFILE_PATH + TENANT_DEFAULT_SETTINGS_PATH)
    @Requires(Permission.WRITE_COMPANY_PROFILE_DEFAULTS)
    TenantDefaultSettingsSummary updateTenantDefaultSettings(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @PathParam(COMPANY_PROFILE_ID) String companyProfileId,
          TenantDefaultSettingsSummary tenantDefaultSettingsSummary) throws RGuestException;

    @GET
    @Path(COMPANY_PROFILE_PATH + TENANT_DEFAULT_SETTINGS_JOB_STATUS_PATH)
    @Requires(Permission.READ_ACCOUNTS)
    AccountUpdateResponse findAccountReceivableJobStatus(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @PathParam(COMPANY_PROFILE_ID) String companyProfileId)
          throws RGuestException;

    @GET
    @Path(COMPANY_PROFILE_PATH + TENANT_DEFAULT_SETTINGS_PROPERTY_LISTINGS_PATH)
    @Requires(Permission.WRITE_COMPANY_PROFILE_DEFAULTS)
    List<TenantARPropertySettingStatus> getAccountReceivablePropertySettingStatus(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @PathParam(COMPANY_PROFILE_ID) String companyProfileId)
          throws RGuestException;

    @POST
    @Path(COMPANY_PROFILE_PATH + TENANT_DEFAULT_SETTINGS_APPLY_PATH)
    @Requires(Permission.WRITE_COMPANY_PROFILE_DEFAULTS)
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
    @Requires(Permission.READ_PROPERTIES)
    void updateProfileIdsInMultiFolioInvoice(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, UpdateFolioInvoicesRequest updateFolioInvoicesRequest)
          throws RGuestException;

    @POST
    @Path(INVOICES_PATH + PRINT_FOLIO)
    @Produces(MediaType.TEXT_HTML)
    @Requires(Permission.READ_PROPERTIES)
    String printFolioInvoice(@PathParam(TENANT_ID) String tenantId, @PathParam(PROPERTY_ID) String propertyId,
          FolioInvoiceRequest folioInvoiceRequest) throws RGuestException;

    @GET
    @Path(ACCOUNT_ID_PATH + FOLIO_INVOICE_SUMMARY)
    @Requires(Permission.READ_PROPERTIES)
    List<FolioInvoiceDetail> getFolioInvoiceSummary(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @PathParam(ACCOUNT_ID) String accountId) throws RGuestException;

    @GET
    @Path(FOLIO_INVOICE_ID_PATH)
    @Requires(Permission.READ_PROPERTIES)
    FolioInvoiceResponse getFolioInvoiceDetailFromFolioInvoiceNumber(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @PathParam("folioInvoiceId") String folioInvoiceId)
          throws RGuestException;

    @POST
    @Path(INVOICES_PATH + BATCH_FOLIO_PRINT)
    @Requires(Permission.READ_PROPERTIES)
    List<String> printBatchFolioInvoice(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, BatchFolioInvoiceRequest batchFolioInvoiceRequest)
          throws RGuestException;

    @POST
    @Path(INVOICES_PATH + FOLIO_EMAIL)
    @Requires(Permission.READ_PROPERTIES)
    void sendFolioInvoiceEmail(@PathParam(TENANT_ID) String tenantId, @PathParam(PROPERTY_ID) String propertyId,
          FolioInvoiceRequest folioInvoiceRequest) throws RGuestException;

    @POST
    @Path(INVOICES_PATH + BATCH_FOLIO_EMAIL)
    @Requires(Permission.READ_PROPERTIES)
    BatchFolioInvoiceResponse sendBatchFolioInvoiceEmail(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, BatchFolioInvoiceRequest batchFolioInvoiceRequest)
          throws RGuestException;

    @POST
    @Path(CANCEL_PAYMENTS)
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Requires(Permission.READ_ACCOUNTS)
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
    @Requires(Permission.WRITE_ACCOUNTS)
    GiftCardResponse loadGiftCard(@PathParam(TENANT_ID) String tenantId, @PathParam(PROPERTY_ID) String propertyId,
          @PathParam(ACCOUNT_ID) String accountId, GiftCardRequest request) throws RGuestException;

    @POST
    @Path(ACCOUNT_ID_PATH + "/giftCard/issue")
    @Requires(Permission.WRITE_ACCOUNTS)
    GiftCardResponse issueGiftCard(@PathParam(TENANT_ID) String tenantId, @PathParam(PROPERTY_ID) String propertyId,
          @PathParam(ACCOUNT_ID) String accountId, GiftCardRequest request) throws RGuestException;

    @POST
    @Path(ACCOUNT_ID_PATH + PANTRY_ITEMS_CHARGE)
    @Requires({ Permission.WRITE_ACCOUNTS, Permission.ADD_PANTRY })
    PantryTransactionResponse postPantryCharges(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @PathParam(ACCOUNT_ID) String accountId,
          @QueryParam("ignoreAuth") boolean ignoreAuth, @QueryParam("reAuth") boolean reAuth,
          @QueryParam(GROUPED) boolean grouped, PantryCharge pantryCharge) throws RGuestException;

    @GET
    @Path(FOLIO_LINE_ITEM)
    @Requires(Permission.READ_ACCOUNTS)
    LineItemView getFolioLineItemById(@PathParam(TENANT_ID) String tenantId, @PathParam(PROPERTY_ID) String propertyId,
          @PathParam(FOLIO_LINE_ITEM_ID) String folioLineItemId) throws RGuestException;

    @GET
    @Path(LEDGER_TRANSACTION_IDS)
    @Requires(Permission.READ_ACCOUNTS)
    IGTransactionHistoryFields getLineItemViewByLedgerTransactionById(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @PathParam(LEDGER_TRANSACTION) String LedgerTransactionIds)
          throws RGuestException;

    @PUT
    @Path(RECEIPT_IMAGE_RESPOME)
    @Requires(Permission.WRITE_ACCOUNTS)
    void updateReceiptImageFolioLineItem(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @PathParam(FOLIO_LINE_ITEM_ID) String folioLineItemId,
          ReceiptImageResponse receiptImageResponse) throws RGuestException;

    @PUT
    @Path(RECEIPT_IMAGE_RESPONCE_GROUP)
    @Requires(Permission.WRITE_ACCOUNTS)
    void updateReceiptImageLedgerTransaction(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @PathParam(LEDGER_TRANSACTION) String ledgerTransactionId,
          ReceiptImageResponse receiptImageResponse) throws RGuestException;

    @POST
    @Path(ACCOUNT_ID_PATH + REDEEM_FOLIO_CHARGE)
    @Requires(Permission.WRITE_ACCOUNTS)
    List<String> redeemPlayerFolioItemsCharge(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @PathParam(ACCOUNT_ID) String accountId,
          CompTransaction compTransaction) throws RGuestException;

    @POST
    @Path(ACCOUNT_ID_PATH + REVERSE_REDEEM_CHARGE)
    CompleteReverseRedemptionRequestAyncJobId completeReverseRedemption(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @PathParam(ACCOUNT_ID) String accountId,
          ReverseRedemptionRequest reverseRedemptionRequest) throws RGuestException;

    @GET
    @Path(REVERSE_REDEEM_CHARGE + "/{id}")
    ReverseRedemptionResponse getReverseRedemptionResponse(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @PathParam("id") String id) throws RGuestException;

    @POST
    @Path(BATCH_DEPOSIT_COLLECTION_JOB_PATH)
    BatchDepositCollectionResponse postBatchDepositCollectionJob(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, BatchDepositCollectionRequest batchDepositCollectionRequest)
          throws RGuestException;

    @POST
    @Path(BATCH_DEPOSIT_COLLECTION_JOB_STATUS_PATH)
    BatchStatusResponse batchDepositCollectionStatus(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @QueryParam(JOB_ID) String jobId) throws RGuestException;

    @POST
    @Path(BATCH_DEPOSIT_COLLECTION_JOB_CANCEL_PATH)
    void cancelBatchDepositCollection(@PathParam(TENANT_ID) String tenantId, @PathParam(PROPERTY_ID) String propertyId,
          CancelBatchRequest request) throws RGuestException;

    @GET
    @Path(ACCOUNT_ID_PATH + FOLIO_PATH + FOLIO_ID_PATH + ALLOWANCE + DATE_PATH)
    @Requires(Permission.READ_ACCOUNTS)
    List<CheckAllowanceResponse> checkPackageAllowance(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @PathParam(ACCOUNT_ID) String accountId,
          @PathParam(FOLIO_ID) String packageFolioId, @PathParam(DATE) LocalDate date) throws RGuestException;

    @POST
    @Path("/transactionItem" + ALLOWANCE)
    @Requires(Permission.WRITE_ACCOUNTS)
    TransactionItem createAllowanceTransactionItem(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId) throws RGuestException;

    @POST
    @Path(UPLOAD_COMPANY_AR_DOCUMENTS)
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Requires(Permission.PLATFORM_WRITE_CONTENT)
    DocumentDetails uploadCompanyARDocuments(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @PathParam(ACCOUNT_ID) String accountId,
          @Multipart(value = FILE) Attachment attachment,
          @Multipart(value = "description", type = "String") String description) throws RGuestException;

    @DELETE
    @Path(DELETE_COMPANY_AR_DOCUMENTS)
    @Consumes(HTTPRequestConstants.JSON_MEDIA_TYPE)
    @Requires(Permission.DELETE_COMPANY_AR_DOCUMENT)
    void deleteCompanyARDocuments(@PathParam(TENANT_ID) String tenantId, @PathParam(PROPERTY_ID) String propertyId,
          DocumentRequest documentRequest) throws RGuestException;

    @POST
    @Path(RELEASE_ALL_AUTH)
    @Consumes(HTTPRequestConstants.JSON_MEDIA_TYPE)
    void releaseAllAuthorizations(@PathParam(TENANT_ID) String tenantId, @PathParam(PROPERTY_ID) String propertyId,
          ReleaseAllAuthRequest ReleaseAllAuthRequest) throws RGuestException;

    @POST
    @Path(ACCOUNT_ID_PATH + STATEMENT_HISTORY)
    void createStatementHistory(@PathParam(TENANT_ID) String tenantId, @PathParam(PROPERTY_ID) String propertyId,
          @PathParam(ACCOUNT_ID) String accountId, StatementHistory statementHistory) throws RGuestException;

    @GET
    @Path(ACCOUNT_ID_PATH + STATEMENT_HISTORY)
    List<StatementHistory> getStatementHistoryByAccountId(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @PathParam(ACCOUNT_ID) String accountId) throws RGuestException;

    @GET
    @Path(ACCOUNT_ID_PATH + VALIDATE_FOR_REFERENCE_NUMBER)
    void validateForRequiredReferenceNumber(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @PathParam(ACCOUNT_ID) String accountId) throws RGuestException;

    @POST
    @Path(ESTIMATE_CHARGE_AMOUNT_FOR_DEPOSIT_POLICY)
    List<RecurringChargeView> getEstimateChargeAmountForDepositCalculation(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, EstimatedChargesWrapper wrapper) throws RGuestException;
}
