<%@ page import=" com.sales.beanclasses.Product,com.sales.FetchProduct" %>

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
         
        </tr>
<% for(Product p:products){
        <tr>
          <td><%= product.getPid() %></td>
          <td><%= product.getProductName() %></td>
          <td><%= product.getPrice() %></td>
          <td>delete</td>
        </tr>
<% } %>        
      </tbody>
    </table>
    <a href="/sales"><button>back</button></a>
  </body>
</html>
