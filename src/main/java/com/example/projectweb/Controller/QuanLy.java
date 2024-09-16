package com.example.projectweb.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class QuanLy {
@GetMapping("/trangquanlysanpham")
public String tranglsp(){
    return "quanlysanpham";
    }
    @GetMapping("/trangchu5")
    public String tranglsp(Model model){
        return "/htmlcss/trangchu";
    }
}

