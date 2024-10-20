package com.example.projectweb.Service;

import com.example.projectweb.Model.*;

import java.util.Optional;


public interface GioHangService {
    void addToCart(sanphamchitiet sanpham, mau Mau, size Size, hoadonchitiet HDCT);
    GioHang getCart();

    void removeFromCart(sanphamchitiet GH);
}
