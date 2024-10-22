package com.example.projectweb.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "sanphamchitiet")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class sanphamchitiet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idspct")
    public Integer idSPCT;

    @ManyToOne
    @JoinColumn(name = "idThuongHieu")
    private thuonghieu idThuongHieu;

    @ManyToOne
    @JoinColumn(name = "idSize")
    private size idSize;

    @ManyToOne
    @JoinColumn(name = "idmau")
    private mau idMau;

    @Column(name = "soluong")
    private String soLuong;

    @Column(name = "gia")
    private int gia;

    @Column(name = "mota",columnDefinition = "nvarchar(255)")
    private String mota;

    @Column(name = "hinhanh",columnDefinition = "nvarchar(255)")
    private String hinhAnh;

    @Column(name = "ngaythem")
    private Date ngayThem;

    @Column(name = "tensp",columnDefinition = "nvarchar(255)")
    private String tensp;

    public void setImage(String fileName) {
        this.hinhAnh = fileName;
    }
}
