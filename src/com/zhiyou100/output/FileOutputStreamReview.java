package com.zhiyou100.output;



import java.io.FileOutputStream;

import org.junit.Test;

public class FileOutputStreamReview {
	@Test
	public void test01() throws Exception{
		FileOutputStream fos=new FileOutputStream("d:/aaa.txt");
		/*fos.write(100);*/
		
		/*byte[] bytes={65,66,67}; 
		fos.write(bytes);*/
		
		/*byte[] bytes={65,66,67};
		fos.write(bytes, 0, 2);*/
		
		String str="大家好";
		fos.write(str.getBytes());//将字符串转换成字节数组  换行用\r\n
		
		fos.close();
	}
}
