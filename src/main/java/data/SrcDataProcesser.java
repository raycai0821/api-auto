package data;

import cn.hutool.json.JSONObject;
import common.utils.JsonParseUtils;
import common.utils.SourceRequest;

import java.util.*;

/**
 * @author leifeng.cai
 * @description 根据swagger返回的字段进行处理
 * @time: 2021/6/4 11:31
 **/
public class SrcDataProcesser {

    public static void JsondataProcess() {
        //获取SWAGGER返回接口参数
        JSONObject jsonObject = SourceRequest.getSrcJsonFromSwagger("/v2/api-docs");
        //截取paths节点数据
        Set<Map.Entry<String, Object>> pathSet = JsonParseUtils.JsonExtract(jsonObject, "paths");
        //截取definition节点数据
        Set<Map.Entry<String, Object>> defSet = JsonParseUtils.JsonExtract(jsonObject, "definitions");
        //遍历path节点
        Iterator<Map.Entry<String, Object>> it = pathSet.iterator();
        Iterator<Map.Entry<String, Object>> defSetIt = defSet.iterator();
        //key=path,value=definition
        Map<String, String> pathDefMap = new HashMap<String, String>();
        //遍历获取url和对应的schema
        while (it.hasNext()) {
            Map.Entry<String,Object> next = it.next();
            JSONObject pathJson = new JSONObject(next.getValue().toString());
            //如果是post需要获取节点下schema，get没有
            if(pathJson.containsKey("post")){
                String schema = JsonParseUtils.getSchema(pathJson, "post.parameters.schema.$ref");
                System.out.println("schema=" + schema);
//                JsonParseUtils.getDefinition();
            }
        }



    }

    //        //获取definitions节点
//    Map<String, Object> definitions = JsonParseUtils.JsonExtract(jsonObject, "definitions");
    //通知shcme值获取对应参数列表

}
