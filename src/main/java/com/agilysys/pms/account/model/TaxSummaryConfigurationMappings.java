package com.agilysys.pms.account.model;

public class TaxSummaryConfigurationMappings {
    private String id;
    private String name;

    public TaxSummaryConfigurationMappings() {
    }

    public TaxSummaryConfigurationMappings(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
