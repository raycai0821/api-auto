package common.utils;

import io.swagger.models.Path;
import io.swagger.models.Swagger;
import io.swagger.parser.SwaggerParser;

import java.util.Map;

/**
 * @author leifeng.cai
 * @description
 * @time: 2021/6/8 15:32
 **/
public class SwaggerJsonParser {


    public static Map<String, Path> parse(String swaggerDocString) {
        Swagger swagger = new SwaggerParser().parse(swaggerDocString);
        Map<String, Path> map = swagger.getPaths();
        return map;

    }
}
