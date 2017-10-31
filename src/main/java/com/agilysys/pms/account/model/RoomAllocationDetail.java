/**
 * (C) 2017 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.util.List;

import com.agilysys.pms.property.model.AllocatedRoomDetail;

public class RoomAllocationDetail {

    List<AllocatedRoomDetail> roomAllocationDetailList;

    public List<AllocatedRoomDetail> getRoomAllocationDetailList() {
        return roomAllocationDetailList;
    }

    public void setRoomAllocationDetailList(List<AllocatedRoomDetail> roomAllocationDetailList) {
        this.roomAllocationDetailList = roomAllocationDetailList;
    }
}
