package com.example.projectweb.Controller;

import com.example.projectweb.Model.size;
import com.example.projectweb.Service.SizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.util.Optional;

@Controller
public class SizeController {
    @Autowired
    private SizeService sizeService;
    @GetMapping("/qlySize")
    public String Size(Model model) {
        model.addAttribute("size", sizeService.getAllSizes());
        return "quanlysize";
    }

    // thêm Size
    @GetMapping("/addSize")
    public String addsize(Model model) {
        model.addAttribute("size", new size());
        return "ViewThemSize";
    }
    @PostMapping("/saveSize")
    public String savesize(@ModelAttribute("Size") size Size
    ) throws IOException {

        sizeService.saveSize(Size);
        return "redirect:/qlySize";
    }
    // Sửa Size
    @GetMapping("/editsize")
    public String editSize(@RequestParam("idsize") Integer idsize, Model model) {
        Optional<size> sizes = sizeService.findSizeByIdsize(idsize);
        sizes.ifPresent(p -> model.addAttribute("size", p));
        return "ViewSuaSize";
    }

    @PostMapping("/updatesize")
    public String updateSize(@ModelAttribute("phone") size Size
    ) throws IOException {

        sizeService.saveSize(Size);
        return "redirect:/qlySize";
    }


}
