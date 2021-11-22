package africa.semicolon.bloggingProject.controller;

import africa.semicolon.bloggingProject.data.model.Author;
import africa.semicolon.bloggingProject.dtos.request.AddAuthorRequest;
import africa.semicolon.bloggingProject.dtos.response.AddAuthorResponse;
import africa.semicolon.bloggingProject.exception.DuplicateEmailException;
import africa.semicolon.bloggingProject.exception.TrackingIdNotFoundException;
import africa.semicolon.bloggingProject.service.AuthorService;
import africa.semicolon.bloggingProject.service.AuthorServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthorController {
    private final AuthorService authorService = new AuthorServiceImpl();

    @PostMapping("/api/author")
    public ResponseEntity<?> createAuthor(@RequestBody AddAuthorRequest request){
        try{
            AddAuthorResponse response = authorService.createAuthor(request);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        }catch(DuplicateEmailException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/api/author/{id}")
    public ResponseEntity<?> findAuthorById(@PathVariable("id")Integer authorId){
        try{
            Author author = authorService.findAuthorById(authorId);
            return new ResponseEntity<>(author, HttpStatus.ACCEPTED);
        }catch(TrackingIdNotFoundException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
