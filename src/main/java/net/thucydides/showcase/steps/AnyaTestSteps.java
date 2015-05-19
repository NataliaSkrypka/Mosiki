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
		homePage.open();
		waitABit(200);
		LOG.info("Property testing " + System.getProperty("thucydides.capability.types"));
	}
	
	@Step
	public void SigningIn() throws Throwable {
		homePage.selectSignIn ();
		homePage.clickSignInButton();
    }
	
	@Step
	 public void enteringMail(String searchMail) {
		homePage.enterMail (searchMail);
	}
	@Step
	public void enteringPassword(String searchPass) {
		homePage.enterPass (searchPass);	
	}
		
    @Step 
    public void submitForm() {
    	homePage.Click_sign_in();
    }
    @Step
    public void userSigned(String userName) {
    	assertEquals("As expected", userName, homePage.getSignedUpassert());
    	
    }
   @Step 
   public void userLoggingOut (){
		homePage.logOut();	
		waitABit(10000);
   }
    @Step
   public void loggingOutValidation (String SignIn){
       assertEquals("As expected", SignIn, homePage.getSignedOutMessage());
   }
    @Step
    public void checkMssge(String ErrMssge){
    	assertEquals ("As expected", ErrMssge, homePage.getErrorOnInvalidCreds());
    }
}


  
         
  