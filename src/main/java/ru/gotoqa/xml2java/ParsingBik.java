package ru.gotoqa.xml2java;


import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

/**
 * @author Muflikhunov Roman
 */
public class ParsingBik {
    public static void main(String[] args) throws JAXBException {
        File file = new File("D:\\JAVA\\Java_SRC\\CreditOrgInfoProject\\src\\main\\java\\ru\\gotoqa\\xml2java\\bik.xml");
        JAXBContext jaxbContext = JAXBContext.newInstance(Envelope.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        Envelope product = (Envelope) unmarshaller.unmarshal(file);

        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(product, System.out);

    }
}
