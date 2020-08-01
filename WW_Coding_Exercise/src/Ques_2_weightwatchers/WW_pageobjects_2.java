package Ques_2_weightwatchers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WW_pageobjects_2

{
	WebDriver ldriver;

	WW_pageobjects_2(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(id = "location-search")
	WebElement LocationSearch;

	@FindBy(className = "rightArrow-daPRP")
	WebElement Search;

	@FindBy(className = "container-3SE46")
	WebElement searchresult;

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

		searchresult.click();

	}
}