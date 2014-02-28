package net.thucydides.showcase.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;

import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;

@DefaultUrl("http://www.booking.com/")
public class HomePage extends PageObject{
	
	private static final String SEARCH_FIELD = "#destination";
	private static final String SERCH_CITY_TEMPLATE = "//div[@id='cityWrapper']/div[%d]/div[2]/a";
	private static final String ERROR_ON_SEARCH = "#b_searchbox_errors p";
	private static final String CHECKBOX_NO_SPECIFIC_DATES = "#availcheck";
	private static final String SEARCH_BUTTON = "#searchbox_btn";
	private static final String ERROR_ON_DATES = "//p[contains(@class,'dateerros')]";
	private static final String SEARCH_HEADER = "#destinationSearch h3";

	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	public void inputTextInSearchField(String searchText) {
		findBy(SEARCH_FIELD).then().clear();
		findBy(SEARCH_FIELD).then().type(searchText);
		findBy(SEARCH_HEADER).then().click();
	}

	public String getErrorMessage() {
		return findBy(ERROR_ON_SEARCH).getText();
	}

	public void clickOnNoSpecificDatesCheckBox() {
		findBy(CHECKBOX_NO_SPECIFIC_DATES).then().click();
	}

	public void clickOnSearchButton() {
		findBy(SEARCH_BUTTON).then().click();
	}

	public List<String> getListOfCitiesAfterSearch() {
		List<String> cityList = new ArrayList<String>();
		for (int i = 1; i <= 5; i++) {
			cityList.add(findBy(String.format(SERCH_CITY_TEMPLATE, i)).getText());
		}
		return cityList;
	}

	public String getErrorOnDates() {
		return findBy(ERROR_ON_DATES).getText();
	}

	public void enterTextAndClickSearch(String textToSearch) {
		inputTextInSearchField(textToSearch);
		clickOnNoSpecificDatesCheckBox();
		clickOnNoSpecificDatesCheckBox();
	}


}
