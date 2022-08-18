package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(ListenersTestNG.class)
public class TestCasesFrom1To3 {
	public WebDriver driver;
	String className ="TestCasesFrom1To3";

	/**
	 * Set up browser settings
	 */

	@BeforeSuite
	public void setUp() {
		long id = Thread.currentThread().getId();
		System.out.println(className+ " @BeforeSuite. Thread id is: " + id);
		// the path for open WebSite
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\lo0ol\\" + "Downloads\\Compressed\\chromedriver_win32_2\\chromedriver.exe");
		driver = new ChromeDriver();

		// Navigate to a WebSite
		driver.navigate().to("https://store.asqgrp.com/sa_en/");

		// Maximize current window
		driver.manage().window().maximize();
	}

	/**
	 * open the website
	 */

	@BeforeMethod
	public void navigate() {
		long id = Thread.currentThread().getId();
		System.out.println(className+ " @BeforeMethod. Thread id is: " + id);
		driver.navigate().to("https://store.asqgrp.com/sa_en/customer/account/login/#");

	}

	/**
	 * Test importante notice
	 * 
	 * @throws InterruptedException
	 */
	@Test(priority = 1, groups = {
			" important notice" }, testName = " Test if the user can open the importante notice to read", description = "Verify if the user can open the long important notice for a long time to be able to read.")
	public void TC_03() throws InterruptedException {
		long id = Thread.currentThread().getId();
		System.out.println(className+ " @Test TC_03. Thread id is: " + id);
		Actions action = new Actions(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// scroll web page to the Element
		WebElement Call = driver.findElement(By.cssSelector("input[id='newsletter']"));
		js.executeScript("arguments[0].scrollIntoView();", Call);
		Thread.sleep(4000);

		// Left Click
		WebElement notice = driver.findElement(By.xpath("//a[text()='Important Notice']"));
		notice.click();
		Thread.sleep(4000);

		// Right click
		action.moveToElement(notice).build().perform();
		System.out.println("Done Mouse hover on 'Notice message");
		Thread.sleep(4000);


	}

	/**
	 * Test invalid data
	 * 
	 * @throws InterruptedException
	 */
	@Test(priority = 2, groups = {
			"Sign in" }, testName = "Test if the user cannot Sign in by invalid data", description = "Verifiy if the user cannot sign in to the website with invalid email and password")
	public void TC_02() throws InterruptedException {
		long id = Thread.currentThread().getId();
		System.out.println(className+ " @Test TC_02. Thread id is: " + id);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;


		// scroll web page to the Element
		WebElement Call = driver.findElement(By.cssSelector("input[id='newsletter']"));
		js.executeScript("arguments[0].scrollIntoView();", Call);
		Thread.sleep(4000);

		// Log in by incorrect Email & password
		WebElement Email = driver.findElement(By.xpath("//input[@id='email']"));
		Email.clear();
		Email.sendKeys("ultrapower.team5@salam.com");
		Thread.sleep(4000);

		// enter password
		WebElement pass = driver.findElement(By.xpath("(//input[@id='pass'])[1]"));
		pass.clear();
		pass.sendKeys("12345");
		Thread.sleep(4000);

		WebElement signinbtn2 = driver.findElement(By.xpath("(//button[@id='send2'])[1]"));
		signinbtn2.click();
		Thread.sleep(4000);

	}

	/**
	 * Test valid data
	 * 
	 * @throws InterruptedException
	 */
	@Test(priority = 3, groups = {
			"Sign in" }, testName = " Test if the user can Sign in by valid data", description = " Verifiy if the user can sign in to the website with valid email and password")
	public void TC_01() throws InterruptedException {
		long id = Thread.currentThread().getId();
		System.out.println(className+ " @Test TC_01. Thread id is: " + id);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		// scroll web page to the Element
		WebElement Call = driver.findElement(By.cssSelector("input[id='newsletter']"));
		js.executeScript("arguments[0].scrollIntoView();", Call);
		Thread.sleep(4000);

		// Log in by correct Email & password
		WebElement Email = driver.findElement(By.xpath("//input[@id='email']"));
		Email.clear();
		Email.sendKeys("ultrapower.team5@gmail.com");
		Thread.sleep(4000);

		// enter password
		WebElement pass = driver.findElement(By.xpath("(//input[@id='pass'])[1]"));
		pass.clear();
		pass.sendKeys("@@UltraP0wer");
		Thread.sleep(4000);

		WebElement signinbtn = driver.findElement(By.xpath("(//button[@id='send2'])[1]"));
		signinbtn.click();
		Thread.sleep(4000);

	}

	/**
	 * Tear down the setup after test completes
	 */
	@AfterSuite
	public void terminateBrowser() {
		long id = Thread.currentThread().getId();
		System.out.println(className+ " @AfterSuite. Thread id is: " + id);
		// Close the browser
		driver.close();

		// Quit the browser
		driver.quit();
	}
}
