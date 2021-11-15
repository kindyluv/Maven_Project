package africa.semicolon.bloggingProject.service;

import africa.semicolon.bloggingProject.data.model.Post;
import africa.semicolon.bloggingProject.dtos.AddPostRequest;
import africa.semicolon.bloggingProject.dtos.AddPostResponse;

import java.util.List;

public interface PostService {

    Post findPostByUniqueId(Integer Id);
    AddPostResponse createPost(AddPostRequest addPostRequest);
    Post updatePost(Integer postId, AddPostRequest addPostRequest);
    void deletePost(Integer postId);
            
}
