package common.utils;

import entity.request.ReqBodyField;
import io.swagger.models.Model;
import io.swagger.models.properties.Property;
import io.swagger.models.properties.RefProperty;
import io.swagger.models.properties.StringProperty;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author leifeng.cai
 * @description 递归获取def字段
 * @time: 2021/6/11 10:02
 **/


public class DefRecursive {

    public static void recursive(Property property, String fieldName, Map<String, Model> defMap,
                                 Map<String, ReqBodyField> reqBodyFieldMap, Map<String, Map<String, ReqBodyField>> totalRq) {

        if (property instanceof RefProperty) {
            RefProperty refProperty = (RefProperty) property;
            Model model = defMap.get(refProperty.getSimpleRef());
            Map<String, Property> propertyMap = model.getProperties();

            for (Map.Entry<String, Property> entry : propertyMap.entrySet()) {
                if (entry instanceof RefProperty) {
                    recursive(refProperty, fieldName, defMap, reqBodyFieldMap, totalRq);
                }
                Property property1 = entry.getValue();
                ReqBodyField reqBodyField = new ReqBodyField();
                reqBodyField.setRequired(property1.getRequired());
                reqBodyField.setDescription(property1.getDescription());
                reqBodyField.setFieldType(property1.getType());
                reqBodyFieldMap.put(entry.getKey(), reqBodyField);
                totalRq.put(fieldName, reqBodyFieldMap);
            }
        } else {
            ReqBodyField reqBodyField = new ReqBodyField();
            reqBodyField.setRequired(property.getRequired());
            reqBodyField.setDescription(property.getDescription());
            reqBodyField.setFieldType(property.getType());
            reqBodyFieldMap.put(fieldName, reqBodyField);
        }
    }

}


