package openapi;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class OpenAPIPharmacyTest02 {
	public static void main(String[] args) throws IOException{
			/*StringBuilder urlBuilder = 
					new StringBuilder("http://apis.data.go.kr/B551182/pharmacyInfoService/getParmacyBasisList"); URL
	        urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + "=rtXyzvtNloEBJC0rtjlfRgr026JEgjNKDhOh%2F5VjvhYppyhbkbcuYDCxa7MDv1Ooc%2BuPCEezvaYRDHcEPls%2B6w%3D%3D"); *//*Service Key*/
		DocumentBuilderFactory factory = 
				DocumentBuilderFactory.newInstance();
		try {
			String pharmurl="http://apis.data.go.kr/B551182/pharmacyInfoService/getParmacyBasisList";
			String key = "rtXyzvtNloEBJC0rtjlfRgr026JEgjNKDhOh%2F5VjvhYppyhbkbcuYDCxa7MDv1Ooc%2BuPCEezvaYRDHcEPls%2B6w%3D%3D";
			String realUrl = pharmurl+"?ServiceKey="+key;
			
			DocumentBuilder domparser = 
							factory.newDocumentBuilder();
			URL url = new URL(realUrl);
			BufferedInputStream bis =
					new BufferedInputStream(url.openStream());
			Document document =  domparser.parse(bis);

			//root엘리먼트 구하기
			Element root =  document.getDocumentElement();
			NodeList list =  root.getElementsByTagName("item");
			System.out.println(list.getLength());
			
			for(int i=0;i<list.getLength();i++){
				Node node = list.item(i);//<item>엘리먼트와 하위엘리먼트 모두 추출
				NodeList childlist =  node.getChildNodes();
				for(int j=0;j<childlist.getLength();j++){
					Node childNode = childlist.item(j);
					System.out.print(childNode.getNodeName()+":");
					System.out.println(childNode.getTextContent());
					
				}
				System.out.println();
			}
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		}
	   
	}
}
