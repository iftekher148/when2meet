package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class When2MeetTask {
    @Test
    public void testClass() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.when2meet.com/");
        driver.manage().window().maximize();

        //Create a Event
        WebElement eventNameInput = driver.findElement(By.xpath("//input[@id='NewEventName']"));
        eventNameInput.clear();
        eventNameInput.sendKeys("My Test");

        //Select start & end Date

        WebElement startDateInput =driver.findElement(By.xpath("//div[@id='Day-2-7']"));
        startDateInput.click();
        WebElement endDateInput = driver.findElement(By.xpath("//div[@id='Day-3-5']"));
        endDateInput.click();

        //Select start & end Time
        WebElement startTimeInput = driver.findElement(By.xpath("//select[@name='NoEarlierThan']"));
        Select select = new Select(startTimeInput);
        select.selectByValue("8");
        WebElement endTimeInput = driver.findElement(By.xpath("//select[@name='NoLaterThan']"));
        Select select1 = new Select(endTimeInput);
        select1.selectByValue("18");

        //Create Event
        WebElement createEventButton = driver.findElement(By.xpath("//input[@value='Create Event']"));
        createEventButton.click();

        //UserName & Password
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='name']")));

        WebElement nameInput= driver.findElement(By.xpath("//input[@id='name']"));
        nameInput.sendKeys("Hello");
        WebElement passwordInput = driver.findElement(By.xpath("//input[@id='password']"));
        passwordInput.sendKeys("12345");
        WebElement signInButton = driver.findElement(By.xpath("    //input[@value='Sign In']"));
        signInButton.click();


        //Time slot between 10 -> 11 AM   
            WebElement availabilityStartTime = driver.findElement(By.xpath("//div[@id='YouTime1719028800']"));
            wait.until(ExpectedConditions.elementToBeClickable(availabilityStartTime));
            availabilityStartTime.click();
            WebElement availabilityEndTime = driver.findElement(By.xpath("//div[@id='YouTime1719032400']"));
            wait.until(ExpectedConditions.elementToBeClickable(availabilityEndTime));
            availabilityEndTime.click();

            WebElement availabilityStartTime1 = driver.findElement(By.xpath("//div[@id='YouTime1719460800']"));
            wait.until(ExpectedConditions.elementToBeClickable(availabilityStartTime1));
            availabilityStartTime1.click();
            WebElement availabilityEndTime1 = driver.findElement(By.xpath("//div[@id='YouTime1719464400']"));
            wait.until(ExpectedConditions.elementToBeClickable(availabilityEndTime1));
            availabilityEndTime1.click();

        driver.close();
    }
}
