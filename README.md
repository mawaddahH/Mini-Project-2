# Mini-Project-2
Mini Project 2 for Track 2 - SDA - Software QA Bootcamp

# Table of Contents
* [Introduction](#introduction)
* [Codes And Screenshot](#codes-and-screenshot)
  * [Before running the code](#before-running-the-code)
  * [Code Details](#code-details)
  * [TestCasesFrom1To3 class](#testcasesfrom1to3-class)
  * [TestCasesFrom8To13 class](#testcasesfrom8to13-class)
  * [TestCasesFrom14and16 class](#testcasesfrom14and16-class)
  * [XML file](#xml-file)
* [Team Members](#team-members)

  
---
# Introduction
As Team 5 (UltraPower) we decide to use in the Mini Project 2 [Abdul samad Al Qurashi](https://store.asqgrp.com/sa_en/) website for testing using Selenium and TestNG framework.


> About [Abdul samad Al Qurashi](https://store.asqgrp.com/sa_en/) website: master of royal perfume, one of the best perfume and oud companies in the world for more than 150 years.


For more information about our Mini Prjoect 2 check the [Presentation](https://youtu.be/BxPXhKZCUUw?t=2874)

---
# Codes And Screenshot

## Before running the code
There are some steps that need to take considered:

### First:
Setup the [JDK](https://www.oracle.com/java/technologies/downloads/),[Eclipse](https://www.eclipse.org/)

And setup latest [Web Driver](https://chromedriver.chromium.org/downloads) for Chrome Driver. 

Donwload the necessary jar files:
- [Selenium](https://www.selenium.dev/downloads/) (Lastest).
- [TestNG](http://www.java2s.com/Code/Jar/t/Downloadtestng685jar.htm)  (Lastest).
- [jcommander](http://www.java2s.com/Code/Jar/j/Downloadjcommanderjar.htm)  (Lastest). 

### Second:
Add them as a library in the classpath of the project
- _click-reight on the file project >Build path > configure Bild path > Java Build Path > Libraries > classpath > add external JARs > Apply and close_

---
## Code Details
### STEP 1: In the project we created 3 classes depending on the function of our website which are:
- `Create Account`: TestCasesFrom1To3
- `Account Setting`: TestCasesFrom8To13
- `Create new order`: TestCasesFrom14and16

<p align="center">
<img src="https://user-images.githubusercontent.com/48597284/185476614-84896699-e189-42ba-9f6d-cb2f39ba9955.png" width=40% height=40%>
</p>


### STEP 2: we used TestNG `annotation` such as:
- `@BeforeSuite`: setup the web driver and browser
- `@BeforeTest`: for sign-in
- `@BeforeMethod`: navigate to the page on the website
- `@AfterTest`: for sign-out
- `@AfterSuite`: to close the browser

<p align="center">
  

https://user-images.githubusercontent.com/48597284/185479013-c9ea2e62-252c-4bf5-ae0e-5304fe6e1484.mp4


</p>


### STEP 3: we specified the `attributes` in a `@Test` annotation such as:
- `priority`: to order each test case.
- `groups`: to group the test depending on the function name.
- `testName`: name of the test case depends on the Test case document.
- `description`: added a description for each test depending on the Test case document.

<p align="center">
<img src="https://user-images.githubusercontent.com/48597284/185478863-6a46a25c-f75c-479e-bc81-1f7f77aa18a2.png" width=80% height=80%>
  
<img src="https://user-images.githubusercontent.com/48597284/185478836-849ed4d7-b0c7-473c-9a8d-28dd50d3b9a9.png" width=80% height=80%>

</p>


### STEP 4: we used a `listener` to listen to the events happening in the automation

<p align="center">

https://user-images.githubusercontent.com/48597284/185480177-c2a7c4fd-70a6-428f-a934-8a1b18538179.mp4

</p>



### STEP 5: we used an `XML file` to run these `3 classes` as parallel using `4 threads`.

<p align="center">

https://user-images.githubusercontent.com/48597284/185481143-55d18dc6-95a7-4bad-b0e7-d8eb01487f34.mp4

</p>


### STEP 6: we used the following code to take the `thread ID` for each method run in the class

```md
long id = Thread.currentThread().getId();
```
---

## TestCasesFrom1To3 class
It for `Create Account` function and it contain 3 Test cases:
- Test case `TC_03`:

```md
@Test
(priority = 1, groups = {" important notice" },
testName = " Test if the user can open the importante notice to read",
description = "Verify if the user can open the long important notice for a long time to be able to read.")
public void TC_03() throws InterruptedException {
	long id = Thread.currentThread().getId();
	System.out.println(className+ " @Test TC_03. Thread id is: " + id);
  
	Actions action = new Actions(driver);
	JavascriptExecutor js = (JavascriptExecutor) driver;

	// scroll web page to the Element
	WebElement Call = driver.findElement(By.cssSelector("input[id='newsletter']"));
	js.executeScript("arguments[0].scrollIntoView();", Call);

	// Left Click
	WebElement notice = driver.findElement(By.xpath("//a[text()='Important Notice']"));
	notice.click();

	// Right click
	action.moveToElement(notice).build().perform();
	System.out.println("Done Mouse hover on 'Notice message");
	}
```

- Test case `TC_02`:

```md
@Test
(priority = 2, groups = {"Sign in" },
testName = "Test if the user cannot Sign in by invalid data",
description = "Verifiy if the user cannot sign in to the website with invalid email and password")
public void TC_02() throws InterruptedException {
	long id = Thread.currentThread().getId();
	System.out.println(className+ " @Test TC_02. Thread id is: " + id);
		
	JavascriptExecutor js = (JavascriptExecutor) driver;

	// scroll web page to the Element
	WebElement Call = driver.findElement(By.cssSelector("input[id='newsletter']"));
	js.executeScript("arguments[0].scrollIntoView();", Call);

	// Log in by incorrect Email & password
	WebElement Email = driver.findElement(By.xpath("//input[@id='email']"));
	Email.clear();
	Email.sendKeys("ultrapower.team5@salam.com");

	// enter password
	WebElement pass = driver.findElement(By.xpath("(//input[@id='pass'])[1]"));
	pass.clear();
	pass.sendKeys("12345");

  WebElement signinbtn2 = driver.findElement(By.xpath("(//button[@id='send2'])[1]"));
	signinbtn2.click();
	}
```

- Test case `TC_01`:

```md
@Test
(priority = 3, groups = {"Sign in" },
testName = " Test if the user can Sign in by valid data",
description = " Verifiy if the user can sign in to the website with valid email and password")
public void TC_01() throws InterruptedException {
	long id = Thread.currentThread().getId();
	System.out.println(className+ " @Test TC_01. Thread id is: " + id);
		
	JavascriptExecutor js = (JavascriptExecutor) driver;
		
	// scroll web page to the Element
	WebElement Call = driver.findElement(By.cssSelector("input[id='newsletter']"));
	js.executeScript("arguments[0].scrollIntoView();", Call);

	// Log in by correct Email & password
	WebElement Email = driver.findElement(By.xpath("//input[@id='email']"));
	Email.clear();
	Email.sendKeys("ultrapower.team5@gmail.com");

	// enter password
	WebElement pass = driver.findElement(By.xpath("(//input[@id='pass'])[1]"));
	pass.clear();
	pass.sendKeys("@@UltraP0wer");

 WebElement signinbtn = driver.findElement(By.xpath("(//button[@id='send2'])[1]"));
	signinbtn.click();
	}
```
The code run without using XML file:

<p align="center">


https://user-images.githubusercontent.com/48597284/185503044-9f10a439-ef4e-4987-8fb3-61d56083f847.mp4


<img src="https://user-images.githubusercontent.com/48597284/185494398-26d9ddc0-b412-4b89-87b2-c059bbe4eeb2.png" width=80% height=80%>

</p>

---

## TestCasesFrom8To13 class
It for `Account Setting` function and it contain 5 Test cases:
- Test case `TC_08`:

```md
@Test
(priority = 1, groups = {"My Account" },
testName = "Virfy if  edit Contact Information and fill all the require field then save.",
description = "Edit Contact Information and fill all the require field then save the page.")
public void TC_08() throws InterruptedException {

	long id = Thread.currentThread().getId();
	System.out.println(className+ " @Test TC_08. Thread id is: " + id);
		
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

	WebElement edit = driver.findElement(By.xpath("//div[@class='box box-information']//a[@class='action edit']"));
	wait.until(ExpectedConditions.elementToBeClickable(edit));
	edit.click();

	WebElement firstName = driver.findElement(By.xpath("//input[@id='firstname']"));
	firstName.clear();
	firstName.sendKeys("Ultra");

	WebElement lastName = driver.findElement(By.xpath("//input[@id='lastname']"));
	lastName.clear();
	lastName.sendKeys("Power");

  WebElement save = driver.findElement(By.xpath("//button[@title='Save']"));
	save.click();

	WebElement error = driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[2]/div[2]/div/div/div"));
	boolean d = error.isDisplayed();
	System.out.println("error message is =" + d);
	String e = error.getText();
	System.out.println("error message is =" + e);

	Assert.assertEquals(e, "You saved the account information.");
	}
```

- Test case `TC_09`:

```md
@Test(priority = 2, groups = {"My Account" },
testName = "Virfy if edit Contact Information and clear one the require field then save.",
description = "Edit Contact Information and clear one the require field then save.")
public void TC_09() throws InterruptedException {
	long id = Thread.currentThread().getId();
	System.out.println(className+ " @Test TC_09. Thread id is: " + id);

	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

	WebElement edit = driver.findElement(By.xpath("//div[@class='box box-information']//a[@class='action edit']"));
	wait.until(ExpectedConditions.elementToBeClickable(edit));
	edit.click();

	WebElement firstName = driver.findElement(By.xpath("//input[@id='firstname']"));
	firstName.clear();

  WebElement save = driver.findElement(By.xpath("//button[@title='Save']"));
  save.click();

	WebElement error = driver.findElement(By.xpath("//div[@id='firstname-error']"));
	boolean d = error.isDisplayed();
	System.out.println("error message " + d);
	String e = error.getText();
	System.out.println("error message " + e);

	Assert.assertEquals(e, "This is a required field.");

	}
```

- Test case `TC_10`:

```md
@Test(priority = 3, groups = {"My Account" },
testName = "Virfy if click on change password and in current password will enter diffrent password from current password.",
description = "Click on change password and in current password will enter diffrent password from current password.")
public void TC_10() throws InterruptedException {
	long id = Thread.currentThread().getId();
	System.out.println(className+ " @Test TC_10. Thread id is: " + id);

	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

	// my Account
  WebElement myAccount = driver.findElement(By.xpath("//main[@id='maincontent']//li[1]//a[1]"));
	wait.until(ExpectedConditions.elementToBeClickable(myAccount));
	myAccount.click();

	WebElement changePassword = driver.findElement(By.xpath("//a[normalize-space()='Change Password']"));
	wait.until(ExpectedConditions.elementToBeClickable(changePassword));
	changePassword.click();

	WebElement currentPassword = driver.findElement(By.xpath("//input[@id='current-password']"));
	currentPassword.sendKeys("123456");

	WebElement newPassword = driver.findElement(By.xpath("//input[@id='password']"));
	newPassword.sendKeys("new@4567");

	WebElement confirmNewPassword = driver.findElement(By.xpath("//input[@id='password-confirmation']"));
	confirmNewPassword.sendKeys("new@4567");

	WebElement save = driver.findElement(By.xpath("//button[@title='Save']"));
	save.click();

	WebElement error = driver.findElement(By.xpath("/html/body/div[4]/main/div[2]/div[2]/div/div"));
	boolean d = error.isDisplayed();
	System.out.println("error message is =" + d);
	String e = error.getText();
	System.out.println("error message is =" + e);

	Assert.assertEquals(e, "The password doesn't match this account. Verify the password and try again.");
	}
```

- Test case `TC_12`:

```md
@Test(priority = 4, groups = {"Address Book" },
testName = "verify if the message \"You saved the address\" appears to the user when he edits his address.",
description = " check if the user can see the \"You saved the address\" message when he edits his address in \"default billing address\" successfully.")
public void TC_12() throws InterruptedException {
	long id = Thread.currentThread().getId();
	System.out.println(className+ " @Test TC_12. Thread id is: " + id);

	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

	// addressBook
	WebElement addressBook = driver.findElement(By.xpath("//a[normalize-space()='Address Book']"));
	wait.until(ExpectedConditions.elementToBeClickable(addressBook));
	addressBook.click();
  
	// changebilling
	WebElement changebilling = driver.findElement(By.xpath("//div[@class='box box-address-billing']//a[@class='action edit']"));
	wait.until(ExpectedConditions.elementToBeClickable(changebilling));
	changebilling.click();

  // city
	WebElement city = driver.findElement(By.xpath("//option[@value='Anak']"));
	wait.until(ExpectedConditions.elementToBeClickable(city));
	city.click();

	// save
	WebElement save = driver.findElement(By.xpath("//button[@title='Save Address']"));
	wait.until(ExpectedConditions.elementToBeClickable(save));
	save.click();

	// save
	WebElement message = driver.findElement(By.xpath("//div[contains(text(),'You saved the address.')]"));
	if (message.isDisplayed()) {
		String text = message.getText();
		Assert.assertEquals(text, "You saved the address.");
	}
}
```

- Test case `TC_13`:

```md
@Test(priority = 5, groups = {"Address Book" },
testName = " verify if the message \"You deleted the address.\" appears to the user when he deletes his address.",
description = " check if the user can see the \"You deleted the address.\" message when he deletes his address in \"additional address entries\" successfully.")
public void TC_13() throws InterruptedException {
	long id = Thread.currentThread().getId();
	System.out.println(className+ " @Test TC_13. Thread id is: " + id);

	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
  
	// addressBook
	WebElement addressBook = driver.findElement(By.xpath("//a[normalize-space()='Address Book']"));
	wait.until(ExpectedConditions.elementToBeClickable(addressBook));
	addressBook.click();

	// delete
	WebElement delete = driver.findElement(By.xpath("(//a[@role='delete-address'])[2]"));
	wait.until(ExpectedConditions.elementToBeClickable(delete));
	delete.click();

	// ok button
	WebElement ok = driver.findElement(By.xpath("//span[normalize-space()='OK']"));
	wait.until(ExpectedConditions.elementToBeClickable(ok));
	ok.click();

	// isDeleteed
	WebElement isDeleteed = driver.findElement(By.xpath("//div[contains(text(),'You deleted the address.')]"));

	if (isDeleteed.isDisplayed()) {
		String text = isDeleteed.getText();
		Assert.assertEquals(text, "You deleted the address.");
	}
}
```
The code run without using XML file:

<p align="center">


https://user-images.githubusercontent.com/48597284/185497136-3bf886bd-6daa-4035-8037-dcfd070fa750.mp4


<img src="https://user-images.githubusercontent.com/48597284/185497074-4046d0f2-b35e-4764-9e21-1528e32f16b9.png" width=80% height=80%>

</p>

---

## TestCasesFrom14and16 class
It for `Create new order` function and it contain 2 Test cases:
- Test case `TC_14`:

```md
@Test
(priority = 1, groups = {"Create New Order" },
testName = "Test add to cart function",
description = "Verify if the user can continue ordering the product without select the Bottle Capacity")
public void TC_14() throws InterruptedException {
	long id = Thread.currentThread().getId();
	System.out.println(className+ " @Test TC_14. Thread id is: " + id);

	// click on "Shop By Product Line"
	driver.findElement(By.xpath("//span[text()='Shop By Product Line' ]")).click();


	// click on perfume
	driver.findElement(By.xpath("//a[@class='product photo product-item-photo']//img[@alt='Damascena Collection-Rose Kazanlak']"))
	.click();

	// add to cart
	WebElement add = driver.findElement(By.xpath("//button[@id='product-addtocart-button']"));
	add.click();

	// wait until pop up window appears.
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[5]/aside[2]/div[2]/header/button")))
	.click();
	}
```

- Test case `TC_16`:

```md
@Test
(priority = 2, groups = {"Create New Order" }, 
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

	// click on Secure Checkout
	wait.until(ExpectedConditions.elementToBeClickable(By.id("top-cart-btn-checkout")));
	WebElement button = driver.findElement(By.id("top-cart-btn-checkout"));
	button.click();

	// chopping details
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//h1[normalize-space()='Shipping Details']")));
	// scroll web page to the Element
	WebElement shoppingdetails = driver.findElement(By.xpath("//h1[normalize-space()='Shipping Details']"));
	js.executeScript("arguments[0].scrollIntoView();", shoppingdetails);
	shoppingdetails.click();

	WebElement submitbutton = driver.findElement(By.xpath("(//button[@data-role='opc-continue'])[1]"));
	boolean actualValue = submitbutton.isEnabled();

	if (actualValue)
		System.out.println("Button is disabled");
	else
		System.out.println("Button is enabled");
	}
```

The code run without using XML file:

<p align="center">


https://user-images.githubusercontent.com/48597284/185498783-b17056f4-882b-49cb-9e7c-0b5520d6b4de.mp4


<img src="https://user-images.githubusercontent.com/48597284/185498735-67796a03-645e-4ff1-9c04-20f8849da646.png" width=80% height=80%>

</p>

---

## XML file
To run the `3 classes` as parallel using `4 threads`.

```md
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE suite SYSTEM "https://testng.org/testng-1.0.dtd">
<suite name="Parallel test suite" parallel="classes" thread-count="4">
  <test name="Test">
    <classes>
      <class name="testcases.TestCasesFrom14and16"/>
      <class name="testcases.TestCasesFrom1To3"/>
      <class name="testcases.TestCasesFrom8To13"/>
    </classes>
  </test> <!-- Test -->
</suite> <!-- Suite -->
```

Code run

<p align="center">

https://user-images.githubusercontent.com/48597284/185499189-c5dbf9f6-af0a-4807-a1aa-4428af363c87.mp4

<img src="https://user-images.githubusercontent.com/48597284/185499245-8c7ef176-dc41-420e-9e98-47495381d95a.png" width=80% height=80%>

</p>

The `index.html` file that generated


<p align="center">

https://user-images.githubusercontent.com/48597284/185499478-44c9954a-0457-45f4-b023-63b972685de4.mp4

  
</p>

---
# Team Members
1. `Lulua Alhumaid` - Team leader
2. `Mawaddah Hanbali` - Deputy Team Leader
3. `Bashayer Alshaheen` - Member
4. `Howra Binabdi` - Member
5. `Kholoud Yaslim` - Member
6. `Lama Alamro` - Member

