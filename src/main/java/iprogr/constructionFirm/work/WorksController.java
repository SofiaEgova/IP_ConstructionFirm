package iprogr.constructionFirm.work;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WorksController {
    @GetMapping("/works")
    public String greeting() {
        return "works";
    }
}
