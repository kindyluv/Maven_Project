package africa.semicolon.bloggingProject.utils.authorModelMapper;

import africa.semicolon.bloggingProject.data.model.Author;
import africa.semicolon.bloggingProject.dtos.request.AddAuthorRequest;
import africa.semicolon.bloggingProject.dtos.response.AddAuthorResponse;

public class ModelMapper {
    
    public static Author map(AddAuthorRequest request){
        Author author = new Author();

        author.setFirstName(request.getFirstName());
        author.setLastName(request.getLastName());
        author.setUserName(request.getUserName());
        author.setEmailAddress(request.getEmailAddress());
        author.setAuthorId(request.getAuthorId());
        
        return author;
    }

    public static AddAuthorResponse map(Author savedAuthor){
        AddAuthorResponse response = new AddAuthorResponse();
        response.setFirstName(savedAuthor.getFirstName());
        response.setLastName(savedAuthor.getLastName());
        response.setUserName(savedAuthor.getUserName());
        response.setAuthorId(savedAuthor.getAuthorId());
        response.setEmailAddress(savedAuthor.getEmailAddress());
        return response;
    }
}
