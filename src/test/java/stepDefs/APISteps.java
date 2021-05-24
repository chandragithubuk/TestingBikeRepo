package stepDefs;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;
import org.junit.Assert;
import cucumber.api.java.en.*;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import io.restassured.response.Response;

import java.util.*;

public class APISteps {
    RequestSpecification request;
    Response response;
    private static String locationId;

    @Given("^User sets the base API request (.*)$")
    public void User_sets_the_base_API_request(String url) {
        RestAssured.baseURI = url;
    }

    @When("^User sends the API request to get all bike info$")
    public void User_sends_the_API_request_to_get_all_bike_info(){

        request = RestAssured.given();
        response =request.get("/visa-frankfurt");
        String jsonString = response.asString();

        //Reading Values from the Response using json-path dependency
        // Getting values from Location-City which is in Key-Value format
        String jsonpathNetworkLocationCity = "$['network']['location']['city']";
        DocumentContext jsonContext = JsonPath.parse(jsonString);
        String locationCity = jsonContext.read(jsonpathNetworkLocationCity);
        //System.out.println("City: "+locationCity);
        Assert.assertEquals("Frankfurt", locationCity);

        // Getting values from Location-Latitude which is in Key-Value format
        String jsonpathNetworkLocationLatitude = "$['network']['location']['latitude']";
        DocumentContext jsonContextLatitude = JsonPath.parse(jsonString);
        Double locationLatitude = jsonContextLatitude.read(jsonpathNetworkLocationLatitude);
        //System.out.println("Latitude: "+locationLatitude);
        Double locationlatitudeexpected =50.1072;
        Assert.assertEquals(locationlatitudeexpected, locationLatitude);


        // Getting values from Location-Longitude which is in Key-Value format
        String jsonpathNetworkLocationLongitude = "$['network']['location']['longitude']";
        DocumentContext jsonContextLongitude = JsonPath.parse(jsonString);
        Double locationLongitude = jsonContextLongitude.read(jsonpathNetworkLocationLongitude);
        //System.out.println("Longitude: "+locationLongitude);
        Double locationlongitudeexpected =8.66375;
        Assert.assertEquals(locationlongitudeexpected, locationLongitude);

        // Getting values from Network-Company which is an array format
        String jsonpathNetworkCompany = "$['network']['company']";
        DocumentContext jsonContextCompany = JsonPath.parse(jsonString);
        JSONArray networkCompany = jsonContextCompany.read(jsonpathNetworkCompany);
        System.out.println("Company: "+networkCompany);

    }

    @Then("^User validates the response status is (.*)$")
    public void User_validates_response_status_code(int code){
        Assert.assertEquals(code, response.getStatusCode());
    }
}