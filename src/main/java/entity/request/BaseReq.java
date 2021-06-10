package entity.request;

import cn.hutool.json.JSONObject;
import lombok.Data;
import org.springframework.http.HttpMethod;

import java.util.List;
import java.util.Map;

/**
 * @author leifeng.cai
 * @description
 * @time: 2021/6/9 14:31
 **/
@Data
public abstract class BaseReq {


    private List<ReqHeader> reqHeaders;

    private List<ReqQuery> reqQueries;

    private JSONObject jsonObject;



    public abstract HttpMethod getHttpMethod();


}
