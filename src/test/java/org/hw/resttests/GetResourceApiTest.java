package org.hw.resttests;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.everyItem;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasProperty;

public class GetResourceApiTest {
    @Test
    public void usersTest() {
        List<ResourceObject> resourses = given()
                .when()
                .contentType(ContentType.JSON)
                .baseUri("https://reqres.in/")
                .get("/api/unknown")
                .then()
                .extract()
                .jsonPath()
                .getList("data", ResourceObject.class);
       // Assertions.assertTrue(resourses.stream().allMatch(e -> e.getName().equals(String)));
        assertThat(resourses, everyItem(hasProperty("name", instanceOf(String.class))));
    }
}
