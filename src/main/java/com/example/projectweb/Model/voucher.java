package com.example.projectweb.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "voucher")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class voucher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idVoucher")
    private Integer idVoucher;
    @Column(name = "tenVoucher")
    private String tenvoucher;
    @Column(name = "ngayBatDau")
    private Date ngayBatDau;
    @Column(name = "ngayKetThuc")
    private Date ngayKetThuc;
    @Column(name = "trangThai")
    private Integer trangThai;
}
