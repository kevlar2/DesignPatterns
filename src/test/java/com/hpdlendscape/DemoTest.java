package com.hpdlendscape;


import com.hpdlendscape.PageObjects.TravelHomepage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DemoTest extends BaseTest {

    TravelHomepage travelHomepage;
    By sectionElement = By.id("flightSearchContainer");
    WebDriver driver;

    @BeforeTest
    public void setUp() {
        driver = initializeDriver();
        travelHomepage = new TravelHomepage(driver);
    }


    @Test(dataProvider = "getData")
    public void flightTest(HashMap<String, String> reservationDetails) throws InterruptedException {

        // Single Responsibility principle (SRP)
        travelHomepage.goTo();
        System.out.println(travelHomepage.getFooterNav().getFlightAttribute());
        Thread.sleep(1500);
        System.out.println(travelHomepage.getFooterNav().getLinkCount());


        Thread.sleep(1500);
        System.out.println(travelHomepage.getNavigationBar().getFlightAttribute());
        System.out.println(travelHomepage.getNavigationBar().getLinkCount());

        System.out.println(reservationDetails);


        travelHomepage.setBookingStrategy("RoundTrip");
        travelHomepage.checkAvail(reservationDetails);

        travelHomepage.setBookingStrategy("MultiTrip");
        travelHomepage.checkAvail(reservationDetails);



    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }

    @DataProvider
    public Object[][] getData() throws IOException {

        /*HashMap<String, String> reservationDetails = new <String, String>HashMap();
        reservationDetails.put("origin", "MAA");
        reservationDetails.put("destination", "HYD");
        reservationDetails.put("destination2", "DEL");

        HashMap<String, String> reservationDetails1 = new <String, String>HashMap();
        reservationDetails1.put("origin","DEL");
        reservationDetails1.put("destination","HYD");
        reservationDetails1.put("destination2","MAA");

        List<HashMap<String,String>> l = new ArrayList();
        l.add(reservationDetails);
        l.add(reservationDetails1);*/

        // Below is a simplified format of the above code gotten from BaseTest class

        List<HashMap<String, String>> l =getJsonData(System.getProperty("user.dir")
               + "//src//main//java//com//hpdlendscape//Dataloads//reservationDetails.json");

        // Try getting directly from DataReader class

        /*DataReader getReader= new DataReader();
        List<HashMap<String, String>> l =getReader.getJsonData(System.getProperty("user.dir")
                + "//src//test//java//com//hpdlendscape//Dataloads//reservationDetails.json");*/

        return new Object[][]{
                //{ reservationDetails}, { reservationDetails1}
                { l.get(0)}, { l.get(1)}
        };
    }

}
