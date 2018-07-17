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
		//���� URL�� �̿��Ͽ� URL��ü�� ������ �Ŀ� images������ jangImg.jpg�� �����ϼ���.
		// - BufferedInputStream���� �а� FileOutputStream���� ���
		BufferedInputStream bis = null;
		FileOutputStream fos = null;
		URL url;
		try {
			url = new URL(res);
			bis = new BufferedInputStream(url.openStream());
			fos = new FileOutputStream("src/images/jangImg.jpg");
			while(true){
				int data = bis.read();//�ϳ��� �а�
				if(data==-1){
					break;
				}
				fos.write(data);//����
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
