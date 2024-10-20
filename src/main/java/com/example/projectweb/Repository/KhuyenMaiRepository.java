package com.example.projectweb.Repository;

import com.example.projectweb.Model.KhuyenMai;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface KhuyenMaiRepository extends JpaRepository<KhuyenMai, Integer> {
    List<KhuyenMai> findAllByTenKMContaining(String tenKM);
}
