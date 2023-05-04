package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import models.UserAccess;

import java.time.Duration;

import static pages.Utils.*;

public class AuthorizationPage {
    private final WebDriver driver;
    public AuthorizationPage(WebDriver driver) {
        this.driver = driver;
    }
    @Step("Клик на «Конструктор»")
    public void openAuthorizationPage() {
        driver.get(LOGIN_PAGE_URL);
    }
    @Step("Заполнить поля формы авторизации - e-mail и пароль Пользователя, нажать кнопку - Войти")
    public void enterAuthorizationDataAndClickLoginEnterButton(UserAccess userAccess) {
        (new WebDriverWait(driver, Duration.ofSeconds(3))).until(ExpectedConditions.urlToBe(LOGIN_PAGE_URL));
        driver.findElement(INPUT_EMAIL).sendKeys(userAccess.getEmail());
        driver.findElement(INPUT_PASSWORD).sendKeys(userAccess.getPassword());
        driver.findElement(ENTER_LINK).click();
    }
    public boolean loginButtonIsDisplay() {
        boolean isDisplayed = driver.findElement(LOGIN_BUTTON).isDisplayed();
        return isDisplayed;
    }
    @Step("Клик на «Конструктор»")
    public void clickConstructor() {
        (new WebDriverWait(driver, Duration.ofSeconds(3))).until(ExpectedConditions.visibilityOfElementLocated(ACCOUNT_LINK));
        driver.findElement(APPHEADER_CONSTRUCTOR).click();
    }
    @Step("Клик на логотип Stellar Burgers")
    public void clickLogoStellar() {
        (new WebDriverWait(driver, Duration.ofSeconds(3))).until(ExpectedConditions.visibilityOfElementLocated(ACCOUNT_LINK));
        driver.findElement(APPHEADER_STELLAR).click();
    }
}
