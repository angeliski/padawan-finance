package br.com.padawan.finance.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/mm/yyyy")
    private Date date;
    private String description;


    @Enumerated(EnumType.STRING)
    private TypeTransaction type;
    private BigDecimal value;

    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private User user;

    public String getUsername() {
        return user == null ? "" : user.getUsername();
    }


    public enum TypeTransaction {
        EXPENSE, REVENUE
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

    public TypeTransaction getType() {
        return type;
    }

    public void setType(TypeTransaction type) {
        this.type = type;
    }


    public String getTypeName() {
        return type == null ? "" : type.name();
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
