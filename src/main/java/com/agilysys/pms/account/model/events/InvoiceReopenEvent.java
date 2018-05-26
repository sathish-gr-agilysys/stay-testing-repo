import java.util.List;

import org.joda.time.LocalDate;

import com.agilysys.platform.persistence.eventsourcing.PropertyLevelIdentifier;
import com.agilysys.pms.account.model.events.InvoiceBalanceChangeEvent;

public class InvoiceReopenEvent extends InvoiceBalanceChangeEvent {

    private PropertyLevelIdentifier id;
    private String accountId;
    private LocalDate invoiceDate;
    private String invoiceNumber;
    public InvoiceReopenEvent(){}

    @Override
    public List<String> getHistoryMessages() {
        return null;
    }

    public InvoiceReopenEvent(PropertyLevelIdentifier id, String accountId, LocalDate invoiceDate, String invoiceNumber, boolean closed) {
        super(closed);
        this.id = id;
        this.accountId = accountId;
        this.invoiceDate = invoiceDate;
        this.invoiceNumber = invoiceNumber;
    }

    public PropertyLevelIdentifier getId() {
        return id;
    }

    public void setId(PropertyLevelIdentifier id) {
        this.id = id;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public LocalDate getInvoiceDate() {
        return invoiceDate;
    }

    public String getAccountId() {
        return accountId;
    }

    @Override
    public long getEventVersion() {
        return 0;
    }

}