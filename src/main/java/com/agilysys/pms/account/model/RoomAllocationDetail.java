package com.agilysys.pms.account.model;

import java.util.List;

import com.agilysys.pms.property.model.AllocatedRoomDetail;

/**
 * Created by MuthalurajG on 10/30/2017.
 */
public class RoomAllocationDetail {

    List<AllocatedRoomDetail> roomAllocationDetailList;

    public List<AllocatedRoomDetail> getRoomAllocationDetailList() {
        return roomAllocationDetailList;
    }

    public void setRoomAllocationDetailList(List<AllocatedRoomDetail> roomAllocationDetailList) {
        this.roomAllocationDetailList = roomAllocationDetailList;
    }
}
