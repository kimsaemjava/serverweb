package openapi;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

public class XmlPullParserTest01 {
	public static void main(String[] args) {
		try {
			//1. �ļ��� factory�� ���ؼ� ����
			XmlPullParserFactory factory = 
							XmlPullParserFactory.newInstance();
			//2. �ļ� ����
			XmlPullParser pullparser = factory.newPullParser();
			//3. �Ľ��� ������ ����
			//   - ���� : URL�� �̿�
			//   - ���� : BufferedInputStream
			BufferedInputStream bis = 
				new BufferedInputStream(
					new FileInputStream("src/openapi/dept.xml"));
			//4. pullparser�� ��Ʈ������ �Ѱ��ش�.
			pullparser.setInput(bis, "euc-kr");
			//5. ������ �̺�Ʈ�� ������ �� �ֵ��� �ڵ带 �ۼ�
			//   �̺�Ʈ��  ������ �� �ִ� ����� �����ϸ� �� ����� ������ �� �ִ� ������ �ʿ�
			int eventType = pullparser.getEventType();
			
			//6. xml������ �����鼭 ������ ��Ȳ�� �°� �̺�Ʈ�� �߻��ϸ� ó���� �� �ֵ��� �۾�
			//   XmlPullParser.END_DOCUMENT�� xml������ ���� �ǹ��ϴ� ���
			while(eventType!=XmlPullParser.END_DOCUMENT){
				//������ �̺�Ʈ�� ���� �ٸ��� ������ �� �ֵ��� �۾�
				switch (eventType) {
					case XmlPullParser.START_DOCUMENT://xml������ ����
						System.out.println("START_DOCUMENT");
						break;
					case XmlPullParser.START_TAG://�±��� ���� <�±׸�>
						System.out.println("START_TAG");
						break;
					case XmlPullParser.END_TAG://�±��� ��</�±׸�>
						System.out.println("END_TAG");
						break;
					case XmlPullParser.TEXT://�ؽ�Ʈ�� �о�����
						System.out.println("TEXT");
						break;
					case XmlPullParser.END_DOCUMENT://xml������ ����
						System.out.println("END_DOCUMENT");
						break;	
				}
				//���� �̺�Ʈ�� �ѱ��
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
