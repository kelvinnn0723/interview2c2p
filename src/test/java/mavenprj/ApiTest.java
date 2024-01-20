package mavenprj;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;


public class ApiTest extends BaseTest {

//API Testing
    @Test
    public void API_Test_1_getCommentsWithId3() {
        // API URL
        String apiUrl = "https://jsonplaceholder.typicode.com/comments";

        //GET request for comments that contains 3
        Response response = RestAssured.get(apiUrl + "/3");

        //Verify status code
        Assert.assertEquals(response.getStatusCode(), 200, "Incorrect status code");

        //Capture response field
        String name = response.jsonPath().getString("name");
        String email = response.jsonPath().getString("email");

        //Verify name and email values in the response body to match with id = 3
        Assert.assertEquals(name, "odio adipisci rerum aut animi", "Incorrect name");
        Assert.assertEquals(email, "Nikita@garfield.biz", "Incorrect email");

        //Print message
        System.out.println("API Test 1: GET Method to retrieve comments with id = 3");
        System.out.println("Name for ID = 3: " + name);
        System.out.println("Email for ID = 3: " + email);
    }

    @Test
    public void API_Test_2_postCommentsAndVerifyId() {
        //Base URL for JSONPlaceholder API
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

        //Request payload
        String requestBody = "{ \"postId\": 1, \"name\": \"Melissa\", \"email\": \"abc@gmail.com\" }";

        // Perform the POST request to the "comments" resource
        Response response = RestAssured
            .given()
            .header("Content-Type", "application/json")
            .body(requestBody)
            .post("/comments");

        // Verify the response status code
        Assert.assertEquals(response.getStatusCode(), 201, "Expected status code 201 (Created)");

        // Parse the response to extract comment ID
        int commentId = response.jsonPath().getInt("id");

        // Verify that the comment ID is greater than 0
        Assert.assertTrue(commentId > 0, "Comment ID should be greater than 0");

        //Print message
        System.out.println("API Test 2: POST Comment Method to retrieve comments with id = 1");
        System.out.println("Comment ID: " + commentId);
        Assert.assertEquals(response.jsonPath().getString("name"), "Melissa", "Incorrect name in the response");
        Assert.assertEquals(response.jsonPath().getString("email"), "abc@gmail.com", "Incorrect email in the response");
    }

    @Test
    public void API_Test_3_getUsersWithId6() {
        //API URL
        String apiUrl = "https://jsonplaceholder.typicode.com/users";

        //Send GET request to retrieve users with id=6
        Response response = RestAssured.get(apiUrl + "/6");

        //Verify the status code
        Assert.assertEquals(response.getStatusCode(), 200, "Incorrect status code");

        //Capture response field
        String street = response.jsonPath().getString("address.street");
        String city = response.jsonPath().getString("address.city");

        //Assertions for "street" and "city"
        Assert.assertEquals(street, "Norberto Crossing", "Incorrect street");
        Assert.assertEquals(city, "South Christy", "Incorrect city");

        //Print message
        System.out.println("API Test 3: GET Method to retrieve street names and city names with user = 6");
        System.out.println("Street Name: " + street);
        System.out.println("City Name: " + city);
    }
}
