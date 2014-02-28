package net.thucydides.showcase.jbehave;

import java.io.File;

import org.jbehave.core.annotations.AfterStories;
import org.jbehave.core.annotations.BeforeStories;
import org.openqa.selenium.WebDriver;

import net.thucydides.jbehave.ThucydidesJUnitStories;

public class AcceptanceTestSuite extends ThucydidesJUnitStories {
	
	WebDriver driver;
	
	@BeforeStories
	public void start(){
		File file = new File("lib\\IEDriverServer.exe");
		System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
	}
	
	@AfterStories
	public void finish(){
		if(driver != null){
			driver.quit();
		}
	}
}
