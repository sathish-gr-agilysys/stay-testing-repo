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
    private String authorizerName;
    private String departmentName;
    private Boolean tax;
    private Boolean taxFollowsPosting;

    public EligibleFolioLineItems() {
        lineItemViews = new ArrayList<>();
    }

    public EligibleFolioLineItems(List<LineItemView> lineItemViews, String authorizerId, String departmentId,
          String authorizerName, String departmentName, Boolean tax, Boolean taxFollowsPosting) {
        this.lineItemViews = lineItemViews;
        this.authorizerId = authorizerId;
        this.departmentId = departmentId;
        this.authorizerName = authorizerName;
        this.departmentName = departmentName;
        this.tax = tax;
        this.taxFollowsPosting = taxFollowsPosting;
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

    public String getAuthorizerName() {
        return authorizerName;
    }

    public void setAuthorizerName(String authorizerName) {
        this.authorizerName = authorizerName;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public Boolean getTax() {
        return tax;
    }

    public void setTax(Boolean tax) {
        this.tax = tax;
    }

    public Boolean getTaxFollowsPosting() {
        return taxFollowsPosting;
    }

    public void setTaxFollowsPosting(Boolean taxFollowsPosting) {
        this.taxFollowsPosting = taxFollowsPosting;
    }
}
