package ru.gotoqa;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;

import javax.sql.DataSource;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.soap.*;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Muflikhunov Roman
 */

public class CreditOrgInfoClient {
    static final String INSERT_QUERY = "INSERT INTO biclist (id, bic, rc, nm, rb, rn, intcode) VALUES (:id, :bic, :rc, :nm, :rb, :rn, :intcode)";

    public static void main(String args[]) {
        String soapEndpointUrl = "http://www.cbr.ru/CreditInfoWebServ/CreditOrgInfo.asmx";
        String soapAction = "http://web.cbr.ru/EnumBIC_XML";
        callSoapWebService(soapEndpointUrl, soapAction);
    }

    private static void createSoapEnvelope(SOAPMessage soapMessage) throws SOAPException {
        SOAPPart soapPart = soapMessage.getSOAPPart();

        String myNamespace = "s";
        String myNamespaceURI = "http://www.cbr.ru/";

        // SOAP Envelope
        SOAPEnvelope envelope = soapPart.getEnvelope();
        envelope.addNamespaceDeclaration(myNamespace, myNamespaceURI);

    }

    private static String log(SOAPMessage message) throws SOAPException, IOException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        message.writeTo(out);
        return out.toString();
    }

    private static void callSoapWebService(String soapEndpointUrl, String soapAction) {
        try {
            ClassPathXmlApplicationContext contextdb = new ClassPathXmlApplicationContext("db.xml");
            NamedParameterJdbcTemplate nqu = new NamedParameterJdbcTemplate(contextdb.getBean(DataSource.class));

            // Create SOAP Connection
            SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
            SOAPConnection soapConnection = soapConnectionFactory.createConnection();

            // Send SOAP Message to SOAP Server
            SOAPMessage soapResponse = soapConnection.call(createSOAPRequest(soapAction), soapEndpointUrl);

            // Print the SOAP Response
            System.out.println("Response SOAP Message:");
            soapResponse.writeTo(System.out);
            System.out.println();

            String xmlString = log(soapResponse);

            try {
                DocumentBuilderFactory dbf =
                        DocumentBuilderFactory.newInstance();
                DocumentBuilder db = dbf.newDocumentBuilder();
                InputSource is = new InputSource();
                is.setCharacterStream(new StringReader(xmlString));

                Document doc = db.parse(is);

                // Create XPathFactory object
                XPathFactory xpathFactory = XPathFactory.newInstance();

                // Create XPath object
                XPath xpath = xpathFactory.newXPath();

                int i;
                for (i = 1; i < 10; i++) {
                    XPathExpression expr =
                            xpath.compile("//*[local-name()='BIC'][" + i + "]" + "//*[local-name()='BIC'][\" +i+ \"]");
                    String nodes = (String) expr.evaluate(doc, XPathConstants.STRING);

                    XPathExpression expr2 =
                            xpath.compile("//*[local-name()='BIC'][" + i + "]" + "//*[local-name()='RC'][\" +i+ \"]");
                    String nodes2 = (String) expr2.evaluate(doc, XPathConstants.STRING);

                    XPathExpression expr3 =
                            xpath.compile("//*[local-name()='BIC'][" + i + "]" + "//*[local-name()='NM'][\" +i+ \"]");
                    String nodes3 = (String) expr3.evaluate(doc, XPathConstants.STRING);

                    XPathExpression expr4 =
                            xpath.compile("//*[local-name()='BIC'][" + i + "]" + "//*[local-name()='RB'][\" +i+ \"]");
                    String nodes4 = (String) expr4.evaluate(doc, XPathConstants.STRING);

                    XPathExpression expr5 =
                            xpath.compile("//*[local-name()='BIC'][" + i + "]" + "//*[local-name()='RN'][\" +i+ \"]");
                    String nodes5 = (String) expr5.evaluate(doc, XPathConstants.STRING);

                    XPathExpression expr6 =
                            xpath.compile("//*[local-name()='BIC'][" + i + "]" + "//*[local-name()='intCode'][\" +i+ \"]");
                    String nodes6 = (String) expr6.evaluate(doc, XPathConstants.STRING);

                    // Creating map with all required params
                    //(:id, :bic, :rc, :nm, :rb, :rn, :intcode)
                    Map<String, Object> paramMap = new HashMap<String, Object>();
                    paramMap.put("id", i);
                    paramMap.put("bic", nodes);
                    paramMap.put("rc", nodes2);
                    paramMap.put("nm", nodes3);
                    paramMap.put("rb", nodes4);
                    paramMap.put("rn", nodes5);
                    paramMap.put("intcode", nodes6);

                    // Passing map containing named params
                    //nqu.update(INSERT_QUERY, paramMap);
                    System.out.println("BIC: " + nodes + "; " + "NM: " + nodes3);
                }

            } catch (ParserConfigurationException | IOException e) {
                e.printStackTrace();
            }
            soapConnection.close();
        } catch (Exception e) {
            System.err.println("Error SOAP");
            e.printStackTrace();
        }
    }

    private static SOAPMessage createSOAPRequest(String soapAction) throws Exception {
        MessageFactory messageFactory = MessageFactory.newInstance();
        SOAPMessage soapMessage = messageFactory.createMessage();

        createSoapEnvelope(soapMessage);

        MimeHeaders headers = soapMessage.getMimeHeaders();
        headers.addHeader("SOAPAction", soapAction);

        soapMessage.saveChanges();
        return soapMessage;
    }

}