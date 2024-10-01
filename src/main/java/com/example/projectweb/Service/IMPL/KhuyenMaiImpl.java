package com.example.projectweb.Service.impl;

import com.example.projectweb.Model.KhuyenMai;
import com.example.projectweb.Repository.KhuyenMaiRepository;
import com.example.projectweb.Service.KhuyenMaiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KhuyenMaiImpl implements KhuyenMaiService {

    @Autowired
    private KhuyenMaiRepository khuyenMaiRepository;

    @Override
    public List<KhuyenMai> getAllKhuyenMais() {
        return (List<KhuyenMai>) khuyenMaiRepository.findAll();
    }

    @Override
    public List<KhuyenMai> findAll() {
        return khuyenMaiRepository.findAll();
    }

    @Override
    public void save(KhuyenMai khuyenMai) {
        khuyenMaiRepository.save(khuyenMai);
    }

    @Override
    public void deleteById(Integer id) {
        khuyenMaiRepository.deleteById(id);
    }

    @Override
    public KhuyenMai findById(Integer id) {
        return khuyenMaiRepository.findById(id).orElse(null);
    }

    @Override
    public List<KhuyenMai> findAllByTenKMContaining(String tenKM) {
        return khuyenMaiRepository.findAllByTenKMContaining(tenKM);
    }
}
