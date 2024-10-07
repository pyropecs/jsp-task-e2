<%@ page import=" com.sales.beanclasses.Customer,com.sales.FetchCustomers" %>

<html>
  <body>
        <%! private Customer[] customers; %>
        <% String field = (String) request.getAttribute("field"); 
        String order = (String)  request.getAttribute("order");
      
        %>

    <% FetchCustomers fc = new FetchCustomers(); 

    if(field!=null && order!=null){
       
         customers = fc.getCustomers(field,order); 
    }else if(field == null && order == null){
      
         customers = fc.getCustomers();
    }else{
        out.println("something went wrong");
    }
    
    
    %>
    
    
    <h1 style="width: 100%; text-align: center">Customers</h1>

    <table>
      <tbody>
        <tr>
          <th>Customer id</th>
          <th>Customer name</th>
          <th>Customer age</th>
        </tr>

        <% for(Customer c:customers){ %>

        <tr>
          <td><%= c.getCid() %></td>
          <td><%= c.getCustomerName() %></td>
          <td><%= c.getAge() %></td>
        </tr>
        <% } %>
      </tbody>
    </table>
    <form action="customers" method="get">
      <select name="order" id="">
        <option <%= field !=null && field.equals("customer_name")  ? "selected":"" %> selected value="customer_name">name</option>
        <option <%= field !=null && field.equals("customer_age")  ? "selected":"" %> value="customer_age">age</option>
      </select>

      <input type="submit" name="sort" value="asc"/>
      <input type="submit" name="sort" value="desc" />
    </form>
  </body>
</html>
