package com.agilysys.pms.account.model;

import com.agilysys.pms.payment.model.GatewayType;

public class GiftCardRequest {
    private String cardNumber;
    private Charge charge;
    private String invoiceNumber;
    private GatewayType gatewayType;

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Charge getCharge() {
        return charge;
    }

    public void setCharge(Charge charge) {
        this.charge = charge;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public GatewayType getGatewayType() {
        return gatewayType;
    }

    public void setGatewayType(GatewayType gatewayType) {
        this.gatewayType = gatewayType;
    }
}
