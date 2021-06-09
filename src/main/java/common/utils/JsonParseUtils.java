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
     * @param nodeName
     * @return map
     */
    public static Map JsonExtractByNode(JSONObject jsonObject, String nodeName) {

        return jsonObject.get(nodeName, Map.class);

    }

    /**
     * 获取具体字段值schema
     *
     * @param jsonObject
     * @return
     */

    public static String getSchemaName(JSONObject jsonObject, String schemaNode) {
        //获取schema里的字段值
        return from(jsonObject.toString()).getString(schemaNode);
    }

    /**
     * 通过schema获取对应definiation的json对象
     *
     * @param schemaName
     * @return
     */

    public static JSONObject getDefBySchema(String schemaName) {
        Map<String, JSONObject> defNodeMap = JsonParseUtils.JsonExtractByNode(jsonObject, "definitions");
        return defNodeMap.get(schemaName);
    }

    /**
     * 通过schemaname获取definition中指定参数值
     *返回字段值
     * @param defNodeName
     * @param schemaName
     * @return []
     */
    public static String[] getDefDataBySchema( String schemaName, String defNodeName) {
        return new String[]{getDefBySchema(schemaName).getByPath(defNodeName).toString()};
    }


    /**
     * 通过schemaname获取definition中指定参数值
     *返回json对象
     * @param defNodeName
     * @param schemaName
     * @return []
     */
    public static JSONObject getDefJsonBySchema( String schemaName, String defNodeName) {
        return (JSONObject) getDefBySchema(schemaName).getByPath(defNodeName);
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
