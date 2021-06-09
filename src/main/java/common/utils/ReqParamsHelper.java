package common.utils;

import cn.hutool.json.JSONObject;

import java.util.Iterator;
import java.util.Map;

/**
 * @author leifeng.cai
 * @description 封装params参数
 * @time: 2021/6/9 13:43
 **/
public class ReqParamsHelper {


    public static void setParams(String paramName, String paramValue, Map<String, String> paramsMap ) {
        paramsMap.put(paramName, paramValue);
    }


}
