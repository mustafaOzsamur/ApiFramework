package test;

import baseUrl.HerrokuAppBaseUrl;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C17_BaseUrlHerokuappQueryParam extends HerrokuAppBaseUrl {
    // Class icinde 3 Test metodu olusturun ve asagidaki testleri yapin
    /*
        1-  https://restful-booker.herokuapp.com/booking endpointine bir GET
        request gonderdigimizde donen response’un status code’unun 200 oldugunu
        ve Response’ta 33071 id'ye sahip bir booking oldugunu test edin
     */
     /*
        2- https://restful-booker.herokuapp.com/booking endpointine gerekli
        Query parametrelerini yazarak “firstname” degeri “Eric” olan rezervasyon
        oldugunu test edecek bir GET request gonderdigimizde, donen response’un
        status code’unun 200 oldugunu ve “Eric” ismine sahip en az bir booking oldugunu test edin
    */
    /*
        3- https://restful-booker.herokuapp.com/booking endpointine gerekli Query
         parametrelerini yazarak “firstname” degeri “Jim” ve “lastname” degeri
         “Jackson” olan rezervasyon oldugunu test edecek bir GET request gonderdigimizde,
         donen response’un status code’unun 200 oldugunu ve “Jim Jackson” ismine sahip
         en az bir booking oldugunu test edin.
    */

    @Test
    public void get01(){
        /*
        1-  https://restful-booker.herokuapp.com/booking endpointine bir GET
        request gonderdigimizde donen response’un status code’unun 200 oldugunu
        ve Response’ta 33071 id'ye sahip bir booking oldugunu test edin
     */

        //1-Url Hazirla
        specHerrOkuApp.pathParam("pp1","booking");

        //3-Response Kaydet

        Response response=given().spec(specHerrOkuApp).when().get("/{pp1}");
        response.prettyPrint();
        //4-Assertion

        response
                .then()
                .assertThat()
                .statusCode(200).body("bookingid", Matchers.hasItem(153));
    }


    @Test
    public void get02(){
/*
        2- https://restful-booker.herokuapp.com/booking endpointine gerekli
        Query parametrelerini yazarak “firstname” degeri “Eric” olan rezervasyon
        oldugunu test edecek bir GET request gonderdigimizde, donen response’un
        status code’unun 200 oldugunu ve “Eric” ismine sahip en az bir booking oldugunu test edin
        //1-Url Hazirla

    */

        specHerrOkuApp.pathParam("pp1","booking").queryParam("firstname","Eric");

        //3-Response Kaydet
        Response response=given().spec(specHerrOkuApp).when().get("/{pp1}");
        response.prettyPrint();


        //4- Assertion

        response.then().assertThat().statusCode(200);
    }

    @Test
    public void get03(){
/*
        3- https://restful-booker.herokuapp.com/booking endpointine gerekli Query
         parametrelerini yazarak “firstname” degeri “Jim” ve “lastname” degeri
         “Jackson” olan rezervasyon oldugunu test edecek bir GET request gonderdigimizde,
         donen response’un status code’unun 200 oldugunu ve “Jim Jackson” ismine sahip
         en az bir booking oldugunu test edin.
    */

        specHerrOkuApp.pathParam("pp1","booking").queryParams("firstname","Jim","lastname","Jackson");
        Response response=given().spec(specHerrOkuApp).when().get("/{pp1}");
        response.prettyPrint();

        response.then().assertThat().statusCode(200);
    }
}
