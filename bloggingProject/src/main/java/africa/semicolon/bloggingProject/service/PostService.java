package africa.semicolon.bloggingProject.service;

import africa.semicolon.bloggingProject.data.model.Post;
import africa.semicolon.bloggingProject.dtos.request.AddPostRequest;
import africa.semicolon.bloggingProject.dtos.response.AddPostResponse;
import africa.semicolon.bloggingProject.exception.PostTrackingIdNotFoundException;

public interface PostService {

    Post findPostByUniqueId(Integer Id) throws PostTrackingIdNotFoundException;
    AddPostResponse createPost(AddPostRequest addPostRequest);
    Post updatePost(Integer postId, AddPostRequest addPostRequest) throws PostTrackingIdNotFoundException;
    void deletePost(Integer postId) throws PostTrackingIdNotFoundException;
            
}
