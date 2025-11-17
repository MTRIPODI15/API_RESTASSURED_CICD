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
