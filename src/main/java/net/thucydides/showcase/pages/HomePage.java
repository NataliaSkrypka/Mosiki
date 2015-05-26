package net.thucydides.showcase.pages;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.number.IsCloseTo;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.findby.By;
import net.thucydides.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;
import net.thucydides.core.pages.WebElementFacade;

@DefaultUrl("http://www.booking.com/")
public class HomePage extends PageObject {

	private Logger LOG = LoggerFactory.getLogger(HomePage.class);

	private static final String SEARCH_FIELD = "//input[@id='destination']";
	private static final String SERCH_CITY_TEMPLATE = "//input[@id='destination']";
	private static final String ERROR_ON_SEARCH = "#b_searchbox_errors p";
	private static final String CHECKBOX_NO_SPECIFIC_DATES = "//input[@name='idf']";
	private static final String SEARCH_BUTTON = "//button[contains(@class,'b-searchbox-button')]";
	private static final String ERROR_ON_DATES = "//p[contains(@class,'dateerros')]";
	private static final String SEARCH_HEADER = "#destinationSearch";
	private static final String GUESTS_DROPDOWN = "//select[@name='group_adults']";
	private static final String RADIO_1 = "//input [contains(@class,leisure)][@value='leisure']";
	private static final String ERROR_ON_INVALID_CREDENTIALS = "//li[@id='current_account']//div[@class='alert alert-error alert-displayed']";
	private static final String EMAIL = "//div[@class='user_access_signin_menu form-section form-shown-section']//form[contains(@class, 'signin')]//input[@name='username']";
	private static final String PASS = "//div[@class='user_access_signin_menu form-section form-shown-section']//form[contains(@class, 'signin')]//input[@name='password']";
	private static final String SIGN_IN_1 = "//div[@class='user_access_signin_menu form-section form-shown-section']//form[contains(@class, 'signin')]//input[@type='submit']";
	private static final String SIGNED_USER = "//ul[@class='up_menu_row_top']//span[@class='header_name user_firstname']";
	private static final String ERROR_ON_MAIL_CREDS = "//li[@id='current_account']//div[contains(@class,'alert')]";

	private static final String SIGN_OUT_BUTTON = "//div[@class='new_menu_size popover_content']//ul[4]/li";
	@FindBy(xpath = "//li[@id='current_account']/a")
	private WebElementFacade signInLink;
	@FindBy(xpath = "//li[@id='current_account']//div[@data-target='user_access_signin_menu']")
	private WebElementFacade clickSignInButton;
	@FindBy(xpath = "//div[@class='user_access_signin_menu form-section form-shown-section']//form[contains(@class, 'signin')]//input[@type='submit']")
	private WebElementFacade submitForm;
	@FindBy(xpath = "//li[@id='current_account']/a[@data-track='click']")
	private WebElementFacade userValidation;
	@FindBy(xpath = "//div[@class='new_menu_size popover_content']//ul[4]/li")
	private WebElementFacade signOutButton;

	public HomePage(WebDriver driver) {
		super(driver);
	}

	public void inputTextInSearchField(String searchText) {
		findBy(SEARCH_FIELD).then().clear();
		// WebElementFacade searchField = findBy(SEARCH_FIELD);
		// searchField.type(searchText);
		findBy(SEARCH_FIELD).then().type(searchText);
		findBy(SEARCH_HEADER).then().click();
	}

	public String getErrorMessage() {
		return findBy(ERROR_ON_SEARCH).getText();
	}

	public void clickOnNoSpecificDatesCheckBox() {
		findBy(CHECKBOX_NO_SPECIFIC_DATES).then().click();
		findBy(GUESTS_DROPDOWN).selectByVisibleText("2");
	}

	public void clickOnSearchButton() {
		findBy(SEARCH_BUTTON).then().click();
	}

	public List<String> getListOfCitiesAfterSearch() {
		List<String> cityList = new ArrayList<String>();
		for (int i = 1; i <= 5; i++) {
			cityList.add(findBy(String.format(SERCH_CITY_TEMPLATE, i))
					.getText());
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

	public void selectRadioButton() {
		findBy(RADIO_1).then().click();
	}

	public void selectSignIn() {
		/*
		 * findBy(SIGN_IN).then().click();
		 * System.out.println("Before clicking on sign in link"); new
		 * Actions(getDriver()).click(findBy(SIGN_IN)).build().perform();
		 */
		//getDriver().manage().deleteAllCookies();
		String userIsLogged = signInLink.getText().trim();
		System.out.println("+++++++++++"+userIsLogged);
		if (userIsLogged.equalsIgnoreCase("sign in")) {
			signInLink.click();
			// waitABit(200);
		} else {
			waitForTextToAppear("Sign In");
		}
		// System.out.println("After clicking on sign in link");
	}

	// signing into account by stages
	public void enterMail(String searchMail) {
	
		/*
		 * System.out.println("Is email element visible " +
		 * findBy(EMAIL).isVisible()); System.out.println("SearchMail variable "
		 * + searchMail); if(!findBy(EMAIL).isVisible()){ waitABit(200);
		 * LOG.info("Is email element visible " + findBy(EMAIL).isVisible()); }
		 * if(findAll(EMAIL).isEmpty()){
		 * System.out.println("Is email element visible " +
		 * findBy(EMAIL).isVisible()); waitABit(100); }
		 */
		waitFor(EMAIL);
		findBy(EMAIL).then().type(searchMail);
	}

	public void enterPass(String searchPass) {
		findBy(PASS).then().clear();
		findBy(PASS).then().type(searchPass);
	}

//selecting [sign in] tab instead of [sign up]
	public void clickSignInButton() {
		clickSignInButton.click();
	}

//clicking final [sign in] to submit form completed
	public void clickSignIn() {
	submitForm.click();
		}
	
//getting signed user name
	public String getEmailOfUserSigned() {
	//	waitForTextToDisappear("It's fast, free and secure!");
		userValidation.click();
		return findBy(SIGNED_USER).getText();
	}

// signing out from account
	public void logOut() {
		signOutButton.click();
	}

	public String getSignedOutMessage() {
		return signInLink.getText();
	}

// Checking message on invalid credentials
	public String getErrorOnInvalidCreds() {
//		Alert alert = getDriver().switchTo().alert();
		return findBy(ERROR_ON_MAIL_CREDS).getText();	
	}

	
	
}
