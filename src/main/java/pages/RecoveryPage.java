package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static pages.Utils.ENTER_LINK;
import static pages.Utils.PASSWORD_RECOVERY_URL;

public class RecoveryPage {
    private WebDriver driver;
    public RecoveryPage(WebDriver driver) {
        this.driver = driver;
    }
    @Step("Открытие страницы «Восстановление пароля»")
    public void openPasswordRecoveryPage() {
        driver.get(PASSWORD_RECOVERY_URL);
        (new WebDriverWait(driver, Duration.ofSeconds(1))).until(ExpectedConditions.urlToBe(PASSWORD_RECOVERY_URL));
    }
    @Step("Нажатие ссылки «Войти»")
    public void clickEnterLink() {
        driver.findElement(ENTER_LINK).click();
    }
}
