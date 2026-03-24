package com.insurance.claimsystem.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.ByteArrayInputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class BaseTest {

    protected WebDriver driver;

    @BeforeEach
    void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterEach
    void tearDown(TestInfo testInfo) {

        try {
            // Screenshot
            TakesScreenshot ts = (TakesScreenshot) driver;
            byte[] screenshotBytes = ts.getScreenshotAs(OutputType.BYTES);

            String filename = testInfo.getDisplayName()
                            .replaceAll("[^a-zA-Z0-9]","_")
                             + "_" + System.currentTimeMillis()
                             + ".png";

            Files.write(
                    Path.of(System.getProperty("user.dir"), "build", filename),
                    screenshotBytes
            );

            Allure.addAttachment(
                    "Screenshot",
                    new ByteArrayInputStream(screenshotBytes)
            );

        } catch (Exception e) {
            e.printStackTrace();
        }

        driver.quit();
    }
}
