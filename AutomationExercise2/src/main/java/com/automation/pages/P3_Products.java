package com.automation.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.automation.library.CaptureScreenshot;
import com.automation.library.PageActions;
import com.automation.library.*;

public class P3_Products {
	WebDriver driver;
	PageActions action;
	public P3_Products(WebDriver driver) {
	this.driver = driver;
	action = new PageActions(driver);
	}
	public String URL() {String URL= "https://automationexercise.com/products"; return URL;} 
	public String getTitle() {String title = "Automation Exercise - All Products"; return title;}

	public String URL_category_products() {String URL= "automationexercise.com/category_products"; return URL;} //contains
	public String URL_brand_products() {String URL= "automationexercise.com/brand_products"; return URL;} //contains
	
	
	
// Right Side_bar
	@FindBy(xpath="//h2[@class='title text-center']") @CacheLookup private WebElement E_title_text_center;
	public WebElement getE_title_text_center() {
		return E_title_text_center;
	}



	@FindBy(xpath="//div[@class='features_items']") @CacheLookup private WebElement E_Product_List; 
	@FindBy(xpath="//i[@class='fa fa-plus-square']/parent::a") @CacheLookup private List<WebElement> LE_ViewProduct; 
	@FindBy(xpath="//div[@class='productinfo text-center']/p") @CacheLookup private List<WebElement> LE_ProductName; 
	@FindBy(xpath="//div[@class='productinfo text-center']//a[@class='btn btn-default add-to-cart']") @CacheLookup private List<WebElement> LE_AddToCart;
	@FindBy(xpath="//div[@class='productinfo text-center']/h2") @CacheLookup private List<WebElement> LE_ProductPrice;

	
// Left Side_bar
	@FindBy(xpath="//div[@class='left-sidebar']") @CacheLookup private WebElement E_left_sidebar;
	@FindBy(xpath="//a[@data-parent='#accordian']") @CacheLookup private List<WebElement> LE_CATEGORIES; 
	@FindBy(xpath="//a[@data-parent='#accordian']") @CacheLookup private List<WebElement> LE_CATEGORIES2; 
	@FindBy(xpath="//div[@id='Women']//a") @CacheLookup private List<WebElement> LE_CATEGORIES_WOMAN_SUB; 
	@FindBy(xpath="//div[@id='Men']//a") @CacheLookup private List<WebElement> LE_CATEGORIES_MEN_SUB;
	
	@FindBy(xpath="//div[@class='brands_products']") @CacheLookup private WebElement E_Brand;

	@FindBy(xpath="//div[@class='brands-name']//li/a") @CacheLookup private List<WebElement> E_Brand_name; 
//	@FindBy(xpath="") @CacheLookup public List<WebElement> ; 
//	@FindBy(xpath="") @CacheLookup public List<WebElement> ; 
//	@FindBy(xpath="") @CacheLookup public List<WebElement> ; 
	
//	RECOMMENDED ITEMS
	@FindBy(xpath="//div[@class='recommended_items']") @CacheLookup private WebElement E_RECOMMENDED_ITEMS;
	@FindBy(xpath="//div[@class='recommended_items']//a[@class='btn btn-default add-to-cart']") @CacheLookup private List<WebElement> E_RECOMMENDED_ITEMS_ADDTOCART;
	@FindBy(xpath="//div[@class='recommended_items']//p") @CacheLookup private List<WebElement> E_RECOMMENDED_ITEMS_ProductName;
	

//	Search product
	@FindBy(xpath="//input[@id='search_product']") @CacheLookup private WebElement E_Search_input;
	public List<WebElement> getLE_CATEGORIES_WOMAN_SUB() {
		return LE_CATEGORIES_WOMAN_SUB;
	}
	@FindBy(xpath="//i[@class='fa fa-search']") @CacheLookup private WebElement E_Search_button;
// 	After Add To Card
	@FindBy(xpath="//div[@class='modal-content']//button") @CacheLookup private WebElement E_ContinueShopping;
	@FindBy(xpath="//div[@class='modal-content']//a[.='View Cart']") @CacheLookup private WebElement E_ViewCart;

	
// Catogory page 
	@FindBy(xpath="//h2[@class='title text-center']") @CacheLookup public WebElement E_CATOGORYPAGE_TITLE;
	public WebElement getE_CATOGORYPAGE_TITLE() {
		return E_CATOGORYPAGE_TITLE;
	}
	public void Fullfill_searchProduct(String key) {
		E_Search_input.sendKeys(key);
		E_Search_button.click();
	}
	
////	------------------------------------------------------------------------------------->>>>>>>>>>>>>
	public WebElement getE_Brand() {
		return E_Brand;
	}
	public List<WebElement> getE_Brand_name() {
		return E_Brand_name;
	}
	public WebElement getE_Product_List() {
		return E_Product_List;
	}
	public List<WebElement> getLE_CATEGORIES() {
		return LE_CATEGORIES;
	}
	public List<WebElement> getLE_ViewProduct() {
		return LE_ViewProduct;
	}
	public List<WebElement> getLE_ProductName() {
		return LE_ProductName;
	}
	public List<WebElement> getLE_AddToCart() {
		return LE_AddToCart;
	}
	public List<WebElement> getLE_ProductPrice() {
		return LE_ProductPrice;
	}
	public WebElement getE_Search_input() {
		return E_Search_input;
	}
	public WebElement getE_Search_button() {
		return E_Search_button;
	}
	public WebElement getE_ContinueShopping() {
		return E_ContinueShopping;
	}
	public WebElement getE_ViewCart() {
		return E_ViewCart;
	}
	public void setE_Product_List(WebElement e_Product_List) {
		E_Product_List = e_Product_List;
	}
	public void setLE_ViewProduct(List<WebElement> lE_ViewProduct) {
		LE_ViewProduct = lE_ViewProduct;
	}
	public void setLE_ProductName(List<WebElement> lE_ProductName) {
		LE_ProductName = lE_ProductName;
	}
	public void setLE_AddToCart(List<WebElement> lE_AddToCart) {
		LE_AddToCart = lE_AddToCart;
	}
	public void setLE_ProductPrice(List<WebElement> lE_ProductPrice) {
		LE_ProductPrice = lE_ProductPrice;
	}
	public void setE_Search_input(WebElement e_Search_input) {
		E_Search_input = e_Search_input;
	}
	public void setE_Search_button(WebElement e_Search_button) {
		E_Search_button = e_Search_button;
	}
	public void setE_ContinueShopping(WebElement e_ContinueShopping) {
		E_ContinueShopping = e_ContinueShopping;
	}
	public void setE_ViewCart(WebElement e_ViewCart) {
		E_ViewCart = e_ViewCart;
	}
	public WebElement getE_left_sidebar() {
		return E_left_sidebar;
	}
	public WebElement getE_RECOMMENDED_ITEMS() {
		return E_RECOMMENDED_ITEMS;
	}
	public List<WebElement> getE_RECOMMENDED_ITEMS_ADDTOCART() {
		return E_RECOMMENDED_ITEMS_ADDTOCART;
	}
	public List<WebElement> getE_RECOMMENDED_ITEMS_ProductName() {
		return E_RECOMMENDED_ITEMS_ProductName;
	}
	public List<WebElement> getLE_CATEGORIES2() {
		return LE_CATEGORIES2;
	}
	public List<WebElement> getLE_CATEGORIES_MEN_SUB() {
		return LE_CATEGORIES_MEN_SUB;
	}
	
	

	

	
}
	

