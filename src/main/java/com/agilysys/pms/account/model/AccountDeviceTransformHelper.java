/*
 * (C) 2022 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.math.BigDecimal;
import java.util.List;

import com.agilysys.intapp.model.GuestReservation;

public final class AccountDeviceTransformHelper {
    public static void initGuestReservation(GuestReservation guestReservation,
          List<EstimatedChargesView> estimatedChargesViews) {
        BigDecimal chargeAmount = toChargeAmount(estimatedChargesViews);
        guestReservation.setChargeAmount(chargeAmount);
    }

    public static BigDecimal toChargeAmount(List<EstimatedChargesView> estimatedChargesViews) {
        if (estimatedChargesViews == null) {
            return null;
        }

        BigDecimal chargeAmount = BigDecimal.ZERO;
        for (EstimatedChargesView estimatedChargesView : estimatedChargesViews) {
            List<RecurringChargeView> recurringCharges = estimatedChargesView.getRecurringCharges();
            if (recurringCharges != null) {
                for (RecurringChargeView recurringCharge : recurringCharges) {
                    BigDecimal normalizedAmount =
                          recurringCharge.getAmount().multiply(new BigDecimal(recurringCharge.getQuantity()));
                    chargeAmount = chargeAmount.add(normalizedAmount);
                }
            }
        }
        return chargeAmount;
    }
}
