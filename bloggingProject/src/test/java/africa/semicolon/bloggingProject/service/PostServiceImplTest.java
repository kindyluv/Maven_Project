package africa.semicolon.bloggingProject.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PostServiceImplTest {
    PostService postService;

    @BeforeEach
    void setUp() {
        postService = new PostServiceImpl();
    }

    @Test
    void findPostByUniqueId() {

        assertEquals(1, postService.findPostByUniqueId(1));
    }

    @Test
    void createPost() {
    }

    @Test
    void updatePost() {
    }

    @Test
    void deletePost() {
    }
}