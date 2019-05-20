package com.agilysys.pms.account.client;

import com.agilysys.pms.common.api.export.ExportServiceInterface;
import com.agilysys.pms.common.client.StayServiceClient;

public class AccountExportServiceClient extends StayServiceClient<ExportServiceInterface> {
    public AccountExportServiceClient(String baseUri) {
        super(ExportServiceInterface.class, baseUri);
    }
}