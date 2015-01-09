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
                 </div>
              
                     <div class="col-md-12"> 
           
                  <div class="page-header">
               
                     <h1>Available sellers</h1>
                       </div>
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
                    
                </table>
                      
          
            </div>
               </div>
        </div> <!-- ends main -->
    </body>
</html>