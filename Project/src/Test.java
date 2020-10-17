package src;


import java.io.File;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

public class Test {

    public static void main(String[] args){

        String fileName = null;
        switch (args.length){
        case 1:
            fileName = "src/xmlFiles/" + args[0];
            break;
        default:
            System.out.println("java Test <xmlfilename>");
        return;
        }

        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        try{
            SAXParser saxParser = saxParserFactory.newSAXParser();
            DungeonXMLHandler handler = new DungeonXMLHandler();
            saxParser.parse(new File(fileName), handler);

        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace(System.out);
        }
    }
}