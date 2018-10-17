package iprogr.constructionFirm.service;

import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ServiceService {
    private final ServiceRepo serviceRepo;

    public ServiceService(ServiceRepo serviceRepo) {
        this.serviceRepo = serviceRepo;
    }

    public List<iprogr.constructionFirm.service.Service> getAll(){
        return serviceRepo.findAll();
    }
}
