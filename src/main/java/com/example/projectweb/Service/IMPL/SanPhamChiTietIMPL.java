package com.example.projectweb.Service.IMPL;

import com.example.projectweb.Model.sanphamchitiet;
import com.example.projectweb.Repository.SanPhamChiTietRepository;
import com.example.projectweb.Service.SanPhamChitietService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SanPhamChiTietIMPL implements SanPhamChitietService {


    @Autowired
    private SanPhamChiTietRepository sanPhamChiTietRepository;

    @Override
    public List<sanphamchitiet> findAll() {
        return sanPhamChiTietRepository.findAll();
    }

    @Override
    public void save(sanphamchitiet spct) {
        sanPhamChiTietRepository.save(spct);
    }

    @Override
    public void deleteById(Integer id) {
        sanPhamChiTietRepository.deleteById(id);
    }

    @Override
    public sanphamchitiet findById(Integer id) {
        return sanPhamChiTietRepository.findById(id).orElse(null);
    }

    @Override
    public List<sanphamchitiet> findAllByTenspContaining(String tensp) {
        return sanPhamChiTietRepository.findAllByTenspContaining(tensp);
    }

}
