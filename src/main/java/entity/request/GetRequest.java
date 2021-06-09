package entity.request;

import lombok.Data;
import org.springframework.http.HttpMethod;

import java.util.Map;

/**
 * @author leifeng.cai
 * @description
 * @time: 2021/6/8 16:52
 **/
@Data
public class GetRequest extends BaseReq {


    @Override
    public HttpMethod getHttpMethod() {
        return HttpMethod.GET;
    }
}
