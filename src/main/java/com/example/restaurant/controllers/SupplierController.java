package com.example.restaurant.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.restaurant.data.model.Supplier;
import com.example.restaurant.service.SupplierService;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;

@RestController
@PreAuthorize("hasRole('ROLE_STAFF') or hasRole('ROLE_ADMIN')")
@RequestMapping(path = { "/api/supplier" }, produces = APPLICATION_JSON_VALUE)
public class SupplierController {
    private final SupplierService supplierService;

    public SupplierController(SupplierService supplierService) {
        this.supplierService = supplierService;
    }

    @GetMapping("")
    public ResponseEntity<List<Supplier>> getAllSuppliers() {
        final List<Supplier> supplierList = supplierService.getAllSuppliers();
        return ResponseEntity.ok(supplierList);
    }

    @GetMapping("/{supplierId}")
    public ResponseEntity<Supplier> getSupplier(@PathVariable(value = "supplierId") int id) {
        final Supplier supplier = supplierService.getSupplier(id);
        return ResponseEntity.ok(supplier);
    }

    @PostMapping(path = "/", consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<Supplier> createSupplier(@RequestBody Supplier supplier) {
        final boolean created = supplierService.insertSupplier(supplier);
        if (!created) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(supplier, HttpStatus.CREATED);
    }

    @PutMapping(path = "/{id}", consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<Supplier> editSupplier(@PathVariable(value = "id") int id, @RequestBody Supplier supplier) {
        final boolean updated = supplierService.updateSupplier(id, supplier);
        if (!updated) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(supplier, HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Boolean> deleteSupplier(@PathVariable(value = "id") int id) {
        final boolean deleted = supplierService.deleteSupplier(id);

        return ResponseEntity.ok(deleted);
    }
}
