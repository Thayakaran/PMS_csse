package com.group25.dao;

import com.group25.entity.SupplierMeterial;

import com.group25.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

@Repository
public class SupplierMeterialDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    //get all supplier material
    public Collection<SupplierMeterial> getAllSupplierMeterial() {
        final String sql = "SELECT * FROM supplierMaterials";
        List<SupplierMeterial> supplierMeterials = jdbcTemplate.query(sql, new SupplierMeterialDao.SupplierMeterialRowMapper());
        return supplierMeterials;
    }

    //class for row mapping the user table
    private static class SupplierMeterialRowMapper implements RowMapper<SupplierMeterial> {
        @Override
        public SupplierMeterial mapRow(ResultSet resultSet, int i) throws SQLException {
            SupplierMeterial supplierMeterial = new SupplierMeterial();

            supplierMeterial.setId(resultSet.getInt("id"));
            supplierMeterial.setSupplierMaterialType(resultSet.getString("supplierMaterialType"));
            supplierMeterial.setMeasurement(resultSet.getString("measurement"));
            supplierMeterial.setUnitPrice(resultSet.getString("unitPrice"));

            return supplierMeterial;
        }
    }




    //adding new supplier material
    public void addSupplierMeterial(SupplierMeterial supplierMeterial) {
        final String sql = "INSERT INTO supplierMaterials ( supplierMaterialType, measurement, unitPrice ,supplierID) VALUES (?, ?, ?,?)";
        int id = supplierMeterial.getId();
        String supplierMaterialType = supplierMeterial.getSupplierMaterialType();
        String measurement = supplierMeterial.getMeasurement();
        String unitPrice = supplierMeterial.getUnitPrice();
        int supplierID = supplierMeterial.getSupplierID();

        jdbcTemplate.update(sql, new Object[] {supplierMaterialType, measurement, unitPrice,supplierID});
    }

    //get a specific supplier Material
    public SupplierMeterial getSupplierMaterialById(int id){
        final String sql = "SELECT * FROM supplierMaterials WHERE id = ?";
        SupplierMeterial supplierMeterial = jdbcTemplate.queryForObject(sql, new SupplierMeterialDao.SupplierMeterialRowMapper(), id);
        return supplierMeterial;
    }

    //delete a specific supplier material
    public void deleteSupplierMaterialById(int id) {
        final String sql = "DELETE FROM supplierMaterials WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }


}


