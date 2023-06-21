package test;

import baseUrl.HerrokuAppBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;
import testData.TestDataHerokuapp;

import static io.restassured.RestAssured.given;

public class C21_Post_TestDataKullanimi extends HerrokuAppBaseUrl {
/*
    https://restful-booker.herokuapp.com/booking url’ine asagidaki body'ye sahip
    bir POST request gonderdigimizde donen response’un status kodunu ve id haric
    body'sinin asagidaki gibi oldugunu test edin.
    Request body


          {
          "firstname" : "Ali",
          "lastname" : “Bak",
          "totalprice" : 500,
          "depositpaid" : false,
          "bookingdates" : {
                      "checkin" : "2021-06-01",
                      "checkout" : "2021-06-10"
                        },
          "additionalneeds" : "wi-fi"
           }
    Expected Body
    {
    "bookingid":24,
    "booking":{
            "firstname":"Ali",
            "lastname":"Bak",
            "totalprice":500,
            "depositpaid":false,
            "bookingdates":{
                            "checkin":"2021-06-01",
                            "checkout":"2021-06-10"
                            },
            "additionalneeds":"wi-fi"
               }
    }
     */

    @Test
    public void post01(){

        //1 - Url ve Request Body hazirla

        specHerrOkuApp.pathParam("pp1","booking");

        // Request Body

        TestDataHerokuapp testDataHerokuapp=new TestDataHerokuapp();
        JSONObject reqBody= testDataHerokuapp.bookingOlusturJSON();

        // Expected Data

        JSONObject expData=testDataHerokuapp.ExpectedBodyOlusturJSON();

        //3 Response Kaydet

        Response response=given()
                                .spec(specHerrOkuApp)
                                .contentType(ContentType.JSON)
                        .when()
                                .body(reqBody.toString())
                                .post("/{pp1}");





    }
}
