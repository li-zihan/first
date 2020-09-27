package Use_cases;
import org.testng.annotations.Test;
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
  //自动化构建测试-登录测试用例
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
	  System.out.println("新增区域测试用例执行结果-------------------------------------------------------------------");
	  boolean bool = true;
	  String file = "F:/Test_Software/eclipse/jar/excel_jar/Regional.xls";
	  while(bool) {
		  method.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		  method.URl(Data.Regional_management_url());

		  method.add();
		  String text = method.Input_Box("//*[@id=\"NAME\"]", Excel_R.getFile(file));
		  method.Input_Box("//*[@id=\"CODE\"]", Excel_R.getFile(file));
		  method.Button("/html/body/div[3]/div/div[2]/div/div[2]/div[3]/div/button[2]");
		  bool = Excel_R.bool();
		  method.Label(By.xpath("//*[text()='"+text+"']"));
	  }
  }
  @Test(priority=3)
  public void Test3() throws BiffException, IOException, InterruptedException {
	  System.out.println("删除区域测试用例执行结果-------------------------------------------------------------------");
	  method.URl(Data.Regional_management_url());
	  String file = "F:/Test_Software/eclipse/jar/excel_jar/复选框.xls";
	  boolean bool = true;
	  while(bool) {
		  method.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		  String str = Excel_R.getFile(file);
		  int num = method.Type_to(str); 
			  if(Excel_R.index()==0) {
				  method.page(num);
			  }else {
				  method.Single_choice(num);
				  method.dll();
				  Thread.sleep(200);
				  method.yes();  
			  }
		  bool = Excel_R.bool();
		  method.Button("//*[@id='app']/div/div[2]/div/div[2]/div/div[1]/div[2]/button");
		  String text = method.Input_Box("//*[@id=\"NAME\"]", Excel_R.getFile(file));
		  method.Input_Box("//*[@id=\"CODE\"]", Excel_R.getFile(file));
		  method.Button("/html/body/div[3]/div/div[2]/div/div[2]/div[3]/div/button[2]");
		  bool = Excel_R.bool();
		  method.Label(By.xpath("//*[text()='"+text+"']"));

	  }
  }
}
