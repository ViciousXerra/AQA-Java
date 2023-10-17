package org.viciousxerra.pattern_project.wbtestdatatypes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class GoodsArticle {

	private final static String ORDER_BUTTON_XPATH = "//div/div[3]/p[3]/a";
	private final static String ITEM_NAME_XPATH = "//div/div[2]/h2/span[2]/text()";
	private final static String ITEM_CURRENT_PRICE_XPATH = "//div/div[2]/p/span/ins";
	private final static String SIZE_SELECTION_CLASSNAME = "j-size";
	private final static String SIZE_SELECTION_BUTTON_XPATH = "//body/div[1]/div/ul/li[1]";
	
	private static int totalPrice;
	
	private WebDriver driver;
	private WebElement element;
	private Actions action;
	
	private String itemName;
	private String price;
	private boolean withSizeSelection;
	
	GoodsArticle(WebDriver driver, WebElement element) {
		this.driver = driver;
		this.element = element;
		action = new Actions(this.driver);
		action
		.moveToElement(element)
		.moveToElement(element.findElement(By.xpath(ORDER_BUTTON_XPATH)))
		.click()
		.build();
		parseData();
	}
	
	public void orderArticle() {
		action.perform();
		if (withSizeSelection) {
			new Actions(driver)
			.moveToElement(driver.findElement(By.xpath(SIZE_SELECTION_BUTTON_XPATH)))
			.click()
			.build()
			.perform();
		}
	}
	
	public static int getTotalPrice() {
		return totalPrice;
	}
	
	public String getName() {
		return itemName;
	}
	
	public String getPrice() {
		return price;
	}
	
	private void parseData() {
		itemName = element.findElement(By.xpath(ITEM_NAME_XPATH)).getDomProperty("textContent");
		price = element.findElement(By.xpath(ITEM_CURRENT_PRICE_XPATH)).getDomProperty("innerText");
		String strPrice = element.findElement(By.xpath(ITEM_CURRENT_PRICE_XPATH)).getDomProperty("innerText").replaceAll(" ", "");
		totalPrice += Integer.parseInt(strPrice.substring(0, strPrice.length() - 1));
		int sizes = driver.findElements(By.className(SIZE_SELECTION_CLASSNAME)).size();
		withSizeSelection = sizes > 1;
	}
	
}
