package com.tutorialsninja.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tutorialsninja.utilities.ReadAction;

public class Contactuspage {

	WebDriver ldriver;

	public Contactuspage(WebDriver rdriver) {

		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath = "//div[@class='panel-body']//div[@class='row']")
	private WebElement contactuspanelbody;

	@FindBy(id = "input-name")
	private WebElement name;

	@FindBy(id = "input-email")
	private WebElement email;

	@FindBy(id = "input-enquiry")
	private WebElement enquiry;
	
	@FindBy(linkText = "Contact Us")
	private WebElement contactuslink;

	@FindBy(xpath = "//input[@value='Submit']")
	private WebElement submittbttn;

	@FindBy(xpath = "//div[contains(text(),'E-Mail Address does not appear to be valid!')]")
	private WebElement invalidemailmsg;

	@FindBy(xpath = "//a[normalize-space()='Continue']")
	private WebElement clickcontinuebttn;

	@FindBy(xpath = "//div[contains(text(),'Enquiry must be between 10 and 3000 characters!')]")
	private WebElement invalidenqrymsg;
	
	///////////////////////////////////////////////////////////////////////
	
	public String getInvalidEnquiryMsg() {

		return (invalidenqrymsg.getText());
	}

	public boolean isDisplayedInvalidEnquiryMsg() {

		return (invalidenqrymsg.isDisplayed());
	}

	public Homepage clickOnContinueButton() {

		clickcontinuebttn.click();
		return (new Homepage(ldriver));
	}

	public String getInvalidEmailMsg() {

		return (invalidemailmsg.getText());
	}

	public boolean isDisplayedInvalidEmailMsg() {

		return (invalidemailmsg.isDisplayed());
	}

	public Contactuspage clickOnSubmittButton() {

		submittbttn.click();
		return (new Contactuspage(ldriver));
	}

	public void enterEnquiryTextField(String enquiryfld) {

		ReadAction.sendKeys(enquiry, enquiryfld);
	}

	public void enterEmailAddressTextField(String emailaddress) {

		email.sendKeys(emailaddress);
	}

	public void enterYourNameTextField(String yourname) {

		name.sendKeys(yourname);
	}

	public String getContactUsPanelBody() {

		return (contactuspanelbody.getText());
	}
	
	public boolean isDisplayedContactUsOnBedCrum() {

		return (contactuslink.isDisplayed());
	}

	public boolean isDisplayedContactUsPanelBody() {

		return (contactuspanelbody.isDisplayed());
	}

	public String getContactUsPageTitle() {

		return (ldriver.getTitle());
	}

	public void navigateToBackPage() {

		ldriver.navigate().back();
	}
}
