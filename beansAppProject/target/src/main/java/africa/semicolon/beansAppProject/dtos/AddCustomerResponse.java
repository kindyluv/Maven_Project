package africa.semicolon.beansAppProject.dtos;
import lombok.Data;

@Data
public class AddCustomerResponse {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
}
