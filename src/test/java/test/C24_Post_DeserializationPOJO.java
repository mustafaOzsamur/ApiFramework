package test;

import baseUrl.HerrokuAppBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import pojos.BookingdatesPOJO;
import pojos.HerOkuBookingPojo;
import pojos.HerokuappExpDataPOJO;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C24_Post_DeserializationPOJO extends HerrokuAppBaseUrl {
    /*
    https://restful-booker.herokuapp.com/booking url’ine asagidaki body'ye sahip bir POST
    request gonderdigimizde donen response’un id haric asagidaki gibi oldugunu test edin.

    Request body
{
"firstname" : "Ahmet",
"lastname" : “Bulut",
"totalprice" : 500,
"depositpaid" : false,
"bookingdates" : {
"checkin" : "2021-06-01",
"checkout" : "2021-06-10"
},
"additionalneeds" : "wi-fi"
}

Response Body // expected data
{
"bookingid": 24,
"booking": {
"firstname": "Ahmet",
"lastname": "Bulut",
"totalprice": 500,
"depositpaid": false,
"bookingdates": {
"checkin": "2021-06-01",
"checkout": "2021-06-10"
},
"additionalneeds": "wi-fi"
}
}

     */

@Test
    public void post(){
    specHerrOkuApp.pathParam("pp1","booking");

    BookingdatesPOJO bookingdatesPOJO=new BookingdatesPOJO("2021-06-01","2021-06-10");

    HerOkuBookingPojo reqBody=new HerOkuBookingPojo("Ahmet","Bulut",500,false,bookingdatesPOJO,"wi-fi");



    HerokuappExpDataPOJO expData=new HerokuappExpDataPOJO(24,reqBody);


    Response response=given().spec(specHerrOkuApp).contentType(ContentType.JSON).when().body(reqBody).post("/{pp1}");
    response.prettyPrint();
    HerokuappExpDataPOJO respPojo=response.as(HerokuappExpDataPOJO.class);



    assertEquals(expData.getBooking().getFirstname(),respPojo.getBooking().getFirstname());
    assertEquals(expData.getBooking().getLastname(),respPojo.getBooking().getLastname());
    assertEquals(expData.getBooking().getTotalprice(),respPojo.getBooking().getTotalprice());
    assertEquals(expData.getBooking().getAdditionalneeds(),respPojo.getBooking().getAdditionalneeds());
    assertEquals(expData.getBooking().isDepositpaid(),respPojo.getBooking().isDepositpaid());
    assertEquals(expData.getBooking().getBookingdates().getCheckout(),respPojo.getBooking().getBookingdates().getCheckout());
    assertEquals(expData.getBooking().getBookingdates().getCheckin(),respPojo.getBooking().getBookingdates().getCheckin());




    }
}
