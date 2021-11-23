package africa.semicolon.jijiMoji.data.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document("Listings")
public class Listing {
    @Id
    private String id;
    private String name;
    private String shortDescription;
    private String longDescription;
    private LocalDateTime dateListed = LocalDateTime.now();
    private Condition condition;
    //@JsonIgnore @Lazy
    @DBRef
    private Lister lister;
    private Type type;
}
