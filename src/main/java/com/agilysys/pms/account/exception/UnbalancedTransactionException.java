/**
 * (C) 2013 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.exception;

import com.agilysys.platform.common.exception.ServiceException;

/**
 * Exception class for ledger transactions not being balanced on insert attempt.
 */
public class UnbalancedTransactionException extends ServiceException {
    private static final long serialVersionUID = -5806375187344271435L;

    public UnbalancedTransactionException() {
        super();
    }

    public UnbalancedTransactionException(String message) {
        super(message);
    }

    public UnbalancedTransactionException(Throwable t) {
        super(t);
    }

    public UnbalancedTransactionException(String message, Throwable t) {
        super(message, t);
    }

    @Override
    public Object getResponseEntity() {
        return null;
    }
}
