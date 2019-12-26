/*
 * (C) 2019 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

public class HtngCategory extends AccountingObjectBase {
    private static final String DISPLAY_NAME = "Htng category";
    private String htngCode;
    private String htngDescription;

    public String getHtngCode() {
        return htngCode;
    }

    public void setHtngCode(String htngCode) {
        this.htngCode = htngCode;
    }

    public String getHtngDescription() {
        return htngDescription;
    }

    public void setHtngDescription(String htngDescription) {
        this.htngDescription = htngDescription;
    }

    @Override
    public String getDisplayName() {
        return DISPLAY_NAME;
    }
}
