import data.Data
import helpers.CommonSystemParameters
import org.openqa.selenium.WebDriver
import pages.HomePage
import pages.LoginPage;
import helpers.JsonDataLoader
import spock.lang.Shared;

public class BaseSpec {

    @Shared
    WebDriver driver

    public static Data currentData
    LoginPage loginPage

    LoginPage navigateToLoginPage() {
        String commonurl = CommonSystemParameters.getSystemFileProperty("COMMON_URL")
        loadLink(commonurl)
        loginPage = new LoginPage(driver)
        return loginPage
    }

    void loadLink() {
        String baseUrl = CommonSystemParameters.getSystemFileProperty("applicationUrl")
        driver.navigate().to(baseUrl)
    }

    HomePage navigateLoginAndLoginToHomePage(String data) throws Exception {
        currentData = JsonDataLoader.loadFromGeneralJson(data, Data.class)
        homePage = navigateToLoginPage().login(currentEnrollmentData.getUsername(), currentEnrollmentData.getPassword(), DashboardPage.class)
        return dashboardPage
    }


}
