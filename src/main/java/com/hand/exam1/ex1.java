package com.hand.exam1;



import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class ex1{

	public static void main(String[] args) {
		new ReadByPost().start();
	}

}

class ReadByPost extends Thread{
	@Override
	public void run() {
		try {



			URL url = new URL("http://www.manning.com/gsmith/SampleChapter1.pdf");

			URLConnection conn = url.openConnection();
			InputStream is=conn.getInputStream();
			InputStreamReader isr = new InputStreamReader(is,"utf-8");
			BufferedReader br = new BufferedReader(isr);
			
			FileOutputStream fos = new FileOutputStream("test.pdf");
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			
			
			
			byte input[] = new byte[10000];
			String line;
			StringBuffer builder = new StringBuffer();
			while ((line=br.readLine())!=null) {
//				builder.append(line);
				bos.write(input);

			}
            bos.flush();
			br.close();
			isr.close();
			is.close();
//			System.out.println(builder.toString());



		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}



}
