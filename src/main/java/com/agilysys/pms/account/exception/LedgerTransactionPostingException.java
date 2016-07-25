/**
 * (C) 2013 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.exception;

import com.agilysys.platform.common.exception.ServiceException;

/**
 * Exception class for errors posting ledger transactions
 */
public class LedgerTransactionPostingException extends ServiceException {

    private static final long serialVersionUID = 7389342432318650800L;

    public LedgerTransactionPostingException() {
        super();
    }

    public LedgerTransactionPostingException(String message) {
        super(message);
    }

    public LedgerTransactionPostingException(Throwable t) {
        super(t);
    }

    public LedgerTransactionPostingException(String message, Throwable t) {
        super(message, t);
    }

    @Override
    public Object getResponseEntity() {
        return null;
    }
}
