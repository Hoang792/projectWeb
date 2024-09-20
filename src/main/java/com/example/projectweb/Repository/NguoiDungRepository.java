package com.example.projectweb.Repository;

import com.example.projectweb.Model.NguoiDung;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NguoiDungRepository extends JpaRepository<NguoiDung, Integer> {
    NguoiDung findByEmail(String email);
    List<NguoiDung> findAllByTenContaining(String ten);
}
