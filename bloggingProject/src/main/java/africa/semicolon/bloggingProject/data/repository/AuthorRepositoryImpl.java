package africa.semicolon.bloggingProject.data.repository;

import africa.semicolon.bloggingProject.data.model.Author;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AuthorRepositoryImpl implements AuthorRepository{
    Map<Integer, Author> database = new HashMap<Integer, Author>();
    private Author author = new Author();
    private int count = 0;

    @Override
    public Author saveAuthor(Author author) {
        Integer authorTrackingId = null;
        if(author.getAuthorId() != null) {
            authorTrackingId = database.size()+1;
            author.setAuthorId(authorTrackingId);
        }
        authorTrackingId = author.getAuthorId();
        database.put(authorTrackingId, author);
        count++;
        return database.get(authorTrackingId);
    }

    @Override
    public Author findAuthorById(Integer authorId) {
        return null;
    }

    @Override
    public Author findAuthorByUsername(String username) {
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
        return null;
    }

    @Override
    public void deleteAuthor(Author author) {

    }

    @Override
    public void deleteAllAuthor(Author... author) {

    }

    @Override
    public void deleteAuthorByUsername(String username) {

    }

    @Override
    public int getCount() {
        return count;
    }
}
