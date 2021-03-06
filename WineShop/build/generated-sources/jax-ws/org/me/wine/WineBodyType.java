
package org.me.wine;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for wineBodyType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="wineBodyType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Full"/>
 *     &lt;enumeration value="Medium"/>
 *     &lt;enumeration value="Light"/>
 *     &lt;enumeration value="Undefined"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "wineBodyType")
@XmlEnum
public enum WineBodyType {

    @XmlEnumValue("Full")
    FULL("Full"),
    @XmlEnumValue("Medium")
    MEDIUM("Medium"),
    @XmlEnumValue("Light")
    LIGHT("Light"),
    @XmlEnumValue("Undefined")
    UNDEFINED("Undefined");
    private final String value;

    WineBodyType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static WineBodyType fromValue(String v) {
        for (WineBodyType c: WineBodyType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
