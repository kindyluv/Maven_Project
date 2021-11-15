package africa.semicolon.bloggingProject.service;

import africa.semicolon.bloggingProject.data.model.Author;
import africa.semicolon.bloggingProject.data.repository.AuthorRepository;
import africa.semicolon.bloggingProject.data.repository.AuthorRepositoryImpl;
import africa.semicolon.bloggingProject.dtos.request.AddAuthorRequest;
import africa.semicolon.bloggingProject.dtos.response.AddAuthorResponse;
import africa.semicolon.bloggingProject.utils.authorModelMapper.ModelMapper;

public class AuthorServiceImpl implements AuthorService{
    private final AuthorRepository authorRepository = new AuthorRepositoryImpl();

    @Override
    public AddAuthorResponse createAuthor(AddAuthorRequest request) {
        Author author = ModelMapper.map(request);

        Author savedAuthor = authorRepository.saveAuthor(author);

        AddAuthorResponse response = ModelMapper.map(savedAuthor);
        return response;
    }

    @Override
    public Author findAuthorById(Integer authorId) {
        return authorRepository.findAuthorById(authorId);
    }
}
