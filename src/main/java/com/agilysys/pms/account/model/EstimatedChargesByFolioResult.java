package com.agilysys.pms.account.model;

import java.util.Map;

public class EstimatedChargesByFolioResult {
    private Map<String, EstimatedChargesView> esimatedChargesByFolioId;

    public Map<String, EstimatedChargesView> getEsimatedChargesByFolioId() {
        return esimatedChargesByFolioId;
    }

    public void setEsimatedChargesByFolioId(Map<String, EstimatedChargesView> esimatedChargesByFolioId) {
        this.esimatedChargesByFolioId = esimatedChargesByFolioId;
    }
}
