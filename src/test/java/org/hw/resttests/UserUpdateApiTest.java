package org.hw.resttests;

import com.google.gson.Gson;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class UserUpdateApiTest {
    @Test
    public void updateUserTest() {
        String requestBody = "{\"name\": \"morpheus\", \"job\": \"zion resident\"}";
        Response response = given()
                .spec(BaseApiTest.getRequestBaseSpec())
                .body(requestBody)
                .when()
                .post("/api/users/2");

        System.out.println("Result is" + response.asString());
        Gson gson = new Gson();
        UpdateUserObject responseObject = gson.fromJson(response.asString(), UpdateUserObject.class);

        String name = responseObject.getName();
        String job = responseObject.getJob();

        String expectedName = "morpheus";
        String expectedJob = "zion resident";

        assertThat(name, equalTo(expectedName));
        assertThat(job, equalTo(expectedJob));
    }
}
