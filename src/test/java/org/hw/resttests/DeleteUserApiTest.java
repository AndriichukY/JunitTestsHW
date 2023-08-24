package org.hw.resttests;

import com.google.gson.Gson;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class DeleteUserApiTest {
    @Test
    public void deleteUserTest() {
        int response =  given()
                .spec(BaseApiTest.getRequestBaseSpec())
                .when()
                .delete("/api/users/2")
                .getStatusCode();
        Assertions.assertEquals(204, response);
    }
}
