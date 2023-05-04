import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import pages.AuthorizationPage;
import pages.MainPage;
import models.UserAccess;

import static org.junit.Assert.assertTrue;
import static pages.Utils.EXIT_BUTTON;

public class LogOutTest extends BaseTest{
    @Test
    @DisplayName("Выход из аккаунта")
    public void LogoutAccountTest(){
        userClient.createUser(user);
        MainPage mainPage = new MainPage(driver);
        mainPage.clickTextLink();
        AuthorizationPage authorizationPage = new AuthorizationPage(driver);
        authorizationPage.enterAuthorizationDataAndClickLoginEnterButton(UserAccess.from(user));
        mainPage.mainPageIsOpen();
        mainPage.clickTextLink();
        driver.findElement(EXIT_BUTTON).click();
        boolean result = authorizationPage.loginButtonIsDisplay();

        assertTrue(result);

    }

}
