package baseUrl;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class HerrokuAppBaseUrl {

    // https://restful-booker.herokuapp.com

    protected RequestSpecification specHerrOkuApp;


    @Before
    public void setUp(){


        specHerrOkuApp=new RequestSpecBuilder().setBaseUri("https://restful-booker.herokuapp.com").build();
    }
}
