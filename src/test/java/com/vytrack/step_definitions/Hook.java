package com.vytrack.step_definitions;

import com.vytrack.utilities.Driver;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hook {
    @Before
    public void setup(Scenario scenario){
        System.out.println(scenario.getName());
        System.out.println("Before");
    }
    /*
    @Before(value="@storemanager", order =1)
    public void setupForStoreManager(Scenario scenario){
        System.out.println("Before For Store Manager");
    }
     */
    @After
    public void teardown(Scenario scenario){
        if(scenario.isFailed()){
            TakesScreenshot takesScreenshot =(TakesScreenshot)Driver.getDriver();
             byte[] image = takesScreenshot.getScreenshotAs(OutputType.BYTES);
             scenario.embed(image, "image/png");
        }
        Driver.closeDriver();
        System.out.println("AFTER");
    }
    /*
    @After(value="@storemanager", order =1)
    public void teardownforStoreManager(Scenario scenario){
        System.out.println(scenario.getName());
        System.out.println("After for storemanager");
    }
     */
}
