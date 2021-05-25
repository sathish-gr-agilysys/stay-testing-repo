/*
 * (C) 2019 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.api;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.agilysys.platform.common.rguest.exception.RGuestException;
import com.agilysys.pms.account.model.LedgerSettingView;
import com.agilysys.pms.common.api.annotation.CreatedOnSuccess;
import com.agilysys.pms.common.security.Permission;
import com.agilysys.pms.common.security.Requires;

@Path("/tenants/{tenantId}/properties/{propertyId}/ledgerSettings")
public interface LedgerSettingsInterface {
    String TENANT_ID = "tenantId";
    String PROPERTY_ID = "propertyId";
    String LEDGER_SETTING_ID = "ledgerSettingId";
    String LEDGER_SETTING_ID_PATH = "/{ledgerSettingId}";

    @POST
    @CreatedOnSuccess
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Requires(Permission.WRITE_ACCOUNTS)
    LedgerSettingView createLedgerSetting(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, LedgerSettingView ledgerSetting) throws RGuestException;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Requires(Permission.READ_ACCOUNTS)
    List<LedgerSettingView> getAllLedgerSettings(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId) throws RGuestException;

    @GET
    @Path(LEDGER_SETTING_ID_PATH)
    @Requires(Permission.READ_ACCOUNTS)
    @Produces(MediaType.APPLICATION_JSON)
    LedgerSettingView getLedgerSetting(@PathParam(TENANT_ID) String tenantId, @PathParam(PROPERTY_ID) String propertyId,
          @PathParam(LEDGER_SETTING_ID) String ledgerSettingId) throws RGuestException;

    @PUT
    @Path(LEDGER_SETTING_ID_PATH)
    @Requires(Permission.WRITE_ACCOUNTS)
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    LedgerSettingView updateLedgerSetting(@PathParam(TENANT_ID) String tenantId,
          @PathParam(PROPERTY_ID) String propertyId, @PathParam(LEDGER_SETTING_ID) String ledgerSettingId,
          LedgerSettingView ledgerSetting) throws RGuestException;
}