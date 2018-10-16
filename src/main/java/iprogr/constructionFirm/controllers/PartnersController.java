package iprogr.constructionFirm.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PartnersController {
    @GetMapping("/partners")
    public String greeting() {
        return "partners";
    }
}
