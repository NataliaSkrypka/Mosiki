package net.thucydides.showcase.jbehave;

import net.thucydides.core.annotations.Steps;
import net.thucydides.showcase.steps.SearchOnBookingSteps;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

public class SearchOnBooking {

	@Steps
	SearchOnBookingSteps searchSteps;

	@Given("user open main page")
	public void userOpensMainPage() {
		searchSteps.userOpenBookingComMainPage();
	}

	@When("user performs search for <fullText> on main page")
	public void searchTextOnBookingCom(
			@Named("fullText") final String searchString) {
		searchSteps.searchTextOnBookingCom(searchString);
	}

	@When("user leave search fields empty")
	public void leaveSearchFieldsEmpty() {
		searchSteps.searchTextOnBookingCom("");
	}

	@When("user performs search for <fullText> on main page and leave dates not specified")
	public void enterSomeTextAndLeaveDatesEmpty(
			@Named("fullText") final String searchString) {
		searchSteps.enterSomeTextAndLeaveDatesEmpty(searchString);
	}

	@Then("mentioned entity is shown in the result")
	public void searchResultsOnBookingCom() {
		searchSteps.searchResultsOnBookingCom();
	}

	@Then("message <message> is shown on search result")
	public void checkMessageOnSearchResult(
			@Named("message") final String messageOnSearchResults) {
		searchSteps.checkMessageOnSearchResult(messageOnSearchResults);
	}

	@Then("error message <message> about invalid dates is shown on search result")
	public void checkMessageOnDates(
			@Named("message") final String messageOnDates) {
		searchSteps.checkMessageOnDates(messageOnDates);
	}

}
