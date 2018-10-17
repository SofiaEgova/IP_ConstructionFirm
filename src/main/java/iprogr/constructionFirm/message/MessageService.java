package iprogr.constructionFirm.message;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;

@Service
public class MessageService {
    private final MessageRepo messageRepo;

    public MessageService(MessageRepo messageRepo) {
        this.messageRepo = messageRepo;
    }

    public List<Message> getAll(){
        return messageRepo.findAll();
    }

    @Transactional
    public void create(Message message) throws IOException {
        messageRepo.save(message);
    }
}
