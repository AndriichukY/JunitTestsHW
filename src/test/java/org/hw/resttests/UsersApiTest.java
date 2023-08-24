package org.hw.resttests;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class UsersApiTest {
    @Test
    public void usersTest() {
        List<UserObject> users = given()
                .spec(BaseApiTest.getRequestBaseSpec())
                .when()
                .get("/api/users?page=2")
                .then()
                .spec(BaseApiTest.getResponseBase200Spec())
                .extract()
                .jsonPath()
                .getList("data", UserObject.class);
        Assertions.assertTrue(users.size()>0);
    }
}
