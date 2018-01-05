package com.zhiyou100.file;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.Arrays;

import org.junit.Test;

public class Filereview {
	@Test
	public void test01() throws IOException{//创建文件
		File file1=new File("d:/aaa.txt");
		boolean newFile = file1.createNewFile();
		System.out.println(newFile);
	}
	@Test
	public void test02(){//创建文件夹 mkdirs可以创建多层文件，mkdir只能创建一层
		File file1=new File("d:/aaa/bb");
		boolean mkdirs = file1.mkdirs();
		file1.delete();//只能删除一层
		System.out.println(mkdirs);
	}
	@Test
	public void test03() throws IOException{
		File file=new File("d:\\bbb.txt");
		file.createNewFile();
		System.out.println(file.getName());
		System.out.println(file.getParentFile());//获取根路径d:\
		System.out.println(file.getFreeSpace());
		System.out.println(file.getParent());
		System.out.println(file.getTotalSpace());
	}
	@Test
	public void test04() throws IOException{
		File file=new File("d:/ccc.txt");
		file.createNewFile();
		System.out.println(file.isAbsolute());
		System.out.println(file.isDirectory()?"null":"ccc.txt");
	}
	@Test
	public void test05() throws IOException{
		File file=new File("d:/develope/hbuilde");
		String[] list = file.list();
		File[] listFiles = file.listFiles();
		File[] listRoots = file.listRoots();
		System.out.println(Arrays.toString(listRoots));
		System.out.println(file.getParent());
		System.out.println(Arrays.toString(list));//路径下的文件
		System.out.println(Arrays.toString(listFiles));//全路径下文件
		for (File file2 : listRoots) {
			System.out.println(file2.getAbsolutePath());
		}
	}
	@Test
	public void test06(){
		File file=new File("d:/develope/hbuilde");
		findFile(file);
	}
	private Integer count=0;
	private void findFile(File file) {
		// TODO Auto-generated method stub
		File[] listFiles = file.listFiles();
		for (File file1 : listFiles) {
			if(file1.isDirectory()){
				findFile(file1);
			}else {
				System.out.println(count++ +"------"+Arrays.toString(listFiles));
			}
		}
	}
	@Test
	public void test07(){
		File file=new File("d:/develope/java");
		findFile1(file);
	}
	private int count1=0;
	private void findFile1(File file) {
		// TODO Auto-generated method stub
		File[] listFiles = file.listFiles(new FileFilter() {
			@Override
			public boolean accept(File pathname) {
				// TODO Auto-generated method stub
				if(pathname.isDirectory()){
					return true;
				}
				if(pathname.getName().toUpperCase().endsWith(".JAR")){
					System.out.println(count++ +"----"+pathname.getName());
				}
				return false;
			}
		});
		for (File file2 : listFiles) {
			findFile1(file2);
		}
	}
}
