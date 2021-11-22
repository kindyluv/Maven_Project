package africa.semicolon.bloggingProject.controller;

import africa.semicolon.bloggingProject.data.model.Post;
import africa.semicolon.bloggingProject.dtos.request.AddPostRequest;
import africa.semicolon.bloggingProject.dtos.response.AddPostResponse;
import africa.semicolon.bloggingProject.exception.DuplicatePostException;
import africa.semicolon.bloggingProject.exception.DuplicatePostTrackingIdException;
import africa.semicolon.bloggingProject.exception.PostTrackingIdNotFoundException;
import africa.semicolon.bloggingProject.service.PostService;
import africa.semicolon.bloggingProject.service.PostServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public class PostController {
    private final PostService postService = new PostServiceImpl();

    @PostMapping("/api/createPost")
    public ResponseEntity<?> createPost(@RequestBody AddPostRequest addPostRequest){
       try{
           AddPostResponse response = postService.createPost(addPostRequest);
           return new ResponseEntity<>(response, HttpStatus.CREATED);
       }catch(DuplicatePostException | DuplicatePostTrackingIdException e){
           return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
       }
    }

    @PatchMapping("/api/updatePost")
    public ResponseEntity<?> updatePost(Integer postId, AddPostRequest addPostRequest) throws PostTrackingIdNotFoundException {
       Post post = postService.updatePost(postId, addPostRequest);
        return new ResponseEntity<>(post, HttpStatus.OK);
    }

    public void deletePost(Integer postId) throws PostTrackingIdNotFoundException {
        postService.deletePost(postId);
    }

    @GetMapping("/api/findPostById")
    public ResponseEntity<?> findPostById(@PathVariable Integer id){
        try{
            Post post = postService.findPostByUniqueId(id);
            return new ResponseEntity<>(post, HttpStatus.ACCEPTED);
        }catch(PostTrackingIdNotFoundException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }

    }
}
