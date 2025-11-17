package api;

import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class ClimateTest {

    @Test
    public void testWeatherCordoba() {
        String apiKey = System.getenv("WEATHER_API_KEY");

        RestAssured
            .given()
            .queryParam("q", "Cordoba")
            .queryParam("appid", apiKey)
            .when()
            .get("https://api.openweathermap.org/data/2.5/weather")
            .then()
            .statusCode(200)
            .body("name", equalTo("Cordoba"))
            .body("main.temp", notNullValue());
    }
}

