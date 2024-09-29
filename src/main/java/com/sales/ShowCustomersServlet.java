package com.sales;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;


@WebServlet("/")
public class ShowCustomersServlet extends HttpServlet {

        public void doGet(HttpServletRequest req, HttpServletResponse res) {
             
                try{ 
                        
                        RequestDispatcher rd = req.getRequestDispatcher("customers.jsp");
                        rd.forward(req, res);
                } catch (IOException e) {
                        System.out.println(e.getMessage());
                } catch (Exception e) {
                        System.out.println(e.getMessage());
                }

        }

}
