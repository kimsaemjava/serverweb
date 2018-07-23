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
			//1. 파서를 factory를 통해서 생성
			XmlPullParserFactory factory = 
							XmlPullParserFactory.newInstance();
			//2. 파서 생성
			XmlPullParser pullparser = factory.newPullParser();
			//3. 파싱할 문서를 지정
			//   - 원격 : URL을 이용
			//   - 로컬 : BufferedInputStream
			BufferedInputStream bis = 
				new BufferedInputStream(
					new FileInputStream("src/openapi/dept.xml"));
			//4. pullparser에 스트림으로 넘겨준다.
			pullparser.setInput(bis, "euc-kr");
			//5. 각각의 이벤트에 반응할 수 있도록 코드를 작성
			//   이벤트를  구분할 수 있는 상수가 존재하며 이 상수를 저장할 수 있는 변수가 필요
			int eventType = pullparser.getEventType();
			
			//6. xml문서를 읽으면서 각각의 상황에 맞게 이벤트가 발생하면 처리할 수 있도록 작업
			//   XmlPullParser.END_DOCUMENT가 xml문서의 끝을 의미하는 상수
			while(eventType!=XmlPullParser.END_DOCUMENT){
				//각각의 이벤트에 따라 다르게 동작할 수 있도록 작업
				switch (eventType) {
					case XmlPullParser.START_DOCUMENT://xml문서의 시작
						System.out.println("START_DOCUMENT");
						break;
					case XmlPullParser.START_TAG://태그의 시작 <태그명>
						System.out.println("START_TAG");
						break;
					case XmlPullParser.END_TAG://태그의 끝</태그명>
						System.out.println("END_TAG");
						break;
					case XmlPullParser.TEXT://텍스트를 읽었을때
						System.out.println("TEXT");
						break;
					case XmlPullParser.END_DOCUMENT://xml문서의 종료
						System.out.println("END_DOCUMENT");
						break;	
				}
				//다음 이벤트로 넘기기
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
