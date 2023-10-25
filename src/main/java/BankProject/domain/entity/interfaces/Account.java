package BankProject.domain.entity.interfaces;

import liquibase.datatype.core.CurrencyType;

import java.math.BigDecimal;
import java.sql.Timestamp;

public interface Account {

    String getId();

    String getClientId();

    String getName();

    int getStatus();

    BigDecimal getBalance();

    CurrencyType getCurrency();

    Timestamp getCreatedAt();

    Timestamp getUpdatedAt();
}
