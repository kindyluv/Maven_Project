package africa.semicolon.bloggingProject.dtos;

import java.time.LocalDate;
import java.time.LocalTime;

import africa.semicolon.bloggingProject.data.model.Author;
import africa.semicolon.bloggingProject.data.model.Post;
import lombok.Data;

@Data
public class AddPostRequest {
    private String postTitle;
    private String postContent;
    private Author authorId;
    private LocalDate date = LocalDate.now();
    private LocalTime time = LocalTime.now();
}
