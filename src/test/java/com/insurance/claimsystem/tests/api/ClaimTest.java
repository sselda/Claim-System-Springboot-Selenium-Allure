package com.insurance.claimsystem.tests.api;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import java.net.HttpURLConnection;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ClaimTest {

    @LocalServerPort
    private int port;

    @Test
    void shouldCreateClaimSuccessfully() throws Exception {
        URL url = new URL("http://localhost:" + port +
                "/claims?description=test&amount=500&fraudFlag=false");

        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");

        int responseCode = con.getResponseCode();

        System.out.println("STATUS: " + responseCode);

        assertEquals(200, responseCode);

    }
}
