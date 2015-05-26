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
	@Aliases(values = { "user logs in with anya_test@yahoo.com and hannah_evergreen1 on main page" })
	public void userOpensMainPage() {
		searchSteps.userOpenBookingComMainPage();
	}

	@When("user inputs $mail and $password on main page")
	public void signingInCheckup(@Named("mail") String searchMail,
			@Named("password") String searchPassword) throws Throwable {
		searchSteps.signIn();
		searchSteps.enterMail(searchMail);
		searchSteps.enterPassword(searchPassword);
		searchSteps.submitForm();
	}

	@When("user clicks log out")
	public void logOut() {
		searchSteps.userLoggingOut();
	}

	@Then("displayed name is $user_id")
	public void signedUser(@Named("user_id") String userName) {
		String EMAIL=searchSteps.getEmaiOfSignedUser();
		assertEquals("As expected",userName,  EMAIL);
		assertThat( EMAIL, equals(userName));
	}

	@Then("<Sign In> displayed")
	public void userLoggedOut(@Named("Sign in") final String SignIn) {
		searchSteps.loggingOutValidation(SignIn);
	}

	@Then("<error message> displayed")
	public void userGettingErrorMessage(
			@Named("error message") final String ErrMssge) {
		searchSteps.checkMssge(ErrMssge);
	}
}
