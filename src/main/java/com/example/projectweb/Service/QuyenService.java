package com.example.projectweb.Service;

import com.example.projectweb.Model.Quyen;

import java.util.List;

public interface QuyenService {
    List<Quyen> findAll();
    void save(Quyen quyen);
    void deleteById(Integer idquyen);
    Quyen findById(Integer idquyen);
}
