package com.practice;

import java.util.Set;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;


/*1) Launch new Browser

2) Open URL “http://toolsqa.wpengine.com/automation-practice-switch-windows/”

3) Get Window name (Use GetWindowHandle command)

4) Click on Button “New Message Window”, it will open a Pop Up Window

5) Get all the Windows name ( Use GetWindowHandles command)

6) Close the Pop Up Window (Use Switch Command to shift window)*/

public class WindowTest {
	
	@Test
	public void startup() throws InterruptedException
	{
	WebDriver driver = new FirefoxDriver();
	driver.manage().window().maximize();
	driver.get("http://toolsqa.wpengine.com/automation-practice-switch-windows/");
	driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	String currentwindow=driver.getWindowHandle();
	System.out.println("Window Name is "+currentwindow);
	WebElement windowclick=driver.findElement(By.xpath("//button[contains(text(),'New Message Window')]"));
	windowclick.click();
	Thread.sleep(3000);
	Set<String> allwin=driver.getWindowHandles();
	System.out.println("allwin");
	 for (String handle1 : allwin) {
		 
     	System.out.println(handle1);
     	driver.switchTo().window(handle1);
     	Thread.sleep(33000);

     	}
	 driver.close();
	
	
	
	
	
}
}
