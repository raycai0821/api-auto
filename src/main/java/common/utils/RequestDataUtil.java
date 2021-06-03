package common.utils;

import base.TestBase;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.io.File;
import java.util.*;

import static io.restassured.RestAssured.get;

/**
 * @author leifeng.cai
 * @description
 * @time: 2021/6/3 14:23
 **/
public class RequestDataUtil extends TestBase {
    /**
     * 接口测试数据来源
     * @param src
     * @return
     */
    public static String getApiData(String src) {
        //加载配置文件
        init();
        //使用配置文件的swagger地址
        Response response = get(TestBase.prop.getProperty("swagger_address") + "/v2/api-docs");
        JSONObject jsonObject = JSONUtil.parseObj(response.asPrettyString());
        //将path节点下的转成对象
        JSONObject jsonObjectPaths = (JSONObject) jsonObject.get("paths");
        //paths下的节点转成set
        Set<Map.Entry<String, Object>> entries = jsonObjectPaths.entrySet();
        //遍历paths下的所有节点
        Iterator<Map.Entry<String, Object>> it = entries.iterator();
        while(it.hasNext()){
            Map.Entry<String, Object> map = it.next();
            System.out.println("key=" + map.getKey());
        }
        return response.asPrettyString();
    }
}
