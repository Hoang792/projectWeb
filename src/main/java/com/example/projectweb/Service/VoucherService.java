package com.example.projectweb.Service;

import com.example.projectweb.Model.size;
import com.example.projectweb.Model.voucher;

import java.util.List;
import java.util.Optional;

public interface VoucherService {
    List<voucher> getAllVouchers();

    void deleteVoucher(Integer idVoucher);

    void saveVoucher(voucher Voucher);

    Optional<voucher> findVoucherById(Integer idVoucher);

    List<voucher> searchVouchers(String query);
}
