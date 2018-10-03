package ru.gotoqa.xml2java;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * @author Muflikhunov Roman
 */
@XmlType(name = "", namespace = "http://www.w3.org/2003/05/soap-envelope", propOrder = {
        "enumBICXMLResult"
})
public class EnumBICXMLResponse {

    protected List<EnumBICXMLResult> enumBICXMLResult;

    @XmlElement(name = "EnumBIC_XMLResult", namespace = "http://web.cbr.ru/")
    public List<EnumBICXMLResult> getEnumBICXMLResult() {
        return enumBICXMLResult;
    }

    public void setEnumBICXMLResult(List<EnumBICXMLResult> enumBICXMLResult) {
        this.enumBICXMLResult = enumBICXMLResult;
    }
}
