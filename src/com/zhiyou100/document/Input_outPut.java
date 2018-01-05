package com.zhiyou100.document;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.junit.Test;

public class Input_outPut {
	@Test
	public void write() throws Exception{
		FileOutputStream fos=new FileOutputStream("d:/out.txt");
		fos.write("最近有“电商专家”质疑双十一，认为这个集中一天促销打折的节日丝毫不创造价值，反而把消费者体验和商家的绩效都拽到了沟里，于是进而建议天猫不要再花这么大的力气在双十一上，最好把它干脆取消掉。我无论从消费者，还是从商家的立场来看，都赞成灭掉双十一这么个玩意。但是从 marketing 的角度来看，这种“电商专家”实在是太缺乏商业常识和素质了，才会得出这么不靠谱的结论。".getBytes());
		fos.close();
	}
	@Test
	public void writedocu() throws Exception{
		inputStreamOutputStream("d:/jsontest.zip", "e:/jsontest.zip");
	}
	public static void inputStreamOutputStream(String src,String out) throws Exception{
		FileOutputStream outputStream=null;
		FileInputStream inputStream=null;
		outputStream =new FileOutputStream(out);
		inputStream = new FileInputStream(src);
		byte[] bytes=new byte[1024];
		int len=0;
		while((len=inputStream.read(bytes))!=-1){
			outputStream.write(bytes,0,len);
			outputStream.flush();
		}
		outputStream.close();
		inputStream.close();
	}
}
