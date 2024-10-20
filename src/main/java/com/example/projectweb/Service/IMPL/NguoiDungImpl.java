package com.example.projectweb.Service.IMPL;

import com.example.projectweb.Model.NguoiDung;
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
    public List<NguoiDung> findAll() {
        return nguoiDungRepository.findAll();
    }

    @Override
    public List<NguoiDung> getAllNguoiDungs() {
        return (List<NguoiDung>) nguoiDungRepository.findAll();
    }

    @Override
    public void save(NguoiDung nguoiDung) {
        nguoiDungRepository.save(nguoiDung);
    }

    @Override
    public void deleteById(Integer id) {
        nguoiDungRepository.deleteById(id);
    }

    @Override
    public NguoiDung findById(Integer id) {
        return nguoiDungRepository.findById(id).orElse(null);
    }

    @Override
    public NguoiDung findByEmail(String email) {
        return nguoiDungRepository.findByEmail(email);
    }

    @Override
    public List<NguoiDung> findAllBytenNguoiDungContaining(String tenNguoiDung) {
        return nguoiDungRepository.findAllBytenNguoiDungContaining(tenNguoiDung);
    }
}
