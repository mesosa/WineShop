//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.5-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.01.06 at 12:56:33 PM CET 
//


package generated;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Request complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Request">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="wineRequest" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Wine" type="{}Wine" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Request", propOrder = {
    "wineRequest",
    "wine"
})
public class Request {

    protected String wineRequest;
    @XmlElement(name = "Wine")
    protected Wine wine;

    /**
     * Gets the value of the wineRequest property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWineRequest() {
        return wineRequest;
    }

    /**
     * Sets the value of the wineRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWineRequest(String value) {
        this.wineRequest = value;
    }

    /**
     * Gets the value of the wine property.
     * 
     * @return
     *     possible object is
     *     {@link Wine }
     *     
     */
    public Wine getWine() {
        return wine;
    }

    /**
     * Sets the value of the wine property.
     * 
     * @param value
     *     allowed object is
     *     {@link Wine }
     *     
     */
    public void setWine(Wine value) {
        this.wine = value;
    }

}
