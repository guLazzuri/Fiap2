package br.com.fiap.epictaskg.Ufo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/ufo")
public class UfoController {

    private final UfoService ufoService;

    public UfoController(UfoService ufoService) {
        this.ufoService = ufoService;
    }

    @GetMapping
    public String index(Model model){
        var ufo = ufoService.getAllUfos();
        model.addAttribute("ufo", ufo);
        return "index";
    }

    @GetMapping("/form")
    public String form(){
        return "form";
    }

    @PostMapping("/form")
    public String create(Ufo ufo, RedirectAttributes redirect ){ //session
        ufoService.save(ufo);
        redirect.addFlashAttribute("message", "Ufo cadastrado com sucesso!");
        return "redirect:/ufo"; //301
    }
}
