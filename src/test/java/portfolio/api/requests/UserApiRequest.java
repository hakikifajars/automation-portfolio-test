package portfolio.api.requests;

import io.restassured.response.Response;
import org.json.JSONObject;

import static io.restassured.RestAssured.given;

public class UserApiRequest {

    private final String baseUrl = "https://dummyapi.io/data/v1";
    private final String appId = "63a804408eb0cb069b57e43a";

    public Response getUsers() {
        return given()
                .baseUri(baseUrl)
                .header("app-id", appId)
                .queryParam("limit", 10)
                .when()
                .get("/user");
    }

    public Response getTags() {
        return given()
                .baseUri(baseUrl)
                .header("app-id", appId)
                .when()
                .get("/tag");
    }

    public Response createUser(JSONObject body) {
        return given()
                .baseUri(baseUrl)
                .header("app-id", appId)
                .contentType("application/json")
                .body(body.toString())
                .when()
                .post("/user/create");
    }

    public Response getUserById(String id) {
        return given()
                .baseUri(baseUrl)
                .header("app-id", appId)
                .when()
                .get("/user/" + id);
    }

    public Response updateUser(String id, JSONObject body) {
        return given()
                .baseUri(baseUrl)
                .header("app-id", appId)
                .contentType("application/json")
                .body(body.toString())
                .when()
                .put("/user/" + id);
    }

    public Response deleteUser(String id) {
        return given()
                .baseUri(baseUrl)
                .header("app-id", appId)
                .when()
                .delete("/user/" + id);
    }

    public Response getUsersWithoutAppId() {
        return given()
                .baseUri(baseUrl)
                .queryParam("limit", 10)
                .when()
                .get("/user");
    }

    public Response getUsersWithInvalidAppId() {
        return given()
                .baseUri(baseUrl)
                .header("app-id", "invalid-app-id")
                .queryParam("limit", 10)
                .when()
                .get("/user");
    }
}