package com.example.projectweb.Controller;

import com.example.projectweb.Model.sanphamchitiet;
import com.example.projectweb.Model.thuonghieu;
import com.example.projectweb.Service.SanPhamChitietService;
import com.example.projectweb.Service.thuonghieuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class QuanLy {
    @Autowired
    private SanPhamChitietService sanPhamChitietService;
    @Autowired
    private thuonghieuService thuonghieuservice;


    @GetMapping("/trangquanlysanpham")
    public String tranglsp() {
        return "quanlysanpham";
    }

    @GetMapping("/trangchu5")
    public String trangchu5(Model model) {
        //hiện danh sách sản phẩm :
        List<sanphamchitiet> sanpham;
        model.addAttribute("sanpham", sanPhamChitietService.findAll());

        //hiện danh sách thương hiệu :
        List<thuonghieu> ThuongHieu;
        model.addAttribute("ThuongHieu", thuonghieuservice.getAllThuongHieus());


        return "/htmlcss/trangchu";
    }
}

