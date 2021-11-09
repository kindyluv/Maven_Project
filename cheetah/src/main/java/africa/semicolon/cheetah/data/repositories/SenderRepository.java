package africa.semicolon.cheetah.data.repositories;

import africa.semicolon.cheetah.data.models.Sender;
import africa.semicolon.cheetah.exceptions.SenderNotFoundException;

import java.util.List;
import java.util.Optional;

public interface SenderRepository {
    Sender save(Sender sender);
    Optional<Sender> findSenderByEmail(String email) throws SenderNotFoundException;
    List<Sender> findAll();
    void deleteBySender(Sender sender);
    void delete(String email);

    void deleteAll();
}
