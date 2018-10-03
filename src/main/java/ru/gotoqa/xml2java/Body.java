package ru.gotoqa.xml2java;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * @author Muflikhunov Roman
 */
//@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", namespace = "http://www.w3.org/2003/05/soap-envelope",propOrder = {
        "enumBICXMLResponse"
})
//@XmlRootElement(name = "Body", namespace = "http://www.w3.org/2003/05/soap-envelope")
public class Body {
    protected List<EnumBICXMLResponse> enumBICXMLResponse;

    @XmlElement(name = "EnumBIC_XMLResponse", namespace = "http://web.cbr.ru/")

    public List<EnumBICXMLResponse> getEnumBICXMLResponse() {
        return enumBICXMLResponse;
    }

    public void setEnumBICXMLResponse(List<EnumBICXMLResponse> enumBICXMLResponse) {
        this.enumBICXMLResponse = enumBICXMLResponse;
    }
}
