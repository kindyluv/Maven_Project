package africa.semicolon.bloggingProject.data.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class Post {
    private Author authorInfo;
    private String commentContent;
    private String postTitle;
    private String postBody;
    private Integer PostUniqueId;
    private LocalDateTime dateTime = LocalDateTime.now();
}
