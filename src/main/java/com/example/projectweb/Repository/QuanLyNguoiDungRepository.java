package com.example.projectweb.Repository;

import com.example.projectweb.Model.QuanLyNguoiDung;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuanLyNguoiDungRepository extends JpaRepository<QuanLyNguoiDung, Integer> {
    void deleteByIdNguoiDungAndIdQuyen(Integer idNguoiDung, Integer idQuyen);
    List<QuanLyNguoiDung> findByIdNguoiDungId(Integer idNguoiDung);
    List<QuanLyNguoiDung> findByIdQuyenId(Integer idQuyen);
}
