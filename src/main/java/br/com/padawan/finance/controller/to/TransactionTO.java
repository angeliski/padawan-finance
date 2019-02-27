package br.com.padawan.finance.controller.to;

import br.com.padawan.finance.model.User;
import br.com.padawan.finance.model.Transaction;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.util.Date;

public class TransactionTO {

    private long id;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/mm/yyyy")
    private Date date;
    private String description;
    private String type;
    private BigDecimal value;
    private String user;

    public TransactionTO(){}

    public TransactionTO(Transaction transaction) {
        this.id = transaction.getId();
        this.date = transaction.getDate();
        this.description = transaction.getDescription();
        this.type = transaction.getTypeName();
        this.value = transaction.getValue();
        this.user = transaction.getUsername();
    }

    public Transaction toNewEntity(User user) {
        Transaction transaction = new Transaction();
        transaction.setDescription(description);
        transaction.setDate(date);
        transaction.setType(Transaction.TypeTransaction.valueOf(type));
        transaction.setValue(value);
        transaction.setUser(user);

        return transaction;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
