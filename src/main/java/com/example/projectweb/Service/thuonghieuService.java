package com.example.projectweb.Service;

import com.example.projectweb.Model.thuonghieu;

import java.util.List;
import java.util.Optional;

public interface thuonghieuService {
    List<thuonghieu> getAllThuongHieus();
    void save (thuonghieu thuonghieu);
    void delete (Long id);
    thuonghieu findByid(Long id);



}
