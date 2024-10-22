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
    /* @GetMapping("/quanlysanpham")
    public String sanpham(Model model) {
        List<sanphamchitiet> sanpham;
        model.addAttribute("sanpham", sanPhamChitietService.findAll());
        return "quanlysanpham";
    } */

    @Autowired
    private thuonghieuService thuonghieuservice;

    @GetMapping("/search")
    public String searchSP(@RequestParam("query") String query, Model model) {
        List<sanphamchitiet> sp = sanPhamChitietService.SearchSP(query);
        model.addAttribute("sanpham", sp);
        return "index";
    }


    @GetMapping("/addGiohang")
    public String addGiohang(Model model) {
        model.addAttribute("giohang", new hoadonchitiet());
        return "TrangGioHang";
    }


    @PostMapping("/savegiohang")
    public String saveGioHang(@ModelAttribute("HoaDonChiTiet") hoadonchitiet hoadonchitiet
    ) throws IOException {

        hoaDonService.save(hoadonchitiet.getIdHD());
        return "redirect:/qlyHoaDon";
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
        return "ThongTinSP";
    }

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

    @GetMapping("/deletehoadon")
    public String deleteHoaDon(@RequestParam("idhd") Integer idhd) {
        hoaDonService.deleteById(idhd);
        return "redirect:/qlyHoaDon";
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



    @GetMapping("/addKhuyenMai")
    public String addKhuyenMai(Model model) {
        model.addAttribute("khuyenmai", new KhuyenMai());
        return "ViewThemKhuyenMai";
    }
    @PostMapping("/savekhuyenmai")
    public String saveKhuyenMai(@ModelAttribute("KhuyenMai") KhuyenMai khuyenMai
    ) throws IOException {

        khuyenMaiService.save(khuyenMai);
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
    public String editMau(@RequestParam("idmau") Integer idmau, Model model) {
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

