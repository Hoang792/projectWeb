package com.example.projectweb.Model;

import java.util.HashMap;
import java.util.Map;

public class GioiHang {
    private Long productId;
    private int quantity;
    private Map<Long,sanphamchitiet>items = new HashMap<Long,sanphamchitiet>();

    public GioiHang(Long id, int i) {
    }

    public void addItem(sanphamchitiet sanpham) {
        items.put(sanpham.getIdSPCT().longValue(), sanpham);
    }
    public Map<Long, sanphamchitiet> getItems() {
        return items;
    }
    public void removeItem(Long id) {
        items.remove(id);
    }
    public void clear() {
        items.clear();
    }
    public Long getProductId() {
        return productId ;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


}
