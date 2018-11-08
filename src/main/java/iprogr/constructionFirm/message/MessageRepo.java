package iprogr.constructionFirm.message;

import iprogr.constructionFirm.BaseRepo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepo extends JpaRepository<Message, Integer>, BaseRepo<Message> {
}
