package openapi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class OpenAPIPharmacyTest01 {
	public static void main(String[] args) throws IOException{
			StringBuilder urlBuilder = 
					new StringBuilder("http://apis.data.go.kr/B551182/pharmacyInfoService/getParmacyBasisList"); /*URL*/
	        urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + "=rtXyzvtNloEBJC0rtjlfRgr026JEgjNKDhOh%2F5VjvhYppyhbkbcuYDCxa7MDv1Ooc%2BuPCEezvaYRDHcEPls%2B6w%3D%3D"); /*Service Key*/
	        urlBuilder.append("&" + URLEncoder.encode("ServiceKey","UTF-8") + "=" + URLEncoder.encode("-", "UTF-8")); /*����Ű*/
	        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*������ ��ȣ*/
	        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("10", "UTF-8")); /*�� ������ ��� ��*/
	        urlBuilder.append("&" + URLEncoder.encode("sidoCd","UTF-8") + "=" + URLEncoder.encode("110000", "UTF-8")); /*�õ��ڵ�*/
	        urlBuilder.append("&" + URLEncoder.encode("sgguCd","UTF-8") + "=" + URLEncoder.encode("110019", "UTF-8")); /*�ñ����ڵ�*/
	        urlBuilder.append("&" + URLEncoder.encode("emdongNm","UTF-8") + "=" + URLEncoder.encode("�ų���", "UTF-8")); /*���鵿��*/
	        urlBuilder.append("&" + URLEncoder.encode("yadmNm","UTF-8") + "=" + URLEncoder.encode("�´����ǰ�", "UTF-8")); /*������*/
	        urlBuilder.append("&" + URLEncoder.encode("xPos","UTF-8") + "=" + URLEncoder.encode("127.0965441345503", "UTF-8")); /*x��ǥ*/
	        urlBuilder.append("&" + URLEncoder.encode("yPos","UTF-8") + "=" + URLEncoder.encode("37.60765568913871", "UTF-8")); /*y��ǥ*/
	        urlBuilder.append("&" + URLEncoder.encode("radius","UTF-8") + "=" + URLEncoder.encode("3000", "UTF-8")); /*�ݰ�*/
	        URL url = new URL(urlBuilder.toString());
	        HttpURLConnection conn = 
	        		(HttpURLConnection) url.openConnection();
	        conn.setRequestMethod("GET");
	        conn.setRequestProperty("Content-type",
	        		"application/json");
	        System.out.println("Response code: " 
	        		+ conn.getResponseCode());
	        BufferedReader rd;
	        if(conn.getResponseCode() >= 200 && 
	        		conn.getResponseCode() <= 300) {
	            rd = new BufferedReader(
	            		new InputStreamReader(
	            				conn.getInputStream()));
	        } else {
	            rd = new BufferedReader(
	            		new InputStreamReader(
	            				conn.getErrorStream()));
	        }
	        StringBuilder sb = new StringBuilder();
	        String line;
	        while ((line = rd.readLine()) != null) {
	            sb.append(line);
	        }
	        rd.close();
	        conn.disconnect();
	        System.out.println(sb.toString());
	    }
	}
