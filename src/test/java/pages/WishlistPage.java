package pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import framework.core.BaseFramework;
import framework.enums.ByType;
import utils.ObjectFileReader;

public class WishlistPage {

	ObjectFileReader ofrWishlist;
	Properties wishlistObj;
	WebDriver driver;
	BaseFramework bf;

	WebElement tableProductName;
	WebElement btnAddToCart;
	WebElement btnRemove;
	String actualProductName;

	public WishlistPage(WebDriver driver) {
		this.driver = driver;
		ofrWishlist = new ObjectFileReader("wishlist");
		wishlistObj = ofrWishlist.getProperties();
		bf = new BaseFramework(driver);
	}

	public String validateProductAdd(String productName) {
		tableProductName = bf.getElementBy(
				String.format(wishlistObj.getProperty("cart.framework.wishlist.table.product_name"), productName),
				ByType.XPATH);
		actualProductName = tableProductName.getText();
		return actualProductName;
	}
	
	
	public void addToCart(String productName) {
		btnAddToCart = bf.getElementBy(
				String.format(wishlistObj.getProperty("cart.framework.wishlist.table.add_to_cart"), productName),
				ByType.XPATH);
		btnAddToCart.click();
	}
	
	public void remove(String productName) {
		btnRemove = bf.getElementBy(
				String.format(wishlistObj.getProperty("cart.framework.wishlist.table.remove"), productName),
				ByType.XPATH);
		btnRemove.click();
	}

}
