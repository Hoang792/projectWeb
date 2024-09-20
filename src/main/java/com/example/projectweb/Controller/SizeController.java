package com.example.projectweb.Controller;

import com.example.projectweb.Model.mau;
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

    @GetMapping("/quanlysize")
    public String quanlysize(Model model) {
        model.addAttribute("size", sizeService.getAllSizes());
        return "quanlysize";
    }

    //lưu màu
    @PostMapping("/saveSize")
    public String saveSize(@ModelAttribute("size") size size
    ) throws IOException {
        sizeService.saveSize(size);
        return "redirect:/quanlysize";
    }
// thêm size
    @GetMapping("/addSize")
    public String addSize(Model model) {
        model.addAttribute("size", new size());
        return "viewThemSize";
    }

    //xóa size
    @GetMapping("/deleteSize")
    public String deleteMau(@RequestParam("idsize") Long idsize) {
        sizeService.deleteSize(idsize);
        return "redirect:/quanlysize";
    }
    // sửa size
    @GetMapping("/editSize")
    public String editMau(@RequestParam("idsize") Long idsize, Model model) {
        Optional<size> size = sizeService.findSizeByIdsize(Math.toIntExact(idsize));
        size.ifPresent(p -> model.addAttribute("size", p));
        return "viewSuaSize";
    }
    // update size
    @PostMapping("/updateSize")
    public String updateMau(@ModelAttribute("size") size size
    ) throws IOException {

        sizeService.saveSize(size);
        return "redirect:/quanlysize";
    }


}
