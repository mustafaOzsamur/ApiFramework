package SelberUben;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C05_Put_SoftAssertIleExpectedDataTesti {
                /*
                http://dummy.restapiexample.com/api/v1/update/21 url’ine asagidaki body’ye sahip bir PUT
            request gonderdigimizde donen response’un asagidaki gibi oldugunu test edin.
            Request Body
            {
            "status": "success",
            "data": {
            "name": “Ahmet",
            "salary": "1230",
            "age": "44",
            "id": 40
            }
            }



            Response Body
            { "status": "success",
            "data": {
            "status": "success",
            "data": {
            "name": “Ahmet",
            "salary": "1230",
            "age": "44",
            "id": 40 }
            },
            "message": "Successfully! Record ha
            s been updated."}
                 */



    @Test
    public void put01(){
        // 1- Url ve Request Body Hazirla

        String url="https://dummy.restapiexample.com/api/v1/update/21";
        /*
        Request Body
            {
            "status": "success",
            "data": {
            "name": “Ahmet",
            "salary": "1230",
            "age": "44",
            "id": 40
            }
            }
         */

        JSONObject data=new JSONObject();
        data.put("name", "Ahmet");
        data.put("salary", "1230");
        data.put("age", "44");
        data.put("id", 40);

        JSONObject reqBody=new JSONObject();
        reqBody.put("status", "success");
        reqBody.put("data",data);



        //3- Response kaydet

        Response response=given()
                .contentType(ContentType.JSON)
                .when()
                .body(reqBody.toString())
                .put(url);


        response.prettyPrint();



    }
}
