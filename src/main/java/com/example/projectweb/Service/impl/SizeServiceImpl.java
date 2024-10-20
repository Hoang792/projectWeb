package com.example.projectweb.Service.impl;

import com.example.projectweb.Model.mau;
import com.example.projectweb.Model.size;
import com.example.projectweb.Repository.SizeRepository;
import com.example.projectweb.Service.SizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SizeServiceImpl implements SizeService {

    @Autowired
    private SizeRepository sizeRepository;

    @Override
    public void saveSize(size Size){sizeRepository.save(Size);
    }

    @Override
    public List<size> getAllSizes() {
        return (List<size>) sizeRepository.findAll();
    }

    @Override
    public Optional<size> findSizeByIdsize(Integer idsize) {
        return sizeRepository.findById(idsize);
    }

    @Override
    public List<size> searchSizes(String query) {
        return sizeRepository.findByKichthuocContainingIgnoreCase(query);
    }
}
