package com.example.projectweb.Service;

import com.example.projectweb.Model.khuyenMai;
import com.example.projectweb.Model.size;

import java.util.List;
import java.util.Optional;

public interface KhuyenMaiService {
    List<khuyenMai> getAllKhuyenMais();
    List<khuyenMai> findAll();
    void save(khuyenMai khuyenMai);
    void deletekhuyenmai(Integer idKM);
    Optional<khuyenMai> findByIdKM(Integer idKM);
    List<khuyenMai> findAllByTenKMContaining(String tenKM);
}
