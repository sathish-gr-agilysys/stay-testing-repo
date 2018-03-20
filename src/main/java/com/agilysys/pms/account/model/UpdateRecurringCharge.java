package com.agilysys.pms.account.model;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by PakkirisamyS on 20-03-2018.
 */
public class UpdateRecurringCharge extends CreateRecurringCharge {

    @JsonProperty(required = true)
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "RecurringCharge [id=" + id + ", agentId=" + getAgentId() + ", itemId=" + getItemId() + ", amount=" + getAmount() + ", reason=" +
              getReason() + ", frequency=" + getFrequencyType() + ", nNights=" + getnNights() + ", occurrenceDays=" +
              Arrays.toString(getOccurrenceDays().toArray()) + "]";
    }

    public UpdateRecurringCharge(String id, String agentId, String itemId, BigDecimal amount, String reason,
          FrequencyType frequencyType, int nNights, Set<Integer> occurrenceDays) {
        super(agentId, itemId, amount, reason, frequencyType, nNights, occurrenceDays);
        this.id = id;
    }

    public UpdateRecurringCharge() {

    }
}
