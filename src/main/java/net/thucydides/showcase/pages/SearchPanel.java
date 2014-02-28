package net.thucydides.showcase.pages;

import org.openqa.selenium.WebDriver;

import net.thucydides.core.pages.PageObject;

public class SearchPanel extends PageObject{
	
	//TODO appropriate locators
	
	private static final String CLIENT_DROPDOWN = "";
	private static final String FROM_DATE_INPUT = "";
	private static final String TO_DATE_INPUT = "";
	private static final String FUND_DROPDOWN = "";
	private static final String REC_INDEX_INPUT = "";
	private static final String REC_TYPE_DROPDOWN = "";
	
	public SearchPanel(WebDriver driver){
		super(driver);
		waitFor(CLIENT_DROPDOWN);
	}
	
	public void chooseClient(String client){
		findBy(CLIENT_DROPDOWN).selectByVisibleText(client);
	}

}
