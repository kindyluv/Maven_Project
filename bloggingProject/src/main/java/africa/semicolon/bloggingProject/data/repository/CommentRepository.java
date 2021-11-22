package africa.semicolon.bloggingProject.data.repository;

import africa.semicolon.bloggingProject.data.model.Comment;

import java.util.List;

public interface CommentRepository {

    Comment createComment(Comment comment);
    Comment retrieveComment(Integer postId, Comment comment);
    Comment updatePost(Integer postId, Comment comment);
    Comment findCommentByPostId(Integer postId, Comment comment);
    Comment findCommentByCommentId(Integer commentId, Comment comment);
    List<Comment> findAllComments();
    void deleteCommentByCommentId(Integer commentId);
    void deleteCommentByCommenterName(String commenterName);
}
