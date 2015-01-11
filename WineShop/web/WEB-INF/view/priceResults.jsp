<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%-- 
    Document   : priceResults
    Created on : 29-12-2014, 23:19:08
    Author     : miklasnjor
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/jspf/header.jspf" %>
            
    <body>
        <%@ include file="/WEB-INF/jspf/navigation.jspf" %>
            
    
        
        <div id="main">
            

            <%@ include file="/WEB-INF/jspf/searchbox.jspf" %>
         

            <!-- div id="searchResults"></div--> <!-- ends searchResults -->
           
                 
                <div id="searchAvailable">
                    <div id="row">
                    <div class="col-md-6"> 

                     <img class="img-thumbnail" alt="wine image" src="http://placehold.it/250x250">
                   </div>
                       <div class="col-md-6"> 
                     <h2>Price results for <% String winename = (String)request.getAttribute("winename"); %><%= winename %></h2>
                   </div>
                   
                   <% String agentRegion = (String)request.getAttribute("seller"); %>
                   <% int price = (Integer)request.getAttribute("price"); %>
                   <% int quantity = (Integer)request.getAttribute("quantity"); %>
                   
                 </div>
              
                     <div class="col-md-12"> 
           
                  <div class="page-header">
               
                     <h1>Available sellers</h1>
                       </div>
                         <form name="basketAdder" id="addToBasketForm" action="addtobasket">
                    <table class="table table-bordered">
                    <thead>
                        <tr>
                            <td>Wine name</td>
                            <td>Seller</td>
                            <td>Price</td>
                            <td>Quantity buying</td>
                            <td>Action</td>
                        </tr>
                    </thead>
                    <tr>
                        <td><%= winename %><input type="hidden" value="<%= winename %>" name="Winename"></td>
                        <td><%= agentRegion %><input type="hidden" value="<%= agentRegion %>" name="Seller"></td>
                        <td><%= price %>$<input type="hidden" value="<%= price %>" name="Price"></td>
                        <td><input type="number" name="Quantity" value="1" min="1" max="<%= quantity %>"></td>
                        <td><input type="submit" value="Add to basket"> </td>
                        
                    </tr>
                    </form>
                </table>
                      
          
            </div>
               </div>
        </div> <!-- ends main -->
        
    </body>
</html>