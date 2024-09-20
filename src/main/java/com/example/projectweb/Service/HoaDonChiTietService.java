package com.example.projectweb.Service;

import com.example.projectweb.Model.hoadonchitiet;

import java.util.List;

public interface HoaDonChiTietService {
    List<hoadonchitiet> findAll();
    void save(hoadonchitiet hoaDonChiTiet);
    void deleteById(Integer id);
    hoadonchitiet findById(Integer id);
}
