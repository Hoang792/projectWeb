package com.example.projectweb.Repository;

import com.example.projectweb.Model.size;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SizeRepository extends CrudRepository<size, Integer> {
    List<size> findByKichthuocContainingIgnoreCase(String query);
}
