package com.agilysys.pms.account.model;

import java.util.List;

public class FolioTaxBreakDown {
    private String _id;
    private String description;
    private List<BreakDown> breakDown;

    public FolioTaxBreakDown() {
    }

    public FolioTaxBreakDown(String _id, String description, List<BreakDown> breakDown) {
        this._id = _id;
        this.description = description;
        this.breakDown = breakDown;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<BreakDown> getBreakDown() {
        return breakDown;
    }

    public void setBreakDown(List<BreakDown> breakDown) {
        this.breakDown = breakDown;
    }
}
