package africa.semicolon.BankingApplication.dtos.requests;

import africa.semicolon.BankingApplication.data.models.AccountType;
import lombok.Data;

@Data
public class CreateAccountRequests {
    private AccountType accountType;
    private String bankId;
    private String firstName;
    private String lastName;
}
