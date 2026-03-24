package com.insurance.claimsystem.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ClaimPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public ClaimPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void open(int port) {
        driver.get("http://localhost:" + port + "/claim-form");
    }

    public void createClaim(String description, String amount) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("description"))).sendKeys(description);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("amount"))).sendKeys(amount);
        wait.until(ExpectedConditions.elementToBeClickable(By.tagName("button"))).click();
    }

    public String getResult() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("body"))).getText();
    }

}
