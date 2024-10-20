package com.example.projectweb.Service.impl;

import com.example.projectweb.Model.nguoidung;
import com.example.projectweb.Repository.NguoiDungRepository;
import com.example.projectweb.Service.NguoiDungService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NguoiDungImpl implements NguoiDungService {

    @Autowired
    private NguoiDungRepository nguoiDungRepository;

    @Override
    public List<nguoidung> findAll() {
        return nguoiDungRepository.findAll();
    }

    @Override
    public List<nguoidung> getAllNguoiDungs() {
        return (List<nguoidung>) nguoiDungRepository.findAll();
    }

    @Override
    public void save(nguoidung nguoiDung) {
        nguoiDungRepository.save(nguoiDung);
    }

    @Override
    public void deleteById(Integer id) {
        nguoiDungRepository.deleteById(id);
    }

    @Override
    public nguoidung findById(Integer id) {
        return nguoiDungRepository.findById(id).orElse(null);
    }

    @Override
    public nguoidung findByEmail(String email) {
        return nguoiDungRepository.findByEmail(email);
    }

    @Override
    public List<nguoidung> findAllBytenNguoiDungContaining(String tenNguoiDung) {
        return nguoiDungRepository.findAllBytenNguoiDungContaining(tenNguoiDung);
    }
}
