package Day8;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.ConfigurationReader;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.*;

public class SpartanFlow {

    int id;
    @BeforeClass
    public void beforeclass(){
        baseURI= ConfigurationReader.get("spartan_api_url");
    }

    @Test(priority = 1)
    public void POSTNewSpartan(){}

    @Test(priority = 2)
    public void PUTExistingSpartan(){}

    @Test(priority = 3)
    public void PATCHExistingSpartan(){}

    @Test(priority = 4)
    public void GETThatSpartan(){}

    @Test(priority = 5)
    public void DELETEThatSpartan(){}

}
