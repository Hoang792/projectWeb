package com.example.projectweb.Controller;

import com.example.projectweb.Model.*;
import com.example.projectweb.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class GiohangControllor {

    @Autowired
    private SanPhamChitietService sanPhamChitietService;
    @Autowired
    private GioHangService giohangservice;
    @Autowired
    private MauService mauService;
    @Autowired
    private SizeService sizeService;
    @Autowired
    private HoaDonChiTietService hoaDonChiTietService;
    @Autowired
    private thuonghieuService ThuonghieuService;

    @GetMapping("/giohang/add")
    public String addToCart(@RequestParam("idsp") Integer idsp,
                            @RequestParam("idmau") Integer idmau ,
                            @RequestParam("idsize") Integer idsize,
                            @RequestParam("soluong") Integer soluong,
                            Model model) {
        sanphamchitiet sanpham = sanPhamChitietService.findById(idsp);

        Optional<size> sizeOptional =sizeService.findSizeByIdsize(idsize);

        model.addAttribute("idmau", idmau);
        if (sanpham == null) {
            model.addAttribute("errorMessage", "Sản phẩm không tồn tại.");
            return "redirect:/ThongtinSP?idsp=" + idsp;
        }

        Optional<mau> mauOptional = mauService.findMauByIdmau(idmau);
        if (!mauOptional.isPresent()) {
            model.addAttribute("errorMessage", "Màu sắc không tồn tại.");
            return "redirect:/ThongtinSP?idsp=" + idsp;
        }

        if (!sizeOptional.isPresent()) {
            model.addAttribute("errorMessage", "Kích thước không tồn tại.");
            return "redirect:/ThongtinSP?idsp=" + idsp;
        }

        hoadonchitiet HDCT = new hoadonchitiet();
        HDCT.setSoluong(soluong);

        giohangservice.addToCart(sanpham, mauOptional.get(), sizeOptional.get(), HDCT);

        return "redirect:/ThongtinSP?idsp=" + idsp; // Trở về trang shop
    }

    @GetMapping("/giohang/remove")
    public String removeFromCart(@RequestParam("idsp") Integer idsp, Model model) {
        sanphamchitiet sanpham = sanPhamChitietService.findById(idsp);
        if (sanpham != null) {
            giohangservice.removeFromCart(sanpham);
        } // Gọi phương thức xóa sản phẩm
        return "redirect:/giohang"; // Quay về trang giỏ hàng
    }

    @GetMapping("/giohang")
    public String viewCart(Model model) {

        // Lấy các mục trong giỏ hàng
        model.addAttribute("cartItems", giohangservice.getCart().getItems().values());

        model.addAttribute("totalPrice", giohangservice.getCart().getTotalPrice());



        List<thuonghieu> ThuongHieu;
        model.addAttribute("ThuongHieu", ThuonghieuService.getAllThuongHieus());

        return "TrangGioHang"; // Trả về trang giỏ hàng
    }

}
