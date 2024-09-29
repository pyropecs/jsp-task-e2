package com.sales;

import java.sql.DriverManager;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectToDb {

        public Connection connect() throws SQLException,Exception{
                
                
            
                try{
                        Properties props = new Properties();
                        InputStream fis = getClass().getClassLoader().getResourceAsStream("db.properties");
                        props.load(fis);
                        String url = props.getProperty("db.url");
                        String userName = props.getProperty("db.username");
                        String password = props.getProperty("db.password");
                         Class.forName(props.getProperty("db.driver"));
                DriverManager.registerDriver(new org.mariadb.jdbc.Driver());
                Connection con = DriverManager.getConnection(url, userName, password);
                return con;
                }catch(SQLException e){
                        System.out.println(e.getMessage());
                throw new SQLException();
                }catch(Exception e){
                        System.out.println(e.getMessage());
                throw new Exception();
                }
               
        }

}
