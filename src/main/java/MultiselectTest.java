import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

/*Launch new Browser
Open “http://toolsqa.wpengine.com/automation-practice-form/”
Select ‘Selenium Commands’ Multiple selection box ( Use Name locator to identify the element )
Select option ‘Browser Commands’  and then deselect it (Use selectByIndex and deselectByIndex)
Select option ‘Navigation Commands’  and then deselect it (Use selectByVisibleText and deselectByVisibleText)
Print and select all the options for the selected Multiple selection list.
Deselect all options
Close the browse*/


public class MultiselectTest {
	
	@Test
	public void startup() throws InterruptedException
	{
		WebDriver driver = new FirefoxDriver();
		 
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
 		driver.get("http://toolsqa.wpengine.com/automation-practice-form");
 
 		/*WebElement selmulti=driver.findElement(By.name("selenium_commands"));
		Select oSelect = new Select(selmulti);
		oSelect.selectByIndex(0);
		oSelect.deselectByIndex(0);
		oSelect.selectByVisibleText("Navigation Commands");
		oSelect.deselectByVisibleText("Navigation Commands");
		List<WebElement> alloptions=oSelect.getOptions();
		int sizeSelected=alloptions.size();
		//ismultiple()-This tells whether the SELECT element support multiple selecting options 
		//at the same time or not. This accepts nothing by returns boolean value(true/false).
		Boolean result=oSelect.isMultiple();
		System.out.println("Result is "+result);
		for(int i=0;i<=sizeSelected;i++)
		{
			String allOptions=oSelect.getOptions().get(i).getText();
			System.out.println("All options"+allOptions);
			oSelect.selectByIndex(i);
			Thread.sleep(3000);
			oSelect.deselectByIndex(i);
			
		}
		*/
 		
 		driver.findElement(By.xpath("//select[@id='selenium_commands']/option[1]")).click();
 		Actions act=new Actions(driver);
 		WebElement element1=driver.findElement(By.xpath("//select[@id='selenium_commands']/option[1]"));
 		act.keyDown(Keys.CONTROL).click(element1).keyUp(Keys.CONTROL).build().perform();
 		//To deselect that selected element
 		element1.click();
 		
 		
 		
 		act.click();//inside click specify the Webelement that we want to click
 	/*	Action class we can use:
 			1.click
 			2.double click
 			3.mouse over
 			4.drag and drop
 			5.kep up 
 			6.Key down*/
 
	}
	

}
