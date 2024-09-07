package com.example.projectweb.Controller;

import com.example.projectweb.Service.MauService;
import com.example.projectweb.Service.SizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
@Controller
public class TrangChu {

    @Autowired
    private SizeService sizeService;
    private MauService mauService;

    @GetMapping("/trangchu")
    public String home(Model model) {
        return "index";
    }

    @GetMapping("/trangqly")
    public String qly(Model model) {
        return "trangquanly";
    }

    @GetMapping("/qlyMau")
    public String mau(Model model) {
        model.addAttribute("mau", mauService.getAllMaus());
        return "quanlymau";
    }

    @GetMapping("/qlySize")
    public String size(Model model) {
        model.addAttribute("size", sizeService.getAllSizes() );
        return "quanlysize";
    }
}

