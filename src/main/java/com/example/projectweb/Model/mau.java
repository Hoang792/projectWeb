package com.example.projectweb.Model;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "mau")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class mau {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idmau")
    private Integer idmau;

    @Column(name = "tenmau",columnDefinition = "nvarchar(255)")
    private String tenmau;
}
