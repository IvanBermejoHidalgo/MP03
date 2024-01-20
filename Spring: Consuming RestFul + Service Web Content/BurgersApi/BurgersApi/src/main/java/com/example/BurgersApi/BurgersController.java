package com.example.BurgersApi;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(BurgersController.RECETAS)
public class BurgersController {

    public static final String RECETAS = "/recetas";

    @Autowired
    BurgersService burgersService;

    @GetMapping
    public String getRecetas(Model model) {
        List<Receta> recetas = burgersService.getRecetas();
        model.addAttribute("recetas", recetas);
        return "recetas";
    }
}