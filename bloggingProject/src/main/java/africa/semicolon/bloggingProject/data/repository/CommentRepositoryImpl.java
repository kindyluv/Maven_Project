package africa.semicolon.bloggingProject.data.repository;

import africa.semicolon.bloggingProject.data.model.Comment;

import java.util.*;

public class CommentRepositoryImpl implements CommentRepository{
    Map<Integer, Comment> database = new HashMap<>();

    @Override
    public Comment createComment(Comment comment) {
        Integer commentId;
        if(comment.getCommentId() == null){
            commentId = database.size()+1;
            comment.setCommentId(commentId);
            database.put(commentId, comment);
        }
        commentId = comment.getCommentId();
        database.put(commentId, comment);
        return database.get(commentId);
    }

    @Override
    public Comment retrieveComment(Integer postId, Comment comment) {
        return null;
    }

    @Override
    public Comment updatePost(Integer postId, Comment comment) {
        return null;
    }

    @Override
    public Comment findCommentByPostId(Integer postId, Comment comment) {
        return null;
    }

    @Override
    public Comment findCommentByCommentId(Integer commentId, Comment comment) {
        return null;
    }

    @Override
    public List<Comment> findAllComments() {
        List<Comment> comments = new ArrayList<>();
        Set<Integer> keys = database.keySet();
        for (Integer key : keys) {
            comments.add(database.get(key));
        }
        return comments;
    }

    @Override
    public void deleteCommentByCommentId(Integer commentId) {

    }

    @Override
    public void deleteCommentByCommenterName(String commenterName) {

    }
}
