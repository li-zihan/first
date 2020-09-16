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
	
	//单选
	public static void Single_choice(String element) {
		
	}
	//翻页
	//根据页数选择
	public static void page() {
		
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
