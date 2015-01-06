
package org.me.wine;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.me.wine package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _SearchWines_QNAME = new QName("http://wine.me.org/", "searchWines");
    private final static QName _HelloResponse_QNAME = new QName("http://wine.me.org/", "helloResponse");
    private final static QName _SearchWinesResponse_QNAME = new QName("http://wine.me.org/", "searchWinesResponse");
    private final static QName _Hello_QNAME = new QName("http://wine.me.org/", "hello");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.me.wine
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link SearchWines }
     * 
     */
    public SearchWines createSearchWines() {
        return new SearchWines();
    }

    /**
     * Create an instance of {@link HelloResponse }
     * 
     */
    public HelloResponse createHelloResponse() {
        return new HelloResponse();
    }

    /**
     * Create an instance of {@link Hello }
     * 
     */
    public Hello createHello() {
        return new Hello();
    }

    /**
     * Create an instance of {@link SearchWinesResponse }
     * 
     */
    public SearchWinesResponse createSearchWinesResponse() {
        return new SearchWinesResponse();
    }

    /**
     * Create an instance of {@link Wine }
     * 
     */
    public Wine createWine() {
        return new Wine();
    }

    /**
     * Create an instance of {@link SetOfWines }
     * 
     */
    public SetOfWines createSetOfWines() {
        return new SetOfWines();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SearchWines }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wine.me.org/", name = "searchWines")
    public JAXBElement<SearchWines> createSearchWines(SearchWines value) {
        return new JAXBElement<SearchWines>(_SearchWines_QNAME, SearchWines.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HelloResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wine.me.org/", name = "helloResponse")
    public JAXBElement<HelloResponse> createHelloResponse(HelloResponse value) {
        return new JAXBElement<HelloResponse>(_HelloResponse_QNAME, HelloResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SearchWinesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wine.me.org/", name = "searchWinesResponse")
    public JAXBElement<SearchWinesResponse> createSearchWinesResponse(SearchWinesResponse value) {
        return new JAXBElement<SearchWinesResponse>(_SearchWinesResponse_QNAME, SearchWinesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Hello }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wine.me.org/", name = "hello")
    public JAXBElement<Hello> createHello(Hello value) {
        return new JAXBElement<Hello>(_Hello_QNAME, Hello.class, null, value);
    }

}
