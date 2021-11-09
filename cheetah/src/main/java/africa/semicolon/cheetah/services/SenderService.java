package africa.semicolon.cheetah.services;

import africa.semicolon.cheetah.data.models.Sender;
import africa.semicolon.cheetah.dtos.request.RegisterSenderRequest;
import africa.semicolon.cheetah.dtos.responses.RegisterSenderResponse;
import africa.semicolon.cheetah.exceptions.SenderNotFoundException;

import java.util.List;
import java.util.Optional;

public interface SenderService {

    RegisterSenderResponse registerSender(RegisterSenderRequest request) throws SenderNotFoundException;
    List<Sender> getSender();
    void deleteAllSenders();
    Optional<Sender> findSenderByEmail(String email) throws SenderNotFoundException;
}
