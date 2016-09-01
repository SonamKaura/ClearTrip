package com.gspann.com;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

@Listeners(com.gspann.com.MyListener.class)
public class ClearTripTest {

	static public WebDriver driver;

	@Parameters("browser")
	@BeforeClass
	public void startup(@Optional  String browsertype)
	{
		browsertype="firefox";
		if (browsertype.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
		}
		/*else{
			System.setProperty("webdriver.chrome.driver", "D://IMPTASPECTS//Selenium Learning//chromedriver_win32//chromedriver.exe");
			driver=new ChromeDriver();
		}*/
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.cleartrip.com/");

	}

	@Parameters({"From","Destionation"})
	@Test
	public void testHomePage(@Optional String fromcity,@Optional String destinationcity) throws InterruptedException
	{
		fromcity="Jaipur";
		destinationcity="Delhi";

		SearchFlight ctSearchFlight=new SearchFlight(driver);
		ctSearchFlight.clickSearchFlight(fromcity,destinationcity);
		System.out.println("done1");
		//Assert.assertTrue(false,"");

		boolean msgverify=ctSearchFlight.verifyMoreOptionMsg();
		//To verify the more message is present or not
		Assert.assertEquals(msgverify, true);
		System.out.println("done2");

		boolean oneWayRadio=ctSearchFlight.verifyonewayisSelected();
		Assert.assertTrue(oneWayRadio, "One way Radio is not selected");
		System.out.println("done3");

		boolean radioBtnresent=ctSearchFlight.verifyradiobtn();	
		Assert.assertTrue(radioBtnresent, "Radio Buttons are not present");
		System.out.println("done4");

		ctSearchFlight.clickSearchBtn();
		System.out.println("done5");

		String pageTitle=ctSearchFlight.verifytitlePage();
		String currenttitle="Cleartrip | Jaipur → New Delhi";
		Assert.assertTrue(pageTitle.equalsIgnoreCase(currenttitle), "Title Mismatch");
		System.out.println("done6");

		ctSearchFlight.clickPaytymMsg();
		System.out.println("done7");

		ctSearchFlight.switchWindow();
		System.out.println("window switched");

		Thread.sleep(3000);
		ctSearchFlight.switchFrame();
		System.out.println("SwitswitchFrameched to Frame");

		ctSearchFlight.clickSearchFlight();
		System.out.println("done10");

		String popupmsg=ctSearchFlight.verifypopupmsg();
		System.out.println("Popup Message is "+popupmsg);
		Boolean popupdisplay=ctSearchFlight.verifypopupdisplay();
		Assert.assertTrue(popupdisplay, "Popup message donot appear");
		System.out.println("done11");
		
		//To come out of the frame
		driver.switchTo().defaultContent();
		System.out.println("we are out of the frame");
		
		boolean subscribeBtn=ctSearchFlight.verifySubscribebtn();
		Assert.assertEquals(subscribeBtn, true);
		
		//Assert.assertEquals(popupdisplay, true);
	}	

}