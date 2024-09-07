package com.example.projectweb.Service.impl;

import com.example.projectweb.Model.thuonghieu;
import com.example.projectweb.Repository.thuonghieuRepository;
import com.example.projectweb.Service.thuonghieuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class thuonghieuServiceImpl implements thuonghieuService {

    @Autowired
    private thuonghieuRepository thuongHieuRepository;

    @Override
    public List<thuonghieu> getAllThuongHieus() {
        return thuongHieuRepository.findAll();
    }

    @Override
    public Optional<thuonghieu> findThuongHieuById(Integer idthuonghieu) {
        return thuongHieuRepository.findById(idthuonghieu);
    }

    @Override
    public List<thuonghieu> searchThuongHieus(String query) {
        return thuongHieuRepository.findByTenthuonghieuContainingIgnoreCase(query);
    }
}
