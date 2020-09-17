package tools;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import jxl.read.biff.BiffException;


public class method {
	public static WebDriver driver;
	//���������
	//��������
	public static void OpenBrowser() {
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();	
	}
	//�򿪵�ַ
	public static void URl(String url) {
		
		driver.get(url);
	}	
	//�����
	//String��String
	//����·�������·��&��������
	public static String Input_Box(String element,String Content) {
		driver.findElement(By.xpath(element)).clear();
		driver.findElement(By.xpath(element)).sendKeys(Content);
		return Content;
	}
	//���õ�¼
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
	//��ť
	//String
	//����·�������·��
	public static void Button(String element) {
		
		driver.findElement(By.xpath(element)).click();	
	}
	
	//��ѡ��
	public static void Single_choice(int num) {
		String str = ".//*[@class=\"ant-table-tbody\"]/tr["+num+"]/td[1]/.//input";
		Button(str);
	}
	//��ҳ
	//����ҳ��ѡ��
	public static void page(int num) {
		String str = ".//*[@class='ant-pagination ant-table-pagination']/li["+(num+2)+"]";
		//*[@id="app"]/div/div[2]/div/div[2]/div/div[2]/div/div/ul/li[3]
		//*[@id="app"]/div/div[2]/div/div[2]/div/div[2]/div/div/ul/li[3]
		Button(str);
	}
	
	//���Ͻ�����
	public static void add() {
		String str = "//*[@id='app']/div/div[2]/div/div[2]/div/div[1]/div[2]/button";
		Button(str);
	}
	
	//����ɾ��
	//��ѡɾ����ť
	public static void dll() {
		String str = ".//*[@id=\"app\"]/div/div[2]/div/div[2]/div/div[1]/div[2]/button[2]";
		Button(str);
	}
	
	//����ȷ����ť
	public static void yes() {
		String str = ".//*[@class='ant-popover-buttons']/button[2]";
		Button(str);
	}
	
	//����ȡ����ť
	public static void no() {
		String str = ".//*[@class='ant-popover-buttons']/button[1]";
		Button(str);
	}
	
	//ѡ��������
	public static void Selection_box() {
		String str = "//*[@id=\"8b8ab980-26b6-45f7-9b7c-6c05e2885b65\"]/ul/li[1]";
	}
	
	//������
	//�޸ġ�ɾ�����鿴
	public static void operation() {
		
	}
	
	//����ת��
	//String��������int
	public static int Type_to(String str) {
		int num = Integer.parseInt(str);
		return num;
	}
	
	//�ж�Ԫ���Ƿ����
	//
	public static boolean Label(By by) {

		try {
			driver.findElement(by);
			System.out.println("�����ɹ���");
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("����ʧ�ܣ�");
			return false;
		}
	}
	
	  //�ȴ�Ԫ�ؿɵ��
	public static void wait(By by) {
		boolean bool = true;
		while(bool){
			try {
				driver.findElement(by).click();
				bool = false;
				//System.out.println("Ԫ�س��ֿɵ��");
			} catch (Exception e) {
				bool =  true;
				//System.out.println("Ԫ��δ����");
			 }
		}
	}

}
