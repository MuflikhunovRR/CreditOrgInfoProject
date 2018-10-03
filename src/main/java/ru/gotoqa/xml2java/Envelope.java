package ru.gotoqa.xml2java;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * @author Muflikhunov Roman
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "body"
})
@XmlRootElement(name = "Envelope", namespace = "http://www.w3.org/2003/05/soap-envelope")
public class Envelope {
    @XmlElement(name = "Body", namespace = "http://www.w3.org/2003/05/soap-envelope", required = true)
    protected List<Body> body;

    public List<Body> getBody() {
        return body;
    }

    public void setBody(List<Body> body) {
        this.body = body;
    }
}
