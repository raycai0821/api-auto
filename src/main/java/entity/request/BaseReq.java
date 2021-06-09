package entity.request;

import lombok.Data;
import org.springframework.http.HttpMethod;

import java.util.Map;

/**
 * @author leifeng.cai
 * @description
 * @time: 2021/6/9 14:31
 **/
@Data
public abstract class BaseReq {

    private String reqUrl;

    private Map<String, String> headersMap;

    private Map<String, String> paramsMap;

    private String requestBody;

    public abstract HttpMethod getHttpMethod();


}
