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

public class DomParserTest02 {
	public static void main(String[] args) {
		DocumentBuilderFactory factory = 
				DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder domparser = factory.newDocumentBuilder();
			Document document = 
					domparser.parse("src/openapi/dept.xml");
			//root������Ʈ ���ϱ�
			Element root =  document.getDocumentElement();
			
			//Ư�� ������Ʈ���� �����ؼ� ��带 ����
			NodeList deptlist =  root.getElementsByTagName("dept");
			System.out.println("deptnode�� ����=>"+
											deptlist.getLength());
			for (int i = 0; i < deptlist.getLength(); i++) {
				//NodeList���� �ϳ��� Node�� ����
				Node deptnode = deptlist.item(i);
				System.out.println("����:"+deptnode.getNodeName());
				
				//dept����� ������带 ����
				NodeList deptChildNodelist =
									deptnode.getChildNodes();
				/*System.out.println("dept����� ���� ��� ����=>"+
									deptChildNodelist.getLength());*/
				for (int j = 0; j < deptChildNodelist.getLength();
									j++) {
					Node deptChildNode = deptChildNodelist.item(j);
					System.out.println("dept��������:"+
								deptChildNode.getNodeName());
					System.out.println("dept�����ؽ�Ʈ���:"+
							deptChildNode.getTextContent());
				}
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
