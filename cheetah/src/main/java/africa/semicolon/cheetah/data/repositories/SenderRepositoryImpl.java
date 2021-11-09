package africa.semicolon.cheetah.data.repositories;

import africa.semicolon.cheetah.data.models.Sender;
import africa.semicolon.cheetah.exceptions.SenderNotFoundException;

import java.util.*;

public class SenderRepositoryImpl implements SenderRepository{
    Map<String, Sender> database = new HashMap<String, Sender>();


    @Override
    public Sender save(Sender sender) {
        database.put(sender.getEmailAddress(), sender);
        return sender;
    }

    @Override
    public Optional<Sender> findSenderByEmail(String email) throws SenderNotFoundException {
        if(!(database.containsKey(email)))throw new SenderNotFoundException("This sender is not a registered sender please enter a valid details");
        return Optional.of(database.get(email));
    }

    @Override
    public List<Sender> findAll() {
        List<Sender> senderList = new ArrayList<>();
        Set<String> keys = database.keySet();
        for(String key : keys){
            senderList.add(database.get(key));
        }
        return senderList;
    }

    @Override
    public void deleteBySender(Sender sender) {
        delete(sender.getEmailAddress());
    }

    @Override
    public void delete(String email) {
        database.remove(email);
    }

    @Override
    public void deleteAll() {
        database.clear();
    }
}
