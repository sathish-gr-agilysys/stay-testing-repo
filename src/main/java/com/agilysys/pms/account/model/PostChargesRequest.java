package com.agilysys.pms.account.model;


import java.util.List;

public class PostChargesRequest {

    private List<Charge> charges;

    private GroupedCharge group;

    public List<Charge> getCharges() {
        return charges;
    }

    public void setCharges(List<Charge> charges) {
        this.charges = charges;
    }

    public GroupedCharge getGroup() {
        return group;
    }

    public void setGroup(GroupedCharge group) {
        this.group = group;
    }
}
