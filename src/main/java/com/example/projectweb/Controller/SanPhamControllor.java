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
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Controller
public class SanPhamControllor {
    public static final String UPLOAD_DIR = "src/main/resources/image/";
    @Autowired
    private SanPhamChitietService sanPhamChitietService;
    @Autowired
    private SizeService sizeService;
    @Autowired
    private thuonghieuService thuonghieuservice;
    @Autowired
    private MauService mauService;

    @GetMapping("/quanlysanpham")
    public String sanpham(Model model , @RequestParam(name = "timkiem", required = false) String timkiem) {
        List<sanphamchitiet> sanpham;
        if(timkiem==null){
            sanpham = sanPhamChitietService.findAll();
        }else {
            sanpham = sanPhamChitietService.SearchSP("%"+timkiem+"%");
            if(sanpham.isEmpty()){
                model.addAttribute("thongbaokhongtimthaysp", "Không tìm thấy sản phẩm nào với tên tìm kiếm!");
                return "quanlysanpham";
            }
        }
        model.addAttribute("sanpham", sanpham);
        return "quanlysanpham";
    }

    @GetMapping("/searchQLsp")
    public String searchQLsp(@RequestParam("query") String query, Model model) {
        List<sanphamchitiet> sp = sanPhamChitietService.SearchSP(query);
        if (sp.isEmpty()) {
            model.addAttribute("thongbaokhongtimthaysp", "Không tìm thấy sản phẩm nào với tên tìm kiếm!");
            return "quanlysanpham";
        }
        else {
        model.addAttribute("sanpham", sp);
        }

        return "quanlysanpham";
    }

    // thêm sản phẩm
    @GetMapping("/addSanPham")
    public String addSanPham(Model model) {
        model.addAttribute("sanpham", new sanphamchitiet());
        // lấy danh sách thương hiệu đổ vào view Thêm sản phẩm :
        List<thuonghieu> ThuongHieuList = thuonghieuservice.getAllThuongHieus();
        model.addAttribute("ThuongHieu", ThuongHieuList);
        // lấy danh sách size
        List<size> SizeList = sizeService.getAllSizes();
        model.addAttribute("Size", SizeList);
        //lấy danh sách màu
        List<mau> MauList = mauService.getAllMaus();
        model.addAttribute("Mau", MauList);

        return "viewThemSanPham";
    }

    //lưu sản phẩm
    @PostMapping("/saveSanPham")
    public String saveSanPham(@ModelAttribute("sanpham") sanphamchitiet sanpham,
                              @RequestParam("file") MultipartFile file) throws IOException {
        if (!file.isEmpty()) {
            // Lấy tên tệp gốc
            String fileName = file.getOriginalFilename();

            // Đặt đường dẫn để lưu tệp vào thư mục trên server
            String UPLOAD_DIR = "src/main/resources/image/"; // Thay đổi thư mục lưu tệp phù hợp với project của bạn
            Path path = Paths.get(UPLOAD_DIR + fileName);

            // Lưu tệp vào thư mục
            Files.write(path, file.getBytes());

            // Cập nhật tên tệp (hoặc đường dẫn tương đối) vào đối tượng sanphamchitiet
            sanpham.setImage(fileName); // Giả sử cột lưu tên ảnh là 'image'
        }

        sanPhamChitietService.save(sanpham);
        return "redirect:/quanlysanpham";
    }

    // xóa sản phẩm
    @GetMapping("/deleteSanPham")
    public String deleteSanPham(@RequestParam("idsanpham") Integer idsanpham) {
        sanPhamChitietService.deleteById(idsanpham);
        return "redirect:/quanlysanpham";
    }

    // sửa sản phẩm
    @GetMapping("/editSanPham")
    public String editSanPham(@RequestParam("idsanpham") Integer idsanpham, Model model) {
        sanphamchitiet sanpham = sanPhamChitietService.findById(idsanpham);
        model.addAttribute("sanpham", sanpham);
        // lấy danh sách thương hiệu đ�� vào view Thêm sản phẩm :
        List<thuonghieu> ThuongHieuList = thuonghieuservice.getAllThuongHieus();
        model.addAttribute("ThuongHieu", ThuongHieuList);
        // lấy danh sách size
        List<size> SizeList = sizeService.getAllSizes();
        model.addAttribute("Size", SizeList);
        //lấy danh sách màu
        List<mau> MauList = mauService.getAllMaus();
        model.addAttribute("Mau", MauList);
        return "viewSuaSanPham";
    }

    // cập nhật sản phẩm
    @PostMapping("/updateSanPham")
    public String updateSanPham(@ModelAttribute("sanpham") sanphamchitiet sanpham,
                                @RequestParam("file") MultipartFile file) throws IOException {
        if (!file.isEmpty()) {
            String fileName = file.getOriginalFilename();
            Path path = Paths.get(UPLOAD_DIR + fileName);
            Files.write(path, file.getBytes());
            sanpham.setImage(fileName); // Đư��ng d��n tương đối đến ảnh
        }
        sanPhamChitietService.save(sanpham);
        return "redirect:/quanlysanpham";
    }
}
