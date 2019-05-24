/**
 * (C) 2013 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.client;

import com.agilysys.pms.account.api.TransactionCategoryConfigServiceInterface;
import com.agilysys.pms.common.client.StayServiceClient;

/**
 * Client proxy for {@link TransactionCategoryConfigServiceInterface}
 */
public class TransactionCategoryServiceClient extends StayServiceClient<TransactionCategoryConfigServiceInterface> {
    public TransactionCategoryServiceClient(String uri) {
        super(TransactionCategoryConfigServiceInterface.class, uri);
    }
}
