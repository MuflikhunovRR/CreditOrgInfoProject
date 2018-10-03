
package ru.gotoqa.xml2java;


import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BIC", propOrder = {
    "content"
})
@XmlRootElement(name = "BIC")
public class BIC {

    @XmlElementRefs({
        @XmlElementRef(name = "intCode", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "RN", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "RC", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "BIC", type = BIC.class, required = false),
        @XmlElementRef(name = "NM", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "RB", type = JAXBElement.class, required = false)
    })
    @XmlMixed
    protected List<Object> content;

   public List<Object> getContent() {
        if (content == null) {
            content = new ArrayList<Object>();
        }
        return this.content;
    }

}
