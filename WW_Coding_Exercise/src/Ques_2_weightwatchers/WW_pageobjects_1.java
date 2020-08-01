package Ques_2_weightwatchers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WW_pageobjects_1 {
	WebDriver ldriver;

	WW_pageobjects_1(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(className = "Icon_icon__wrapper__3dIsp")
	WebElement FindaWorkshop;
	
	//Click on Find a Workshop
	public void clickFindaWorkshop()
	{
		FindaWorkshop.click();

   }
	

	
	
	
	
}
