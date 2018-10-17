package iprogr.constructionFirm.contact;
import iprogr.constructionFirm.message.Message;
import iprogr.constructionFirm.message.MessageService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;


@Controller
public class ContactsController {
    private final MessageService messageService;
    private final ContactService contactService;

    public ContactsController(ContactService contactService, MessageService messageService) {
        this.messageService = messageService;
        this.contactService=contactService;
    }

    @GetMapping("/contacts")
    public String greeting() {
        return "contacts";
    }

    @PostMapping
    public void createMessage(@RequestParam String text, @RequestParam String sender) throws IOException {
        Message message = new Message();
        message.setSenderMail(sender);
        message.setText(text);
        message.setStatus(Message.MessageStatus.PENDING);
        messageService.create(message);
    }
}
