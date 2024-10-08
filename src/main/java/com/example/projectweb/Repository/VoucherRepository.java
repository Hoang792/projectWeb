package com.example.projectweb.Repository;

import com.example.projectweb.Model.Voucher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VoucherRepository extends JpaRepository<Voucher, Integer> {
    List<Voucher> findByTenvoucherContainingIgnoreCase(String query);
}
