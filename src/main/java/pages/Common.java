package pages;

import helpers.Actions;
import org.openqa.selenium.WebDriver;

public class Common extends Actions {

    protected WebDriver driver;
    LoginPage loginPage;

    public Common(WebDriver driver) throws Exception{
        super(driver);
        this.driver = driver;
    }



}
