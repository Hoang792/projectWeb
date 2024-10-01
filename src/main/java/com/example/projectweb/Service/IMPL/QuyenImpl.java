package com.example.projectweb.Service.impl;

import com.example.projectweb.Model.Quyen;
import com.example.projectweb.Repository.QuyenRepository;
import com.example.projectweb.Service.QuyenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuyenImpl implements QuyenService {

    @Autowired
    private QuyenRepository quyenRepository;

    @Override
    public List<Quyen> getAllQuyens() {
        return (List<Quyen>) quyenRepository.findAll();
    }

    @Override
    public List<Quyen> findAll() {
        return quyenRepository.findAll();
    }

    @Override
    public void save(Quyen quyen) {
        quyenRepository.save(quyen);
    }

    @Override
    public void deleteById(Integer idquyen) {
        quyenRepository.deleteById(idquyen);
    }

    @Override
    public Quyen findById(Integer idquyen) {
        return quyenRepository.findById(idquyen).orElse(null);
    }
}
