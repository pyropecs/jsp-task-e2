package com.sales;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.sales.beanclasses.Customer;

public class FetchCustomers {

    private final ArrayList<Customer> arr = new ArrayList<>();
    
    public Customer[] getCustomers() {
        FetchCollection fc = new FetchCollection();
        try {
            ResultSet rs = fc.fetchData("customers");
            while (rs.next()) {
                Customer c = new Customer();
                c.setCid(rs.getInt("customer_id"));
                c.setCustomerName(rs.getString("customer_name"));
                c.setAge(rs.getInt("customer_age"));
                arr.add(c);
            }
            rs.close();
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
          
        }
        return arr.toArray(new Customer[0]);
    }

    public Customer[] getCustomers(String field,String order){
        FetchCollection fc = new FetchCollection();
      
        try {
            ResultSet rs = fc.fetchData("customers",order,field);
            while (rs.next()) {
                Customer c = new Customer();
                c.setCid(rs.getInt("customer_id"));
                c.setCustomerName(rs.getString("customer_name"));
                c.setAge(rs.getInt("customer_age"));
                arr.add(c);
            }
            rs.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());

        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
        return arr.toArray(new Customer[0]);
    }

}
