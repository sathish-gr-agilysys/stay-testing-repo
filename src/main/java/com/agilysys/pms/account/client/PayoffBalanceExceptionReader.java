/**
 * (C) 2016 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.client;

import javax.ws.rs.core.Response;

import com.agilysys.platform.common.exception.ApplicationRuntimeException;
import com.agilysys.pms.account.exception.PayoffBalanceException;
import com.agilysys.pms.account.model.PayoffBalanceErrorResult;
import com.agilysys.pms.common.client.TransitiveExceptionReader;
import com.agilysys.pms.common.exceptions.account.AccountErrorCode;

@Deprecated
public class PayoffBalanceExceptionReader
      extends TransitiveExceptionReader<PayoffBalanceErrorResult, PayoffBalanceException> {
    @Override
    protected PayoffBalanceErrorResult readPayload(Response response) {
        try {
            PayoffBalanceErrorResult errorResult = response.readEntity(PayoffBalanceErrorResult.class);
            if (errorResult != null && errorResult.getCode() == AccountErrorCode.PAYOFF_BALANCE_FAILED) {
                return errorResult;
            }
        } catch (Exception e) {
            // do nothing
        }
        return null;
    }

    @Override
    protected PayoffBalanceErrorResult handleInvalidResponse(Response response) {
        throw new ApplicationRuntimeException("Unable to parse response [" + response.toString() + "]");
    }

    @Override
    protected PayoffBalanceException mapPayloadToException(Response response,
          PayoffBalanceErrorResult payoffBalanceErrorResult) {
        return new PayoffBalanceException(payoffBalanceErrorResult.getMessage(), payoffBalanceErrorResult);
    }
}
