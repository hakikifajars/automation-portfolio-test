package portfolio.api.steps;

import io.cucumber.java.en.*;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import portfolio.api.requests.UserApiRequest;

public class ApiSteps {

    UserApiRequest userApiRequest = new UserApiRequest();
    Response response;

    static String createdUserId;
    static String createdEmail;

    @Given("user prepares DummyAPI header")
    public void userPreparesDummyAPIHeader() {
        // Header app-id sudah disiapkan di UserApiRequest
    }

    @When("user sends request to get list of users")
    public void userSendsRequestToGetListOfUsers() {
        response = userApiRequest.getUsers();
    }

    @When("user sends request to get list of tags")
    public void userSendsRequestToGetListOfTags() {
        response = userApiRequest.getTags();
    }

    @When("user sends request to create new user")
    public void userSendsRequestToCreateNewUser() {
        createdEmail = "hakiki" + System.currentTimeMillis() + "@example.com";

        JSONObject body = new JSONObject();
        body.put("firstName", "Hakiki");
        body.put("lastName", "Fajars");
        body.put("email", createdEmail);

        response = userApiRequest.createUser(body);
        createdUserId = response.jsonPath().getString("id");
    }

    @When("user sends request to get created user by id")
    public void userSendsRequestToGetCreatedUserById() {
        response = userApiRequest.getUserById(createdUserId);
    }

    @When("user sends request to update created user")
    public void userSendsRequestToUpdateCreatedUser() {
        JSONObject body = new JSONObject();
        body.put("firstName", "HakikiUpdated");

        response = userApiRequest.updateUser(createdUserId, body);
    }

    @When("user sends request to delete created user")
    public void userSendsRequestToDeleteCreatedUser() {
        response = userApiRequest.deleteUser(createdUserId);
    }

    @When("user sends request to create user without email")
    public void userSendsRequestToCreateUserWithoutEmail() {
        JSONObject body = new JSONObject();
        body.put("firstName", "Negative");
        body.put("lastName", "Test");

        response = userApiRequest.createUser(body);
    }

    @Then("API response status code should be {int}")
    public void apiResponseStatusCodeShouldBe(int expectedStatusCode) {
        Assert.assertEquals(expectedStatusCode, response.statusCode());
    }

    @Then("API response body should contain user data")
    public void apiResponseBodyShouldContainUserData() {
        Assert.assertNotNull(response.jsonPath().getList("data"));
    }

    @Then("API response body should contain tag data")
    public void apiResponseBodyShouldContainTagData() {
        Assert.assertFalse(response.getBody().asString().isEmpty());
    }

    @Then("API response body should contain created user id")
    public void apiResponseBodyShouldContainCreatedUserId() {
        Assert.assertNotNull(createdUserId);
    }

    @Then("API response body should contain created user email")
    public void apiResponseBodyShouldContainCreatedUserEmail() {
        Assert.assertEquals(createdEmail, response.jsonPath().getString("email"));
    }

    @Then("API response body should contain updated user name")
    public void apiResponseBodyShouldContainUpdatedUserName() {
        Assert.assertEquals("HakikiUpdated", response.jsonPath().getString("firstName"));
    }

    @Then("API response body should contain deleted user id")
    public void apiResponseBodyShouldContainDeletedUserId() {
        Assert.assertEquals(createdUserId, response.jsonPath().getString("id"));
    }
}