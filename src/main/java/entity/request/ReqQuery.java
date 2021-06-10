package entity.request;

import lombok.Data;

/**
 * @author leifeng.cai
 * @description get请求参数
 * @time: 2021/6/10 15:06
 **/
@Data
public class ReqQuery {

    private String type;

    private  String format;

    private  String name;

    private boolean isRequired;

    private int fieldLength;
}
