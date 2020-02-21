package NTDefinition;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;

import base.NTBase;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
//import io.qameta.allure.Step;
import pageobjects.ConfirmPage;
import pageobjects.LogoutPage;
import pageobjects.PreviewPage;
import pageobjects.TradedetailPage;
import pageobjects.VSELoginPage;
import pageobjects.VSETradePage;
import pageobjects.VSEdashboardPage;
import utility.TestUtil;

public class NTDefine extends NTBase {
	TestUtil testutil = new TestUtil();
	VSELoginPage vseloginpage;
	VSEdashboardPage dashboard;
	VSETradePage trade;
	TradedetailPage tradedetails;
	PreviewPage preview;
	ConfirmPage confirm;
	LogoutPage logout;
	
	//@Step("User Logs into the VSE website")
	@Given("^User Logs into the VSE website$")
	public void user_Logs_into_the_VSE_website() throws Throwable {
	    NTBase.initialization();
	    
	}
	//@Step("User inputs the valid username and password")
	@When("^User inputs the valid username and password$")
	public void user_inputs_the_valid_username_and_password() throws Throwable {
		vseloginpage = new VSELoginPage(driver);
		vseloginpage.Signin();
		String frontpagetitle =vseloginpage.verifylandingpagetitle();
		System.out.println("title of page:" +frontpagetitle);
	    vseloginpage.Login();
	    vseloginpage.password();
	    vseloginpage.submit();
	    
		
	}
	//@Step("User verifies the title DASHBOARD")
	@Then("^User verifies the title DASHBOARD$")
	public void user_verifies_the_title_DASHBOARD() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		dashboard = new VSEdashboardPage(driver);
	   String dashboardtitle =dashboard.verifydashboardtitle();
	   System.out.println("Title of page:" +dashboardtitle);
	   Assert.assertEquals("Dashboard",dashboardtitle );
	   System.out.println("Title matched");
	  }
	//@Step("User selects TRADE STOCKS option in MAKE A TRADE dropdown")
	@Given("^User selects TRADE STOCKS option in MAKE A TRADE dropdown$")
	public void user_selects_TRADE_STOCKS_option_in_MAKE_A_TRADE_dropdown() throws Throwable {
	    
		trade=new VSETradePage(driver);
		trade.clicktrade();
		String tradetitle =trade.verifytradetitle();
		   System.out.println("Title of page:" +tradetitle);
		   Assert.assertEquals("Trading - Equities",tradetitle);
		   System.out.println("Title matched");
		
		
	    	}
	//@Step("User selects the Region, Location and keys in necessary values")
	@When("^User selects the Region, Location and keys in necessary values$")
	public void user_selects_the_Region_Location_and_keys_in_necessary_values() throws Throwable {
		tradedetails = new TradedetailPage(driver);
		tradedetails.selectregion();
		tradedetails.selectlocation();
		tradedetails.selectaction();
		tradedetails.symbolvalue();
		tradedetails.qtyvalue();
		tradedetails.ordertypevalue();
		System.out.println("Trade details filled");
	    
	}

	//@Step("Clicks the Preview Button")
	@When("^Clicks the Preview Button$")
	public void clicks_the_Preview_Button() throws Throwable {
	    
		preview = new PreviewPage(driver);
		//driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		preview.previewclick();
		//Assert.assertTrue(preview.verifyorderdetails(), "valid order");
	}

	//@Step("Now User Clicks the Confirm Button")	
	@Then("^Now User Clicks the Confirm Button$")
	public void now_User_Clicks_the_Confirm_Button() throws Throwable {
	   
		confirm= new ConfirmPage(driver);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		confirm.confirmorder();
	}

	//@Step("Trade is successfully placed")	
	@Then("^Trade is successfully placed$")
	public void trade_is_successfully_placed() throws Throwable {
	    
		System.out.println("Order placed successfully");
	}

	//@Step("User is in the VSE website")
	@Given("^User is in the VSE website$")
	public void user_is_in_the_VSE_website() throws Throwable {
	    
	    System.out.println("User is in the VSE website");
	}

	//@Step("Click Logout")
	@When("^Click Logout$")
	public void click_Logout() throws Throwable {
	    
		logout = new LogoutPage(driver);
		//driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		logout.logoutclick();
		System.out.println("User logsout of the website");
	    
	}

	//@Step("User verifies the Virtual Stock Exchange title")
	@Then("^User verifies the Virtual Stock Exchange title$")
	public void user_verifies_the_Virtual_Stock_Exchange_title() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    driver.quit();
	    System.out.println("User quits the browser");

	}


}
