package com.revolut.account.domain;

import java.math.BigDecimal;
import java.util.Objects;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@DatabaseTable(tableName = "accounts")
public class Account {

    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField(canBeNull = false)
    private String owner;

    @DatabaseField(canBeNull = false)
    private BigDecimal amount = BigDecimal.ZERO;

    public Account() {
    }

    public Account(int id, String owner, BigDecimal amount) {
        this.id = id;
        this.owner = owner;
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Account)) {
            return false;
        }
        Account account = (Account) o;
        return getId() == account.getId()
                && Objects.equals(getOwner(), account.getOwner())
                && Objects.equals(getAmount(), account.getAmount());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getOwner(), getAmount());
    }
}
