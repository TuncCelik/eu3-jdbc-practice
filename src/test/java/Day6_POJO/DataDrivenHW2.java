package Day6_POJO;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.ConfigurationReader;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.*;

import org.testng.annotations.Test;

public class DataDrivenHW2 {
    @BeforeClass
    public void beforeclass(){
        baseURI= ConfigurationReader.get("api_mackaroo_url");
    }

    //Homework-2
    //-Create one mackaroo api for name,gender,phone
    //send get request to retrieve random info from that api
    //use those info to send post request to spartan
    @Test
    public void dataDrivenHw2(){
        Map<String,Object> requestMap = new HashMap<>();
        //adding value that we want to post
        requestMap.put("first_name","MikeEU2");
        requestMap.put("gender","Male");
        requestMap.put("phone",8877445596l);

        Response response = given().accept(ContentType.JSON)
                .and()
                .contentType(ContentType.JSON)
                .and()
                .body(requestMap)
                .when()
                .post("/eu3mackaroo?key=1e2cf6c0")
                ;


        //response.prettyPrint();
        //JsonPath jsonPath = response.jsonPath();






    }
}
