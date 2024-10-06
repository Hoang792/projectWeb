package com.example.projectweb.Service;

import com.example.projectweb.Model.sanphamchitiet;
import com.example.projectweb.Service.impl.SanPhamChiTietIMPL;


import java.util.List;

public interface SanPhamChitietService {
    List<sanphamchitiet> getAllSanPhamChiTiets();
    List<sanphamchitiet> findAll();
    void save(sanphamchitiet spct);
    void deleteById(Integer tensp);
    sanphamchitiet findById(Integer idsp);
    List<sanphamchitiet> findAllByTenspContaining(String tensp);

}
