package com.example.projectweb.Service;

import com.example.projectweb.Model.HoaDon;

import java.util.List;

public interface HoaDonService {
    List<HoaDon> findAll();
    void save(HoaDon hoaDon);
    void deleteById(Integer id);
    HoaDon findById(Integer id);
    List<HoaDon> findAllByTrangThaiContaining(String trangThai);
}
