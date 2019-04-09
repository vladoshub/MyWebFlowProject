package ru.mmtr.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class MvcController {

    @RequestMapping("/viewMvc")
    public String getData(Model model) {
        model.addAttribute("message", "Hello world MVC");
        return "mvcView";
    }
}