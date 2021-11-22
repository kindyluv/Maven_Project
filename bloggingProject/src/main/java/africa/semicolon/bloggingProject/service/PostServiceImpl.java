package africa.semicolon.bloggingProject.service;

import africa.semicolon.bloggingProject.data.model.Post;
import africa.semicolon.bloggingProject.data.repository.PostRepository;
import africa.semicolon.bloggingProject.data.repository.PostRepositoryImpl;
import africa.semicolon.bloggingProject.dtos.request.AddPostRequest;
import africa.semicolon.bloggingProject.dtos.response.AddPostResponse;
import africa.semicolon.bloggingProject.exception.PostTrackingIdNotFoundException;
import africa.semicolon.bloggingProject.utils.postModelMapper.ModelMapper;

import java.util.Optional;

public class PostServiceImpl implements PostService{
    PostRepository postRepository = new PostRepositoryImpl();

    @Override
    public Post findPostByUniqueId(Integer id) throws PostTrackingIdNotFoundException {
        assert(postRepository.findPostByUniqueId(id).isPresent());
        return postRepository.findPostByUniqueId(id).get();
    }


    @Override
    public AddPostResponse createPost(AddPostRequest addPostRequest) {
        Post post = ModelMapper.map(addPostRequest);

        Post savedPost = postRepository.savePost(post);

        AddPostResponse addResponse = ModelMapper.map(savedPost);

        return addResponse;
    }

    @Override
    public Post updatePost(Integer postId, AddPostRequest addPostRequest) throws PostTrackingIdNotFoundException {
        assert(postRepository.findPostByUniqueId(postId).isPresent());
        Post post = postRepository.findPostByUniqueId(postId).get();
        if(!post.getPostTitle().equals(addPostRequest.getPostTitle())) post.setPostTitle(addPostRequest.getPostTitle());
        if(!post.getPostBody().equals(addPostRequest.getPostContent())) post.setPostBody(addPostRequest.getPostContent());
        if(!post.getAuthorInfo().equals(addPostRequest.getAuthorId())) post.setAuthorInfo(addPostRequest.getAuthorId());

        return postRepository.updatePost(postId, post);
    }

    @Override
    public void deletePost(Integer postId) throws PostTrackingIdNotFoundException {
        assert(postRepository.findPostByUniqueId(postId).isPresent());
        postRepository.deletePost(postRepository.findPostByUniqueId(postId).get().getPostUniqueId());

    }
}
