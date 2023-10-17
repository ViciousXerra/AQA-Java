package org.viciousxerra.pattern_project;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Comparator;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.viciousxerra.pattern_project.wbtestdatatypes.GoodsArticle;
import org.viciousxerra.pattern_project.wbtestdatatypes.GoodsListElement;
import org.viciousxerra.pattern_project.wbtestdatatypes.HomePage;
import org.viciousxerra.pattern_project.wbtestdatatypes.ShoppingCartPage;

public class AppTest {
	
	private static HomePage home;
	private static GoodsListElement goods;
	private static ShoppingCartPage cart;
	private static List<GoodsArticle> articles;
	private static List<String> expectedNames;
	private static List<String> expectedPrices;
	private static int expectedTotalPrice;
	private static int expectedTotalQuantity;
	
	@BeforeAll
	static void setUp() {
		home = HomePage.getHomePage();
		goods = home.getGoodsListElement();
		articles = goods.getOrderedItemsWithRandomQuantity();
		expectedNames = articles
				.stream()
				.map(a -> a.getName())
				.sorted(Comparator.naturalOrder())
				.toList();
		expectedPrices = articles
				.stream()
				.map(a -> a.getPrice())
				.sorted(Comparator.naturalOrder())
				.toList();
		expectedTotalPrice = GoodsArticle.getTotalPrice();
		expectedTotalQuantity = articles.size();
		cart = home.getShoppingCartPage();
	}
	
	@AfterAll
	static void teardown() {
		home.quitDriver();
	}
	
	@Test
	@DisplayName("Test item names")
	void testNames() {
		//When
		List<String> actualNames = cart.getNamesList();
		actualNames.sort(Comparator.naturalOrder());
		//Then
		assertThat(actualNames).isEqualTo(expectedNames);
	}
	
	@Test
	@DisplayName("Test item prices")
	void testPrices() {
		//When
		List<String> actualPrices = cart.getPrices();
		actualPrices.sort(Comparator.naturalOrder());
		//Then
		assertThat(actualPrices).isEqualTo(expectedPrices);
	}
	
	@Test
	@DisplayName("Test total Price")
	void testTotalprice() {
		//When
		int actualTotalPrice = cart.getTotalPrice();
		//Then
		assertThat(actualTotalPrice).isEqualTo(expectedTotalPrice);
	}
	
	@Test
	@DisplayName("Test total quantity")
	void testTotalQuantity() {
		//When
		int actualTotalQuantity = cart.getTotalQuantity();
		//Then
		assertThat(actualTotalQuantity).isEqualTo(expectedTotalQuantity);
	}
}
