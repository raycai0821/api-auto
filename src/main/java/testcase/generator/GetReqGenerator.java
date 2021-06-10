package testcase.generator;

import entity.request.BaseReq;
import io.restassured.response.Response;
import sun.security.x509.OtherName;

import static io.restassured.RestAssured.given;

/**
 * @author leifeng.cai
 * @description get请求测试用例生成
 * @time: 2021/6/9 14:28
 **/
public class GetReqGenerator implements ReqGenerator {

    /**
     * 根据req开启请求
     */
    @Override
    public Response start(BaseReq baseReq) {
        Response response = null;


        return response;
    }
}
