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
            System.out.println(wineCountry);
          
            String wineRegion = request.getParameter("wineRegion");
            System.out.println(wineRegion);
            
            String wineWinery = request.getParameter("wineWinery");
            System.out.println(wineWinery);

            String wineColor = request.getParameter("wineColor");
            System.out.println(wineColor);
            
            String wineFlavor = request.getParameter("wineFlavor");
            System.out.println(wineFlavor);
            
            String wineSugar = request.getParameter("wineSugar");
            System.out.println(wineSugar);
            
            String wineBody = request.getParameter("wineBody");
            System.out.println(wineBody);
            
            // call web service with these variables values. ask with prolog queries

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

}