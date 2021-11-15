package africa.semicolon.bloggingProject.service;

import africa.semicolon.bloggingProject.data.model.Post;
import africa.semicolon.bloggingProject.data.repository.PostRepository;
import africa.semicolon.bloggingProject.data.repository.PostRepositoryImpl;
import africa.semicolon.bloggingProject.dtos.AddPostRequest;
import africa.semicolon.bloggingProject.dtos.AddPostResponse;
import africa.semicolon.bloggingProject.utils.ModelMapper;

import java.util.List;

public class PostServiceImpl implements PostService{
    PostRepository postRepository = new PostRepositoryImpl();

    @Override
    public Post findPostByUniqueId(Integer id) {
        return postRepository.findPostByUniqueId(id);
    }


    @Override
    public AddPostResponse createPost(AddPostRequest addPostRequest) {
        Post post = ModelMapper.map(addPostRequest);

        Post savedPost = postRepository.savePost(post);

        AddPostResponse addResponse = ModelMapper.map(savedPost);

        return addResponse;
    }

    @Override
    public Post updatePost(Integer postId, AddPostRequest addPostRequest) {
        Post post = postRepository.findPostByUniqueId(postId);
        if(!post.getPostTitle().equals(addPostRequest.getPostTitle())) post.setPostTitle(addPostRequest.getPostTitle());
        if(!post.getPostBody().equals(addPostRequest.getPostContent())) post.setPostBody(addPostRequest.getPostContent());
        if(!post.getAuthorInfo().equals(addPostRequest.getAuthorId())) post.setAuthorInfo(addPostRequest.getAuthorId());

        return postRepository.updatePost(postId, post);
    }

    @Override
    public void deletePost(Integer postId) {
        postRepository.deletePost(postRepository.findPostByUniqueId(postId).getPostUniqueId());

    }
}
