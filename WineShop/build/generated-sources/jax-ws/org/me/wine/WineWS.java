
package org.me.wine;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.FaultAction;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.8
 * Generated source version: 2.2
 * 
 */
@WebService(name = "WineWS", targetNamespace = "http://wine.me.org/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface WineWS {


    /**
     * 
     * @param flavor
     * @param country
     * @param color
     * @param wineName
     * @param winery
     * @param body
     * @param region
     * @param sugar
     * @return
     *     returns org.me.wine.SetOfWines
     * @throws Exception_Exception
     * @throws PrologException_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "searchWines", targetNamespace = "http://wine.me.org/", className = "org.me.wine.SearchWines")
    @ResponseWrapper(localName = "searchWinesResponse", targetNamespace = "http://wine.me.org/", className = "org.me.wine.SearchWinesResponse")
    @Action(input = "http://wine.me.org/WineWS/searchWinesRequest", output = "http://wine.me.org/WineWS/searchWinesResponse", fault = {
        @FaultAction(className = PrologException_Exception.class, value = "http://wine.me.org/WineWS/searchWines/Fault/PrologException"),
        @FaultAction(className = Exception_Exception.class, value = "http://wine.me.org/WineWS/searchWines/Fault/Exception")
    })
    public SetOfWines searchWines(
        @WebParam(name = "wineName", targetNamespace = "")
        String wineName,
        @WebParam(name = "winery", targetNamespace = "")
        String winery,
        @WebParam(name = "color", targetNamespace = "")
        String color,
        @WebParam(name = "sugar", targetNamespace = "")
        String sugar,
        @WebParam(name = "body", targetNamespace = "")
        String body,
        @WebParam(name = "flavor", targetNamespace = "")
        String flavor,
        @WebParam(name = "region", targetNamespace = "")
        String region,
        @WebParam(name = "country", targetNamespace = "")
        String country)
        throws Exception_Exception, PrologException_Exception
    ;

    /**
     * 
     * @param arg1
     * @param arg0
     * @return
     *     returns org.me.wine.Term
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getOneVariableAnswer", targetNamespace = "http://wine.me.org/", className = "org.me.wine.GetOneVariableAnswer")
    @ResponseWrapper(localName = "getOneVariableAnswerResponse", targetNamespace = "http://wine.me.org/", className = "org.me.wine.GetOneVariableAnswerResponse")
    @Action(input = "http://wine.me.org/WineWS/getOneVariableAnswerRequest", output = "http://wine.me.org/WineWS/getOneVariableAnswerResponse")
    public Term getOneVariableAnswer(
        @WebParam(name = "arg0", targetNamespace = "")
        PrologAssignments arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        String arg1);

    /**
     * 
     * @param name
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "hello", targetNamespace = "http://wine.me.org/", className = "org.me.wine.Hello")
    @ResponseWrapper(localName = "helloResponse", targetNamespace = "http://wine.me.org/", className = "org.me.wine.HelloResponse")
    @Action(input = "http://wine.me.org/WineWS/helloRequest", output = "http://wine.me.org/WineWS/helloResponse")
    public String hello(
        @WebParam(name = "name", targetNamespace = "")
        String name);

}