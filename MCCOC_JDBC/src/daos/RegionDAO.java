/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import models.Region;
import tools.Koneksi;

/**
 *
 * @author Gin
 */
public class RegionDAO {
    private Connection connection = null;

    public RegionDAO( ) {
        this.connection = new Koneksi().getConnection();
    }
    /**
     * to do : Mengambil semua data pada tabel region
     * to set : null
     * @return : semua data pada tabel
     */
    public List<Region> getRegions(){
        List<Region> regions = new ArrayList<>();
        String query ="select * from region";
        try{
            PreparedStatement statement= connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                Region region = new Region();
                region.setId(resultSet.getInt(1));
                region.setName(resultSet.getString(2));
                regions.add(region);
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        return regions;
    }
    /**
     * method untuk memasukan query untuk menambahkan object region ke database
     * @return list country
     */
    public boolean insert(Region region){
        boolean result = false;
        String query = "insert into region (id, name) values (?,?) ";
        try{
            PreparedStatement statement= connection.prepareStatement(query);
            statement.setInt(1, region.getId());
            statement.setString(2, region.getName());
            statement.executeUpdate();
            result = true;
        }catch(Exception e){
            e.printStackTrace();
        } 
        return result;
    }
    /**
     * Fungsi delete satu data pada tabel region 
     * set yangdibutuhkan adalah string id 
     * @return berhasil / tidak penghapusan
     */
    public boolean delete(int id){
        boolean result = false;
        String query = "delete from region where id = ?" ;
        try {
            PreparedStatement statement= connection.prepareStatement(query);
            statement.setInt(1, id);
            statement.executeUpdate();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        } 
        return result;
    }
    /**
     * method untuk memasukan query untuk mengupdate obkect region ke database
     * @return list country
     */
    public boolean update(Region region){
        boolean result = false;
        String query = "update region set name = ? where id = ? ";
        try {
            PreparedStatement statement= connection.prepareStatement(query); 
            statement.setString(1, region.getName());
            statement.setInt(2, region.getId());
            statement.executeUpdate();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    /**
     * melakukan query untuk mendapatkan objecy region sesuai id
     * @return 
     */
    public Region getById(int id){
        Region region = null;
        String query ="select * from region where id =?";
        try {
            PreparedStatement statement= connection.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                region = new Region();
                region.setId(resultSet.getInt(1));
                region.setName(resultSet.getString(2)); 
            }
        } catch (Exception e) {
        }
        return region;
    }
    /**
     * melakukan query untuk mendapatkan seluruh object  region sesuai keyword search
     * @return 
     */
    public List<Region> search (String keyword){
        List<Region> regions = new ArrayList<>();
        String query ="select * from region where id like ? or name like ?";
        try {
            PreparedStatement statement= connection.prepareStatement(query);
            statement.setString(1, "%"+keyword+"%");
            statement.setString(2, "%"+keyword+"%");
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                Region region = new Region();
                region.setId(resultSet.getInt(1));
                region.setName(resultSet.getString(2));
                regions.add(region);
            }
        } catch (Exception e) {
        }
        return regions;
    }
    
}
