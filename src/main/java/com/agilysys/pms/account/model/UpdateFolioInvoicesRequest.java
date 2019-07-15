/*
 * (C) 2019 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

public class UpdateFolioInvoicesRequest {

    private String sourceProfileId;
    private String destinationProfileId;

    public UpdateFolioInvoicesRequest() {}

    public UpdateFolioInvoicesRequest(String sourceProfileId, String destinationProfileId) {
        this.sourceProfileId = sourceProfileId;
        this.destinationProfileId = destinationProfileId;
    }

    public String getSourceProfileId() {
        return sourceProfileId;
    }

    public void setSourceProfileId(String sourceProfileId) {
        this.sourceProfileId = sourceProfileId;
    }

    public String getDestinationProfileId() {
        return destinationProfileId;
    }

    public void setDestinationProfileId(String destinationProfileId) {
        this.destinationProfileId = destinationProfileId;
    }
}
