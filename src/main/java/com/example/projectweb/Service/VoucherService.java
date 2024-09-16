package com.example.projectweb.Service;

import com.example.projectweb.Model.Voucher;

import java.util.List;
import java.util.Optional;

public interface VoucherService {
    List<Voucher> getAllVouchers();

    Optional<Voucher> findVoucherById(Integer idVoucher);

    List<Voucher> searchVouchers(String query);
}
