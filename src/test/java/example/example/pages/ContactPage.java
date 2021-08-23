package example.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

//Contact page is extension of Base page
public class ContactPage extends BasePage {

	

	/** The FistName. */
	@FindBy(name = "FirstName")
	private WebElement firstNameVal;
	
	/** The LastName. */
	@FindBy(name = "LastName")
	private WebElement lastNameVal;
	
	/** The Company */
	@FindBy(name = "Company")
	private WebElement CompanyNameVal;
	
	/** The WorkEmail */
	@FindBy(name = "Email")
	private WebElement emailVal;
	
	/** The PhoneNumber */
	@FindBy(name = "Phone")
	private WebElement phoneVal;
	
	/** The Country Location */
	@FindBy(name = "HQ_Location_Country__c")
	private WebElement hqLocationVal;
	
	/** The Industry belong to */
	@FindBy(name = "Industry__c")
	private WebElement industryVal;
	
	/** The consent check box to receive an mails related to Infogix */
	@FindBy(id = "LblConsent_to_Processing__c")
	private WebElement checkBox;
	
	/** adding comments */
	@FindBy(name = "Next_Step_Comments__c")
	private WebElement commentsSection;
	
	
	/** submitting form with required details */
	@FindBy(xpath = "//*[@class='mktoButton']")
	private WebElement submitButton;
	
	/** Thank you form display after completing the form */
	@FindBy(xpath = "//*[contains(text(),'Thank You!')]")
	private WebElement ThanksValidation;

	/**
	 * Instantiates a new home page.
	 *
	 * @param driver the driver
	 */
	public ContactPage(WebDriver driver) {
		super(driver);
	}



	/**
	 * Enter password.
	 *
	 * @param password the password
	 * 
	 */
	public ContactPage enterFirstName(String firstName) {
		firstNameVal.sendKeys(firstName);
		return this;
	}
	
	/**
	 * Enter lastname.
	 *
	 * @param lastname
	 * @return the facebook login page
	 */
	public ContactPage lastName(String lastName) {
		lastNameVal.sendKeys(lastName);
		return this;
	}
	
	/**
	 * Enter companyName.
	 *
	 * @param companyName
	 */
	public ContactPage companyName(String companyName) {
		CompanyNameVal.sendKeys(companyName);
		return this;
	}
	/**
	 * Enter emailID.
	 *
	 * @param emailID
	 */
	public ContactPage email(String emailID) {
		emailVal.sendKeys(emailID);
		return this;
	}
	/**
	 * Enter phoneNumber.
	 *
	 * @param phoneNum
	 */
	public ContactPage phoneNum(String phoneNumber) {
		phoneVal.sendKeys(phoneNumber);
		return this;
	}
	
	/**
	 * select countryLocation.
	 *
	 * from the dropdown in the contactpage
	 */
	public ContactPage country(String countryLocation) {
		WebElement dropDowncountry = hqLocationVal;
		Select CountryList = new Select(dropDowncountry);
		CountryList.selectByVisibleText(countryLocation);
		hqLocationVal.sendKeys(countryLocation);
		return this;
	}
	
	/**
	 * select industry.
	 *
	 * from the dropdown in the contactpage
	 */
	public ContactPage industry(String industry) {
		WebElement dropDownIndustry = industryVal;
		Select CountryList = new Select(dropDownIndustry);
		CountryList.selectByVisibleText(industry);
		industryVal.sendKeys(industry);
		return this;
	}
	/**
	 * Update comments as per the test data.
	 *
	 * in the contact page
	 */
	public ContactPage comments(String commentsValue) {
		commentsSection.sendKeys(commentsValue);
		return this;
	}
	/**
	 * checkbox clicked to accept to receive communications.
	 *
	 */
	public void checkboxclick() {
		checkBox.click();
		
	}
	
	/**
	 * submitting the form by clicking on the button.
	 *
	 */
	
	public void Submitclick() {
		submitButton.click();
		
	}
	/**
	 * after submitting the form need to check whether Thanks validation form displays or not.
	 *
	 */
	public String SubmitValidation() {
		String Validation = ThanksValidation.getText();
		return Validation;
		
	}

	
}
