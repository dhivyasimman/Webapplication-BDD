package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ConfirmPage {
	
WebDriver driver;
	
	public ConfirmPage(WebDriver driver){
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(how=How.XPATH,using="//input[@value='Confirm']")
	private WebElement confirmbtn;


	public void confirmorder(){
		
		WebDriverWait waitconfirm = new WebDriverWait(driver, 200);
		WebElement cnfrmbtn = waitconfirm.until(ExpectedConditions.elementToBeClickable(confirmbtn));
		
		confirmbtn.click();
	}
	
	public void verifyorderdetail(){
		
	}
	
}
