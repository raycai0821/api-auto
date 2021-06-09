package testcase.generator;

import entity.request.BaseReq;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

/**
 * @author leifeng.cai
 * @description post请求测试用例生成
 * @time: 2021/6/9 14:28
 **/
public class PostReqGenerator implements ReqGenerator {


    @Override
    public Response start(BaseReq baseReq) {
        Response response = null;
        response = given()
                .headers(baseReq.getHeadersMap())
                .queryParams(baseReq.getParamsMap())
                .body(baseReq.getRequestBody())
                .when()
                .get(baseReq.getReqUrl());
        return response;
    }
}

