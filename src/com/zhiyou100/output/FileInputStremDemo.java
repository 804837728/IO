package com.zhiyou100.output;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import org.junit.Test;

public class FileInputStremDemo {

	@Test
	public void test01() throws Exception{
		File file=new File("d:/aaa.txt");
		/*FileOutputStream file1=new FileOutputStream(file);
		file1.write(100);*/
		FileInputStream fis=new FileInputStream(file);
		int len=0;
		while((len=fis.read())!=-1){
			System.out.println((char)len);
		}
		fis.close();
	}
	@Test
	public void test02() throws Exception{
		File file=new File("d:/aaa.txt");
		FileInputStream fis=new FileInputStream(file);
		byte[] bs=new byte[2];
		int len=0;
		while((len=fis.read(bs))!=-1){
			String str=new String(bs, 0, len);
			System.out.println(str);
		}
	}
	@Test
	public void test03() throws Exception{
		FileOutputStream file=new FileOutputStream("d:/bbb.txt");
		OutputStreamWriter osw=new OutputStreamWriter(file, "gbk");
	}
	@Test
	public void test04() throws Exception{
		FileInputStream file=new FileInputStream("d:/bbb.txt");
		InputStreamReader osw=new InputStreamReader(file, "gbk");
	}
}
