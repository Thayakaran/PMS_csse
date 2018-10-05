package com.group25.controller;

import com.group25.entity.SupplierMeterial;

import com.group25.entity.User;
import com.group25.service.SupplierMeterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/supplierMeterial")
public class SupplierMeterialController {
    @Autowired
    private SupplierMeterialService supplierMeterialService;

    @RequestMapping(method = RequestMethod.GET)
    public Collection<SupplierMeterial> getAllSupplierMeterial(){
        return supplierMeterialService.getAllSupplierMeterial();
    }



    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addSupplierMeterial(@RequestBody SupplierMeterial supplierMeterial){
        System.out.println();
        supplierMeterialService.addSupplierMeterial(supplierMeterial);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public  SupplierMeterial  getSupplierMaterialById(@PathVariable("id") int id){
    return supplierMeterialService.getSupplierMaterialById(id) ;
    }



    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteSupplierMaterialById(@PathVariable("id") int id){
         supplierMeterialService.deleteSupplierMaterialById(id);    }
}
