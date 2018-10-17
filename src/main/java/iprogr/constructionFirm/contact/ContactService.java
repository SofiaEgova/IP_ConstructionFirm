package iprogr.constructionFirm.contact;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ContactService {
    private final ContactRepo contactRepo;

    public ContactService(ContactRepo contactRepo) {
        this.contactRepo = contactRepo;
    }

    public List<Contact> getAll(){
        return contactRepo.findAll();
    }

}
