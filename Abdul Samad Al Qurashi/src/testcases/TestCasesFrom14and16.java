package testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(ListenersTestNG.class)
public class TestCasesFrom14and16 {
	public WebDriver driver;
	String className ="TestCasesFrom14and16";

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
	 * Sign in to the website
	 * @throws InterruptedException 
	 */

	@BeforeTest
	public void signIn() throws InterruptedException {
		long id = Thread.currentThread().getId();
		System.out.println(className+ " @BeforeTest. Thread id is: " + id);
		
		// wait until the login form appears.
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//body/div/header/div/ul/li[@data-label='or']/a[1]")));

		// click on sign-in
		WebElement signIn = driver.findElement(By.xpath("//body/div/header/div/ul/li[@data-label='or']/a[1]"));
		signIn.click();
		Thread.sleep(4000);


		// email
		WebElement email = driver.findElement(By.xpath("//input[@title='Email']"));
		wait.until(ExpectedConditions.elementToBeClickable(email));
		email.sendKeys("ultrapower.team5@gmail.com");
		Thread.sleep(4000);


		// email
		WebElement password = driver.findElement(By.xpath("//input[@title='Password']"));
		wait.until(ExpectedConditions.elementToBeClickable(email));
		password.sendKeys("@@UltraP0wer");
		Thread.sleep(4000);


		// next1 button
		WebElement next1 = driver.findElement(By.xpath("//button[@class='action login button-secondary']"));
		next1.click();
		Thread.sleep(4000);

	}

	/**
	 * Test add to cart without select the Bottle Capacity
	 * 
	 * @throws InterruptedException
	 */
	@Test(priority = 1, groups = {
			"Create New Order" }, testName = "Test add to cart function", description = "Verify if the user can continue ordering the product without select the Bottle Capacity")
	public void TC_14() throws InterruptedException {
		long id = Thread.currentThread().getId();
		System.out.println(className+ " @Test TC_14. Thread id is: " + id);

		// click on "Shop By Product Line"
		driver.findElement(By.xpath("//span[text()='Shop By Product Line' ]")).click();
		Thread.sleep(4000);


		// click on perfume
		driver.findElement(By.xpath(
				"//a[@class='product photo product-item-photo']//img[@alt='Damascena Collection-Rose Kazanlak']"))
				.click();
		Thread.sleep(4000);

		// add to cart
		WebElement add = driver.findElement(By.xpath("//button[@id='product-addtocart-button']"));
		add.click();
		Thread.sleep(4000);

		// wait until pop up window appears.
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[5]/aside[2]/div[2]/header/button")))
				.click();
		Thread.sleep(4000);

	}

	/**
	 * Test add to cart without select the Bottle Capacity
	 * 
	 * @throws InterruptedException
	 */
	@Test(priority = 2, groups = {"Create New Order" }, 
	testName = " Test select the shipping details function ",
	description = "test if the user cannot continued payment without select the shipping details")
	public void TC_16() throws InterruptedException {
		long id = Thread.currentThread().getId();
		System.out.println(className+ " @Test TC_16. Thread id is: " + id);
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		JavascriptExecutor js = (JavascriptExecutor) driver;


		// click on cart icon
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[class='action showcart']")));
		driver.findElement(By.cssSelector("a[class='action showcart']")).click();
		Thread.sleep(4000);

		// click on Secure Checkout
		wait.until(ExpectedConditions.elementToBeClickable(By.id("top-cart-btn-checkout")));
		WebElement button = driver.findElement(By.id("top-cart-btn-checkout"));
		button.click();
		Thread.sleep(4000);

		// chopping details
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//h1[normalize-space()='Shipping Details']")));
		// scroll web page to the Element
		WebElement shoppingdetails = driver.findElement(By.xpath("//h1[normalize-space()='Shipping Details']"));
		js.executeScript("arguments[0].scrollIntoView();", shoppingdetails);
		shoppingdetails.click();
		Thread.sleep(4000);


		WebElement submitbutton = driver.findElement(By.xpath("(//button[@data-role='opc-continue'])[1]"));
		boolean actualValue = submitbutton.isEnabled();

		if (actualValue)
			System.out.println("Button is disabled");
		else
			System.out.println("Button is enabled");
		Thread.sleep(4000);
	}

	/**
	 * log out from website
	 * 
	 * @throws InterruptedException
	 */
	@AfterTest
	public void signOut() throws InterruptedException {
		long id = Thread.currentThread().getId();
		System.out.println(className+ " @AfterTest. Thread id is: " + id);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		// icon
		WebElement icon = driver.findElement(By.xpath(
				"//ul[@class='header links top-links sticky-top-links']//li[@class='customer-welcome dropdown']"));
		wait.until(ExpectedConditions.elementToBeClickable(icon));
		icon.click();
		Thread.sleep(4000);


		// logOut
		WebElement signOut = driver
				.findElement(By.xpath("//div[@class='customer-menu visible']//a[normalize-space()='Log out']"));
		wait.until(ExpectedConditions.elementToBeClickable(signOut));
		signOut.click();
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

