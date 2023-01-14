package com.tutorialsninja.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Forgotyourpasswordpage {

	WebDriver ldriver;

	public Forgotyourpasswordpage(WebDriver rdriver) {

		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath = "//*[@id='content']/p")
	private WebElement forgetcontent;

	@FindBy(linkText = "Forgotten Password")
	private WebElement forgtpass;

	@FindBy(id = "input-email")
	private WebElement forgotpgemail;

	@FindBy(xpath = "//*[@id='content']/form/div/div[2]/input")
	private WebElement continuebtn;

	@FindBy(xpath = "//div[contains(text(),' Warning: The E-Mail Address was not found in our records')]")
	private WebElement registedemailwarnmsg;

	@FindBy(linkText = "Back")
	private WebElement backlink;

	///////////////////////////////////////////////////////////////////

	public Loginpage clickOnBackButton() {

		backlink.click();
		return (new Loginpage(ldriver));
	}

	public String getAttributeForEmailTextField(String data) {

		return (forgotpgemail.getAttribute(data));
	}

	public String getWarnForUnregisteredEmail() {

		return (registedemailwarnmsg.getText());
	}

	public boolean isDisplayedWarnForUnregisteredEmail() {

		return (registedemailwarnmsg.isDisplayed());
	}

	public Loginpage clickOnContinueButton() {

		continuebtn.click();
		return (new Loginpage(ldriver));
	}

	public void enterEmailOfForgotenPassword(String email) {

		forgotpgemail.sendKeys(email);
	}

	public boolean isDisplayedForgottenPassOnBedcrum() {

		return (forgtpass.isDisplayed());
	}

	public String getForgetMsgContent() {

		return (forgetcontent.getText());
	}

	public boolean isDisplayedForgetMsgContent() {

		return (forgetcontent.isDisplayed());
	}

	public String getForgotPasswordPageTitle() {

		return (ldriver.getTitle());
	}
}
