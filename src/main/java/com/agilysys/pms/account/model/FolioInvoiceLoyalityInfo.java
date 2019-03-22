package com.agilysys.pms.account.model;

import java.util.List;

import com.agilysys.platform.guestprofile.model.RewardIntegrationMetaData;

public class FolioInvoiceLoyalityInfo {

    private List<RewardIntegrationMetaData> rewardIntegrationMetaDataList;

    public List<RewardIntegrationMetaData> getRewardIntegrationMetaDataList() {
        return rewardIntegrationMetaDataList;
    }

    public void setRewardIntegrationMetaDataList(List<RewardIntegrationMetaData> rewardIntegrationMetaDataList) {
        this.rewardIntegrationMetaDataList = rewardIntegrationMetaDataList;
    }
}
