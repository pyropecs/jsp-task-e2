<%@ page import="com.sales.beanclasses.Product,com.sales.FetchProduct" %>

<html>
  <body>
    <%  FetchProduct fp = new FetchProduct();
    Product[] products = fp.getProduct(); %>
    <h1 style="width: 100%; text-align: center">Product</h1>

    <table>
      <tbody>
        <tr>
          <th>Product id</th>
          <th>Product name</th>
          <th>Price</th>
          <th>Delete</th>
        </tr>

 <%
 if(products.length == 0){
  %>  
 <tr>
  <td>no products found</td>
 </tr>

 <% } %>


<% for(Product p:products){ %>
        <tr>
          <td><%= p.getPid() %></td>
          <td><%= p.getProductName() %></td>
          <td><%= p.getPrice() %></td>
          <td><a href="products/deleteItem?id=<%= p.getPid() %>" onclick="return confirm('Are you sure you want to delete this item?')">
    <img src="images/delete.png" alt="Delete" height="32" width="32">
</a>
</td>
        </tr>
<% } %>        
      </tbody>
    </table>
    <a href="/sales"><button>back</button></a>
  </body>
</html>
