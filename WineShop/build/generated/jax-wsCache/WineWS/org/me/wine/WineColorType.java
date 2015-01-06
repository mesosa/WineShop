
package org.me.wine;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for wineColorType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="wineColorType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Red"/>
 *     &lt;enumeration value="Rose"/>
 *     &lt;enumeration value="White"/>
 *     &lt;enumeration value="Undefined"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "wineColorType")
@XmlEnum
public enum WineColorType {

    @XmlEnumValue("Red")
    RED("Red"),
    @XmlEnumValue("Rose")
    ROSE("Rose"),
    @XmlEnumValue("White")
    WHITE("White"),
    @XmlEnumValue("Undefined")
    UNDEFINED("Undefined");
    private final String value;

    WineColorType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static WineColorType fromValue(String v) {
        for (WineColorType c: WineColorType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
