package com.zhiyou100.threeKingdoms;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;

import org.junit.Test;

import jdk.internal.dynalink.beans.StaticClass;

public class BufferReaderAndwriter {
	
	@Test
	public void test01() throws Exception{
		FileReader fr=new FileReader("d:/三国演义.txt");
		BufferedReader br=new BufferedReader(fr);
		FileWriter fw=new FileWriter("e:/三国演义.txt");
		BufferedWriter bw=new BufferedWriter(fw);
		String str= "";
		while((str = br.readLine())!=null){
			if(str.startsWith("第")){
					bw.close();
					fw=new FileWriter("e:/"+str+".txt");
					bw=new BufferedWriter(fw);
				}
			bw.write(str);
			bw.newLine();
			}
	}
}
