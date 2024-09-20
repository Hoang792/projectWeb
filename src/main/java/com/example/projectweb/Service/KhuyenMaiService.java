package com.example.projectweb.Service;

import com.example.projectweb.Model.KhuyenMai;

import java.util.List;

public interface KhuyenMaiService {
    List<KhuyenMai> findAll();
    void save(KhuyenMai khuyenMai);
    void deleteById(Integer id);
    KhuyenMai findById(Integer id);
    List<KhuyenMai> findAllByTenKMContaining(String tenKM);
}
