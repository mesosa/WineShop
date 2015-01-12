<%-- 
    Document   : shoppingCart
    Created on : 29-12-2014, 23:20:08
    Author     : miklasnjor
--%>

<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/jspf/header.jspf" %>
            
    <body>
        <%@ include file="/WEB-INF/jspf/navigation.jspf" %>
        
            
        <div id="main">
            	

             <%@ include file="/WEB-INF/jspf/searchbox.jspf" %>
             
             
              
                
                <% 
                    
                    if (session.getAttribute("cart")==null) {
                        %>
                        Your shopping cart is empty!
                    <%
                    // Not created yet. Now do so yourself.
                    
                } else {
                        %>
                    
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
                    <% 
                        HashMap<String, ArrayList<String>> cart = (HashMap<String, ArrayList<String>>) session.getAttribute("cart");
                        
                        Integer priceTog = 0;
                        for (String name : cart.keySet()) {
                            ArrayList<String> value = cart.get(name);
                            priceTog = priceTog + Integer.parseInt(value.get(0))*Integer.parseInt(value.get(1));
                            %>
                            <tr>
                                <td><%= name %></td>
                                <td><%= value.get(2) %></td>
                                <td><%= value.get(1) %></td>
                                <td><%= value.get(0) %>$</td>
                            </tr>
                            <%
                        }
                        
                    %>
                    <!--
                    <tr>
                        <td><%= request.getSession().getAttribute("Winename") %></td>
                        <td><%= request.getSession().getAttribute("Seller") %></td>
                        <td><%= request.getSession().getAttribute("Quantity") %></td>
                        <td><%= request.getSession().getAttribute("Price") %>$</td>
                        
                    </tr>

                    -->
                </tbody>
            </table>
                        
                <div class="form-group align-right well">
                <label>Total:</label>
                <span class="price"> <%= priceTog %>$</span>
                <form action="shoppingCart" method="post">
                    <input type="submit" name="buyButton" id="buyButton" value="Buy!">
                </form>
            
                        </div>
                  </div>
                                    </div>

        
                        <%
                }
                %>
                
        </div> <!-- ends main -->        
    </body>
</html>
