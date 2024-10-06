package com.sales;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.sales.common.ConnectToDb;

public class FetchCollection {

    private ResultSet rs;

    public ResultSet fetchData(String tableName, String... args) {
     
        String order = args.length != 0 ? args[0] : "none";
        String field = args.length != 0 ? args[1] : "none";
       
        switch (order) {
            case "asc":
                rs = fetchDataQuery("select * from " + tableName + " order by "+ field + " asc");
                System.out.println(order + field);
                break;
            case "desc":
                rs = fetchDataQuery("select * from " + tableName + " order by " + field + " desc");
              

            default:
         
                rs = fetchDataQuery("select * from " + tableName);
                break;
        }
        return rs;
    }

    public ResultSet fetchDataQuery(String query) {
        try {
            ConnectToDb connection = new ConnectToDb();
            Connection con = connection.connect();
            Statement st = con.createStatement();

            rs = st.executeQuery(query);

            st.close();
            con.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());

        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
        return rs;
    }

}
