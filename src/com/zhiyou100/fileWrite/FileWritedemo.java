package com.zhiyou100.fileWrite;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import org.apache.coyote.http11.filters.BufferedInputFilter;
import org.junit.Test;

public class FileWritedemo {
	/*
	 * 字符流调用close的时候。会自动调用flush
	 */
	@Test
	public void test01() throws IOException{
		FileWriter fw=new FileWriter("d:/bbb.txt");
		char[] chars={'你','我','h'};
		fw.write(chars);
		fw.write("李得会");
		fw.flush();
	}
	@Test
	public void test02() throws IOException{
		FileReader fr=new FileReader("d:/bbb.txt");
		int read = fr.read();//一次读一个字符
		System.out.println((char)read);
		
		char[] chars=new char[1024];
		int len=0;
		while((len=fr.read(chars))!=-1){
			String st = new String(chars, 0, len);
			System.out.println(st);
		}
		fr.close();
	}
	@Test
	public void test03() throws Exception{
		FileInputStream fis=new FileInputStream("d:/ccc_gbk.txt");
		InputStreamReader isr=new InputStreamReader(fis,"GBK");
		char[] chars=new char[1024];
		int len = 0;
		while((len=isr.read(chars))!=-1){
			String str=new String(chars, 0, len);
			System.out.println(str);
		}
		isr.close();
	}
		/*
		
		FileOutputStream fos=new FileOutputStream("d:/ccc.txt");
		//创建字节转换流
		OutputStreamWriter osw=new OutputStreamWriter(fos, "GBK");
		osw.write("大家好");
		osw.flush();
		osw.close();*/
	@Test
	public void test04() throws Exception{
		FileOutputStream fos= new FileOutputStream("d:/buffer.txt");
		BufferedOutputStream bos=new BufferedOutputStream(fos);
		bos.write("你好".getBytes());
		bos.close();
	}
	@Test
	public void test05() throws Exception{
		FileInputStream fis= new FileInputStream("d:/buffer.txt");
		BufferedInputStream bis=new BufferedInputStream(fis);
		
	}
	@Test
	public void test06() throws Exception{
		/*
		 * BufferedWriter bw=new BufferedWriter(fw);要求传入writer对象
		 * 我么可以传FileWriter，也可以传outPutStreamWriter
		 */
		FileWriter fw=new FileWriter("d:/buffer_writer.txt");
		BufferedWriter bw=new BufferedWriter(fw);
		bw.write("你好");
		bw.newLine();
		bw.write("你不好");
		bw.close();
	}
	@Test
	public void test07() throws Exception{
		FileReader fr=new FileReader("d:/buffer_writer.txt");
		BufferedReader br=new BufferedReader(fr);
		/*String readLine1 = br.readLine();
		String readLine2 = br.readLine();
		String readLine3 = br.readLine();
		System.out.println(readLine1);
		System.out.println(readLine2);
		System.out.println(readLine3);*/
		String content= null;
		while((content = br.readLine())!=null){
			System.out.println(br);
			br.close();
		}
	}
}