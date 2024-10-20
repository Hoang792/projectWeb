package com.example.projectweb.Model;

public class GioHangItem {

    private sanphamchitiet sanPham;
    private mau Mau;
    private size Size;
    private hoadonchitiet HDCT;

    public GioHangItem(sanphamchitiet sanPham, mau Mau,size Size,hoadonchitiet HDCT) {
        this.sanPham = sanPham;
        this.Mau = Mau;
        this.Size=Size;
        this.HDCT=HDCT;
    }

    public sanphamchitiet getSanPham() {
        return sanPham;
    }

    public void setSanPham(sanphamchitiet sanPham) {
        this.sanPham = sanPham;
    }

    public mau getMau() {
        return Mau;
    }

    public void setMau(mau mau) {
        Mau = mau;
    }

    public size getSize() {
        return Size;
    }

    public void setSize(size size) {
        Size = size;
    }

    public hoadonchitiet getHDCT() {
        return HDCT;
    }

    public void setHDCT(hoadonchitiet HDCT) {
        this.HDCT = HDCT;
    }
}
