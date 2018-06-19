package com.agilysys.pms.account.model;

/**
 * EVERY = Every Night
 * FIRST = First Night Only
 * LAST = Last Night Only
 * EVERY_N = Every N Nights, nNights must be set > 0
 * DAYS_OF_WEEK = Specific days of the week, occurrenceDays must be set
 */
public enum FrequencyType {
    EVERY,
    FIRST,
    LAST,
    EVERY_N,
    DAYS_OF_WEEK;
}
