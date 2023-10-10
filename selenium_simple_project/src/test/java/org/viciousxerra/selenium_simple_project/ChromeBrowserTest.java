package org.viciousxerra.selenium_simple_project;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.assertj.core.api.Assertions.assertThat;

import java.net.*;
import java.time.Duration;
import java.util.List;

class ChromeBrowserTest {
	private static String URL = "https://www.mts.by/";
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
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3L));
	}
	
	@BeforeEach
	void setHomeUrl() {
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
		String elementText = element.getText();
		
		//Then
		assertThat(elementText.equals(line)).isEqualTo(true);
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
		
		assertThat(element.getText()).isEqualTo("Подробнее о сервисе");
		
		HttpURLConnection con = null;
		int responseCode = -1;
		try {
			URL presentedURL = new URL(element.getDomProperty("href"));
			con = (HttpURLConnection) presentedURL.openConnection();
			responseCode = con.getResponseCode();
			
		} catch(Exception e) {
			
		} finally {
			con.disconnect();
		}
		
		//Then
		assertThat(responseCode).isEqualByComparingTo(HttpURLConnection.HTTP_OK);
	}
	
}
