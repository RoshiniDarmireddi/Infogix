package example.example.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class SerachPage extends BasePage {
	
	/** The searchinput. */
	@FindBy(xpath = "//input[@class='searchfor']")
	private WebElement searchinput;
	
	
	@FindBy(xpath = "//div[@class='details']//a")
	private List<WebElement> searchLink;

	//webelement used to move from 1 page to another
	@FindBy(xpath = "//*[@class='paged-prev-next']//a")
	private WebElement nextpage;

	/**
	 * Instantiates a new google page.
	 *
	 * @param driver the driver
	 */
	public SerachPage(WebDriver driver) {
		super(driver);
	}

	/**
	 * Searches the given text.
	 *
	 * @param key the key
	 */
	public void searchText(String key) {
		searchinput.sendKeys(key + Keys.ENTER);//keys to move from one page to another
	}
	/**
	 * Searches the given text in the following page of the link.
	 *
	 */
	public void searchLink(String key) {
		List <WebElement>options = searchLink;
		int setvalue = 1 ;
        for(WebElement option:options) {
        	if(option.getText().equalsIgnoreCase(key)) {
        		option.click();
        		setvalue = setvalue+1;
        		break;
        	}
        }
        if(setvalue <= 1 ) {
        	nextpage.click();
        	for(WebElement option:options) {
            	if(option.getText().equalsIgnoreCase(key)) {
            		option.click();
            		setvalue = setvalue+1;
            		break;
            	}
            }
        }
	}
	
	public String validateUrl(){
		String CurrentURL= driver.getCurrentUrl();
		return CurrentURL;
	}

}
