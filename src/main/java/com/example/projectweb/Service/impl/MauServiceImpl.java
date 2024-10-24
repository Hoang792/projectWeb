package com.example.projectweb.Service.IMPL;

import com.example.projectweb.Model.mau;
import com.example.projectweb.Repository.MauRepository;
import com.example.projectweb.Service.MauService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MauServiceImpl implements MauService {

    @Autowired
    private MauRepository mauRepository;

    @Override
    public List<mau> getAllMaus() {
        return (List<mau>) mauRepository.findAll();
    }

    @Override
    public void saveMau(mau maus){mauRepository.save(maus);
    }
    @Override
    public void deleteMau(Long id) {
        mauRepository.deleteById(id);
    }
    @Override
    public Optional<mau> findMauByIdmau(Integer idmau) {
        return mauRepository.findById(Long.valueOf(idmau));
    }

    @Override
    public List<mau> searchMaus(String query) {
        return mauRepository.findByTenmauContainingIgnoreCase(query);
    }
}
