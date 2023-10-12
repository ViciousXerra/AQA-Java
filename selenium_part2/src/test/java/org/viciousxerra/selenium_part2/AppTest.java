package org.viciousxerra.selenium_part2;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.assertj.core.api.Assertions.assertThat;

import java.net.*;
import java.time.Duration;
import java.util.List;

/*
 * Проверить надписи в незаполненных полях каждого варианта оплаты услуг: услуги связи,
 * домашний интернет, рассрочка, задолженность;
 * 
 * Для варианта «Услуги связи» заполнить поля в соответствии с пререквизитами из предыдущей
 * темы, нажать кнопку «Продолжить» и в появившемся окне проверить корректность отображения
 * суммы (в том числе на кнопке), номера телефона, а также надписей в незаполненных полях для
 * ввода реквизитов карты, наличие иконок платёжных систем.
 */
class ChromeBrowserTest {
	private static String URL = "https://www.mts.by";
	private static WebDriver driver;
	
	@BeforeAll
	static void setUp() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10L));
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
		assertThat(driver.findElement(By.xpath("//form[@class = 'pay-form opened']/div[1]/input")).getDomProperty("placeholder")).isEqualTo(expectedTypeSign);
		assertThat(driver.findElement(By.xpath("//form[@class = 'pay-form opened']/div[2]/input")).getDomProperty("placeholder")).isEqualTo(expectedMoneyValueSign);
		assertThat(driver.findElement(By.xpath("//form[@class = 'pay-form opened']/div[3]/input")).getDomProperty("placeholder")).isEqualTo(expectedEmailSign);
	}
		
}