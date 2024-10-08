package com.example.projectweb.Repository;

import com.example.projectweb.Model.thuonghieu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface thuonghieuRepository extends JpaRepository<thuonghieu, Integer> {
    List<thuonghieu> findByTenthuonghieuContainingIgnoreCase(String query);
}
