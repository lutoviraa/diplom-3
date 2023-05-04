package client;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class WebDriverFactory {
    public static WebDriver getBrowser(String browserName) {
        switch (browserName) {

            case "yandex":
                System.setProperty("webdriver.chrome.driver", "C:\\Users\\irina.lutovinova\\WebDriver\\bin\\chromedriver_win32\\chromedriver.exe");
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--remote-allow-origins=*");
                return new ChromeDriver(options);

            case "chromeWebDriverManager":
                System.setProperty("webdriver.http.factory", "jdk-http-client");
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver();

/*            case "chromeNoManager":
                System.setProperty("webdriver.http.factory", "jdk-http-client");
                return new ChromeDriver();*/

            default:
                throw new RuntimeException("Ваш браузер пока не поддерживается - только Хром и Яндекс!");
        }
    }
}


