package openapi;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DomParserTest03 {
	public static void main(String[] args) {
		DocumentBuilderFactory factory = 
				DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder domparser = factory.newDocumentBuilder();
			Document document = 
					domparser.parse("src/openapi/dept.xml");
			Element root =  document.getDocumentElement();
			NodeList deptlist =  root.getElementsByTagName("dept");
			for (int i = 0; i < deptlist.getLength(); i++) {
				Node dept = deptlist.item(i);
				System.out.print((i+1)+"번 노드,");
				System.out.print("노드명:"+dept.getNodeName());
				//dept노드의 속성을 추출
				//속성은 속성명과 속성값을 같이 저장해야 하므로 Map으로 관리
				//deptnode의 모든 속성을 추출
				NamedNodeMap attributeMap =  dept.getAttributes();
				System.out.print(",dept노드의 속성의 갯수=>"
							+attributeMap.getLength());
				
				//dept노드의 0번째 속성명과 값을 출력
				//모든속성에 대한 자동작업을 하려면 for문을 이용해서 탐색
				//attribute도 하나의 노드로 관리
				Node attributeNode =  attributeMap.item(0);
				System.out.print(",속성명:"+
								attributeNode.getNodeName());
				System.out.print(",속성값:"+
						attributeNode.getNodeValue());
								
				System.out.println();
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
