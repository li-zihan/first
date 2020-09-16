package Use_cases;
import jxl.read.biff.BiffException;
import tools.Data;
import tools.Excel_R;
import tools.method;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;


public class loginTest {
	static 
	@BeforeTest
	public void start() {
		method.OpenBrowser();
	}
  @Test(priority=1)
  //参照测试用例F:/Test_Software/eclipse/jar/excel_jar/UserName.xls
  	public void Test1() throws InterruptedException, BiffException, IOException {
	  	System.out.println("登录测试用例执行结果-------------------------------------------------------------------");
	  	boolean bool = true;
	  	String file = "F:/Test_Software/eclipse/jar/excel_jar/UserName.xls";
	  	while(bool) {
			method.driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	  		method.login(Excel_R.getFile(file),Excel_R.getFile(file));
			method.driver.manage().deleteAllCookies();
			bool = Excel_R.bool();
	  	}
  }
  @Test(priority=2)
  public void Test2() throws BiffException, IOException, InterruptedException {
	  //method.login("cnooc","cnooc");
	  System.out.println("新增区域测试用例执行结果-------------------------------------------------------------------");
	  boolean bool = true;
	  String file = "F:/Test_Software/eclipse/jar/excel_jar/Regional.xls";
	  while(bool) {
		  method.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		  method.URl(Data.Regional_management_url());
		  method.Button("//*[@id='app']/div/div[2]/div/div[2]/div/div[1]/div[2]/button");
		  String text = method.Input_Box("//*[@id=\"NAME\"]", Excel_R.getFile(file));
		  method.Input_Box("//*[@id=\"CODE\"]", Excel_R.getFile(file));
		  method.Button("/html/body/div[3]/div/div[2]/div/div[2]/div[3]/div/button[2]");
		  bool = Excel_R.bool();
		  method.Label(By.xpath("//*[text()='"+text+"']"));
	//	  method.Label(By.xpath("//*[contains(text(),'" + text + "')]"));
	//	  System.out.println(text);
	  }
  }
}
