package africa.semicolon.beansAppProject.dtos;
import lombok.Data;

@Data
public class AddCustomerRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
}
