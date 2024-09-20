package com.example.projectweb.Service;

import com.example.projectweb.Model.sanphamchitiet;



import java.util.List;

public interface SanPhamChitietService {
    List<sanphamchitiet> findAll();
    void save(sanphamchitiet spct);
    void deleteById(Long id);
    sanphamchitiet findById(Long idsp);
    List<sanphamchitiet> findAllByTenspContaining(String tensp);

}
