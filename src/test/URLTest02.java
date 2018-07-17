package test;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class URLTest02 {
	public static void main(String[] args) {
		String res =
			"http://imgnews.naver.com/image/144/2009/10/20/20091020001012_r.jpg";
		//위의 URL을 이용하여 URL객체를 생성한 후에 images폴더에 jangImg.jpg로 저장하세요.
		// - BufferedInputStream으로 읽고 FileOutputStream으로 출력
		BufferedInputStream bis = null;
		FileOutputStream fos = null;
		URL url;
		try {
			url = new URL(res);
			bis = new BufferedInputStream(url.openStream());
			fos = new FileOutputStream("src/images/jangImg.jpg");
			while(true){
				int data = bis.read();//하나씩 읽고
				if(data==-1){
					break;
				}
				fos.write(data);//쓰기
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) { 
			e.printStackTrace();
		} finally{
			try {
				if(fos!=null)fos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
