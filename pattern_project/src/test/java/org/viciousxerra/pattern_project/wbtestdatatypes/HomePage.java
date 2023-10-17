package org.viciousxerra.pattern_project.wbtestdatatypes;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomePage {
	
	private final static String HOME_PAGE_URL = "https://www.wildberries.ru/";
	
	private WebDriver driver;
	
	private static HomePage instance;
	
	private HomePage() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10L));
		driver.get(HOME_PAGE_URL);
	}
	
	public static HomePage getHomePage() {
		if (instance == null) {
			instance = new HomePage();
		}
		return instance;
	}
	
	public GoodsListElement getGoodsListElement() {
		return GoodsListElement.getGoodsListElement(driver);
	}
	
	public ShoppingCartPage getShoppingCartPage() {
		return ShoppingCartPage.getShoppingCartPage(driver);
	}
	
	public void quitDriver() {
		driver.quit();
	}
	
}
