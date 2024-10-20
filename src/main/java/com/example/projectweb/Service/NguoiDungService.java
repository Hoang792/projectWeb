package com.example.projectweb.Service;

import com.example.projectweb.Model.nguoidung;

import java.util.List;

public interface NguoiDungService {
    List<nguoidung> getAllNguoiDungs();
    List<nguoidung> findAll();
    void save(nguoidung nguoiDung);
    void deleteById(Integer id);
    nguoidung findById(Integer id);
    nguoidung findByEmail(String email);
    List<nguoidung> findAllBytenNguoiDungContaining(String tenNguoiDung);
}
