package parcial2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import parcial2.model.Capitulo;
import parcial2.service.ServiceCap;

@Controller
public class CapController {
    private final ServiceCap ServiceCap;


    @Autowired
    public CapController(ServiceCap serviceCap) {
        this.ServiceCap = serviceCap;
    }

    @GetMapping("/index")
    public String index(Model model) {
        Capitulo capitulo = ServiceCap.getCapMejor();
        model.addAttribute("capitulo", capitulo);
        return "index";
    }
}
