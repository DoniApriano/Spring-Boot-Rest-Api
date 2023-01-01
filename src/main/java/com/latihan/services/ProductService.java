package com.latihan.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.latihan.models.entities.Product;
import com.latihan.models.entities.Supplier;
import com.latihan.models.repo.ProductRepo;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ProductService {

    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private SupplierService supplierService;

    public Product save(Product product) {
        return productRepo.save(product);
    }

    public Product findOne(Long id) {
        Optional<Product> optional = productRepo.findById(id);
        if (!optional.isPresent()) {
            return null;
        }
        return optional.get();
    }

    public Iterable<Product> findAll() {
        return productRepo.findAll();
    }

    public void removeOne(Long id) {
        productRepo.deleteById(id);
    }

    public List<Product> findByName(String name) {
        return productRepo.findByNameContains(name);
    }

    public void addSupplier(Supplier supplier, Long productId) {
        Product product = findOne(productId);
        if (product == null) {
            throw new RuntimeException("Produk dengan id " + productId + "tidak ada");
        }
        product.getSuppliers().add(supplier);
        save(product);
    }

    public Product findByProductName(String name) {
        return productRepo.findProductByName(name);
    }

    public List<Product> findByProductNameLike(String name) {
        return productRepo.findProductByNameLike("%" + name + "%");
    }

    public List<Product> findProductByCategory(Long categoryId) {
        return productRepo.findProductByCategory(categoryId);
    }

    public List<Product> findProductBySupplier(Long supplierId){
        Supplier supplier = supplierService.findOne(supplierId);
        if (supplier == null) {
            return new ArrayList<Product>();
        }
        return productRepo.findProductBySupplier(supplier);
    }

}
