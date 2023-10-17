package org.viciousxerra.pattern_project.wbtestdatatypes;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ShoppingCartPage {

	private final static String CART_BUTTON_CLASSNAME = "navbar-pc__icon navbar-pc__icon--basket";
	private final static String ORDER_POSITIONS_CSS_SELECTOR = "div.accordion__body.j-b-list-content > div > div > div";
	private final static String ORDERED_ITEM_NAME_CLASSNAME = "good-info__good-name";
	private final static String ORDERED_ITEM_PRICE_CLASSNAME = "list-item__price-new";
	private final static String TOTAL_PRICE_XPATH = "//form/div[2]/div/div/div/div[2]/p/span[2]/span";
	private final static String ITEM_QUANTITY_XPATH = "//input[@type = 'number']";
	
	private WebDriver driver;
	List<WebElement> orderElements;
	
	private static ShoppingCartPage instance;
	
	private ShoppingCartPage(WebDriver driver) {
		this.driver = driver;
		WebElement cartButton = this.driver.findElement(By.className(CART_BUTTON_CLASSNAME));
		((JavascriptExecutor)this.driver).executeScript("arguments[0].scrollIntoView(true);", cartButton);
		new Actions(this.driver)
		.moveToElement(cartButton)
		.click()
		.build()
		.perform();
		orderElements = this.driver.findElements(By.cssSelector(ORDER_POSITIONS_CSS_SELECTOR));
	}
	
	public static ShoppingCartPage getShoppingCartPage(WebDriver driver) {
		if (instance == null) {
			instance = new ShoppingCartPage(driver);
		}
		return instance;
	}
	
	public List<String> getNamesList() {
		List<String> names = new ArrayList<>();
		orderElements.forEach(e -> {
			((JavascriptExecutor)this.driver).executeScript("arguments[0].scrollIntoView(true);", e);
			String name = e.findElement(By.className(ORDERED_ITEM_NAME_CLASSNAME)).getDomProperty("textContent");
			names.add(name);
		});
		return names;
	}
	
	public List<String> getPrices() {
		List<String> prices = new ArrayList<>();
		orderElements.forEach(e -> {
			((JavascriptExecutor)this.driver).executeScript("arguments[0].scrollIntoView(true);", e);
			String price = e.findElement(By.className(ORDERED_ITEM_PRICE_CLASSNAME)).getDomProperty("textContent");
			prices.add(price);
		});
		return prices;
	}
	
	
	public int getTotalPrice() {
		String price = driver.findElement(By.xpath(TOTAL_PRICE_XPATH)).getDomProperty("textContent");
		price = price.replaceAll(" ", "");
		return Integer.parseInt(price.substring(0, price.length() - 1));
	}
	
	public int getTotalQuantity() {
		int total = 0;
		for(WebElement e : orderElements) {
			String itemQuantity = e.findElement(By.xpath(ITEM_QUANTITY_XPATH)).getDomProperty("value");
			total += Integer.parseInt(itemQuantity);
		}
		return total;
	}
}
