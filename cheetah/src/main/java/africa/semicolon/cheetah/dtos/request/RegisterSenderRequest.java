package africa.semicolon.cheetah.dtos.request;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
public class RegisterSenderRequest {
    private String senderEmail;
    private String senderName;
    private String phoneNumber;
}
