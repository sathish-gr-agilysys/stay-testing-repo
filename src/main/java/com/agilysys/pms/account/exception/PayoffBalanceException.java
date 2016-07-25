package com.agilysys.pms.account.exception;

import java.util.Map;

import com.agilysys.platform.common.exception.ServiceException;
import com.google.common.collect.Maps;

public class PayoffBalanceException extends ServiceException {
    private Map<String, String> errors = Maps.newHashMap();

    public PayoffBalanceException() {}

    public PayoffBalanceException(String message) {
        super(message);
    }

    public PayoffBalanceException(String message, Map<String, String> errors) {
        this(message);
        this.errors = errors;
    }

    public Map<String, String> getErrors() {
        return errors;
    }

    public void setErrors(Map<String, String> errors) {
        this.errors = errors;
    }

    @Override
    public Object getResponseEntity() {
        return errors;
    }
}
