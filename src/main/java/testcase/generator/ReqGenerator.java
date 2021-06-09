package testcase.generator;

import entity.request.BaseReq;
import io.restassured.response.Response;

public interface ReqGenerator {


    public  Response start(BaseReq baseReq);
}


