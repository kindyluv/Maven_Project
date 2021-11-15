package africa.semicolon.bloggingProject.dtos.request;

import lombok.Data;

@Data
public class AddAuthorRequest {
    private String firstName;
    private String lastName;
    private String userName;
    private Integer authorId;
    private String emailAddress;
}
