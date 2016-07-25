/**
 * (C) 2013 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.exception;

import com.agilysys.platform.common.exception.ServiceException;

/**
 * Exception class for errors on posting any transaction (e.g. Charge, Payment,
 * Transfer) to an account
 */
public class AccountConcurrencyException extends ServiceException {

    private static final long serialVersionUID = 1566827235863760113L;

    public AccountConcurrencyException() {
        super();
    }

    public AccountConcurrencyException(String message) {
        super(message);
    }

    public AccountConcurrencyException(Throwable t) {
        super(t);
    }

    public AccountConcurrencyException(String message, Throwable t) {
        super(message, t);
    }

    @Override
    public Object getResponseEntity() {
        return null;
    }

}
