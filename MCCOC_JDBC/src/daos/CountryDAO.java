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
import models.Country;
import tools.Koneksi;

/**
 *
 * @author Gin
 */
public class CountryDAO {
    private Connection connection = null;

    public CountryDAO() {
        this.connection = new Koneksi().getConnection();
    }
    
    /**
     * method untuk melakukan query ke database untuk mendapatkan semua country
     * @return lisy country
     */
    public List<Country> getCountrys(){   
        List<Country> countrys = new ArrayList<>();
        String query ="select * from country";
        try{
            PreparedStatement statement= connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                Country country = new Country();
                country.setId(resultSet.getString(1));
                country.setName(resultSet.getString(2));
                country.setRegion(resultSet.getInt(3));
                countrys.add(country);
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        return countrys;
    }
    /**
     * method untuk memasukan query untuk menambahkan obkect country ke database
     * @return list country
     */
    public boolean insert(Country country){
        boolean result = false;
        String query = "insert into country (id, name, region) values (?,?,?) ";
        try{
            PreparedStatement statement= connection.prepareStatement(query);
            statement.setString(1, country.getId());
            statement.setString(2, country.getName());
            statement.setInt(3, country.getRegion());
            statement.executeUpdate();
            result = true;
        }catch(Exception e){
            e.printStackTrace();
        } 
        return result;
    }
    /**
     * method untuk memasukan query untuk menghapus obkect country ke database
     * @return list country
     */
    public boolean delete(String id){
        boolean result = false;
        String query = "delete from country where id = \"" + id + "\"";
        try {
            PreparedStatement statement= connection.prepareStatement(query); 
            statement.execute();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        } 
        return result;
    }
    /**
     * method untuk memasukan query untuk mengupdate obkect country ke database
     * @return list country
     */
    public boolean update(Country country){
        boolean result = false;
        String query = "update country set name = ?, region = ?  where id = ? ";
        try {
            PreparedStatement statement= connection.prepareStatement(query); 
            statement.setString(1, country.getName());
            statement.setInt(2, country.getRegion());
            statement.setString(3, country.getId());
            statement.executeUpdate();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    /**
     * melakukan query untuk mendapatkan objecy country sesuai id
     * @return 
     */
    public Country getById(int id){
        Country country = null;
        String query ="select * from country where id =?";
        try {
            PreparedStatement statement= connection.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                country = new Country();
                country.setId(resultSet.getString(1));
                country.setName(resultSet.getString(2));
                country.setRegion(resultSet.getInt(3));
            }
        } catch (Exception e) {
        }
        return country;
    }
    /**
     * melakukan query untuk mendapatkan seluruh object  country sesuai keyword search
     * @return 
     */
    public List<Country> search (String keyword){
        List<Country> countrys = new ArrayList<>();
        String query ="select * from country where id like ? or name like ? or region like ?";
        try {
            PreparedStatement statement= connection.prepareStatement(query);
            statement.setString(1, "%"+keyword+"%");
            statement.setString(2, "%"+keyword+"%");
            statement.setString(3, "%"+keyword+"%");
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                Country country = new Country();
                country.setId(resultSet.getString(1));
                country.setName(resultSet.getString(2));
                country.setRegion(resultSet.getInt(3));
                countrys.add(country);
            }
        } catch (Exception e) {
        }
        return countrys;
    }
    
}
