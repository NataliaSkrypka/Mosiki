package net.thucydides.showcase.jbehave;

import org.hamcrest.Matcher;
import org.jbehave.core.annotations.Aliases;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.When;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;

import net.thucydides.jbehave.ThucydidesJUnitStories;
import net.thucydides.core.annotations.Steps;
import net.thucydides.showcase.steps.AnyaTestSteps;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.*;

public class Anya {

	@Steps
	AnyaTestSteps searchSteps;

	@Given("user opens main page")
	@Aliases(values = { "user logs in with anya_test@yahoo.com and hannah_evergreen1 on main page",
			             "user logs in with invalid creds on main page"})
	public void userOpensMainPage() {
		searchSteps.userOpenBookingComMainPage();
	}

	@When("user inputs $mail and $password on main page")
	public void checkSignedUser(@Named("mail") String searchMail,
			@Named("password") String searchPassword) throws Throwable {
		searchSteps.signIn();
		searchSteps.enterMail(searchMail);
		searchSteps.enterPassword(searchPassword);
		searchSteps.submitForm();
	}

	@When("user clicks log out")
	public void logOut() {
		searchSteps.userLogsOut();
	}

	@Then("displayed name is $user_id")
	public void signedUser(@Named("user_id") String userName) {
		String EMAIL=searchSteps.getEmaiOfSignedUser();
		assertEquals("As expected",userName,  EMAIL);
		//assertThat("User invalid",EMAIL,equals(userName)); //the first message is the one you get in case assert encounters invalid parameter
	}

	@Then("<Sign In> displayed")
	public void userLoggedOut(@Named("Sign in") String SignIn) {
	//	searchSteps.loggingOutValidation(SignIn);
		String SIGNIN= searchSteps.loggingOutValidation();
		assertEquals("As expected", SignIn, SIGNIN);
	}
	
	@Then("<error message> displayed")
	public void userGettingErrorMessage(
			@Named("error message") final String ErrMssge) {
		String ERROR_MSSGE=searchSteps.checkMssge();
		assertEquals("As expected", ErrMssge,ERROR_MSSGE);
	}
}
