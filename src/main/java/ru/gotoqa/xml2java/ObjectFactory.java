
package ru.gotoqa.xml2java;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;
import java.math.BigInteger;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the mypackage package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _RB_QNAME = new QName("", "RB");
    private final static QName _RC_QNAME = new QName("", "RC");
    private final static QName _IntCode_QNAME = new QName("", "intCode");
    private final static QName _RN_QNAME = new QName("", "RN");
    private final static QName _NM_QNAME = new QName("", "NM");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: mypackage
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link EnumBIC }
     * 
     */
    public EnumBIC createEnumBIC() {
        return new EnumBIC();
    }

    /**
     * Create an instance of {@link BIC }
     *
     */
    public BIC createBIC() {
        return new BIC();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "RB")
    public JAXBElement<BigInteger> createRB(BigInteger value) {
        return new JAXBElement<BigInteger>(_RB_QNAME, BigInteger.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "RC")
    public JAXBElement<XMLGregorianCalendar> createRC(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_RC_QNAME, XMLGregorianCalendar.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "intCode")
    public JAXBElement<BigInteger> createIntCode(BigInteger value) {
        return new JAXBElement<BigInteger>(_IntCode_QNAME, BigInteger.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "RN")
    public JAXBElement<BigInteger> createRN(BigInteger value) {
        return new JAXBElement<BigInteger>(_RN_QNAME, BigInteger.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "NM")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    public JAXBElement<String> createNM(String value) {
        return new JAXBElement<String>(_NM_QNAME, String.class, null, value);
    }

}
