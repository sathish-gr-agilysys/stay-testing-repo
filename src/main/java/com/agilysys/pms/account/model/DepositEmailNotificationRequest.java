/*
 * (C) 2019 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.math.BigDecimal;
import java.util.List;

import org.joda.time.LocalDate;

import com.agilysys.platform.communication.model.EmailDeliveryDetail;

import lombok.Data;

@Data
public class DepositEmailNotificationRequest {
    private String maskedCardNumber;
    private String paymentMethodId;
    private String paymentInstrumentId;

    private BigDecimal dueAmount;
    private LocalDate dueDate;
    private String scheduledDepositDueId;

    private EmailDeliveryDetail emailDeliveryDetail;
    private String firstName;
    private String lastName;
    private String reservationConfirmationId;
    private String reservationId;
    private String accountId;

    private String propertyName;
    private String propertyAddress;

    public String getMaskedCardNumber() {
        return maskedCardNumber;
    }

    public void setMaskedCardNumber(String maskedCardNumber) {
        this.maskedCardNumber = maskedCardNumber;
    }

    public String getPaymentMethodId() {
        return paymentMethodId;
    }

    public void setPaymentMethodId(String paymentMethodId) {
        this.paymentMethodId = paymentMethodId;
    }

    public String getPaymentInstrumentId() {
        return paymentInstrumentId;
    }

    public void setPaymentInstrumentId(String paymentInstrumentId) {
        this.paymentInstrumentId = paymentInstrumentId;
    }

    public BigDecimal getDueAmount() {
        return dueAmount;
    }

    public void setDueAmount(BigDecimal dueAmount) {
        this.dueAmount = dueAmount;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public String getScheduledDepositDueId() {
        return scheduledDepositDueId;
    }

    public void setScheduledDepositDueId(String scheduledDepositDueId) {
        this.scheduledDepositDueId = scheduledDepositDueId;
    }

    public EmailDeliveryDetail getEmailDeliveryDetail() {
        return emailDeliveryDetail;
    }

    public void setEmailDeliveryDetail(EmailDeliveryDetail emailDeliveryDetail) {
        this.emailDeliveryDetail = emailDeliveryDetail;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getReservationConfirmationId() {
        return reservationConfirmationId;
    }

    public void setReservationConfirmationId(String reservationConfirmationId) {
        this.reservationConfirmationId = reservationConfirmationId;
    }

    public String getReservationId() {
        return reservationId;
    }

    public void setReservationId(String reservationId) {
        this.reservationId = reservationId;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public String getPropertyAddress() {
        return propertyAddress;
    }

    public void setPropertyAddress(String propertyAddress) {
        this.propertyAddress = propertyAddress;
    }
}
