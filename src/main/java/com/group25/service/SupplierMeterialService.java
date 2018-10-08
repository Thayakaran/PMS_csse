package com.group25.service;

import com.group25.dao.SupplierMeterialDao;
import com.group25.entity.SupplierMeterial;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Collection;
@Service
public class SupplierMeterialService {

    @Autowired
    private SupplierMeterialDao supplierMeterialDao;

    public Collection<SupplierMeterial> getAllSupplierMeterial(){
        return this.supplierMeterialDao.getAllSupplierMeterial();
    }

    ///add supplier meterial
    public void addSupplierMeterial(SupplierMeterial supplierMeterial) {
        this.supplierMeterialDao.addSupplierMeterial(supplierMeterial);
    }

    //get supplier Material by ID
    public SupplierMeterial getSupplierMaterialById(int id) {
        return this.supplierMeterialDao.getSupplierMaterialById(id);
    }

    //delete supplier meterial by ID
    public void deleteSupplierMaterialById(int id) {
        this.supplierMeterialDao.deleteSupplierMaterialById(  id);
    }

}
