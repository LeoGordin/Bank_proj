package BankProject.domain.entity.interfaces;

import java.math.BigDecimal;
import java.sql.Timestamp;

public interface Agreement {

    String getId();

    String getAccountId();

    String getProductId();

    float getInterestRate();

    int getStatus();

    BigDecimal getSum();

    Timestamp getCreatedAt();

    Timestamp getUpdatedAt();
}
