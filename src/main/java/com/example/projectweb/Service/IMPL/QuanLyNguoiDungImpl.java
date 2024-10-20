package com.example.projectweb.Service.IMPL;

import com.example.projectweb.Model.QuanLyNguoiDung;
import com.example.projectweb.Model.QuanLyNguoiDungId;
import com.example.projectweb.Repository.QuanLyNguoiDungRepository;
import com.example.projectweb.Service.QuanLyNguoiDungService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuanLyNguoiDungImpl implements QuanLyNguoiDungService {

    @Autowired
    private QuanLyNguoiDungRepository quanLyNguoiDungRepository;


    @Override
    public List<QuanLyNguoiDung> findAll() {
        return quanLyNguoiDungRepository.findAll();
    }

    @Override
    public List<QuanLyNguoiDung> getAllQuanLyNguoiDungs() {
        return (List<QuanLyNguoiDung>) quanLyNguoiDungRepository.findAll();
    }

    @Override
    public void save(QuanLyNguoiDung quanLyNguoiDung) {
        quanLyNguoiDungRepository.save(quanLyNguoiDung);
    }

    @Override
    public void deleteById(Integer idNguoiDung, Integer idQuyen) {
        QuanLyNguoiDungId id = new QuanLyNguoiDungId(idNguoiDung, idQuyen);
        quanLyNguoiDungRepository.deleteById(id);
    }

    @Override
    public QuanLyNguoiDung findById(Integer idNguoiDung, Integer idQuyen) {
        QuanLyNguoiDungId id = new QuanLyNguoiDungId(idNguoiDung, idQuyen);
        return quanLyNguoiDungRepository.findById(id).orElse(null);
    }

}
