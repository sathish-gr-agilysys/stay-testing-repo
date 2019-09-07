/*
 * (C) 2019 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model.invoice.folio.detail;

import java.util.List;
import java.util.Set;

import com.agilysys.pms.account.model.invoice.folio.InvoicedSourceAccountFolioView;
import com.agilysys.pms.common.model.ThirdPartyConfirmation;
import com.agilysys.pms.profile.model.AddressDetails;

public class InvoicedSourceAccountDetailView extends InvoicedSourceAccountFolioView<InvoiceFolioLineDetailView> {
    private List<String> additionalGuestDetails;
    private AddressDetails addressDetails;
    private String referenceId;
    private String reservationAlias;
    private String sourceAccountName;
    private String sourceAccountType;
    private Set<ThirdPartyConfirmation> thirdPartyConfirmation;

    public List<String> getAdditionalGuestDetails() {
        return additionalGuestDetails;
    }

    public void setAdditionalGuestDetails(List<String> additionalGuestDetails) {
        this.additionalGuestDetails = additionalGuestDetails;
    }

    public AddressDetails getAddressDetails() {
        return addressDetails;
    }

    public void setAddressDetails(AddressDetails addressDetails) {
        this.addressDetails = addressDetails;
    }

    public String getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(String referenceId) {
        this.referenceId = referenceId;
    }

    public String getReservationAlias() {
        return reservationAlias;
    }

    public void setReservationAlias(String reservationAlias) {
        this.reservationAlias = reservationAlias;
    }

    public String getSourceAccountName() {
        return sourceAccountName;
    }

    public void setSourceAccountName(String sourceAccountName) {
        this.sourceAccountName = sourceAccountName;
    }

    public String getSourceAccountType() {
        return sourceAccountType;
    }

    public void setSourceAccountType(String sourceAccountType) {
        this.sourceAccountType = sourceAccountType;
    }

    public Set<ThirdPartyConfirmation> getThirdPartyConfirmation() {
        return thirdPartyConfirmation;
    }

    public void setThirdPartyConfirmation(Set<ThirdPartyConfirmation> thirdPartyConfirmation) {
        this.thirdPartyConfirmation = thirdPartyConfirmation;
    }
}
