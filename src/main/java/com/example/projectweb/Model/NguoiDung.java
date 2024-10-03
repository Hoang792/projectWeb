package com.example.projectweb.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "nguoidung")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class NguoiDung {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_nguoi_dung")
    private Integer idNguoiDung;
    @Column(name = "ten")
    private String tenNguoiDung;
    @Column(name = "dia_chi")
    private String diaChi;
    @Column(name = "sdt")
    private Integer Sdt;
    @Column(name = "email")
    private String email;
    @Column(name = "ngay_sinh")
    private Date ngaySinh;
    @Column(name = "mat_khau")
    private String matKhau;
}
