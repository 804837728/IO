package com.zhiyou100.threeKingdoms;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.Test;

public class BufferedDemo {
	@Test
	public void test01() throws Exception{
		FileInputStream fis=new FileInputStream("d:/abc.txt");
		BufferedInputStream bis=new BufferedInputStream(fis);
	}
	@Test
	public void test02() throws Exception {
		FileWriter fw=new FileWriter("d:/aaa.txt");
		BufferedWriter bw=new BufferedWriter(fw);
		bw.write("add");
	}
	@Test
	public void test03() throws Exception {
		FileReader fw=new FileReader("d:/aaa.txt");
		BufferedReader bw=new BufferedReader(fw);
		String len=null;
		while((len=bw.readLine())!=null){
			System.out.println(len);
		}
	}
	@Test
	public void test04() throws Exception{
		BufferedReader br=new BufferedReader(new FileReader("d:/aaa.txt"));
		BufferedWriter bw=new BufferedWriter(new FileWriter("d:/bbb.txt"));
		String len=null;
		while((len=br.readLine())!=null){
			bw.write(len);
			bw.newLine();
		}
		br.close();
		bw.close();
	}
}
