package pages;

import org.openqa.selenium.WebDriver;
import java.lang.reflect.Constructor;

public class LoginPage extends Common {

    LoginPageObjects objects;

    public LoginPage(WebDriver driver) throws Exception {
        super(driver);

        waitUntilElementIsVisible(objects.USERNAME);
        waitUntilElementIsVisible(objects.PASSWORD);
    }

    public <T> T login(String username, String password, Class<T> page) throws Exception {
        type(objects.USERNAME, username);
        type(objects.PASSWORD, password);
        clickButton(objects.LOGINBUTTON);
        Constructor<T> constructor = page.getConstructor(WebDriver.class);
        return constructor.newInstance(driver);

    }

}
