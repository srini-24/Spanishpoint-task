package com.spanishpoint.task;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Spanishpoint {
	
public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver",".\\Drivers\\chromedriver_107.exe");
		WebDriver driver = new ChromeDriver();
		
		By solution_loc=By.xpath("//div[contains(@id,'menu')]//li//span[contains(text(),'Solutions & Services')]");
		By moderwork_loc=By.xpath("//ul//li[contains(@id,'menu')]//span[contains(text(),'Modern Work')]");
		By modernwork_header=By.xpath("//h2[contains(text(),'Modern Workplace Solutions')]");
		By employee_exp_loc=By.xpath("//div[contains(@class,'vc_tta-tabs-container')]//span[contains(text(),'Employee Experience')]");
		By engaging_loc=By.xpath("//h3[contains(text(),'Employee Experience')]/following-sibling::div//p//strong");
		By join_loc=By.xpath("//a[contains(text(),'Join Our')]");
		By learnmore_loc=By.xpath("//h3[contains(text(),'Hybrid')]/following-sibling::div//a[contains(text(),'Learn More')]");
		
    	String baseUrl = "https://www.spanishpoint.ie/";
        String expected_text = "Engaging, Mobile Intranet and Digital Workspace collaboration solution.";
        driver.get(baseUrl);
        Thread.sleep(2000);
        driver.manage().window().maximize();
        Thread.sleep(2000);
        Actions action=new Actions(driver);
        action.moveToElement(driver.findElement(solution_loc)).perform();
        Thread.sleep(2000);
        driver.findElement(moderwork_loc).click();
        Thread.sleep(2000);
        ScrollUpOrDown(driver, modernwork_header);
        try{
        	driver.findElement(modernwork_header).isDisplayed();
        }catch(Exception e){
        	System.out.println(e);
        }
        
        Thread.sleep(3000);
        try{
        	
        	ScrollUpOrDown(driver, join_loc);
        	driver.findElement(employee_exp_loc).click();
        }catch(Exception e){
        	System.out.println(e);
        }
        
        ScrollUpOrDown(driver, engaging_loc);
        String text=driver.findElement(engaging_loc).getText();
        if(expected_text.contentEquals(text)){
            System.out.println("Text Message Displayed");
        } else {
            System.out.println("Text Message Display Failed");
        }
       
        Thread.sleep(3000);
        driver.quit();
       
    }


public static boolean ScrollUpOrDown(WebDriver driver,By ele){
	try{
		WebElement element=driver.findElement(ele);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(2000);
		driver.findElement(ele).isDisplayed();
	}catch(Exception e){
		return false;
	}
	return true;
}
}
