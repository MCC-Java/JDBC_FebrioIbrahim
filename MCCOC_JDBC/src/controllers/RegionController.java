/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.RegionDAO;
import java.util.List;
import models.Region;

/**
 *
 * @author Gin
 */
public class RegionController {
    private RegionDAO rdao;

    public RegionController() {
        this.rdao = new RegionDAO();
    }
    
    /**
     * method memanggil semua object region ada database
     * @return list Semua region
     */
    public List<Region> binding(){
        return this.rdao.getRegions();
    }
    
    /**
     * method untuk mengubah masukan dari view kemudain membuat object region dan di kirim ke DAO untuk di simpan di database 
     * @return notifikasi berhasil/gagal
     */
    public String save(String id, String name){
      String result ="Simpan data gagal";   
      Region region = new Region(name);
      if(this.rdao.insert(region)) result = "simpan berhasil";
      return result;
    }
    
    /**
     * method untuk memanggil method delete pada DAO
     * @return notifikasi berhasil/gagal
     */
    public String delete(String id){
        int newId = Integer.parseInt(id);
        String result = "Gagal Dihapus";
        if(this.rdao.delete(newId)) result = "Berhasil Dihapus";
        return result;
    }
    /**
     * method untuk membuat region baru yag akan diupdate pada database
     * @return notifikasi berhasil/gagal
     */
    public String update(String id, String name){
        String result = "Update gagal";
        int newId = Integer.parseInt(id);
        Region region = new Region(newId,name);
        if(this.rdao.update(region)) result = "Update berhasil";
        return result;
    }
    /**
     * method untuk memanggil DAO search
     * @return list country
     */
    public List<Region> search(String keyword){
        return this.rdao.search(keyword);
    }
    /**
     * method untuk mengubah masukan dari view dan memanggil method getbyid pada DAO
     * @return object region
     */
    public Region getById(String id){
        int newId = Integer.parseInt(id);
        return this.rdao.getById(newId);
    }
}
