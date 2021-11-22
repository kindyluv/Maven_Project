package africa.semicolon.bloggingProject.data.repository;

import africa.semicolon.bloggingProject.data.model.Author;
import africa.semicolon.bloggingProject.data.model.Comment;
import africa.semicolon.bloggingProject.data.model.Post;
import africa.semicolon.bloggingProject.exception.EmptyPostIdException;
import africa.semicolon.bloggingProject.exception.PostTrackingIdNotFoundException;

import java.util.List;
import java.util.Optional;

public interface PostRepository {
    Optional<Post> findPostByUniqueId(Integer postId) throws PostTrackingIdNotFoundException;
    Post makePost(Integer postId, Post post) throws PostTrackingIdNotFoundException;
    Post savePost(Post post);
    Post updatePost(Integer postId, Post newPost);
    Author saveAuthor(Author author);
//    Comment saveComment(Comment comment);
    void deletePost(Integer postId);
    void deleteAllPost();
    List<Post> findAllPost();
    Post findPost(Integer postId);

}
