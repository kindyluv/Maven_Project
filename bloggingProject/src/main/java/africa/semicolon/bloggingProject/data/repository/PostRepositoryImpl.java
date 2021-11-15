package africa.semicolon.bloggingProject.data.repository;

import africa.semicolon.bloggingProject.data.model.Author;
import africa.semicolon.bloggingProject.data.model.Post;

import java.util.*;

public class PostRepositoryImpl implements PostRepository {
    Map<Integer, Post> database = new HashMap<Integer, Post>();
    Map<Integer, Author> authorDatabase = new HashMap<Integer, Author>();
//    Map<Integer, Comment> commentDatabase = new HashMap<Integer, Comment>();
    private int count = 0;

//    private DataStorage database_ = new DataStorage();


    @Override
    public Post findPostByUniqueId(Integer postId){
        Post post = new Post();
        List<Post> uniqueId = new ArrayList<>();
        Set<Integer> keys = database.keySet();
        for(Integer key : keys){
            if(key.equals(postId)){
              Post post_ = uniqueId.get(key);
                return post_;
            }
        }
        return null;
    }

    @Override
    public Post makePost(Integer postId, Post post) {
        Post findId = findPostByUniqueId(postId);
        if(!findId.equals(postId)){
            return post;
        }
        return null;
    }

    @Override
    public int getCount() {
        return count;
    }

    @Override
    public Post savePost(Post post) {
        Integer postId = null;
        if(post.getPostUniqueId() == null){
            postId = database.size()+1;
            post.setPostUniqueId(postId);
        }else{
        postId = post.getPostUniqueId();
        database.put(postId, post);
        count++;}
        return database.get(postId);
    }

    @Override
    public Post updatePost(Integer postId, Post newPost) {
        List<Post> postList = new ArrayList<>();
        Set<Integer> keys = database.keySet();
        for (Integer key : keys) {
            if(postId.equals(key)) {
                return savePost(newPost);
            }

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
