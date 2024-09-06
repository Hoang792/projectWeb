package com.example.projectweb.Service;

import com.example.projectweb.Model.mau;

import java.util.List;
import java.util.Optional;

public interface MauService {
    List<mau> getAllMaus();

    Optional<mau> findMauByIdmau(Long idmau);
    List<mau> searchMaus(String query);
}
