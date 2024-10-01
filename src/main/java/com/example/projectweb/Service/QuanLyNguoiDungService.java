package com.example.projectweb.Service;

import com.example.projectweb.Model.QuanLyNguoiDung;

import java.util.List;

public interface QuanLyNguoiDungService {
    List<QuanLyNguoiDung> getAllQuanLyNguoiDungs();
    List<QuanLyNguoiDung> findAll();
    void save(QuanLyNguoiDung quanLyNguoiDung);
    void deleteById(Integer idNguoiDung, Integer idQuyen);
    QuanLyNguoiDung findById(Integer idNguoiDung, Integer idQuyen);
}
