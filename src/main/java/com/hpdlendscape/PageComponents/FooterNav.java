package com.hpdlendscape.PageComponents;

import com.hpdlendscape.AbstractComponents.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FooterNav extends AbstractComponent {

   // WebDriver driver;

    By flights = By.cssSelector("[title='Flights']");
    By links = By.cssSelector("a");

    public FooterNav(WebDriver driver, By sectionElement){
        super(driver, sectionElement);// when you inherit parent class you should invoke parent class constructor
        // in your own child constructor
    }

    // Create method to handle flights
    // When selenium executes any method in this class scope of selenium
    // should be in the footer only

    public void selectFlight(){

        findElement(flights).click();

    }

    public String getFlightAttribute(){

        return findElement(flights).getAttribute("class");

    }

    public int getLinkCount(){
        return findElements(links).size();
    }

}
