package com.agilysys.pms.account.model;

import java.math.BigDecimal;
import java.util.List;

import org.joda.time.LocalDate;

import com.agilysys.common.model.rate.AllowanceCombination;
import com.agilysys.common.model.rate.AllowanceFrequencyType;

public class PackageFolioLinesRequest {
    private List<AllowanceCombination> allowanceCombinations;
    private AllowanceFrequencyType allowanceFrequencyType;
    private BigDecimal allowanceAmount;
    private BigDecimal amount;
    private LocalDate endDate;
    private int quantity;
    private String packageFolioId;
    private String propertyId;
    private LocalDate startDate;
    private String tenantId;

    public PackageFolioLinesRequest() {}

    public PackageFolioLinesRequest(String tenantId, String propertyId, String packageFolioId,
          ComponentChargeView view) {
        this.allowanceCombinations = view.getAllowanceCombinations();
        this.allowanceFrequencyType = view.getAllowanceFrequencyType();
        this.allowanceAmount = view.getAllowanceAmount();
        this.amount = view.getAmount();
        this.quantity = view.getQuantity();
        this.packageFolioId = packageFolioId;
        this.propertyId = propertyId;
        this.tenantId = tenantId;
    }

    public List<AllowanceCombination> getAllowanceCombinations() {
        return allowanceCombinations;
    }

    public void setAllowanceCombinations(List<AllowanceCombination> allowanceCombinations) {
        this.allowanceCombinations = allowanceCombinations;
    }

    public AllowanceFrequencyType getAllowanceFrequencyType() {
        return allowanceFrequencyType;
    }

    public void setAllowanceFrequencyType(AllowanceFrequencyType allowanceFrequencyType) {
        this.allowanceFrequencyType = allowanceFrequencyType;
    }

    public BigDecimal getAllowanceAmount() {
        return allowanceAmount;
    }

    public void setAllowanceAmount(BigDecimal allowanceAmount) {
        this.allowanceAmount = allowanceAmount;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getPackageFolioId() {
        return packageFolioId;
    }

    public void setPackageFolioId(String packageFolioId) {
        this.packageFolioId = packageFolioId;
    }

    public String getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(String propertyId) {
        this.propertyId = propertyId;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }
}