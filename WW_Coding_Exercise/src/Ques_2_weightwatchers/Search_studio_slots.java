package Ques_2_weightwatchers;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import ExtentReport.ExtentReport_Imp;

public class Search_studio_slots {
	static WebDriver driver;

	@Test
	public static void searchstudio()  {
		try{
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.weightwatchers.com/us/");
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		driver.manage().window().maximize();
		String Actualtitle = driver.getTitle();

		
		// Replacing non breaking space with space"
		Actualtitle = Actualtitle.replaceAll(String.valueOf((char) 160), " ");
		String Expectedtitle = "WW (Weight Watchers): Weight Loss & Wellness Help | WW USA";
	
		Assert.assertEquals(Actualtitle, Expectedtitle, "Actual Title is not as Expected");	
		ExtentReport_Imp.test.log(Status.PASS, "Home Page - Actual Title matches the Expected Title");
		WW_pageobjects_1 pageobj1 = new WW_pageobjects_1(driver);
		pageobj1.FindaWorkshop.click();
		WebDriverWait wait = new WebDriverWait(driver, 3);
		wait.until(ExpectedConditions.titleContains("Meetings Near You | WW USA"));
		String Act_workshop_pagetitle = driver.getTitle();

		// Replacing non breaking space with space"
		Act_workshop_pagetitle = Act_workshop_pagetitle.replaceAll(String.valueOf((char) 160), " ");
		String Exp_workshop_pagetitle = "Find WW Studios & Meetings Near You | WW USA";

		Assert.assertEquals(Act_workshop_pagetitle, Exp_workshop_pagetitle, "Actual Title is not as Expected Title");
		ExtentReport_Imp.test.log(Status.PASS, "Find Workshop Page - Actual Title matches the Expected Title");
		WW_pageobjects_2 pageobj2 = new WW_pageobjects_2(driver);
		WW_pageobjects_3 pageobj3 = new WW_pageobjects_3(driver);
		pageobj2.clickLocationSearch();
		pageobj2.LocationSearchInput();
		pageobj2.SearchArrow();
		
		
		//Printing the FIRST SEARCH RESULT & it's DISTANCE
		String firstresultname = pageobj2.fr_getText();
		String firstDistance = pageobj2.fd_getText();
		System.out.println("The first search result Title :  " + firstresultname);
		System.out.println("The first search result's Distance  : " + firstDistance);
		System.out.println();
		pageobj2.SearchResultClick();

			
		String locationname = pageobj3.loc_getText();

		// Checking if the title of the 1st search result is same as the 1st search result location page title
		Assert.assertEquals(firstresultname, locationname,
				"The First result name in the Find Workshops page and name in specific location page are not same");
		ExtentReport_Imp.test.log(Status.PASS, "The First result name in the Find Workshops page and name in specific location page are same");
		
		
		ArrayList<String> inputdayslist= WW_pageobjects_3.daysofweek();
		Scanner inp = new Scanner(System.in);
		System.out.println("Enter the day to print meetings of the day by Associate Name");
		System.out.println("Hint : Input should be of 3 characters of the day like  " + inputdayslist);
		System.out.println();
		String inputday = inp.nextLine();
		ExtentReport_Imp.test.log(Status.INFO, "Finding the slots of associate on " + inputday + ".");
		if (inputdayslist.contains(inputday)) 
		{
			pageobj3.printmeeting(inputday);
			ExtentReport_Imp.test.log(Status.PASS, "Retrieved the slots of associate on " + inputday + ".");
		}
		else {
			System.out.println("Enter a valid input day name. Refer Hint");
			Assert.assertTrue(false);
			ExtentReport_Imp.test.log(Status.FAIL, "The provided input day is not valid");
		
		inp.close();
		}}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
		// Closing the browser window
		driver.quit();	
		}

		

	}
	
	}
	
	

