package stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static utilities.ApiCalls.trendLifeUser;
import static utilities.Authentication.generateTokenTrendLife;

public class US01_StepDefinition {

    Response response;
    @Given("Admin should connect to the API server with {int}")
    public void admin_should_connect_to_the_api_server_with(Integer id) {
        response = given()
                .header("Authorization","Bearer " + generateTokenTrendLife())
                .when().get(trendLifeUser(id));
    }
    @Then("Verify the status code is {int}")
    public void verify_the_status_code_is(Integer statuscode) {
        response.then().assertThat().statusCode(statuscode) ;
    }
    @Then("Verify the content type is {string}")
    public void verify_the_content_type_is(String contentType) {
    response.then().assertThat().contentType(contentType) ;
    }
    @Then("Verify the user , {string}, {string}, {string}")
    public void verify_the_user(String firstName, String username, String email) {

        response.then().body("user.first_name", equalTo(firstName),
                "user.username",equalTo(username),"user.email",equalTo(email));
    }



}
