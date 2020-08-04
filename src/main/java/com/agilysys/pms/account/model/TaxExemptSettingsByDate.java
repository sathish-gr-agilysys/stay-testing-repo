/**
 * (C) 2014 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.util.List;
import java.util.Map;

import org.joda.time.LocalDate;

import com.agilysys.common.json.serialize.LocalDateJsonKeyDeserializer;
import com.agilysys.platform.common.json.schema.MinLengthRestriction;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * Tax exempt settings for individual dates.
 */
public class TaxExemptSettingsByDate extends TaxExemptSettings {
    @JsonProperty(required = true)
    @MinLengthRestriction(1)
    @JsonDeserialize(keyUsing = LocalDateJsonKeyDeserializer.class)
    private Map<LocalDate, List<String>> exemptions;

    public Map<LocalDate, List<String>> getExemptions() {
        return this.exemptions;
    }

    public void setExemptions(Map<LocalDate, List<String>> exemptions) {
        this.exemptions = exemptions;
    }
}