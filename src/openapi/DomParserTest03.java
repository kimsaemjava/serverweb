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
				System.out.print((i+1)+"�� ���,");
				System.out.print("����:"+dept.getNodeName());
				//dept����� �Ӽ��� ����
				//�Ӽ��� �Ӽ���� �Ӽ����� ���� �����ؾ� �ϹǷ� Map���� ����
				//deptnode�� ��� �Ӽ��� ����
				NamedNodeMap attributeMap =  dept.getAttributes();
				System.out.print(",dept����� �Ӽ��� ����=>"
							+attributeMap.getLength());
				
				//dept����� 0��° �Ӽ���� ���� ���
				//���Ӽ��� ���� �ڵ��۾��� �Ϸ��� for���� �̿��ؼ� Ž��
				//attribute�� �ϳ��� ���� ����
				Node attributeNode =  attributeMap.item(0);
				System.out.print(",�Ӽ���:"+
								attributeNode.getNodeName());
				System.out.print(",�Ӽ���:"+
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
