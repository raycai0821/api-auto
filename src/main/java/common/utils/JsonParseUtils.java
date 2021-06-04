package common.utils;

import base.TestBase;
import cn.hutool.json.JSONObject;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

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
    public static Set<Map.Entry<String, Object>> JsonExtract(JSONObject jsonObject, String node) {
        //加载配置文件

        //将path节点下的转成对象
        JSONObject jsonObjectPaths = (JSONObject) jsonObject.get(node);
        //paths下的节点转成set
        return jsonObjectPaths.entrySet();
        //遍历paths下的所有节点
//        Iterator<Map.Entry<String, Object>> it = entries.iterator();
//
//        Map<String, Object> map = new HashMap<String, Object>();
//        while (it.hasNext()) {
//            Map.Entry<String, Object> next = it.next();
//            map.put(next.getKey(), next.getValue());
//        }
//
//        return map;
    }

    /**
     * 获取具体字段值schema
     *
     * @param jsonObject
     * @return
     */

    public static String getSchema(JSONObject jsonObject, String schemanode) {
        //获取sheme里的字段值
        String scheme = from(jsonObject.toString()).getString(schemanode);
        return scheme;
    }

    public static JSONObject getDefinition(Set<Map.Entry<String, Object>> set, String definitionNode) {
        Iterator<Map.Entry<String, Object>> it = set.iterator();
        Map<String, Object> definitionMap = new HashMap<String, Object>();
        while (it.hasNext()) {
            Map.Entry<String, Object> next = it.next();
            definitionMap.put(next.getKey(), next.getValue());
        }
        return (JSONObject) definitionMap.get("definitionNode");

    }
}
