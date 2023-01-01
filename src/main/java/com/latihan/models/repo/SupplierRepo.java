package com.latihan.models.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.latihan.models.entities.Supplier;

public interface SupplierRepo extends CrudRepository<Supplier, Long> {

    List<Supplier> findByNameContains(String name);

    Supplier findByEmail(String email);

}
