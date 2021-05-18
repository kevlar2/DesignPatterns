package com.hpdlendscape.AbstractComponents;

import com.hpdlendscape.PageComponents.MultiTrip;
import com.hpdlendscape.PageComponents.RoundTrip;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class StrategyFactor {

    // Factory design pattern Implementation
    WebDriver driver;
    By sectionElement = By.id("flightSearchContainer");

    public StrategyFactor(WebDriver driver) {
        this.driver = driver;
    }

    public SearchFlightAvail createStrategy(String strategyType){
        if (strategyType.equalsIgnoreCase("multitrip")){

            return new MultiTrip(driver, sectionElement);

        }

        if (strategyType.equalsIgnoreCase("roundtrip")){

            return new RoundTrip(driver, sectionElement);

        }

        return null;
    }

}
