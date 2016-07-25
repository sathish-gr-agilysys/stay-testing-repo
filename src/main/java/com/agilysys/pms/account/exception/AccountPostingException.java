/**
 * (C) 2013 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.exception;

import com.agilysys.platform.common.exception.ServiceException;
import com.agilysys.pms.account.model.AccountErrorCode;

/**
 * Exception class for errors on posting any transaction (e.g. Charge, Payment, Transfer) to an account
 */
public class AccountPostingException extends ServiceException {
    private AccountPostingError accountPostingError;

    private static final long serialVersionUID = -1070269454713388735L;

    public AccountPostingException(String message) {
        super(message);
        accountPostingError = new AccountPostingError();
        accountPostingError.setErrorCode(AccountErrorCode.GENERAL_ACCOUNT_ERROR.getCode());
        accountPostingError.setDescription(message);
    }

    public AccountPostingException(AccountPostingError error) {
        super(error.getDescription());
        accountPostingError = error;
    }

    public AccountPostingException(String message, AccountErrorCode reasonCode) {
        super(message);
        accountPostingError = new AccountPostingError();
        accountPostingError.setErrorCode(reasonCode.getCode());
        accountPostingError.setDescription(message);
    }

    @Override
    public Object getResponseEntity() {
        return accountPostingError;
    }
}
