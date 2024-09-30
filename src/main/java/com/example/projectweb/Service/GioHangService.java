package com.example.projectweb.Service;

import com.example.projectweb.Model.GioiHang;
import com.example.projectweb.Model.sanphamchitiet;

public interface GioHangService {
    void addToCart(Long id);

    GioiHang getCart();
    void removeItem(Long id);
    void clearCart();
    default double calculateTotal() {
        // implement logic to calculate total amount of items in the cart
        return 0;
    }


}
