/*
 * (C) 2016 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import com.agilysys.pms.common.model.ThirdPartyConfirmation;
import com.agilysys.pms.common.util.JsonUtils;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class AccountAttributesTest {

    AccountAttributes accountAttributes = new AccountAttributes();

    @Test
    public void testCompareSelectedThirdPartyConfirmationsTrue() {
        Set<ThirdPartyConfirmation> defaultSettings = new HashSet<ThirdPartyConfirmation>();
        Set<ThirdPartyConfirmation> existingSettings = new HashSet<ThirdPartyConfirmation>();

        ThirdPartyConfirmation newTestObject1 = new ThirdPartyConfirmation("Test Name 1", "Test Number 1");
        ThirdPartyConfirmation newTestObject2 = new ThirdPartyConfirmation("Test Name 2", "Test Number 2");

        ThirdPartyConfirmation newTestObject3 = new ThirdPartyConfirmation("Test Name 1", "Test Number 1");
        ThirdPartyConfirmation newTestObject4 = new ThirdPartyConfirmation("Test Name 2", "Test Number 2");

        defaultSettings.add(newTestObject1);
        defaultSettings.add(newTestObject2);

        existingSettings.add(newTestObject3);
        existingSettings.add(newTestObject4);

        Assert.assertTrue(accountAttributes.compareSelectedThirdPartyConfirmations(defaultSettings, existingSettings));

    }

    @Test
    public void testCompareSelectedThirdPartyConfirmationsFalse() {
        Set<ThirdPartyConfirmation> defaultSettings = new HashSet<ThirdPartyConfirmation>();
        Set<ThirdPartyConfirmation> existingSettings = new HashSet<ThirdPartyConfirmation>();

        ThirdPartyConfirmation newTestObject1 = new ThirdPartyConfirmation("Test Name 1", "Test Number 1");
        ThirdPartyConfirmation newTestObject2 = new ThirdPartyConfirmation("Test Name 2", "Test Number 2");

        ThirdPartyConfirmation newTestObject3 = new ThirdPartyConfirmation("Test Name 1", "Test Number 1");
        ThirdPartyConfirmation newTestObject4 = new ThirdPartyConfirmation("Test Name 4", "Test Number 4");

        defaultSettings.add(newTestObject1);
        defaultSettings.add(newTestObject2);

        existingSettings.add(newTestObject3);
        existingSettings.add(newTestObject4);

        Assert.assertFalse(accountAttributes.compareSelectedThirdPartyConfirmations(defaultSettings, existingSettings));

    }
}