package com.example.projectweb.Service.IMPL;

import com.example.projectweb.Model.*;

import com.example.projectweb.Repository.MauRepository;
import com.example.projectweb.Service.GioHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GioHangimpl implements GioHangService {
    private GioHang GH = new GioHang();

    @Override
    public void addToCart(sanphamchitiet sp, mau Mau, size Size, hoadonchitiet HDCT) {
        GH.addItem(sp, Mau, Size, HDCT); // Thêm sản phẩm vào giỏ hàng
    }

    @Override
    public GioHang getCart() {
        return GH;
    }

    @Override
    public void removeFromCart(sanphamchitiet sp) {
        GH.removeItem(sp);
    }
}
