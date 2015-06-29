package net.thucydides.showcase.jbehave;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.jbehave.core.annotations.AfterStories;
import org.jbehave.core.annotations.BeforeStories;
import org.jbehave.core.io.CodeLocations;
import org.jbehave.core.io.StoryFinder;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import net.thucydides.jbehave.ThucydidesJUnitStories;

public class AcceptanceTestSuite extends ThucydidesJUnitStories {
	
	WebDriver driver;
	@BeforeStories
	public void start(){
		File file = new File("lib\\FirefoxDriverServer.exe");
		//System.setProperty("webdriver.ie.driver", file.getAbsolutePath());  
		System.setProperty("webdriver.Firefox.driver", file.getAbsolutePath());  
	}
	
	@Override
	public List<String> storyPaths() {
		List<String> storyPath = new ArrayList<String>();
		String codeLocation = CodeLocations.codeLocationFromClass(this.getClass()).getFile();
		String storyName = System.getProperty("story");
		if (storyName != null) {
			String[] stories = storyName.split(";");
			storyPath = new StoryFinder().findPaths(codeLocation, Arrays.asList(stories), Arrays.asList(""));
		} else {
			storyPath = super.storyPaths();
		}
		return storyPath;
	}
	
	@AfterStories
	public void finish(){
		if(driver != null){
			driver.quit();
		}
	}
}
