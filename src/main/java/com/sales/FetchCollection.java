package com.sales;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class FetchCollection {

        public ResultSet fetchData(String tableName)throws SQLException,Exception  {
                String query = "select * from " + tableName;
                ConnectToDb connection = new ConnectToDb();
                try {
                        Connection con = connection.connect();
                        Statement st = con.createStatement();
                        
                        ResultSet rs = st.executeQuery(query);

                        st.close();
                        con.close();
                        return rs;
                        
                } catch (SQLException e) {
                        System.out.println(e.getMessage());
                        throw new SQLException();
                } catch (Exception e) {
                        System.out.println(e.getMessage());
                        throw new Exception();
                }
        }

public ResultSet fetchData(String tableName,int id) throws SQLException, Exception {
        String query = "select * from " + tableName + " where pid= "+ id ;
        ConnectToDb connection = new ConnectToDb();
        try {
                Connection con = connection.connect();
                Statement st = con.createStatement();

                ResultSet rs = st.executeQuery(query);

                st.close();
                con.close();
                return rs;

        } catch (SQLException e) {
                System.out.println(e.getMessage());
                throw new SQLException();
        } catch (Exception e) {
                System.out.println(e.getMessage());
                throw new Exception();
        }
}

}
