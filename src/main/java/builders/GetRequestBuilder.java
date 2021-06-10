package builders;

import entity.request.GetRequest;
import lombok.Data;

import java.util.Map;

/**
 * @author leifeng.cai
 * @description 赋值请求数据类，生成get的request请求对象
 * @time: 2021/6/9 9:53
 * 链式调用
 **/

@Data
public class GetRequestBuilder implements Builder {


    private GetRequest getRequest = new GetRequest();

//    public GetRequestBuilder setParamsMap(Map<String, String> paramsMap){
//        getRequest.setParamsMap(paramsMap);
//        return this;
//    }
//
//    public GetRequestBuilder setHeaderMap(Map<String, String> headersMap){
//        getRequest.setHeadersMap(headersMap);
//        return this;
//    }
//
//    public GetRequestBuilder setReqUrl(String reqUrl){
//        getRequest.setReqUrl(reqUrl);
//        return this;
//    }

    @Override
    public GetRequest build() {
        return getRequest;
    }
}
