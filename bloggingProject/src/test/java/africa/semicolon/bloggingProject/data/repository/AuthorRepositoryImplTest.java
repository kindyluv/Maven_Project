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
        author.setUserName(author.getFirstName() + " @ " + author.getLastName());
        author.setAuthorId(1990);
        author.setEmailAddress(author.getLastName()+"@gmail.com");

        return author;
    }

    @Test
    void save() {
        Author author = new Author();
        author.setFirstName("Toye");
        author.setLastName("David");
        author.setUserName(author.getFirstName() + " " + author.getLastName());
        author.setAuthorId(1990);
        author.setEmailAddress(author.getLastName()+"@gmail.com");

        authorRepository.saveAuthor(author);
        assertEquals(1, authorRepository.findAllAuthor().size());
    }

    @Test
    void findAuthorById() {
        Author author = response();
        authorRepository.saveAuthor(author);

        Author author__ = authorRepository.findAuthorById(author.getAuthorId());
        Author author_ = authorRepository.saveAuthor(author__);

        assertEquals(1990, author_.getAuthorId());
    }

    @Test
    void findAuthorByUsername() {
        Author author = response();

        authorRepository.saveAuthor(author);
        Author author__ = authorRepository.findAuthorByUsername(author.getUserName());
        assertEquals("Toye @ David", author__.getUserName());

    }

    @Test
    void findAuthor() {
    }

    @Test
    void findAllAuthor() {
        Author author = response();
        authorRepository.saveAuthor(author);

        assertEquals(1, authorRepository.findAllAuthor().size());
    }

    @Test
    void deleteAuthor() {
        Author author = response();
        Author author_ = authorRepository.saveAuthor(author);

        authorRepository. deleteAuthorId(author_.getAuthorId());
        assertEquals(0, authorRepository.findAllAuthor().size());
    }

    @Test
    void deleteAllAuthor() {
        Author author1 = response();
        Author author_ = authorRepository.saveAuthor(author1);

        Author author = new Author();
        author.setFirstName("Lois");
        author.setLastName("Ama");
        author.setUserName(author.getFirstName() + " " + author.getLastName());
        author.setAuthorId(9690);
        author.setEmailAddress(author.getLastName()+"@gmail.com");

        authorRepository.saveAuthor(author);
        authorRepository.deleteAllAuthor();
        assertEquals(0, authorRepository.findAllAuthor().size());
    }
}