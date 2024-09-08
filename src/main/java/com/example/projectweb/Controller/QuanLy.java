package com.example.projectweb.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class QuanLy {
@GetMapping("/trangquanlysanpham")
public String tranglsp(){
    return "quanlysanpham";
    }
}
