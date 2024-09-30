package com.example.projectweb.Service.IMPL;

import com.example.projectweb.Model.GioiHang;
import com.example.projectweb.Model.sanphamchitiet;
import com.example.projectweb.Service.GioHangService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GioHangImpl implements GioHangService {
    private List<GioiHang> cartItems = new ArrayList<>();
    @Override
    public void addToCart(Long id) {
        // Kiểm tra xem sản phẩm đã có trong giỏ hàng chưa
        GioiHang item = cartItems.stream()
                .filter(i -> i.getProductId().equals(id))
                .findFirst()
                .orElse(null);

        if (item != null) {
            // Nếu đã có, tăng số lượng
            item.setQuantity(item.getQuantity() + 1);
        } else {
            // Nếu chưa có, thêm mới vào giỏ hàng
            GioiHang newItem = new GioiHang(id, 1); // Giả sử CartItem có id và quantity
            cartItems.add(newItem);
        }

    }
    @Override
    public GioiHang getCart() {
        return null;
    }

    @Override
    public void removeItem(Long id) {

    }

    @Override
    public void clearCart() {

    }

    @Override
    public double calculateTotal() {
        return GioHangService.super.calculateTotal();
    }
}
