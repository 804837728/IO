package com.zhiyou100.file;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.Arrays;

import org.junit.Test;


public class Filldemo {
	@Test
	public void test01(){
		/*
		 * 1.创建File对象，并不会真实的去创建文件
		 * 2.也不需要路径一定存在
		 **/
		File file1= new File("c:/a/b/c/d");
		System.out.println(file1);
		
		File file2=new File(file1,"a.txt");
		System.out.println(file2);
		
		File file3= new File("c:/a/b/c/d", "b.txt");
		System.out.println(file3);
	}
	@Test
	public void test02() throws IOException{
//		创建文件
		File file1= new File("d:/kkk.txt");//并不会真正的创建文件，必须调用creteNewFile()方法才在本地创建文件
		boolean createNewFile = file1.createNewFile();
		System.out.println(file1.getTotalSpace()/(1024*1024*1024)+"G");
		System.out.println(createNewFile);
	}
	@Test
	public void test03() throws IOException{
//		创建文件夹 mkdirs && mkdir mkdirs可以创建多层文件夹
		File file1= new File("d:a/b/c");
		boolean createNewFile = file1.mkdirs();
		System.out.println(createNewFile);
	}
	@Test
	public void test04() throws IOException{
//		删除文件 ，一删不回收站
		File file1= new File("d:/kkk.txt");
		boolean createNewFile = file1.delete();
		System.out.println(createNewFile);
	}
	@Test
	public void test05() throws IOException{
		File file1= new File("a.txt");
		/*
		 * 根据斜杠 分割``
		 * 
		 * file1.getName()---->通过分隔符进行切割后获取最后一个字符串
		 * file1.getParent()---》父目录
		 * file1.getPath()-->创建File对象的时候指定路径
		 * file1.getAbsolutePath()-->如果创建File对象的时候使用的是相对路径得到绝对路径
		 * file1.length()--->文件的字节数
		 */
		System.out.println(file1.getName());//文件名
		System.out.println(file1.getParent());//d:\a.txt
		System.out.println(file1.getPath());//d:\a.txt
		System.out.println(file1.getAbsolutePath());//绝对路径
		System.out.println(file1.length());//文件的字节数
		System.out.println(file1.getParentFile());
	}
	@Test
	public void test06() throws IOException{
		/*
		 * file的判断功能
		 */
		File file1= new File("d:/a.txt");
		System.out.println(file1.exists()? "路径存在":"路径不存在");
		System.out.println(file1.isDirectory()? "文件夹":"文件");
		System.out.println(file1.isFile()? "文件":"文件夹");
		
		
	}
	@Test
	public void test07() throws IOException{
		File file1= new File("d:\\develope\\eclipse");
		String[] listPaths=file1.list();
		File[] listFiles=file1.listFiles();
		File[] listRoots= file1.listRoots();
		System.out.println(Arrays.toString(listPaths));
		System.out.println(Arrays.toString(listFiles));
		System.out.println(Arrays.toString(listRoots));
		System.out.println(file1.getParent());
		for (File file : listFiles) {
			System.out.println(file.getAbsolutePath());
		}
	}
	/*
	 * 递归
	 */
	@Test
	public void test08() throws IOException{
		File file1= new File("d:\\develope\\eclipse");
		findFile(file1);
	}
		private int count=0;
		private void findFile(File file1) {
		// TODO Auto-generated method stub
			/*
			 * 递归
			 */
			File[] listFiles=file1.listFiles();
			for (File file : listFiles) {
				if(file.isDirectory()){
					findFile(file);
				}else{
					System.out.println(count++ +"---"+file.getName());
				}
			}
		}
		
		@Test
		public void test09(){
			File file1=new File("d:\\devlope\\java");
			findJar(file1);
		}
		private void findJar(File file1) {
			// TODO Auto-generated method stub
			File[] listFiles=file1.listFiles(new FileFilter() {
				@Override
				public boolean accept(File pathname) {
					// TODO Auto-generated method stub
					if(pathname.isDirectory()){
						return true;
					}
					if(pathname.getName().toUpperCase().endsWith(".JAR")){
						System.out.println(pathname.getName());
					}
					return false;
				}
			});
			for(File file:listFiles){
				findJar(file);
			}
		}
		
			
}
		
		
		
		
		
		
		
		
		
		
		
