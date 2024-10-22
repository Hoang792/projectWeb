package com.example.projectweb.Repository;

import com.example.projectweb.Model.voucher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VoucherRepository extends JpaRepository<voucher, Integer> {
    List<voucher> findByTenvoucherContainingIgnoreCase(String query);
}
