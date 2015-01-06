
package org.me.wine;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for wineFlavorType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="wineFlavorType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Delicate"/>
 *     &lt;enumeration value="Moderate"/>
 *     &lt;enumeration value="Strong"/>
 *     &lt;enumeration value="Undefined"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "wineFlavorType")
@XmlEnum
public enum WineFlavorType {

    @XmlEnumValue("Delicate")
    DELICATE("Delicate"),
    @XmlEnumValue("Moderate")
    MODERATE("Moderate"),
    @XmlEnumValue("Strong")
    STRONG("Strong"),
    @XmlEnumValue("Undefined")
    UNDEFINED("Undefined");
    private final String value;

    WineFlavorType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static WineFlavorType fromValue(String v) {
        for (WineFlavorType c: WineFlavorType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
