package net.thucydides.showcase.steps;

import java.util.List;

import static org.junit.Assert.assertEquals;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;
import net.thucydides.showcase.pages.HomePage;

public class AnyaTestSteps extends ScenarioSteps {

	private static final long serialVersionUID = 1L;

	private static Logger LOG = LoggerFactory
			.getLogger( AnyaTestSteps.class);

	HomePage homePage;

	public  AnyaTestSteps(Pages pages) {
		super(pages);
		homePage = getPages().get(HomePage.class);
	}

	@Step
	public void userOpenBookingComMainPage() {
		getDriver().manage().deleteAllCookies();
		homePage.open();
		//waitABit(200);
		homePage.waitForTextToAppear ("Find the Best Deals");
		LOG.info("Property testing " + System.getProperty("thucydides.capability.types"));
	}
	
	@Step
	public void signIn() throws Throwable {
		homePage.selectSignIn ();
		homePage.clickSignInButton();
    }
	
	@Step
	 public void enterMail(String searchMail) {
		homePage.enterMail (searchMail);
	}
	@Step
	public void enterPassword(String searchPass) {
		homePage.enterPass (searchPass);	
	}
		
    @Step 
    public void submitForm() {
    	homePage.clickSignIn();
    }
    @Step
    public String getEmaiOfSignedUser() {  	
    	return homePage.getEmailOfUserSigned();
    
    }
   @Step 
   public void userLogsOut (){
		homePage.logOut();	
		waitABit(200);
   }
    @Step
   public String loggingOutValidation (){
       return homePage.getSignedOutMessage();
   }
    @Step
    public String checkMssge(){
    	return homePage.getErrorOnInvalidCreds();
    }
}


  
         
  