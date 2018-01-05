package com.zhiyou100.threeKingdoms;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class SanGuo {
	private static String fileName="000 三国演义 上卷";
	private static int num=0;
	private static BufferedWriter writer;
	public static void parse() throws Exception{
		BufferedReader reader=new BufferedReader(new FileReader("d:/三国演义.txt"));
		resetWriter();
		String content=null;
		while((content=reader.readLine())!=null){
			analysisText(content);
		}
		writer.close();
		reader.close();
	}
	private static void analysisText(String text) throws Exception {
		// TODO Auto-generated method stub
		String[] txt=text.split("  ");
		if(txt[0].startsWith("第") && txt[0].endsWith("回")){
			num++;
			String str=String.format("%03d ",num);
			fileName = str + text;
			resetWriter();
		}
		writer.write(text);;
		writer.newLine();
	}
	private static void resetWriter() throws Exception {
		// TODO Auto-generated method stub
		if(writer!=null){
			writer.flush();
			writer.close();
		}
		writer =new BufferedWriter(new FileWriter("d:/三国分章节/"+fileName+".txt"));
	}
	public static void main(String[] args) throws Exception {
		parse();
	}
}
