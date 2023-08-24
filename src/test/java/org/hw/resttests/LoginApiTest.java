package org.hw.resttests;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static io.restassured.RestAssured.given;

public class LoginApiTest {
    @Test
    public void loginUserTest() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        LoginObject loginRequest = objectMapper.readValue(new File("/Users/andriichuk/IdeaProjects/JunitTestsHW/src/test/java/org/hw/resttests/loginRequest.json"), LoginObject.class);
        int response =  given()
                .spec(BaseApiTest.getRequestBaseSpec())
                .body(loginRequest)
                .when()
                .post("/api/login")
                .getStatusCode();
        Assertions.assertEquals(200, response);
    }
}
