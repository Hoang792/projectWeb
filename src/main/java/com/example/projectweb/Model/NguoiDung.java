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
    @Column(name = "idNguoiDung")
    private Integer idNguoiDung;
    @Column(name = "ten")
    private String tenNguoiDung;
    @Column(name = "diaChi")
    private String diaChi;
    @Column(name = "sdt")
    private Integer Sdt;
    @Column(name = "email")
    private String email;
    @Column(name = "ngaySinh")
    private Date ngaySinh;
    @Column(name = "matKhau")
    private String matKhau;
}
