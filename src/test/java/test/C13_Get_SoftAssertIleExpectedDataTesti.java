package test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;
import static junit.framework.TestCase.assertEquals;

public class C13_Get_SoftAssertIleExpectedDataTesti {
/*
    http://dummy.restapiexample.com/api/v1/employee/3 url’ine bir GET request
    gonderdigimizde donen response’un asagidaki gibi oldugunu test edin.
        Response Body
        {
        "status":"success",
        "data":{
                "id":3,
                "employee_name":"Ashton Cox",
                "employee_salary":86000,
                "employee_age":66,
                "profile_image":""
                },
        "message":"Successfully! Record has been fetched."
        }
     */


    @Test
    public void get01(){

        //1-Url Hazirla
        String url="http://dummy.restapiexample.com/api/v1/employee/3";


        //2- Expected Data Hazirla
        JSONObject ExpInnerData=new JSONObject();
        ExpInnerData.put("id", 3);
        ExpInnerData.put("employee_name", "Ashton Cox");
        ExpInnerData.put("employee_salary", 86000);
        ExpInnerData.put("employee_age", 66);
        ExpInnerData.put("profile_image", "");

        JSONObject ExpreqBody=new JSONObject();
        ExpreqBody.put( "status", "success");
        ExpreqBody.put("data",ExpInnerData);
        ExpreqBody.put("message", "Successfully! Record has been fetched.");

       //3- Response kaydet

        Response response=given().when().get(url);
        response.prettyPrint();

        //4-Assertion

        SoftAssert softAssert= new SoftAssert();

        JsonPath respJP=response.jsonPath();

        softAssert.assertEquals(respJP.get("status"),ExpreqBody.get("status"));
        softAssert.assertEquals(respJP.get("message"),ExpreqBody.get("message"));
        softAssert.assertEquals(respJP.get("data.id"),ExpreqBody.getJSONObject("data").get("id"));
        softAssert.assertEquals(respJP.get("data.employee_name"),ExpreqBody.getJSONObject("data").get("employee_name"));
        softAssert.assertEquals(ExpreqBody.getJSONObject("data").get("employee_salary"),respJP.get("data.employee_salary"));
        softAssert.assertEquals(ExpreqBody.getJSONObject("data").get("employee_age"),respJP.get("data.employee_age"));
        softAssert.assertEquals(ExpreqBody.getJSONObject("data").get("profile_image"),respJP.get("data.profile_image"));




        softAssert.assertAll();
    }

}
