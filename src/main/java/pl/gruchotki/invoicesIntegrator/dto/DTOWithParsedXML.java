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
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DTOWithParsedXML {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        List<InvoiceDtoRequest> invoices = parseInvoicesXML();
        List<ItemDtoRequest> items = parseItemsXML();
        List<ClientDtoRequest> clients = parseClientsXML();

        System.out.println(invoices.size());
        System.out.println(items.size());
        System.out.println(clients.size());

//        File xmlFile = new File("src/main/resources/input.xml");
//
//        XmlMapper xmlMapper = (XmlMapper) new XmlMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
//                .configure(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT, true);
//
//        Faktura fakturyType = xmlMapper.readValue(xmlFile, Faktura.class);
//
//        System.out.println(fakturyType.getDataSprzedazy());
    }

    private static List<InvoiceDtoRequest> parseInvoicesXML()
            throws ParserConfigurationException, SAXException, IOException {
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
                invoice.setNumber(document.getElementsByTagName("NumerDokumentu").item(0).getTextContent());
                invoice.setPayment(new BigDecimal(eElement.getElementsByTagName("Zaplacono").item(0).getTextContent()));
                invoice.setPaymentOnDocument(new BigDecimal(eElement.getElementsByTagName("Wartosc").item(0).getTextContent()));
                invoice.setIssueDate(LocalDate.parse(eElement.getElementsByTagName("DataWystawienia").item(0).getTextContent()));
                invoice.setPaymentDate(LocalDate.parse(eElement.getElementsByTagName("TerminPlatnosci").item(0).getTextContent()));
                invoice.setSaleDate(LocalDate.parse(eElement.getElementsByTagName("DataSprzedazy").item(0).getTextContent()));
                invoice.setPaymentType("ELE");
                invoice.setNumberingSeriesName("default");
                invoice.setTemplateName("xxx");
                invoice.setComments(eElement.getElementsByTagName("DodatkoweInformacje").item(0).getTextContent() + " " +
                        eElement.getElementsByTagName("ListPrzewozowy").item(0).getTextContent());
                invoices.add(invoice);
            }
        }
        return invoices;
    }

    private static List<ItemDtoRequest> parseItemsXML() throws ParserConfigurationException, SAXException, IOException {
        File xmlFile = new File("src/main/resources/input.xml");

        List<ItemDtoRequest> items = new ArrayList<>();
        ItemDtoRequest item;

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(xmlFile);
        document.getDocumentElement().normalize();

        NodeList nList = document.getElementsByTagName("Produkt");
        for (int temp = 0; temp < nList.getLength(); temp++) {
            Node node = nList.item(temp);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) node;

                item = new ItemDtoRequest();

                item.setNumber(document.getElementsByTagName("NumerDokumentu").item(0).getTextContent());
                item.setVatRate(Double.parseDouble(eElement.getElementsByTagName("VAT").item(0).getTextContent()));
                item.setQuantity(Integer.parseInt(eElement.getElementsByTagName("Ilosc").item(0).getTextContent().replaceAll("\\..*", "")));
                item.setUnitPrice(Double.parseDouble(eElement.getElementsByTagName("CenaNetto").item(0).getTextContent()));
                item.setFullName(eElement.getElementsByTagName("Nazwa").item(0).getTextContent());

                items.add(item);
            }
        }
        return items;

    }

    private static List<ClientDtoRequest> parseClientsXML()
            throws ParserConfigurationException, SAXException, IOException {
        File xmlFile = new File("src/main/resources/input.xml");

        List<ClientDtoRequest> clients = new ArrayList<>();
        ClientDtoRequest client;

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(xmlFile);
        document.getDocumentElement().normalize();

        NodeList nList = document.getElementsByTagName("faktura");
        for (int temp = 0; temp < nList.getLength(); temp++) {
            Node node = nList.item(temp);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) node;

                client = new ClientDtoRequest();

                client.setNumber(document.getElementsByTagName("NumerDokumentu").item(0).getTextContent());
                client.setBuyerNip(eElement.getElementsByTagName("NIP").item(0).getTextContent());
                client.setName(eElement.getElementsByTagName("Nazwa").item(0).getTextContent());
                client.setNip(eElement.getElementsByTagName("NIP").item(0).getTextContent());
                client.setStreet(eElement.getElementsByTagName("Adres").item(0).getTextContent());
                client.setPostalCode(eElement.getElementsByTagName("KodPocztowy").item(0).getTextContent());
                client.setCity(eElement.getElementsByTagName("Miasto").item(0).getTextContent());
                clients.add(client);
            }
        }
        return clients;
    }
}
