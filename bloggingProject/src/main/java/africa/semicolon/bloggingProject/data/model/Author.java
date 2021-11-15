package africa.semicolon.bloggingProject.data.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Author {
    private String firstName;
    private String lastName;
    private String userName;
    private Integer authorId;
    private String emailAddress;
}
