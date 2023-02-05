package pl.gruchotki.invoicesIntegrator.dto;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ItemDtoWithParsedXML {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        List<InvoiceDtoRequest> invoices = parseInvoicesXML();
    }

    private static List<InvoiceDtoRequest> parseInvoicesXML() throws ParserConfigurationException, SAXException, IOException {
        File xmlFile = new File("src/main/resources/input.xml");

        List<InvoiceDtoRequest> invoices = new ArrayList<>();
        InvoiceDtoRequest invoice;

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(xmlFile);
        document.getDocumentElement().normalize();

        NodeList nList = document.getElementsByTagName("faktura");
        for (int temp = 0; temp < nList.getLength(); temp++) {
            Node node = nList.item(temp);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) node;

                invoice = new InvoiceDtoRequest();
                invoice.setPayment(Double.parseDouble(eElement.getElementsByTagName("Zaplacono").item(0).getTextContent()));
                invoice.setPaymentOnDocument(Double.parseDouble(eElement.getElementsByTagName("Zaplacono").item(0).getTextContent()));
                invoice.setIssueDate(LocalDate.parse(eElement.getElementsByTagName("DataWystawienia").item(0).getTextContent()));
                invoice.setPaymentDate(LocalDate.parse(eElement.getElementsByTagName("TerminPlatnosci").item(0).getTextContent()));
                invoice.setSaleDate(LocalDate.parse(eElement.getElementsByTagName("DataSprzedazy").item(0).getTextContent()));
                invoice.setPaymentType(eElement.getElementsByTagName("MetodaPlatnosci").item(0).getTextContent());
                invoice.setNumberingSeriesName(eElement.getElementsByTagName("NumerDokumentu").item(0).getTextContent());
                invoice.setTemplateName(eElement.getElementsByTagName("NumerDokumentu").item(0).getTextContent());
                invoice.setComments(eElement.getElementsByTagName("ListPrzewozowy").item(0).getTextContent());
                invoice.setNumber(eElement.getElementsByTagName("NumerDokumentu").item(0).getTextContent());
                invoice.setBuyerNip(eElement.getElementsByTagName("NIP").item(0).getTextContent());
                invoice.setName(eElement.getElementsByTagName("Nazwa").item(0).getTextContent());
                invoice.setNip(eElement.getElementsByTagName("NIP").item(0).getTextContent());
                invoice.setStreet(eElement.getElementsByTagName("Adres").item(0).getTextContent());
                invoice.setPostalCode(eElement.getElementsByTagName("KodPocztowy").item(0).getTextContent());
                invoice.setCity(eElement.getElementsByTagName("Miasto").item(0).getTextContent());

                invoices.add(invoice);
            }
        }
        return invoices;
    }
}
