package com.example.projectweb.Service;

import com.example.projectweb.Model.thuonghieu;

import java.util.List;
import java.util.Optional;

public interface thuonghieuService {
    List<thuonghieu> getAllThuongHieus();


    void savethuonghieu(thuonghieu thuonghieus);

    void deletethuonghieu(Long idthuonghieu);

    Optional<thuonghieu> findThuongHieuById(Long idthuonghieu);

    List<thuonghieu> searchThuongHieus(String query);
}
