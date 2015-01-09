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
            Price results for <% String winename = (String)request.getAttribute("winename"); %><%= winename %>
            <!-- div id="searchResults"></div--> <!-- ends searchResults -->
            
        </div> <!-- ends main -->
    </body>
</html>