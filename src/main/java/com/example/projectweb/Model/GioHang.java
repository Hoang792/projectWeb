package com.example.projectweb.Model;

import java.util.HashMap;
import java.util.Map;

public class GioHang {
    private Map<Long, GioHangItem> items = new HashMap<>();

    public void addItem(sanphamchitiet sanpham,mau Mau,size Size,hoadonchitiet HDCT) {
        if (items.containsKey(Long.valueOf(sanpham.getIdSPCT()))) {
            // Nếu sản phẩm đã tồn tại, cập nhật số lượng
            GioHangItem existingItem = items.get(Long.valueOf(sanpham.getIdSPCT()));
            existingItem.getHDCT().setSoluong(existingItem.getHDCT().getSoluong() + HDCT.getSoluong());
            existingItem.setMau(Mau); // Cập nhật màu
            existingItem.setSize(Size); // Cập nhật kích thước
        } else {
            // Nếu không, thêm sản phẩm mới vào giỏ hàng
            items.put(Long.valueOf(sanpham.getIdSPCT()), new GioHangItem(sanpham, Mau, Size, HDCT));
        }

    }

    public void removeItem(sanphamchitiet sanpham) {
        items.remove(Long.valueOf(sanpham.getIdSPCT()), sanpham); // Xóa sản phẩm khỏi giỏ hàng dựa trên ID
    }

    public Map<Long, GioHangItem> getItems() {
        return items;
    }

    public void clear() {
        items.clear();
    }

    public double getTotalPrice() {
        double total = 0.0;
        for (GioHangItem item : items.values()) {
            total += item.getSanPham().getGia() * item.getHDCT().getSoluong();
        }
        return total;
    }

}
