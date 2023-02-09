package pl.gruchotki.invoicesIntegrator.dto;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
//import pl.invoicesIntegrator.Faktury;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class InvoiceDTOWithParsedXML {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
//        List<ItemDtoRequest> invoices = parseInvoicesXML();


        File xmlFile = new File("src/main/resources/input.xml");

        XmlMapper xmlMapper = (XmlMapper) new XmlMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                .configure(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT, true);
        
//        Faktury fakturyType = xmlMapper.readValue(xmlFile, Faktury.class);
    }

    private static List<ItemDtoRequest> parseInvoicesXML() throws ParserConfigurationException, SAXException, IOException {
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
}
