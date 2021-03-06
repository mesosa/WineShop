
package org.me.wine;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Wine complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Wine">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="wineName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="winery" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="wineRegion" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="wineColor" type="{http://wine.me.org/}wineColorType"/>
 *         &lt;element name="wineBody" type="{http://wine.me.org/}wineBodyType"/>
 *         &lt;element name="wineFlavor" type="{http://wine.me.org/}wineFlavorType"/>
 *         &lt;element name="wineSugar" type="{http://wine.me.org/}wineSugarType"/>
 *         &lt;element name="wineCountry" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Wine", propOrder = {
    "wineName",
    "winery",
    "wineRegion",
    "wineColor",
    "wineBody",
    "wineFlavor",
    "wineSugar",
    "wineCountry"
})
public class Wine {

    @XmlElement(required = true)
    protected String wineName;
    @XmlElement(required = true)
    protected String winery;
    @XmlElement(required = true)
    protected String wineRegion;
    @XmlElement(required = true)
    protected WineColorType wineColor;
    @XmlElement(required = true)
    protected WineBodyType wineBody;
    @XmlElement(required = true)
    protected WineFlavorType wineFlavor;
    @XmlElement(required = true)
    protected WineSugarType wineSugar;
    @XmlElement(required = true)
    protected String wineCountry;

    /**
     * Gets the value of the wineName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWineName() {
        return wineName;
    }

    /**
     * Sets the value of the wineName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWineName(String value) {
        this.wineName = value;
    }

    /**
     * Gets the value of the winery property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWinery() {
        return winery;
    }

    /**
     * Sets the value of the winery property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWinery(String value) {
        this.winery = value;
    }

    /**
     * Gets the value of the wineRegion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWineRegion() {
        return wineRegion;
    }

    /**
     * Sets the value of the wineRegion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWineRegion(String value) {
        this.wineRegion = value;
    }

    /**
     * Gets the value of the wineColor property.
     * 
     * @return
     *     possible object is
     *     {@link WineColorType }
     *     
     */
    public WineColorType getWineColor() {
        return wineColor;
    }

    /**
     * Sets the value of the wineColor property.
     * 
     * @param value
     *     allowed object is
     *     {@link WineColorType }
     *     
     */
    public void setWineColor(WineColorType value) {
        this.wineColor = value;
    }

    /**
     * Gets the value of the wineBody property.
     * 
     * @return
     *     possible object is
     *     {@link WineBodyType }
     *     
     */
    public WineBodyType getWineBody() {
        return wineBody;
    }

    /**
     * Sets the value of the wineBody property.
     * 
     * @param value
     *     allowed object is
     *     {@link WineBodyType }
     *     
     */
    public void setWineBody(WineBodyType value) {
        this.wineBody = value;
    }

    /**
     * Gets the value of the wineFlavor property.
     * 
     * @return
     *     possible object is
     *     {@link WineFlavorType }
     *     
     */
    public WineFlavorType getWineFlavor() {
        return wineFlavor;
    }

    /**
     * Sets the value of the wineFlavor property.
     * 
     * @param value
     *     allowed object is
     *     {@link WineFlavorType }
     *     
     */
    public void setWineFlavor(WineFlavorType value) {
        this.wineFlavor = value;
    }

    /**
     * Gets the value of the wineSugar property.
     * 
     * @return
     *     possible object is
     *     {@link WineSugarType }
     *     
     */
    public WineSugarType getWineSugar() {
        return wineSugar;
    }

    /**
     * Sets the value of the wineSugar property.
     * 
     * @param value
     *     allowed object is
     *     {@link WineSugarType }
     *     
     */
    public void setWineSugar(WineSugarType value) {
        this.wineSugar = value;
    }

    /**
     * Gets the value of the wineCountry property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWineCountry() {
        return wineCountry;
    }

    /**
     * Sets the value of the wineCountry property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWineCountry(String value) {
        this.wineCountry = value;
    }

}
