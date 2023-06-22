package com.PageObjectModel.Scripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.PageObjectModel.Base.TestBase;
import com.PageObjectModel.Pages.FlightPage;

public class FlightTest extends TestBase {
	
	FlightPage objFlight;
	
  @Test (priority=5,groups={"sanity"},retryAnalyzer=com.PageObjectModel.Listners.RetryAnalyser.class)
 /* public void checkRoundTripSelectionByDefault() 
  {
	  objFlight=new FlightPage(driver);
	  objFlight.clickFlights();
	  Assert.assertTrue(objFlight.roundTrip(), "Round trip is not selected by default");
  } */
  
  public void checkOnewayTripSelection() 
  {
	  objFlight=new FlightPage(driver);
	  objFlight.clickFlights();
	  Assert.assertFalse(objFlight.onewayTrip(), "One way trip is selected ");
  }
  
  @Test(priority=6,groups={"sanity"},retryAnalyzer=com.PageObjectModel.Listners.RetryAnalyser.class)

  public void selectOneWay()
  {
	  objFlight=new FlightPage(driver);
	  objFlight.clickOneWay();
	  Assert.assertTrue(objFlight.onewayTrip(), "One way trip is not selected ");
  }
  
  
  
}

//
