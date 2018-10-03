
package ru.gotoqa.xml2java;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", namespace = "http://web.cbr.ru/", propOrder = {
    "bic"
})
public class EnumBIC {

    @XmlElement(name = "BIC", required = true)
    protected List<BIC> bic;


    public List<BIC> getBIC() {
        if (bic == null) {
            bic = new ArrayList<BIC>();
        }
        return this.bic;
    }

}
