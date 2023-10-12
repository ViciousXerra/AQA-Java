package org.viciousxerra.selenium_simple_project;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v117.browser.Browser;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.assertj.core.api.Assertions.assertThat;

import java.net.*;
import java.time.Duration;
import java.util.List;

class ChromeBrowserTest {
	private static String URL = "https://www.mts.by";
	private static WebDriver driver;
	
	@BeforeAll
	static void setUp() {
		/*
		 * WebDriverManager.chromedriver().browserVersion("117.0.5938.150");
		 * WebDriverManager.chromedriver().setup();
		 * ChromeOptions options = new ChromeOptions();
		 * options.addArguments("--remote-allow-origins=*");
		 * DesiredCapabilities cp = new DesiredCapabilities();
		 * cp.setCapability(ChromeOptions.CAPABILITY, options);
		 * options.merge(cp);
		 * driver = new ChromeDriver(options);
		 * driver.manage().timeouts().implicitlyWait(3L, TimeUnit.SECONDS);
		 */
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10L));
		driver.get(URL);
	}
	
	@AfterAll
	static void teardown() {
		driver.quit();
	}
		
	@Test
	@DisplayName("Block sign check")
	void checkBlockSign() {
		//Given
		String line = "Онлайн пополнение\nбез комиссии";
		
		//When
		WebElement element = driver.findElement(By.xpath("//section[@class = 'pay']/div/h2"));
		String elementLabel = element.getText();
		
		//Then
		assertThat(elementLabel).isEqualTo(line);
	}
	
	@Test
	@DisplayName("Payment system logo check")
	void testLogo() {
		//Given
		boolean logosIsPresent = true;
		
		List<WebElement> elements = driver.findElements(By.xpath("//div[@class = 'pay__partners']/ul/li"));
		
		//Check for existence
		assertThat(elements.size()).isPositive();
		
		for(WebElement x : elements) {
			if(!x.findElement(By.tagName("IMG")).isDisplayed()) {
				logosIsPresent = false;
				break;
			}
		}
		
		//Then
		assertThat(logosIsPresent).isEqualTo(true);
	}
	
	@Test
	@DisplayName("Test link")
	void testLink() {
		//Given
		boolean linkIsValid = true;
		
		//When
		WebElement element = driver.findElement(By.xpath("//div[@class = 'pay__wrapper']/a"));
		
		//Then
		assertThat(element.getText()).isEqualTo("Подробнее о сервисе");
		
		//When
		HttpURLConnection con = null;
		int responseCode = -1;
		try {
			URL presentedURL = new URL(element.getDomProperty("href"));
			con = (HttpURLConnection) presentedURL.openConnection();
			responseCode = con.getResponseCode();
			
		} catch(Exception e) {
			
		} finally {
			if(con != null) {
				con.disconnect();
			}
		}
		
		//Then
		assertThat(responseCode).isBetween(200, 399);
	}
	
	@Test
	@DisplayName("Test button")
	void testButton() {
		//Given
		String category = "Услуги связи";
		String tel = "297777777";
		String paymentValue = "10";
		String email = "randomemail@mailbox.org";
		
		//When
		WebElement base = driver.findElement(By.xpath("//div[@class = 'pay__form']"));
		String actualCategory = base.findElement(By.xpath("//span[@class = 'select__now']")).getText();
		
		//Then
		assertThat(actualCategory).isEqualTo(category);
		
		//When
		base = driver.findElement(By.xpath("//input[@class = 'phone']"));
		base.sendKeys(tel);
		base = driver.findElement(By.xpath("//input[@class = 'total_rub']"));
		base.sendKeys(paymentValue);
		base = driver.findElement(By.xpath("//input[@class = 'email']"));
		base.sendKeys(email);
		
		base = driver.findElement(By.cssSelector("#pay-connection > button"));
		
		//Then
		assertThat(base.getDomProperty("textContent")).isEqualTo("Продолжить");		
		
		//When
		JavascriptExecutor exec = (JavascriptExecutor)driver;
		exec.executeScript("arguments[0].click();", base);
		new WebDriverWait(driver, Duration.ofSeconds(5L)).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(0));
		//Then
		String actualPrice = driver.findElement(By.className("header__payment-amount")).getDomProperty("textContent");
		String actualTelInfo = driver.findElement(By.className("header__payment-info")).getDomProperty("textContent");

		assertThat(actualPrice).isEqualTo(" 10.00 BYN ");
		assertThat(actualTelInfo.contains("375297777777")).isEqualTo(true);
	}
	
}
