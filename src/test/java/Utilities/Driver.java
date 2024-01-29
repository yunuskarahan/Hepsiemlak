package Utilities;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static config.ConfigFactory.getConfig;

public class Driver {


    private Driver() {

    }


    private static WebDriver driver;


    public static WebDriver getDriver() {

        if (driver == null) {

            String browser = ConfigurationReader.getProperty("browser");
            switch (browser) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions chromeOptions = new ChromeOptions();
                    Map<String, Object> prefs = new HashMap<>();
                    chromeOptions.setExperimentalOption("prefs", prefs);
                    chromeOptions.setExperimentalOption("excludeSwitches", List.of("enable-automation"));
                    chromeOptions.addArguments("--disable-notifications");
                    chromeOptions.addArguments("--remote-allow-origins=*");

                    String mobileAgent = getConfig().status();

                    if (mobileAgent != null && mobileAgent.equalsIgnoreCase("true")) {
                        chromeOptions.addArguments(
                                "--user-agent=Mozilla/5.0 (iPhone; CPU iPhone OS 10_0 like Mac OS X) " +
                                        "AppleWebKit/602.1.50 (KHTML, like Gecko) " +
                                        "Version/10.0 Mobile/14A345 Safari/602.1"
                        );
                    }

                    chromeOptions.addArguments("start-maximized");
                    driver = new ChromeDriver(chromeOptions);
                    break;



            }

        }

        return driver;
    }

    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }


    }


}


























