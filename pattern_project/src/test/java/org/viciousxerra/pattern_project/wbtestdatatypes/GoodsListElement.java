package org.viciousxerra.pattern_project.wbtestdatatypes;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoodsListElement {

	private final static String ELEMENT_XPATH = "//div[@class = 'main-page']/div[3]/div[2]/div";
	private final static String GOODS_CLASSNAME = "product-card__wrapper";
	
	private WebDriver driver;
	private WebElement goodsList;
	
	private static GoodsListElement instance;
	
	private GoodsListElement(WebDriver driver) {
		this.driver = driver;
		goodsList = this.driver.findElement(By.xpath(ELEMENT_XPATH));
		new Actions(driver)
		.moveToElement(goodsList)
		.build()
		.perform();
		new WebDriverWait(driver, Duration.ofSeconds(10L)).until(ExpectedConditions.visibilityOfNestedElementsLocatedBy(By.xpath(ELEMENT_XPATH), By.className(GOODS_CLASSNAME)));
		
	}
	
	static GoodsListElement getGoodsListElement(WebDriver driver) {
		if (instance == null) {
			instance = new GoodsListElement(driver);
		}
		return instance;
	}
	
	public List<GoodsArticle> getOrderedItemsWithRandomQuantity() {
		List<GoodsArticle> list = getArticles();
		Random r = new Random();
		int quantity = r.nextInt(list.size());
		List<GoodsArticle> ordered = new ArrayList<>();
		for(int i = 0; i < quantity; i++) {
			list.get(i).orderArticle();
			ordered.add(list.get(i));
		}
		return ordered;
	}
	
	private List<GoodsArticle> getArticles() {
		List<GoodsArticle> list = 
				goodsList
				.findElements(By.className(GOODS_CLASSNAME))
				.stream()
				.map(e -> {
					return new GoodsArticle(driver, e);
				})
				.toList();
		return list;
	}
	
}
