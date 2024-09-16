package com.example.projectweb.Repository;

import com.example.projectweb.Model.sanphamchitiet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SanPhamChiTietRepository extends JpaRepository<sanphamchitiet,Integer> {
    List<sanphamchitiet> findAllByTenspContaining (String tensp);

}
