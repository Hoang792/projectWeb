package com.example.projectweb.Repository;

import com.example.projectweb.Model.sanphamchitiet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SanPhamChiTietRepository extends JpaRepository<sanphamchitiet,Integer> {
    List<sanphamchitiet> findAllByTenspContaining (String tensp);
    @Query("SELECT M FROM sanphamchitiet  M WHERE M.tensp LIKE %?1%")
    List<sanphamchitiet> search(@Param("timkiem") String timkiem);

}
