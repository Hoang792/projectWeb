package com.example.projectweb.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "quyen")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Quyen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idquyen")
    private Integer idquyen;
    @Column(name = "tenQuyen")
    private String tenquyen;

}
