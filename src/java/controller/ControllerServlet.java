/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import javax.ejb.EJB;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.WebServiceRef;
import org.me.wine.SetOfWines;
import org.me.wine.Wine;
import org.me.wine.WineWS_Service;
/**
 *
 * @author tgiunipero
 */
@WebServlet(name = "ControllerServlet",
            loadOnStartup = 1,
            urlPatterns = {"/results",
                            "/shoppingCart",
                            "/priceResults"
                           })
public class ControllerServlet extends HttpServlet {
    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/WineWS/WineWS.wsdl")
    private WineWS_Service service;
   
    
    /**
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String userPath = request.getServletPath();
                
        // if category page is requested
        if (userPath.equals("/results")) {
            // get all the parameters to variables
            // searchButton=Search+for+wines%21

            String wineCountry = request.getParameter("wineCountry");
            if (wineCountry.equals("Choose"))
                wineCountry = "country";
            
            String wineRegion = request.getParameter("wineRegion");
            if (wineRegion.equals("Choose"))
                wineRegion = "region";
            
            String wineWinery = request.getParameter("wineWinery");
            if (wineWinery.equals("Choose"))
                wineWinery = "winery";
            
            String wineColor = request.getParameter("wineColor");
            if (wineColor == null)
                wineColor = "color";
            
            String wineFlavor = request.getParameter("wineFlavor");
            if (wineFlavor == null)
                wineFlavor = "flavor";
            
            String wineSugar = request.getParameter("wineSugar");
            if (wineSugar == null)
                wineSugar = "sugar";
           
            String wineBody = request.getParameter("wineBody");
            if (wineBody == null)
                wineBody = "body";
            
            SetOfWines results = searchWines("winename",wineWinery,wineColor,wineSugar,wineBody,wineFlavor,wineRegion,wineCountry);
            // call web service with these variables values. ask with prolog queries
            
            /*for (Wine w:results.getWines()){
                System.out.println(w.getWineName());
            }
*/            
        } else if (userPath.equals("/shoppingCart")){
        
        } else if (userPath.equals("/priceResults")){
        
        }

        // use RequestDispatcher to forward request internally
        String url = "/WEB-INF/view" + userPath + ".jsp";

        try {
            request.getRequestDispatcher(url).forward(request, response);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    /**
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String userPath = request.getServletPath();
        HttpSession session = request.getSession();
        
        // use RequestDispatcher to forward request internally
        String url = "/WEB-INF/view" + userPath + ".jsp";

        try {
            request.getRequestDispatcher(url).forward(request, response);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private SetOfWines searchWines(java.lang.String wineName, java.lang.String winery, java.lang.String color, java.lang.String sugar, java.lang.String body, java.lang.String flavor, java.lang.String region, java.lang.String country) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        org.me.wine.WineWS port = service.getWineWSPort();
        return port.searchWines(wineName, winery, color, sugar, body, flavor, region, country);
    }

    

    
}