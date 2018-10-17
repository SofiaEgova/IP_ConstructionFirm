package iprogr.constructionFirm.work;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkService {
    private final WorkRepo workRepo;

    public WorkService(WorkRepo workRepo){
        this.workRepo=workRepo;
    }

    public List<Work> getAll(){
        return workRepo.findAll();
    }
}
