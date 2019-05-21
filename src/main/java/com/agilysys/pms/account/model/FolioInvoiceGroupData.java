/*
 * (C) 2019 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import com.agilysys.pms.profile.model.LinkedGuestProfileDetails;

public class FolioInvoiceGroupData {

    private String groupId;
    private String groupName;
    private LinkedGuestProfileDetails linkedGuestProfileDetails;

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public LinkedGuestProfileDetails getLinkedGuestProfileDetails() {
        return linkedGuestProfileDetails;
    }

    public void setLinkedGuestProfileDetails(LinkedGuestProfileDetails linkedGuestProfileDetails) {
        this.linkedGuestProfileDetails = linkedGuestProfileDetails;
    }
}
