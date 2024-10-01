package com.example.projectweb.Model;

import java.io.Serializable;
import java.util.Objects;

public class QuanLyNguoiDungId implements Serializable {
    private Integer idNguoiDung;
    private Integer idQuyen;

    public QuanLyNguoiDungId() {}

    public QuanLyNguoiDungId(Integer idNguoiDung, Integer idQuyen) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QuanLyNguoiDungId that = (QuanLyNguoiDungId) o;
        return Objects.equals(idNguoiDung, that.idNguoiDung) && Objects.equals(idQuyen, that.idQuyen);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idNguoiDung, idQuyen);
    }
}
