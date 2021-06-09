package entity.response;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

/**
 * @author leifeng.cai
 * @description
 * @time: 2021/6/8 11:26
 **/
@Data
public  class BaseResp {

    /**
     * 返回码
     */
    @JSONField(name = "code")
    private String code;

    /**
     * 返回消息
     */
    @JSONField(name = "msg")
    private String msg;

    /**
     * 成功标识
     */
    @JSONField(name = "success")
    private String success;

    /**
     *
     * data
     */
    @JSONField(name = "data")
    private String Data;
}
