package africa.semicolon.cheetah.services;

import africa.semicolon.cheetah.data.models.Sender;
import africa.semicolon.cheetah.data.repositories.SenderRepository;
import africa.semicolon.cheetah.data.repositories.SenderRepositoryImpl;
import africa.semicolon.cheetah.dtos.request.RegisterSenderRequest;
import africa.semicolon.cheetah.dtos.responses.RegisterSenderResponse;
import africa.semicolon.cheetah.exceptions.DuplicateUserException;
import africa.semicolon.cheetah.exceptions.SenderNotFoundException;
import africa.semicolon.cheetah.utils.ModelMapper;

import java.util.List;
import java.util.Optional;

public class SenderServiceImpl implements SenderService{
    private static final SenderRepository senderRepository = new SenderRepositoryImpl();
    @Override
    public RegisterSenderResponse registerSender(RegisterSenderRequest request) throws SenderNotFoundException {
        Optional<Sender> savedInDatabase = senderRepository.findSenderByEmail(request.getSenderEmail());
        if  (savedInDatabase.isPresent()) throw new DuplicateUserException (request.getSenderEmail() + " already exists");
        //convert to sender
        Sender sender = ModelMapper.map(request);
        //save sender
        Sender savedSender = senderRepository.save(sender);
        //convert sender to dto
        RegisterSenderResponse response = ModelMapper.map(savedSender);
        //return dto
        return response;
    }

    @Override
    public List<Sender> getSender() {
        return senderRepository.findAll();
    }

    @Override
    public void deleteAllSenders() {
        senderRepository.deleteAll();
    }

    @Override
    public Optional<Sender> findSenderByEmail(String email) throws SenderNotFoundException {
        if (!senderRepository.findSenderByEmail(email).isPresent()) throw new SenderNotFoundException("Sender not found");
        return senderRepository.findSenderByEmail(email);
    }
}
