/**
 * (C) 2015 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.util.Set;

import com.agilysys.pms.common.model.CollectionRequest;
import com.google.common.collect.Sets;

public class AccountsCollectionRequest extends CollectionRequest {
    private Set<String> accountNumbers = Sets.newHashSet();

    public Set<String> getAccountNumbers() {
        return accountNumbers;
    }

    public void setAccountNumbers(Set<String> accountNumbers) {
        this.accountNumbers = accountNumbers;
    }
}
