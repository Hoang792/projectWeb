package com.example.projectweb.Service.impl;

import com.example.projectweb.Model.QuanLyNguoiDung;
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
    public List<QuanLyNguoiDung> getAllQuanLyNguoiDung() {
        return (List<QuanLyNguoiDung>) quanLyNguoiDungRepository.findAll();
    }

    @Override
    public void saveQuanLyNguoiDung(QuanLyNguoiDung quanLyNguoiDung) {
        quanLyNguoiDungRepository.save(quanLyNguoiDung);
    }

    @Override
    public void deleteQuanLyNguoiDung(Integer idNguoiDung, Integer idQuyen) {
        quanLyNguoiDungRepository.deleteByIdNguoiDungAndIdQuyen(idNguoiDung, idQuyen);
    }

    @Override
    public List<QuanLyNguoiDung> findByNguoiDungId(Integer idNguoiDung) {
        return quanLyNguoiDungRepository.findByIdNguoiDungId(idNguoiDung);
    }

    @Override
    public List<QuanLyNguoiDung> findByQuyenId(Integer idQuyen) {
        return quanLyNguoiDungRepository.findByIdQuyenId(idQuyen);
    }
}
