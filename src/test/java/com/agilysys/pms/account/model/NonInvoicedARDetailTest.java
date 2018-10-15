/**
 * (C) 2018 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class NonInvoicedARDetailTest {

    NonInvoicedARDetail nonInvoicedARDetail;
    NonInvoicedSourceAccountDetail nonInvoicedSourceAccountDetail;
    GroupNonInvoicedDetail groupNonInvoicedDetail;
    BigDecimal charges;
    BigDecimal payments;

    @Before
    public void setup() {
        nonInvoicedARDetail = new NonInvoicedARDetail();
        nonInvoicedSourceAccountDetail = new NonInvoicedSourceAccountDetail();
        groupNonInvoicedDetail = new GroupNonInvoicedDetail();
        charges = new BigDecimal(5);
        payments = new BigDecimal(7);

        groupNonInvoicedDetail.setNonInvoicedChargesBalance(BigDecimal.TEN);
        groupNonInvoicedDetail.setNonInvoicedChargesTaxBalance(charges);
        groupNonInvoicedDetail.setNonInvoicedPaymentsTotalBalance(payments);

        nonInvoicedSourceAccountDetail.setNonInvoicedChargesBalance(BigDecimal.TEN);
        nonInvoicedSourceAccountDetail.setNonInvoicedChargesTaxBalance(charges);
        nonInvoicedSourceAccountDetail.setNonInvoicedPaymentsTotalBalance(payments);
    }

    @Test
    public void testBalanceWithGroupOnly(){
        nonInvoicedARDetail.setGroupNonInvoicedDetails(Arrays.asList(groupNonInvoicedDetail));

        assertEquals(BigDecimal.TEN, nonInvoicedARDetail.getNonInvoicedChargesBalance());
        assertEquals(charges, nonInvoicedARDetail.getNonInvoicedChargesTaxBalance());
        assertEquals(payments, nonInvoicedARDetail.getNonInvoicedPaymentsTotalBalance());
    }

    @Test
    public void testBalanceWithNonGroupOnly(){
        nonInvoicedARDetail.setNonGroupNonInvoicedDetails(Arrays.asList(nonInvoicedSourceAccountDetail));

        assertEquals(BigDecimal.TEN, nonInvoicedARDetail.getNonInvoicedChargesBalance());
        assertEquals(charges, nonInvoicedARDetail.getNonInvoicedChargesTaxBalance());
        assertEquals(payments, nonInvoicedARDetail.getNonInvoicedPaymentsTotalBalance());
    }

    @Test
    public void testBalanceWithGroupAndNonGroup(){

        nonInvoicedARDetail.setGroupNonInvoicedDetails(Arrays.asList(groupNonInvoicedDetail));
        nonInvoicedARDetail.setNonGroupNonInvoicedDetails(Arrays.asList(nonInvoicedSourceAccountDetail));

        assertEquals(new BigDecimal(20), nonInvoicedARDetail.getNonInvoicedChargesBalance());
        assertEquals(BigDecimal.TEN, nonInvoicedARDetail.getNonInvoicedChargesTaxBalance());
        assertEquals(new BigDecimal(14), nonInvoicedARDetail.getNonInvoicedPaymentsTotalBalance());
    }
}
