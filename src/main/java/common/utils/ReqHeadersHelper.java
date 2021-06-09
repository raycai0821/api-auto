package common.utils;

import java.util.Map;

/**
 * @author leifeng.cai
 * @description 将headers封装成map
 * @time: 2021/6/9 13:43
 **/
public class ReqHeadersHelper {


    public static void setHeaders(String headerName, String headerValue, Map<String, String> headersMap) {
        headersMap.put(headerName, headerValue);
    }
}
