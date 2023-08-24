package org.hw.resttests;

import com.google.gson.Gson;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;


public class CreateApiTets {
    @Test
    public void сreateUserTest() {
        String requestBody = "{\"name\": \"morpheus\", \"job\": \"leader\"}";
        Response response = given()
                .spec(BaseApiTest.getRequestBaseSpec())
                .body(requestBody)
                .when()
                .post("/api/users");

        System.out.println("Result is" + response.asString());
        Gson gson = new Gson();
        CreateObject responseObject = gson.fromJson(response.asString(), CreateObject.class);

        String name = responseObject.getName();
        String job = responseObject.getJob();

        String expectedName = "morpheus";
        String expectedJob = "leader";

        Assertions.assertEquals(expectedName, name);
        Assertions.assertEquals(expectedJob, job);
    }
}
