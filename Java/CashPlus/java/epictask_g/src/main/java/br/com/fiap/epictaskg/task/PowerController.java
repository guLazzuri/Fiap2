package br.com.fiap.epictaskg.task;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/power")
public class PowerController {

    private final PowerService PowerService;

    public PowerController(PowerService PowerService) {
        this.PowerService = PowerService;
    }

    @GetMapping
    public String index(Model model){
        var power = PowerService.getAllTasks();
        model.addAttribute("powers", power);
        return "index";
    }
}
