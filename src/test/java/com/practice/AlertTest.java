package com.practice;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class AlertTest {
	@Test
	public void startup(){
	
	WebDriver driver=new FirefoxDriver();
	driver.get("http://toolsqa.wpengine.com/automation-practice-switch-windows/");
	driver.findElement(By.xpath("//button[@id='alert']")).click();
	Alert al=driver.switchTo().alert();
	al.dismiss();
	

}
}
