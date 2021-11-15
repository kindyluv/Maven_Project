package africa.semicolon.bloggingProject.data.repository;

import africa.semicolon.bloggingProject.data.model.Author;

import java.util.List;

public interface AuthorRepository {

    Author saveAuthor(Author author);
    Author findAuthorById(Integer authorId);
    Author findAuthorByUsername(String username);
    Author findAuthor(Author author);
    Author findAuthorByPostHeadLine(String postHeadLine);
    List<Author> findAllAuthor();
    void deleteAuthorId(Integer authorId);
    void deleteAllAuthor();

}
