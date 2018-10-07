package com.group25.dao;

import com.group25.entity.Site;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

@Repository
public class SiteDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    //class for row mapping the Site table
    private static class SiteRowMapper implements RowMapper<Site> {
        @Override
        public Site mapRow(ResultSet resultSet, int i) throws SQLException {
            Site site = new Site();
            site.setSiteID(resultSet.getString("SiteID"));
            site.setLocation(resultSet.getString("Location"));
            site.setClient(resultSet.getString("Client"));
            site.setManager(resultSet.getInt("Manager"));
            site.setContractors(resultSet.getString("Contractors"));
            site.setSuppliers(resultSet.getString("Suppliers"));
            return site;
        }
    }

    //get all sites
    public Collection<Site> getAllSites(){
        final String sql = "SELECT * FROM sites";
        List<Site> sites = jdbcTemplate.query(sql, new SiteDao.SiteRowMapper());
        return sites;
    }

    //get a specific site by siteID
    public Site getSiteById(String siteID){
        final String sql = "SELECT * FROM sites WHERE siteID = ?";
        Site site = jdbcTemplate.queryForObject(sql, new SiteDao.SiteRowMapper(), siteID);
        return site;
    }

    //delete a specific site
    public String deleteSiteById(String siteID) {
        final String sql = "DELETE FROM sites WHERE siteID = ?";
        try{
            jdbcTemplate.update(sql, siteID);
            return "{\"success\" : true}";
        }
        catch (Exception ex){
            return "{\"success\" : false}";
        }
    }

    //updating existing site
    public String updateSite(Site site){
        final String sql = "UPDATE sites SET location = ?, client = ?, manager = ?, contractors = ?, suppliers = ? WHERE siteID = ?";
        String siteID = site.getSiteID();
        String location = site.getLocation();
        String client = site.getClient();
        int manager = site.getManager();
        String contractors = site.getContractors();
        String suppliers = site.getSuppliers();
        try{
            jdbcTemplate.update(sql, new Object[] {location, client, manager, contractors, suppliers, siteID});
            return "{\"success\" : true}";
        }
        catch (Exception ex){
            return "{\"success\" : false}";
        }
    }

    //adding new Site
    public String addSite(Site site) {
        final String sql = "INSERT INTO sites (siteID, location, client, manager, contractors, suppliers) VALUES (?, ?, ?, ?, ?, ?)";
        String siteID = site.getSiteID();
        String location = site.getLocation();
        String client = site.getClient();
        int manager = site.getManager();
        String contractors = site.getContractors();
        String suppliers = site.getSuppliers();
        try{
            jdbcTemplate.update(sql, new Object[] {siteID, location, client, manager, contractors, suppliers});
            return "{\"success\" : true}";
        }
        catch (Exception ex){
            return "{\"success\" : false}";
        }
    }
}
