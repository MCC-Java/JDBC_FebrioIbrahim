/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.CountryDAO;
import java.util.List;
import models.Country;

/**
 *
 * @author Gin
 */
public class CountryController {
    private CountryDAO cdao;

    public CountryController() {
        this.cdao = new CountryDAO();
    }
    /**
     * method memanggil semua object coutry ada database
     * @return list Semua country
     */
    public List<Country> binding(){
        return this.cdao.getCountrys();
    }
    
    /**
     * method untuk mengubah masukan dari view kemudain membuat object country dan di kirim ke DAI untuk di simpan di database 
     * @return notifikasi berhasil/gagal
     */
    public String save(String id, String name, String region){
        String result = "Insert Data Gagal";
        int newCounty = Integer.parseInt(region);
        Country country = new Country(id,name,newCounty);
        if(this.cdao.insert(country)) result = "Insert Data Berhasil";
        return result;
    }
    /**
     * method untuk memanggil method delete pada DAO
     * @return notifikasi berhasil/gagal
     */
    public String delete(String id){
        String result = "Gagal Dihapus";
        if(this.cdao.delete(id)) result = "Berhasil Dihapus";
        return result;
    }
    /**
     * method untuk membuat region baru yag akan diupdate pada database
     * @return notifikasi berhasil/gagal
     */
    public String update(String id, String name, String region){
        String result = "Update gagal";
        int newRegion = Integer.parseInt(region);
        Country country = new Country(id,name,newRegion);
        if(this.cdao.update(country)) result = "Update berhasil";
        return result;
    }
    /**
     * method untuk memanggil DAO search
     * @return list country
     */
    public List<Country> search(String keyword){
        return this.cdao.search(keyword);
    }
    /**
     * method untuk mengubah masukan dari view dan memanggil method getbyid pada DAO
     * @return object country
     */
    public Country getById(String id){
        int newId = Integer.parseInt(id);
        return this.cdao.getById(newId);
    }
}
