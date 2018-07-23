package openapi;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

public class XmlPullParserTest02 {
	public static void main(String[] args) {
		try {
			XmlPullParserFactory factory = 
							XmlPullParserFactory.newInstance();
			XmlPullParser pullparser = factory.newPullParser();
			BufferedInputStream bis = 
				new BufferedInputStream(
					new FileInputStream("src/openapi/dept.xml"));
			pullparser.setInput(bis, "utf-8");
			int eventType = pullparser.getEventType();
			while(eventType!=XmlPullParser.END_DOCUMENT){
				if(eventType== XmlPullParser.START_TAG){
					//�±װ� �����϶� �±׸��� ����
					System.out.println("�±׸�:"+
								pullparser.getName());
				}else if(eventType==XmlPullParser.TEXT){
					String text = pullparser.getText();
					if(!text.contains("\n")){
						System.out.println("���ڿ�:"+text);
					}
				}
				eventType = pullparser.next();
			}
			
			
		} catch (XmlPullParserException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		

	}

}
