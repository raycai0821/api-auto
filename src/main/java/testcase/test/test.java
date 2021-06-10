package testcase.test;

import base.TestBase;
import builders.GetRequestBuilder;
import common.utils.SwaggerJsonParser;
import entity.request.GetRequest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import testcase.generator.GetReqGenerator;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

/**
 * @author leifeng.cai
 * @description
 * @time: 2021/6/3 14:44
 **/
public class test extends TestBase {

    @BeforeTest
    public void setUp(){
        init();
    }


//    public void test1(){
//        Map<String, String> headers = new HashMap<String, String>();
//        headers.put("X-MemberCode", "MECN0163");
//        headers.put("headers", "222333");
//        Map<String, String> params = new HashMap<String, String>();
//        params.put("param","222");
//        params.put("param2", "3333");
//        //链式调用
//        GetRequest getRequest = new GetRequestBuilder()
//                .setParamsMap(params)
//                .setHeaderMap(headers)
//                .setReqUrl("http://api.st2.com/authorize")
//                .build();
//        GetReqGenerator getReqGenerator = new GetReqGenerator();
//        getReqGenerator.start(getRequest);
//
//    }

    @Test
    public void test(){
        Map paths = SwaggerJsonParser.parsePath(response.asPrettyString());

        given()
                .header("X-MemberCode","X-SecretKey")

                .when()
                .get("http://api.st2.com/authorize")
                .then()
                .statusCode(401);

    }
}
