package africa.semicolon.bloggingProject.data.repository;

import africa.semicolon.bloggingProject.data.model.Author;
import africa.semicolon.bloggingProject.data.model.Comment;
import africa.semicolon.bloggingProject.data.model.Post;

import java.util.List;

public interface PostRepository {
    Post findPostByUniqueId(Integer postId);
    Post makePost(Integer postId, Post post);
    Post savePost(Post post);
    Post updatePost(Integer postId, Post newPost);
    Author saveAuthor(Author author);
//    Comment saveComment(Comment comment);
    void deletePost(Integer postId);
    void deleteAllPost();
    List<Post> findAllPost();
    Post findPost(Integer postId);

    int getCount();
}
