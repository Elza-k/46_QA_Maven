package demoqa.core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class ApplicationManager {
    public WebDriver driver;

    protected void init() {
        String browser = System.getProperty("browser", "chrome");
// Проверяет значение переменной browser и в зависимости от результата инициализирует нужный драйвер
        switch (browser.toLowerCase()) {
            case "firefox":
                WebDriverManager.chromedriver().setup();
                driver = new FirefoxDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
                break;
            default: // Это резервный сценарий на случай, если значение browser не совпадает ни с одним из указанных случаев
                WebDriverManager.chromedriver().setup();
               driver = new ChromeDriver();
        }
        driver.manage().window().maximize();//развернуть драйвер на весь экран
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2)); // неявное
        //wait = new WebDriverWait(driver, Duration.ofSeconds(5)); // явное
        driver.get("https://demoqa.com/");
    }

    public void stop() {
        if (driver != null) {
            driver.quit(); // Остановка драйвера после всех тестов
        }
    }
}
