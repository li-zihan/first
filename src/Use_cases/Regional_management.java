package Use_cases;

import org.testng.annotations.Test;

import jxl.read.biff.BiffException;
import tools.Data;
import tools.Excel_R;
import tools.method;

import java.awt.Button;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.xml.xpath.XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;

public class Regional_management {
  @BeforeTest
  public void beforeTest() {
	  method.OpenBrowser();
  }

  @Test(priority=4)
  public void Test4() throws BiffException, IOException, InterruptedException {
	  System.out.println("修改区域测试用例执行结果-------------------------------------------------------------------");
	  method.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	  method.URl(Data.Regional_management_url());
	  String file = "F:/Test_Software/eclipse/jar/excel_jar/修改.xls";
	  String front = "";
	  String after = "";
	  String str1="";
	  boolean bool = true;
	  while(bool) {
		  String str = Excel_R.getFile(file);
		  if(Excel_R.index()==0) {
			  int num = method.Type_to(str);
			  method.page(num);
		  }else if(Excel_R.index()==1){
			   front = ".//*[@class='ant-table-tbody']/tr["+str+"]";
		  }
		  else if(Excel_R.index()==2){
			   after = "/td[5]/.//a["+str+"]";
			   front+=after;
			   method.Button(front);
			   if(method.Type_to(str)==1) {
				   method.Input_Box("//*[@id='NAME']",Excel_R.getFile(file));
				   method.Input_Box("//*[@id='CODE']",Excel_R.getFile(file));
				   method.Input_Box("//*[@id='DESCRIPTION']",Excel_R.getFile(file));
				   method.Button("/html/body/div[3]/div/div[2]/div/div[2]/div[3]/div/button[2]");
			   }else if(method.Type_to(str)==2) {
				   Thread.sleep(200);
				   method.yes();
			   }else{}
		  }
		  bool = Excel_R.bool();
		  Thread.sleep(200);		  
}
	  }
}