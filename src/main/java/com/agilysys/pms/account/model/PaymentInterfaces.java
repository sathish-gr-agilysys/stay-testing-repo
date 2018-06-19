/**
 * (C) 2015 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import com.agilysys.intapp.model.BillingRestriction;
import com.agilysys.intapp.model.CallRestriction;
import com.agilysys.intapp.model.GameRestriction;
import com.agilysys.intapp.model.MovieRestriction;

public class PaymentInterfaces {
    private CallRestriction callRestriction;
    private MovieRestriction movieRestriction;
    private GameRestriction gameRestriction;
    private BillingRestriction billingRestriction;

    public CallRestriction getCallRestriction() {
        return callRestriction;
    }

    public void setCallRestriction(CallRestriction callRestriction) {
        this.callRestriction = callRestriction;
    }

    public MovieRestriction getMovieRestriction() {
        return movieRestriction;
    }

    public void setMovieRestriction(MovieRestriction movieRestriction) {
        this.movieRestriction = movieRestriction;
    }

    public GameRestriction getGameRestriction() {
        return gameRestriction;
    }

    public void setGameRestriction(GameRestriction gameRestriction) {
        this.gameRestriction = gameRestriction;
    }

    public BillingRestriction getBillingRestriction() {
        return billingRestriction;
    }

    public void setBillingRestriction(BillingRestriction billingRestriction) {
        this.billingRestriction = billingRestriction;
    }
}
