package com.sales;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.sales.beanclasses.Product;

public class FetchProduct {
 private final ArrayList<Product> arr = new ArrayList<>();
    public Product[] getProduct() {
        FetchCollection fc = new FetchCollection();
  
        try {
            ResultSet rs = fc.fetchData("products");
            while (rs.next()) {
                Product p = new Product();
                p.setPid(rs.getInt("product_id"));
                p.setProductName(rs.getString("product_name"));
                p.setPrice(rs.getFloat("price"));
                arr.add(p);
            }
            rs.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
        return arr.toArray(new Product[0]);
    }
    public String deleteProduct(int id){
        DeleteCollection dc = new DeleteCollection();
        String result = dc.deleteDataQuery(id);
        return result;
    }
}
