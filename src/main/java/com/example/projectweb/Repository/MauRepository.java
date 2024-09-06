package com.example.projectweb.Repository;

import com.example.projectweb.Model.mau;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MauRepository extends CrudRepository<mau, Long> {
    List<mau> findByTenmauContainingIgnoreCase(String tenmau);

}
