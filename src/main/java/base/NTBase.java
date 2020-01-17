package base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.util.Units;
import org.apache.poi.xwpf.usermodel.Document;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import utility.TestUtil;


public class NTBase {
	public static WebDriver driver;
	public static Properties Prop;
	//public WebDriverWait wait;
		
		public NTBase(){
			try {
				Prop = new Properties();
				FileInputStream ip = new FileInputStream("C:\\Users\\Induction\\Desktop\\NothernTrust\\NT\\src\\main\\java\\config\\config.properties");
				Prop.load(ip);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}}
		
		public static void initialization(){
			String browserName = Prop.getProperty("browser");
			
			if(browserName.equals("chrome")){
				System.setProperty("webdriver.chrome.driver", "C:\\Users\\Induction\\Desktop\\NothernTrust\\NT\\src\\main\\java\\config\\chromedriver.exe");	
				driver = new ChromeDriver(); 
			}
			else if(browserName.equals("FF")){
				System.out.println("Driver not found");
			}
			
			//WebDriverWait wait = new WebDriverWait(driver, 1000);
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
			driver.get(Prop.getProperty("url"));
			
			/*try {
				driver.manage().timeouts().wait(TestUtil.WAIT);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Element not found");
			}*/
					
	}
		public static void getScreenshot(String s) throws IOException, InvalidFormatException
		{
			File scrfile=	((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrfile,new File(System.getProperty("user.dir")+"\\Screenshots\\"+s+".png"));
			XWPFDocument doc = new XWPFDocument();
			XWPFParagraph p = doc.createParagraph();
			XWPFRun r = p.createRun();
			r.setText(s);
			r.addBreak();
			r.addPicture(new FileInputStream(scrfile), Document.PICTURE_TYPE_PNG, s, Units.toEMU(400), Units.toEMU(400));
			FileOutputStream out = new FileOutputStream(System.getProperty("user.dir")+"\\Screenshots\\"+s+".docx");
			doc.write(out);
			out.close();
			doc.close();
		}
}
