package tools;

import java.io.File;
import java.io.IOException;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class Excel_R {
	static int i = 0;
	static int y = 1;
	static boolean bool=true;//�ļ�������־
	static Boolean line_end = true;
	private static int line = 1;//��
	private static int column = 0;//��
	private static int ide;//���ؽ��е��ڼ���
	public static String getFile(String file) throws BiffException, IOException {
		Workbook book = Workbook.getWorkbook(new File(file));
	      //��õ�һ����������� 
	    Sheet sheet = book.getSheet(0);
	    int rows = sheet.getRows();  //��
		int cols = sheet.getColumns();  //��
//		System.out.println("���ļ�һ����"+cols+"��");
//		System.out.println("���ļ�һ����"+rows+"��");
	    String str = sheet.getCell(column,line).getContents();
	    if(column==(cols-1)) {
	    	System.out.print("��"+line+"����������ִ�гɹ���"+"�û�����"+str+" "+"���룺"+sheet.getCell(column,line).getContents()+" ");
	    }
	    ide = column;
	    column++;
	    if(line==(rows-1)&column==cols) {
			bool=false;
		}else {
			bool=true;
		}
		if(column>cols-1) {
			column=0;//��
			line++;//��
			line_end=false;
		}
		return str;
	}
	//�ж��ļ��Ƿ����������line��column��ֵ
	public static boolean bool() {
		if (bool==false) {
			line = 1;
			column = 0;
		}
		return bool;
	}
	//��������ִ����һ��
	public static int index() {
		return ide;
	}
	//����
	public static boolean end() {
		return line_end;
	}

}
