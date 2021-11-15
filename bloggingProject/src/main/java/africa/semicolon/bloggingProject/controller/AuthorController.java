package africa.semicolon.bloggingProject.controller;

import africa.semicolon.bloggingProject.data.model.Author;
import africa.semicolon.bloggingProject.dtos.request.AddAuthorRequest;
import africa.semicolon.bloggingProject.dtos.response.AddAuthorResponse;
import africa.semicolon.bloggingProject.service.AuthorService;
import africa.semicolon.bloggingProject.service.AuthorServiceImpl;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthorController {
    private final AuthorService authorService = new AuthorServiceImpl();

    @PostMapping("/api/author")
    public AddAuthorResponse createAuthor(@RequestBody AddAuthorRequest request){
       return authorService.createAuthor(request);
    }
    @GetMapping("/api/author/{id}")
    public Author findAuthorById(@PathVariable("id")Integer authorId){
        return authorService.findAuthorById(authorId);
    }
}
