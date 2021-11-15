package africa.semicolon.bloggingProject.data.repository;

import africa.semicolon.bloggingProject.data.model.Author;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AuthorRepositoryImplTest {
    AuthorRepository authorRepository;

    @BeforeEach
    void setUp() {
        authorRepository = new AuthorRepositoryImpl();
    }

    public Author response(){
        Author author = new Author();
        author.setFirstName("Toye");
        author.setLastName("David");
        author.setUserName(author.getFirstName() + " " + author.getLastName());
        author.setAuthorId(1990);
        author.setEmailAddress("toye@gmail.com");

        return author;
    }

    @Test
    void save() {
        Author author = new Author();
        author.setFirstName("Toye");
        author.setLastName("David");
        author.setUserName(author.getFirstName() + " " + author.getLastName());
        author.setAuthorId(1990);
        author.setEmailAddress("toye@gmail.com");

        authorRepository.saveAuthor(author);
        assertEquals(1, authorRepository.getCount());
    }

    @Test
    void findAuthorById() {
        Author author = response();
        Author author__ = response();
        authorRepository.saveAuthor(author);
        System.out.println(author);
        author__.setAuthorId(2000);
        author__.getAuthorId();
        authorRepository.saveAuthor(author__);
        System.out.println(author__);

//        assertEquals(, );
    }

    @Test
    void findAuthorByUsername() {
    }

    @Test
    void findAuthor() {
    }

    @Test
    void findAllAuthor() {
        Author author = response();
        Author author__ = response();
        authorRepository.saveAuthor(author);
        authorRepository.saveAuthor(author__);

        assertEquals(2, authorRepository.getCount());
    }

    @Test
    void deleteAuthor() {
    }

    @Test
    void deleteAllAuthor() {
    }

    @Test
    void deleteAuthorByUsername() {
    }
}