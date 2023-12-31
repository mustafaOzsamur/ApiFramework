package test;

import baseUrl.HerrokuAppBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import pojos.BookingPOJO;
import pojos.BookingdatesPOJO;
import pojos.HerokuappExpectedBodyPOJO;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C26_Post_Pojo extends HerrokuAppBaseUrl {


    /*
    https://restful-booker.herokuapp.com/booking url’ine
    asagidaki body'ye sahip bir POST request gonderdigimizde
    donen response’un id disinda asagidaki gibi oldugunu test edin.
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
                        Response Body = Expected Data
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
                                        }
                        ,
                        "additionalneeds":"wi-fi"
                              }
                    }
         */

@Test
    public void put(){
    specHerrOkuApp.pathParam("pp1","booking");

    BookingdatesPOJO bookingdates=new BookingdatesPOJO("2021-06-01","2021-06-10");

    BookingPOJO reqBody= new BookingPOJO("Ali","Bak",500,false,bookingdates,"wi-fi");

    HerokuappExpectedBodyPOJO expData=new HerokuappExpectedBodyPOJO(24,reqBody);

    Response response=given().spec(specHerrOkuApp).contentType(ContentType.JSON).when().body(reqBody).post("/{pp1}");

    response.prettyPrint();


    //4-Assertion


    HerokuappExpectedBodyPOJO respPojo= response.as(HerokuappExpectedBodyPOJO.class);

    assertEquals(expData.getBooking().getFirstname(),respPojo.getBooking().getFirstname());
    assertEquals(expData.getBooking().getLastname(),respPojo.getBooking().getLastname());
    assertEquals(expData.getBooking().getTotalprice(),respPojo.getBooking().getTotalprice());

    assertEquals(expData.getBooking().getBookingdates().getCheckin(),respPojo.getBooking().getBookingdates().getCheckin());
    assertEquals(expData.getBooking().getBookingdates().getCheckout(),respPojo.getBooking().getBookingdates().getCheckout());
    assertEquals(expData.getBooking().isDepositpaid(),respPojo.getBooking().isDepositpaid());
    assertEquals(expData.getBooking().getAdditionalneeds(),respPojo.getBooking().getAdditionalneeds());

  }
}
