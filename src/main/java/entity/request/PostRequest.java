package entity.request;

import cn.hutool.json.JSONObject;
import lombok.Data;
import org.springframework.http.HttpMethod;

/**
 * @author leifeng.cai
 * @description
 * @time: 2021/6/9 10:12
 **/

@Data
public class PostRequest extends BaseReq {

    private JSONObject requestBody;

    @Override
    public HttpMethod getHttpMethod() {
        return HttpMethod.POST;
    }
}
