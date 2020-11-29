package apitests;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.ConfigurationReader;

import java.util.List;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class HW1 {
    @BeforeClass
    public void beforeClass(){
        baseURI = ConfigurationReader.get("hr_api_url");
    }
     /**Q1
    ORDS API:
    - Given accept type is Json
    - Path param value- US
    - When users sends request to /countries
    - Then status code is 200
    - And Content - Type is Json
    - And country_id is US
    - And Country_name is United States of America
    - And Region_id is 2
    */
     @Test
    public void QA1(){
         Response response = given().accept(ContentType.JSON)
                 .and().pathParam("id", "US")
                 .when().get("/countries/{id}");
         assertEquals(response.statusCode(),200);
         assertEquals(response.contentType(),"application/json");

         JsonPath jsonPath = response.jsonPath();
         String country_id = jsonPath.getString("country_id ");
         String country_name = jsonPath.getString("country_name");
         int region_id = jsonPath.getInt("region_id");

         System.out.println("country_id = " + country_id);
         System.out.println("country_name = " + country_name);
         System.out.println("region_id = " + region_id);

         assertEquals(country_id,"US");
         assertEquals(country_name,"United States of America");
         assertEquals(region_id,2);
     }
     /**Q2
        - Given accept type is Json
        - Query param value - q={"department_id":80}
        - When users sends request to /employees
        - Then status code is 200
        - And Content - Type is Json
        - And all job_ids start with 'SA'
        - And all department_ids are 80
        - Count is 25
        */
     @Test
    public void QA2(){
         Response response = given().accept(ContentType.JSON)
                 .and().queryParam("q","{\"department_id\":80}")
                 .when().get("/employees");

         assertEquals(response.statusCode(),200);
         assertEquals(response.contentType(),"application/json");

         JsonPath jsonPath = response.jsonPath();
         List<String> job_id = jsonPath.getList("items.job_id");
         for (String job_IDs : job_id) {
             assertTrue(job_IDs.startsWith("SA"));
         }

         List<Integer> department_id = jsonPath.getList("items.department_id");
         for (Integer department_IDs : department_id) {
             assertTrue(department_IDs.equals(80));
         }
         int count = jsonPath.getInt("count");
         assertEquals(count,25);
     }
     /**Q3:
    - Given accept type is Json
    - Query param value q= region_id 3
    - When users sends request to /countries
    - Then status code is 200
    - And all regions_id is 3
    - And count is 6
    - And hasMore is false
    - And Country_name are;
        Australia,China,India,Japan,Malaysia,Singapore
      */
     @Test
    public void QA3(){
         Response response = given().accept(ContentType.JSON)
                 .and().queryParam("q","region_id 3")
                 .when().get("/countries");

         assertEquals(response.statusCode(),200);

         JsonPath jsonPath = response.jsonPath();

     }

}
