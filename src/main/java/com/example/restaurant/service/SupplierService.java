package com.example.restaurant.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.restaurant.data.model.Supplier;
import com.example.restaurant.repository.SupplierRepository;

@Service
public class SupplierService {
    private final SupplierRepository supplierRepository;

    public SupplierService(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    public List<Supplier> getAllSuppliers() {
        return supplierRepository.findAll();
    }

    public Supplier getSupplier(int id) {
        return supplierRepository.findById(id);
    }

    public boolean insertSupplier(Supplier supplier) {
        int insertStatus = supplierRepository.save(supplier);

        if (insertStatus == 0) {
            return false;
        } else {
            return true;
        }
    }

    public boolean updateSupplier(int id, Supplier supplier) {
        int updateStatus = supplierRepository.update(supplier, id);

        if (updateStatus == 0) {
            return false;
        } else {
            return true;
        }
    }

    public boolean deleteSupplier(int id) {
        int deleteStatus = supplierRepository.deleteById(id);
        if (deleteStatus == 0) {
            return false;
        } else {
           return true;
        }
    }
}
