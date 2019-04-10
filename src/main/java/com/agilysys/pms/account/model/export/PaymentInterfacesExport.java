/**
 * (C) 2016 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model.export;

import com.agilysys.intapp.model.export.BillingRestrictionExport;
import com.agilysys.intapp.model.export.CallRestrictionExport;
import com.agilysys.intapp.model.export.GameRestrictionExport;
import com.agilysys.intapp.model.export.MovieRestrictionExport;

public class PaymentInterfacesExport {
    private CallRestrictionExport callRestriction;
    private MovieRestrictionExport movieRestriction;
    private GameRestrictionExport gameRestriction;
    private BillingRestrictionExport billingRestriction;

    public CallRestrictionExport getCallRestriction() {
        return callRestriction;
    }

    public void setCallRestriction(CallRestrictionExport callRestriction) {
        this.callRestriction = callRestriction;
    }

    public MovieRestrictionExport getMovieRestriction() {
        return movieRestriction;
    }

    public void setMovieRestriction(MovieRestrictionExport movieRestriction) {
        this.movieRestriction = movieRestriction;
    }

    public GameRestrictionExport getGameRestriction() {
        return gameRestriction;
    }

    public void setGameRestriction(GameRestrictionExport gameRestriction) {
        this.gameRestriction = gameRestriction;
    }

    public BillingRestrictionExport getBillingRestriction() {
        return billingRestriction;
    }

    public void setBillingRestriction(BillingRestrictionExport billingRestriction) {
        this.billingRestriction = billingRestriction;
    }
}
