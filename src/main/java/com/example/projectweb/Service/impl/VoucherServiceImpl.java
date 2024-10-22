package com.example.projectweb.Service.IMPL;


import com.example.projectweb.Model.voucher;
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
    public List<voucher> getAllVouchers() {
        return voucherRepository.findAll();
    }

    @Override
    public void saveVoucher(voucher Voucher){voucherRepository.save(Voucher);
    }

    @Override
    public void deleteVoucher(Integer idVoucher) {
        voucherRepository.deleteById(idVoucher);
    }

    @Override
    public Optional<voucher> findVoucherById(Integer idVoucher) {
        return voucherRepository.findById(idVoucher);
    }

    @Override
    public List<voucher> searchVouchers(String query) {
        return voucherRepository.findByTenvoucherContainingIgnoreCase(query);
    }
}
