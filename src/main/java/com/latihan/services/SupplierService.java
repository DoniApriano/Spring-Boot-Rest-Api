package com.latihan.services;

import java.util.Optional;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.latihan.models.entities.Supplier;
import com.latihan.models.repo.SupplierRepo;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class SupplierService {

    @Autowired
    private SupplierRepo supplierRepo;


    public Supplier save(Supplier supplier) {
        return supplierRepo.save(supplier);
    }

    public Supplier findOne(Long id) {
        Optional<Supplier> supplier = supplierRepo.findById(id);

        if (!supplier.isPresent()) {
            return null;
        }
        return supplier.get();
    }

    public Iterable<Supplier> findAll() {
        return supplierRepo.findAll();
    }

    public void removeOne(Long id) {
        supplierRepo.deleteById(id);
    }

    public List<Supplier> findByName(String name){
        return supplierRepo.findByNameContains(name);
    }

    public Supplier findByEmail(String name) {
        return supplierRepo.findByEmail(name);
    }
}
