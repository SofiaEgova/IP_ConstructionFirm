package iprogr.constructionFirm.message;

import iprogr.constructionFirm.BaseRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;

@Service
public class MessageService {
    private final BaseRepo<Message> messageRepo;

    public MessageService(MessageRepo messageRepo) {
        this.messageRepo = messageRepo;
    }

    public List<Message> getAll() throws IOException{
        return messageRepo.getAll();
    }

    @Transactional
    public void create(Message message) throws IOException {
        messageRepo.save(message);
    }
}
