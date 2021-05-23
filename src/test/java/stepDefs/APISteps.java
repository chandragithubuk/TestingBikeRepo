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

        String jsonpathNetworkLocationCity = "$['network']['location']['city']";
        DocumentContext jsonContext = JsonPath.parse(jsonString);
        String locationCity = jsonContext.read(jsonpathNetworkLocationCity);
        System.out.println("City: "+locationCity);

        String jsonpathNetworkLocationLatitude = "$['network']['location']['latitude']";
        DocumentContext jsonContextLatitude = JsonPath.parse(jsonString);
        Double locationLatitude = jsonContextLatitude.read(jsonpathNetworkLocationLatitude);
        System.out.println("Latitude: "+locationLatitude);

        String jsonpathNetworkLocationLongitude = "$['network']['location']['longitude']";
        DocumentContext jsonContextLongitude = JsonPath.parse(jsonString);
        Double locationLongitude = jsonContextLongitude.read(jsonpathNetworkLocationLongitude);
        System.out.println("Longitude: "+locationLongitude);

        String jsonpathNetworkCompany = "$['network']['company']";
        DocumentContext jsonContextCompany = JsonPath.parse(jsonString);
        JSONArray networkCompany = jsonContextCompany.read(jsonpathNetworkCompany);
        System.out.println("Company: "+networkCompany);

/*
        jsonString = response.asString();
        System.out.println("Response: "+jsonString);

        Map<String, String> bikes = JsonPath.from(jsonString).get("network");
        Assert.assertTrue(bikes.size() > 0);
        System.out.println("BikeSize: " + bikes.size());

        System.out.println("Id: "+bikes.get("id"));
        System.out.println("href: "+bikes.get("href"));
        System.out.println("location: "+bikes.get("location"));
*/
       // Map<Object, Object> locationInfo = JsonPath.from(jsonString).get("location");
        //System.out.println("Location: "+ bikes.get("location"));
        //Map<Object, Object> locationInfo = bikes.get("location");
        //System.out.println("LocationInfo: "+locationInfo);
        //System.out.println("City: "+locationInfo.get("city"));
    }

    @Then("^User validates the response status is (.*)$")
    public void User_validates_response_status_code(int code){
        Assert.assertEquals(code, response.getStatusCode());
    }
}
