package com.gspann.com;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SearchFlight {

	WebDriver driver;

	SearchFlight(WebDriver d)
	{
		this .driver=d;
	}

	private By FromLoc=By.xpath("//input[@id='FromTag']");
	private By DestionationLoc=By.xpath("//input[@id='ToTag']");
	private By CalenderIconLoc=By.xpath("//section[@class='row fieldRow searchBox']/div[1]/dl/dd/div/a/i");
	private By dateLoc=By.xpath("//div[@class='monthBlock last']/table/tbody/tr[5]/td[3]");
	private By adultsLoc=By.xpath("//select[@id='Adults']");
	private By moreOptionMesLoc=By.xpath("//a[@id='MoreOptionsLink']");
	private By onewayLoc=By.xpath("	//label[@title='One way']/input");
	private By radioBtnLoc=By.xpath("//nav[@class='row fieldRow tripType']/ul");
	private By searchBtnLoc=By.xpath("//input[@id='SearchBtn']");
	private By paytymFlightOverLoc=By.xpath("//a[@class='span span22 truncate offerLink']");
	private By frameLoc=By.xpath("//iframe[@name='bookingengine']");
	private By flightsearchLoc=By.xpath("//form[@id='AirSearch']/fieldset[6]/button");
	private By msgpopupLoc=By.xpath("//div[@id='errors']/div/span");
	private By subscibeLoc=By.xpath("//input[@id='edit-submit']");
	
			



	public void clickSearchFlight(String fromto,String destinationTo) throws InterruptedException
	{
		WebElement From=driver.findElement(FromLoc);
		From.sendKeys(fromto);
		Thread.sleep(3000);

		WebElement Destionation=driver.findElement(DestionationLoc);
		Destionation.sendKeys(destinationTo);
		Thread.sleep(3000);

		WebElement CalenderIcon=driver.findElement(CalenderIconLoc);
		CalenderIcon.click();
		System.out.println("Calender Icon is clicked");
		Thread.sleep(3000);

		WebElement date=driver.findElement(dateLoc);
		date.click();
		System.out.println("Date is clicked");
		Thread.sleep(3000);

		WebElement adults=driver.findElement(adultsLoc);
		Select selectadult =new Select(adults);
		selectadult.selectByIndex(2);
		System.out.println("Adults is clicked");
		Thread.sleep(3000);


	}


	public boolean verifyMoreOptionMsg()
	{
		WebElement moreOption=driver.findElement(moreOptionMesLoc);
		String msg1=moreOption.getText();
		boolean msg2=moreOption.isDisplayed();
		return msg2;

	}

	public boolean verifyonewayisSelected()
	{
		WebElement oneway=driver.findElement((onewayLoc));
		boolean onewaradio=oneway.isSelected();
		return onewaradio;
	}

	public Boolean verifyradiobtn()
	{
		WebElement radioBtn=driver.findElement((radioBtnLoc));
		Boolean radiobt=radioBtn.isDisplayed();
		return  radiobt;

	}

	public void clickSearchBtn() throws InterruptedException
	{
		WebElement searchBtn=driver.findElement((searchBtnLoc));
		searchBtn.click();
		Thread.sleep(4000);
		String title=driver.getTitle();

	}

	public String verifytitlePage(){

		String title=driver.getTitle();
		return title;
	}

	public void clickPaytymMsg()
	{
		WebElement paytymFlightOver=driver.findElement((paytymFlightOverLoc));
		paytymFlightOver.click();
	}

	public void switchWindow()
	{
		String parent=driver.getWindowHandle();
		Set<String> allwin=driver.getWindowHandles();
		for(String eachwin:allwin)
		{
			if(!eachwin.equals(parent))
			{
				driver.switchTo().window(eachwin);
				break;
			}
		}
	}

	public void switchFrame()
	{
		WebElement frame=driver.findElement(frameLoc);
		driver.switchTo().frame(frame);
	}

	public void clickSearchFlight()
	{
		WebElement flightsearch=driver.findElement(flightsearchLoc);
		flightsearch.click();
	}

	public String verifypopupmsg()
	{
		WebElement msgpopup=driver.findElement(msgpopupLoc)	;
		String popuptext=msgpopup.getText();
		return  popuptext;
	}

	public Boolean verifypopupdisplay()
	{
		WebElement msgpopup=driver.findElement(msgpopupLoc)	;
		Boolean displaypopup=msgpopup.isDisplayed();
		return displaypopup;
	}
	
	public boolean verifySubscribebtn()
	{
		WebElement subscibe=driver.findElement(subscibeLoc);
		boolean subbtn=subscibe.isDisplayed();
		return subbtn;
		
	}










}
