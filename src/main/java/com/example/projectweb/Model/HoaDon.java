package com.example.projectweb.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "hoadon")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class HoaDon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idHD")
    private Integer idhd;

    @ManyToOne
    @JoinColumn(name = "id_nguoi_dung")
    private NguoiDung idnguoidung;

    @Column(name = "ngaylap")
    private Date ngaylap;

    @Column (name = "tong_tien")
    private BigDecimal tongtien;

    @Column (name = "trangthai")
   private String trangthai;

    @ManyToOne
    @JoinColumn(name = "id_khuyen_mai")
    private KhuyenMai khuyenmai;

    @ManyToOne
    @JoinColumn(name = "id_voucher")
    private Voucher voucher;
}
