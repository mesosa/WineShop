<%-- 
    Document   : shoppingCart
    Created on : 29-12-2014, 23:20:08
    Author     : miklasnjor
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/jspf/header.jspf" %>
            
    <body>
        <%@ include file="/WEB-INF/jspf/navigation.jspf" %>
        
            
        <div id="main">
            	

             <%@ include file="/WEB-INF/jspf/searchbox.jspf" %>
             
             
              <div id="cart">
                                       <div class="col-md-12"> 

                <h2>Shopping cart</h2>
                <table class="table table-bordered">
                <thead class="table-header">
                    <tr>
                        <td>Wine name</td>
                        <td>Seller</td>
                        <td>Qty</td>
                        <td>Price</td>
                    </tr>
                </thead>
                <tbody>

  <tr>
      <td><%= request.getSession().getAttribute("Winename") %></td>
                        <td><%= request.getSession().getAttribute("Seller") %></td>
                        <td><%= request.getSession().getAttribute("Quantity") %></td>
                        <td><%= request.getSession().getAttribute("Price") %>$</td>
                        
                    </tr>

                    
                </tbody>
            </table>
                <div class="form-group align-right well">
                <label>Total:</label>
                <span class="price"><%= Integer.parseInt (request.getSession().getAttribute("Price").toString()) * Integer.parseInt( request.getSession().getAttribute("Quantity").toString()) %>$</span>
            </div>
                  </div>
                                    </div>

        </div> <!-- ends main -->
    </body>
</html>
