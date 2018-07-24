package json;

import java.io.FileWriter;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

//json��ü�� �����ϴ� ����
/*
 * {} : JSON��ü - JSONObject
 * [] : JSON�迭 - JSONArray
 */
public class JSONMaker_Exam {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws Exception{
		JSONObject myjson = new JSONObject();
		myjson.put("name", "�嵿��");
		myjson.put("age", "25");
		
		JSONArray subjectlist = new JSONArray();
		subjectlist.add("�ڹ�");
		subjectlist.add("�ϵ�");
		subjectlist.add("��ť���ڵ�");
		
		//������ �ۼ��� JSONArray�� JSONObject�� �߰��ϱ�
		myjson.put("subject",subjectlist);
		
		//addr - JSONObject
		JSONObject addobj = new JSONObject();
		addobj.put("zip", "111-222");
		addobj.put("addr1", "��õ��");
		myjson.put("addr", addobj);
		
		//history
		JSONArray historylist = new JSONArray();
		JSONObject history1 = new JSONObject();
		history1.put("subject", "java");
		history1.put("month", "11");
		
		
		JSONObject history2 = new JSONObject();
		history2.put("subject", "servlet");
		history2.put("month", "12");
		
		historylist.add(history1);
		historylist.add(history2);
		
		myjson.put("history", historylist);
		
		//json������ ���� - ����io
		FileWriter fw = new FileWriter("src/json/mydata2.json");
		// JSONObject�� �ؽ�Ʈ�� ��ȯ�Ͽ� FileWriter�� ����
		System.out.println(myjson.toJSONString());
		
		fw.write(myjson.toJSONString());
		fw.flush();
		fw.close();
	
	}

}
