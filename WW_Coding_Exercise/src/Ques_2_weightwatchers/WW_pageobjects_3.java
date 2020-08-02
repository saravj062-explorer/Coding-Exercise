package Ques_2_weightwatchers;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

public class WW_pageobjects_3  extends PageObject 
{
	
	public WW_pageobjects_3(WebDriver driver) {
		super(driver);
		
	}

	public static HashMap<String, Integer> associate_slots = null;
	
	@FindBy(className = "locationName-1jro_")
	WebElement locationname;

	@FindBys(@FindBy(className = "day-NhBOb"))
	List<WebElement> workshopschedule;
	
	public String loc_getText() 
	{
		return locationname.getText();
	}
	
	// Finding the schedule

	public void printmeeting(String DAY) {
		for (WebElement sch : workshopschedule) {

			WebElement DayofWeek = sch.findElement(By.className("dayName-1UpF5"));
			String testtext = DayofWeek.getText();
			if (testtext.equalsIgnoreCase(DAY)) {

				List<WebElement> sch_details = sch.findElements(By.className("meeting-14qIm"));
				associate_slots = new HashMap<String, Integer>();
				for (WebElement detail : sch_details) {
					List<WebElement> sch_data = detail.findElements(By.tagName("span"));
					for (WebElement sch1 : sch_data) {
						if (sch1.getAttribute("class").isEmpty()) {
							String associate = sch1.getText();
							Integer value = associate_slots.get(associate);
							if (value == null) {
								associate_slots.put(associate, 1);
							} else {
								associate_slots.put(associate, value + 1);
							}
						}
					}

				}
				if (associate_slots != null) {
					for (String associateslot : associate_slots.keySet()) {
						System.out.println(associateslot + "  " + associate_slots.get(associateslot));
						System.out.println();
					}
				}

				break;
			}

		}

	}
}
