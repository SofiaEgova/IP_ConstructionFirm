package iprogr.constructionFirm.message;

import iprogr.constructionFirm.FileRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
@Profile("file-store")
public class MessageFileRepo extends FileRepository<Message>{
    public MessageFileRepo(Environment env) {
        super(Message.class, env);
    }
}
