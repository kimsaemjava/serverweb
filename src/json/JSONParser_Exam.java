package json;

import java.io.FileReader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/*
 * .json파일을 JSONArray나 JSONObject로 변환
 * JSON파서 - JSONParser(json-simple.jar라이브러리내에서) 
 */
public class JSONParser_Exam {
	public static void main(String[] args) throws Exception{
		//1. JSONParser를 생성
		JSONParser parser = new JSONParser();
		//2. json파싱하기
		JSONObject root = 
				(JSONObject)parser.parse(
						new FileReader("src/json/mydata2.json"));
		
		//3. JSONObject에서 데이터 읽기
		String name = (String)root.get("name");
		String age = (String)root.get("age");
		System.out.println("name:"+name);
		System.out.println("age:"+age);
		
		//4. JSONArray에서 데이터읽기
		JSONArray subjectlist = (JSONArray)root.get("subject");
		
		
		for (int i = 0; i <subjectlist.size(); i++) {
			String subject = (String)subjectlist.get(i);
			System.out.println("Subject:"+subject);
		}
		
		
		//5. addr
		JSONObject addr = (JSONObject)root.get("addr");
		String zip = (String)addr.get("zip");
		String addr1 = (String)addr.get("addr1");
		System.out.println("zip:"+zip);
		System.out.println("addr:"+addr1);
		
		//6. history
		JSONArray historylist = (JSONArray)root.get("history");
		for (int i = 0; i < historylist.size(); i++) {
			JSONObject history = (JSONObject)historylist.get(i);
			System.out.println("subject:"+history.get("subject"));
			System.out.println("month:"+history.get("month"));
		}
	}
}









