package br.com.fiap.epictaskg.character;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/characters")
public class CharacterController {

    @Autowired
    CharacterService service;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("characters", service.listAll());
        return "character/index";
    }

    @GetMapping("/new")
    public String form(Character character) {
        return "character/form";
    }

    @PostMapping
    public String save(@Valid Character character, BindingResult result) {
        if (result.hasErrors()) {
            return "character/form";
        }
        service.save(character);
        return "redirect:/characters";
    }
}
