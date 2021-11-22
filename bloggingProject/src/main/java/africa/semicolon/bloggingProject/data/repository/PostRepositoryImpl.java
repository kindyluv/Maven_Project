package africa.semicolon.bloggingProject.data.repository;

import africa.semicolon.bloggingProject.data.model.Author;
import africa.semicolon.bloggingProject.data.model.Post;
import africa.semicolon.bloggingProject.exception.PostTrackingIdNotFoundException;

import java.util.*;

public class PostRepositoryImpl implements PostRepository {
    Map<Integer, Post> database = new HashMap<Integer, Post>();
    Map<Integer, Author> authorDatabase = new HashMap<Integer, Author>();


    @Override
    public Post savePost(Post post) {
        Integer postId;
        if (post.getPostUniqueId() == null){
            postId = database.size()+1;
            post.setPostUniqueId(postId);
        }
        postId = post.getPostUniqueId();
        database.put(postId, post);

        return database.get(postId);
    }

    @Override
    public Post updatePost(Integer postId, Post newPost) {
        Set<Integer> keys = database.keySet();
        for (Integer key : keys) {
            if(postId.equals(key)) return savePost(newPost);
        }
        return null;
    }

    @Override
    public Optional<Post> findPostByUniqueId(Integer postId) throws PostTrackingIdNotFoundException {
        if(!(database.containsKey(postId))) throw new PostTrackingIdNotFoundException("Please Enter a valid tracking id");
        Set<Integer> keys = database.keySet();
        for(Integer key : keys){
            if(key.equals(postId)) return Optional.of(database.get(postId));
        }
        return Optional.empty();
    }

    @Override
    public Post makePost(Integer postId, Post post) throws PostTrackingIdNotFoundException {
        Optional<Post> findId = findPostByUniqueId(postId);
        if(!(findId.equals(postId))){
            return post;
        }
        return null;
    }

    @Override
    public Author saveAuthor(Author author) {
        Integer authorId_ = null;
        if(author.getAuthorId() == null){
            authorId_ = authorDatabase.size()+1;
            author.setAuthorId(authorId_);
        }
        authorId_ = author.getAuthorId();
        authorDatabase.put(authorId_, author);
        return authorDatabase.get(authorId_);
    }

//    @Override
//    public Comment saveComment(Comment comment) {
//        Integer commentId = null;
//        if(comment.getCommentId() == null){
//            commentId = commentDatabase.size()+1;
//            comment.setCommentId(commentId);
//        }
//        commentId = comment.getCommentId();
//        commentDatabase.put(commentId, comment);
//        Comment comment_ = commentDatabase.get(commentId);
//        return comment_;
//    }

    @Override
    public void deletePost(Integer postId) {
        database.remove(postId);
    }

    @Override
    public void deleteAllPost() {
       database.clear();
    }

    @Override
    public List<Post> findAllPost() {
        List<Post> all = new ArrayList<>();
        Set<Integer> keys = database.keySet();
        for(Integer key: keys){
            all.add(database.get(key));
        }
        return all;
    }

    @Override
    public Post findPost(Integer postId) {
        return database.get(postId);
    }
}
