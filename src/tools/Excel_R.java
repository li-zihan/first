package tools;

import java.io.File;
import java.io.IOException;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class Excel_R {
	static int i = 0;
	static int y = 1;
	static boolean bool=true;//文件结束标志
	static Boolean line_end = true;
	private static int line = 1;//行
	private static int column = 0;//列
	private static int ide;//返回进行到第几列
	public static String getFile(String file) throws BiffException, IOException {
		Workbook book = Workbook.getWorkbook(new File(file));
	      //获得第一个工作表对象 
	    Sheet sheet = book.getSheet(0);
	    int rows = sheet.getRows();  //行
		int cols = sheet.getColumns();  //列
//		System.out.println("本文件一共："+cols+"列");
//		System.out.println("本文件一共："+rows+"行");
	    String str = sheet.getCell(column,line).getContents();
	    if(column==(cols-1)) {
	    	System.out.print("第"+line+"条测试用例执行成功，"+"用户名："+str+" "+"密码："+sheet.getCell(column,line).getContents()+" ");
	    }
	    ide = column;
	    column++;
	    if(line==(rows-1)&column==cols) {
			bool=false;
		}else {
			bool=true;
		}
		if(column>cols-1) {
			column=0;//列
			line++;//行
			line_end=false;
		}
		return str;
	}
	//判断文件是否结束，重置line和column的值
	public static boolean bool() {
		if (bool==false) {
			line = 1;
			column = 0;
		}
		return bool;
	}
	//返回正在执行哪一列
	public static int index() {
		return ide;
	}
	//返回
	public static boolean end() {
		return line_end;
	}

}
