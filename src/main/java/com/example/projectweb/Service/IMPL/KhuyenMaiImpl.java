package com.example.projectweb.Service.impl;

import com.example.projectweb.Model.khuyenMai;
import com.example.projectweb.Model.size;
import com.example.projectweb.Repository.KhuyenMaiRepository;
import com.example.projectweb.Service.KhuyenMaiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public  class KhuyenMaiImpl implements KhuyenMaiService {

    @Autowired
    private KhuyenMaiRepository khuyenMaiRepository;

    @Override
    public List<khuyenMai> getAllKhuyenMais() {
        return (List<khuyenMai>) khuyenMaiRepository.findAll();
    }

    @Override
    public List<khuyenMai> findAll() {
        return khuyenMaiRepository.findAll();
    }

    @Override
    public void save(khuyenMai khuyenMai) {
        khuyenMaiRepository.save(khuyenMai);
    }

    @Override
    public void deletekhuyenmai(Integer idKM) {
        khuyenMaiRepository.deleteById(idKM);
    }

    @Override
    public Optional<khuyenMai> findByIdKM(Integer idKM) {
        return khuyenMaiRepository.findById(idKM);
    }


    @Override
    public List<khuyenMai> findAllByTenKMContaining(String tenKM) {
        return khuyenMaiRepository.findAllByTenKMContaining(tenKM);
    }
}
