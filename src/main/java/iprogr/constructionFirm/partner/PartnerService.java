package iprogr.constructionFirm.partner;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PartnerService {
    private final PartnerRepo partnerRepo;

    public PartnerService(PartnerRepo partnerRepo) {
        this.partnerRepo = partnerRepo;
    }

    public List<Partner> getAll(){
        return partnerRepo.findAll();
    }
}
