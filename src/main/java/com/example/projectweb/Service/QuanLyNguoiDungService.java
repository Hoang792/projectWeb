package com.example.projectweb.Service;

import com.example.projectweb.Model.QuanLyNguoiDung;

import java.util.List;

public interface QuanLyNguoiDungService {
    List<QuanLyNguoiDung> getAllQuanLyNguoiDung();
    void saveQuanLyNguoiDung(QuanLyNguoiDung quanLyNguoiDung);
    void deleteQuanLyNguoiDung(Integer idNguoiDung, Integer idQuyen);
    List<QuanLyNguoiDung> findByNguoiDungId(Integer idNguoiDung);
    List<QuanLyNguoiDung> findByQuyenId(Integer idQuyen);
}
