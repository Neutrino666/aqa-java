package ru.education.aqajava.tests.lessons.lesson5;

import io.restassured.specification.ResponseSpecification;
import ru.education.aqajava.tests.lessons.lesson5.structure.apiHelper.ApiHelper;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static io.restassured.RestAssured.expect;


public class BaseTest {
    public static ResponseSpecification resp200 = expect().statusCode(200);
    public static ResponseSpecification resp400 = expect().statusCode(400);
    public static ResponseSpecification resp401 = expect().statusCode(401);
    public static ResponseSpecification resp403 = expect().statusCode(403);
    public static ResponseSpecification resp406 = expect().statusCode(406);
    public static ResponseSpecification resp404 = expect().statusCode(404);
    public static ResponseSpecification resp413 = expect().statusCode(413);
    public static ResponseSpecification resp422 = expect().statusCode(422);
    public static ResponseSpecification resp500 = expect().statusCode(500);

    public static Properties props;
    public static ApiHelper apiHelper;

    static {
        String service = "service";

        InputStream is = ClassLoader.getSystemResourceAsStream(service + ".properties");
        props = new Properties();
        try {
            props.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        apiHelper = new ApiHelper();
    }
}
