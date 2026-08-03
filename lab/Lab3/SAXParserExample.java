
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.io.File;
public class SAXParserExample {
        
    public static void main(String[] args) {

        try {
            File inputFile = new File("input.xml");
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            DefaultHandler handler = new DefaultHandler() {

                boolean id = false;
                boolean name = false;
                boolean branch = false;
                boolean semester = false;

                public void startElement(String uri, String localName, String qName, Attributes attributes) {
                    if (qName.equalsIgnoreCase("id")) {
                        id = true;
                    }
                    if (qName.equalsIgnoreCase("name")) {
                        name = true;
                    }
                    if (qName.equalsIgnoreCase("branch")) {
                        branch = true;
                    }
                    if (qName.equalsIgnoreCase("semester")) {
                        semester = true;
                    }
                }

                public void characters(char ch[], int start, int length) {
                    if (id) {
                        System.out.println("ID: " + new String(ch, start, length));
                        id = false;
                    }
                    if (name) {
                        System.out.println("Name: " + new String(ch, start, length));
                        name = false;
                    }
                    if (branch) {
                        System.out.println("Branch: " + new String(ch, start, length));
                        branch = false;
                    }
                    if (semester) {
                        System.out.println("Semester: " + new String(ch, start, length));
                        semester = false;
                        System.out.println("");
                    }
                }
            };
            saxParser.parse(inputFile, handler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
