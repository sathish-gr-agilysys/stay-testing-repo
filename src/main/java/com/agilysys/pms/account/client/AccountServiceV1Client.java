package com.agilysys.pms.account.client;

import com.agilysys.pms.account.api.AccountServiceInterfaceV1;
import com.agilysys.pms.common.client.StayServiceClient;

public class AccountServiceV1Client extends StayServiceClient<AccountServiceInterfaceV1> {
    public AccountServiceV1Client(String uri) {
        super(AccountServiceInterfaceV1.class, uri);
    }
}
