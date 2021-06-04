package common.utils;

import base.TestBase;
import cn.hutool.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.path.json.JsonPath.from;

/**
 * @author leifeng.cai
 * @description Json 解析
 * @time: 2021/6/3 14:23
 **/
public class JsonParseUtils extends TestBase {

    /**
     * 根据节点参数获取json节点数据
     *
     * @param jsonObject
     * @param node
     * @return map
     */
    public static Map JsonExtractByNode(JSONObject jsonObject, String node) {

        return jsonObject.get(node, Map.class);

    }

    /**
     * 获取具体字段值schema
     *
     * @param jsonObject
     * @return
     */

    public static String getSchemaName(JSONObject jsonObject, String schemaNode) {
        //获取sheme里的字段值
        return from(jsonObject.toString()).getString(schemaNode);
    }

    /**
     * 通过shema获取对应definiationd的json对象
     *
     * @param schemaName
     * @return
     */

    public static JSONObject getSchemaDef(String schemaName) {
        Map<String, JSONObject> defNodeMap = JsonParseUtils.JsonExtractByNode(jsonObject, "definitions");
        return defNodeMap.get(schemaName);
    }

    /**
     *
     * 获取definition中指定对象
     * @param colName
     * @param schemaName
     * @return
     */
    public static JSONObject getDefData(String colName, String schemaName){
        return (JSONObject)getSchemaDef(schemaName).getByPath(colName);
    }

    /**
     * 请求swagger，并将pathurl+schema进行返回,一个url对应一个schema
     *
     * @return pathSchemaMap
     */

    public static Map<String, String> getPathSchema() {
        //获取SWAGGER返回接口参数
        //截取paths节点数据
        Map<String, JSONObject> pathNodeMap = JsonParseUtils.JsonExtractByNode(jsonObject, "paths");
        Map<String, String> pathSchemaMap = new HashMap<String, String>();
        for (Map.Entry<String, JSONObject> entry1 : pathNodeMap.entrySet()) {
            JSONObject entryObj = entry1.getValue();
            String schema = JsonParseUtils.getSchemaName(entryObj, "post.parameters.schema.$ref");
            //将url作为key，schema作为value存入map
            pathSchemaMap.put(entry1.getKey(), schema);
            System.out.println("schema=" + schema);
        }
        return pathSchemaMap;

    }

}
