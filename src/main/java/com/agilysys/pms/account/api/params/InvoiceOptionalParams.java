/**
 * (C) 2015 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.api.params;

import static com.agilysys.pms.common.exceptions.ExceptionFactory.accountException;
import static com.agilysys.pms.common.exceptions.account.AccountContextKey.VALUE;

import org.joda.time.DateTime;
import org.joda.time.format.ISODateTimeFormat;

import com.agilysys.pms.common.exceptions.account.AccountErrorCode;

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
            throw accountException(AccountErrorCode.NUMBER_PARSE_FAILED).put(VALUE, expectedVersion).cause(e)
                  .buildCompatible();
        }
    }

    public DateTime getAsOfDateTime() {
        if (asOf == null || "null".equalsIgnoreCase(asOf.trim())) return null;

        try {
            return ISODateTimeFormat.dateTime().parseDateTime(asOf);
        } catch (Exception e) {
            throw accountException(AccountErrorCode.DATE_PARSE_FAILED).put(VALUE, asOf).cause(e).buildCompatible();
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
