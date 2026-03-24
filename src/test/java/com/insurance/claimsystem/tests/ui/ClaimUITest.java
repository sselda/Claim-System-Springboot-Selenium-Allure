package com.insurance.claimsystem.tests.ui;

import com.insurance.claimsystem.base.BaseTest;
import com.insurance.claimsystem.pages.ClaimPage;
import io.qameta.allure.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ClaimUITest extends BaseTest {

    @LocalServerPort
    int port;

    @Epic("Claim Management")
    @Feature("Create Claim")
    @Description("User creates a claim via UI")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    void shouldCreateClaimViaUI() {

        System.out.println("PORT: " + port);
        ClaimPage page = new ClaimPage(driver);

        page.open(port);

        page.createClaim("UI Test", "500");

        String result = page.getResult();

        System.out.println("RESULT: " + result);

        assertTrue(result.contains("UI Test"));
    }

    @Test
    void shouldFailWhenAmountEmpty() {

        ClaimPage page = new ClaimPage(driver);

        page.open(port);
        page.createClaim("Test without amount", "");
        String result = page.getResult();
        assertTrue(result.toLowerCase().contains("error"));

    }

    @Test
    void shouldRejectNegativeAmount() {
        ClaimPage page = new ClaimPage(driver);

        page.open(port);
        page.createClaim("Test", "-100");
        String result = page.getResult();
        assertTrue(result.toLowerCase().contains("invalid"));
    }

    @Test
    void shouldHandleLargeAmount() {

        ClaimPage page = new ClaimPage(driver);

        page.open(port);
        page.createClaim("Großer Betrag", "999999");

        String result = page.getResult();

        assertTrue(result.contains("Großer Betrag"));
    }

}