package tools;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import jxl.read.biff.BiffException;


public class method {
	public static WebDriver driver;
	//调用浏览器
	//浏览器最大化
	public static void OpenBrowser() {
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();	
	}
	//打开地址
	public static void URl(String url) {
		
		driver.get(url);
	}	
	//输入框
	//String，String
	//绝对路径或相对路径&输入内容
	public static String Input_Box(String element,String Content) {
		driver.findElement(By.xpath(element)).clear();
		driver.findElement(By.xpath(element)).sendKeys(Content);
		return Content;
	}
	//引用登录
	public static String login(String user,String password) throws BiffException, IOException, InterruptedException {
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		URl(Data.login_url());
		Input_Box("//*[@id=\"app\"]/div/div/div[2]/div[1]/span/input", user);
		Input_Box("//*[@id=\"app\"]/div/div/div[2]/div[2]/span/input",password);
		Button("//*[@id=\"app\"]/div/div/div[2]/div[3]/button");
		Thread.sleep(200);
		Label(By.xpath("//*[@id=\"app\"]/div/div[3]/a[1]"));
		return null;
	}
	//按钮
	//String
	//绝对路径或相对路径
	public static void Button(String element) {
		
		driver.findElement(By.xpath(element)).click();	
	}
	
	//复选框
	public static void Single_choice(int num) {
		String str = ".//*[@class=\"ant-table-tbody\"]/tr["+num+"]/td[1]/.//input";
		Button(str);
	}
	//翻页
	//根据页数选择
	public static void page(int num) {
		String str = ".//*[@class='ant-pagination ant-table-pagination']/li["+(num+2)+"]";
		//*[@id="app"]/div/div[2]/div/div[2]/div/div[2]/div/div/ul/li[3]
		//*[@id="app"]/div/div[2]/div/div[2]/div/div[2]/div/div/ul/li[3]
		Button(str);
	}
	
	//右上角新增
	public static void add() {
		String str = "//*[@id='app']/div/div[2]/div/div[2]/div/div[1]/div[2]/button";
		Button(str);
	}
	
	//批量删除
	//勾选删除按钮
	public static void dll() {
		String str = ".//*[@id=\"app\"]/div/div[2]/div/div[2]/div/div[1]/div[2]/button[2]";
		Button(str);
	}
	
	//二次确定按钮
	public static void yes() {
		String str = ".//*[@class='ant-popover-buttons']/button[2]";
		Button(str);
	}
	
	//二次取消按钮
	public static void no() {
		String str = ".//*[@class='ant-popover-buttons']/button[1]";
		Button(str);
	}
	
	//选择下拉框
	public static void Selection_box() {
		String str = "//*[@id=\"8b8ab980-26b6-45f7-9b7c-6c05e2885b65\"]/ul/li[1]";
	}
	
	//操作栏
	//修改、删除、查看
	public static void operation() {
		
	}
	
	//类型转换
	//String————int
	public static int Type_to(String str) {
		int num = Integer.parseInt(str);
		return num;
	}
	
	//判断元素是否存在
	//
	public static boolean Label(By by) {

		try {
			driver.findElement(by);
			System.out.println("操作成功！");
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("操作失败！");
			return false;
		}
	}
	
	  //等待元素可点击
	public static void wait(By by) {
		boolean bool = true;
		while(bool){
			try {
				driver.findElement(by).click();
				bool = false;
				//System.out.println("元素出现可点击");
			} catch (Exception e) {
				bool =  true;
				//System.out.println("元素未出现");
			 }
		}
	}

}
