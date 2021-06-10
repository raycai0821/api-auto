package entity.request;

import lombok.Data;

/**
 * @author leifeng.cai
 * @description
 * @time: 2021/6/10 15:11
 **/

@Data
public class ReqHeader {

    private String headerName;

    private String tyPe;

    private boolean isRequired;

    private int fieldLength;

    private String url;

    private String httpMethod;

}
