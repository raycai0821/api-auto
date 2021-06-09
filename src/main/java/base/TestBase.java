package base;

import cn.hutool.core.io.resource.ClassPathResource;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import io.restassured.response.Response;

import java.io.IOException;
import java.util.Properties;

import static io.restassured.RestAssured.get;

/**
 * @author leifeng.cai
 * @description
 * @time: 2021/6/3 14:02
 * 初始化配置
 **/
public class TestBase {



    public static Properties prop;
    public static JSONObject jsonObject;
    public static Response response;

    public static void init() {
        prop = new Properties();
        ClassPathResource resource = new ClassPathResource("app.properties");
        try {
            prop.load(resource.getStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        String swaggerUrl = prop.getProperty("swagger_address");
        response = get(swaggerUrl + "/v2/api-docs");
        jsonObject = JSONUtil.parseObj(response.asPrettyString());
    }


}
