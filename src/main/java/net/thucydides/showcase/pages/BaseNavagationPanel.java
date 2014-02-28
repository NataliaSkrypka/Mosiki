package net.thucydides.showcase.pages;

import org.openqa.selenium.WebDriver;

import net.thucydides.core.pages.PageObject;

public class BaseNavagationPanel extends PageObject {
	
	//TODO appropriate locators, these made from BaseNavigator.java
	
	private static final String RECXPRESS_LINK = "[value=recxpress]";
	private static final String OPERATION_CONSOLE_LINK = "[value=operationconsole]";
	private static final String RECONCILATION_LINK = "[value=reconcilation]";
	
	public BaseNavagationPanel (WebDriver driver){
		super(driver);
		waitFor(RECXPRESS_LINK);
		waitFor(OPERATION_CONSOLE_LINK);
	}
	
	public void clickOnRecXpressLink(){
		findBy(RECXPRESS_LINK).then().click();
	}
	
	public void clickOnOperationConsoleLink(){
		findBy(OPERATION_CONSOLE_LINK).then().click();
	}
	
	public void clickOnReconcilationLink(){
		findBy(RECONCILATION_LINK).then().click();
	}

}
