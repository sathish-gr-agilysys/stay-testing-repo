package com.agilysys.pms.account.model;

/**
 * Created by basus on 8/10/16.
 */
import java.util.List;

public class PostChargesRequest {

    private List<Charge> charges;

    public List<Charge> getCharges() {
        return charges;
    }

    public void setCharges(List<Charge> charges) {
        this.charges = charges;
    }
}
