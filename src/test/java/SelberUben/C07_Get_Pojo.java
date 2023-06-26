package SelberUben;

import baseUrl.DummyBaseUrl;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import pojos.DummyDataPOJO;
import pojos.DummyExpectedBodyPojo;

import static io.restassured.RestAssured.given;

public class C07_Get_Pojo extends DummyBaseUrl {
    /*
    C29_Get_Pojo
http://dummy.restapiexample.com/api/v1/employee/3 url’ine bir GET request
gonderdigimizde donen response’un asagidaki gibi oldugunu test edin.
Response Body
{
"status": "success",
"data": {
"id": 3,
"employee_name": "Ashton Cox",
"employee_salary": 86000,
"employee_age": 66,
"profile_image": ""
},
"message": "Successfully! Record has been fetched."
}
     */

    @Test
    public void get01(){
        specDummy.pathParams("pp1","api","pp2","v1","pp3","employee","pp4",3);


        DummyDataPOJO data=new DummyDataPOJO(3,"Ashton Cox",86000,66,"");

        DummyExpectedBodyPojo expData=new DummyExpectedBodyPojo("success",data,"Successfully! Record has been fetched.");


        Response response=given().spec(specDummy).when().get("/{pp1}/{pp2}/{pp3}/{pp4}");

        DummyExpectedBodyPojo respPojo=response.as(DummyExpectedBodyPojo.class);

        Assert.assertEquals(expData.getData().getProfile_image(),respPojo.getData().getProfile_image());
        Assert.assertEquals(expData.getData().getId(),respPojo.getData().getId());
        Assert.assertEquals(expData.getData().getEmployee_salary(),respPojo.getData().getEmployee_salary());
        Assert.assertEquals(expData.getData().getEmployee_age(),respPojo.getData().getEmployee_age());
        Assert.assertEquals(expData.getData().getEmployee_name(),respPojo.getData().getEmployee_name());
        Assert.assertEquals(expData.getStatus(),respPojo.getStatus());
        Assert.assertEquals(expData.getMessage(),respPojo.getMessage());
    }
}
