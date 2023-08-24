package org.hw;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;

public class BaseTestClass {
    public WebDriver chromeDriver;

    @BeforeEach
    public void init() throws MalformedURLException {
        chromeDriver = new ChromeDriver();
        chromeDriver.manage().window().maximize();
        chromeDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        chromeDriver.get("https://www.saucedemo.com/");}

       /* ChromeOptions options = new ChromeOptions();

        options.setCapability("selenoid:options", new HashMap<String, Object>() {{
            put("name", "Test badge...");

            put("sessionTimeout", "15m");

            put("env", new ArrayList<String>() {{
                add("TZ=UTC");
            }});

            put("labels", new HashMap<String, Object>() {{
                put("manual", "true");
            }});


            put("enableVideo", true);
        }});

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName("chrome");
        capabilities.setVersion("114.0"); // Use the version specified in browsers.json

        WebDriver chromeDriver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);
        chromeDriver.manage().window().maximize();
        chromeDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        chromeDriver.get("https://www.saucedemo.com/");
    }*/

    @AfterEach
    public void clear() {chromeDriver.quit();}
}
