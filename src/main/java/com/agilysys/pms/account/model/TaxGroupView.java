package com.agilysys.pms.account.model;

import java.util.Set;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import com.google.common.collect.Sets;

public class TaxGroupView {
    private String id;
    private String name;
    private Set<String> memberNames = Sets.newHashSet();

    public TaxGroupView() {
    }

    public TaxGroupView(String name) {
        this.name = name;
    }

    public TaxGroupView(String name, Set<String> memberNames) {
        this.name = name;
        this.memberNames = memberNames;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<String> getMemberNames() {
        return memberNames;
    }

    public void setMemberNames(Set<String> memberNames) {
        this.memberNames = memberNames;
    }

    @Override
    public boolean equals(Object other) {
        if (other == null) return false;
        if (other == this) return true;
        if (other.getClass() != this.getClass()) return false;
        TaxGroupView rhs = (TaxGroupView) other;
        return new EqualsBuilder().append(name, rhs.name).append(memberNames, rhs.memberNames).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(47, 89).append(name).append(memberNames).toHashCode();
    }
}
