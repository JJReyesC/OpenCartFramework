package framework.core;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import framework.enums.ByType;

public class BaseFramework {

	private WebDriver driver;
	private WebDriverWait wait;

	public BaseFramework(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	}

	public BaseFramework(WebDriver driver, long waitTime) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(waitTime));
	}

	public WebElement getElementBy(String locator, ByType type) {
		WebElement element = null;
		switch (type) {
		case ID:
			element = driver.findElement(By.id(locator));
			break;
		case XPATH:
			element = driver.findElement(By.xpath(locator));
			break;
		case NAME:
			element = driver.findElement(By.name(locator));
			break;
		case CLASS_NAME:
			element = driver.findElement(By.className(locator));
			break;
		case LINK_TEXT:
			element = driver.findElement(By.linkText(locator));
			break;
		case PARTIAL_LINK_TEXT:
			element = driver.findElement(By.partialLinkText(locator));
			break;
		case CSS_SELECTOR:
			element = driver.findElement(By.cssSelector(locator));
			break;
		case TAG_NAME:
			element = driver.findElement(By.tagName(locator));
			break;
		default:
			element = driver.findElement(By.id(locator));
			break;
		}
		return element;
	}

	public List<WebElement> getElementsBy(String locator, ByType type) {
		List<WebElement> elements = new ArrayList<WebElement>();
		switch (type) {
		case ID:
			elements = driver.findElements(By.id(locator));
			break;
		case XPATH:
			elements = driver.findElements(By.xpath(locator));
			break;
		case CLASS_NAME:
			elements = driver.findElements(By.className(locator));
			break;
		case LINK_TEXT:
			elements = driver.findElements(By.linkText(locator));
			break;
		case PARTIAL_LINK_TEXT:
			elements = driver.findElements(By.partialLinkText(locator));
			break;
		case CSS_SELECTOR:
			elements = driver.findElements(By.cssSelector(locator));
			break;
		case TAG_NAME:
			elements = driver.findElements(By.tagName(locator));
			break;
		default:
			elements = driver.findElements(By.id(locator));
			break;
		}
		return elements;
	}

	public String getPageTitle() {
		return driver.getTitle();
	}

	public void navigateBack() {
		driver.navigate().back();
	}

	public void navigateForward() {
		driver.navigate().forward();
	}

	public void refreshPage() {
		driver.navigate().refresh();
	}

	public void waitForElementVisibitlity(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void waitForElementInvisibitlity(WebElement element) {
		wait.until(ExpectedConditions.invisibilityOf(element));
	}

	public void waitForElementClickable(WebElement element) {
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void scrollto(WebElement element) {
		String js = String.format("window.scroll(0, %d);", element.getLocation().getY());
		((JavascriptExecutor) driver).executeScript(js);
	}

}
