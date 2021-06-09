package builders;

import entity.request.PostRequest;
import lombok.Data;

import java.util.Map;

/**
 * @author leifeng.cai
 * @description 赋值post请求类，生成request
 * @time: 2021/6/9 9:54
 * 链式调用
 **/

@Data
public class PostRequestBuilder implements Builder {

    private PostRequest postRequest = new PostRequest();

    public PostRequestBuilder setParamsMap(Map<String, String> paramsMap) {
        postRequest.setParamsMap(paramsMap);
        return this;
    }

    public PostRequestBuilder setHeaderMap(Map<String, String> headersMap) {
        postRequest.setHeadersMap(headersMap);
        return this;
    }

    public PostRequestBuilder setReqUrl(String reqUrl) {
        postRequest.setReqUrl(reqUrl);
        return this;
    }

    public PostRequestBuilder setReqBody(String requestBody) {
        postRequest.setReqUrl(requestBody);
        return this;
    }


    @Override
    public PostRequest build() {
        return postRequest;
    }
}
