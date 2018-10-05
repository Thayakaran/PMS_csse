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


    public void addSupplierMeterial(SupplierMeterial supplierMeterial) {
        this.supplierMeterialDao.addSupplierMeterial(supplierMeterial);
    }

    public SupplierMeterial getSupplierMaterialById(int id) {
        return this.supplierMeterialDao.getSupplierMaterialById(id);
    }

    public void deleteSupplierMaterialById(int id) {
        this.supplierMeterialDao.deleteSupplierMaterialById(  id);
    }

}
