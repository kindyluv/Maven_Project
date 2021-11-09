package africa.semicolon.cheetah.data.models;

import lombok.Data;

import java.util.List;
import java.util.ListIterator;
import java.util.Locale;

@Data
public class Sender {
    private String senderName;
    private String phoneNumber;
    private String emailAddress;

}
