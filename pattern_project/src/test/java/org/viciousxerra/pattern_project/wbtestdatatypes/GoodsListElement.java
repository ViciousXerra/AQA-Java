package org.viciousxerra.pattern_project.wbtestdatatypes;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoodsListElement {

	private final static String ELEMENT_XPATH = "//*[@id= 'app']/div[2]/div/div[3]/div[2]/div[1]";
	private final static String ARTICLE_XPATH = "/article";
	
	private WebDriver driver;
	private WebElement goodsList;
	
	private static GoodsListElement instance;
	
	private GoodsListElement(WebDriver driver) {
		this.driver = driver;
		goodsList = this.driver.findElement(By.xpath(ELEMENT_XPATH));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", goodsList);
		new WebDriverWait(driver, Duration.ofSeconds(10L))
		.ignoring(StaleElementReferenceException.class)
		.until((d) -> {
			WebElement element = d.findElement(By.xpath(ELEMENT_XPATH));
			element.findElements(By.xpath(ARTICLE_XPATH));
			return true;
		});
		
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
				driver
				.findElements(By.xpath(ELEMENT_XPATH + ARTICLE_XPATH))
				.stream()
				.map(e -> {
					return new GoodsArticle(driver, e);
				})
				.toList();
		return list;
	}
	
}
