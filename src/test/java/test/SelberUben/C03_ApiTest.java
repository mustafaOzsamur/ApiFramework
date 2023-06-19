package test.SelberUben;

import org.json.JSONObject;
import org.junit.Test;

public class C03_ApiTest {


    /*
    Asagidaki JSON Objesini olusturup konsolda yazdirin.
    {
        "title":"Ahmet",
        "body":"Merhaba",
        "userId":1
    }
    */

    @Test
    public void JsonObje01(){

        JSONObject ilkObje=new JSONObject();

        ilkObje.put("title","Ahmet");
        ilkObje.put("body","Merhaba");
        ilkObje.put("userId",1);

        System.out.println("ilk json obje: "+ ilkObje);

    }

    @Test
    public void JsonObje2(){
         /*
                {
                 "firstname":"Jim",
                 "additionalneeds":"Breakfast",
                 "bookingdates":{
                         "checkin":"2018-01-01",
                         "checkout":"2019-01-01"
                    },
                  "totalprice":111,
                  "depositpaid":true,
                  "lastname":"Brown"
                  }
         */

        JSONObject bookingDates=new JSONObject();
        bookingDates.put("checkin","2018-01-01");
        bookingDates.put("checkout","2019-01-01");

        JSONObject outorObje=new JSONObject();

        outorObje.put("firstname","Jim");
        outorObje.put("additionalneeds","Breakfast");
        outorObje.put("bookingdates",bookingDates);
        outorObje.put("totalprice",111);
        outorObje.put("depositpaid",true);
        outorObje.put("lastname","Brown");


        System.out.println("obje: "+outorObje);



    }
}
