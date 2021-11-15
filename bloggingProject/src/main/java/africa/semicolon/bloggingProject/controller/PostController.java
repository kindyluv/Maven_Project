package africa.semicolon.bloggingProject.controller;

import africa.semicolon.bloggingProject.data.model.Post;
import africa.semicolon.bloggingProject.dtos.AddPostRequest;
import africa.semicolon.bloggingProject.dtos.AddPostResponse;
import africa.semicolon.bloggingProject.service.PostService;
import africa.semicolon.bloggingProject.service.PostServiceImpl;
import org.springframework.web.bind.annotation.*;

public class PostController {
    private PostService postService = new PostServiceImpl();

    @PostMapping("/api/createPost")
    public AddPostResponse createPost(@RequestBody AddPostRequest addPostRequest){
        return postService.createPost(addPostRequest);
    }

    @PatchMapping("/api/updatePost")
    public Post updatePost(Integer postId, AddPostRequest addPostRequest){
        return postService.updatePost(postId, addPostRequest);
    }

    public void deletePost(Integer postId){
        postService.deletePost(postId);
    }

    @GetMapping("/api/findPostById")
    public Post findPostById(@PathVariable Integer id){
        return postService.findPostByUniqueId(id);
    }
}
