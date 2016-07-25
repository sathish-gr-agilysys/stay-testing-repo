/**
 * (C) 2015 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.api.params;

import org.joda.time.DateTime;
import org.joda.time.format.ISODateTimeFormat;

import com.agilysys.platform.common.exception.ValidationException;

public class InvoiceOptionalParams {
    private String expectedVersion;
    private String asOf;

    public InvoiceOptionalParams() {
    }

    public InvoiceOptionalParams(Long expectedVersion, DateTime asOf) {
        this.expectedVersion = expectedVersion != null ? String.valueOf(expectedVersion) : null;
        this.asOf = asOf != null ? String.valueOf(asOf) : null;
    }

    public InvoiceOptionalParams(DateTime asOf) {
        this(null, asOf);
    }

    public InvoiceOptionalParams(Long expectedVersion) {
        this(expectedVersion, null);
    }

    public Long getExpectedVersionNumber() {
        if (expectedVersion == null || "null".equalsIgnoreCase(expectedVersion.trim())) return null;

        try {
            return Long.parseLong(expectedVersion);
        } catch (Exception e) {
            throw new ValidationException("Failed to parse numeric value: " + expectedVersion);
        }
    }

    public DateTime getAsOfDateTime() {
        if (asOf == null || "null".equalsIgnoreCase(asOf.trim())) return null;

        try {
            return ISODateTimeFormat.dateTime().parseDateTime(asOf);
        } catch (Exception e) {
            throw new ValidationException("Failed to parse ISO date: " + asOf);
        }
    }

    public String getExpectedVersion() {
        return expectedVersion;
    }

    public void setExpectedVersion(String expectedVersionNumber) {
        if (expectedVersionNumber != null && !"null".equalsIgnoreCase(expectedVersionNumber.trim())) {
            this.expectedVersion = expectedVersionNumber;
        }
    }

    public String getAsOf() {
        return asOf;
    }

    public void setAsOf(String asOf) {
        if (asOf != null && !"null".equalsIgnoreCase(asOf.trim())) {
            this.asOf = asOf;
        }
    }

    @Override
    public String toString() {
        return String.format("expectedVersion=%s, asOf=%s", expectedVersion, asOf);
    }
}
