package com.agilysys.pms.account.model;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import com.agilysys.common.template.TemplateData;

public class BreakDown implements TemplateData {
    private String id;
    private String name;
    private BigDecimal value;

    public BreakDown() {
    }

    public BreakDown(String id, String name, BigDecimal value) {
        this.id = id;
        this.name = name;
        this.value = value;
    }

    public BreakDown(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    @Override
    public Map<String, Object> rawFields() {
        Map<String, Object> rawFieldMap = new HashMap<>(1);
        if (value != null) {
            rawFieldMap.put(TemplateData.rawField("value"), value);
        }

        return rawFieldMap;
    }
}
