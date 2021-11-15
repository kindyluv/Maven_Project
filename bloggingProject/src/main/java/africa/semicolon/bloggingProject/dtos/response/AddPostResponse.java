package africa.semicolon.bloggingProject.dtos.response;

import africa.semicolon.bloggingProject.data.model.Author;
import africa.semicolon.bloggingProject.data.model.Post;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class AddPostResponse {
    private String postTitle;
    private String postContent;
    private Author authorId;
    private LocalDate date = LocalDate.now();
    private LocalTime time = LocalTime.now();
}
