package com.example.projectweb.Service.IMPL;

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
        return (List<thuonghieu>)thuongHieuRepository.findAll();
    }
    @Override
    public void save(thuonghieu thuonghieu) {
    }
    @Override
    public void delete(Long id) {
        thuongHieuRepository.deleteById(id);
    }

    @Override
    public thuonghieu findByid(Long id) {
        return null;
    }

}