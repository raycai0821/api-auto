package common.utils;

import base.TestBase;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import io.restassured.response.Response;

import static io.restassured.RestAssured.get;

/**
 * @author leifeng.cai
 * @description
 * @time: 2021/6/4 13:20
 **/
public class SourceRequest extends TestBase {

    public static JSONObject getSrcJsonFromSwagger(String url)
    {
        init();
        //使用配置文件的swagger地址
        Response response = get(TestBase.prop.getProperty("swagger_address") + url);
        return JSONUtil.parseObj(response.asPrettyString());

    }

}

