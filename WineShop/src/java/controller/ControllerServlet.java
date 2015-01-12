/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.WebServiceRef;
import org.me.wine.Exception_Exception;
import org.me.wine.PrologException_Exception;
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
                            "/priceResults",
                            "/addtobasket"
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
    
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
    static final String DB_URL = "jdbc:mysql://mysql11.gigahost.dk:3306/goldenboy_agents";

    //  Database credentials
    static final String USER = "goldenboy";
    static final String PASS = "1_am_g0ld3nb0y";
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String userPath = request.getServletPath();
        System.out.println(userPath);        
        // if category page is requested
        if (userPath.equals("/results")) {
            // get all the parameters to variables
            // searchButton=Search+for+wines%21

            String wineCountry = request.getParameter("wineCountry");
            if (wineCountry.equals("Choose"))
                wineCountry = "Country";
            else
                wineCountry = wineCountry.toLowerCase();
            
            String wineRegion = request.getParameter("wineRegion");
            if (wineRegion.equals("Choose"))
                wineRegion = "Region";
            else
                wineRegion = wineRegion.toLowerCase();
            
            String wineWinery = request.getParameter("wineWinery");
            if (wineWinery.equals("Choose"))
                wineWinery = "Winery";
            else
                wineWinery = wineWinery.toLowerCase();
            
            String wineColor = request.getParameter("wineColor");
            if (wineColor == null)
                wineColor = "Color";
            else
                wineColor = wineColor.toLowerCase();
                
            String wineFlavor = request.getParameter("wineFlavor");
            if (wineFlavor == null)
                wineFlavor = "Flavor";
            else
                wineFlavor = wineFlavor.toLowerCase();
            
            String wineSugar = request.getParameter("wineSugar");
            if (wineSugar == null)
                wineSugar = "Sugar";
            else
                wineSugar = wineSugar.toLowerCase();
           
            String wineBody = request.getParameter("wineBody");
            if (wineBody == null)
                wineBody = "Body";
            else 
                wineBody = wineBody.toLowerCase();
            
            SetOfWines results = null;
            try {
                results = searchWines("winename",wineWinery,wineColor,wineSugar,wineBody,wineFlavor,wineRegion,wineCountry);
                // call web service with these variables values. ask with prolog queries
            } catch (Exception_Exception ex) {
                Logger.getLogger(ControllerServlet.class.getName()).log(Level.SEVERE, null, ex);
            } catch (PrologException_Exception ex) {
                Logger.getLogger(ControllerServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            
            request.setAttribute("setofwines", results);
        } else if (userPath.equals("/shoppingCart")){
            System.out.println("cart");
        } /* */else if (userPath.equals("/priceResults")){
            String winename = request.getParameter("wineName");
            System.out.println(winename);
            
            //
            Connection conn = null;
            Statement stmt = null;
            try{
               //STEP 2: Register JDBC driver
               Class.forName("com.mysql.jdbc.Driver");

               //STEP 3: Open a connection
               System.out.println("Connecting to database...");
               conn = DriverManager.getConnection(DB_URL,USER,PASS);

               //STEP 4: Execute a query
               System.out.println("Creating statement...");
               stmt = conn.createStatement();
               String sql;
               sql = "SELECT wines.WineName, wines.WineID, agents.WineAgentID, agents.AgentRegion,\n" +
                "wineStock.WineAgentID, wineStock.WineID, wineStock.StockPrice, wineStock.StockQuantity\n" +
                "FROM wines, agents, wineStock\n" +
                "WHERE wines.WineID = wineStock.WineID\n" +
                "AND wineStock.WineAgentID = agents.WineAgentID\n" +
                "AND wines.WineName ='"+winename+"'";
               ResultSet rs = stmt.executeQuery(sql);

               //STEP 5: Extract data from result set
               while(rs.next()){
                  //Retrieve by column name
                  int wineID  = rs.getInt("WineID");
                  String name = rs.getString("WineName");
                  int agentID = rs.getInt("WineAgentID");
                  int wineprice = rs.getInt("StockPrice");
                  int quantity = rs.getInt("StockQuantity");
                  String agentRegion = rs.getString("AgentRegion");
                  
                  request.setAttribute("wineID", wineID);
                  request.setAttribute("wineAgentID", agentID);
                  request.setAttribute("seller", agentRegion);
                  request.setAttribute("price", wineprice);
                  request.setAttribute("quantity", quantity);
                  //Display values
                  System.out.print(", name: " + name);
               }
               //STEP 6: Clean-up environment
               rs.close();
               stmt.close();
               conn.close();
            }catch(SQLException se){
               //Handle errors for JDBC
               se.printStackTrace();
            }catch(Exception e){
               //Handle errors for Class.forName
               e.printStackTrace();
            }finally{
               //finally block used to close resources
               try{
                  if(stmt!=null)
                     stmt.close();
               }catch(SQLException se2){
               }// nothing we can do
               try{
                  if(conn!=null)
                     conn.close();
               }catch(SQLException se){
                  se.printStackTrace();
               }//end finally try
            }//end try

            //
            
            request.setAttribute("winename", winename);
        }

        else if (userPath.equals("/addtobasket")) {
            
            System.out.print("hejhej");
            HttpSession session = request.getSession(true);
            
            String s = request.getParameter("Winename");
            String q = request.getParameter("Quantity");
            
            if (session.getAttribute("cart")==null){
                session.setAttribute("cart", new HashMap<String, ArrayList<String>>());
            }
            HashMap<String, ArrayList<String>> cart = (HashMap<String, ArrayList<String>>) session.getAttribute("cart");
            
            ArrayList<String> addToCart = new ArrayList<String>();
            addToCart.add(request.getParameter("Price").toString());
            addToCart.add(q==""?"0":q);
            addToCart.add(request.getParameter("Seller").toString());
                    
            cart.put(s, addToCart);
            session.setAttribute("cart", cart);
            
            /*
            session.setAttribute("Winename",s);
            session.setAttribute("Seller", request.getParameter("Seller").toString());
            session.setAttribute("Quantity", q==""?"0":q);
            session.setAttribute("Price", request.getParameter("Price").toString());
            */
            
            response.setHeader("Location", "/shoppingCart");
            
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
        System.out.println("post");
        System.out.println(userPath);
        if (userPath.equals("/shoppingCart")){
            System.out.println("buy ");
            //session.setAttribute("cart", new HashMap<String, ArrayList<String>>());
            request.getSession(false).removeAttribute("cart");
        
        } 
        
        // use RequestDispatcher to forward request internally
        String url = "/WEB-INF/view" + userPath + ".jsp";

        try {
            request.getRequestDispatcher(url).forward(request, response);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private SetOfWines searchWines(java.lang.String wineName, java.lang.String winery, java.lang.String color, java.lang.String sugar, java.lang.String body, java.lang.String flavor, java.lang.String region, java.lang.String country) throws Exception_Exception, PrologException_Exception {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        org.me.wine.WineWS port = service.getWineWSPort();
        return port.searchWines(wineName, winery, color, sugar, body, flavor, region, country);
    }

    

    
}