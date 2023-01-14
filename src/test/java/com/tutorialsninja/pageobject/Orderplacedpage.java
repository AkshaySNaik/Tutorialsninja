package com.tutorialsninja.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Orderplacedpage {

	WebDriver ldriver;

	public Orderplacedpage(WebDriver rdriver) {

		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath = "//h1[normalize-space()='Your order has been placed!']")
	private WebElement ordrplacmsg;

	@FindBy(css = "div[id='common-success'] li:nth-child(4)")
	private WebElement successbedcrum;

	@FindBy(xpath = "//a[normalize-space()='Continue']")
	private WebElement continuebttn;

	@FindBy(linkText = "my account")
	private WebElement myaccountlink;

	@FindBy(linkText = "store owner")
	private WebElement storeownerlink;

	/////////////////////////////////////////////////////////////////

	public Contactuspage clickOnStoreOwnerLink() {

		storeownerlink.click();
		return (new Contactuspage(ldriver));
	}

	public Accountpage clickOnMyAccountLink() {

		myaccountlink.click();
		return (new Accountpage(ldriver));
	}

	public Homepage clickOnContinueButton() {

		continuebttn.click();
		return (new Homepage(ldriver));
	}

	public String getSuccessOnBedcrum() {

		return (successbedcrum.getText());
	}

	public boolean isDisplayedSuccessOnBedcrum() {

		return (successbedcrum.isDisplayed());
	}

	public String getOrderplacedPageTitle() {

		return (ldriver.getTitle());
	}

	public String getOrderplacedMessage() {

		return (ordrplacmsg.getText());
	}

	public boolean isDisplayedOrderplacedMessage() {

		return (ordrplacmsg.isDisplayed());
	}

}
