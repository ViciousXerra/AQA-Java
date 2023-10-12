package org.viciousxerra.selenium_part2;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.Duration;
import java.util.List;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ChromeBrowserTest {
	private static String URL = "https://www.mts.by";
	private static WebDriver driver;
	
	@BeforeAll
	static void setUp() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10L));
		driver.manage().window().maximize();
		driver.get(URL);
	}
		
	@AfterAll
	static void teardown() {
		driver.quit();
	}
	
	private static Object[][] testDataProvider() {
		return new Object[][] {
			{1, "Номер телефона", "Сумма", "E-mail для отправки чека"},
			{2, "Номер абонента", "Сумма", "E-mail для отправки чека"},
			{3, "Номер счета на 44", "Сумма", "E-mail для отправки чека"},
			{4, "Номер счета на 2073", "Сумма", "E-mail для отправки чека"}
		};
	}
	
	@ParameterizedTest
	@Order(1)
	@MethodSource("testDataProvider")
	@DisplayName("Check block signs")
	void testText(int type, String expectedTypeSign, String expectedMoneyValueSign, String expectedEmailSign) {
		//When
		Actions action = new Actions(driver);
		action
		.scrollToElement(driver.findElement(By.xpath("//button[@class = 'select__header']")))
		.click(driver.findElement(By.xpath("//button[@class = 'select__header']")))
		.pause(Duration.ofSeconds(5L))
		.scrollToElement(driver.findElement(By.xpath(String.format("//ul[@class = 'select__list']/li[%d]", type))))
		.click(driver.findElement(By.xpath(String.format("//ul[@class = 'select__list']/li[%d]", type))))
		.build()
		.perform();
		
		//Then
		assertThat(driver.findElement(By.xpath("//form[@class = 'pay-form opened']/div[1]/input"))
				.getDomProperty("placeholder")).isEqualTo(expectedTypeSign);
		assertThat(driver.findElement(By.xpath("//form[@class = 'pay-form opened']/div[2]/input"))
				.getDomProperty("placeholder")).isEqualTo(expectedMoneyValueSign);
		assertThat(driver.findElement(By.xpath("//form[@class = 'pay-form opened']/div[3]/input"))
				.getDomProperty("placeholder")).isEqualTo(expectedEmailSign);
		
	}
	
	@Test
	@Order(2)
	@DisplayName("Check phone payment form")
	void testForm() {
		//Given
		String tel = "297777777";
		String paymentValue = "10";
		
		//When
		Actions action = new Actions(driver);
		action
		.scrollToElement(driver.findElement(By.xpath("//button[@class = 'select__header']")))
		.click(driver.findElement(By.xpath("//button[@class = 'select__header']")))
		.pause(Duration.ofSeconds(5L))
		.scrollToElement(driver.findElement(By.xpath("//ul[@class = 'select__list']/li[1]")))
		.click(driver.findElement(By.xpath("//ul[@class = 'select__list']/li[1]")))
		.build()
		.perform();
		
		driver.findElement(By.xpath("//input[@class = 'phone']")).sendKeys(tel);
		driver.findElement(By.xpath("//input[@class = 'total_rub']")).sendKeys(paymentValue);
		
		JavascriptExecutor exec = (JavascriptExecutor)driver;
		exec.executeScript("arguments[0].click();", driver.findElement(By.cssSelector("#pay-connection > button")));
		new WebDriverWait(driver, Duration.ofSeconds(20L)).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(0));
		
		String actualPrice = driver.findElement(By.className("header__payment-amount"))
				.getDomProperty("textContent");
		String actualPriceButton = driver.findElement(
				By.cssSelector("body > app-root > div > div > app-payment-container > section > app-card-page > div > div.card-page__card > button"))
				.getDomProperty("textContent");
		String actualTelInfo = driver.findElement(By.className("header__payment-info"))
				.getDomProperty("textContent");

		//Then
		assertThat(actualPrice.contains("10.00 BYN")).isEqualTo(true);
		assertThat(actualPriceButton.contains("10.00 BYN")).isEqualTo(true);
		assertThat(actualTelInfo.contains("375297777777")).isEqualTo(true);
		
		//When
		boolean isPresent = true;
		List<WebElement> logoList = driver.findElements(
				By.cssSelector("body > app-root > div > div > app-payment-container > section > app-card-page > "
						+ "div > div.card-page__card > app-card-input > form > div.card.ng-tns-c52-0 > "
						+ "div:nth-child(1) > app-input > div > div > div.icons-container.ng-tns-c46-1 > div > div > img"));
		assertThat(logoList.size()).isPositive();
		
		for(WebElement x : logoList) {
			if(!x.isDisplayed()) {
				isPresent = false;
				break;
			}
		}
		
		//Then
		assertThat(isPresent).isEqualTo(true);
		
		//When
		String actualCardNumSign = driver.findElement(By.xpath("//app-input/div/div/div[1]/label"))
				.getDomProperty("textContent");
		String actualValidDate = driver.findElement(By.xpath("//app-card-input/form/div[1]/div[2]/div[1]/app-input/div/div/div[1]/label"))
				.getDomProperty("textContent");
		String CVCSign = driver.findElement(By.xpath("//app-card-input/form/div[1]/div[2]/div[3]/app-input/div/div/div[1]/label"))
				.getDomProperty("textContent");
		String userFirstAndLastName = driver.findElement(By.xpath("//app-card-input/form/div[1]/div[3]/app-input/div/div/div[1]/label"))
				.getDomProperty("textContent");
		
		//Then
		assertThat(actualCardNumSign).isEqualTo("Номер карты");
		assertThat(actualValidDate).isEqualTo("Срок действия");
		assertThat(CVCSign).isEqualTo("CVC");
		assertThat(userFirstAndLastName).isEqualTo("Имя держателя (как на карте)");
		
	}
		
}