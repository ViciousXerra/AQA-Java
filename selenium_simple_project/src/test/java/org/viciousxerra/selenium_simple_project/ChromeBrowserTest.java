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

import java.time.Duration;

class ChromeBrowserTest {
	private static String URL = "https://www.mts.by/";
	private static WebDriver driver;
	
	@BeforeAll
	static void setUp() {
		/*WebDriverManager.chromedriver().browserVersion("117.0.5938.150");
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		DesiredCapabilities cp = new DesiredCapabilities();
		cp.setCapability(ChromeOptions.CAPABILITY, options);
		options.merge(cp);
		driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);*/
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
		WebElement element = driver.findElement(By.xpath("//section[@class = 'pay']"));
		String elementText = element.getText();
		
		//Then
		assertThat(elementText.contains(line)).isEqualTo(true);
	}
	
}
