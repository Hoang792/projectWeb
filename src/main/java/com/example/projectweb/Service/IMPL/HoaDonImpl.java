package com.example.projectweb.Service.impl;

import com.example.projectweb.Model.HoaDon;
import com.example.projectweb.Repository.HoaDonRepository;
import com.example.projectweb.Service.HoaDonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HoaDonImpl implements HoaDonService {

    @Autowired
    private HoaDonRepository hoaDonRepository;

    @Override
    public List<HoaDon> findAll() {
        return hoaDonRepository.findAll();
    }

    @Override
    public void save(HoaDon hoaDon) {
        hoaDonRepository.save(hoaDon);
    }

    @Override
    public void deleteById(Integer id) {
        hoaDonRepository.deleteById(id);
    }

    @Override
    public HoaDon findById(Integer id) {
        return hoaDonRepository.findById(id).orElse(null);
    }

    @Override
    public List<HoaDon> findAllBytrangthaiContaining(String trangthai) {
        return hoaDonRepository.findAllBytrangthaiContaining(trangthai);
    }
}
