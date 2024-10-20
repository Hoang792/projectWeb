package com.example.projectweb.Service.IMPL;

import com.example.projectweb.Model.HoaDon;
import com.example.projectweb.Model.hoadonchitiet;
import com.example.projectweb.Repository.HoaDonChiTietRepository;
import com.example.projectweb.Service.HoaDonChiTietService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HoaDonChiTietImpl implements HoaDonChiTietService {

    @Autowired
    private HoaDonChiTietRepository hoaDonChiTietRepository;

    @Override
    public List<hoadonchitiet> getAllHoaDonChiTiets() {
        return (List<hoadonchitiet>) hoaDonChiTietRepository.findAll();
    }

    @Override
    public List<hoadonchitiet> findAll() {
        return hoaDonChiTietRepository.findAll();
    }

    @Override
    public void save(hoadonchitiet hoaDonChiTiet) {
        hoaDonChiTietRepository.save(hoaDonChiTiet);
    }

    @Override
    public void deleteById(Integer id) {
        hoaDonChiTietRepository.deleteById(id);
    }

    @Override
    public hoadonchitiet findById(Integer id) {
        return hoaDonChiTietRepository.findById(id).orElse(null);
    }
}
