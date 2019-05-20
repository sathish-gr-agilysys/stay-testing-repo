package com.agilysys.pms.account.client;

import com.agilysys.pms.account.api.TaxGroupsInterface;
import com.agilysys.pms.common.client.StayServiceClient;

public class TaxGroupsClient extends StayServiceClient<TaxGroupsInterface> {
    public TaxGroupsClient(String uri) {
        super(TaxGroupsInterface.class, uri);
    }
}
