package com.sales;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class FetchCustomers {
        private ArrayList<Customer> arr = new ArrayList<>();

        public Customer[] getCustomers() throws SQLException, Exception {
                FetchCollection fc = new FetchCollection();
                try {
                        ResultSet rs = fc.fetchData("customers");
                        while (rs.next()) {
                                Customer c = new Customer();
                                c.setCid(rs.getInt("cid"));
                                c.setCity(rs.getString("city"));
                                c.setCustomerMobile(rs.getString("customer_mobile"));
                                c.setCustomerName(rs.getString("customer_name"));
                                c.setPid(rs.getInt("pid"));
                                arr.add(c);
                        }
                        rs.close();
                        return arr.toArray(new Customer[0]);
                } catch (SQLException e) {
                        System.out.println(e.getMessage());
                        throw new SQLException();
                } catch (Exception e) {
                        System.out.println(e.getMessage());
                        throw new Exception();
                }

        }

}
