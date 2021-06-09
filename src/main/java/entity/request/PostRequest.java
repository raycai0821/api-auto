package entity.request;

import lombok.Data;
import org.springframework.http.HttpMethod;

/**
 * @author leifeng.cai
 * @description
 * @time: 2021/6/9 10:12
 **/

@Data
public class PostRequest extends BaseReq {

    @Override
    public HttpMethod getHttpMethod() {
        return HttpMethod.POST;
    }
}
