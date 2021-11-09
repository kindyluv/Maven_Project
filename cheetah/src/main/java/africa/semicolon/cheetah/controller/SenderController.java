package africa.semicolon.cheetah.controller;

import africa.semicolon.cheetah.data.models.Sender;
import africa.semicolon.cheetah.dtos.request.RegisterSenderRequest;
import africa.semicolon.cheetah.dtos.responses.RegisterSenderResponse;
import africa.semicolon.cheetah.services.SenderService;
import africa.semicolon.cheetah.services.SenderServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

public class SenderController {
    private SenderService senderService = new SenderServiceImpl();

    @PostMapping("/api/v1/sender")
    public RegisterSenderResponse registerSender(@RequestBody RegisterSenderRequest request){
        return senderService.registerSender(request);
    }

    @GetMapping("/api/v1/sender/{id}")
    public Optional<Sender> getSenderById(@PathVariable String email){
        return senderService.findSenderByEmail(email);
    }
}
