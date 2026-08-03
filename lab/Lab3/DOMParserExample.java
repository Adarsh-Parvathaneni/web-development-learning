import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.io.File;
public class DOMParserExample{
    public static void main(String[] args){
        try{
            File xmlFile=new File("students.xml");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(xmlFile);
            document.getDocumentElement().normalize();
            System.out.println("Root Element: "+ document.getDocumentElement().getNodeName());
            
            NodeList nodeList = document.getElementsByTagName("student");
            for(int i = 0;i<nodeList.getLength();i++){
                Node node = nodeList.item(i);
                if(node.getNodeType() == Node.ELEMENT_NODE){
                    Element element = (Element)node;
                    System.out.println("\nStudent"+(i+1));
                    System.out.println("ID:"+element.getElementsByTagName("id").item(0).getTextContent());
                    System.out.println("Name:"+element.getElementsByTagName("name").item(0).getTextContent());
                    System.out.println("Branch:"+element.getElementsByTagName("branch").item(0).getTextContent());
                    System.out.println("Semester:"+element.getElementsByTagName("semester").item(0).getTextContent());
                }
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
