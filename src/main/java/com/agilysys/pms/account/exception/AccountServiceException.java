/**
 * (C) 2013 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.exception;

import java.util.Map;

import org.elasticsearch.common.collect.Maps;

import com.agilysys.platform.common.exception.ClientException;

/**
 * Generic Exception for all account service related exceptions and errors
 */
public class AccountServiceException extends ClientException {

    private static final long serialVersionUID = 6467765185951408255L;
    private ServiceError serviceError;
    // simple classname -> object map
    private Map<String, Object> entities = Maps.newHashMap();

    // This should be refactored to a common place.- in pmsCommon
    // This will have responseEntityType
    public enum ServiceError {
        CLIENT_INVALID_REQUEST(109000, "There was either invalid or missing data for this request."),
        //
        FAILED_TO_CREATE_FOLIO(101000, "Failed to create folio"),
        //
        FAILED_TO_UPDATE_FOLIO(101001, "Failed to update folio"),
        //
        FAILED_TO_UPDATE_PROFILE_WITH_PAYMENT_METHOD(101002, "Failed to update profile with payment method"),
        //

        FAILED_TO_CREATE_PAYMENT_METHOD(102000, "Failed to create payment method"),
        //
        FAILED_TO_APPLY_PAYMENT(102001, "Failed to post payment to account"),
        //
        FAILED_TO_CREATE_PAYMENT_INSTRUMENT(103000, "Failed to create payment instrument"),
        //
        FAILED_TO_CREATE_PAYMENT_INSTRUMENT_FROM_PAYAUTH(103001, "Failed to create payment instrument from payAuth"),
        //
        FAILED_TO_UPSERT_PAYMENT_SETTING(104000, "Failed to create or update payment setting"),
        //
        UNSUPPORTED_CARD_ISSUER(105000, "Credit Card Issuer not supported"),
        //
        FAILED_TO_GET_COMPLETED_TRANSACTION(106000, "Failed to retrieve completed transaction from data store"); //

        private ServiceError(int c, String d) {
            this.code = c;
            this.description = d;
        }

        private int code;
        private String description;

        public int getCode() {
            return code;
        }

        public String getDescription() {
            return description;
        }
    }

    /**
     * @param serviceError
     * @param responseEntity
     * @param clazz
     * @param responseCode
     */
    public AccountServiceException(ServiceError serviceError, Object entity, Class<?> entityClazz,
          Integer responseCode) {
        super();
        this.serviceError = serviceError;
        this.responseCode = responseCode;
        addEntities(entityClazz, entity);
    }

    /**
     * @return the entities
     */
    public Map<String, Object> getEntities() {
        return entities;
    }

    /**
     * @param entities the entities to set
     */
    public void setEntities(Map<String, Object> entities) {
        this.entities = entities;
    }

    /**
     * @param entities the entities to set
     */
    public void addEntities(Class<?> clazz, Object entity) {
        this.entities.put(clazz.getSimpleName(), entity);
    }

    /**
     * @return the serviceError
     */
    public ServiceError getServiceError() {
        return serviceError;
    }

    /**
     * @param serviceError the serviceError to set
     */
    public void setServiceError(ServiceError serviceError) {
        this.serviceError = serviceError;
    }

    public int getCode() {
        return this.getServiceError().getCode();
    }

    public String getMessage() {
        return "HttpErrorCode: " + this.getResponseCode() + ", AccountServiceCode : " + getCode() + ", " +
              this.serviceError.getDescription() + " " + this.getResponseBody();
    }
}
