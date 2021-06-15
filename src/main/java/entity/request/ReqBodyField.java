package entity.request;

import lombok.Data;

/**
 * @author leifeng.cai
 * @description
 * @time: 2021/6/11 9:52
 **/
@Data
public class ReqBodyField {

    private String fieldName;

    private boolean isRequired;

    private String fieldType;

    private String description;

    private ReqBodyField belongsTo;


}
