package testData;

import org.json.JSONObject;

public class TestDataHerokuapp {

    public int basariliStatusCoe=200;
    /*
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


    public JSONObject bookingDatesOlusturJSON(){
        JSONObject bookingdates=new JSONObject();

        bookingdates.put("checkin" , "2021-06-01");
        bookingdates.put("checkout","2021-06-10");

        return  bookingdates;
    }

    public JSONObject bookingOlusturJSON(){
        JSONObject booking =new JSONObject();

        booking.put("firstname","Ali");
        booking.put("lastname","Bak");
        booking.put("totalprice",500);
        booking.put("depositpaid",false);
        booking.put("additionalneeds","wi-fi");
        booking.put("bookingdates",bookingDatesOlusturJSON());

        return booking;
    }

    public JSONObject ExpectedBodyOlusturJSON(){
        JSONObject expData=new JSONObject();

        expData.put("bookingId" , 24);
        expData.put("booking",bookingOlusturJSON());

        return  expData;
    }


}
