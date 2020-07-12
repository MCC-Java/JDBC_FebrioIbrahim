/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import controllers.CountryController;
import controllers.RegionController;
import java.util.List;
import models.Country;
import models.Region;
import java.util.Scanner;

/**
 *
 * @author Gin
 */
public class ManualTest {
    public static void main(String[] args){
        /*
        //System.out.println(new Koneksi().getConnection());
        RegionController rController = new RegionController(); 
        List<Region> daftarRegion = rController.binding(); 
        CountryController cController = new CountryController();
        List<Country> daftarCountry = cController.binding(); 
        //System.out.println(rController.save("", "Africa"));
        for(Region region : rController.binding()){
            System.out.println("Region Id :" + region.getId() + "| Region Name : " + region.getName());
        }
        //System.out.println(rController.delete("6"));
        System.out.println(rController.update("1", "Asian")); 
        //System.out.println( );System.out.println("=========================");
        //System.out.println(cController.save("MX", "Mexico", "4"));
        for(Country country : cController.binding()){
           System.out.println("Country Id :" + country.getId() + "| Country Name : " + country.getName()+ "| Country Region : " + country.getRegion());
        //}
        */
        //menu();
        /* RegionController rController = new RegionController(); 
        List<Region> daftarRegion = rController.binding();
        
        for(Region region : rController.search("as")){
            System.out.println("Region Id :" + region.getId() + "| Region Name : " + region.getName());
        }
        
        Region region = rController.getById("1");
        System.out.println(region.getId());
        System.out.println(region.getName()); */
    }
    
    static void showMenuRegion() {
        boolean result = false;
        while(result == false){
            Scanner input = new Scanner(System.in);
            Scanner input2 = new Scanner(System.in);
            Scanner input3 = new Scanner(System.in);
            RegionController rController = new RegionController(); 
            List<Region> daftarRegion = rController.binding();
            System.out.println("\n========= MENU REGION =========");
            System.out.println("1. Insert Data");
            System.out.println("2. Show Data");
            System.out.println("3. Edit Data");
            System.out.println("4. Delete Data");
            System.out.println("0. Back");
            System.out.println("");
            System.out.print("PILIHAN> ");

            try {
                int pilihan = input.nextInt();
                String name,id;    
                if (pilihan == 0) {
                    menu();
                } else if(pilihan == 1) {
                    System.out.print ("Masukan Nama Region : ");
                    name = input2.nextLine();
                    System.out.println(rController.save("", name)); 
                }else if (pilihan == 2){
                    for(Region region : rController.binding()){
                            System.out.println("Region Id :" + region.getId() + "| Region Name : " + region.getName());
                    }
                }else if (pilihan == 3){
                    System.out.print ("Masukan Id Region : ");
                    String idUpdate = input2.nextLine();
                    System.out.print("Masukan Nama Region yang Baru : ");
                    String nameUpdate = input3.nextLine();  
                    System.out.println(rController.update(idUpdate, nameUpdate));
                }else if (pilihan == 4){
                    System.out.print ("Masukan id yang akan di hapus : ");
                    id = input2.nextLine();
                    System.out.println(rController.delete(id));
                }else{
                    System.out.println("Pilihan Salah");
                } 
            } catch (Exception e) {
                e.printStackTrace();
            }
        } 
    }
    
    static void showMenuCountry() {
        boolean result = false;
        while(result == false){
            Scanner input = new Scanner(System.in);
            Scanner input1 = new Scanner(System.in);
            Scanner input2 = new Scanner(System.in);
            Scanner input3 = new Scanner(System.in);
            
            
            CountryController cController = new CountryController();
            List<Country> daftarCountry = cController.binding(); 
            
            
            System.out.println("\n========= MENU COUNTRY =========");
            System.out.println("1. Insert Data");
            System.out.println("2. Show Data");
            System.out.println("3. Edit Data");
            System.out.println("4. Delete Data");
            System.out.println("0. Back");
            System.out.println("");
            System.out.print("PILIHAN> ");

            try {
                int pilihan = input.nextInt();
                String name,id,region;    
                if (pilihan == 0) {
                    menu();
                } else if(pilihan == 1) {
                    System.out.print("Masukan Id Country : ");
                    id = input1.nextLine();
                    System.out.print("Masukan Nama Country : ");
                    name = input2.nextLine();
                    System.out.print("Masukan Region Country : ");
                    region = input3.nextLine();
                    System.out.println(cController.save(id,name,region)); 
                }else if (pilihan == 2){
                    for(Country country : cController.binding()){
                        System.out.println("Country Id :" + country.getId() + "| Country Name : " + country.getName()+ "| Country Region : " + country.getRegion());
                    }    
                }else if (pilihan == 3){
                    System.out.print ("Masukan Id Country : ");
                    id = input2.nextLine();
                    System.out.print("Masukan Nama Country yang Baru : ");
                    name = input3.nextLine();
                    System.out.print("Masukan Country Country : ");
                    region = input1.nextLine();
                    System.out.println(cController.update(id, name,region));
                }else if (pilihan == 4){
                    System.out.print ("Masukan id yang akan di hapus : ");
                    id = input2.nextLine();
                    System.out.println(cController.delete(id));
                }else{
                    System.out.println("Pilihan Salah");
                } 
            } catch (Exception e) {
                e.printStackTrace();
            } 
        } 
    }
    
    static void menu(){
        Scanner input = new Scanner(System.in);
        
        System.out.println("\n========= MENU UTAMA =========");
        System.out.println("1. Region Menu");
        System.out.println("2. Country Menu");
        System.out.println("0. Keluar");
        System.out.println("");
        System.out.print("PILIHAN> ");
        int pilihan = input.nextInt();
        switch (pilihan) {
            case 0:
                System.exit(0);
                break;
            case 1:
                showMenuRegion();
                break;
            case 2:
                showMenuCountry();
                break;
            default:
                System.out.println("Pilihan salah!");    
        }
        
    }
}
