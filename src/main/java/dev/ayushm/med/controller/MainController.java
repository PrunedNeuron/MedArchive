package dev.ayushm.med.controller;

import dev.ayushm.med.database.Populator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;

@Controller
public class MainController {

    private static Integer counter = 0;

    @GetMapping("/")
    public String index(Model model) throws IOException {

        if (counter++ <= 0) Populator.populate();
        return "index";
    }

}
