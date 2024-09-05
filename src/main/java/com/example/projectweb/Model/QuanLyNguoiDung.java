package com.example.projectweb.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "quanlynguoidung")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class QuanLyNguoiDung {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ManyToOne
    @JoinColumn(name = "idNguoiDung")
    private NguoiDung idNguoiDung;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ManyToOne
    @JoinColumn(name = "idQuyen")
    private Quyen idQuyen;
}
