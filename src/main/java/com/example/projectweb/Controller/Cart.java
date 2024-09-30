package com.example.projectweb.Controller;

import com.example.projectweb.Model.sanphamchitiet;
import com.example.projectweb.Service.GioHangService;
import com.example.projectweb.Service.SanPhamChitietService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Cart {
    @Autowired
    private GioHangService giohangservice;
    @Autowired
    private SanPhamChitietService sanPhamService;

    @GetMapping("/cart")
    public String showCart(Model model) {
        model.addAttribute("giohang", giohangservice.getCart());
        return "GioHang";
    }

    @GetMapping("/cart/add")
    public String addToCart(@RequestParam Long id, Model model) {
        sanphamchitiet sanPham = sanPhamService.findById(id);
        if (sanPham != null){
            giohangservice.addToCart(id);
    }
        return "redirect:/GioiHang";
    }
}
