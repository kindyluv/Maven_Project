package africa.semicolon.bloggingProject.db;

import africa.semicolon.bloggingProject.data.model.Post;

import java.util.*;

public class DataStorage {
    Map<Integer, Post> database = new HashMap<Integer, Post>();
    private int counter = 0;

    public void add(Integer postId, Post post) {
        database.put(postId, post);
    }

    public Integer size() {
        return counter++;
    }

    public List<Post> get(Integer postId) {
        List<Post> all = new ArrayList<Post>();
        Set<Integer> keys = database.keySet();
        for(Integer key : keys) {
            all.add(database.get(key));
        }
        return all;
    }
}
