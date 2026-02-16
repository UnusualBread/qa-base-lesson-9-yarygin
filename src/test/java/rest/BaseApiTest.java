package rest;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

public class BaseApiTest {

    @BeforeAll
    static void setup() {
        RestAssured.baseURI = "https://qa-stand-login.inzhenerka.tech/api";
    }
}
