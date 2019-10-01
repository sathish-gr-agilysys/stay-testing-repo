/*
 * (C) 2019 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */

package com.agilysys.pms.account.model;

import java.util.ArrayList;
import java.util.List;

public class EligibleFolioLineItems {
    private List<LineItemView> lineItemViews;
    private String authorizerId;
    private String departmentId;

    public EligibleFolioLineItems() {
        lineItemViews = new ArrayList<>();
    }

    public EligibleFolioLineItems(List<LineItemView> lineItemViews, String authorizerId, String departmentId) {
        this.lineItemViews = lineItemViews;
        this.authorizerId = authorizerId;
        this.departmentId = departmentId;
    }

    public List<LineItemView> getLineItemViews() {
        return lineItemViews;
    }

    public void setLineItemViews(List<LineItemView> lineItemViews) {
        this.lineItemViews = lineItemViews;
    }

    public String getAuthorizerId() {
        return authorizerId;
    }

    public void setAuthorizerId(String authorizerId) {
        this.authorizerId = authorizerId;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }
}
