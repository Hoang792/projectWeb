package com.example.projectweb.Service;

import com.example.projectweb.Model.size;

import java.util.List;
import java.util.Optional;

public interface SizeService {
    List<size> getAllSizes();
    void saveSize(size size);
    void deleteSize(Long id);
    Optional<size> findSizeByIdsize(Integer idsize);

    List<size> searchSizes(String query);
}
