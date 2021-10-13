package africa.semicolon.BankingApplication.data.models;

import lombok.Data;
import java.math.BigDecimal;

import static africa.semicolon.BankingApplication.data.models.AccountType.SAVINGS;

@Data
public class Account {
    private String customerId = "0";
    private String number;
    private AccountType type = SAVINGS;
    private BigDecimal balance = BigDecimal.ZERO;
}
