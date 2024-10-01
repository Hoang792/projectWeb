package com.example.projectweb.Service;

import com.example.projectweb.Model.NguoiDung;

import java.util.List;

public interface NguoiDungService {
    List<NguoiDung> getAllNguoiDungs();
    List<NguoiDung> findAll();
    void save(NguoiDung nguoiDung);
    void deleteById(Integer id);
    NguoiDung findById(Integer id);
    NguoiDung findByEmail(String email);
    List<NguoiDung> findAllBytenNguoiDungContaining(String tenNguoiDung);
}
