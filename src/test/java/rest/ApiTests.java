package rest;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ApiTests extends BaseApiTest {

    private final String key = "API_KEY";
    private final String keyValue = "API_KEY123";

    @Order(1)
    @Test
    void createUser() {
        String requestBody = createJsonBody(
                false,
                5,
                "Im gonna be changed",
                "Me too",
                "And me",
                "What about me",
                "IamCoolDog"
        );

        given()
                .contentType("application/json")
                .queryParam(key, keyValue)
                .body(requestBody)
        .when()
                .post("/users")
        .then()
                .statusCode(anyOf(is(201), is(400)))
                .log().all();
    }

    @Order(2)
    @Test
    void updateUser() {
        String requestBody = createJsonBody(
                false,
                123,
                "Hello",
                "AQA",
                "Hot Dog",
                "123",
                "IamCoolDog"
        );

        given()
                .contentType("application/json")
                .queryParam(key, keyValue)
                .body(requestBody)
        .when()
                .put("/users/IamCoolDog")
        .then()
                .statusCode(200)
                .log().all();
    }

    @Order(3)
    @ParameterizedTest
    @ValueSource(strings = {"IamHotDog", "admin", "IamCoolDog"})
    void getUser(String username) {
        given()
                .queryParam(key, keyValue)
        .when()
                .get("/users/" + username)
        .then()
                .statusCode(200)
                .body("username", equalTo(username))
                .log().all();
    }

    @Order(4)
    @Test
    void deleteUser() {
        given()
                .params(key, keyValue)
        .when()
                .delete("/users/IamCoolDog")
        .then()
                .statusCode(200)
                .log().all();
    }

    private static String createJsonBody(
            boolean isAdmin,
            int age,
            String desc,
            String job,
            String name,
            String pwd,
            String username
    ) {
        return """
                {
                    "admin": %b,
                    "age": %s,
                    "description": "%s",
                    "jobtitle": "%s",
                    "name": "%s",
                    "password": "%s",
                    "username": "%s"
                }
                """.formatted(isAdmin, age, desc, job, name, pwd, username);
    }
}
