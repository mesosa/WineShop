/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.me.wine;

import generated.SetOfWines;
import generated.Wine;
import generated.WineBodyType;
import generated.WineColorType;
import generated.WineFlavorType;
import generated.WineSugarType;
import gnu.prolog.term.Term;
import gnu.prolog.vm.PrologException;
import java.util.Iterator;
import java.util.Set;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import prolog.ExecuteGoal;
import prolog.PrologAssignments;
import prolog.SetOfPrologAssignments;

/**
 *
 * @author Mojca
 */
@WebService(serviceName = "WineWS")
@Stateless()
public class WineWS {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "searchWines")
    public SetOfWines searchWines(@WebParam(name = "wineName") String wineName, @WebParam(name = "winery") String winery, @WebParam(name = "color") String color, @WebParam(name = "sugar") String sugar, @WebParam(name = "body") String body, @WebParam(name = "flavor") String flavor, @WebParam(name = "region") String region, @WebParam(name = "country") String country) throws PrologException, Exception {
        
        SetOfWines wines = new SetOfWines();
        ExecuteGoal execute = new ExecuteGoal();
        execute.readInPredicates("/Users/Mojca/NetBeansProjects/WineShop/WineShopWS/wine.pro");
        
        String goalToRun = "wine(Winename"+","+winery+","+color+","+sugar+","+body+","+flavor+","+region+","+country+")";
        System.out.println(goalToRun);
        
        SetOfPrologAssignments assignments = execute.executeGoal(goalToRun);
        
        if(assignments.isSuccess()) {
            System.out.println(assignments.toString());
        }
        
        Iterator<PrologAssignments> iter = assignments.iterator();
        while (iter.hasNext()) {
            PrologAssignments ass1 = iter.next();

            Wine wine = new Wine();

            Term o = getOneVariableAnswer(ass1, "Winename");
            if (o != null) {
                wine.setWineName(o.toString());
            } else {
                wine.setWineName(wineName);
            }

            o = getOneVariableAnswer(ass1, region);
            if (o != null) {
                wine.setWineRegion(o.toString());
            } else {
                wine.setWineRegion(region);
            }

            o = getOneVariableAnswer(ass1, body);
            if (o != null) {
                wine.setWineBody(WineBodyType.valueOf(o.toString().toUpperCase()));
            } else {
                wine.setWineBody(WineBodyType.valueOf(body.toUpperCase()));
            }

            o = getOneVariableAnswer(ass1, color);
            if (o != null) {
                wine.setWineColor(WineColorType.valueOf(o.toString().toUpperCase()));
            } else {
                wine.setWineColor(WineColorType.valueOf(color.toUpperCase()));
            }

            o = getOneVariableAnswer(ass1, flavor);
            if (o != null) {
                wine.setWineFlavor(WineFlavorType.valueOf(o.toString().toUpperCase()));
            } else {
                wine.setWineFlavor(WineFlavorType.valueOf(flavor.toUpperCase()));
            }
            
            o = getOneVariableAnswer(ass1, sugar);
            if (o != null) {
                wine.setWineSugar(WineSugarType.valueOf(o.toString().toUpperCase()));
            } else {
                wine.setWineSugar(WineSugarType.valueOf(sugar.toUpperCase()));
            }
            
            o = getOneVariableAnswer(ass1, winery);
            if (o != null) {
                wine.setWinery(o.toString());
            } else {
                wine.setWinery(winery);
            }
      

            o = getOneVariableAnswer(ass1, country);
            if (o != null) {
                wine.setWineCountry(o.toString());
            } else {
                wine.setWineCountry(country);
            }
        
            wines.getWines().add(wine);
            
            
            
        }
        return wines;
        //return null;

    }
       
    public Term getOneVariableAnswer(PrologAssignments assign, String variable) {
        String assignS = null;
        // Iterate through terms
        Set<Term> setOfNames = assign.getSetOfNames();
        Term name = null;
        Iterator<Term> termsIter = setOfNames.iterator();
        // Loop until the match to the variable is found
        while (termsIter.hasNext() && name == null) {
            Term currentTerm = termsIter.next();
            if (currentTerm.toString().equals(variable)) {
                name = currentTerm;
            }
        }
        // Get the value of the variable and add it to the list
        Term findAssignment = assign.findAssignment(name);

        return findAssignment;
    }
}
