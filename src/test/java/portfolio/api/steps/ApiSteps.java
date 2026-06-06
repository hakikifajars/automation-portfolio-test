package portfolio.api.steps;

import io.cucumber.java.en.*;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import portfolio.api.requests.UserApiRequest;

import java.util.Arrays;

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
        createNewUser();
    }

    @When("user sends request to get created user by id")
    public void userSendsRequestToGetCreatedUserById() {
        createUserIfNeeded();
        response = userApiRequest.getUserById(createdUserId);
    }

    @When("user sends request to update created user")
    public void userSendsRequestToUpdateCreatedUser() {
        createUserIfNeeded();

        JSONObject body = new JSONObject();
        body.put("firstName", "HakikiUpdated");

        response = userApiRequest.updateUser(createdUserId, body);
    }

    @When("user sends request to delete created user")
    public void userSendsRequestToDeleteCreatedUser() {
        createUserIfNeeded();
        response = userApiRequest.deleteUser(createdUserId);
    }

    @When("user sends request to create user without email")
    public void userSendsRequestToCreateUserWithoutEmail() {
        JSONObject body = new JSONObject();
        body.put("firstName", "Negative");
        body.put("lastName", "Test");

        response = userApiRequest.createUser(body);
    }

    @When("user sends request to create user without first name")
    public void userSendsRequestToCreateUserWithoutFirstName() {
        JSONObject body = new JSONObject();
        body.put("lastName", "Test");
        body.put("email", generateEmail());

        response = userApiRequest.createUser(body);
    }

    @When("user sends request to create user with invalid email")
    public void userSendsRequestToCreateUserWithInvalidEmail() {
        JSONObject body = new JSONObject();
        body.put("firstName", "Negative");
        body.put("lastName", "Test");
        body.put("email", "invalid-email-format");

        response = userApiRequest.createUser(body);
    }

    @When("user sends request to get user with invalid id")
    public void userSendsRequestToGetUserWithInvalidId() {
        response = userApiRequest.getUserById("invalid-user-id");
    }

    @When("user sends request to update user with invalid id")
    public void userSendsRequestToUpdateUserWithInvalidId() {
        JSONObject body = new JSONObject();
        body.put("firstName", "InvalidUpdate");

        response = userApiRequest.updateUser("invalid-user-id", body);
    }

    @When("user sends request to delete user with invalid id")
    public void userSendsRequestToDeleteUserWithInvalidId() {
        response = userApiRequest.deleteUser("invalid-user-id");
    }

    @When("user sends request to get list of users without app id")
    public void userSendsRequestToGetListOfUsersWithoutAppId() {
        response = userApiRequest.getUsersWithoutAppId();
    }

    @When("user sends request to get list of users with invalid app id")
    public void userSendsRequestToGetListOfUsersWithInvalidAppId() {
        response = userApiRequest.getUsersWithInvalidAppId();
    }

    @Then("API response status code should be {int}")
    public void apiResponseStatusCodeShouldBe(int expectedStatusCode) {
        Assert.assertEquals(expectedStatusCode, response.statusCode());
    }

    @Then("API response status code should be 400 or 404")
    public void apiResponseStatusCodeShouldBe400Or404() {
        Assert.assertTrue(
                Arrays.asList(400, 404).contains(response.statusCode())
        );
    }

    @Then("API response body should contain user data")
    public void apiResponseBodyShouldContainUserData() {
        Assert.assertNotNull(response.jsonPath().getList("data"));
        Assert.assertFalse(response.jsonPath().getList("data").isEmpty());
    }

    @Then("API response body should contain tag data")
    public void apiResponseBodyShouldContainTagData() {
        Assert.assertFalse(response.getBody().asString().isEmpty());
    }

    @Then("API response body should contain created user id")
    public void apiResponseBodyShouldContainCreatedUserId() {
        createdUserId = response.jsonPath().getString("id");

        Assert.assertNotNull(createdUserId);
        Assert.assertFalse(createdUserId.isEmpty());
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

    private void createNewUser() {
        createdEmail = generateEmail();

        JSONObject body = new JSONObject();
        body.put("firstName", "Hakiki");
        body.put("lastName", "Fajars");
        body.put("email", createdEmail);

        response = userApiRequest.createUser(body);
        createdUserId = response.jsonPath().getString("id");
    }

    private void createUserIfNeeded() {
        if (createdUserId == null || createdUserId.isEmpty()) {
            createNewUser();
            Assert.assertEquals(200, response.statusCode());
            Assert.assertNotNull(createdUserId);
        }
    }

    private String generateEmail() {
        return "hakiki" + System.currentTimeMillis() + "@example.com";
    }
}