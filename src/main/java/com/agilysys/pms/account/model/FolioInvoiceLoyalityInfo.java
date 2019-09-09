/*
 * (C) 2019 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.util.List;

import com.agilysys.platform.guestprofile.model.RewardIntegrationMetaData;

public class FolioInvoiceLoyalityInfo {

    private List<FolioInvoiceReservationLoyaltyInfo> folioInvoiceReservationLoyaltyInfos;
    private List<RewardIntegrationMetaData> rewardIntegrationMetaDataList;

    public List<FolioInvoiceReservationLoyaltyInfo> getFolioInvoiceReservationLoyaltyInfo() {
        return folioInvoiceReservationLoyaltyInfos;
    }

    public void setFolioInvoiceReservationLoyaltyInfo(
          List<FolioInvoiceReservationLoyaltyInfo> folioInvoiceReservationLoyaltyInfos) {
        this.folioInvoiceReservationLoyaltyInfos = folioInvoiceReservationLoyaltyInfos;
    }

    public List<RewardIntegrationMetaData> getRewardIntegrationMetaDataList() {
        return rewardIntegrationMetaDataList;
    }

    public void setRewardIntegrationMetaDataList(List<RewardIntegrationMetaData> rewardIntegrationMetaDataList) {
        this.rewardIntegrationMetaDataList = rewardIntegrationMetaDataList;
    }
}
