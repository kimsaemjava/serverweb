package openapi;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DomParserTest01 {
	public static void main(String[] args) {
		//parser를 생성해주는 팩토리 객체를 먼저 작성
		DocumentBuilderFactory factory = 
				DocumentBuilderFactory.newInstance();
		try {
			//xml문서를 파싱할 수 있는 dom parser생성
			DocumentBuilder xmlparser = factory.newDocumentBuilder();
			
			//xml문서를 파싱해서 자바에서 사용할 수 있는 객체로 변환 
			//=> xml을 변환해서 생성된 DOM객체
			Document document
				=xmlparser.parse("src/openapi/dept.xml");
			System.out.println(document);
			
			//dom객체로 부터 엘리먼트 반환받기 - xml문서의 root엘리먼트
			Element root =  document.getDocumentElement();
			System.out.println(root);
			System.out.println(root.getTagName());
			System.out.println(root.getFirstChild());
			System.out.println(root.getLastChild());
			
			NodeList nodelist =  root.getChildNodes();
			System.out.println("자식객체의 사이즈=>"+nodelist.getLength());
			int size = nodelist.getLength();
			for (int i = 0; i <size; i++) {
				Node node = nodelist.item(i);
				System.out.println("노드네임:"+node.getNodeName());
			}
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}







