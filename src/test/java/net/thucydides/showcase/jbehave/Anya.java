package net.thucydides.showcase.jbehave;
import org.jbehave.core.annotations.Named;

import org.jbehave.core.annotations.When;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;

import net.thucydides.jbehave.ThucydidesJUnitStories;
import net.thucydides.core.annotations.Steps;
import net.thucydides.showcase.steps.AnyaTestSteps;
public class Anya {

	@Steps
	AnyaTestSteps searchSteps;

	@Given("user opens main page")
	public void userOpensMainPage() {
		searchSteps.userOpenBookingComMainPage();
	}
	
	    
	@When("user inputs $mail and $password on main page")
	public void signingInCheckup(
			@Named("mail") String searchMail, 
		    @Named("password") String searchPassword) throws Throwable  {
		searchSteps.SigningIn();
		searchSteps.enteringMail(searchMail);
		searchSteps.enteringPassword(searchPassword);
		searchSteps.submitForm();
	}
	
	@When("user clicks log out")
    public void logOut (){
	searchSteps.userLoggingOut();	
	} 
	
	@Then("displayed name is $user_id")
	public void signedUser(
	@Named ("user_id") final String userName){
		searchSteps.userSigned(userName);
	}
	
   @Then ("<Sign In> displayed")
   public void userLoggedOut(
   @Named ("Sign in") final String SignIn) {
  searchSteps. loggingOutValidation(SignIn);
    }
   
   @Then ("<error message> displayed")
  public void userGettingErrorMessage(
    @Named ("error message") final String ErrMssge) {
	   searchSteps.checkMssge(ErrMssge);
   }
}


