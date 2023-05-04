import client.BrowserCase;
import client.UserClient;
import client.WebDriverFactory;
import io.qameta.allure.Step;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.response.ValidatableResponse;
import models.User;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import models.User;
import models.UserAccess;
import models.UserGenerator;

import javax.swing.*;
import java.time.Duration;

import static pages.Utils.MAIN_PAGE_URL;

public class BaseTest {
    User user;
    String accessToken;
    WebDriver driver;
    UserClient userClient;
    @BeforeClass
    public static void globalSetUp() {
        RestAssured.filters(
                new RequestLoggingFilter(), new ResponseLoggingFilter(),
                new AllureRestAssured());
    }
    @Before
    @Step("Запуск браузера и создание профиля пользователя")
    public void setUp() {

        String[] options = {"Google Chrome", "YandexBrowser"};
        int x = JOptionPane.showOptionDialog(null, "Select the browser in which the tests will be performed",
                "Click a button",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options);
        if (x == 0 ) {
            driver = WebDriverFactory.getBrowser("chromeWebDriverManager");
        } else if (x == 1) {
            driver = WebDriverFactory.getBrowser("yandex");

        }

        driver.get(MAIN_PAGE_URL);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        user = UserGenerator.getUser();
        userClient = new UserClient();
    }

    @After
    @Step("Удаление профиля пользователя и закрытие браузера")
    public void tearDown() {
        driver.quit();
        ValidatableResponse loginResponse = userClient.loginUser(UserAccess.from(user));
        accessToken = loginResponse.extract().path("accessToken");
        if (accessToken != null) {
            userClient.deleteUser(accessToken);
        }
    }
}


