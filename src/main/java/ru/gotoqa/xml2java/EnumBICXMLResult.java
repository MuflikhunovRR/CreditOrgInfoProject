package ru.gotoqa.xml2java;

import javax.xml.bind.annotation.*;
import java.util.List;
/**
 * @author Muflikhunov Roman
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", namespace = "http://web.cbr.ru/", propOrder = {
        "enumBIC"
})
public class EnumBICXMLResult {

    @XmlElement(name = "EnumBIC", required = true)
    protected List<EnumBIC> enumBIC;


    public List<EnumBIC> getEnumBIC() {
        return enumBIC;
    }

    public void setEnumBIC(List<EnumBIC> enumBIC) {
        this.enumBIC = enumBIC;
    }
}








