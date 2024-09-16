package com.example.projectweb.Controller;

import com.example.projectweb.Service.SizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SizeController {
    @Autowired
    private SizeService sizeService;
    @GetMapping("/quanlysize")
    public String quanlysize(Model model) {
        model.addAttribute("size", sizeService.getAllSizes());
        return "quanlysize";
    }


}
