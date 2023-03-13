package com.example.restaurant.data.model;

import java.time.LocalDateTime;

public class Supplier {
    private int supplierId;
    private int supplierName;
    private boolean isActive;
    private int phoneNo; // create phone number table and class incase multiple numbers and then reference this class
    private String address1; // create address table
    private String address2;
    private String parish; // add parish to address table
    private LocalDateTime dateCreated;
    private LocalDateTime dateUpdated;


    public Supplier() {
    }

    public Supplier(int supplierId, int supplierName, boolean isActive, int phoneNo, String address1, String address2, String parish, LocalDateTime dateCreated, LocalDateTime dateUpdated) {
        this.supplierId = supplierId;
        this.supplierName = supplierName;
        this.isActive = isActive;
        this.phoneNo = phoneNo;
        this.address1 = address1;
        this.address2 = address2;
        this.parish = parish;
        this.dateCreated = dateCreated;
        this.dateUpdated = dateUpdated;
    }

    public int getSupplierId() {
        return this.supplierId;
    }

    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }

    public int getSupplierName() {
        return this.supplierName;
    }

    public void setSupplierName(int supplierName) {
        this.supplierName = supplierName;
    }

    public boolean isIsActive() {
        return this.isActive;
    }

    public boolean getIsActive() {
        return this.isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public int getPhoneNo() {
        return this.phoneNo;
    }

    public void setPhoneNo(int phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getAddress1() {
        return this.address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return this.address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getParish() {
        return this.parish;
    }

    public void setParish(String parish) {
        this.parish = parish;
    }

    public LocalDateTime getDateCreated() {
        return this.dateCreated;
    }

    public void setDateCreated(LocalDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }

    public LocalDateTime getDateUpdated() {
        return this.dateUpdated;
    }

    public void setDateUpdated(LocalDateTime dateUpdated) {
        this.dateUpdated = dateUpdated;
    }
    
}
