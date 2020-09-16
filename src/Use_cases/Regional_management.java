package Use_cases;

import org.testng.annotations.Test;

import jxl.read.biff.BiffException;
import tools.Data;
import tools.Excel_R;
import tools.method;

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
//  @Test(priority=2)
//  public void Test2() throws BiffException, IOException, InterruptedException {
//	  //method.login("cnooc","cnooc");
//	  boolean bool = true;
//	  String file = "F:/Test_Software/eclipse/jar/excel_jar/Regional.xls";
//	  while(bool) {
//		  method.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//		  method.URl(Data.Regional_management_url());
//		  method.Button("//*[@id='app']/div/div[2]/div/div[2]/div/div[1]/div[2]/button");
//		  String text = method.Input_Box("//*[@id=\"NAME\"]", UserData.getFile(file));
//		  method.Input_Box("//*[@id=\"CODE\"]", UserData.getFile(file));
//		  method.Button("/html/body/div[2]/div/div[2]/div/div[2]/div[3]/div/button[2]");
//		  bool = UserData.bool();
//		  method.Label(By.xpath("//*[text()='"+text+"']"));		  
//	  }
//  }
  @Test(priority=3)
  public void Test3() throws BiffException, IOException, InterruptedException {
	  method.URl(Data.Regional_management_url());
	  String file = "F:/Test_Software/eclipse/jar/excel_jar/¸´Ñ¡¿ò.xls";
	  boolean bool = true;
	  while(bool) {
	  method.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		  String str = Excel_R.getFile(file);
		  int num = method.Type_to(str); 
			  if(Excel_R.index()==0) {
				  String elen = ".//*[@class='ant-pagination ant-table-pagination']/li["+(num+2)+"]";
				  method.Button(elen);
			  }else {
				  String elen = ".//*[@class=\"ant-table-tbody\"]/tr["+num+"]/td[1]/.//input";
				  method.Button(elen);
				  method.Button(".//*[@id=\"app\"]/div/div[2]/div/div[2]/div/div[1]/div[2]/button[2]");
				  Thread.sleep(200);
				  method.Button(".//*[@class='ant-popover-buttons']/button[2]");
			  }
			  bool = Excel_R.end();
	  }
  }

}
