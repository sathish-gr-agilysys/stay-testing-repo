package com.agilysys.pms.account.model;

/**
 * (C) 2013 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
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
