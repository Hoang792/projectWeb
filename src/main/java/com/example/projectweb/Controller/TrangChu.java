package com.example.projectweb.Controller;

import com.example.projectweb.Model.*;
import com.example.projectweb.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.Optional;

@Controller
public class TrangChu {
    @Autowired
    private MauService mauService;
    @Autowired
    private SanPhamChitietService sanPhamChitietService;
    @Autowired
    private HoaDonService hoaDonService;
    @Autowired
    private HoaDonChiTietService hoaDonChiTietService;
    @Autowired
    private KhuyenMaiService khuyenMaiService;
    @Autowired
    private SizeService sizeService;
    @Autowired
    private VoucherService voucherService;

    private final String UPLOAD_DIR = "src/main/resources/image/";

    //hiện sp bên trang quản lý sp
    @GetMapping("/quanlysanpham")
    public String sanpham(Model model) {
        List<sanphamchitiet> sanpham;
        model.addAttribute("sanpham", sanPhamChitietService.findAll());
        return "quanlysanpham";
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

    @GetMapping("/qlyHoaDon")
    public String hoadon(Model model) {
        var hoahon = hoaDonService.getAllHoaDons();
        model.addAttribute("HoaDon", hoaDonService.getAllHoaDons());
        return "HoaDon";
    }

    @GetMapping("/addHoaDon")
    public String addHoaDon(Model model) {
        model.addAttribute("hoadon", new HoaDon());
        return "ViewThemHoaDon";
    }
    @PostMapping("/savehoadon")
    public String saveHoaDon(@ModelAttribute("HoaDon") HoaDon hoaDon
    ) throws IOException {

        hoaDonService.save(hoaDon);
        return "redirect:/qlyHoaDon";
    }
// voucher
    @GetMapping("/qlyVoucher")
    public String voucher(Model model) {
        model.addAttribute("Voucher", voucherService.getAllVouchers());
        return "Voucher";
    }

    // thêm Voucher
    @GetMapping("/addVoucher")
    public String addvoucher(Model model) {
        model.addAttribute("voucher", new voucher());
        return "ViewThemVoucher";
    }
    @PostMapping("/saveVoucher")
    public String savevoucher(@ModelAttribute("voucher") voucher Voucher
    ) throws IOException {

        voucherService.saveVoucher(Voucher);
        return "redirect:/qlyVoucher";
    }
// sửa Voucher
    @GetMapping("/editvoucher")
    public String editVoucher(@RequestParam("idVoucher") Integer idVoucher, Model model) {
        Optional<voucher> Voucher = voucherService.findVoucherById(idVoucher);
        Voucher.ifPresent(p -> model.addAttribute("voucher", p));
        return "ViewSuaVoucher";
    }

    @PostMapping("/updatevoucher")
    public String updateVoucher(@ModelAttribute("phone") voucher Voucher
    ) throws IOException {

        voucherService.saveVoucher(Voucher);
        return "redirect:/qlyVoucher";
    }

    //xóa Voucher
    @GetMapping("/deletevoucher")
    public String deleteVoucher(@RequestParam("idVoucher") Integer idVoucher) {
        voucherService.deleteVoucher(idVoucher);
        return "redirect:/qlyVoucher";
    }



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

    @GetMapping("/qlyHoaDonChiTiet")
    public String hoadonchitiet(Model model) {
        model.addAttribute("bronchitics", hoaDonChiTietService.getAllHoaDonChiTiets());
        return "HoaDonChiTiet";
    }

    @GetMapping("/qlyKhuyenMai")
    public String khuyenmai(Model model) {
        model.addAttribute("KhuyenMai", khuyenMaiService.getAllKhuyenMais());
        return "KhuyenMai";
    }
    //Thêm

    @GetMapping("/addKhuyenMai")
    public String addKhuyenMai(Model model) {
        model.addAttribute("khuyenmai", new khuyenMai());
        return "ViewThemKhuyenMai";
    }
    @PostMapping("/savekhuyenmai")
    public String saveKhuyenMai(@ModelAttribute("KhuyenMai") khuyenMai khuyenMai
    ) throws IOException {

        khuyenMaiService.save(khuyenMai);
        return "redirect:/qlyKhuyenMai";
    }

//Sửa
@GetMapping("/editkhuyenmai")
public String editKhuyenMai(@RequestParam("idKM") Integer idKM, Model model) {
    Optional<khuyenMai> KhuyenMai = khuyenMaiService.findByIdKM(idKM);
    KhuyenMai.ifPresent(p -> model.addAttribute("khuyenMai", p));
    return "ViewSuaKhuyenMai";
}
@PostMapping("/updatekhuyenmai")
    public String updateKhuyenMai(@ModelAttribute("phone") khuyenMai KhuyenMai
    ) throws IOException {
        khuyenMaiService.save(KhuyenMai);
        return "redirect:/qlyKhuyenMai";
    }

    //xóa Khuyến Mãi
    @GetMapping("/deletekhuyenmai")
    public String deleteKhuyenMai(@RequestParam("idKM") Integer idKM) {
        khuyenMaiService.deletekhuyenmai(idKM);
        return "redirect:/qlyKhuyenMai";
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

