package Ques_2_weightwatchers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WW_pageobjects_2 extends PageObject

{
	
	public WW_pageobjects_2(WebDriver driver) {
		super(driver);
		
	}
	@FindBy(id = "location-search")
	WebElement LocationSearch;

	@FindBy(className = "rightArrow-daPRP")
	WebElement Search;

	@FindBy(className = "container-3SE46")
	WebElement searchresult;

	@FindBy(className = "linkUnderline-1_h4g")
	WebElement firstResult;
	
	@FindBy(className = "distance-OhP63")
	WebElement firstDistance;
	
	public void clickLocationSearch() {

		LocationSearch.click();

	}

	public void LocationSearchInput() {

		LocationSearch.sendKeys("10011");
	}

	public void SearchArrow() {

		Search.click();

	}
	public void SearchResultClick() {

		firstResult.click();

	}
	public String fr_getText() 
	{
		return firstResult.getText();
	}
	public String fd_getText() 
	{
		return firstDistance.getText();
	}
}