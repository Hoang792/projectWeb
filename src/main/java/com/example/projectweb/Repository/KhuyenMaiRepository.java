package com.example.projectweb.Repository;

import com.example.projectweb.Model.khuyenMai;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface KhuyenMaiRepository extends JpaRepository<khuyenMai, Integer> {
    List<khuyenMai> findAllByTenKMContaining(String tenKM);
}
