package africa.semicolon.bloggingProject.data.repository;

import africa.semicolon.bloggingProject.data.model.Author;
import africa.semicolon.bloggingProject.data.model.Comment;
import africa.semicolon.bloggingProject.data.model.Post;
import africa.semicolon.bloggingProject.data.repository.*;
import africa.semicolon.bloggingProject.exception.PostTrackingIdNotFoundException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CommentRepositoryImplTest {
    CommentRepository commentRepository;

    @BeforeEach
    void setUp() {
        commentRepository = new CommentRepositoryImpl();
    }

    @AfterEach
    void tearDown() {
    }

    private Comment response() throws PostTrackingIdNotFoundException {
        Comment comment = new Comment();
        Post post = postResponse();

        comment.setPostId(post.getPostUniqueId());
        comment.setCommentId(1234);
        comment.setCommenterName("precious");
        comment.setCommentContents("nice dress");
        return commentRepository.createComment(comment);
    }

    private Author authorInfo(){
        Author author = new Author();
        AuthorRepository authorRepository = new AuthorRepositoryImpl();
        author.setFirstName("Lois");
        author.setLastName("Loisy");
        author.setAuthorId(2202);
        author.setEmailAddress("onyeukwuamara@gmail");
        author.setUserName("Precious_Lois");
        return authorRepository.saveAuthor(author);
    }

    private Post postResponse(){
        Post post = new Post();
        PostRepository postRepository = new PostRepositoryImpl();
        post.setAuthorInfo(authorInfo());
        post.setPostUniqueId(1985);
        post.setPostTitle("First Post");
        post.setPostBody("good morning world ohhhhhhh i love blogging");
        return postRepository.savePost(post);
    }

    @Test
    void createComment() throws PostTrackingIdNotFoundException {
        Comment comment = new Comment();
        Post post = postResponse();
        post.setPostUniqueId(postResponse().getPostUniqueId());
        comment.setCommentId(164);
        comment.setCommentId(1234);
        comment.setCommenterName("precious");
        comment.setCommentContents("nice dress");

        commentRepository.createComment(comment);
        assertEquals(1, commentRepository.findAllComments().size());
    }

    @Test
    void retrieveComment() {

    }

    @Test
    void updatePost() {
    }
}