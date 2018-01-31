/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bbw.ch.schulweg;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.XMLOutputter;

/**
 *
 *
 * @author Jassimran
 */
public class XMLWriter {
    
    public XMLWriter() {
        //XMLReader xmlreader = new XMLReader();
        //xmlreader.getDataFromXML();

    }

    public void writeDataIntoXML(ArrayList<Person> persons) throws FileNotFoundException, IOException {
        
        Element schulweg = new Element("schulweg");
        Document document = new Document(schulweg);

        for (Person pers : persons) {

            schulweg.addContent(new Element("person")
                    .addContent(new Element("nachname").addContent(pers.getSurname()))
                    .addContent(new Element("vorname").addContent(pers.getName()))
                    .addContent(new Element("abfahrtsOrt").addContent(pers.getDepartureLocation()))
                    .addContent(new Element("ankunftsOrt").addContent(pers.getArrivalLocation())));
        }

        XMLOutputter outputter = new XMLOutputter();
        FileOutputStream output;

        output = new FileOutputStream("schulweg.xml");
        outputter.output(document, output);
        output.close();
    }

    
    
}
