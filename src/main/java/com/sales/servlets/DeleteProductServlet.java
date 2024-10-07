package com.sales.servlets;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sales.DeleteCollection;

@WebServlet("/products/deleteItem")
public class DeleteProductServlet extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse res) {
        int id = Integer.parseInt(req.getParameter("id"));
        DeleteCollection dc = new DeleteCollection();
        dc.deleteDataQuery(id);
        try {
            res.sendRedirect("/sales/products");
        } catch (IOException e) {

            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }

    }

}
