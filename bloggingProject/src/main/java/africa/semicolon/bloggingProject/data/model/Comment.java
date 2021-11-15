package africa.semicolon.bloggingProject.data.model;

import java.time.LocalDate;
import java.time.LocalTime;
import lombok.Data;

@Data
public class Comment {
    private Integer postId;
    private Integer commentId;
    private String commenterName;
    private String commentContents;
    private LocalTime time = LocalTime.now();
    private LocalDate date = LocalDate.now();
}
