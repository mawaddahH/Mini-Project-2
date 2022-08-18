package testcases;

import org.testng.annotations.Test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;

@Listeners(ListenersTestNG.class)
public class TestCasesFrom8To13 {
	public WebDriver driver;
	String className ="TestCasesFrom8To13";

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
	 * signIn to the website
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
	 * Test require field
	 * 
	 * @throws InterruptedException
	 */
	@Test(priority = 1, groups = {
			"My Account" }, testName = "Virfy if  edit Contact Information and fill all the require field then save.", description = "Edit Contact Information and fill all the require field then save the page.")
	public void TC_08() throws InterruptedException {

		long id = Thread.currentThread().getId();
		System.out.println(className+ " @Test TC_08. Thread id is: " + id);
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		WebElement edit = driver.findElement(By.xpath("//div[@class='box box-information']//a[@class='action edit']"));
		wait.until(ExpectedConditions.elementToBeClickable(edit));
		edit.click();
		Thread.sleep(4000);

		WebElement firstName = driver.findElement(By.xpath("//input[@id='firstname']"));
		firstName.clear();
		firstName.sendKeys("Ultra");
		Thread.sleep(4000);

		WebElement lastName = driver.findElement(By.xpath("//input[@id='lastname']"));
		lastName.clear();
		lastName.sendKeys("Power");
		Thread.sleep(4000);

		WebElement save = driver.findElement(By.xpath("//button[@title='Save']"));
		save.click();
		Thread.sleep(4000);

		WebElement error = driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[2]/div[2]/div/div/div"));
		boolean d = error.isDisplayed();
		System.out.println("error message is =" + d);
		String e = error.getText();
		System.out.println("error message is =" + e);

		Assert.assertEquals(e, "You saved the account information.");
		Thread.sleep(4000);

	}

	/**
	 * Test require field
	 * 
	 * @throws InterruptedException
	 */
	@Test(priority = 2, groups = {
			"My Account" }, testName = "Virfy if edit Contact Information and clear one the require field then save.", description = "Edit Contact Information and clear one the require field then save.")
	public void TC_09() throws InterruptedException {
		long id = Thread.currentThread().getId();
		System.out.println(className+ " @Test TC_09. Thread id is: " + id);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		WebElement edit = driver.findElement(By.xpath("//div[@class='box box-information']//a[@class='action edit']"));
		wait.until(ExpectedConditions.elementToBeClickable(edit));
		edit.click();
		Thread.sleep(4000);

		WebElement firstName = driver.findElement(By.xpath("//input[@id='firstname']"));
		firstName.clear();
		Thread.sleep(4000);

		WebElement save = driver.findElement(By.xpath("//button[@title='Save']"));
		save.click();
		Thread.sleep(4000);

		WebElement error = driver.findElement(By.xpath("//div[@id='firstname-error']"));
		boolean d = error.isDisplayed();
		System.out.println("error message " + d);
		String e = error.getText();
		System.out.println("error message " + e);

		Assert.assertEquals(e, "This is a required field.");
		Thread.sleep(4000);


	}

	/**
	 * Test Message when entering the wrong password in the change password section.
	 * 
	 * @throws InterruptedException
	 */
	@Test(priority = 3, groups = {
			"My Account" }, testName = "Virfy if click on change password and in current password will enter diffrent password from current password.", description = "Click on change password and in current password will enter diffrent password from current password.")
	public void TC_10() throws InterruptedException {
		long id = Thread.currentThread().getId();
		System.out.println(className+ " @Test TC_10. Thread id is: " + id);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		// my Account
		WebElement myAccount = driver.findElement(By.xpath("//main[@id='maincontent']//li[1]//a[1]"));
		wait.until(ExpectedConditions.elementToBeClickable(myAccount));
		myAccount.click();
		Thread.sleep(4000);


		WebElement changePassword = driver.findElement(By.xpath("//a[normalize-space()='Change Password']"));
		wait.until(ExpectedConditions.elementToBeClickable(changePassword));
		changePassword.click();
		Thread.sleep(4000);

		WebElement currentPassword = driver.findElement(By.xpath("//input[@id='current-password']"));
		currentPassword.sendKeys("123456");
		Thread.sleep(4000);

		WebElement newPassword = driver.findElement(By.xpath("//input[@id='password']"));
		newPassword.sendKeys("new@4567");
		Thread.sleep(4000);

		WebElement confirmNewPassword = driver.findElement(By.xpath("//input[@id='password-confirmation']"));
		confirmNewPassword.sendKeys("new@4567");
		Thread.sleep(4000);

		WebElement save = driver.findElement(By.xpath("//button[@title='Save']"));
		save.click();
		Thread.sleep(4000);

		WebElement error = driver.findElement(By.xpath("/html/body/div[4]/main/div[2]/div[2]/div/div"));
		boolean d = error.isDisplayed();
		System.out.println("error message is =" + d);
		String e = error.getText();
		System.out.println("error message is =" + e);

		Assert.assertEquals(e, "The password doesn't match this account. Verify the password and try again.");
		Thread.sleep(4000);


	}

	/**
	 * Test message
	 * 
	 * @throws InterruptedException
	 */
	@Test(priority = 4, groups = {
			"Address Book" }, testName = "verify if the message \"You saved the address\" appears to the user when he edits his address.", description = " check if the user can see the \"You saved the address\" message when he edits his address in \"default billing address\" successfully.")
	public void TC_12() throws InterruptedException {
		long id = Thread.currentThread().getId();
		System.out.println(className+ " @Test TC_12. Thread id is: " + id);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		// addressBook
		WebElement addressBook = driver.findElement(By.xpath("//a[normalize-space()='Address Book']"));
		wait.until(ExpectedConditions.elementToBeClickable(addressBook));
		addressBook.click();
		Thread.sleep(4000);


		// changebilling
		WebElement changebilling = driver
				.findElement(By.xpath("//div[@class='box box-address-billing']//a[@class='action edit']"));
		wait.until(ExpectedConditions.elementToBeClickable(changebilling));
		changebilling.click();
		Thread.sleep(4000);


		// city
		WebElement city = driver.findElement(By.xpath("//option[@value='Anak']"));
		wait.until(ExpectedConditions.elementToBeClickable(city));
		city.click();
		Thread.sleep(4000);


		// save
		WebElement save = driver.findElement(By.xpath("//button[@title='Save Address']"));
		wait.until(ExpectedConditions.elementToBeClickable(save));
		save.click();
		Thread.sleep(4000);

		// save
		WebElement message = driver.findElement(By.xpath("//div[contains(text(),'You saved the address.')]"));
		if (message.isDisplayed()) {
			String text = message.getText();
			Assert.assertEquals(text, "You saved the address.");
		}

		Thread.sleep(4000);

	}

	/**
	 * Test deleted the address
	 * 
	 * @throws InterruptedException
	 */
	@Test(priority = 5, groups = {
			"Address Book" }, testName = " verify if the message \"You deleted the address.\" appears to the user when he deletes his address.", description = " check if the user can see the \"You deleted the address.\" message when he deletes his address in \"additional address entries\" successfully.")
	public void TC_13() throws InterruptedException {
		long id = Thread.currentThread().getId();
		System.out.println(className+ " @Test TC_13. Thread id is: " + id);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		// addressBook
		WebElement addressBook = driver.findElement(By.xpath("//a[normalize-space()='Address Book']"));
		wait.until(ExpectedConditions.elementToBeClickable(addressBook));
		addressBook.click();
		Thread.sleep(4000);

		// delete
		WebElement delete = driver.findElement(By.xpath("(//a[@role='delete-address'])[2]"));
		wait.until(ExpectedConditions.elementToBeClickable(delete));
		delete.click();
		Thread.sleep(4000);

		// ok button
		WebElement ok = driver.findElement(By.xpath("//span[normalize-space()='OK']"));
		wait.until(ExpectedConditions.elementToBeClickable(ok));
		ok.click();
		Thread.sleep(4000);

		// isDeleteed
		WebElement isDeleteed = driver.findElement(By.xpath("//div[contains(text(),'You deleted the address.')]"));

		if (isDeleteed.isDisplayed()) {
			String text = isDeleteed.getText();
			Assert.assertEquals(text, "You deleted the address.");
		}

		Thread.sleep(4000);

	}

	/**
	 * signOut from website
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
