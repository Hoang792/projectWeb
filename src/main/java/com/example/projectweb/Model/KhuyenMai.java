package com.example.projectweb.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "khuyenMai")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class KhuyenMai {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idKM")
    private Integer idKM;
    @Column(name = "tenKhuyenMai")
    private String tenKM;
    @Column(name = "giaTriKhuyenMai")
    private Integer giaTriKhuyenMai;
    @Column(name = "ngayBatDau")
    private Date ngayBatDau;
    @Column(name = "ngayKetThuc")
    private Date ngayKetThuc;
    @Column(name = "trangThai")
    private Integer trangThai;


}
