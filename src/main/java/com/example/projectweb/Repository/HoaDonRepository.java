package com.example.projectweb.Repository;

import com.example.projectweb.Model.HoaDon;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HoaDonRepository extends JpaRepository<HoaDon, Integer> {
    List<HoaDon> findAllByTrangThaiContaining(String trangThai);
}
