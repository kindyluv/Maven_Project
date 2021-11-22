package africa.semicolon.bloggingProject.data.repository;

import africa.semicolon.bloggingProject.data.model.Author;
import africa.semicolon.bloggingProject.exception.TrackingIdNotFoundException;

import java.util.*;

public class AuthorRepositoryImpl implements AuthorRepository{
    Map<Integer, Author> database = new HashMap<Integer, Author>();

    @Override
    public Author saveAuthor(Author author) {
        Integer authorTrackingId = null;
        if(author.getAuthorId() == null) {
            authorTrackingId = database.size()+1;
            author.setAuthorId(authorTrackingId);
        }else
            if(author.getAuthorId()!=null ){
            authorTrackingId = author.getAuthorId();
            database.put(authorTrackingId, author);
        }
        return database.get(authorTrackingId);
    }

    @Override
    public Author findAuthorById(Integer authorId) {
        if(!(database.containsKey(authorId))) throw new TrackingIdNotFoundException("invalid Author information");
        return database.get(authorId);
    }

    @Override
    public Author findAuthorByUsername(String username) {
       for (Author value: database.values()) {
           if (value.getUserName().equals(username)) {
               return value;
           }
       }
       return null;
    }

    @Override
    public Author findAuthor(Author author) {
        return null;
    }

    @Override
    public Author findAuthorByPostHeadLine(String postHeadLine) {
        return null;
    }

    @Override
    public List<Author> findAllAuthor() {
        List<Author> allAuthor = new ArrayList<Author>();
        Set<Integer> keys = database.keySet();
        for (Integer key : keys) {
            allAuthor.add(database.get(key));
        }
        return allAuthor;
    }

    @Override
    public void deleteAuthorId(Integer id) {
        for(Author value: database.values()){
            if(value.getAuthorId().equals(id)){
                database.remove(id);
            }
        }
    }

    @Override
    public void deleteAllAuthor() {
       database.clear();
    }

}
