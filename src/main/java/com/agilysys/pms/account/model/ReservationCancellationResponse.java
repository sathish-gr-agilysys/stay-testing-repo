package com.agilysys.pms.account.model;

import java.util.HashMap;
import java.util.Map;

public class ReservationCancellationResponse {

    private Map<String, PostCancellationDetail> postCancellationDetailMap = new HashMap<>();

    public Map<String, PostCancellationDetail> getPostCancellationDetailMap() {
        return postCancellationDetailMap;
    }

    public void setPostCancellationDetailMap(Map<String, PostCancellationDetail> postCancellationDetailMap) {
        this.postCancellationDetailMap = postCancellationDetailMap;
    }
}
