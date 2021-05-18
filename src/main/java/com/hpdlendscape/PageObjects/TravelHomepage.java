package com.hpdlendscape.PageObjects;

import com.hpdlendscape.AbstractComponents.SearchFlightAvail;
import com.hpdlendscape.AbstractComponents.StrategyFactor;
import com.hpdlendscape.PageComponents.FooterNav;
import com.hpdlendscape.PageComponents.NavigationBar;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;

public class TravelHomepage {

    WebDriver driver;
    By sectionElement = By.id("traveller-home");
    By headerNavSectionElement = By.id("buttons");
    SearchFlightAvail searchFlightAvail;

    public TravelHomepage(WebDriver driver) {
        this.driver = driver;
    }

    public void goTo(){
        driver.get("https://rahulshettyacademy.com/dropdownsPractise");
    }

    public NavigationBar getNavigationBar(){

        return new NavigationBar(driver,headerNavSectionElement);
    }

    public FooterNav getFooterNav(){

        return new FooterNav(driver, sectionElement);
    }

    public void setBookingStrategy(String strategyType){
        StrategyFactor strategyFactor = new StrategyFactor(driver);
        searchFlightAvail = strategyFactor.createStrategy(strategyType);
        this.searchFlightAvail = searchFlightAvail;
    }

    public void checkAvail(HashMap<String, String> reservationDetails){

        searchFlightAvail.checkAvail(reservationDetails);
    }

    public String getTitle(){

        System.out.println("Hello");
        return driver.getTitle();
    }

}
