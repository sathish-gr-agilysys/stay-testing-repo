package com.agilysys.pms.account.model;

import com.agilysys.pms.common.model.GeneralLedgerCodeType;

public class GlCodeTemplate {
    private String autoGlCodeTemplate;
    private String building;
    private String guestType;
    private String guestTypeTemplate;
    private String marketSegment;
    private String mealperiod;
    private String outlet;
    private String paymentMethodTemplate;
    private String template;
    private String transactionItemName;
    private String payment;
    private String transactionItemTemplate;

    public GlCodeTemplate() {}

    public GlCodeTemplate(String building, String outlet, String mealperiod, String transactionItemName,
          String transactionItemTemplate) {
        this.building = building;
        this.outlet = outlet;
        this.mealperiod = mealperiod;
        this.transactionItemName = transactionItemName;
        this.autoGlCodeTemplate = transactionItemTemplate;
    }

    public GlCodeTemplate(String building, String guestTypeName, String marketSegmentName, String autoGlCodeTemplate) {
        this.building = building;
        this.autoGlCodeTemplate = autoGlCodeTemplate;
        this.guestType = guestTypeName;
        this.marketSegment = marketSegmentName;
    }

    public GlCodeTemplate(String building, String outletCode, String paymentMethodName, String autoGlCodeTemplate,
          GeneralLedgerCodeType type) {
        this.building = building;
        this.autoGlCodeTemplate = autoGlCodeTemplate;
        this.outlet = outletCode;
        this.payment = paymentMethodName;
    }

    public String getAutoGlCodeTemplate() {
        return autoGlCodeTemplate;
    }

    public void setAutoGlCodeTemplate(String autoGlCodeTemplate) {
        this.autoGlCodeTemplate = autoGlCodeTemplate;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getGuestType() {
        return guestType;
    }

    public void setGuestType(String guestType) {
        this.guestType = guestType;
    }

    public String getGuestTypeTemplate() {
        return guestTypeTemplate;
    }

    public void setGuestTypeTemplate(String guestTypeTemplate) {
        this.guestTypeTemplate = guestTypeTemplate;
    }

    public String getMarketSegment() {
        return marketSegment;
    }

    public void setMarketSegment(String marketSegment) {
        this.marketSegment = marketSegment;
    }

    public String getMealperiod() {
        return mealperiod;
    }

    public void setMealperiod(String mealperiod) {
        this.mealperiod = mealperiod;
    }

    public String getOutlet() {
        return outlet;
    }

    public void setOutlet(String outlet) {
        this.outlet = outlet;
    }

    public String getPaymentMethodTemplate() {
        return paymentMethodTemplate;
    }

    public void setPaymentMethodTemplate(String paymentMethodTemplate) {
        this.paymentMethodTemplate = paymentMethodTemplate;
    }

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    public String getTransactionItemName() {
        return transactionItemName;
    }

    public void setTransactionItemName(String transactionItemName) {
        this.transactionItemName = transactionItemName;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public String getTransactionItemTemplate() {
        return transactionItemTemplate;
    }

    public void setTransactionItemTemplate(String transactionItemTemplate) {
        this.transactionItemTemplate = transactionItemTemplate;
    }
}
