package com.PageObjectModel.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FlightPage {
	
	public WebDriver driver;
	@FindBy(xpath="//a[text()='Flights']")
	WebElement flight;
	@FindBy(xpath="//input[@value='roundtrip']")
	WebElement roundtrip;
	@FindBy(xpath="//input[@value='oneway']")
	WebElement oneway;
	
	
	public FlightPage (WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickFlights()
	{
		flight.click();
	}
	public boolean roundTrip()
	{
		boolean selection=roundtrip.isSelected();
		return selection;
	}
	public boolean onewayTrip()
	{
		boolean selection=oneway.isSelected();
		return selection;
	}
	
	public void clickOneWay() 
	{
		oneway.click();
	}

}
