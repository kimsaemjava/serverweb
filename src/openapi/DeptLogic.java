package openapi;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;
//dao의 역할
public class DeptLogic {
	public ArrayList<XMLDeptDTO> getDeptListPull(){
		ArrayList<XMLDeptDTO> deptlist = 
				new ArrayList<XMLDeptDTO>();
		try {
			XmlPullParserFactory factory = 
								XmlPullParserFactory.newInstance();
			XmlPullParser pullparser = factory.newPullParser();
			BufferedInputStream bis = 
				new BufferedInputStream(
					new FileInputStream("src/openapi/dept.xml"));
			pullparser.setInput(bis, "utf-8");
			int eventType = pullparser.getEventType();
			String tagName = "";
			String code = "";
			String name = "";
			String loc = "";
			String tel = "";
			while(eventType!=XmlPullParser.END_DOCUMENT){
				if(eventType==XmlPullParser.START_TAG){
					tagName = pullparser.getName();//태그명을 셋팅
				}else if(eventType==XmlPullParser.TEXT){
					if(tagName.equals("code") & 
						!pullparser.getText().contains("\n")){
						code = pullparser.getText();
					}else if(tagName.equals("name") & 
						!pullparser.getText().contains("\n")){
						name = pullparser.getText();
					}else if(tagName.equals("loc") & 
						!pullparser.getText().contains("\n")){
						loc = pullparser.getText();
					}else if(tagName.equals("tel") & 
						!pullparser.getText().contains("\n")){
						tel = pullparser.getText();
					}
				}else if(eventType==XmlPullParser.END_TAG){
					tagName = pullparser.getName();//태그명을 다시 셋팅
					if(tagName.equals("dept")){
						XMLDeptDTO dept = 
							new XMLDeptDTO(code, name, loc, tel);
						deptlist.add(dept);
					}
				}
				//다음이벤트로 넘기기
				eventType = pullparser.next();
			}
			
		} catch (XmlPullParserException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return deptlist;
	}
	
	public ArrayList<XMLDeptDTO> getDeptList(){
		ArrayList<XMLDeptDTO> deptlist = 
							new ArrayList<XMLDeptDTO>();
		DocumentBuilderFactory factory = 
				DocumentBuilderFactory.newInstance();
		
		try {
			DocumentBuilder domparser = factory.newDocumentBuilder();
			Document document = 
					domparser.parse("src/openapi/dept.xml");
			Element root =  document.getDocumentElement();
			NodeList deptNodelist = 
								root.getElementsByTagName("dept");
			
			for(int i=0;i<deptNodelist.getLength();i++){
				//dept노드의 하위 노드들 중에서 <code>,<name>,<loc>,<tel>
				//노드의 텍스트값만 추출
				Node deptnode = deptNodelist.item(i);
				String code = getText(deptnode, "code");
				String name = getText(deptnode, "name");
				String loc = getText(deptnode, "loc");
				String tel = getText(deptnode, "tel");
				//각 노드의 값을 추출해서 dto를 생성하고 ArrayList에 추가
				XMLDeptDTO dept = 
						new XMLDeptDTO(code, name, loc, tel);
				deptlist.add(dept);
				
			}
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
		
		return deptlist;
	}
	//노드의 텍스트값을 리턴하는 메소드
	//같은 노드가 없고 같은 패턴으로 반복되면 편하게 사용할 수 있는 방법
	public String getText(Node node,String tagName){
		String data = "";
		Element element = (Element)node;
		Node deptChildNode = 
				element.getElementsByTagName(tagName).item(0);
		data = deptChildNode.getTextContent();
		return data;
	}
}










