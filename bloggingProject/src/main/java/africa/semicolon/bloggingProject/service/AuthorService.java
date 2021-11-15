package africa.semicolon.bloggingProject.service;

import africa.semicolon.bloggingProject.data.model.Author;
import africa.semicolon.bloggingProject.dtos.request.AddAuthorRequest;
import africa.semicolon.bloggingProject.dtos.response.AddAuthorResponse;

public interface AuthorService {

    AddAuthorResponse createAuthor(AddAuthorRequest request);
    Author findAuthorById(Integer authorId);

}
