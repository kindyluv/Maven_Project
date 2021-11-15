package africa.semicolon.bloggingProject.dtos.response;

import lombok.Data;

@Data
public class AddAuthorResponse {
    private String firstName;
    private String lastName;
    private String userName;
    private Integer authorId;
    private String emailAddress;
}
