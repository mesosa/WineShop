//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.5-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.01.06 at 12:56:33 PM CET 
//


package generated;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for wineSugarType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="wineSugarType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Dry"/>
 *     &lt;enumeration value="Offdry"/>
 *     &lt;enumeration value="Sweet"/>
 *     &lt;enumeration value="Undefined"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "wineSugarType")
@XmlEnum
public enum WineSugarType {

    @XmlEnumValue("Dry")
    DRY("Dry"),
    @XmlEnumValue("Offdry")
    OFFDRY("Offdry"),
    @XmlEnumValue("Sweet")
    SWEET("Sweet"),
    @XmlEnumValue("Undefined")
    UNDEFINED("Undefined");
    private final String value;

    WineSugarType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static WineSugarType fromValue(String v) {
        for (WineSugarType c: WineSugarType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}