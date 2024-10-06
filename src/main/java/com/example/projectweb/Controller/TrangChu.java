package com.example.projectweb.Controller;

import com.example.projectweb.Model.mau;
import com.example.projectweb.Model.sanphamchitiet;
import com.example.projectweb.Model.size;
import com.example.projectweb.Model.thuonghieu;
import com.example.projectweb.Service.MauService;
import com.example.projectweb.Service.SanPhamChitietService;
import com.example.projectweb.Service.SizeService;
import com.example.projectweb.Service.thuonghieuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

@Controller
public class TrangChu {
    @Autowired
    private MauService mauService;

    @Autowired
    private SizeService sizeService;

    @Autowired
    private SanPhamChitietService sanPhamChitietService;

    private final String UPLOAD_DIR = "src/main/resources/image/";

    //hiện sp bên trang quản lý sp
    @GetMapping("/quanlysanpham")
    public String sanpham(Model model) {
        List<sanphamchitiet> sanpham;
        model.addAttribute("sanpham", sanPhamChitietService.findAll());
        return "quanlysanpham";
    }

    @GetMapping("/giohang")
    public String giohang(Model model) {
        List<sanphamchitiet> sanpham;
        model.addAttribute("sanpham", sanPhamChitietService.findAll());

        List<thuonghieu> ThuongHieu;
        model.addAttribute("ThuongHieu", thuonghieuservice.getAllThuongHieus());
        return "TrangGioHang";
    }
    @GetMapping("/ThongtinSP")
    public String sanphamchitiet(@RequestParam("idsp") Integer idsp, Model model) {
        //hiện danh sách sản phẩm :
        List<sanphamchitiet> sanpham;
        model.addAttribute("sanpham", sanPhamChitietService.findById(idsp));
        model.addAttribute("idsp", idsp);

        List<size> Size;
        model.addAttribute("Size", sizeService.getAllSizes());

        List<mau> Mau;
        model.addAttribute("Mau", mauService.getAllMaus());

        //hiện danh sách thương hiệu :
        List<thuonghieu> ThuongHieu;
        model.addAttribute("ThuongHieu", thuonghieuservice.getAllThuongHieus());
        return "TrangThongTinSP";
    }


    @Autowired
    private thuonghieuService thuonghieuservice;

    @GetMapping("/trangchu")
    public String home(Model model) {
        //hiện danh sách sản phẩm :
        List<sanphamchitiet> sanpham;
        model.addAttribute("sanpham", sanPhamChitietService.findAll());

        //hiện danh sách thương hiệu :
        List<thuonghieu> ThuongHieu;
        model.addAttribute("ThuongHieu", thuonghieuservice.getAllThuongHieus());
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

    //thêm
    @GetMapping("/add")
    public String addPhoneForm(Model model) {
        model.addAttribute("maus", new mau());
        return "viewThem";
    }
    @PostMapping("/save")
    public String saveMau(@ModelAttribute("mau") mau maus
    ) throws IOException {
        mauService.saveMau(maus);
        return "redirect:/qlyMau";
    }

    //sửa
    @GetMapping("/edit")
    public String editMau(@RequestParam("idmau") Long idmau, Model model) {
        Optional<mau> mau = mauService.findMauByIdmau(idmau);
        mau.ifPresent(p -> model.addAttribute("maus", p));
        return "viewSua";
    }

    @PostMapping("/update")
    public String updateMau(@ModelAttribute("phone") mau maus
                              ) throws IOException {

        mauService.saveMau(maus);
        return "redirect:/qlyMau";
    }

    //xóa
    @GetMapping("/delete")
    public String deleteMau(@RequestParam("idmau") Long idmau) {
        mauService.deleteMau(idmau);
        return "redirect:/qlyMau";
    }


    //hình ảnh :
    @GetMapping("/image/{hinhAnh}")
    public ResponseEntity<byte[]> getImage(@PathVariable("hinhAnh") String hinhAnh) {
        try {
            File file = new File("src/main/resources/image/" + hinhAnh);
            byte[] imageBytes = Files.readAllBytes(file.toPath());
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.IMAGE_JPEG);
            return new ResponseEntity<>(imageBytes, headers, HttpStatus.OK);
        } catch (IOException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

