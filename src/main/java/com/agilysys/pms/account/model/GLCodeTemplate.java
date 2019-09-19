/*
 * Copyright (c) 2019. Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import com.agilysys.pms.common.model.GeneralLedgerCodeType;

public class GLCodeTemplate {
    private String autoGLCodeTemplate;
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

    public GLCodeTemplate() {}

    public GLCodeTemplate(String building, String outlet, String mealperiod, String transactionItemName,
          String autoGLCodeTemplate, String transactionItemTemplate) {
        this.building = building;
        this.outlet = outlet;
        this.mealperiod = mealperiod;
        this.transactionItemName = transactionItemName;
        this.autoGLCodeTemplate = autoGLCodeTemplate;
        this.template = transactionItemTemplate;
    }

    public GLCodeTemplate(String building, String guestTypeName, String marketSegmentName, String autoGLCodeTemplate, String guestTypeTemplate) {
        this.building = building;
        this.autoGLCodeTemplate = autoGLCodeTemplate;
        this.guestType = guestTypeName;
        this.marketSegment = marketSegmentName;
        this.template = guestTypeTemplate;
    }

    public GLCodeTemplate(String building, String outletCode, String paymentMethodName, String autoGLCodeTemplate,
          String paymentTemplate, GeneralLedgerCodeType type) {
        this.building = building;
        this.autoGLCodeTemplate = autoGLCodeTemplate;
        this.outlet = outletCode;
        this.payment = paymentMethodName;
        this.template = paymentTemplate;
    }

    public String getAutoGLCodeTemplate() {
        return autoGLCodeTemplate;
    }

    public void setAutoGLCodeTemplate(String autoGLCodeTemplate) {
        this.autoGLCodeTemplate = autoGLCodeTemplate;
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
