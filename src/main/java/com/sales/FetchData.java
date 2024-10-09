package com.sales;

import java.sql.ResultSet;
import java.util.ArrayList;

import com.sales.beanclasses.Customer;
import com.sales.beanclasses.Product;

public class FetchData<T> {

    private ArrayList<T> arr;

    public T[] fetchCollection(String tableName, String... labels) {
        FetchCollection fc = new FetchCollection();

        try {
            ResultSet rs = fc.fetchData(tableName);
            while (rs.next()) {
                if (tableName.equals("products")) {
                    Product productObject = new Product(rs.getInt(labels[0]), rs.getString(labels[1]), rs.getFloat(labels[2]));
                    arr.add((T) productObject);
                } else if (tableName.equals("customers")) {
                    {
                        Customer customerObject = new Customer(rs.getInt(labels[0]), rs.getString(labels[1]), rs.getInt(labels[2]));
                        arr.add((T) customerObject);
                    }
                } else {
                    System.out.println("something went wrong.recieved table name not yet created");
                }

            }
            rs.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
        return (T[]) arr.toArray();
    }

    public static String deleteProduct(int id) {
        DeleteCollection dc = new DeleteCollection();
        String result = dc.deleteDataQuery(id, "products");
        return result;
    }

}
