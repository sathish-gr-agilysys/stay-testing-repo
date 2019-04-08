/**
 * (C) 2016 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.agilysys.pms.common.util.JsonUtils;

public class TransactionItemTest {

    @Test
    public void testPlu() {
        TransactionItem item = new TransactionItem();
        item.setPlu("1234");

        String json = JsonUtils.toJson(item);
        assertTrue(json.contains("plu"));

        item.setPlu("");
        json = JsonUtils.toJson(item);
        assertFalse(json.contains("plu"));
    }
}
