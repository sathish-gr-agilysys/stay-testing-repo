package com.agilysys.pms.account.data.domain;

import java.util.List;

import org.joda.time.LocalDate;

import com.agilysys.common.model.rate.ComponentRateSnapshot;

public class CheckAllowanceRequest {
    private List<ComponentRateSnapshot> componentRateSnapshots;
    private LocalDate endDate;
    private String packageFolioId;
    private LocalDate propertyDate;
    private LocalDate startDate;

    public CheckAllowanceRequest() {}

    public CheckAllowanceRequest(List<ComponentRateSnapshot> componentRateSnapshots, LocalDate endDate,
          String packageFolioId, LocalDate propertyDate, LocalDate startDate) {
        this.componentRateSnapshots = componentRateSnapshots;
        this.endDate = endDate;
        this.packageFolioId = packageFolioId;
        this.propertyDate = propertyDate;
        this.startDate = startDate;
    }

    public List<ComponentRateSnapshot> getComponentRateSnapshots() {
        return componentRateSnapshots;
    }

    public void setComponentRateSnapshots(List<ComponentRateSnapshot> componentRateSnapshots) {
        this.componentRateSnapshots = componentRateSnapshots;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getPackageFolioId() {
        return packageFolioId;
    }

    public void setPackageFolioId(String packageFolioId) {
        this.packageFolioId = packageFolioId;
    }

    public LocalDate getPropertyDate() {
        return propertyDate;
    }

    public void setPropertyDate(LocalDate propertyDate) {
        this.propertyDate = propertyDate;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }
}