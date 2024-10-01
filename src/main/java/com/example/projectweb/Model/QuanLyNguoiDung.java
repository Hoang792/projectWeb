package com.example.projectweb.Model;

import com.example.projectweb.Model.QuanLyNguoiDungId;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;


import java.io.Serializable;

@Entity
@IdClass(QuanLyNguoiDungId.class) // Ánh xạ khóa chính phức hợp
public class QuanLyNguoiDung implements Serializable {

    @Id
    private Integer idNguoiDung;

    @Id
    private Integer idQuyen;

    public QuanLyNguoiDung() {
    }

    public QuanLyNguoiDung(Integer idNguoiDung, Integer idQuyen) {
        this.idNguoiDung = idNguoiDung;
        this.idQuyen = idQuyen;
    }

    public Integer getIdNguoiDung() {
        return idNguoiDung;
    }

    public void setIdNguoiDung(Integer idNguoiDung) {
        this.idNguoiDung = idNguoiDung;
    }

    public Integer getIdQuyen() {
        return idQuyen;
    }

    public void setIdQuyen(Integer idQuyen) {
        this.idQuyen = idQuyen;
    }
}
