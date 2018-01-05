package com.zhiyou100.output;


import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.junit.Test;

public class FileOutputStreamDemo {

	@Test
	public void test01() throws Exception{
		FileOutputStream fos=new FileOutputStream("d:/aaa.txt");
//		fos.write(100);//ASCII码值
		/*byte[] content={97,98,99,100};
		fos.write(content,2,2);*/
		fos.write("good good study".getBytes());//字符串转字节
		fos.close();
	}
	/*
	 * read()--->每次读一个字节，该方法的返回值就是读取内容
	 */
	@Test
	public void test02() throws Exception{
		FileInputStream fis=new FileInputStream("d:/aaa.txt");
		/*int read = fis.read();
		System.out.println((char)read);*/
		byte[] cont =new byte[1024];
		fis.close();
		/*while(true){
			int len = fis.read(cont);
			if(len==-1){
				break;
			}
			String str=new String(cont, 0, len);
		}*/
		int len=0;
		while((len = fis.read(cont))!=-1){
			String str=new String(cont, 0, len);
			System.out.println(str);
		}
	}
}
