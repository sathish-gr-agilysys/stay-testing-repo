package com.agilysys.pms.account.model;

import java.util.List;
import java.util.Map;

public class TaxSummaryConfig {
    private String id;
    private String tenantId;
    private String propertyId;
    private String description;
    private boolean active;
    private Map<String, List<String>> mappings;


    public TaxSummaryConfig() {
    }

    public TaxSummaryConfig(String tenantId, String propertyId, String description, boolean active, Map<String, List<String>> mappings) {
        this.tenantId = tenantId;
        this.propertyId = propertyId;
        this.description = description;
        this.active = active;
        this.mappings = mappings;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public String getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(String propertyId) {
        this.propertyId = propertyId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Map<String, List<String>> getMappings() {
        return mappings;
    }

    public void setMappings(Map<String, List<String>> mappings) {
        this.mappings = mappings;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
