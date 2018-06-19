package com.agilysys.pms.account.client;

import com.agilysys.pms.account.api.HouseAccountCategoryInterface;
import com.agilysys.pms.common.client.StayServiceClient;

public class HouseAccountCategoryServiceClient extends StayServiceClient<HouseAccountCategoryInterface> {
    
    public HouseAccountCategoryServiceClient(String uri) {
        super(HouseAccountCategoryInterface.class, uri);
    }
}
