package net.thucydides.showcase.steps;

import java.util.List;

import static org.junit.Assert.assertEquals;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;
import net.thucydides.showcase.pages.HomePage;

public class SearchOnBookingSteps extends ScenarioSteps {

	private static final long serialVersionUID = 1L;

	private static Logger LOG = LoggerFactory
			.getLogger(SearchOnBookingSteps.class);

	HomePage homePage;

	public SearchOnBookingSteps(Pages pages) {
		super(pages);
		homePage = getPages().get(HomePage.class);
	}

	@Step
	public void userOpenBookingComMainPage() {
		homePage.open();
		LOG.info("Property testing " + System.getProperty("thucydides.capability.types"));
	}

	@Step
	public void searchTextOnBookingCom(String searchString) {
		homePage.inputTextInSearchField(searchString);
		homePage.clickOnNoSpecificDatesCheckBox();
		homePage.selectRadioButton ();
		homePage.clickOnSearchButton();
	}

	@Step
	public void leaveSearchFieldsEmpty() {
		searchTextOnBookingCom("");
	}

	@Step
	public void enterSomeTextAndLeaveDatesEmpty(String searchString) {
		homePage.inputTextInSearchField(searchString);
		homePage.clickOnSearchButton();
	}

	@Step
	public void searchResultsOnBookingCom() {
		List<String> results = homePage.getListOfCitiesAfterSearch();
		for (String row : results) {
			LOG.info("Location in list: " + row);
		}
	}

	@Step
	public void checkMessageOnSearchResult(String messageOnSearchResults) {
		assertEquals("Message is not as expected", messageOnSearchResults,
				homePage.getErrorMessage());
	}

	@Step
	public void checkMessageOnDates(String messageOnDates) {
		assertEquals("Message is not as expected", messageOnDates,
				homePage.getErrorOnDates());
	}



}
