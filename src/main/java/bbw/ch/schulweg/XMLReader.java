/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bbw.ch.schulweg;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Element;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author Jassimran und Eduard
 */
public class XMLReader {

    private Document docu;
    private String filename;
    private Person p;

    public XMLReader() {
        filename = "gooo.xml";
        p = new Person();
    }

    public Person getP() {
        return p;
    }
    
    private String getValueOfSingleChild(Element elem, String tagName) {
        NodeList childList = elem.getElementsByTagName(tagName);
        if (childList != null && childList.getLength() > 0) {
            return childList.item(0).getTextContent();
        }
        return "";
    }

    public void getDataFromXML() {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        try {
            builder = factory.newDocumentBuilder();
            docu = (Document) builder.parse(new File(filename));
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(XMLReader.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(XMLReader.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(XMLReader.class.getName()).log(Level.SEVERE, null, ex);
        }

        NodeList nList = docu.getElementsByTagName("person");
        for (int i = 0; i < nList.getLength(); i++) {
            Element elem = (Element) nList.item(i);
            p.getPersonList().add(new Person(getValueOfSingleChild(elem, "nachname"), 
                                    getValueOfSingleChild(elem, "vorname"), 
                                    getValueOfSingleChild(elem, "abfahrtsort"), 
                                    getValueOfSingleChild(elem, "ankunftsOrt")));
        }
    }
    
  public static void main(String[] args)  {
       
        XMLReader r = new XMLReader();
        r.getDataFromXML();
        System.out.println(r.getP().getPersonList().size());
         XMLWriter w = new XMLWriter();
        try {
            w.writeDataIntoXML(r.getP().getPersonList());
            System.out.println("es schreibt");
        } catch (IOException ex) {
            Logger.getLogger(XMLReader.class.getName()).log(Level.SEVERE, null, ex);
        }

    }


}
