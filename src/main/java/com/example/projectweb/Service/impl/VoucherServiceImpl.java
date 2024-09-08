package com.example.projectweb.Service.impl;

import com.example.projectweb.Model.Voucher;
import com.example.projectweb.Repository.VoucherRepository;
import com.example.projectweb.Service.VoucherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VoucherServiceImpl implements VoucherService {

    @Autowired
    private VoucherRepository voucherRepository;

    @Override
    public List<Voucher> getAllVouchers() {
        return voucherRepository.findAll();
    }

    @Override
    public Optional<Voucher> findVoucherById(Integer idVoucher) {
        return voucherRepository.findById(idVoucher);
    }

    @Override
    public List<Voucher> searchVouchers(String query) {
        return voucherRepository.findByTenvoucherContainingIgnoreCase(query);
    }
}
