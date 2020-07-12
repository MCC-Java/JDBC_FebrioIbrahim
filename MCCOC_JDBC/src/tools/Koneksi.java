/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import com.mysql.cj.jdbc.MysqlDataSource;
import java.sql.Connection;

/**
 *
 * @author Gin
 */
public class Koneksi {
    private Connection connection = null;
    
    /**
    *melakukan koneksi ke database
    */
    public Connection getConnection(){
        try{
            MysqlDataSource dataSource = new MysqlDataSource();
            dataSource.setServerName("localhost");
            dataSource.setPort(3306);
            dataSource.setDatabaseName("mccoc");
            dataSource.setUser("root");
            dataSource.setPassword("b0o7c@mp");
            connection = dataSource.getConnection();
            return connection;
        }catch(Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return connection;
    }
}
