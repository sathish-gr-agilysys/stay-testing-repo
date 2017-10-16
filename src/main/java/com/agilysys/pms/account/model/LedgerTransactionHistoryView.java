package com.agilysys.pms.account.model;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;

/**
 * Created by MuthalurajG on 10/9/2017.
 */
public class LedgerTransactionHistoryView {


    private String id;

    private String sourceId;

    private String sourceAccountType;

    private String sourceReservationConfirmationId;

    private String sourceName;

    private String destinationId;

    private String destinationAccountType;

    private String destinationReservationConfirmationId;

    private String destinationName;

    private String reason;

    private DateTime dateTime;

    private LocalDate sourceArrivalDate;

    private LocalDate destinationArrivalDate;

    private LocalDate sourceDepartureDate;

    private LocalDate destinationDepartureDate;

    private String sourceGroupCode;

    private String destinationGroupCode;

    public String getSourceId() {
        return sourceId;
    }

    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    public String getSourceAccountType() {
        return sourceAccountType;
    }

    public void setSourceAccountType(String sourceAccountType) {
        this.sourceAccountType = sourceAccountType;
    }

    public String getSourceReservationConfirmationId() {
        return sourceReservationConfirmationId;
    }

    public void setSourceReservationConfirmationId(String sourceReservationConfirmationId) {
        this.sourceReservationConfirmationId = sourceReservationConfirmationId;
    }

    public String getSourceName() {
        return sourceName;
    }

    public void setSourceName(String sourceName) {
        this.sourceName = sourceName;
    }

    public String getDestinationId() {
        return destinationId;
    }

    public void setDestinationId(String destinationId) {
        this.destinationId = destinationId;
    }

    public String getDestinationAccountType() {
        return destinationAccountType;
    }

    public void setDestinationAccountType(String destinationAccountType) {
        this.destinationAccountType = destinationAccountType;
    }

    public String getDestinationReservationConfirmationId() {
        return destinationReservationConfirmationId;
    }

    public void setDestinationReservationConfirmationId(String destinationReservationConfirmationId) {
        this.destinationReservationConfirmationId = destinationReservationConfirmationId;
    }

    public String getDestinationName() {
        return destinationName;
    }

    public void setDestinationName(String destinationName) {
        this.destinationName = destinationName;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public DateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(DateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDate getSourceArrivalDate() {
        return sourceArrivalDate;
    }

    public void setSourceArrivalDate(LocalDate sourceArrivalDate) {
        this.sourceArrivalDate = sourceArrivalDate;
    }

    public LocalDate getDestinationArrivalDate() {
        return destinationArrivalDate;
    }

    public void setDestinationArrivalDate(LocalDate destinationArrivalDate) {
        this.destinationArrivalDate = destinationArrivalDate;
    }

    public LocalDate getSourceDepartureDate() {
        return sourceDepartureDate;
    }

    public void setSourceDepartureDate(LocalDate sourceDepartureDate) {
        this.sourceDepartureDate = sourceDepartureDate;
    }

    public LocalDate getDestinationDepartureDate() {
        return destinationDepartureDate;
    }

    public void setDestinationDepartureDate(LocalDate destinationDepartureDate) {
        this.destinationDepartureDate = destinationDepartureDate;
    }

    public String getSourceGroupCode() {
        return sourceGroupCode;
    }

    public void setSourceGroupCode(String sourceGroupCode) {
        this.sourceGroupCode = sourceGroupCode;
    }

    public String getDestinationGroupCode() {
        return destinationGroupCode;
    }

    public void setDestinationGroupCode(String destinationGroupCode) {
        this.destinationGroupCode = destinationGroupCode;
    }

    public void toHistoryView(String sourceId, String destinationId, String sourceAccountType, String destinationAccountType, String id, String reason, DateTime dateTime){
        this.sourceId=sourceId;
        this.destinationId=destinationId;
        this.sourceAccountType=sourceAccountType;
        this.destinationAccountType=destinationAccountType;
        this.id=id;
        this.reason=reason;
        this.dateTime=dateTime;
    }
}
