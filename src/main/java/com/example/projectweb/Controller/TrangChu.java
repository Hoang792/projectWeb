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
    private SanPhamChitietService sanPhamChitietService;
    @Autowired
    private SizeService sizeService;
    @Autowired
    private thuonghieuService thuonghieuservice;

    private final String UPLOAD_DIR = "src/main/resources/image/";

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
    //trang quản lý thương hiệu
    @GetMapping("/quanlythuonghieu")
    public String thuonghieu(Model model) {
        model.addAttribute("thuonghieu", thuonghieuservice.getAllThuongHieus());
        return "quanlythuonghieu";
    }

    //thêm màu
    @GetMapping("/add")
    public String addPhoneForm(Model model) {
        model.addAttribute("maus", new mau());
        return "viewThem";
    }
    @GetMapping("/addthuonghieu")
    public String addthuonghieu(Model model) {
        model.addAttribute("thuonghieus", new thuonghieu());
        return "viewthemthuonghieu";
    }

    // lưu màu
    @PostMapping("/save")
    public String saveMau(@ModelAttribute("mau") mau maus
    ) throws IOException {
        mauService.saveMau(maus);
        return "redirect:/qlyMau";
    }
    // lưu thương hiệu
    @PostMapping("/savethuonghieu")
    public String savethuonghieu(@ModelAttribute("thuonghieu") thuonghieu thuonghieus) throws IOException{
        thuonghieuservice.savethuonghieu(thuonghieus);
        return "redirect:/quanlythuonghieu";
    }


    //sửa màu
    @GetMapping("/edit")
    public String editMau(@RequestParam("idmau") Long idmau, Model model) {
        Optional<mau> mau = mauService.findMauByIdmau(idmau);
        mau.ifPresent(p -> model.addAttribute("maus", p));
        return "viewSua";
    }
    // sửa thương hiệu
    @GetMapping("/editthuonghieu")
    public String editthuonghieu(@RequestParam("idthuonghieu") Long idthuonghieu, Model model) {
        Optional<thuonghieu> thuonghieu = thuonghieuservice.findThuongHieuById(idthuonghieu);
        thuonghieu.ifPresent(p -> model.addAttribute("thuonghieus", p));
        return "viewsuathuonghieu";
    }

    // update màu
    @PostMapping("/update")
    public String updateMau(@ModelAttribute("phone") mau maus
    ) throws IOException {

        mauService.saveMau(maus);
        return "redirect:/qlyMau";
    }
    // updatethuonghieu
    @PostMapping("/updatethuonghieu")
    public String updatethuonghieu(@ModelAttribute("thuonghieu") thuonghieu thuonghieus) throws IOException{
        thuonghieuservice.savethuonghieu(thuonghieus);
        return "redirect:/quanlythuonghieu";
    }

    //xóa màu
    @GetMapping("/delete")
    public String deleteMau(@RequestParam("idmau") Long idmau) {
        mauService.deleteMau(idmau);
        return "redirect:/qlyMau";
    }
    //xóa thương hiệu
    @GetMapping("/deletethuonghieu")
    public String deletethuonghieu(@RequestParam("idthuonghieu") Long idthuonghieu) {
        thuonghieuservice.deletethuonghieu(idthuonghieu);
        return "redirect:/quanlythuonghieu";
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

