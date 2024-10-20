package com.example.projectweb.Repository;

import com.example.projectweb.Model.nguoidung;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NguoiDungRepository extends JpaRepository<nguoidung, Integer> {
    nguoidung findByEmail(String email);
    List<nguoidung> findAllBytenNguoiDungContaining(String tenNguoiDung);
}
