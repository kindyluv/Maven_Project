package africa.semicolon.bloggingProject.utils;

import africa.semicolon.bloggingProject.data.model.Post;
import africa.semicolon.bloggingProject.dtos.AddPostRequest;
import africa.semicolon.bloggingProject.dtos.AddPostResponse;

public class ModelMapper {

    public static Post map(AddPostRequest addPostRequest){
        Post post = new Post();
        post.setPostTitle(addPostRequest.getPostTitle());
        post.setPostBody(addPostRequest.getPostContent());
        post.setAuthorInfo(addPostRequest.getAuthorId());
        return post;
    }

    public static AddPostResponse map(Post savedPost){
        AddPostResponse addResponse = new AddPostResponse();
        addResponse.setPostTitle(savedPost.getPostTitle());
        addResponse.setPostContent(savedPost.getPostBody());
        addResponse.setAuthorId(savedPost.getAuthorInfo());

        return addResponse;
    }
}
