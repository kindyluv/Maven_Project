package africa.semicolon.bloggingProject.data.repository;

import africa.semicolon.bloggingProject.data.model.Author;
import africa.semicolon.bloggingProject.data.model.Comment;
import africa.semicolon.bloggingProject.data.model.Post;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PostRepositoryImplTest {
    PostRepository postRepository;

    @BeforeEach
    void setUp() {
        postRepository = new PostRepositoryImpl();
        Author author = authorInfo();
    }

    private Author authorInfo(){
        Author author = new Author();
        author.setFirstName("Lois");
        author.setLastName("Loisy");
        author.setAuthorId(2202);
        author.setEmailAddress("onyeukwuamara@gmail");
        author.setUserName("Precious_Lois");
        return postRepository.saveAuthor(author);
    }

//    public Comment commenter(){
//        Post post = new Post();
//        Comment comment = new Comment();
//        comment.setCommenterName("Kindy");
//        comment.setCommentId(3456);
//        comment.setPostId(post.getPostUniqueId());
//        comment.setCommentContents("i love this");
//        return postRepository.saveComment(comment);
//    }

    private Post response(){
        Post post = new Post();
        post.setAuthorInfo(authorInfo());
        post.setPostUniqueId(1985);
        post.setPostTitle("First Post");
        post.setPostBody("good morning world ohhhhhhh i love blogging");
        return post;
    }

    @Test
    void makePost() {
        Post post = new Post();
        post.setAuthorInfo(authorInfo());
        post.setPostUniqueId(1985);
        post.setPostTitle("First Post");
        post.setPostBody("good morning world ohhhhhhh i love blogging");
        Post post_ = postRepository.savePost(post);
        assertEquals(1985, post_.getPostUniqueId());
    }

    @Test
    void searchForPostByUniqueId() {
        Post post = response();

        Post post_ = postRepository.savePost(post);
        assertEquals(1, postRepository.getCount());

    }

    @Test
    void savePost() {
        Post post = new Post();
        post.setAuthorInfo(authorInfo());
        post.setPostTitle("First Post");
        post.setPostBody("good morning world ohhhhhhh i love blogging");
        Post post_ = postRepository.savePost(post);
        assertEquals(1, post_.getPostUniqueId());
    }

    @Test
    void updatePost() {
        Post post = response();
        post.setPostBody("good morning world i love blogging");
        Post post__ = postRepository.updatePost(response().getPostUniqueId(), post);
        Post savedPost = postRepository.savePost(post__);
        System.out.println(savedPost);
        post.setPostTitle("Presh stole the meat");
        postRepository.updatePost(response().getPostUniqueId(), post);
        Post save = postRepository.savePost(post);
        System.out.println(save);
        assertEquals(1, postRepository.getCount());
    }

    @Test
    void makeComment() {
        Post post = response();
        post.setCommentContent("i love being me and i love being around lovely and sincere people");
        postRepository.savePost(post);
        assertEquals(1, postRepository.findAllPost().size());
    }

    @Test
    void editPost() {
    }

    @Test
    void findAll(){
        Post post = response();
        Post pos = postRepository.savePost(post);
        postRepository.findAllPost();
        assertEquals(1,postRepository.findAllPost().size());
    }

    @Test
    void deletePost() {
        Post post = response();
        Post post__ = postRepository.savePost(post);
        assertEquals(1985, post__.getPostUniqueId());
        assertEquals(1, postRepository.findAllPost().size());

        postRepository.deletePost(post.getPostUniqueId());
         assertEquals(0, postRepository.findAllPost().size());
    }

    @Test
    void deleteAllPost() {
        Post post = response();
        Post post__ = postRepository.savePost(post);
        postRepository.deleteAllPost();
        assertEquals(0, postRepository.findAllPost().size());
    }

    @Test
    void findPostByComment() {
    }
}