/**
 * (C) 2013 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.exception;

import com.agilysys.platform.common.exception.ServiceException;

/**
 * Exception class for ledger not balanced.
 */
public class UnbalancedLedgerException extends ServiceException {

    private static final long serialVersionUID = -1671075733751482215L;

    public UnbalancedLedgerException() {
        super();
    }

    public UnbalancedLedgerException(String message) {
        super(message);
    }

    public UnbalancedLedgerException(Throwable t) {
        super(t);
    }

    public UnbalancedLedgerException(String message, Throwable t) {
        super(message, t);
    }

    @Override
    public Object getResponseEntity() {
        return null;
    }
}
