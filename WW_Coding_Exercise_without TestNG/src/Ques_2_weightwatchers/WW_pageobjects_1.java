package Ques_2_weightwatchers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WW_pageobjects_1 extends PageObject{

	public WW_pageobjects_1(WebDriver driver) {
		super(driver);
		
	}

	@FindBy(className = "Icon_icon__wrapper__3dIsp")
	WebElement FindaWorkshop;
	
	//Click on Find a Workshop
	public void clickFindaWorkshop()
	{
		FindaWorkshop.click();

   }
	

	
	
	
	
}
