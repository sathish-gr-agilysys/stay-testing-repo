/**
 * (C) 2018 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.joda.time.LocalDate;

import com.agilysys.pms.account.model.AccountAttributes.PreferredCommunication;

public class ARBalanceInfo {
    private String tenantId;
    private List<String> ageGroupLabels;
    private List<CompanyBalanceInfo> companyProfiles;

    private Map<String, LocalDate> propertyDateMap;

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public List<String> getAgeGroupLabels() {
        return ageGroupLabels;
    }

    public void setAgeGroupLabels(List<String> ageGroupLabels) {
        this.ageGroupLabels = ageGroupLabels;
    }

    public List<CompanyBalanceInfo> getCompanyProfiles() {
        return companyProfiles;
    }

    public void setCompanyProfiles(List<CompanyBalanceInfo> companyProfiles) {
        this.companyProfiles = companyProfiles;
    }

    public Map<String, LocalDate> getPropertyDateMap() {
        return propertyDateMap;
    }

    public void setPropertyDateMap(Map<String, LocalDate> propertyDateMap) {
        this.propertyDateMap = propertyDateMap;
    }

    public static class CompanyBalanceInfo {
        private String id;
        private String name;
        private PreferredCommunication deliveryPreference;
        private String email;

        private List<BigDecimal> invoiceTotalsByAging; //invoiceTotalByAgeGroup
        private BigDecimal unInvoicedTotal; // sum(unInvoicedCharges)

        private List<PropertyBalanceInfo> properties;

        public CompanyBalanceInfo(String id, String name) {
            this.id = id;
            this.name = name;
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

        public PreferredCommunication getDeliveryPreference() {
            return deliveryPreference;
        }

        public void setDeliveryPreference(PreferredCommunication deliveryPreference) {
            this.deliveryPreference = deliveryPreference;
        }

        public String getEmail() { return email; }

        public void setEmail(String email) { this.email = email; }

        public List<BigDecimal> getInvoiceTotalsByAging() { return invoiceTotalsByAging; }

        public void setInvoiceTotalsByAging(List<BigDecimal> invoiceTotalsByAging) {
            this.invoiceTotalsByAging = invoiceTotalsByAging;
        }

        public BigDecimal getInvoiceTotal() { // invoiceTotal = sum(invoiceTotalsByAgeGroups)
            if (invoiceTotalsByAging == null ) return BigDecimal.ZERO;
            return invoiceTotalsByAging.stream().reduce(BigDecimal.ZERO, BigDecimal::add);
        }

        public BigDecimal getUnInvoicedTotal() {
            return unInvoicedTotal;
        }

        public void setUnInvoicedTotal(BigDecimal unInvoicedTotal) {
            this.unInvoicedTotal = unInvoicedTotal;
        }

        public BigDecimal getBalance() {
            return getInvoiceTotal().add(getUnInvoicedTotal()); // balance = subTotal + unInvoicedTotal
        }

        public List<PropertyBalanceInfo> getProperties() {
            return properties;
        }

        public void setProperties(List<PropertyBalanceInfo> properties) {
            this.properties = properties;
        }

        public static class PropertyBalanceInfo {
            private String id;
            private String name;
            private PreferredCommunication deliveryPreference = PreferredCommunication.Print;

            private String accountId;
            private String email;

            private boolean readOnly;
            private boolean closed;

            private List<BigDecimal> invoiceTotalsByAging; //invoiceTotalByAgeGroup
            private BigDecimal unInvoicedTotal; // sum(unInvoicedCharges)

            public PropertyBalanceInfo(String id, String name) {
                this.id = id;
                this.name = name;
            }

            public PropertyBalanceInfo(String id, String name, boolean readOnly) {
                this(id, name);
                this.readOnly = readOnly;
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

            public PreferredCommunication getDeliveryPreference() {
                return deliveryPreference;
            }

            public void setDeliveryPreference(PreferredCommunication deliveryPreference) {
                this.deliveryPreference = deliveryPreference;
            }

            public String getAccountId() { return accountId; }

            public void setAccountId(String accountId) { this.accountId = accountId; }

            public String getEmail() { return email; }

            public void setEmail(String email) { this.email = email; }

            public boolean isReadOnly() {
                return readOnly;
            }

            public void setReadOnly(boolean readOnly) {
                this.readOnly = readOnly;
            }

            public boolean isClosed() {
                return closed;
            }

            public void setClosed(boolean closed) {
                this.closed = closed;
            }

            public List<BigDecimal> getInvoiceTotalsByAging() { return invoiceTotalsByAging; }

            public void setInvoiceTotalsByAging(List<BigDecimal> invoiceTotalsByAging) {
                this.invoiceTotalsByAging = invoiceTotalsByAging;
            }

            public BigDecimal getInvoiceTotal() { // invoiceTotal = sum(invoiceTotalsByAgeGroups)
                if (invoiceTotalsByAging == null ) return BigDecimal.ZERO;
                return invoiceTotalsByAging.stream().reduce(BigDecimal.ZERO, BigDecimal::add);
            }

            public BigDecimal getUnInvoicedTotal() {
                return unInvoicedTotal == null? BigDecimal.ZERO: unInvoicedTotal;
            }

            public void setUnInvoicedTotal(BigDecimal unInvoicedTotal) {
                this.unInvoicedTotal = unInvoicedTotal;
            }

            public BigDecimal getBalance() {
                return getInvoiceTotal().add(getUnInvoicedTotal()); // balance = subTotal + unInvoicedTotal
            }
        }
    }
}