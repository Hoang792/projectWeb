package com.example.projectweb.Service;

import com.example.projectweb.Model.thuonghieu;

import java.util.List;
import java.util.Optional;

public interface thuonghieuService {
    List<thuonghieu> getAllThuongHieus();

    Optional<thuonghieu> findThuongHieuById(Integer idthuonghieu);

    List<thuonghieu> searchThuongHieus(String query);
}
