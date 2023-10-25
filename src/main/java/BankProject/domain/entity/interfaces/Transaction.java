package BankProject.domain.entity.interfaces;

public interface Transaction {

    String getId();

    String getCreditAccountId();

    String getDebitAccountId();

    String getType();

    String getAmount();

    String getDescription();
}
